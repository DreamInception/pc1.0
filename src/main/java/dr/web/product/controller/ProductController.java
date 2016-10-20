package dr.web.product.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dr.web.basis.bean.AssetBean;
import dr.web.basis.bean.User_financeBean;
import dr.web.basis.service.BasisFixed_deposit_productsService;
import dr.web.basis.service.BasisProductService;
import dr.web.basis.service.BasisProduct_detailService;
import dr.web.basis.service.BasisProjectsService;
import dr.web.basis.service.BasisSub_fixed_deposit_productsService;
import dr.web.basis.service.BasisUser_financeService;
import dr.web.common.bean.SessionUser;
import dr.web.common.constant.InterfaceConstant;
import dr.web.common.constant.SystemConstant;
import dr.web.common.utils.HttpUtil;
import dr.web.common.utils.JsonUtil;
import dr.web.product.service.ProductDetailService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/product")
public class ProductController {
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	BasisProduct_detailService basisProduct_detailService;
	
	@Autowired
	BasisProductService basisProductService;
	
	@Autowired
	BasisFixed_deposit_productsService  basisFixed_deposit_productsService;
	
	@Autowired 
	ProductDetailService productDetailService;
	
	@Autowired
	BasisUser_financeService basisUser_financeService;
	@Autowired
	BasisSub_fixed_deposit_productsService basisSub_fixed_deposit_productsService;
	@Autowired
	BasisProjectsService basisProjectsService;
	@Autowired
	InterfaceConstant interfaceConstant;
	@Autowired
	SystemConstant systemConstant;
	
	/**
	 * 产品详情
	 * @return
	 */
	@RequestMapping("/productinfo/{pdtId}")
	public String productInfo(@PathVariable("pdtId") Long pdtId, Model model,HttpSession session){
		Map<String, String> params = new HashMap<>();
		params.putAll(systemConstant.getStaticMap());
		params.put("page", "0");
		params.put("elementsPerPage", "1");
		params.put("returnedFields", "id,name,expectYieldRate,minOrderAmount,durationDesc,"
				+ "totalAmount,expireDtDesc,instruction,yieldInstruction,orders,availableAmount,icon");
		Map<String, Object> productInfo = null;
			params.put("productIds", pdtId.toString());
		String body = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.products, params);
		JSONObject result = JSONObject.fromObject(body);
		if(result != null && !result.get("errCode").toString().equals("OK")){
			model.addAttribute("errMsg", result.get("errMsg").toString());
			return "product/productDetail";
		}
		List<Map<String, Object>> productInfoList = (List<Map<String, Object>>) JSONArray.toCollection(JSONArray.fromObject(result.get("elements")),HashMap.class);
		productInfo = productInfoList.get(0);
		productInfo.put("instruction", productInfo.get("instruction").toString().replace("\r\n\r\n", "<br>"));
		
		model.addAttribute("pdt", productInfo);
		/**
		 * 投资列表
		 */
		List<Map<String, Object>> orderList = (List<Map<String, Object>>) JSONArray.toCollection(JSONArray.fromObject(productInfo.get("orders")),HashMap.class);
		for (Map<String, Object> map : orderList) {
			long dt = Long.valueOf(map.get("dt").toString());
			map.put("dt", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dt));
		}
		model.addAttribute("orders", orderList);
		
		Object object = session.getAttribute(SystemConstant.SESSION_USER);
		if(object != null){
			Map<String, Object> map = new HashMap<>();
			Map<String, Object> user = (Map<String, Object>) object; 
			map.put(User_financeBean.userId, user.get(SessionUser.userId));
			map = (Map<String, Object>) basisUser_financeService.findById(map);
			model.addAttribute("userBalance", map.get("userBalance"));
		}
		
		return "product/productDetail";
	}
	
	//预期收益计算
	@ResponseBody
	@RequestMapping("/profit")
	public Map<String, Object> profit(@RequestParam BigDecimal assetBuyMoney,@RequestParam(required=false) long cycleDay,@RequestParam BigDecimal rate){
		Map<String, Object> map = new HashMap<>();
		BigDecimal profit = null;
			//预计收益
			profit = rate.multiply(assetBuyMoney).multiply(new BigDecimal(cycleDay)).divide((new BigDecimal(36500).multiply(new BigDecimal(1440))), 2, BigDecimal.ROUND_FLOOR);
		map.put("profit", profit);
		return map;
	}
	
	
	@RequestMapping("/buy")
	public String buy(@RequestParam String payPass,BigDecimal orderMoney,long pdtId,Long[] ticketId,int pdtCycle,HttpSession session,Model model){
		StringBuilder selectedTicketIds = new StringBuilder();
		if(ticketId != null){
		for (Long id : ticketId) {
			selectedTicketIds.append(id+",");
		}
			if(selectedTicketIds.toString().endsWith(",")){
				selectedTicketIds.toString().substring(0, selectedTicketIds.toString().length()-1);
			}
		}
		try {
			Map<String, String> params = new HashMap<>();
			Map<String, String> user = (Map<String, String>) session.getAttribute(SystemConstant.SESSION_USER);
			params.put("userId", String.valueOf(user.get(SessionUser.userId)));
			params.putAll(systemConstant.getStaticMap());
			params.put("amount", orderMoney.toString());
			params.put("selectedTicketIds", selectedTicketIds.toString());
			if (pdtId % 2 == 1) {
				params.put("v1ProductId", (pdtId - 1) / 10 + "");
			} else if (pdtId % 2 == 0) {
				params.put("v2SubProductId", (pdtId - 2) / 10 + "");
			}
			String body = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.order, params);
			Map<String, Object> map = JsonUtil.jsonStr2Map(body);
			if (map.get("errCode").toString().equals("OK")) {
				Map<String, Object> orderParam = new HashMap<>();
				orderParam.put(AssetBean.userId, user.get(SessionUser.userId));
				if (pdtId % 2 == 1) {
					orderParam.put("pdtId", (pdtId - 1) / 10);
					orderParam.put("orderId", map.get("v1OrderId").toString());
					orderParam = productDetailService.orderinfo(orderParam);
				} else if (pdtId % 2 == 0) {
					orderParam.put("pdtId", (pdtId - 2) / 10);
					orderParam.put("orderId", map.get("v2AssetId").toString());
					orderParam = productDetailService.v3orderinfo(orderParam);
					Calendar calendar = Calendar.getInstance();
					calendar.add(Calendar.DATE, 1);
					orderParam.put("pdt_start_yield_date", new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
					calendar.add(Calendar.MINUTE, pdtCycle);
					orderParam.put("pdt_expire_date", new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
				}
				model.addAttribute("pdt", orderParam);
				return "product/buySuccess";
			} else {
				model.addAttribute("pdtId", pdtId);
				model.addAttribute("errMsg", map.get("errMsg") == null ? null : map.get("errMsg").toString());
			} 
		} catch (Exception e) {
			e.printStackTrace();
			return "product/buyFailure";
		}
		return "product/buyFailure";
	}
	
	@RequestMapping("/productlist")
	public String productlist(Model model){
		Map<String, String> params = new HashMap<>();
		params.putAll(systemConstant.getStaticMap());
		params.put("page", "0");
		params.put("elementsPerPage", "5");
		params.put("returnedFields", "name,expectYieldRate,statusCode,durationDesc,minOrderAmount,id,icon");
		String body = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.products, params);
		List<Map<String, Object>> products = null;
		if(StringUtils.hasText(body)){
			JSONArray fromObject = JSONArray.fromObject(JsonUtil.jsonStr2Map(body).get("elements"));
			products  = (List<Map<String, Object>>) JSONArray.toCollection(fromObject);
		}
		if(products!=null && products.size()>0){
			model.addAttribute("page", products);
		}
		int pageCount = Integer.valueOf(JsonUtil.jsonStr2Map(body).get("totalPages").toString());
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("pageNum", 1);
		return "product/index";
		
	}
	
	@RequestMapping("/refresh")
	public String refresh(Model model,@RequestParam(value = "pageNum", required = false) Integer pageNum){
		Map<String, String> params = new HashMap<>();
		params.putAll(systemConstant.getStaticMap());
		params.put("page", String.valueOf(pageNum-1));
		params.put("elementsPerPage", "5");
		params.put("returnedFields", "name,expectYieldRate,statusCode,durationDesc,minOrderAmount,id,icon");
		String body = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.products, params);
		List<Map<String, Object>> products = null;
		if(StringUtils.hasText(body)){
			JSONArray fromObject = JSONArray.fromObject(JsonUtil.jsonStr2Map(body).get("elements"));
			products  = (List<Map<String, Object>>) JSONArray.toCollection(fromObject);
		}
		int pageCount = Integer.valueOf(JsonUtil.jsonStr2Map(body).get("totalPages").toString());
		int page = 1;// 当前页数
		if (pageNum != null) {
			if (pageNum > pageCount && pageCount != 0) {
				page = pageCount;
			} else if (pageNum < 0) {
				page = 1;
			} else {
				page = pageNum;
			}
		}

		if(products!=null && products.size()>0){
			model.addAttribute("page", products);
		}
		model.addAttribute("pageNum", page);
		model.addAttribute("pageCount", pageCount);
		return "product/refresh";
		
	}
	/**
	 * 交易密码是否正确
	 */
	@ResponseBody
	@RequestMapping("/validatePass")
	public Map<String, Object> validatePass(@RequestParam(required=false) String pass,HttpSession session){
		Map<String, String> user = (Map<String, String>) session.getAttribute(SystemConstant.SESSION_USER);
		Map<String, String> valiMap = new HashMap<>();
		valiMap.put("pwd", pass);
		valiMap.put("userId", String.valueOf(user.get(SessionUser.userId)));
		valiMap.put("loginOrTrade", "false");
		valiMap.putAll(systemConstant.getStaticMap());
		String body = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.checkPwd, valiMap);
		Map<String, Object> jsonStr2Map = JsonUtil.jsonStr2Map(body);
		if("OK".equals(jsonStr2Map.get("errCode"))){
			jsonStr2Map.put("msg", jsonStr2Map.get("ct").toString());
		}
		return jsonStr2Map;
	}
}

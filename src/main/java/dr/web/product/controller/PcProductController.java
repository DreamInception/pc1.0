package dr.web.product.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dr.web.basis.bean.ProductBean;
import dr.web.basis.bean.ProjectsBean;
import dr.web.basis.bean.Sub_fixed_deposit_productsBean;
import dr.web.basis.service.BasisProductService;
import dr.web.basis.service.BasisProduct_detailService;
import dr.web.basis.service.BasisProjectsService;
import dr.web.basis.service.BasisSub_fixed_deposit_productsService;
import dr.web.common.bean.SessionUser;
import dr.web.common.constant.InterfaceConstant;
import dr.web.common.constant.SystemConstant;
import dr.web.common.utils.HttpUtil;
import dr.web.common.utils.JsonUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/pcclient/product")
public class PcProductController {
	@Autowired
	BasisProductService basisProductService;
	@Autowired
	BasisSub_fixed_deposit_productsService basisSub_fixed_deposit_productsService;
	@Autowired
	BasisProjectsService basisProjectsService;
	@Autowired
	BasisProduct_detailService basisProduct_detailService;
	@Autowired
	InterfaceConstant interfaceConstant;
	@Autowired
	SystemConstant systemConstant;

	/**
	 * 购买
	 * 
	 * @throws ParseException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/tobuy")
	public String tobuy(@RequestParam long cycleDay, @RequestParam BigDecimal yieldRate, @RequestParam long pdtId,
			@RequestParam BigDecimal assetBuyMoney, Model model, HttpSession session) throws ParseException {
		Map<String, Object> params = new HashMap<>();
		params.put(ProductBean.pdtId, pdtId);
		Map<String, Object> productInfo = new HashMap<>();
		Map<String, String> paramPdt = new HashMap<>();
		paramPdt.put("productIds", pdtId + "");
		paramPdt.putAll(systemConstant.getStaticMap());
		paramPdt.put("page", "0");
		paramPdt.put("elementsPerPage", "1");
		String product = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.products, paramPdt);
		JSONObject result = JSONObject.fromObject(product);
		if (result != null && !result.get("errCode").toString().equals("OK")) {
			model.addAttribute("errMsg", result.get("errMsg").toString());
			return "product/productDetail";
		}
		List<Map<String, Object>> productInfoList = (List<Map<String, Object>>) JSONArray
				.toCollection(JSONArray.fromObject(result.get("elements")), HashMap.class);
		productInfo = productInfoList.get(0);

		// 预计收益
		BigDecimal profit = yieldRate.multiply(assetBuyMoney).multiply(new BigDecimal(cycleDay))
				.divide((new BigDecimal(36500).multiply(new BigDecimal(1440))), 2, BigDecimal.ROUND_FLOOR);
		/**
		 * 加息券列表
		 */
		if (pdtId % 2 == 1) {
			Map<String, Object> map = (Map<String, Object>) session.getAttribute(SystemConstant.SESSION_USER);
			String body = HttpUtil
					.restHttpGet(interfaceConstant.getTicket_list() + map.get(SessionUser.userId) + "/0/1000");
			System.out.println("用户加息券接口返回信息" + body);
			map = JsonUtil.jsonStr2Map(body);
			if ((boolean) map.get("success")) {
				List<Map<String, Object>> tickets = new ArrayList<>();
				List<Map<String, Object>> list = (List<Map<String, Object>>) JSONArray
						.toCollection(JSONArray.fromObject(map.get("content")), HashMap.class);
				for (Map<String, Object> map2 : list) {
					if ((int) map2.get("state") == 0
							&& Long.valueOf(map2.get("expireDate").toString()) > new Date().getTime()) {
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						Long time = Long.valueOf(map2.get("expireDate").toString());
						String d = format.format(time);
						Date date = format.parse(d);
						map2.put("expireDate", date);
						if ((int) map2.get("isSpecify") == 0) {
							tickets.add(map2);
						} else {
							Long[] pdtIds = (Long[]) map2.get("pdtIdArr");
							for (long pdtid : pdtIds) {
								if (pdtid == pdtId) {
									tickets.add(map2);
								}

							}
						}
					}
				}

				model.addAttribute("list", tickets);
			}
		}
		// 合同id
		List<Map<String, Object>> pro = null;
		Map<String, Object> contractParam = new HashMap<>();
		if (pdtId % 2 == 1) {
			long pdtid = (pdtId - 1) / 10;
			contractParam.put(ProductBean.pdtId, pdtid);
			pro = (List<Map<String, Object>>) basisProductService.findAllList(params);
			List<Map<String, Object>> findAllList = (List<Map<String, Object>>) basisProduct_detailService
					.findAllList(contractParam);
			model.addAttribute("pdtDetail",
					(findAllList != null && findAllList.size() > 0) ? null : findAllList.get(0));
		} else {
			long pdtid = (pdtId - 2) / 10;
			contractParam.put(Sub_fixed_deposit_productsBean.id, pdtid);
			pro = (List<Map<String, Object>>) basisSub_fixed_deposit_productsService.findAllList(contractParam);
			contractParam.put(ProjectsBean.id, pro.get(0).get(Sub_fixed_deposit_productsBean.projectId));
			contractParam.remove(ProductBean.pdtId);
			pro = (List<Map<String, Object>>) basisProjectsService.findAllList(contractParam);
		}

		model.addAttribute("contractId",
				(pro != null && pro.size() > 0) ? pro.get(0).get(ProjectsBean.contractId) : "1");
		model.addAttribute("profit", profit);
		model.addAttribute("money", assetBuyMoney);
		model.addAttribute("pdt", productInfo);
		return "product/viewOrder";
	}
}

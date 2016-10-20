package dr.web.common.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dr.web.basis.bean.Sub_fixed_deposit_productsBean;
import dr.web.basis.bean.System_configBean;
import dr.web.basis.bean.Tiyan_planBean;
import dr.web.basis.bean.Tiyan_plan_prod_relatedBean;
import dr.web.basis.service.BasisContractService;
import dr.web.basis.service.BasisFixed_deposit_productsService;
import dr.web.basis.service.BasisProductService;
import dr.web.basis.service.BasisProduct_detailService;
import dr.web.basis.service.BasisSub_fixed_deposit_productsService;
import dr.web.basis.service.BasisSystem_configService;
import dr.web.basis.service.BasisTiyan_planService;
import dr.web.basis.service.BasisTiyan_plan_prod_relatedService;
import dr.web.common.constant.InterfaceConstant;
import dr.web.common.constant.SystemConstant;
import dr.web.common.utils.HttpUtil;
import dr.web.company.bo.CompanyBo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * @包名 :dr.web.common.controller
 * @文件名 :IndexController.java TODO 类作用：跳转首页
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年4月19日 下午2:35:47
 * @版本号 :v0.0.01
 */
@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	BasisProductService basisProductService;

	@Autowired
	BasisProduct_detailService basisProduct_detailService;

	@Autowired
	BasisSystem_configService basisSystem_configService;

	@Autowired
	BasisFixed_deposit_productsService basisFixed_deposit_productsService;
	@Autowired
	BasisContractService contractService;
	@Autowired
	BasisSub_fixed_deposit_productsService basisSub_fixed_deposit_productsService;
	@Autowired
	BasisTiyan_planService basisTiyan_planService;
	@Autowired
	BasisTiyan_plan_prod_relatedService basisTiyan_plan_prod_relatedService;
	@Autowired
	InterfaceConstant interfaceConstant;
	@Autowired
	SystemConstant systemConstant;

	/**
	 * 
	 * TODO 方法作用：跳转首页
	 * @param model
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月19日 下午4:05:26
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/")
	public String index(Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put(System_configBean.configName, "new_exclusive");
		List<Map<String, Object>> list = (List<Map<String, Object>>) basisSystem_configService.findAllList(map);
		if (list != null && list.size() > 0) {
			Map<String, Object> sysConfig = list.get(0);
			String configValue = sysConfig.get("configValue").toString();
			List<CompanyBo> configList = (List<CompanyBo>) JSONArray.toCollection(JSONArray.fromObject(configValue),
					CompanyBo.class);
			List<Map<String, Object>> pdtList = new ArrayList<>();
			Map<String, String> params = new HashMap<>();
			params.putAll(systemConstant.getStaticMap());
			params.put("page", "0");
			params.put("elementsPerPage", "20");
			params.put("returnedFields", "id,name,expectYieldRate,minOrderAmount,icon");
			for (CompanyBo bean : configList) {
				int source = bean.getSource();
				if (source == 1) {
					String pdtIdStr = bean.getPdtIds();
					String[] pdtIds = pdtIdStr.split(",");
					StringBuilder sb = new StringBuilder();
					for (String id : pdtIds) {
						sb.append(id + "1,");
					}
					String id = "";
					if (sb.toString().endsWith(",")) {
						id = sb.toString().substring(0, sb.toString().length() - 1);
					}
					params.put("productIds", id);
					String body = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.products, params);
					JSONObject result = JSONObject.fromObject(body);
					if (result != null && !result.get("errCode").toString().equals("OK")) {
						model.addAttribute("errMsg", result.get("errMsg").toString());
						return "redirect:product/productlist";
					}
					List<Map<String, Object>> productInfoList = (List<Map<String, Object>>) JSONArray
							.toCollection(JSONArray.fromObject(result.get("elements")), HashMap.class);
					for (Map<String, Object> pdt : productInfoList) {
						Map<String, Object> pdtPar = new HashMap<>();
						pdtPar.put(Tiyan_plan_prod_relatedBean.pdtId,
								((Long.valueOf(pdt.get("id").toString()) - 1) / 10));
						// pdtPar.put(Tiyan_plan_prod_relatedBean.rtSource, 0);
						List<Map<String, Object>> findAllList = (List<Map<String, Object>>) basisTiyan_plan_prod_relatedService
								.findAllList(pdtPar);
						List<Map<String, Object>> findMap = null;
						int i = 1;
						for (Map<String, Object> findObj : findAllList) {
							pdtPar.clear();
							pdtPar.put(Tiyan_planBean.planId, findObj.get("planId"));
							findMap = (List<Map<String, Object>>) basisTiyan_planService.findAllList(pdtPar);
							if (findMap != null && findMap.size() > 0) {
								pdt.put("plan" + i,
										(findMap.get(0).get("planIcon") == null
												|| findMap.get(0).get("planIcon").toString().equals("")) ? null
														: findMap.get(0).get("planIcon"));
							}
							i++;
						}

					}
					pdtList.addAll(productInfoList);
				} else if (source == 2) {
					String[] ids = bean.getPdtIds().split(",");
					StringBuilder sb = new StringBuilder();
					Map<String, Object> m = new HashMap<>();
					for (String id : ids) {
						m.put(Sub_fixed_deposit_productsBean.productId, id);
						m.put(Sub_fixed_deposit_productsBean.soldOut, "false");
						List<Map<String, Object>> findAllList = (List<Map<String, Object>>) basisSub_fixed_deposit_productsService
								.findAllList(m);
						if (findAllList == null || findAllList.size() < 1) {
							continue;
						}
						String subId = String.valueOf(findAllList.get(0).get(Sub_fixed_deposit_productsBean.id));
						sb.append(subId).append("2,");
					}
					if (sb.toString().endsWith(",")) {
						sb.toString().substring(0, sb.toString().length() - 1);
					}
					params.put("productIds", sb.toString());
					String body = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.products, params);
					JSONObject result = JSONObject.fromObject(body);
					if (result != null && !result.get("errCode").toString().equals("OK")) {
						model.addAttribute("errMsg", result.get("errMsg").toString());
						return "product/index";
					}
					List<Map<String, Object>> productInfoList = (List<Map<String, Object>>) JSONArray
							.toCollection(JSONArray.fromObject(result.get("elements")), HashMap.class);
					for (Map<String, Object> pdt : productInfoList) {
						Map<String, Object> pdtPar = new HashMap<>();
						pdtPar.put(Tiyan_plan_prod_relatedBean.pdtId,
								((Long.valueOf(pdt.get("id").toString()) - 2) / 10));
						pdtPar.put(Tiyan_plan_prod_relatedBean.rtSource, 1);
						List<Map<String, Object>> findAllList = (List<Map<String, Object>>) basisTiyan_plan_prod_relatedService
								.findAllList(pdtPar);
						List<Map<String, Object>> findMap = null;
						int i = 1;
						for (Map<String, Object> findObj : findAllList) {
							pdtPar.put(Tiyan_planBean.planId, findObj.get("planId"));
							pdtPar.remove(Tiyan_plan_prod_relatedBean.pdtId);
							pdtPar.remove(Tiyan_plan_prod_relatedBean.rtSource);
							findMap = (List<Map<String, Object>>) basisTiyan_planService.findAllList(pdtPar);
							if (findMap != null && findMap.size() > 0) {
								pdt.put("plan" + i,
										(findMap.get(0).get("planIcon") == null
												|| findMap.get(0).get("planIcon").toString().equals("")) ? null
														: findMap.get(0).get("planIcon"));
							}
							i++;
						}

					}
					pdtList.addAll(productInfoList);
				}

			}
			model.addAttribute("pdtList", pdtList);
		}
		/**
		 * 首页轮播图片获取
		 */
		Map<String, Object> imgParam = new HashMap<>();
		imgParam.put(System_configBean.configName, "pc_home_img");
		List<Map<String, Object>> imgList = (List<Map<String, Object>>) basisSystem_configService.findAllList(imgParam);
		if (imgList.size() > 0) {
			String imgString = imgList.get(0).get("configValue").toString();
			List<CompanyBo> urlList = (List<CompanyBo>) JSONArray.toCollection(JSONArray.fromObject(imgString),
					CompanyBo.class);
			model.addAttribute("urlList", urlList);
		}

		return "company/index";
	}
}

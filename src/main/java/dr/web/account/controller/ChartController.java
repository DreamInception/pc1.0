package dr.web.account.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dr.web.account.service.ChartService;
import dr.web.basis.bean.UserBean;
import dr.web.basis.service.BasisUserService;
import dr.web.common.constant.MessageConstant;
import dr.web.common.constant.SystemConstant;
import dr.web.common.utils.JsonMessage;

/**
 * 
 * @包名 :dr.web.account.controller
 * @文件名 :ChartController.java TODO 类作用：图表数据类
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年3月31日 下午4:06:43
 * @版本号 :v0.0.01
 */
@Controller
@RequestMapping("pcclient/chart")
public class ChartController {
	private static Logger logger = LoggerFactory.getLogger(ChartController.class);

	@Autowired
	ChartService chartService;
	@Autowired
	BasisUserService basisUserService;

	/**
	 * 
	 * TODO 方法作用：我的资产图表-资产
	 * 
	 * @param request
	 * @param session
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月31日 下午3:35:34
	 */
	@RequestMapping(value = "yieldChart")
	@ResponseBody
	public JsonMessage yieldChart(HttpServletRequest request, HttpSession session) {
		JsonMessage jsonMessage = new JsonMessage(MessageConstant.CODE_0010);
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));

		// 资产前八天的收益
		List<?> yield = chartService.assetYieldLog(session.getAttribute(SystemConstant.USER_ID).toString());
		logger.info("资产前八天的收益yield:{}", yield);
		jsonMessage.setRows(yield);
		return jsonMessage;
	}

	/**
	 * 
	 * TODO 方法作用：零钱收益
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月16日 下午9:01:00
	 */
	@RequestMapping(value = "assetChart")
	@ResponseBody
	public JsonMessage assetChart(HttpServletRequest request, HttpSession session) {
		JsonMessage jsonMessage = new JsonMessage(MessageConstant.CODE_0010);

		// 零钱包前八天的收益
		List<?> yield = chartService.sinaYieldLog(session.getAttribute(SystemConstant.USER_ID).toString());
		logger.info("零钱包前八天的收益yield:{}", yield);
		jsonMessage.setRows(yield);
		return jsonMessage;
	}

	/**
	 * 
	 * TODO 方法作用：零钱包与资产前八天收益
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月17日 上午9:37:37
	 */
	@RequestMapping(value = "balanceChart")
	@ResponseBody
	public JsonMessage balanceChart(HttpServletRequest request, HttpSession session) {
		JsonMessage jsonMessage = new JsonMessage(MessageConstant.CODE_0010);
		// 资产前八天的收益
		List<?> yield = chartService.sinaYieldLog(session.getAttribute(SystemConstant.USER_ID).toString());
		// 零钱包前八天的收益
		List<?> asset = chartService.assetYieldLog(session.getAttribute(SystemConstant.USER_ID).toString());
		List<Object> result = new ArrayList<>();
		for (int i = 0; i < yield.size(); i++) {
			Double yieldD = Double.parseDouble(yield.get(i).toString());
			Double assetD = Double.parseDouble(asset.get(i).toString());
			Double balance = yieldD + assetD;
			result.add(balance);
		}
		logger.info("资产前八天的收益result:{}", result);
		jsonMessage.setRows(result);
		return jsonMessage;
	}

	/**
	 * 
	 * TODO 方法作用：产品合同
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月12日 下午1:42:33
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "financeContract")
	public String financeContract(HttpServletRequest request, HttpSession session,
			@RequestParam("productId") Integer productId, Model model) {
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);
		user.put("productId", productId);
		String contract = chartService.financeContract(user);
		model.addAttribute("txt", contract);
		return "company/contract";
	}
}

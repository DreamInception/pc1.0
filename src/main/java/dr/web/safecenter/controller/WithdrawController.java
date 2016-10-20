package dr.web.safecenter.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dr.web.basis.bean.AreasBean;
import dr.web.basis.bean.UserBean;
import dr.web.basis.service.BasisAreasService;
import dr.web.basis.service.BasisBankService;
import dr.web.basis.service.BasisUserService;
import dr.web.basis.service.BasisUser_financeService;
import dr.web.common.constant.MessageConstant;
import dr.web.common.constant.SystemConstant;
import dr.web.common.utils.JsonMessage;
import dr.web.safecenter.service.WithdrawService;

/**
 * 
 * @包名 :dr.web.safecenter.controller
 * @文件名 :WithdrawController.java TODO 类作用：提现
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年3月25日 下午3:50:08
 * @版本号 :v0.0.01
 */
@Controller
@RequestMapping("pcclient/withdraw")
public class WithdrawController {

	@Autowired
	WithdrawService withdrawService;

	@Autowired
	BasisAreasService basisAreasService;

	@Autowired
	BasisBankService basisBankService;

	@Autowired
	BasisUserService basisUserService;

	@Autowired
	BasisUser_financeService basisUser_financeService;
	@Autowired
	SystemConstant systemConstant;

	/**
	 * 
	 * TODO 方法作用：提现
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月25日 下午4:06:23
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "withdraw")
	@ResponseBody
	public JsonMessage withdraw(HttpServletRequest request, HttpSession session) {
		JsonMessage jsonMessage = new JsonMessage(MessageConstant.CODE_0010);
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);

		if (request.getParameter("amount") != "" && request.getParameter("tradePwd") != "") {
			Map<String, String> param = new HashMap<String, String>();
			param.put(UserBean.userId, user.get(UserBean.userId).toString());
			param.put("amount", request.getParameter("amount"));
			param.put("tradePwd", request.getParameter("tradePwd"));
			param.putAll(systemConstant.getStaticMap());
			String result = withdrawService.withdraw(param);
			if (!result.equals("OK")) {
				jsonMessage.setErrMsg(result);
			}
		} else {
			jsonMessage.setErrMsg(MessageConstant.CODE_0015);
		}
		return jsonMessage;
	}

	/**
	 * 
	 * TODO 方法作用：换绑步骤二——换绑页面
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月27日 上午11:24:22
	 */
	@RequestMapping(value = "exchangeBindPage2")
	public ModelAndView exchangeBindPage2(HttpServletRequest request, HttpSession session, Map<String, Object> param) {
		ModelAndView mv = new ModelAndView();
		List<?> bankList = basisBankService.findAllList(param);
		mv.addObject("bankList", bankList);
		mv.setViewName("safeCenter/exchangeBind-Step2");
		return mv;
	}

	/**
	 * 
	 * TODO 方法作用：换绑银行卡
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月27日 下午2:41:53
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "exchangeBind")
	@ResponseBody
	public JsonMessage exchangeBind(HttpServletRequest request, HttpSession session) {
		// 获取ajax数据
		String bankCardRealName = request.getParameter("bankCardRealName");
		String bankCode = request.getParameter("bankCode");
		String bankCardNumber = request.getParameter("bankCardNumber");
		String bankCardReservedPhone = request.getParameter("bankCardReservedPhone");
		String bankCardCity = request.getParameter("bankCardCity");
		// 获取开户行城市中文名
		Map<String, Object> areaMap = new HashMap<String, Object>();
		areaMap.put(AreasBean.areaId, bankCardCity);
		Map<String, Object> cityName = (Map<String, Object>) basisAreasService.findById(areaMap);
		bankCardCity = cityName.get(AreasBean.areaName).toString();

		JsonMessage jsonMessage = new JsonMessage(MessageConstant.CODE_0010);
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);

		Map<String, String> param = new HashMap<String, String>();
		param.put(UserBean.userId, user.get(UserBean.userId).toString());
		param.put("realName", bankCardRealName);
		param.put("idCardNumber", user.get(UserBean.userCert_no).toString());
		param.put("bankCode", bankCode);
		param.put("bankCardNumber", bankCardNumber);
		param.put("bankCardReservedPhone", bankCardReservedPhone);
		param.put("bankCardCity", bankCardCity);
		param.putAll(systemConstant.getStaticMap());

		Map<String, Object> resultMap = withdrawService.exchange(param, user);
		if (resultMap.get("errCode").equals("OK")) {
			List<Object> list = new ArrayList<Object>();
			list.add(resultMap.get("ticket"));
			jsonMessage.setRows(list);
		} else {
			jsonMessage.setErrMsg(resultMap.get(SystemConstant.MESSAGE).toString());
		}
		return jsonMessage;
	}

	/**
	 * 
	 * TODO 方法作用：绑卡成功
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月8日 下午6:09:23
	 */
	@RequestMapping(value = "bindCardSuccess")
	public String bindCardSuccess() {
		return "safeCenter/bindCardSuccess";
	}

	/**
	 * 
	 * TODO 方法作用：绑卡失败
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月8日 下午6:11:01
	 */
	@RequestMapping(value = "bindCardFail")
	public String bindCardFail(@RequestParam("msg") String msg, Model model) {
		model.addAttribute(SystemConstant.MESSAGE, msg);
		return "safeCenter/bindCardFail";
	}
}

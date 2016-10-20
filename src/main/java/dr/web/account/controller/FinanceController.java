package dr.web.account.controller;

import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dr.web.account.service.FinanceService;
import dr.web.basis.bean.BankBean;
import dr.web.basis.bean.Sys_info_push_logBean;
import dr.web.basis.bean.UserBean;
import dr.web.basis.bean.User_financeBean;
import dr.web.basis.service.BasisBankService;
import dr.web.basis.service.BasisSys_info_push_logService;
import dr.web.basis.service.BasisTransaction_limitService;
import dr.web.basis.service.BasisUserService;
import dr.web.basis.service.BasisUser_financeService;
import dr.web.common.constant.MessageConstant;
import dr.web.common.constant.SystemConstant;
import dr.web.common.utils.DrStringUtil;
import dr.web.common.utils.JsonMessage;

/**
 * 
 * @包名 :dr.web.account.controller
 * @文件名 :FinanceController.java TODO 类作用：充值、取现
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年3月27日 下午5:21:59
 * @版本号 :v0.0.01
 */
@Controller
@RequestMapping("pcclient/finance")
public class FinanceController {
	private static Logger logger = LoggerFactory.getLogger(FinanceController.class);
	@Autowired
	BasisBankService basisBankService;

	@Autowired
	FinanceService financeService;

	@Autowired
	BasisUser_financeService basisUser_financeService;

	@Autowired
	BasisTransaction_limitService basisTransaction_limitService;

	@Autowired
	BasisUserService basisUserService;

	@Autowired
	BasisSys_info_push_logService basisSys_info_push_logService;
	@Autowired
	SystemConstant systemConstant;

	/**
	 * 
	 * TODO 方法作用：充值页面
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月27日 下午5:23:55
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "rechargePage")
	public ModelAndView rechargePage(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);

		// 未实名跳转实名认证
		if (!user.containsKey(UserBean.userRealname)
				|| DrStringUtil.isNull(user.get(UserBean.userRealname).toString()) == true) {
			mv.setViewName("redirect:/pcclient/identification/identificationPage");
		} else if (!user.containsKey(UserBean.userPay_password)
				|| DrStringUtil.isNull(user.get(UserBean.userPay_password).toString()) == true) {
			mv.setViewName("redirect:/pcclient/safeCenter/setTransactPage");
		} else if (!user.containsKey(UserBean.userBank_account)
				|| DrStringUtil.isNull(user.get(UserBean.userBank_account).toString()) == true) {
			mv.setViewName("redirect:/pcclient/user/bindCardPage");
		} else {
			mv.addObject(UserBean.userBank_code, user.get(UserBean.userBank_code));
			String userBankAccount = DrStringUtil.procHideNum(user.get(UserBean.userBank_account).toString(), 9, 4);
			mv.addObject(UserBean.userBank_account, userBankAccount);
			mv.addObject(UserBean.userRealname, user.get(UserBean.userRealname));
			Map<String, Object> param = new HashMap<String, Object>();
			List<Map<String, Object>> list = (List<Map<String, Object>>) basisTransaction_limitService
					.findAllList(param);
			mv.addObject("bankList", list);
			// 是否有未读消息
			Map<String, Object> messageMap = new HashMap<String, Object>();
			messageMap.put(Sys_info_push_logBean.userId, session.getAttribute(SystemConstant.USER_ID));
			messageMap.put(Sys_info_push_logBean.isReaded, 0);
			if (basisSys_info_push_logService.count(messageMap) > 0) {
				mv.addObject("isRead", 0);
			} else {
				mv.addObject("isRead", 1);
			}
			mv.setViewName("account/recharge_id");
		}

		return mv;
	}

	/**
	 * 
	 * TODO 方法作用：充值短信
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月27日 下午6:49:35
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "recharge")
	@ResponseBody
	public JsonMessage recharge(HttpServletRequest request, HttpSession session,
			@RequestParam(value = "randImg") String randImg) {
		JsonMessage jsonMessage = new JsonMessage(MessageConstant.CODE_0010);
		String rand = (String) session.getAttribute("rand");
		session.removeAttribute("rand");
		if (rand.equals(randImg.toLowerCase())) {
			Map<String, Object> user = (Map<String, Object>) session.getAttribute(SystemConstant.SESSION_USER);
			Map<String, String> param = new HashMap<String, String>();
			param.put(UserBean.userId, user.get(UserBean.userId).toString());
			param.put("amount", request.getParameter("amount"));
			param.putAll(systemConstant.getStaticMap());
			// 充值
			Map<String, Object> result = financeService.recharge(param);
			if (result.get("errCode").toString().equals("OK")) {
				List resultList = new ArrayList();
				resultList.add(result.get("ticket"));
				jsonMessage.setRows(resultList);
			} else {
				jsonMessage.setErrMsg(result.get("errMsg").toString());
			}
		} else {
			jsonMessage.setErrMsg(MessageConstant.CODE_0006);
		}
		return jsonMessage;
	}

	/**
	 * 
	 * TODO 方法作用：充值验证
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月27日 下午9:34:10
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "rechargeVerify")
	@ResponseBody
	public JsonMessage rechargeVerify(HttpServletRequest request, HttpSession session) {
		JsonMessage jsonMessage = new JsonMessage(MessageConstant.CODE_0010);
		Map<String, Object> user = (Map<String, Object>) session.getAttribute(SystemConstant.SESSION_USER);
		Map<String, String> pwdMap = new HashMap<String, String>();
		pwdMap.put("userId", user.get(UserBean.userId).toString());
		pwdMap.put("pwd", request.getParameter("transactPsw"));
		pwdMap.put("loginOrTrade", "false");
		pwdMap.putAll(systemConstant.getStaticMap());
		Map<String, Object> resultMap = financeService.checkPwd(pwdMap);
		// 交易密码验证
		if (resultMap.get("errCode").equals("OK") && Integer.parseInt(resultMap.get("ct").toString()) < 5) {
			Map<String, String> param = new HashMap<String, String>();
			param.put(UserBean.userId, user.get(UserBean.userId).toString());
			param.put("ticket", request.getParameter("ticket"));
			param.put("smsCode", request.getParameter("smsCode"));
			param.putAll(systemConstant.getStaticMap());
			// 充值校验
			resultMap = financeService.rechargeVerify(param);
			if (!resultMap.get("errCode").toString().equals("OK")) {
				jsonMessage.setErrMsg(resultMap.get("errMsg").toString());
			}
		} else {
			if (resultMap.containsKey("ct") && Integer.parseInt(resultMap.get("ct").toString()) >= 5) {
				jsonMessage.setErrMsg(MessageConstant.CODE_0017);
			} else {
				jsonMessage.setErrMsg(MessageConstant.CODE_0016);
			}
		}

		return jsonMessage;
	}

	/**
	 * 
	 * TODO 方法作用：跳转取现页面（零钱包）
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月27日 下午10:26:06
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "withdrawPage")
	public ModelAndView withdrawPage(HttpServletRequest request, HttpSession session) {
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);

		ModelAndView mv = new ModelAndView();
		// 未实名跳转实名认证
		if (!user.containsKey(UserBean.userRealname)
				|| DrStringUtil.isNull(user.get(UserBean.userRealname).toString()) == true) {
			mv.setViewName("redirect:/pcclient/identification/identificationPage");
		} else if (!user.containsKey(UserBean.userPay_password)
				|| DrStringUtil.isNull(user.get(UserBean.userPay_password).toString()) == true) {
			mv.setViewName("redirect:/pcclient/safeCenter/setTransactPage");
		} else if (!user.containsKey(UserBean.userBank_account)
				|| DrStringUtil.isNull(user.get(UserBean.userBank_account).toString()) == true) {
			mv.setViewName("redirect:/pcclient/user/bindCardPage");
		} else {
			mv.addObject(UserBean.userBank_code, user.get(UserBean.userBank_code));
			String userBankAccount = DrStringUtil.procHideNum(user.get(UserBean.userBank_account).toString(), 9, 4);
			mv.addObject(UserBean.userBank_account, userBankAccount);
			mv.addObject(UserBean.userRealname, user.get(UserBean.userRealname));
			Map<String, Object> param = (Map<String, Object>) basisUser_financeService.findById(user);
			mv.addObject(User_financeBean.userBalance, param.get(User_financeBean.userBalance));
			// 是否有未读消息
			Map<String, Object> messageMap = new HashMap<String, Object>();
			messageMap.put(Sys_info_push_logBean.userId, session.getAttribute(SystemConstant.USER_ID));
			messageMap.put(Sys_info_push_logBean.isReaded, 0);
			if (basisSys_info_push_logService.count(messageMap) > 0) {
				mv.addObject("isRead", 0);
			} else {
				mv.addObject("isRead", 1);
			}
			mv.setViewName("account/withdraw");
		}
		return mv;
	}

	/**
	 * 
	 * TODO 方法作用：银行卡充值页面
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月16日 下午5:07:55
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "bankRechargePage")
	public ModelAndView bankRechargePage(HttpServletRequest request, HttpSession session) {
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);

		ModelAndView mv = new ModelAndView();
		// 银行列表
		Map<String, Object> bankMap = new HashMap<>();
		bankMap.put(BankBean.bankStatus, 1);
		List<Map<String, Object>> bankList = (List<Map<String, Object>>) basisBankService.findAllList(bankMap);
		mv.addObject("bankList", bankList);

		// 用户资金
		Map<String, Object> financeMap = (Map<String, Object>) basisUser_financeService.findById(tempMap);
		BigDecimal userBalance = new BigDecimal(financeMap.get(User_financeBean.userBalance).toString()).setScale(2,
				BigDecimal.ROUND_DOWN);
		mv.addObject("userBalance", userBalance);
		// 是否有未读消息
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put(Sys_info_push_logBean.userId, session.getAttribute(SystemConstant.USER_ID));
		messageMap.put(Sys_info_push_logBean.isReaded, 0);
		if (basisSys_info_push_logService.count(messageMap) > 0) {
			mv.addObject("isRead", 0);
		} else {
			mv.addObject("isRead", 1);
		}
		mv.setViewName("account/recharge_cb");
		return mv;
	}

	/**
	 * 
	 * TODO 方法作用：银行卡大额充值
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月23日 下午4:34:47
	 */
	@RequestMapping(value = "bankCharge")
	@ResponseBody
	public JsonMessage bankCharge(HttpServletRequest request, HttpSession session) {
		JsonMessage jsonMessage = new JsonMessage(MessageConstant.CODE_0010);
		if (request.getParameter("amount").toString() != null
				&& Integer.parseInt(request.getParameter("amount").toString()) > 0) {
			Map<String, String> param = new HashMap<>();
			param.put("userId", session.getAttribute(SystemConstant.USER_ID).toString());
			param.put("amount", request.getParameter("amount"));
			param.put("bankCode", request.getParameter("bankCode"));
			param.put("returnUrl", "http://www.51doro.com/pcclient/safeCenter/safeGuard");
			param.putAll(systemConstant.getStaticMap());
			logger.info("传入数据集param:{}", param);
			Map<String, Object> resultMap = financeService.bankCharge(param);
			if (resultMap.get("errCode").equals("OK")) {
				List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
				resultList.add(resultMap);
				jsonMessage.setRows(resultList);
			} else {
				jsonMessage.setErrMsg(MessageConstant.CODE_0011);
			}
		}
		return jsonMessage;
	}
}

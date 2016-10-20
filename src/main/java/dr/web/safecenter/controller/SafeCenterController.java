package dr.web.safecenter.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dr.web.account.service.AccountService;
import dr.web.basis.bean.Sys_info_push_logBean;
import dr.web.basis.bean.UserBean;
import dr.web.basis.bean.User_financeBean;
import dr.web.basis.bean.User_login_logBean;
import dr.web.basis.service.BasisSys_info_push_logService;
import dr.web.basis.service.BasisUserService;
import dr.web.basis.service.BasisUser_financeService;
import dr.web.common.constant.InterfaceConstant;
import dr.web.common.constant.MessageConstant;
import dr.web.common.constant.SystemConstant;
import dr.web.common.utils.DrStringUtil;
import dr.web.common.utils.GetIpUtil;
import dr.web.common.utils.HttpUtil;
import dr.web.common.utils.JsonMessage;
import dr.web.common.utils.JsonUtil;
import dr.web.common.utils.RegularUtil;

/**
 * 
 * @包名 :dr.web.safecenter.controller
 * @文件名 :SafeCenterController.java TODO 类作用：安全中心
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年4月5日 下午8:59:47
 * @版本号 :v0.0.01
 */
@Controller
@RequestMapping("pcclient/safeCenter")
public class SafeCenterController {

	@Autowired
	BasisUserService basisUserService;

	@Autowired
	BasisUser_financeService basisUser_financeService;

	@Autowired
	AccountService accountService;

	@Autowired
	BasisSys_info_push_logService basisSys_info_push_logService;

	@Autowired
	InterfaceConstant interfaceConstant;
	@Autowired
	SystemConstant systemConstant;

	/**
	 * 
	 * TODO 方法作用：安全设置
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月18日 下午4:59:24
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "safeGuard", method = RequestMethod.GET)
	public ModelAndView safeGuard(HttpServletRequest request, HttpSession session) {
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);
		ModelAndView mv = new ModelAndView();
		// 返回页面需要的信息
		mv.addObject(UserBean.userTelephone, user.get(UserBean.userTelephone));
		mv.addObject(UserBean.userRealname, user.get(UserBean.userRealname));
		// 获取用户ip对应地址，上一次登录时间
		Map<String, Object> loginMap = accountService.getLastLogin(user);
		mv.addObject(User_login_logBean.logLogintime, loginMap.get(User_login_logBean.logLogintime));
		String loginIp = loginMap.get(User_login_logBean.logLogin_ip).toString();
		mv.addObject("loginAddress", loginIp);
		// if (!GetIpUtil.getLoginAddress(loginIp).isEmpty()) {
		// mv.addObject("loginAddress", GetIpUtil.getLoginAddress(loginIp));
		// }
		if (user.containsKey(UserBean.userRealname)
				&& DrStringUtil.isNull(user.get(UserBean.userRealname).toString()) == false) {
			mv.addObject(UserBean.userRealname, user.get(UserBean.userRealname).toString());
		} else {
			mv.addObject(UserBean.userRealname, "不存在");
		}
		if (user.containsKey(UserBean.userPay_password)
				&& DrStringUtil.isNull(user.get(UserBean.userPay_password).toString())) {
			mv.addObject(UserBean.userPay_password, "未设置");
		} else {
			mv.addObject(UserBean.userPay_password, "已设置");
		}
		if (user.get(UserBean.userBank_status).toString() == "false") {
			mv.addObject(UserBean.userBank_status, "未绑定");
		} else {
			String userBankAccount = DrStringUtil.procHideNum(user.get(UserBean.userBank_account).toString(), 9, 4);
			mv.addObject(UserBean.userBank_account, userBankAccount);
		}
		// 是否有未读消息
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put(Sys_info_push_logBean.userId, session.getAttribute(SystemConstant.USER_ID));
		messageMap.put(Sys_info_push_logBean.isReaded, 0);
		if (basisSys_info_push_logService.count(messageMap) > 0) {
			mv.addObject("isRead", 0);
		} else {
			mv.addObject("isRead", 1);
		}
		mv.setViewName("safeCenter/safeGuard");
		return mv;
	}

	/**
	 * 
	 * TODO 方法作用：返回重置密码页面
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月20日 下午12:08:52
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "resetLogin", method = RequestMethod.GET)
	public ModelAndView resetLogin(HttpServletRequest request, HttpSession session) {
		Map<String, Object> user = (Map<String, Object>) session.getAttribute(SystemConstant.SESSION_USER);
		ModelAndView mv = new ModelAndView();
		mv.addObject(UserBean.userTelephone, user.get(UserBean.userTelephone));
		mv.setViewName("safeCenter/resetLoginPsw");
		return mv;
	}

	/**
	 * 
	 * TODO 方法作用：重置登录密码
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月19日 下午12:35:50
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "resetLoginPwd", method = RequestMethod.POST)
	@ResponseBody
	public JsonMessage resetLoginPwd(HttpServletRequest request, HttpSession session) {
		JsonMessage jsonMessage = new JsonMessage(MessageConstant.CODE_0010);
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		String texting = request.getParameter("texting");
		String ticket = request.getParameter("ticket");

		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);

		Map<String, String> params = new HashMap<String, String>();
		params.put("phone", phone);
		params.put("pwd", pwd);
		params.put("smsTicket", ticket);
		params.put("smsCode", texting);
		params.putAll(systemConstant.getStaticMap());
		// map副本
		Map<String, String> copyParams = new HashMap<String, String>();
		copyParams.putAll(params);
		// 测试该手机是否注册公共密码
		copyParams.put("pwd", "7Yb2GHHlw87H6293GH");
		if (phone.isEmpty()) {
			jsonMessage.setErrMsg(MessageConstant.CODE_0002);
		} else {
			Pattern p = Pattern.compile(RegularUtil.TELEPHONE);
			Matcher m = p.matcher(phone);
			// 手机号正则表达是否匹配
			if (m.matches()) {
				// 检测手机号是否账户手机
				if (!user.get(UserBean.userTelephone).equals(phone)) {
					jsonMessage.setErrMsg(MessageConstant.CODE_0009);
				} else {
					// 密码是否为空
					if (pwd.isEmpty()) {
						jsonMessage.setErrMsg(MessageConstant.CODE_0004);
					} else {
						p = Pattern.compile(RegularUtil.PWD);
						Matcher m1 = p.matcher(pwd);
						// 密码正则表达式
						if (m1.matches()) {
							// 短信验证是否正确
							copyParams.put("ticket", ticket);
							copyParams.put("code", texting);
							String result = HttpUtil
									.http(interfaceConstant.getIp() + InterfaceConstant.smsCaptchaVerify, copyParams);
							Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);
							// 判断短信验证码结果是否正确
							if (resultMap.get("errCode").toString().equals("OK") && resultMap.containsKey("phone")) {
								// 短信验证码正确，修改登录密码
								params.put("userId", user.get(UserBean.userId).toString());
								params.put("loginOrTrade", "true");
								result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.setPwd, params);
								resultMap = JsonUtil.jsonStr2Map(result);
								// 修改是否成功
								if (resultMap.get("errCode").toString().equals("OK")) {
									session.removeAttribute(SystemConstant.SESSION_USER);
								}
							} else {
								if (resultMap.containsKey("errMsg")) {
									jsonMessage.setErrMsg(resultMap.get("errMsg").toString());
								} else {
									jsonMessage.setErrMsg(MessageConstant.CODE_0007);
								}
							}
						} else {
							jsonMessage.setErrMsg(MessageConstant.CODE_0003);
						}
					}
				}
			} else {
				jsonMessage.setErrMsg(MessageConstant.CODE_0001);
			}
		}
		return jsonMessage;
	}

	/**
	 * 
	 * TODO 方法作用：修改交易密码页面
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月20日 下午4:26:59
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "resetTransact", method = RequestMethod.GET)
	public String resetTransact(HttpServletRequest request, HttpSession session, Model model) {
		Map<String, Object> user = (Map<String, Object>) session.getAttribute(SystemConstant.SESSION_USER);
		model.addAttribute(UserBean.userTelephone, user.get(UserBean.userTelephone));
		return "safeCenter/resetTransactPsw";
	}

	/**
	 * 
	 * TODO 方法作用：重置交易密码
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月20日 下午4:39:14
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "resetTransactPwd", method = RequestMethod.POST)
	@ResponseBody
	public JsonMessage resetTransactPwd(HttpServletRequest request, HttpSession session) {
		JsonMessage jsonMessage = new JsonMessage(MessageConstant.CODE_0010);
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		String texting = request.getParameter("texting");
		String ticket = request.getParameter("ticket");
		Map<String, Object> user = (Map<String, Object>) session.getAttribute(SystemConstant.SESSION_USER);

		Map<String, String> params = new HashMap<String, String>();
		params.put("phone", phone);
		params.put("pwd", pwd);
		params.put("smsTicket", ticket);
		params.put("smsCode", texting);
		params.putAll(systemConstant.getStaticMap());
		// map副本
		Map<String, String> copyParams = new HashMap<String, String>();
		copyParams.putAll(params);
		// 测试该手机是否注册公共密码
		copyParams.put("pwd", SystemConstant.TESTPWD);
		if (phone.isEmpty()) {
			jsonMessage.setErrMsg(MessageConstant.CODE_0002);
		} else {
			Pattern p = Pattern.compile(RegularUtil.TELEPHONE);
			Matcher m = p.matcher(phone);
			// 手机号正则表达是否匹配
			if (m.matches()) {
				// 检测手机号是否账户手机
				if (!user.get(UserBean.userTelephone).equals(phone)) {
					jsonMessage.setErrMsg(MessageConstant.CODE_0009);
				} else {
					// 密码是否为空
					if (pwd.isEmpty()) {
						jsonMessage.setErrMsg(MessageConstant.CODE_0004);
					} else {
						p = Pattern.compile(RegularUtil.PWD);
						Matcher m1 = p.matcher(pwd);
						// 密码正则表达式
						if (m1.matches()) {
							// 短信验证是否正确
							copyParams.put("ticket", ticket);
							copyParams.put("code", texting);
							String result = HttpUtil
									.http(interfaceConstant.getIp() + InterfaceConstant.smsCaptchaVerify, copyParams);
							Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);
							// 判断短信验证码结果是否正确
							if (resultMap.get("errCode").toString().equals("OK")) {
								// 短信验证码正确，修改交易密码
								params.put("userId", user.get(UserBean.userId).toString());
								params.put("loginOrTrade", "false");
								result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.setPwd, params);
								resultMap = JsonUtil.jsonStr2Map(result);
								// 修改是否成功
								if (resultMap.get("errCode").toString().equals("OK")) {
									jsonMessage.setErrMsg(MessageConstant.CODE_0010);
								} else {
									jsonMessage.setErrMsg(resultMap.get("errMsg").toString());
								}
							} else {
								jsonMessage.setErrMsg(resultMap.get("errMsg").toString());
							}
						} else {
							jsonMessage.setErrMsg(MessageConstant.CODE_0003);
						}
					}
				}
			} else {
				jsonMessage.setErrMsg(MessageConstant.CODE_0001);
			}
		}
		return jsonMessage;
	}

	/**
	 * 
	 * TODO 方法作用：跳转设置交易密码页面
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月22日 下午5:52:23
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "setTransactPage")
	public String setTransactPage(HttpServletRequest request, HttpSession session) {
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);
		// 身份验证三部曲跳转选择
		if (!user.containsKey(UserBean.userRealname)
				|| DrStringUtil.isNull(user.get(UserBean.userRealname).toString()) == true) {
			return "redirect:/pcclient/identification/identificationPage";
		} else if (!user.containsKey(UserBean.userPay_password)
				|| DrStringUtil.isNull(user.get(UserBean.userPay_password).toString()) == true) {
			return "user/setBusinessPsw";
		} else if (!user.containsKey(UserBean.userBank_account)
				|| DrStringUtil.isNull(user.get(UserBean.userBank_account).toString()) == true) {
			return "redirect:/pcclient/user/bindCardPage";
		} else {
			return "redirect:/pcclient/safeCenter/safeGuard";
		}
	}

	/**
	 * 
	 * TODO 方法作用：设置交易密码
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月22日 下午7:54:18
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "setTransactPwd")
	@ResponseBody
	public JsonMessage setTransactPwd(HttpServletRequest request, HttpSession session,
			@RequestParam(value = "pwd") String pwd) {
		JsonMessage jsonMessage = new JsonMessage(MessageConstant.CODE_0010);
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);
		Pattern p = Pattern.compile(RegularUtil.PWD);
		Matcher m1 = p.matcher(pwd);
		// 密码正则表达式
		if (m1.matches()) {
			Map<String, String> param = new HashMap<String, String>();
			// 设置交易密码
			param.put(UserBean.userId, user.get(UserBean.userId).toString());
			param.put("pwd", pwd);
			param.put("smsTicket", "");
			param.put("smsCode", "");
			param.put("loginOrTrade", "false");
			param.putAll(systemConstant.getStaticMap());
			String result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.setPwd, param);
			Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);
			// 修改是否成功
			if (resultMap.get("errCode").toString().equals("OK")) {
				jsonMessage.setErrMsg(MessageConstant.CODE_0010);
			} else {
				jsonMessage.setErrMsg(resultMap.get("errMsg").toString());
			}

		}
		return jsonMessage;
	}

	/**
	 * 
	 * TODO 方法作用：无零钱直接换绑银行卡选择页面
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月25日 下午2:40:10
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "exchangeBindPage")
	public String exchangeBindPage(HttpServletRequest request, HttpSession session) {
		Map<String, Object> user = (Map<String, Object>) session.getAttribute(SystemConstant.SESSION_USER);
		Map<String, Object> financeMap = (Map<String, Object>) basisUser_financeService.findById(user);
		BigDecimal userBalance = (BigDecimal) financeMap.get(User_financeBean.userBalance);
		BigDecimal userFrozen = (BigDecimal) financeMap.get(User_financeBean.userFrozen);
		String url;
		if (userBalance.compareTo(BigDecimal.ZERO) == 0 && userFrozen.compareTo(BigDecimal.ZERO) == 0) {
			url = "redirect:/pcclient/withdraw/exchangeBindPage2";
		} else {
			url = "redirect:/pcclient/safeCenter/exchangeBindPageStep1";
		}
		return url;
	}

	/**
	 * 
	 * TODO 方法作用：换绑步骤一——提现页面
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月1日 下午1:46:30
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "exchangeBindPageStep1")
	public ModelAndView exchangeBindPageStep1(HttpServletRequest request, HttpSession session) {
		Map<String, Object> user = (Map<String, Object>) session.getAttribute(SystemConstant.SESSION_USER);
		ModelAndView mv = new ModelAndView();
		mv.addObject(UserBean.userBank_code, user.get(UserBean.userBank_code).toString());
		mv.addObject(UserBean.userBank_account, user.get(UserBean.userBank_account));
		mv.addObject(UserBean.userRealname, user.get(UserBean.userRealname));
		// 查询用户账户余额
		Map<String, Object> userFinance = (Map<String, Object>) basisUser_financeService.findById(user);
		mv.addObject(User_financeBean.userBalance, userFinance.get(User_financeBean.userBalance));
		mv.addObject(User_financeBean.userFrozen, userFinance.get(User_financeBean.userFrozen));
		mv.setViewName("safeCenter/exchangeBind-Step1");
		return mv;
	}

}

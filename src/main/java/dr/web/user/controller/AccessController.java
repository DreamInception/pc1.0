package dr.web.user.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dr.web.basis.bean.AreasBean;
import dr.web.basis.bean.Dr_userBean;
import dr.web.basis.bean.UserBean;
import dr.web.basis.bean.User_recommendBean;
import dr.web.basis.bean.User_sourceBean;
import dr.web.basis.service.BasisAreasService;
import dr.web.basis.service.BasisBankService;
import dr.web.basis.service.BasisDr_userService;
import dr.web.basis.service.BasisUserService;
import dr.web.basis.service.BasisUser_recommendService;
import dr.web.basis.service.BasisUser_sourceService;
import dr.web.common.constant.InterfaceConstant;
import dr.web.common.constant.MessageConstant;
import dr.web.common.constant.SystemConstant;
import dr.web.common.utils.DateUtil;
import dr.web.common.utils.DrStringUtil;
import dr.web.common.utils.GetIpUtil;
import dr.web.common.utils.HttpUtil;
import dr.web.common.utils.JsonMessage;
import dr.web.common.utils.JsonUtil;
import dr.web.common.utils.RegularUtil;

/**
 * 
 * @包名 :dr.web.user.controller
 * @文件名 :AccessController.java TODO 类作用：帐号操作
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年3月24日 下午8:56:49
 * @版本号 :v0.0.01
 */
@Controller
@RequestMapping("pcclient/user")
public class AccessController {
	private static Logger logger = LoggerFactory.getLogger(AccessController.class);

	@Autowired
	BasisUserService basisUserService;
	@Autowired
	BasisDr_userService basisDr_userService;
	@Autowired
	BasisBankService basisBankService;
	@Autowired
	BasisAreasService basisAreasService;
	@Autowired
	InterfaceConstant interfaceConstant;
	@Autowired
	SystemConstant systemConstant;
	@Autowired
	BasisUser_recommendService basisUser_recommendService;
	@Autowired
	BasisUser_sourceService basisUser_sourceService;
	@Autowired
	BasisDr_userService BasisDr_userService;

	/**
	 * 
	 * TODO 方法作用：登录或注册页面
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月11日 下午6:03:41
	 */
	@RequestMapping(value = "access")
	public String accessPage(@RequestParam(value = "login", required = false) Integer login, Model model) {
		if (login == null) {
			login = 1;
		}
		model.addAttribute("login", login);
		return "user/access";
	}

	/**
	 * 登录跳转我的资产
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public JsonMessage login(@RequestParam(value = "telephone") String telephone,
			@RequestParam(value = "password") String password, @RequestParam(value = "loginRand") String loginRand,
			HttpServletRequest request, HttpSession session) {
		JsonMessage jsonMessage = new JsonMessage(MessageConstant.CODE_0010);
		String rand = (String) session.getAttribute("rand");
		session.removeAttribute("rand");
		if (rand.equals(loginRand.toLowerCase())) {
			if (telephone.isEmpty()) {
				jsonMessage.setErrMsg(MessageConstant.CODE_0002);
			} else if (password.isEmpty()) {
				jsonMessage.setErrMsg(MessageConstant.CODE_0004);
			} else {
				Pattern p = Pattern.compile(RegularUtil.TELEPHONE);
				Matcher m = p.matcher(telephone);
				p = Pattern.compile(RegularUtil.PWD);
				Matcher m1 = p.matcher(password);
				// 手机正则表达是否匹配
				if (m.matches()) {
					// 密码正则表达
					if (m1.matches()) {
						String ip = GetIpUtil.getIpAddress(request);
						// 调用服务器url接口获取json数据
						Map<String, String> params = new HashMap<String, String>();
						params.put("phone", telephone);
						params.put("pwd", password);
						// 存入ip
						params.put("appForwardedFor", ip);
						params.putAll(systemConstant.getStaticMap());
						String result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.loginCheckForPhone,
								params);
						Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);
						if (resultMap.get("errCode").toString().equals("OK")) {
							Map<String, Object> user = new HashMap<String, Object>();
							user.put(UserBean.userId, resultMap.get(UserBean.userId).toString());
							Map<String, Object> userMap = (Map<String, Object>) basisDr_userService.findById(user);
							session.setAttribute(SystemConstant.SESSION_USER, userMap);
							session.setAttribute(SystemConstant.USER_ID, userMap.get(Dr_userBean.userId));
						} else {
							jsonMessage.setErrMsg(resultMap.get("errMsg").toString());
						}
					} else {
						jsonMessage.setErrMsg(MessageConstant.CODE_0003);
					}
				} else {
					jsonMessage.setErrMsg(MessageConstant.CODE_0001);
				}
			}
		} else {
			jsonMessage.setErrMsg(MessageConstant.CODE_0006);
		}
		return jsonMessage;
	}

	/**
	 * 手机注册
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody
	public JsonMessage register(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		JsonMessage jsonMessage = new JsonMessage(MessageConstant.CODE_0010);
		String phone = request.getParameter("telephone");
		String pwd = request.getParameter("password");
		String texting = request.getParameter("texting");
		String ticket = request.getParameter("ticket");
		String recommend = request.getParameter("recommend");
		String source = request.getParameter("source");

		Map<String, String> params = new HashMap<String, String>();
		params.put("phone", phone);
		params.put("pwd", pwd);
		params.putAll(systemConstant.getStaticMap());
		// map副本
		Map<String, String> copyParams = new HashMap<String, String>();
		copyParams.putAll(params);
		// 测试该手机是否注册公共密码
		copyParams.put("pwd", SystemConstant.TESTPWD);
		Pattern p = Pattern.compile(RegularUtil.TELEPHONE);
		Matcher m = p.matcher(phone);
		p = Pattern.compile(RegularUtil.PWD);
		Matcher m1 = p.matcher(pwd);
		// 检验手机号是否注册
		if (phone.isEmpty()) {
			jsonMessage.setErrMsg(MessageConstant.CODE_0002);
		} else {
			if (m.matches()) {
				// 调用服务器url接口获取json数据
				String result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.loginCheckForPhone,
						copyParams);
				Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);
				if (resultMap.get("errCode").toString().equals("OK")) {
					jsonMessage.setErrMsg(MessageConstant.CODE_0005);
					return jsonMessage;
				}
			} else {
				jsonMessage.setErrMsg(MessageConstant.CODE_0001);
				return jsonMessage;
			}
		}
		// 密码是否为空
		if (pwd.isEmpty()) {
			jsonMessage.setErrMsg(MessageConstant.CODE_0004);
		} else {
			// 密码正则表达式
			if (!m1.matches()) {
				jsonMessage.setErrMsg(MessageConstant.CODE_0003);
				return jsonMessage;
			}
		}
		if (texting.isEmpty()) {
			jsonMessage.setErrMsg(MessageConstant.CODE_0008);
		} else {// 短信验证是否正确
			copyParams.put("ticket", ticket);
			copyParams.put("code", texting);
			String result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.smsCaptchaVerify, copyParams);
			Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);
			// 判断短信验证码结果是否正确
			if (resultMap.get("errCode").toString().equals("OK")) {
				// 短信验证码正确，注册
				params.put("smsTicket", ticket);
				params.put("smsCode", texting);
				params.put("loginPwd", pwd);
				result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.createUserByPhone, params);
				resultMap = JsonUtil.jsonStr2Map(result);
				// 注册是否成功
				if (resultMap.get("errCode").toString().equals("OK")) {
					if (!StringUtils.hasText(source)) {
						source = "";
					}
					Map<String, Object> sourceMap = new HashMap<>();
					sourceMap.put(User_sourceBean.userId, resultMap.get(UserBean.userId).toString());
					sourceMap.put(User_sourceBean.sourceFrom, source);
					sourceMap.put(User_sourceBean.clientFrom, "pc");
					basisUser_sourceService.save(sourceMap);
					// 推荐关系
					if (StringUtils.hasText(recommend)) {
						Map<String, Object> param = new HashMap<>();
						param.put(UserBean.userTelephone, recommend);
						List<Map<String, Object>> userList = (List<Map<String, Object>>) basisUserService
								.findAllList(param);
						logger.debug("用户列表userList:{}", userList);
						Map<String, Object> tempMap = new HashMap<>();
						tempMap = userList.get(0);
						// 设置推荐人
						if (DrStringUtil.isNull(tempMap.get(UserBean.userId).toString()) == false
								&& !recommend.equals(phone)) {
							Map<String, Object> user = new HashMap<String, Object>();
							user.put(UserBean.userId, resultMap.get(UserBean.userId).toString());
							user.put(User_recommendBean.recommendId, tempMap.get(UserBean.userId).toString());
							user.put(User_recommendBean.createdDt, DateUtil.nowDate("yyyy-MM-dd"));
							basisUser_recommendService.save(user);
						}
					}
				} else {
					jsonMessage.setErrMsg(resultMap.get("errMsg").toString());
				}
			} else {
				jsonMessage.setErrMsg(resultMap.get("errMsg").toString());
			}
		}
		return jsonMessage;
	}

	/**
	 * 
	 * TODO 方法作用：查询银行列表，跳转绑卡页面(绑卡顺序：实名、交易密码、绑卡)
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月22日 下午4:30:17
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "bindCardPage")
	public ModelAndView bindCardPage(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);

		// 身份验证三部曲跳转选择
		if (!user.containsKey(UserBean.userRealname)
				|| DrStringUtil.isNull(user.get(UserBean.userRealname).toString()) == true) {
			mv.setViewName("redirect:/pcclient/identification/identificationPage");
		} else if (!user.containsKey(UserBean.userPay_password)
				|| DrStringUtil.isNull(user.get(UserBean.userPay_password).toString()) == true) {
			mv.setViewName("redirect:/pcclient/safeCenter/setTransactPage");
		} else if (user.containsKey(UserBean.userBank_status)
				&& user.get(UserBean.userBank_status).toString() == "false") {
			// 银行账户字段为空
			Map<String, Object> param = new HashMap<String, Object>();
			List<?> bankList = basisBankService.findAllList(param);
			mv.addObject("bankList", bankList);
			mv.setViewName("user/bindCard");
		} else {
			mv.setViewName("redirect:/pcclient/safeCenter/safeGuard");
		}
		return mv;
	}

	/**
	 * 
	 * TODO 方法作用：银行发送短信验证，验证完成绑卡成功
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月22日 下午4:35:59
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "bindCard")
	@ResponseBody
	public JsonMessage bindCard(HttpServletRequest request, HttpSession session) {
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);

		JsonMessage jsonMessage = new JsonMessage(MessageConstant.CODE_0010);
		String randImg = request.getParameter("randImg").toString();
		// 声明变量、放入参数
		String rand = (String) session.getAttribute("rand");
		session.removeAttribute("rand");
		if (rand.equals(randImg.toLowerCase())) {
			String bankCardRealName;
			String idCardNumber;
			// 获取ajax数据
			if (request.getParameter("bankCardRealName") != null) {
				bankCardRealName = request.getParameter("bankCardRealName");
			} else {
				bankCardRealName = user.get(UserBean.userRealname).toString();
			}
			if (request.getParameter("idCardNumber") != null) {
				idCardNumber = request.getParameter("idCardNumber");
			} else {
				idCardNumber = user.get(UserBean.userCert_no).toString();
			}
			String bankCode = request.getParameter("bankCode");
			String bankCardNumber = request.getParameter("bankCardNumber");
			String bankCardReservedPhone = request.getParameter("bankCardReservedPhone");
			String bankCardCity = request.getParameter("bankCardCity");
			// 获取开户行城市中文名
			Map<String, Object> areaMap = new HashMap<String, Object>();
			areaMap.put(AreasBean.areaId, bankCardCity);
			Map<String, Object> cityName = (Map<String, Object>) basisAreasService.findById(areaMap);
			bankCardCity = cityName.get(AreasBean.areaName).toString();
			Map<String, String> param = new HashMap<String, String>();
			param.put(UserBean.userId, user.get(UserBean.userId).toString());
			param.put("bankCode", bankCode);
			param.put("bankCardNumber", bankCardNumber);
			param.put("bankCardReservedPhone", bankCardReservedPhone);
			param.put("bankCardCity", bankCardCity);
			param.putAll(systemConstant.getStaticMap());
			Map<String, Object> resultMap = new HashMap<String, Object>();
			String result;
			if (user.containsKey(UserBean.userRealname) && user.get(UserBean.userRealname) != null) {
				// 判断用户第二次输入实名是否相符
				if (!user.get(UserBean.userRealname).toString().equals(bankCardRealName)) {
					jsonMessage.setErrMsg(MessageConstant.CODE_0014);
					return jsonMessage;
				}
			} else {
				// 用于实名认证的copyParam
				Map<String, String> copyParam = new HashMap<String, String>();
				copyParam.putAll(param);
				copyParam.put("realName", bankCardRealName);
				copyParam.put("idCardNumber", idCardNumber);
				// 实名认证
				result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.verifyRealName, copyParam);
				resultMap = JsonUtil.jsonStr2Map(result);
				if (!resultMap.get("errCode").toString().equals("OK")) {
					jsonMessage.setErrMsg(resultMap.get("errMsg").toString());
				}
			}
			// 绑定银行卡
			result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.bindBankCard, param);
			resultMap = JsonUtil.jsonStr2Map(result);
			if (resultMap.get("errCode").toString().equals("OK")) {
				List<Object> ticket = new ArrayList<Object>();
				ticket.add(resultMap.get("ticket"));
				jsonMessage.setRows(ticket);
			} else {
				jsonMessage.setErrMsg(resultMap.get("errMsg").toString());
			}
		} else {
			jsonMessage.setErrMsg(MessageConstant.CODE_0006);
		}
		return jsonMessage;
	}

	/**
	 * 
	 * TODO 方法作用：绑卡结束，验证短信验证码，跳转我的资产
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月24日 下午9:04:17
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "bindOver")
	@ResponseBody
	public JsonMessage bindOver(HttpServletRequest request, HttpSession session,
			@RequestParam(value = "texting") String texting, @RequestParam(value = "ticket") String ticket) {
		// 声明变量、放入参数
		JsonMessage jsonMessage = new JsonMessage(MessageConstant.CODE_0010);
		Map<String, Object> user = (Map<String, Object>) session.getAttribute(SystemConstant.SESSION_USER);
		Map<String, String> param = new HashMap<String, String>();
		param.put(UserBean.userId, user.get(UserBean.userId).toString());
		param.put("ticket", ticket);
		param.put("smsCode", texting);
		param.putAll(systemConstant.getStaticMap());
		String result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.bindBankCardVerify, param);
		Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);
		if (!resultMap.get("errCode").toString().equals("OK")) {
			jsonMessage.setErrMsg(resultMap.get("errMsg").toString());
		}
		return jsonMessage;
	}

	/**
	 * 
	 * TODO 方法作用：跳转重置登录密码页面
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月28日 下午4:14:05
	 */
	@RequestMapping(value = "resetPwd")
	public String resetPwd() {
		return "user/resetPsw";
	}

	/**
	 * 
	 * TODO 方法作用：重置登录密码(未登录)
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月28日 下午4:38:45
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "resetPwdUnlogin", method = RequestMethod.POST)
	@ResponseBody
	public JsonMessage resetPwdUnlogin(HttpServletRequest request, HttpSession session) {
		JsonMessage jsonMessage = new JsonMessage(MessageConstant.CODE_0010);
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		String texting = request.getParameter("texting");
		String ticket = request.getParameter("ticket");
		Map<String, Object> user = new HashMap<String, Object>();
		user.put(UserBean.userTelephone, phone);
		// 查找手机号对应帐号
		List<Map<String, Object>> userList = (List<Map<String, Object>>) basisUserService.findAllList(user);
		user.putAll(userList.get(0));

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
						String result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.smsCaptchaVerify,
								copyParams);
						Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);
						// 判断短信验证码结果是否正确
						if (resultMap.get("errCode").toString().equals("OK")) {
							// 短信验证码正确，修改登录密码
							params.put("userId", user.get(UserBean.userId).toString());
							params.put("loginOrTrade", "true");
							result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.setPwd, params);
							resultMap = JsonUtil.jsonStr2Map(result);
							// 修改是否成功
							if (resultMap.get("errCode").toString().equals("OK")) {
								session.removeAttribute(SystemConstant.SESSION_USER);
								jsonMessage.setErrMsg(MessageConstant.CODE_0010);
							}
						} else {
							jsonMessage.setErrMsg(resultMap.get("errMsg").toString());
						}
					} else {
						jsonMessage.setErrMsg(MessageConstant.CODE_0003);
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
	 * TODO 方法作用：注销
	 * 
	 * @param session
	 * @param res
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月10日 下午5:43:45
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletResponse res) {
		Enumeration<?> attributeNames = session.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			Object name = attributeNames.nextElement();
			session.removeAttribute(String.valueOf(name));
		}
		res.setHeader("Cache-Control", "no-cache");
		res.setHeader("Cache-Control", "no-store");
		res.setDateHeader("Expires", 0);
		res.setHeader("Pragma", "no-cache");
		session.invalidate();
		return "redirect:/company/index";
	}

	/**
	 * 
	 * TODO 方法作用：
	 * 
	 * @param session
	 * @param res
	 * @return
	 * @Author: 郭翔
	 * @Date: 2016年5月18日 下午3:49:19
	 */
	@RequestMapping("/bindSuccess")
	public String bindSuccess(HttpSession session, HttpServletResponse res) {
		return "user/bindCard-Success";
	}
}

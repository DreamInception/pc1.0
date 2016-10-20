package dr.web.account.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dr.web.account.service.AccountService;
import dr.web.account.service.TicketService;
import dr.web.basis.bean.Fixed_deposit_assetsBean;
import dr.web.basis.bean.Fixed_deposit_productsBean;
import dr.web.basis.bean.OrderBean;
import dr.web.basis.bean.ProductBean;
import dr.web.basis.bean.Sina_system_yield_logBean;
import dr.web.basis.bean.Sys_info_push_logBean;
import dr.web.basis.bean.Tiyan_activeBean;
import dr.web.basis.bean.Tiyan_planBean;
import dr.web.basis.bean.Tiyan_plan_relatedBean;
import dr.web.basis.bean.Tiyan_user_recordBean;
import dr.web.basis.bean.UserBean;
import dr.web.basis.bean.User_login_logBean;
import dr.web.basis.service.BasisFixed_deposit_assetsService;
import dr.web.basis.service.BasisFixed_deposit_productsService;
import dr.web.basis.service.BasisOrderService;
import dr.web.basis.service.BasisProductService;
import dr.web.basis.service.BasisSina_system_yield_logService;
import dr.web.basis.service.BasisSys_info_push_logService;
import dr.web.basis.service.BasisTiyan_activeService;
import dr.web.basis.service.BasisTiyan_planService;
import dr.web.basis.service.BasisTiyan_plan_relatedService;
import dr.web.basis.service.BasisTiyan_user_recordService;
import dr.web.basis.service.BasisUserService;
import dr.web.basis.service.BasisUser_financeService;
import dr.web.common.bean.SessionUser;
import dr.web.common.constant.InterfaceConstant;
import dr.web.common.constant.SystemConstant;
import dr.web.common.utils.DateUtil;
import dr.web.common.utils.DrStringUtil;
import dr.web.common.utils.HttpUtil;
import dr.web.common.utils.JsonUtil;

/**
 * @包名 :dr.web.account.controller
 * @文件名 :AccountController.java TODO 类作用：个人中心页面
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年3月17日 下午6:51:30
 * @版本号 :v0.0.01
 */
@Controller
@RequestMapping("pcclient/account")
public class AccountController {
	private static Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	BasisUser_financeService basisUser_financeService;

	@Autowired
	BasisSina_system_yield_logService basisSina_system_yield_logService;
	@Autowired
	BasisTiyan_user_recordService tiyan_user_recordService;
	@Autowired
	BasisTiyan_planService tiyan_planService;
	@Autowired
	BasisTiyan_activeService tiyan_activeService;
	@Autowired
	BasisTiyan_plan_relatedService tiyan_plan_relatedService;
	@Autowired
	AccountService accountService;
	@Autowired
	BasisOrderService orderService;
	@Autowired
	BasisFixed_deposit_assetsService fixed_deposit_assetsService;
	@Autowired
	BasisProductService productService;
	@Autowired
	BasisFixed_deposit_productsService fixed_deposit_productsService;
	@Autowired
	TicketService ticketService;
	@Autowired
	BasisUserService basisUserService;
	@Autowired
	BasisSys_info_push_logService basisSys_info_push_logService;
	@Autowired
	InterfaceConstant interfaceConstant;
	@Autowired
	SystemConstant systemConstant;

	/**
	 * TODO 方法作用：我的资产
	 *
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月17日 下午7:08:16
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "userAsset", method = RequestMethod.GET)
	public ModelAndView userAsset(HttpServletRequest request, HttpSession session) {
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);

		ModelAndView mv = new ModelAndView();
		// 用户信息
		if (user != null) {
			mv.addObject(UserBean.userRealname, user.get(UserBean.userRealname));
			mv.addObject(UserBean.userTelephone, user.get(UserBean.userTelephone));
			// 获取用户ip对应地址，最后登录时间
			Map<String, Object> loginMap = accountService.getLastLogin(user);
			mv.addObject(User_login_logBean.logLogintime, loginMap.get(User_login_logBean.logLogintime));
			String loginIp = loginMap.get(User_login_logBean.logLogin_ip).toString();
			mv.addObject("loginAddress", loginIp);
			// if (!GetIpUtil.getLoginAddress(loginIp).isEmpty()) {
			// mv.addObject("loginAddress", GetIpUtil.getLoginAddress(loginIp));
			// }
			// 设置绑卡参数，用于页面判断绑卡
			mv.addObject("userBankStatus", user.get(UserBean.userBank_status).toString() == "true" ? 1 : 0);
		}
		Map<String, Object> finacneMap = (Map<String, Object>) basisUser_financeService.findById(user);
		// 资金信息
		if (finacneMap != null) {
			mv.addObject("userBalance",
					DrStringUtil.formatNumber(Double.parseDouble(finacneMap.get("userBalance").toString())));
			mv.addObject("userFrozen",
					DrStringUtil.formatNumber(Double.parseDouble(finacneMap.get("userFrozen").toString())));
		}
		// 理财账户、在途资金金额接口
		Map<String, String> param = new HashMap<String, String>();
		param.put(UserBean.userId, user.get(SessionUser.userId).toString());
		param.putAll(systemConstant.getStaticMap());
		String result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.account, param);
		Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);

		if (resultMap.get("errCode").toString().equals("OK")) {
			// 持有资产
			Double a = Double.parseDouble(resultMap.get("totalAssetAmount").toString());
			// 可用余额
			Double b = Double.parseDouble(resultMap.get("availableBalance").toString());
			// 资产总额
			mv.addObject("balance", DrStringUtil.formatNumber(a + b));
			// 在途资金
			mv.addObject("inTransitBalance",
					DrStringUtil.formatNumber(Double.parseDouble(resultMap.get("inTransitBalance").toString())));
			// 理财账户
			mv.addObject("totalAssetAmount",
					DrStringUtil.formatNumber(Double.parseDouble(resultMap.get("totalAssetAmount").toString())));
			// 昨日所有项目收益
			mv.addObject("yesterdayYield",
					DrStringUtil.formatNumber(Double.parseDouble(resultMap.get("yesterdayYield").toString())));
			// 累计所有项目收益
			mv.addObject("totalYield",
					DrStringUtil.formatNumber(Double.parseDouble(resultMap.get("totalYield").toString())));
			// 是否有未读消息
			Map<String, Object> messageMap = new HashMap<String, Object>();
			messageMap.put(Sys_info_push_logBean.userId, session.getAttribute(SystemConstant.USER_ID));
			messageMap.put(Sys_info_push_logBean.isReaded, 0);
			if (basisSys_info_push_logService.count(messageMap) > 0) {
				mv.addObject("isRead", 0);
			} else {
				mv.addObject("isRead", 1);
			}
		} else {
			mv.addObject("msg", resultMap.get("errMsg").toString());
		}
		mv.setViewName("account/userAsset");
		return mv;
	}

	/**
	 * TODO 方法作用：零钱包
	 *
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月17日 下午7:13:54
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "userAccount", method = RequestMethod.GET)
	public ModelAndView userAccount(HttpServletRequest request, HttpSession session,
			@RequestParam(value = "chargeSuccess", required = false) String chargeSuccess,
			@RequestParam(value = "withdrawSuccess", required = false) String withdrawSuccess,
			@RequestParam(value = "pageNum", required = false) Integer pageNum) {
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);

		ModelAndView mv = new ModelAndView();
		// 理财账户、在途资金金额接口
		Map<String, String> param = new HashMap<String, String>();
		param.put(SessionUser.userId, user.get(SessionUser.userId).toString());
		param.putAll(systemConstant.getStaticMap());
		String result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.account, param);
		Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);

		if (resultMap.get("errCode").toString().equals("OK")) {
			// 在途资金
			mv.addObject("inTransitBalance", resultMap.get("inTransitBalance"));
			// 零钱包
			mv.addObject("availableBalance", resultMap.get("availableBalance"));
			// 冻结资金
			mv.addObject("frozenBalance", resultMap.get("frozenBalance"));
			// （零钱包）累计收益
			mv.addObject("totalPurseYield", resultMap.get("totalPurseYield"));
			// （零钱包）昨日收益
			mv.addObject("yesterdayPurseYield", resultMap.get("yesterdayPurseYield"));
			Map<String, Object> dateMap = new HashMap<String, Object>();
			// 前一天时间
			String beforeTime = DateUtil.getSpecifiedDayBefore(DateUtil.nowDate(DateUtil.DEFAULT_DATE_PATTERN));
			dateMap.put(Sina_system_yield_logBean.logDate, beforeTime);
			Map<String, Object> yieldMap = (Map<String, Object>) basisSina_system_yield_logService.findById(dateMap);
			if (yieldMap != null) {
				if (yieldMap.containsKey(Sina_system_yield_logBean.logSina_net_float)
						&& yieldMap.get(Sina_system_yield_logBean.logSina_net_float) != null) {
					// 万份收益
					BigDecimal logSina_net_float = new BigDecimal(
							yieldMap.get(Sina_system_yield_logBean.logSina_net_float).toString())
									.multiply(new BigDecimal(100)).setScale(4, BigDecimal.ROUND_DOWN);
					yieldMap.put(Sina_system_yield_logBean.logSina_net_float, logSina_net_float);
				}
				if (yieldMap.containsKey(Sina_system_yield_logBean.logSina_7days_yield_rate)
						&& yieldMap.get(Sina_system_yield_logBean.logSina_7days_yield_rate) != null) {
					// 七日年化收益率
					BigDecimal logSina_7days_yield_rate = new BigDecimal(
							yieldMap.get(Sina_system_yield_logBean.logSina_7days_yield_rate).toString())
									.multiply(new BigDecimal(100)).setScale(4, BigDecimal.ROUND_DOWN);
					yieldMap.put(Sina_system_yield_logBean.logSina_7days_yield_rate, logSina_7days_yield_rate);
				}
			}
			mv.addObject("yieldMap", yieldMap);
			// 零钱包-交易明细列表
			Map<String, Object> changesMap = new HashMap<String, Object>();
			// 排序规则
			changesMap.put("orderby", "Order By log_createtime DESC");
			changesMap.putAll(param);
			// 查询list以及分页参数
			if (pageNum != null) {
				changesMap.put("pageNum", pageNum);
			}
			changesMap = accountService.smallChange(changesMap);
			logger.info("零钱记录changesMap:{}", changesMap);
			mv.addObject("pageNum", changesMap.get("page"));
			mv.addObject("pageCount", changesMap.get("pageCount"));
			mv.addObject("changesList", changesMap.get("list"));
			// 充值成功或失败判断
			if (null != chargeSuccess) {
				if (chargeSuccess.equals("true")) {
					mv.addObject("chargeSuccess", "true");
				} else {
					mv.addObject("chargeSuccess", "false");
				}
			}
			// 取现成功或失败判断
			if (null != withdrawSuccess) {
				if (withdrawSuccess.equals("true")) {
					mv.addObject("withdrawSuccess", "true");
				} else {
					mv.addObject("withdrawSuccess", "false");
				}
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
		} else {
			mv.addObject("msg", resultMap.get("errMsg").toString());
		}
		mv.setViewName("account/userAccount");
		return mv;
	}

	/**
	 * 
	 * TODO 方法作用：根据筛选条件刷新局部页面
	 * 
	 * @param request
	 * @param session
	 * @param model
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月12日 上午10:23:15
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "refreshAccount")
	public String refreshAccount(HttpServletRequest request, HttpSession session, Model model,
			@RequestParam(value = "pageNum", required = false) Integer pageNum,
			@RequestParam(value = "startTime", required = false) String startTime,
			@RequestParam(value = "endTime", required = false) String endTime) {
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);
		// 零钱包-交易明细列表
		Map<String, Object> changesMap = new HashMap<String, Object>();
		// 排序规则
		changesMap.put("orderby", "Order By log_createtime DESC");
		if (!DrStringUtil.isNull(startTime)) {
			changesMap.put("startTime", DateUtil.StrToDate(startTime));
		}
		if (!DrStringUtil.isNull(endTime)) {
			changesMap.put("endTime", DateUtil.StrToDate(endTime));
		}
		changesMap.put(SessionUser.userId, user.get(SessionUser.userId).toString());
		changesMap.putAll(systemConstant.getStaticMap());
		// 查询list以及分页参数
		if (pageNum != null) {
			changesMap.put("pageNum", pageNum);
		}
		changesMap = accountService.smallChange(changesMap);
		logger.info("零钱记录changesMap:{}", changesMap);

		model.addAttribute("pageNum", changesMap.get("page"));
		model.addAttribute("pageCount", changesMap.get("pageCount"));
		model.addAttribute("changesList", changesMap.get("list"));
		return "account/accountRefresh";
	}

	/**
	 * TODO 方法作用：我的理财
	 *
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月18日 下午2:47:54
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "userFinance", method = RequestMethod.GET)
	public ModelAndView userFinance(HttpServletRequest request, HttpSession session,
			@RequestParam(value = "days", required = false) Integer days,
			@RequestParam(value = "datetime", required = false) String datetime) {
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);
		ModelAndView mv = new ModelAndView();
		// 理财账户、在途资金金额接口
		Map<String, String> param = new HashMap<String, String>();
		param.put(SessionUser.userId, user.get(SessionUser.userId).toString());
		param.putAll(systemConstant.getStaticMap());
		String result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.account, param);
		Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);

		if (resultMap.get("errCode").toString().equals("OK")) {
			// 持有资产
			mv.addObject("totalAssetAmount", resultMap.get("totalAssetAmount"));
			// (持有资产)累计收益
			mv.addObject("totalAssetYield", resultMap.get("totalAssetYield"));
			// (持有资产)昨日收益
			mv.addObject("yesterdayAssetYield", resultMap.get("yesterdayAssetYield"));
			// (持有资产)预计到期收益
			mv.addObject("projectedRepaidAmount", resultMap.get("projectedRepaidAmount"));
			// 资产列表总页数
			int pageCount = accountService.countProductPage(session.getAttribute(SystemConstant.USER_ID).toString(),
					days, datetime);
			if (pageCount == 0) {
				pageCount = 1;
			}
			mv.addObject("pageCount", pageCount);
			int pageNum = 1;
			mv.addObject("pageNum", pageNum);
			List<Map<String, Object>> elements = accountService.getProductList(user.get(SessionUser.userId).toString(),
					days, datetime, pageNum);
			mv.addObject("elements", elements);

			// 是否有未读消息
			Map<String, Object> messageMap = new HashMap<String, Object>();
			messageMap.put(Sys_info_push_logBean.userId, session.getAttribute(SystemConstant.USER_ID));
			messageMap.put(Sys_info_push_logBean.isReaded, 0);
			if (basisSys_info_push_logService.count(messageMap) > 0) {
				mv.addObject("isRead", 0);
			} else {
				mv.addObject("isRead", 1);
			}
		} else {
			mv.addObject("msg", resultMap.get("errMsg").toString());
		}
		mv.setViewName("account/userFinance");
		return mv;
	}

	/**
	 * 
	 * TODO 方法作用：局部刷新我的理财资产列表
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月14日 下午3:18:52
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "refreshFinance")
	public String refreshFinance(HttpServletRequest request, HttpSession session,
			@RequestParam(value = "pageNum", required = false) Integer pageNum,
			@RequestParam(value = "days", required = false) Integer days,
			@RequestParam(value = "datetime", required = false) String datetime, Model model) {
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);
		Map<String, String> param = new HashMap<String, String>();
		param.put(SessionUser.userId, user.get(SessionUser.userId).toString());
		param.putAll(systemConstant.getStaticMap());
		System.out.println("==========================>pageNum:{}"+ pageNum);
		System.out.println("==========================>days:{}"+ days);
		System.out.println("==========================>datetime:{}"+ datetime);
		// 资产列表总页数
		int pageCount = accountService.countProductPage(session.getAttribute(SystemConstant.USER_ID).toString(), days,
				datetime);
		if (pageCount == 0) {
			pageCount = 1;
		}
		model.addAttribute("pageCount", pageCount);
		if (pageNum == null || pageNum <= 0) {
			pageNum = 1;
		} else if (pageNum > pageCount) {
			pageNum = pageCount;
		}
		model.addAttribute("pageNum", pageNum);
		List<Map<String, Object>> elements = accountService.getProductList(user.get(SessionUser.userId).toString(),
				days, datetime, pageNum);
		if (days != null) {
			model.addAttribute("days", days);
		}
		if (!DrStringUtil.isNull(datetime)) {
			model.addAttribute("datetime", datetime);
		}
		model.addAttribute("elements", elements);
		return "account/refreshFinance";
	}

	/**
	 * TODO 方法作用：我的福利（体验金、加息券等）
	 *
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月18日 下午4:37:16
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "userTicket", method = RequestMethod.GET)
	public ModelAndView userTicket(HttpServletRequest request, HttpSession session) {
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);

		Map<String, Object> urParam = new HashMap<>();
		ModelAndView mv = new ModelAndView();
		urParam.put(Tiyan_user_recordBean.userId, user.get(UserBean.userId));
		// 查询年体验金用户列表
		logger.debug("体验金查询条件urParam:{}", urParam);
		List<HashMap<String, Object>> list = (List<HashMap<String, Object>>) tiyan_user_recordService
				.findAllList(urParam);
		if (list != null && list.size() > 0) {
			Map<Boolean, List<HashMap<String, Object>>> urTypeMap = list.stream().collect(
					Collectors.partitioningBy(rcm -> rcm.get("urType") != null && (boolean) rcm.get("urType")));
			List<HashMap<String, Object>> ticketList = urTypeMap.get(true);
			List<HashMap<String, Object>> tiyanList = urTypeMap.get(false);
			if (ticketList != null && ticketList.size() > 0) {
				Predicate<HashMap<String, Object>> predicate = rcm -> rcm.get("urState") != null
						&& (int) rcm.get("urState") != -1 && (int) rcm.get("urState") != 0;
				mv.addObject("ticketCount", ticketList.stream().filter(predicate).count());
				mv.addObject("ticketDayProfit",
						ticketList.stream().filter(predicate)
								.collect(Collectors.summingDouble(rcm -> rcm.get("urDay_profit") == null ? 0D
										: ((BigDecimal) rcm.get("urDay_profit")).doubleValue())));
				mv.addObject("ticketAccProfit",
						ticketList.stream().filter(predicate)
								.collect(Collectors.summingDouble(rcm -> rcm.get("urAccu_profit") == null ? 0D
										: ((BigDecimal) rcm.get("urAccu_profit")).doubleValue())));
				mv.addObject("ticketList", wrapUr(ticketList, 0));
			}
			if (tiyanList != null && tiyanList.size() > 0) {
				Predicate<HashMap<String, Object>> predicate = rcm -> rcm.get("urState") != null
						&& (int) rcm.get("urState") != -1 && (int) rcm.get("urState") != 0;
				mv.addObject("tiyanAmount",
						tiyanList.stream().filter(predicate)
								.collect(Collectors.summingDouble(rcm -> rcm.get("urTiyan_amount") == null ? 0D
										: ((BigDecimal) rcm.get("urTiyan_amount")).doubleValue())));
				mv.addObject("tiyanDayProfit",
						tiyanList.stream().filter(predicate)
								.collect(Collectors.summingDouble(rcm -> rcm.get("urDay_profit") == null ? 0D
										: ((BigDecimal) rcm.get("urDay_profit")).doubleValue())));
				mv.addObject("tiyanAccProfit",
						tiyanList.stream().filter(predicate)
								.collect(Collectors.summingDouble(rcm -> rcm.get("urAccu_profit") == null ? 0D
										: ((BigDecimal) rcm.get("urAccu_profit")).doubleValue())));
				mv.addObject("tiyanList", wrapUr(tiyanList, 0));
			}
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
		mv.setViewName("account/userTicket");
		return mv;
	}

	/**
	 * 
	 * TODO 方法作用：我的福利Tab刷新
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月20日 上午11:00:22
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@RequestMapping(value = "ticketTab", method = RequestMethod.POST)
	public ModelAndView ticketTab(HttpServletRequest request, HttpSession session) {
		String stateStr = request.getParameter("state");
		int state = 0;
		try {
			state = Integer.parseInt(stateStr);
		} catch (Exception e) {
			state = 0;
		}
		Map<String, Object> urParam = new HashMap<>();
		ModelAndView mv = new ModelAndView();
		urParam.put(Tiyan_user_recordBean.userId, session.getAttribute(SystemConstant.USER_ID));
		List<HashMap<String, Object>> list = (List<HashMap<String, Object>>) tiyan_user_recordService
				.findAllList(urParam);
		if (list != null && list.size() > 0) {
			Map<Boolean, List<HashMap<String, Object>>> urTypeMap = list.stream().collect(
					Collectors.partitioningBy(rcm -> rcm.get("urType") != null && (boolean) rcm.get("urType")));
			List<HashMap<String, Object>> ticketList = urTypeMap.get(true);
			List<HashMap<String, Object>> tiyanList = urTypeMap.get(false);
			if (ticketList != null && ticketList.size() > 0) {
				Predicate<HashMap<String, Object>> predicate = rcm -> rcm.get("urState") != null
						&& (int) rcm.get("urState") != -1 && (int) rcm.get("urState") != 0;
				mv.addObject("ticketList", wrapUr(ticketList, state));
			}
			if (tiyanList != null && tiyanList.size() > 0) {
				Predicate<HashMap<String, Object>> predicate = rcm -> rcm.get("urState") != null
						&& (int) rcm.get("urState") != -1 && (int) rcm.get("urState") != 0;
				mv.addObject("tiyanList", wrapUr(tiyanList, state));
			}
		}
		mv.setViewName("account/userTicket_tab");
		return mv;
	}

	/**
	 * 
	 * TODO 方法作用：根据urState查询对应体验金或加息券
	 * 
	 * @param list
	 * @param state
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月19日 下午4:24:22
	 */
	@SuppressWarnings("unchecked")
	private List<HashMap<String, Object>> wrapUr(List<HashMap<String, Object>> list, int state) {
		List<HashMap<String, Object>> result = list.stream()
				.filter(rcm -> rcm.get("urState") != null && (int) rcm.get("urState") == state)
				.collect(Collectors.toList());
		result.forEach(rcm -> {
			Object planIdObj = rcm.get("planId");
			if (planIdObj == null)
				return;
			Long planId = Long.parseLong(planIdObj.toString());
			Map<String, Object> planParam = new HashMap<>();
			planParam.put(Tiyan_planBean.planId, planId);
			HashMap<String, Object> plan = (HashMap<String, Object>) tiyan_planService.findById(planParam);
			Date createDate = (Date) rcm.get("urCreate_time");
			if (createDate != null) {
				rcm.put("validDate", dr.web.utils.date.DateUtil.addDay(createDate, (int) plan.get("planValid_period")));
			}
			Map<String, Object> planRelatedParam = new HashMap<>();
			planRelatedParam.put(Tiyan_plan_relatedBean.planId, plan.get(Tiyan_planBean.planId));
			planRelatedParam.put(Tiyan_plan_relatedBean.relatedType, 2);
			List<HashMap<String, Object>> planRelatedList = (List<HashMap<String, Object>>) tiyan_plan_relatedService
					.findAllList(planRelatedParam);
			if (planRelatedList != null && planRelatedList.size() > 0) {
				HashMap<String, Object> planRelated = planRelatedList.get(0);
				Map<String, Object> activeParam = new HashMap<String, Object>();
				activeParam.put(Tiyan_activeBean.id, planRelated.get(Tiyan_plan_relatedBean.relatedId));
				HashMap<String, Object> active = (HashMap<String, Object>) tiyan_activeService.findById(activeParam);
				if (active != null) {
					rcm.put("activeName", active.get(Tiyan_activeBean.name));
				}
			}
		});
		return result;
	}

	/**
	 * 
	 * TODO 方法作用：福利明细
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月20日 上午11:21:10
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "ticketDetail", method = RequestMethod.GET)
	public ModelAndView ticketDetail(HttpServletRequest request, HttpSession session) {
		Map<String, Object> urParam = new HashMap<>();
		ModelAndView mv = new ModelAndView();
		urParam.put(Tiyan_user_recordBean.userId, session.getAttribute(SystemConstant.USER_ID));
		List<Map<String, Object>> list = (List<Map<String, Object>>) tiyan_user_recordService.findAllList(urParam);
		mv.addObject("list", wrapDetailUr(list, 0, null));
		mv.setViewName("account/ticketDetail");
		return mv;
	}

	/**
	 * 
	 * TODO 方法作用：福利明细局部刷新
	 * 
	 * @param inteval
	 * @param d
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月17日 下午5:23:58
	 */
	@RequestMapping(value = "ticketDetailRefresh")
	public String ticketDetailRefresh(
			@RequestParam(value = "inteval", required = false, defaultValue = "0") Integer inteval,
			@RequestParam(value = "d", required = false) String d, HttpServletRequest request, HttpSession session,
			Model model) {
		Map<String, Object> urParam = new HashMap<>();
		urParam.put(Tiyan_user_recordBean.userId, session.getAttribute(SystemConstant.USER_ID));
		if (inteval != 0) {
			urParam.put("inteval", inteval);
		}
		if (!DrStringUtil.isNull(d)) {
			urParam.put(Tiyan_user_recordBean.urStart_date, d);
		}
		List<Map<String, Object>> list = accountService.ticketDetail(urParam);
		model.addAttribute("list", wrapDetailUr(list, inteval, DateUtil.StrToDate(d)));
		model.addAttribute("inteval", inteval);
		model.addAttribute("d", d);
		return "account/ticketDetail_refresh";
	}

	/**
	 * 
	 * TODO 方法作用：福利明细状态转文字公共方法
	 * 
	 * @param list
	 * @param inteval
	 * @param d
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月20日 上午11:15:21
	 */
	@SuppressWarnings("unchecked")
	private List<Map<String, Object>> wrapDetailUr(List<Map<String, Object>> list, int inteval, Date d) {
		List<Map<String, Object>> result = list.stream().filter(
				rcm -> rcm.get("urState") != null && (int) rcm.get("urState") != -1 && (int) rcm.get("urState") != 4)
				.collect(Collectors.toList());
		Date now = new Date();
		result.forEach(rcm -> {
			if (rcm.get("urType") == null || (boolean) rcm.get("urType") == false) {
				rcm.put("welname", "体验金");

			} else if ((boolean) rcm.get("urType") == true) {
				rcm.put("welname", "加息券");

			}
			Object orderId = rcm.get("orderId");
			HashMap<String, Object> param = new HashMap<String, Object>();
			if (orderId != null) {
				// 判断是老产品还是新产品
				if (rcm.get("rt_source") == null || (byte) rcm.get("rt_source") == 0) {
					param.put(OrderBean.orderId, orderId);
					logger.debug("查询老产品param:{}", param);
					HashMap<String, Object> order = (HashMap<String, Object>) ticketService.findById(param);
					if (order != null) {
						param.clear();
						param.put(ProductBean.pdtId, order.get(OrderBean.pdtId));
						HashMap<String, Object> prod = (HashMap<String, Object>) productService.findById(param);
						if (prod != null) {
							rcm.put("pdtName", prod.get(ProductBean.pdtName));
						}
					}
				} else if ((byte) rcm.get("rt_source") == 1) {
					param.put(Fixed_deposit_assetsBean.id, orderId);
					logger.debug("查询新产品param:{}", param);
					HashMap<String, Object> order = (HashMap<String, Object>) fixed_deposit_assetsService
							.findById(param);
					if (order != null) {
						param.clear();
						param.put(Fixed_deposit_productsBean.id, order.get(Fixed_deposit_assetsBean.productId));
						HashMap<String, Object> prod = (HashMap<String, Object>) fixed_deposit_productsService
								.findById(param);
						if (prod != null) {
							rcm.put("pdtName", prod.get(Fixed_deposit_productsBean.name));
						}
					}
				}
			}
			param.clear();
			param.put(Tiyan_plan_relatedBean.relatedType, 2);
			param.put(Tiyan_plan_relatedBean.planId, rcm.get(Tiyan_planBean.planId));
			List<HashMap<String, Object>> prList = (List<HashMap<String, Object>>) tiyan_plan_relatedService
					.findAllList(param);
			if (prList != null && prList.size() > 0) {
				HashMap<String, Object> pr = prList.get(0);
				param.clear();
				param.put(Tiyan_activeBean.id, pr.get(Tiyan_plan_relatedBean.relatedId));
				HashMap<String, Object> active = (HashMap<String, Object>) tiyan_activeService.findById(param);
				if (active != null) {
					rcm.put("activeName", active.get(Tiyan_activeBean.name));
				}
			}
			Object startDate = rcm.get(Tiyan_user_recordBean.urStart_date);
			Object endDate = rcm.get(Tiyan_user_recordBean.urEnd_date);
			if (startDate != null) {
				Date d1 = (Date) startDate;
				rcm.put("usedDate", d1);
				if (endDate != null) {
					Date d2 = (Date) endDate;
					if (now.after(d2)) {
						rcm.put("leftDay", "/");
					} else {
						rcm.put("leftDay", dr.web.utils.date.DateUtil.getIntervalDays(now, d2));
					}
				}
			} else {
				rcm.put("usedDate", "未使用");
			}
		});
		return result;
	}

	/**
	 * TODO 方法作用：我的消息
	 *
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月18日 下午4:47:18
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "info")
	public ModelAndView info(HttpServletRequest request, HttpSession session,
			@RequestParam(value = "pageNum", required = false) Integer pageNum,
			@RequestParam(value = "isReaded", required = false) String isReaded,
			@RequestParam(value = "type", required = false) String type) {
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);

		ModelAndView mv = new ModelAndView();
		// 查询符合条件的总页数
		Map<String, Object> pageParam = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		// 赋值存页面
		// if (isReaded == null) {
		// isReaded = "2";
		// }
		if (type == null) {
			type = "3";
		}
		// if (null != isReaded) {
		// if (!isReaded.equals("2")) {
		// pageParam.put(Sys_info_push_logBean.isReaded, isReaded);
		// param.put(Sys_info_push_logBean.isReaded, isReaded);
		// }
		// mv.addObject("isReaded", isReaded);
		// }
		if (null != type) {
			if (!type.equals("3")) {
				pageParam.put(Sys_info_push_logBean.type, type);
				param.put(Sys_info_push_logBean.type, type);
			}
			mv.addObject("type", type);
		}
		pageParam.put(Sys_info_push_logBean.userId, user.get(UserBean.userId));
		// 查询消息总页数
		logger.info("筛选条件pageParam:{}" + pageParam);
		int pageCount = accountService.countPage(pageParam);

		if (pageCount == 0) {
			pageCount = 1;
		}
		int page = 1;// 当前页数
		int rows = 6;// 每页多少行
		if (pageNum != null) {
			if (pageNum > pageCount) {
				page = pageCount;
			} else if (pageNum < 0) {
				page = 1;
			} else {
				page = pageNum;
			}
		}

		param.put(Sys_info_push_logBean.userId, user.get(Sys_info_push_logBean.userId));
		param.put(SystemConstant.PAGE_KEY_PAGE, page);
		param.put(SystemConstant.PAGE_KEY_ROW, rows);
		param.put("orderby", "order by create_dt DESC");// 排序规则
		logger.info("筛选条件param:{}" + param);
		List<Map<String, Object>> messageList = accountService.findPageList(param);

		mv.addObject("messageList", messageList);
		mv.addObject("pageNum", page);
		mv.addObject("pageCount", pageCount);
		// 是否有未读消息
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put(Sys_info_push_logBean.userId, session.getAttribute(SystemConstant.USER_ID));
		messageMap.put(Sys_info_push_logBean.isReaded, 0);
		if (basisSys_info_push_logService.count(messageMap) > 0) {
			mv.addObject("isRead", 0);
		} else {
			mv.addObject("isRead", 1);
		}
		mv.setViewName("account/info");
		return mv;
	}

	/**
	 * 
	 * TODO 方法作用：我的消息，局部刷新
	 * 
	 * @param request
	 * @param session
	 * @param pageNum
	 * @param isReaded
	 * @param type
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月7日 下午2:15:06
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "infoRefresh")
	public String infoRefresh(HttpServletRequest request, HttpSession session,
			@RequestParam(value = "pageNum", required = false) Integer pageNum,
			@RequestParam(value = "isReaded", required = false) String isReaded,
			@RequestParam(value = "type", required = false) String type, Model model) {
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);

		// 查询符合条件的总页数
		Map<String, Object> pageParam = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		if (null != isReaded) {
			// if (!isReaded.equals("2")) {
			// pageParam.put(Sys_info_push_logBean.isReaded, isReaded);
			// param.put(Sys_info_push_logBean.isReaded, isReaded);
			// }
			model.addAttribute("isReaded", isReaded);
		}
		if (null != type) {
			if (!type.equals("3")) {
				pageParam.put(Sys_info_push_logBean.type, type);
				param.put(Sys_info_push_logBean.type, type);
			}
			model.addAttribute("type", type);
		}
		pageParam.put(Sys_info_push_logBean.userId, user.get(UserBean.userId));
		// 查询消息总页数
		int pageCount = accountService.countPage(pageParam);
		if (pageCount == 0) {
			pageCount = 1;
		}
		int page = 1;// 当前页数
		int rows = 6;// 每页多少行
		if (pageNum != null) {
			if (pageNum > pageCount && pageCount != 0) {
				page = pageCount;
			} else if (pageNum < 0) {
				page = 1;
			} else {
				page = pageNum;
			}
		}
		param.put(Sys_info_push_logBean.userId, user.get(Sys_info_push_logBean.userId));
		param.put(SystemConstant.PAGE_KEY_PAGE, page);
		param.put(SystemConstant.PAGE_KEY_ROW, rows);
		param.put("orderby", "order by create_dt DESC");// 排序规则
		List<Map<String, Object>> messageList = accountService.findPageList(param);
		model.addAttribute("messageList", messageList);
		model.addAttribute("pageNum", page);
		model.addAttribute("pageCount", pageCount);
		return "/account/infoRefresh";
	}

}

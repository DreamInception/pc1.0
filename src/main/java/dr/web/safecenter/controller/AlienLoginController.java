package dr.web.safecenter.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dr.web.basis.bean.UserBean;
import dr.web.basis.bean.User_login_logBean;
import dr.web.basis.service.BasisUser_login_logService;
import dr.web.common.constant.InterfaceConstant;
import dr.web.common.constant.SystemConstant;
import dr.web.common.utils.HttpUtil;
import dr.web.common.utils.JsonUtil;

/**
 * 
 * @包名 :dr.web.safecenter.controller
 * @文件名 :AlienLoginController.java TODO 类作用：异地登录列表
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年4月1日 上午11:28:38
 * @版本号 :v0.0.01
 */
@Controller
@RequestMapping("pcclient/alienLogin")
public class AlienLoginController {
	private Logger logger = LoggerFactory.getLogger(AlienLoginController.class);

	@Autowired
	BasisUser_login_logService basisUser_login_logService;

	/**
	 * 
	 * TODO 方法作用：登录ip列表
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月1日 上午11:22:12
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "alienLogin")
	public String alienLogin(HttpSession session, Model model) {
		Map<String, String> ipparam = new HashMap<>();

		Map<String, Object> param = new HashMap<>();
		param.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		param.put(SystemConstant.PAGE_KEY_PAGE, "1");
		param.put(SystemConstant.PAGE_KEY_ROW, "10");
		param.put("orderby", "order by log_logintime DESC");
		List<Map<String, Object>> ipList = (List<Map<String, Object>>) basisUser_login_logService.findPageList(param);
		logger.info("用户登录数据ipList:{}", ipList);

//		ipList.forEach(uip -> {
//			String ip = (String) uip.get(User_login_logBean.logLogin_ip);
//			if (!ip.equals("127.0.0.1")) {
//				ipparam.clear();
//				ipparam.put("ip", ip);
//				String result = HttpUtil.http(InterfaceConstant.sinaIpInterface, ipparam);
//				Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);
//				if (resultMap.get("code").toString().equals("0")) {
//					Map<String,Object> temp = new HashMap<>();
//					temp = (Map<String, Object>) resultMap.get("data");
//					String address = temp.get("country").toString() + "." + temp.get("city").toString();
//					uip.put("address", address);
//				}
//			}
//		});
		model.addAttribute("ipList", ipList);
		return "safeCenter/alienLogin";
	}
}

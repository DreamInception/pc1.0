package dr.web.safecenter.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dr.web.basis.bean.UserBean;
import dr.web.basis.service.BasisUserService;
import dr.web.common.constant.InterfaceConstant;
import dr.web.common.constant.MessageConstant;
import dr.web.common.constant.SystemConstant;
import dr.web.common.utils.DrStringUtil;
import dr.web.common.utils.HttpUtil;
import dr.web.common.utils.JsonMessage;
import dr.web.common.utils.JsonUtil;

/**
 * 
 * @包名 :dr.web.safecenter.controller
 * @文件名 :IdentificationController.java TODO 类作用：绑卡三步曲
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年4月9日 下午4:27:16
 * @版本号 :v0.0.01
 */
@Controller
@RequestMapping("pcclient/identification")
public class IdentificationController {

	@Autowired
	BasisUserService basisUserService;
	@Autowired
	InterfaceConstant interfaceConstant;
	@Autowired
	SystemConstant systemConstant;

	/**
	 * 
	 * TODO 方法作用：跳转身份验证页面
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月9日 下午4:29:38
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "identificationPage")
	public String identificationPage(HttpServletRequest request, HttpSession session) {
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);

		// 身份验证三部曲跳转选择
		if (!user.containsKey(UserBean.userRealname)
				|| DrStringUtil.isNull(user.get(UserBean.userRealname).toString()) == true) {
			return "user/identification";
		} else if (!user.containsKey(UserBean.userPay_password)
				|| DrStringUtil.isNull(user.get(UserBean.userPay_password).toString()) == true) {
			return "redirect:/pcclient/safeCenter/setTransactPage";
		} else if (!user.containsKey(UserBean.userBank_account)
				|| DrStringUtil.isNull(user.get(UserBean.userBank_account).toString()) == true) {
			return "redirect:/pcclient/user/bindCardPage";
		} else {
			return "redirect:/pcclient/safeCenter/safeGuard";
		}
	}

	/**
	 * 
	 * TODO 方法作用：身份验证
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月9日 下午5:04:13
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "identification")
	@ResponseBody
	public JsonMessage identification(HttpServletRequest request, HttpSession session) {
		Map<String, Object> tempMap = new HashMap<>();
		tempMap.put(UserBean.userId, session.getAttribute(SystemConstant.USER_ID));
		Map<String, Object> user = (Map<String, Object>) basisUserService.findById(tempMap);

		JsonMessage jsonMessage = new JsonMessage(MessageConstant.CODE_0010);
		String realName = request.getParameter("realName");
		String idCardNumber = request.getParameter("idCardNumber");
		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", user.get(UserBean.userId).toString());
		params.put("realName", realName);
		params.put("idCardNumber", idCardNumber);
		params.putAll(systemConstant.getStaticMap());
		// 实名验证
		String result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.verifyRealName, params);
		Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);
		if (!resultMap.get("errCode").toString().equals("OK")) {
			jsonMessage.setErrMsg(resultMap.get(SystemConstant.MESSAGE).toString());
		}
		return jsonMessage;
	}

}

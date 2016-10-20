package dr.web.safecenter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dr.web.common.constant.SystemConstant;
/**
 * 
 * @包名 :dr.web.safecenter.controller
 * @文件名 :ResetPswController.java 
 * TODO 类作用：修改密码、交易密码成功页面
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年4月5日 下午4:04:21
 * @版本号   :v0.0.01
 */
@Controller
@RequestMapping("pcclient/resetPsw")
public class ResetPswController {
	
	/**
	 * 
	 * TODO 方法作用：重置登录密码之后跳转登录页面
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月5日 下午4:05:22
	 */
	@RequestMapping(value = "resetPwdSuccessPage")
	public String resetPwdSuccessPage(HttpServletRequest request, HttpSession session){
		session.removeAttribute(SystemConstant.SESSION_USER);
		return "redirect: /pcclient/user/access";
	}
	
	/**
	 * 
	 * TODO 方法作用：重置交易密码之后跳转安全中心
	 * @param request
	 * @param session
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月5日 下午6:29:06
	 */
	@RequestMapping(value = "resetTransactSuccessPage")
	public String resetTransactSuccessPage(){
		return "redirect: /pcclient/safeCenter/safeGuard";
	}
}

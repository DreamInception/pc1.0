/*************************************************************************
 * @system name：  :上海景源金服PC端
 * @Author: 陈吉秋特 604969793@qq.com
 * @Date: 2016年5月6日 下午2:09:49
 * @(c) Copyright 上海景源金融信息服务有限公司
**************************************************************************/

package dr.web.common.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dr.web.common.utils.VerifyCodeUtils;

/**
 * @包名 :dr.web.common.controller
 * @文件名 :AuthImageController.java TODO 类作用：调用验证码服务，并将生成的验证码存入
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年5月6日 下午2:09:49
 * @版本号 :v2.0.0-16010508
 */
@Controller
@RequestMapping("authImage")
public class AuthImageController extends HttpServlet implements Servlet {

	/**
	 * <code>serialVersionUID</code> of comment
	 */
	private static final long serialVersionUID = 214783794784201189L;

	/**
	 * 
	 * TODO 方法作用：生成验证码
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月6日 下午2:13:20
	 */
	@RequestMapping(value = "image")
	public void image(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		// 生成随机字串
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		// 存入会话session
		HttpSession session = request.getSession(true);
		session.setAttribute("rand", verifyCode.toLowerCase());
		// 生成图片
		int w = 200, h = 80;
		VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
	}
}

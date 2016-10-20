/**
 * 包名:	com.xx.common.interceptor
 * 文件名:	ControllerInterceptor.java
 * 描述:	所有Controller拦截器 对传入传出参数进行处理
 * 创建人:	qss
 * 创建时间:	2014-5-7上午10:09:23
 * 版权:	2014 xx版权所有
 */
package dr.web.common.interceptor;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dr.web.basis.bean.UserBean;
import dr.web.basis.service.BasisTiyan_activeService;
import dr.web.basis.service.BasisUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import dr.web.common.constant.MessageConstant;
import dr.web.common.constant.SystemConstant;


public class ControllerInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    BasisUserService basisUserService;
    @Autowired
    BasisTiyan_activeService basisTiyan_activeService;

    /**
     * 在DispatcherServlet完全处理完请求后被调用
     * <p>
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        request.setCharacterEncoding(SystemConstant.ENCODING_UTF_8);
        super.afterCompletion(request, response, handler, ex);

    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

    /**
     * 执行顺序: 2、postHandle
     * <p>
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 执行顺序: 1、preHandle
     * <p>
     * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * <p>
     * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
     * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.setCharacterEncoding(SystemConstant.ENCODING_UTF_8);

        String url = request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE).toString();// 当前请求的地址
        System.out.println("请求地址：" + url);

        // 放行自定义地址
        if (ReleaseUrl.URL.indexOf(url) >= 0 || ReleaseUrl.pcUrlExist(url)) {
            return super.preHandle(request, response, handler);
        }


        Object seesionValue = request.getSession().getAttribute(SystemConstant.SESSION_USER);

        // 登录检测
        if (null == seesionValue) {

            if (ReleaseUrl.pcUrlExist(url)) {
                String redirect = request.getServletPath() + "?" + StringUtils.defaultString(request.getQueryString());
                if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                    response.setHeader("sessionstatus", "timeout");
                    response.setHeader("redirectUrl", request.getContextPath() + ReleaseUrl.user_login);
                } else { /* 其他形式 */
                    response.sendRedirect(request.getContextPath() + StringUtils.defaultIfEmpty(ReleaseUrl.user_login, "/") + "?redirect="
                            + URLEncoder.encode(redirect, "UTF-8"));
                }

                return false;
            } else {
                response.getWriter().write(MessageConstant.CODE_0010);

                String redirect = request.getServletPath() + "?" + StringUtils.defaultString(request.getQueryString());
                if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                    response.setHeader("sessionstatus", "timeout");
                    response.setHeader("redirectUrl", request.getContextPath() + ReleaseUrl.forwardUrl);
                } else { /* 其他形式 */
                    response.sendRedirect(request.getContextPath() + StringUtils.defaultIfEmpty(ReleaseUrl.forwardUrl, "/") + "?redirect="
                            + URLEncoder.encode(redirect, "UTF-8"));
                }

                return false;
            }
        }

        return super.preHandle(request, response, handler);
    }

}

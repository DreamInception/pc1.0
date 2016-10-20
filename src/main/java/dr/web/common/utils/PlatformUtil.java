package dr.web.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlatformUtil {

	private static ThreadLocal<HttpServletRequest> request_threadLocal = new ThreadLocal<HttpServletRequest>();

	private static ThreadLocal<HttpServletResponse> response_threadLocal = new ThreadLocal<HttpServletResponse>();

	/**
	 * 拿到HttpServletRequest对象
	 * 
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		return request_threadLocal.get();
	}

	/**
	 * 设置HttpServletRequest对象
	 * 
	 * @param request
	 */
	public static void setRequest(HttpServletRequest request) {
		request_threadLocal.set(request);
	}

	/**
	 * 移除HttpServletRequest对象
	 */
	public static void removeRequest() {
		request_threadLocal.remove();
	}

	/**
	 * 拿到HttpServletResponse对象
	 * 
	 * @return
	 */
	public static HttpServletResponse getResponse() {
		return response_threadLocal.get();
	}

	/**
	 * 设置HttpServletResponse对象
	 * 
	 * @param response
	 */
	public static void setResponse(HttpServletResponse response) {
		response_threadLocal.set(response);
	}

	/**
	 * 移除HttpServletResponse对象
	 */
	public static void removeResponse() {
		response_threadLocal.remove();
	}

	/**
	 * 拿到HttpServletRequest里面的对象
	 * 
	 * @param key
	 *            对象名称
	 * @return
	 */
	public static Object getRequestAttribute(String key) {
		return request_threadLocal.get().getAttribute(key);
	}

}

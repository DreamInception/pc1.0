package dr.web.common.base;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dr.web.common.bean.Json;
import dr.web.common.bean.SessionUser;
import dr.web.common.constant.MessageConstant;
import dr.web.common.constant.SystemConstant;
import dr.web.common.utils.JsonUtil;
import dr.web.common.utils.PlatformUtil;

/**
 * 
 * @包名 :dr.web.common.base
 * @文件名 :BaseController.java TODO 类作用：
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年3月16日 下午3:11:18
 * @版本号 :v0.0.01
 */
public class BaseController {
	protected HttpServletRequest request;

	protected HttpServletResponse response;

	public HttpServletRequest getRequest() {
		this.request = PlatformUtil.getRequest();
		return this.request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		this.response = PlatformUtil.getResponse();
		return this.response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getSessionUserid() {
		return this.getSessionUser(SessionUser.userId);
	}

	@SuppressWarnings("unchecked")
	public String getSessionUser(String key) {
		Object object = this.getRequest().getSession()
				.getAttribute(SystemConstant.SESSION_USER);
		if (null == object) {
			return null;
		} else {
			Map<String, Object> user = (Map<String, Object>) object;
			return user.containsKey(key) ? user.get(key).toString() : null;
		}
	}

	private void setResponseEncoding(String encoding) {
		if (null == encoding) {
			encoding = SystemConstant.ENCODING_UTF_8;
		}
		getResponse().setCharacterEncoding(encoding);
	}

	protected void responseData(Object object, boolean prototype) {
		setResponseEncoding(null);
		try {
			getResponse().getWriter().write(
					JsonUtil.praseJson(object, prototype));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void responseData(Object object) {
		setResponseEncoding(null);
		try {
			getResponse().getWriter().write(
					JsonUtil.praseJson(object, Boolean.FALSE));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Map<Object, Object> result;

	public Json json;

	/**
	 * 
	 * TODO 方法作用：向页面返回的结果
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月16日 下午4:17:13
	 */
	public Map<Object, Object> getResult() {
		if (null == result) {
			result = new HashMap<Object, Object>();
		}
		return result;
	}

	/**
	 * 
	 * TODO 方法作用：获取前台传入的参数
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月16日 下午4:16:55
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getParam() {
		return (Map<String, Object>) PlatformUtil
				.getRequestAttribute(SystemConstant.PARAM);
	}

	/**
	 * 
	 * TODO 方法作用：操作结果
	 * 
	 * @param effectRow
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月16日 下午4:16:42
	 */
	public Map<String, Object> operateResult(int effectRow) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(SystemConstant.SUCCESS, effectRow > 0 ? true : false);
		result.put(SystemConstant.MESSAGE,
				effectRow > 0 ? MessageConstant.CODE_0010
						: MessageConstant.CODE_0011);
		return result;
	}

	/**
	 * 
	 * TODO 方法作用：操作结果
	 * 
	 * @param effectRow
	 * @param message
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月16日 下午4:16:47
	 */
	public Map<String, Object> operateResult(int effectRow, String message) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(SystemConstant.SUCCESS, effectRow > 0 ? true : false);
		result.put(SystemConstant.MESSAGE,
				effectRow > 0 ? MessageConstant.CODE_0010 : message);
		return result;
	}
}

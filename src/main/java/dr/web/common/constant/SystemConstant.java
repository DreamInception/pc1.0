package dr.web.common.constant;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 
 * @包名 :dr.web.common.constant
 * @文件名 :SystemConstant.java 
 * TODO 类作用：系统常量
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年4月22日 下午6:16:17
 * @版本号   :v0.0.01
 */
@Configuration
@PropertySource("classpath:prop/settings.properties")
public class SystemConstant {

	// http .POST 常量
	private String APP_ID;
	private String APP_SECRET;

	public String getAPP_ID() {
		return APP_ID;
	}

	@Value("${APP_ID}")
	public void setAPP_ID(String aPP_ID) {
		APP_ID = aPP_ID;
	}

	public String getAPP_SECRET() {
		return APP_SECRET;
	}

	@Value("${APP_SECRET}")
	public void setAPP_SECRET(String aPP_SECRET) {
		APP_SECRET = aPP_SECRET;
	}

	public static final String TESTPWD = "7Yb2GHHlw87H6293GH";
	public static final String APP_VERSION = "1.0.0-16010415";
	public static final String APP_COOKIE = "65366d1de78572ab75156cb15a268289";

	public Map<String, String> getStaticMap() {
		Map<String, String> staticMap = new HashMap<String, String>();
		staticMap.put("appId", getAPP_ID());
		staticMap.put("appVersion", SystemConstant.APP_VERSION);
		staticMap.put("appCookie", SystemConstant.APP_COOKIE);
		staticMap.put("appSecret", getAPP_SECRET());
		return staticMap;
	}

	// 系统常量
	public static final String SESSION_USER = "SESSION_USER";

	public static final String USER_ID = "USER_ID";

	public static final String LOCATION = "LOCATION";

	public static final String ENCODING_UTF_8 = "UTF-8";

	public static final String PAGE_KEY_PAGE = "page";

	public static final String PAGE_KEY_ROW = "rows";

	public static final String PARAM = "PARAM";

	public static final String CONTENT_TYPE_PLAIN = "text/plan,charset=UTF-8";

	public static final String PASSWORD = "password";

	public static final String MD5_PASSWORD = "";

	public static final String SUCCESS = "success";

	public static final String MESSAGE = "errMsg";

	public static final String ERROR = "error";

	public static final String PAGE_KEY_START = "start";

	public static final String PAGE_KEY_END = "end";

}

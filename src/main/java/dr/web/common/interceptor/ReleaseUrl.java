/*************************************************************************
 * @system name：  :中楚佳联
 * @Author: 陈吉秋特 604969793@qq.com
 * @Date: 2015-12-8 下午6:14:10
 * @(c) Copyright 武汉中楚佳联网络科技有限公司
 **************************************************************************/

package dr.web.common.interceptor;

/**
 * 
 * @包名 :dr.web.common.interceptor
 * @文件名 :ReleaseUrl.java TODO 类作用：放行的url
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年3月21日 下午8:55:25
 * @版本号 :v0.0.01
 */
public class ReleaseUrl {
	/** 检查不通过时，转发的URL */
	public static String forwardUrl = "/pcclient/user/access";

	public static String user_login = "/pcclient/user/access";

	public static StringBuffer URL = new StringBuffer();
	static {
		URL.append(user_login);
		URL.append("/pcclient/user/login");
		URL.append("/pcclient/user/register");
		URL.append("/product/productinfo");
		// 重置登录密码（未登录）
		URL.append("/pcclient/user/resetPwdUnlogin");
		// 跳转登录页面（未登录）
		URL.append("/pcclient/user/resetPwd");
	}

	/**
	 * 系统的放行的页面
	 */
	public static final String[] DR_PC_URL = { "/wechat/", "/texting/", "/company/" };

	/**
	 * 
	 * TODO 方法作用：检查放心的URL
	 * 
	 * @param url
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2015-12-8 下午7:58:24
	 */
	public static boolean pcUrlExist(String url) {
		for (int i = 0; i < DR_PC_URL.length; i++) {
			if (url.indexOf(DR_PC_URL[i]) >= 0) {
				return true;
			}
		}
		return false;
	}

}

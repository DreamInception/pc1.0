/*************************************************************************
 * @system name：  :中楚佳联
 * @Author: 陈吉秋特 604969793@qq.com
 * @Date: 2015-12-8 下午9:32:30
 * @(c) Copyright 武汉中楚佳联网络科技有限公司
 **************************************************************************/

package dr.web.common.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dr.web.common.constant.InterfaceConstant;

/**
 * 
 * @包名 :dr.web.common.utils
 * @文件名 :GetIpUtil.java TODO 类作用：获取客户端ip地址
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年3月17日 下午4:33:30
 * @版本号 :v0.0.01
 */
public class GetIpUtil {

	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip != null && ip.length() > 15) {
			// logger.warn("getAddr({})", ip);
			String[] as = ip.split(",");
			ip = as[0];
			if (ip.length() > 15) {
				ip = ip.substring(0, 15);
			}
		}
		return ip;
	}

	/**
	 * 
	 * TODO 方法作用：根据ip地址获取登录地址
	 * 
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月11日 下午3:53:45
	 */
	@SuppressWarnings("unchecked")
	public static String getLoginAddress(String ip) {
		String address = "";

		if (!ip.equals("127.0.0.1")) {
			Map<String, String> ipparam = new HashMap<>();
			ipparam.put("ip", ip);
			String result = HttpUtil.http(InterfaceConstant.sinaIpInterface, ipparam);
			Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);
			if (resultMap.get("code").toString().equals("0")) {
				Map<String, Object> temp = new HashMap<>();
				temp = (Map<String, Object>) resultMap.get("data");
				address = temp.get("country").toString() + "." + temp.get("city").toString();
			}
		}
		return address;
	}

}

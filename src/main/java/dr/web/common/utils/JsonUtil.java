/**
 *	包名:	com.xx.common.util
 *	文件名:	JsonUtil.java
 *	描述:	JSON解析类
 *	创建人:	qss
 *	创建时间:	2014-5-7下午3:27:53
 *	版权:	2014 xx版权所有
 */
package dr.web.common.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.BooleanUtils;

import dr.web.common.bean.Json;



public class JsonUtil {

	public static String praseJson(Object object, boolean prototype) {
		if (null == object) {
			return "{}";
		}
		if (object instanceof List) {
			List<?> list = (List<?>) object;
			if (BooleanUtils.isTrue(prototype)) {
				return JSONArray.fromObject(list).toString();
			} else {
				return JSONObject.fromObject(new Json(list.size(), list)).toString();
			}
		} else {
			return JSONObject.fromObject(object).toString();
		}
	}

	/**
	 * JSON转换成map
	 * 
	 * @param json
	 * @return
	 */
	public static Map<String, Object> json2Map(JSONObject json) {
		Map<String, Object> map = new HashMap<String, Object>();
		for (Object k : json.keySet()) {
			Object v = json.get(k);
			// 如果内层还是数组的话，继续解析
			map.put(k.toString(), v);
		}
		return map;
	}

	/**
	 * 
	 * TODO 方法作用：json字符串转换为map
	 * @param str
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月16日 下午3:38:37
	 */
	public static Map<String, Object> jsonStr2Map(String str) {
		JSONObject obj = JSONObject.fromObject(str);
		return json2Map(obj);
	}

}

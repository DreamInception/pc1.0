package dr.web.common.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dr.web.common.constant.InterfaceConstant;
import dr.web.common.constant.MessageConstant;
import dr.web.common.constant.SystemConstant;
import dr.web.common.utils.HttpUtil;
import dr.web.common.utils.JsonMessage;
import dr.web.common.utils.JsonUtil;

/**
 * 
 * @包名 :dr.web.common.utils
 * @文件名 :TextingUtil.java TODO 类作用：发送短信公共类
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年4月5日 下午4:35:16
 * @版本号 :v0.0.01
 */
@Controller
@RequestMapping("texting")
public class TextingController {

	@Autowired
	InterfaceConstant interfaceConstant;
	@Autowired
	SystemConstant systemConstant;

	/**
	 * 
	 * TODO 方法作用：发送短信给手机
	 * 
	 * @param phone
	 * @param tpl
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月22日 下午5:53:25
	 */
	@RequestMapping(value = "getTexting", method = RequestMethod.POST)
	@ResponseBody
	public JsonMessage getTexting(@RequestParam(value = "phone") String phone, @RequestParam(value = "tpl") String tpl,
			@RequestParam(value = "randImg") String randImg, HttpSession session) {
		JsonMessage jsonMessage = new JsonMessage(MessageConstant.CODE_0010);
		String rand = (String) session.getAttribute("rand");
		session.removeAttribute("rand");
		if (rand.equals(randImg.toLowerCase())) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("phone", phone);
			params.put("tpl", tpl);// 短信回执类型参数
			params.putAll(systemConstant.getStaticMap());
			String result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.smsCaptchaSend, params);
			Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);
			if (resultMap.get("errCode").toString().equals("OK")) {
				List<String> rows = new ArrayList<String>();
				rows.add(resultMap.get("ticket").toString());
				jsonMessage.setRows(rows);
			} else {
				jsonMessage.setErrMsg(resultMap.get("errMsg").toString());
			}
		} else {
			jsonMessage.setErrMsg(MessageConstant.CODE_0006);
		}
		return jsonMessage;
	}
}

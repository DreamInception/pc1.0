package dr.web.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @包名 :dr.web.common.utils
 * @文件名 :ForwardURLController.java 
 * TODO 类作用：公共跳转页面action
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年4月5日 下午4:39:38
 * @版本号   :v0.0.01
 */
@Controller
@RequestMapping("forward")
public class ForwardURLController {

	/**
	 * 
	 * TODO 方法作用：公共跳转URL
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月5日 下午4:40:35
	 */
	@RequestMapping(value = "forwardURL")
	public String forwardURL(@RequestParam(value = "url") String url){
		return url;
	}
}

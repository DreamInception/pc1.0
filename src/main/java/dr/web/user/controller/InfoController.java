package dr.web.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dr.web.user.service.InfoService;

/**
 * 
 * @包名 :dr.web.user.controller
 * @文件名 :InfoController.java TODO 类作用：标记信息为已读
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年4月13日 下午9:31:30
 * @版本号 :v0.0.01
 */
@Controller
@RequestMapping("pcclient/Info")
public class InfoController {

	@Autowired
	InfoService infoService;

	/**
	 * 
	 * TODO 方法作用：标记已读信息
	 * 
	 * @param userId
	 * @param infoId
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月13日 下午9:45:42
	 */
	@RequestMapping(value = "markInfo")
	@ResponseBody
	public void markInfo(@RequestParam(value = "id") String id) {
		infoService.markInfo(id);
	}
}

package dr.web.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dr.web.basis.bean.AreasBean;
import dr.web.basis.service.BasisAreasService;
import dr.web.common.constant.MessageConstant;
import dr.web.common.utils.JsonMessage;

/**
 * 
 * @包名 :dr.web.user.controller
 * @文件名 :AreaController.java TODO 类作用：返回区域地址
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年3月23日 下午8:22:09
 * @版本号 :v0.0.01
 */
@Controller
@RequestMapping("area")
public class AreaController {

	@Autowired
	BasisAreasService basisAreasService;

	/**
	 * 
	 * TODO 方法作用：查询地址,返回json
	 * 
	 * @param parentId
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月23日 下午8:33:54
	 */
	@RequestMapping(value = "getAddress")
	@ResponseBody
	public JsonMessage getAddress(@RequestParam(value = "parentId") String parentId) {
		JsonMessage jsonMessage = new JsonMessage(MessageConstant.CODE_0010);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(AreasBean.parentId, parentId);
		List<?> address = basisAreasService.findAllList(param);
		jsonMessage.setRows(address);
		return jsonMessage;
	}
}

package dr.web.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import dr.web.basis.bean.Sys_info_push_logBean;
import dr.web.common.base.InterfaceServiceImpl;
import dr.web.common.dao.DaoMethod;
import dr.web.user.service.InfoService;

/**
 * 
 * @包名 :dr.web.user.service.impl
 * @文件名 :InfoServiceImpl.java TODO 类作用：标记信息已读
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年4月13日 下午9:57:59
 * @版本号 :v0.0.01
 */
@Service(value = "infoService")
public class InfoServiceImpl extends InterfaceServiceImpl<Map<String, Object>> implements InfoService {

	public static final String nameSpace = "info";

	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return nameSpace;
	}

	/**
	 * 
	 * TODO 方法作用：信息已读
	 * 
	 * @param userId
	 * @param infoId
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月13日 下午9:57:52
	 */
	@Override
	public void markInfo(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(Sys_info_push_logBean.id, id);
		param.put(Sys_info_push_logBean.isReaded, 1);
		int i = dao.update(nameSpace, DaoMethod.UPDATE, param);
		if (i > 0) {
			System.out.println(id + ",消息标记成功！");
		} else {
			System.out.println(id + ",消息标记失败！");
		}
	}
}

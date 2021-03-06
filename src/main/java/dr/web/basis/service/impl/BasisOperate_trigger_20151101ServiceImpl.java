package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisOperate_trigger_20151101Service;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisOperate_trigger_20151101ServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisOperate_trigger_20151101Service")
public class BasisOperate_trigger_20151101ServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisOperate_trigger_20151101Service {
	public static final String nameSpace = "basis_operate_trigger_20151101";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

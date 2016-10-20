package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisOperate_trigger_20151207Service;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisOperate_trigger_20151207ServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisOperate_trigger_20151207Service")
public class BasisOperate_trigger_20151207ServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisOperate_trigger_20151207Service {
	public static final String nameSpace = "basis_operate_trigger_20151207";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisOperate_trigger_bakService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisOperate_trigger_bakServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisOperate_trigger_bakService")
public class BasisOperate_trigger_bakServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisOperate_trigger_bakService {
	public static final String nameSpace = "basis_operate_trigger_bak";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

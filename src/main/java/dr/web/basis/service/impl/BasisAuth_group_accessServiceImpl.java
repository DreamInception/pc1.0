package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisAuth_group_accessService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisAuth_group_accessServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisAuth_group_accessService")
public class BasisAuth_group_accessServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisAuth_group_accessService {
	public static final String nameSpace = "basis_auth_group_access";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

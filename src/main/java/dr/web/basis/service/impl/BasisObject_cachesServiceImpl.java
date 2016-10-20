package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisObject_cachesService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisObject_cachesServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisObject_cachesService")
public class BasisObject_cachesServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisObject_cachesService {
	public static final String nameSpace = "basis_object_caches";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

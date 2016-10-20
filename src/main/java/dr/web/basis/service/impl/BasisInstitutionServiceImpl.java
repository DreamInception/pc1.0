package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisInstitutionService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisInstitutionServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisInstitutionService")
public class BasisInstitutionServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisInstitutionService {
	public static final String nameSpace = "basis_institution";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisSystem_dayService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisSystem_dayServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisSystem_dayService")
public class BasisSystem_dayServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisSystem_dayService {
	public static final String nameSpace = "basis_system_day";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisSystem_statisticService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisSystem_statisticServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisSystem_statisticService")
public class BasisSystem_statisticServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisSystem_statisticService {
	public static final String nameSpace = "basis_system_statistic";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

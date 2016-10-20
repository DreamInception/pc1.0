package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisUcenter_appService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisUcenter_appServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisUcenter_appService")
public class BasisUcenter_appServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisUcenter_appService {
	public static final String nameSpace = "basis_ucenter_app";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

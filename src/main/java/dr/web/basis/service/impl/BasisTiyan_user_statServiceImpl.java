package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisTiyan_user_statService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisTiyan_user_statServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisTiyan_user_statService")
public class BasisTiyan_user_statServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisTiyan_user_statService {
	public static final String nameSpace = "basis_tiyan_user_stat";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

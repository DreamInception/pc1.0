package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisUser_login_logService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisUser_login_logServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisUser_login_logService")
public class BasisUser_login_logServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisUser_login_logService {
	public static final String nameSpace = "basis_user_login_log";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisApi_user_sessionsService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisApi_user_sessionsServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisApi_user_sessionsService")
public class BasisApi_user_sessionsServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisApi_user_sessionsService {
	public static final String nameSpace = "basis_api_user_sessions";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

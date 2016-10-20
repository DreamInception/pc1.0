package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisUser_password_recordService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisUser_password_recordServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisUser_password_recordService")
public class BasisUser_password_recordServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisUser_password_recordService {
	public static final String nameSpace = "basis_user_password_record";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

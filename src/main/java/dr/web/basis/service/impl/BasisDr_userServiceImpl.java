package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisDr_userService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisDr_userServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisDr_userService")
public class BasisDr_userServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisDr_userService {
	public static final String nameSpace = "basis_dr_user";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

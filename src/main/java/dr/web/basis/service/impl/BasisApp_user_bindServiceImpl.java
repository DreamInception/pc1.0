package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisApp_user_bindService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisApp_user_bindServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisApp_user_bindService")
public class BasisApp_user_bindServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisApp_user_bindService {
	public static final String nameSpace = "basis_app_user_bind";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

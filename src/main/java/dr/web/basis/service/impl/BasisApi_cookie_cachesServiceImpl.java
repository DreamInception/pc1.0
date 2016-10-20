package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisApi_cookie_cachesService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisApi_cookie_cachesServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisApi_cookie_cachesService")
public class BasisApi_cookie_cachesServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisApi_cookie_cachesService {
	public static final String nameSpace = "basis_api_cookie_caches";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

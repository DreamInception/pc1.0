package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisShanhu_user_clicksService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisShanhu_user_clicksServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisShanhu_user_clicksService")
public class BasisShanhu_user_clicksServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisShanhu_user_clicksService {
	public static final String nameSpace = "basis_shanhu_user_clicks";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

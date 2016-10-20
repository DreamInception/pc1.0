package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisPending_productService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisPending_productServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisPending_productService")
public class BasisPending_productServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisPending_productService {
	public static final String nameSpace = "basis_pending_product";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisFixed_deposit_productsService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisFixed_deposit_productsServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisFixed_deposit_productsService")
public class BasisFixed_deposit_productsServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisFixed_deposit_productsService {
	public static final String nameSpace = "basis_fixed_deposit_products";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

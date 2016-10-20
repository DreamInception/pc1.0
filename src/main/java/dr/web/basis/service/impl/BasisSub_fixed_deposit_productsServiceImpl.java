package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisSub_fixed_deposit_productsService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisSub_fixed_deposit_productsServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisSub_fixed_deposit_productsService")
public class BasisSub_fixed_deposit_productsServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisSub_fixed_deposit_productsService {
	public static final String nameSpace = "basis_sub_fixed_deposit_products";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

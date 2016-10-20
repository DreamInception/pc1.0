package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisTiyan_plan_prod_relatedService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisTiyan_plan_prod_relatedServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisTiyan_plan_prod_relatedService")
public class BasisTiyan_plan_prod_relatedServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisTiyan_plan_prod_relatedService {
	public static final String nameSpace = "basis_tiyan_plan_prod_related";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

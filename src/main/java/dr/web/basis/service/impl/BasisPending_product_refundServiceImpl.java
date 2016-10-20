package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisPending_product_refundService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisPending_product_refundServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisPending_product_refundService")
public class BasisPending_product_refundServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisPending_product_refundService {
	public static final String nameSpace = "basis_pending_product_refund";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

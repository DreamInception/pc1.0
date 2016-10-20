package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisTransaction_limitService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisTransaction_limitServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisTransaction_limitService")
public class BasisTransaction_limitServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisTransaction_limitService {
	public static final String nameSpace = "basis_transaction_limit";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

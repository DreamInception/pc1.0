package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisShort_messageService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisShort_messageServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisShort_messageService")
public class BasisShort_messageServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisShort_messageService {
	public static final String nameSpace = "basis_short_message";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

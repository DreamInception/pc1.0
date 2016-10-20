package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisTiyan_batch_excp_recordService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisTiyan_batch_excp_recordServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisTiyan_batch_excp_recordService")
public class BasisTiyan_batch_excp_recordServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisTiyan_batch_excp_recordService {
	public static final String nameSpace = "basis_tiyan_batch_excp_record";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

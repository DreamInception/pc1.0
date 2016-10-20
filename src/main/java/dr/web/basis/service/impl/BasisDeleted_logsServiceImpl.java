package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisDeleted_logsService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisDeleted_logsServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisDeleted_logsService")
public class BasisDeleted_logsServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisDeleted_logsService {
	public static final String nameSpace = "basis_deleted_logs";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisSinapay_sync_summaryService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisSinapay_sync_summaryServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisSinapay_sync_summaryService")
public class BasisSinapay_sync_summaryServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisSinapay_sync_summaryService {
	public static final String nameSpace = "basis_sinapay_sync_summary";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

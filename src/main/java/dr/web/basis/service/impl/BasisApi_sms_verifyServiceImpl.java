package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisApi_sms_verifyService;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisApi_sms_verifyServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisApi_sms_verifyService")
public class BasisApi_sms_verifyServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisApi_sms_verifyService {
	public static final String nameSpace = "basis_api_sms_verify";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

package dr.web.basis.service.impl;


import java.util.Map;
import org.springframework.stereotype.Service;
import dr.web.basis.service.BasisPlant_activity_20151113Service;
import dr.web.common.base.InterfaceServiceImpl;

/**
 * 
 * @包名 :dr.web.basis.service.impl
 * @文件名 :BasisPlant_activity_20151113ServiceImpl.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016-3-16下午5:00:00
 * @版本号 :v0.0.01
 */
@Service(value = "basisPlant_activity_20151113Service")
public class BasisPlant_activity_20151113ServiceImpl extends InterfaceServiceImpl<Map<String, Object>>  implements BasisPlant_activity_20151113Service {
	public static final String nameSpace = "basis_plant_activity_20151113";

	@Override
	public String getNamespace() {
		return nameSpace;
	}
}

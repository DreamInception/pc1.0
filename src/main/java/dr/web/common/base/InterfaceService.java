package dr.web.common.base;

import java.util.List;
import java.util.Map;

/**
 * 
 * @包名 :dr.web.common.base
 * @文件名 :InterfaceService.java 
 * TODO 类作用：
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年3月16日 下午4:20:25
 * @版本号   :v0.0.01
 */
public interface InterfaceService {
	Integer count(Map<String, Object> param);

	int save(Map<String, Object> param);

	int saveAll(Map<String, Object> param);

	int delete(Map<String, Object> param);

	int deleteAll(Map<String, Object> param);

	Object findById(Map<String, Object> param);

	List<?> findAllList(Map<String, Object> param);

	List<?> findPageList(Map<String, Object> param);

	int update(Map<String, Object> param);

}

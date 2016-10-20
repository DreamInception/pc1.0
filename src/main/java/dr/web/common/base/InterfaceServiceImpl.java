package dr.web.common.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import dr.web.common.bean.SessionUser;
import dr.web.common.constant.SystemConstant;
import dr.web.common.dao.Dao;
import dr.web.common.dao.DaoMethod;

/**
 * 
 * @包名 :dr.web.common.base
 * @文件名 :InterfaceServiceImpl.java TODO 类作用：
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年3月16日 下午4:51:35
 * @版本号 :v0.0.01
 */
public abstract class InterfaceServiceImpl<T> {

	@Autowired
	public Dao<T> dao;

	// 获取namespace
	public abstract String getNamespace();

	/**
	 * 
	 * TODO 方法作用：从前台获取id的list集合
	 * 
	 * @param object
	 *            前台传入的数据
	 * @param key
	 *            要获取的value的key
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2015-6-17 上午11:21:39
	 */
	public List<String> objectGetIdList(Map<String, Object> param, String key) {
		if (null == param) {
			return null;
		}
		String value = param.get(key).toString();
		return new ArrayList<String>(Arrays.asList(value.split(",")));
	}

	/**
	 * 
	 * TODO 方法作用：获取当前的request
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2014-6-9 下午01:50:32
	 */
	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
	}

	/**
	 * 
	 * TODO 方法作用：从session对象中取指定的key的结果
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2014-6-9 下午01:50:50
	 */
	public Object getAttributeFormRequest(String key) {
		return this.getRequest().getSession().getAttribute(key);
	}

	/**
	 * 
	 * TODO 方法作用：获取当前用户
	 * 
	 * @param key
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月16日 下午5:23:51
	 */
	@SuppressWarnings("unchecked")
	public String getSessionUser(String key) {
		Object object = this
				.getAttributeFormRequest(SystemConstant.SESSION_USER);
		if (null == object) {
			return null;
		} else {
			Map<String, Object> user = (Map<String, Object>) object;
			return user.containsKey(key) ? user.get(key).toString() : null;
		}
	}

	/**
	 * 
	 * TODO 方法作用：从session拿到当前用户的使用的用户ID
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月16日 下午5:24:01
	 */
	public String getSessionUserid() {
		return this.getSessionUser(SessionUser.userId);
	}

	public Integer count(Map<String, Object> param) {
		return dao.count(getNamespace(), DaoMethod.COUNT, param);
	}

	public int delete(Map<String, Object> param) {
		return dao.update(getNamespace(), DaoMethod.DELETE, param);
	}

	public int deleteAll(Map<String, Object> param) {
		return dao.deleteAll(getNamespace(), DaoMethod.DELETE_ALL,
				this.objectGetIdList(param, "ids[]"));
	}

	public List<?> findAllList(Map<String, Object> param) {
		return dao.findAllList(getNamespace(), DaoMethod.FIND_ALL_LIST, param);
	}

	public List<?> findPageList(Map<String, Object> param) {
		return dao
				.findPageList(getNamespace(), DaoMethod.FIND_PAGE_LIST, param);
	}

	public Object findById(Map<String, Object> param) {
		return dao.findById(getNamespace(), DaoMethod.FIND_BYID, param);
	}

	public int save(Map<String, Object> param) {
		return dao.save(getNamespace(), DaoMethod.SAVE, param);
	}

	public int saveAll(Map<String, Object> param) {
		return dao.saveAll(getNamespace(), DaoMethod.SAVE_ALL,
				new ArrayList<Map<String, Object>>());
	}

	public int update(Map<String, Object> param) {
		return dao.update(getNamespace(), DaoMethod.UPDATE, param);
	}

}

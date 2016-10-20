package dr.web.common.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import dr.web.common.bean.SessionUser;
import dr.web.common.constant.CodeConstant;
import dr.web.common.constant.SystemConstant;
import dr.web.common.exception.DataAccessException;


public class DaoImpl<T> extends SqlSessionDaoSupport implements Dao<T> {

	/**
	 * 
	 * TODO 方法作用：筛选条件时间格式化
	 * 
	 * @param param
	 * @Author: 陈吉秋特
	 * @Date: 2015-12-6 下午6:03:47
	 */
	public void screeningDateFormat(Map<String, Object> param) {
		if (null == param) {
			return;
		}

	}

	/**
	 * 
	 * TODO 方法作用：从session拿到当前用户的使用的用户ID
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2015-12-8 下午6:27:22
	 */
	public String getSessionUserid() {
		return null == sessionUserid() ? "no userid" : sessionUserid();
	}

	@SuppressWarnings("unchecked")
	public String sessionUserid() {
		RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
		if (null == attributes) {
			return null;
		}

		HttpServletRequest request = ((ServletRequestAttributes) attributes).getRequest();
		Object object = request.getSession().getAttribute(SystemConstant.SESSION_USER);
		if (null == object) {
			return null;
		}

		return ((Map<String, Object>) object).get(SessionUser.userId).toString();
	}

	@Override
	public Integer count(String nameSpace, String statementName, Map<String, Object> param) throws DataAccessException {
		if (null == nameSpace || null == statementName || null == param) {
			throw new DataAccessException("nameSpace , statementName and param must not be null ..");
		}
		try {
			List<Map<String, Object>> list = getSqlSession().selectList(nameSpace + "." + statementName, param);
			if (null == list || list.size() <= 0) {
				return 0;
			} else {
				Object count = list.get(0).values().toArray()[0];
				return Integer.parseInt(count.toString());
			}

		} catch (Exception e) {
			throw new DataAccessException(CodeConstant.CODE_0013, e.getMessage());
		}
	}

	@Override
	public Integer count(String nameSpace, String statementName) throws DataAccessException {
		if (null == nameSpace || null == statementName) {
			throw new DataAccessException("nameSpace , statementName must not be null ..");
		}
		try {
			List<Map<String, Object>> list = getSqlSession().selectList(nameSpace + "." + statementName);
			if (null == list || list.size() <= 0) {
				return 0;
			} else {
				Object count = list.get(0).values().toArray()[0];
				return Integer.parseInt(count.toString());
			}

		} catch (Exception e) {
			throw new DataAccessException(CodeConstant.CODE_0013, e.getMessage());
		}
	}

	@Override
	public int delete(String nameSpace, String statementName, Map<String, Object> param) throws DataAccessException {
		if (null == nameSpace || null == statementName || null == param) {
			throw new DataAccessException("nameSpace , statementName and param must not be null ..");
		}
		try {
			return getSqlSession().delete(nameSpace + "." + statementName, param);
		} catch (Exception e) {
			throw new DataAccessException(CodeConstant.CODE_0013, e.getMessage());
		}
	}

	@Override
	public int deleteAll(String nameSpace, String statementName, List<String> param) throws DataAccessException {
		if (null == nameSpace || null == statementName || null == param) {
			throw new DataAccessException("nameSpace , statementName and param must not be null ..");
		}
		try {
			return getSqlSession().delete(nameSpace + "." + statementName, param);
		} catch (Exception e) {
			throw new DataAccessException(CodeConstant.CODE_0013, e.getMessage());
		}
	}

	@Override
	public List<T> findAllList(String nameSpace, String statementName, Map<String, Object> param) throws DataAccessException {
		if (null == nameSpace || null == statementName) {
			throw new DataAccessException("nameSpace and statementName must not be null ..");
		}
		try {
			this.screeningDateFormat(param);// 筛选条件时间格式化
			return getSqlSession().selectList(nameSpace + "." + statementName, param);
		} catch (Exception e) {
			throw new DataAccessException(CodeConstant.CODE_0013, e.getMessage());
		}
	}

	@Override
	public List<T> findAllList(String nameSpace, String statementName) throws DataAccessException {
		if (null == nameSpace || null == statementName) {
			throw new DataAccessException("nameSpace and statementName must not be null ..");
		}
		try {
			return getSqlSession().selectList(nameSpace + "." + statementName);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException(CodeConstant.CODE_0013, e.getMessage());
		}
	}

	@Override
	public List<T> findPageList(String nameSpace, String statementName, Map<String, Object> param) throws DataAccessException {
		if (null == nameSpace || null == statementName) {
			throw new DataAccessException("nameSpace and statementName must not be null ..");
		}
		try {
			this.screeningDateFormat(param);// 筛选条件时间格式化

			if (!param.containsKey(SystemConstant.PAGE_KEY_PAGE)) {
				param.put(SystemConstant.PAGE_KEY_PAGE, 1);
			}

			if (!param.containsKey(SystemConstant.PAGE_KEY_ROW)) {
				param.put(SystemConstant.PAGE_KEY_ROW, 6);
			}

			int page = StringUtils.isBlank(param.get(SystemConstant.PAGE_KEY_PAGE).toString()) ? 1 : Integer.parseInt(param.get(SystemConstant.PAGE_KEY_PAGE)
					.toString());
			int rows = StringUtils.isBlank(param.get(SystemConstant.PAGE_KEY_ROW).toString()) ? 1 : Integer.parseInt(param.get(SystemConstant.PAGE_KEY_ROW)
					.toString());

			// 设置分页和排序参数
			param.put(SystemConstant.PAGE_KEY_START, (page - 1) * rows);
			param.put(SystemConstant.PAGE_KEY_END, rows);

			return getSqlSession().selectList(nameSpace + "." + statementName, param);
		} catch (Exception e) {
			throw new DataAccessException(CodeConstant.CODE_0013, e.getMessage());
		}
	}

	@Override
	public T findById(String nameSpace, String statementName, Map<String, Object> param) throws DataAccessException {
		if (null == nameSpace || null == statementName) {
			throw new DataAccessException("nameSpace and statementName must not be null ..");
		}
		try {
			this.screeningDateFormat(param);// 筛选条件时间格式化

			return getSqlSession().selectOne(nameSpace + "." + statementName, param);
		} catch (Exception e) {
			throw new DataAccessException(CodeConstant.CODE_0013, e.getMessage());
		}
	}

	@Override
	public int save(String nameSpace, String statementName, Map<String, Object> param) throws DataAccessException {
		if (null == nameSpace || null == statementName) {
			throw new DataAccessException("nameSpace and statementName must not be null ..");
		}
		try {
			return getSqlSession().insert(nameSpace + "." + statementName, param);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException(CodeConstant.CODE_0013, e.getMessage());
		}
	}

	@Override
	public int saveAll(String nameSpace, String statementName, List<Map<String, Object>> param) throws DataAccessException {
		if (null == nameSpace || null == statementName) {
			throw new DataAccessException("nameSpace and statementName must not be null ..");
		}
		try {
			return getSqlSession().insert(nameSpace + "." + statementName, param);
		} catch (Exception e) {
			throw new DataAccessException(CodeConstant.CODE_0013, e.getMessage());
		}
	}

	@Override
	public int update(String nameSpace, String statementName, Map<String, Object> param) throws DataAccessException {
		if (null == nameSpace || null == statementName) {
			throw new DataAccessException("nameSpace and statementName must not be null ..");
		}
		try {
			return getSqlSession().update(nameSpace + "." + statementName, param);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException(CodeConstant.CODE_0013, e.getMessage());
		}
	}

}

package dr.web.common.dao;

import java.util.List;
import java.util.Map;

import dr.web.common.exception.DataAccessException;

public interface Dao<T> {

	public Integer count(String nameSpace, String statementName,
			Map<String, Object> param) throws DataAccessException;

	public Integer count(String nameSpace, String statementName)
			throws DataAccessException;

	public int save(String nameSpace, String statementName,
			Map<String, Object> param) throws DataAccessException;

	public int saveAll(String nameSpace, String statementName,
			List<Map<String, Object>> param) throws DataAccessException;

	public int delete(String nameSpace, String statementName,
			Map<String, Object> param) throws DataAccessException;

	public int deleteAll(String nameSpace, String statementName,
			List<String> param) throws DataAccessException;

	public T findById(String nameSpace, String statementName,
			Map<String, Object> param) throws DataAccessException;

	public List<T> findAllList(String nameSpace, String statementName,
			Map<String, Object> param) throws DataAccessException;

	public List<T> findAllList(String nameSpace, String statementName)
			throws DataAccessException;

	public List<T> findPageList(String nameSpace, String statementName,
			Map<String, Object> param) throws DataAccessException;

	public int update(String nameSpace, String statementName,
			Map<String, Object> param) throws DataAccessException;

}

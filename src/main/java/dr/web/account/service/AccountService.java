package dr.web.account.service;

import java.util.List;
import java.util.Map;

public interface AccountService {

	Map<String, Object> getLastLogin(Map<String, Object> user);

	List<Map<String, Object>> sinaYieldLog(Map<String, Object> user);

	List<Map<String, Object>> findPageList(Map<String, Object> param);

	int countPage(Map<String, Object> param);

	Map<String, Object> smallChange(Map<String, Object> param);

	/**
	 * TODO 方法作用：
	 * 
	 * @param userId
	 * @param days
	 * @param datetime
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月17日 下午1:54:48
	 */
	int countProductPage(String userId, Integer days, String datetime);

	/**
	 * TODO 方法作用：
	 * @param userId
	 * @param days
	 * @param datetime
	 * @param pageNum
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月20日 下午3:22:13
	 */ 
	List<Map<String, Object>> getProductList(String userId, Integer days, String datetime, int pageNum);

	/**
	 * TODO 方法作用：
	 * @param param
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月21日 下午3:13:19
	 */ 
	List<Map<String, Object>> ticketDetail(Map<String, Object> param);

}

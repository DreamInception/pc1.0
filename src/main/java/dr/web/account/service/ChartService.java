package dr.web.account.service;

import java.util.List;
import java.util.Map;

public interface ChartService {

	String financeContract(Map<String, Object> user);

	/**
	 * TODO 方法作用：
	 * @param userId
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月16日 下午9:00:04
	 */ 
	List<String> assetYieldLog(String userId);

	/**
	 * TODO 方法作用：
	 * @param userId
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月17日 上午9:33:04
	 */ 
	List<String> sinaYieldLog(String userId);

}

package dr.web.account.service;

import java.util.Map;

public interface FinanceService {

	Map<String, Object> recharge(Map<String, String> param);

	Map<String, Object> rechargeVerify(Map<String, String> param);

	Map<String, Object> checkPwd(Map<String, String> pwdMap);

	/**
	 * TODO 方法作用：
	 * @param param
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月23日 下午4:43:05
	 */ 
	Map<String, Object> bankCharge(Map<String, String> param);

}

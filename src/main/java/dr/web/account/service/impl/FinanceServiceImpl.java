package dr.web.account.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dr.web.account.service.FinanceService;
import dr.web.common.base.InterfaceServiceImpl;
import dr.web.common.constant.InterfaceConstant;
import dr.web.common.utils.HttpUtil;
import dr.web.common.utils.JsonUtil;

/**
 * 
 * @包名 :dr.web.account.service.impl
 * @文件名 :FinanceServiceImpl.java TODO 类作用：充值、提现
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年3月27日 下午6:54:23
 * @版本号 :v0.0.01
 */
@Service(value = "financeServiceI")
public class FinanceServiceImpl extends InterfaceServiceImpl<Map<String, Object>> implements FinanceService {

	@Autowired
	InterfaceConstant interfaceConstant;

	public static final String nameSpace = "withdraw";

	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return nameSpace;
	}

	/**
	 * 
	 * TODO 方法作用：充值
	 * 
	 * @param param
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月27日 下午7:51:40
	 */
	@Override
	public Map<String, Object> recharge(Map<String, String> param) {
		String result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.deposit, param);
		Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);
		return resultMap;
	}

	/**
	 * 
	 * TODO 方法作用：充值短信验证
	 * 
	 * @param param
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月27日 下午9:35:26
	 */
	@Override
	public Map<String, Object> rechargeVerify(Map<String, String> param) {
		String result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.depositVerify, param);
		Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);
		return resultMap;
	}

	/**
	 * 
	 * TODO 方法作用：比对支付或交易密码
	 * 
	 * @param param
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月28日 下午2:06:46
	 */
	@Override
	public Map<String, Object> checkPwd(Map<String, String> param) {
		String result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.checkPwd, param);
		Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);
		return resultMap;
	}

	/**
	 * 
	 * TODO 方法作用：银行充值接口
	 * 
	 * @param param
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月23日 下午4:42:17
	 */
	@Override
	public Map<String, Object> bankCharge(Map<String, String> param) {
		String result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.getDepositUrl, param);
		Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);
		return resultMap;
	}
}

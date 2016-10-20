package dr.web.safecenter.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dr.web.basis.bean.UserBean;
import dr.web.common.base.InterfaceServiceImpl;
import dr.web.common.constant.InterfaceConstant;
import dr.web.common.constant.SystemConstant;
import dr.web.common.utils.HttpUtil;
import dr.web.common.utils.JsonUtil;
import dr.web.safecenter.service.WithdrawService;

/**
 * 
 * @包名 :dr.web.safecenter.service.impl
 * @文件名 :WithdrawServiceImpl.java TODO 类作用：提现
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年3月27日 上午9:49:38
 * @版本号 :v0.0.01
 */
@Service(value = "withdrawService")
public class WithdrawServiceImpl extends InterfaceServiceImpl<Map<String, Object>> implements WithdrawService {

	@Autowired
	InterfaceConstant interfaceConstant;
	@Autowired
	SystemConstant systemConstant;
	
	public static final String nameSpace = "withdraw";

	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return nameSpace;
	}

	/**
	 * 
	 * TODO 方法作用：提现
	 * 
	 * @param param
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月27日 上午10:06:10
	 */
	@Override
	public String withdraw(Map<String, String> param) {
		String result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.withdraw, param);
		Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);
		return resultMap.get("errCode").toString().equals("OK") ? resultMap.get("errCode").toString()
				: resultMap.get("errMsg").toString();
	}
	
	/**
	 * 
	 * TODO 方法作用：换绑银行卡
	 * @param param
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月27日 下午3:00:59
	 */
	@Override
	public Map<String,Object> exchange(Map<String, String> param,Map<String,Object> user){
		Map<String,String> userParam = new HashMap<>();
		userParam.put("userId", user.get(UserBean.userId).toString());
		userParam.putAll(systemConstant.getStaticMap());
		//先解绑银行卡，再绑定
		String result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.unbindBankCard, userParam);
		Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);
		if(resultMap.get("errCode").toString().equals("OK")){
			result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.bindBankCard, param);
			resultMap = JsonUtil.jsonStr2Map(result);
		}
		return resultMap;
	}
	
}

package dr.web.account.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dr.web.account.service.ChartService;
import dr.web.basis.bean.Asset_yield_logBean;
import dr.web.basis.bean.User_sina_yield_logBean;
import dr.web.common.base.InterfaceServiceImpl;
import dr.web.common.bean.SessionUser;
import dr.web.common.constant.InterfaceConstant;
import dr.web.common.constant.SystemConstant;
import dr.web.common.utils.HttpUtil;
import dr.web.common.utils.JsonUtil;

/**
 * 
 * @包名 :dr.web.account.service.impl
 * @文件名 :ChartServiceImpl.java TODO 类作用：所有图表数据
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年3月31日 下午5:06:41
 * @版本号 :v0.0.01
 */
@Service(value = "chartService")
public class ChartServiceImpl extends InterfaceServiceImpl<Map<String, Object>> implements ChartService {
	private static Logger logger = LoggerFactory.getLogger(ChartServiceImpl.class);

	@Autowired
	InterfaceConstant interfaceConstant;
	@Autowired
	SystemConstant systemConstant;

	public static final String nameSpace = "chart";

	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return nameSpace;
	}

	/**
	 * 
	 * TODO 方法作用：我的资产图表数据
	 * 
	 * @param user
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月31日 下午3:49:44
	 */
	@Override
	public List<String> sinaYieldLog(String userId) {
		String[] yieldArray = { "0", "0", "0", "0", "0", "0", "0", "0" };
		Map<String, Object> yieldMap = new HashMap<String, Object>();
		Map<String, Object> user = new HashMap<String, Object>();
		user.put(User_sina_yield_logBean.userId, userId);
		user.put("orderby", "Order By log_yield_date DESC");
		// 零钱包前八天的收益以及日期
		List<Map<String, Object>> sinaYieldList = dao.findAllList(nameSpace, "sinaYieldLog", user);
		logger.info("零钱包八天收益sinaYieldList:{}", sinaYieldList);
		for (int i = 0; i < sinaYieldList.size(); i++) {
			yieldMap = sinaYieldList.get(i);
			if (!yieldMap.isEmpty() && yieldMap.containsKey(User_sina_yield_logBean.logYield)) {
				// 前八天每天的收益
				yieldArray[i] = yieldMap.get(User_sina_yield_logBean.logYield).toString();
			}
		}
		List<String> yieldList = Arrays.asList(yieldArray);
		logger.info("返回的结果yieldList:{}", yieldList);
		return yieldList;
	}

	/**
	 * 
	 * TODO 方法作用：查询前八天零钱收益
	 * 
	 * @param userId
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月16日 下午8:59:44
	 */
	@Override
	public List<String> assetYieldLog(String userId) {
		String[] assetArray = { "0", "0", "0", "0", "0", "0", "0", "0" };
		Map<String, Object> assetMap = new HashMap<String, Object>();
		assetMap.put(Asset_yield_logBean.userId, userId);
		// 我的资产前八天收益
		for (int i = 1; i <= 8; i++) {
			assetMap.put("days", i);
			List<Map<String, Object>> assetYieldList = dao.findAllList(nameSpace, "sinaAssetLog", assetMap);
			if (null != assetYieldList.get(0)) {
				assetArray[i - 1] = assetYieldList.get(0).get(Asset_yield_logBean.logYield).toString();
			}
		}
		List<String> assetList = Arrays.asList(assetArray);
		logger.info("返回的结果assetList:{}", assetList);
		return assetList;
	}

	/**
	 * 
	 * TODO 方法作用：我的资产项目合同
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月12日 下午1:12:54
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String financeContract(Map<String, Object> user) {
		Map<String, String> param = new HashMap<String, String>();
		param.put(SessionUser.userId, user.get(SessionUser.userId).toString());
		int assetIds = Integer.parseInt(user.get("productId").toString()) * 10 + 1;
		param.put("assetIds", String.valueOf(assetIds));// 合同id
		param.put("page", "0");// 第1页
		param.put("elementsPerPage", "1");// 每页记录数
		param.put("returnedFields", "contract");// 只取合同
		param.putAll(systemConstant.getStaticMap());
		String result = HttpUtil.http(interfaceConstant.getIp() + InterfaceConstant.assets, param);
		Map<String, Object> resultMap = JsonUtil.jsonStr2Map(result);
		if (resultMap.get("errCode").toString().equals("OK")) {
			List<Map<String, Object>> resultList = (List<Map<String, Object>>) resultMap.get("elements");
			logger.info("合同结果集resultList:{}", resultList);
			return resultList.get(0).get("contract").toString();
		} else {
			logger.info("错误信息resultMap:{}", resultMap.get("errMsg").toString());
			return resultMap.get("errMsg").toString();
		}
	}
}

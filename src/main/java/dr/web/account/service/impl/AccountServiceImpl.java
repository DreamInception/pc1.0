package dr.web.account.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dr.web.account.service.AccountService;
import dr.web.basis.bean.AssetBean;
import dr.web.basis.bean.Asset_yield_logBean;
import dr.web.basis.bean.OrderBean;
import dr.web.basis.bean.ProductBean;
import dr.web.basis.bean.User_finance_logBean;
import dr.web.basis.service.impl.BasisAssetServiceImpl;
import dr.web.basis.service.impl.BasisAsset_yield_logServiceImpl;
import dr.web.basis.service.impl.BasisDr_orderServiceImpl;
import dr.web.basis.service.impl.BasisOrderServiceImpl;
import dr.web.basis.service.impl.BasisProductServiceImpl;
import dr.web.basis.service.impl.BasisSys_info_push_logServiceImpl;
import dr.web.common.base.InterfaceServiceImpl;
import dr.web.common.constant.InterfaceConstant;
import dr.web.common.constant.SystemConstant;
import dr.web.common.dao.DaoMethod;
import dr.web.common.utils.DateUtil;

/**
 * 
 * @包名 :dr.web.account.service.impl
 * @文件名 :AccountServiceImpl.java TODO 类作用：
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年3月29日 下午8:52:25
 * @版本号 :v0.0.01
 */
@Service(value = "accountServiceI")
public class AccountServiceImpl extends InterfaceServiceImpl<Map<String, Object>> implements AccountService {
	private static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	InterfaceConstant interfaceConstant;
	@Autowired
	SystemConstant systemConstant;
	@Autowired
	BasisOrderServiceImpl basisOrderServiceImpl;
	@Autowired
	BasisAssetServiceImpl basisAssetServiceImpl;
	@Autowired
	BasisAsset_yield_logServiceImpl basisAsset_yield_logServiceImpl;
	@Autowired
	BasisDr_orderServiceImpl basisDr_orderServiceImpl;

	public static final String nameSpace = "account";

	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return nameSpace;
	}

	/**
	 * 
	 * TODO 方法作用：获取最后登录时间与地址
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月29日 下午9:08:49
	 */
	@Override
	public Map<String, Object> getLastLogin(Map<String, Object> user) {
		return dao.findById(nameSpace, DaoMethod.FIND_BYID, user);
	}

	/**
	 * 
	 * TODO 方法作用：查询用户零钱包前八天的收益与日期
	 * 
	 * @param user
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月30日 下午5:56:17
	 */
	@Override
	public List<Map<String, Object>> sinaYieldLog(Map<String, Object> user) {
		return dao.findAllList(nameSpace, "sinaYieldLog", user);
	}

	/**
	 * 
	 * TODO 方法作用：查询用户消息
	 * 
	 * @param param
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月6日 上午11:37:11
	 */
	@Override
	public List<Map<String, Object>> findPageList(Map<String, Object> param) {
		return dao.findPageList(BasisSys_info_push_logServiceImpl.nameSpace, DaoMethod.FIND_PAGE_LIST, param);
	}

	/**
	 * 
	 * TODO 方法作用：返回我的消息总页数
	 * 
	 * @param param
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月6日 下午1:37:07
	 */
	@Override
	public int countPage(Map<String, Object> param) {
		int messageCount = dao.count(BasisSys_info_push_logServiceImpl.nameSpace, DaoMethod.COUNT, param);
		int pageCount;
		if (messageCount % 6 == 0) {
			pageCount = messageCount / 6;
		} else {
			pageCount = messageCount / 6 + 1;
		}
		return pageCount;
	}

	/**
	 * 
	 * TODO 方法作用：零钱包列表-操作明细
	 * 
	 * @param param
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月11日 下午2:38:41
	 */
	@Override
	public Map<String, Object> smallChange(Map<String, Object> param) {
		Map<String, Object> smallMap = new HashMap<String, Object>();
		// 当前页面
		Integer pageNum = 0;
		if (param.containsKey("pageNum")) {
			pageNum = Integer.parseInt(param.get("pageNum").toString());
		}
		int count = dao.count(nameSpace, "countFinanceLog", param);
		int pageCount = 1;
		if (count % 8 == 0) {
			pageCount = count / 8;
		} else if (count % 8 > 0) {
			pageCount = count / 8 + 1;
		}
		int page = 1;// 当前页数
		int rows = 7;// 每页多少行
		if (pageNum != null) {
			if (pageNum > pageCount) {
				page = pageCount;
			} else if (pageNum <= 0) {
				page = 1;
			} else {
				page = pageNum;
			}
		}
		param.put(SystemConstant.PAGE_KEY_PAGE, page);
		param.put(SystemConstant.PAGE_KEY_ROW, rows);
		// 查询列表数据
		List<Map<String, Object>> pageList = dao.findPageList(nameSpace, "findPageFinanceLog", param);
		logger.info("列表数据pageList:{}", pageList);
		// 迭代list中数据，向页面输入中文
		Iterator<Map<String, Object>> it = pageList.iterator();
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		while (it.hasNext()) {
			Map<String, Object> temp = it.next();
			// 日志状态输出中文
			int logStatus = Integer.parseInt(temp.get(User_finance_logBean.logStatus).toString());
			switch (logStatus) {
			case 1:
				temp.put(User_finance_logBean.logStatus, "完成");
				break;
			case 0:
				temp.put(User_finance_logBean.logStatus, "未完成");
				break;
			case -1:
				temp.put(User_finance_logBean.logStatus, "处理失败");
				break;
			}
			resultList.add(temp);
			it.remove();
		}
		smallMap.put("list", resultList);
		smallMap.put("pageCount", pageCount);
		smallMap.put("page", page);
		return smallMap;
	}

	/**
	 * 
	 * TODO 方法作用：查询用户订单条数，计算产品总条数
	 * 
	 * @param param
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月12日 下午5:28:59
	 */
	@Override
	public int countProductPage(String userId, Integer days, String datetime) {
		Map<String, Object> param = new HashMap<>();
		param.put(OrderBean.userId, userId);
		param.put("days", days);
		param.put(OrderBean.orderPaytime, datetime);
		param.put(OrderBean.orderStatus, 2);// 订单已付款
		int productCount = dao.count(nameSpace, "countOrder", param);
		int pageCount;
		if (productCount % 8 == 0) {
			pageCount = productCount / 8;
		} else {
			pageCount = productCount / 8 + 1;
		}
		return pageCount;
	}

	/**
	 * 
	 * TODO 方法作用：获取用户购买产品列表及交易明细
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月12日 下午7:18:34
	 */
	@Override
	public List<Map<String, Object>> getProductList(String userId, Integer days, String datetime, int pageNum) {
		List<Map<String, Object>> resultList = new ArrayList<>();
		Map<String, Object> param = new HashMap<>();
		int rows = 8;
		param.put(OrderBean.userId, userId);
		param.put("days", days);
		param.put(OrderBean.orderPaytime, datetime);
		param.put(SystemConstant.PAGE_KEY_PAGE, pageNum);
		param.put(SystemConstant.PAGE_KEY_ROW, rows);
		param.put("orderby", "Order By dr_order.order_paytime DESC");
		List<Map<String, Object>> orderList = dao.findPageList(nameSpace, "orderPageList", param);

		Map<String, Object> productMap = new HashMap<>();// 查询产品map
		Map<String, Object> assetMap = new HashMap<>();// 查询资产map
		Map<String, Object> assetLogMap = new HashMap<>();// 查询资产日志map
		List<Map<String, Object>> tempList = new ArrayList<>();
		for (Map<String, Object> temp : orderList) {
			Map<String, Object> result = new HashMap<>();// 存放结果map
			productMap.clear();
			assetMap.clear();
			assetLogMap.clear();
			tempList.clear();
			// 产品id
			String pdtId = temp.get(OrderBean.pdtId).toString();
			// 订单id
			String orderId = temp.get(OrderBean.orderId).toString();

			assetMap.put(AssetBean.userId, userId);
			assetMap.put(AssetBean.pdtId, pdtId);
			assetMap.put(AssetBean.orderId, orderId);
			// 查询资产list
			List<Map<String, Object>> assetList = dao.findAllList(nameSpace, "assetAllList", assetMap);
			// 资产id
			String assetId = assetList.get(0).get(AssetBean.assetId).toString();
			productMap.put(ProductBean.pdtId, pdtId);
			Map<String, Object> productResult = dao.findById(BasisProductServiceImpl.nameSpace, DaoMethod.FIND_BYID,
					productMap);
			// 产品名称
			result.put(ProductBean.pdtName, productResult.get(ProductBean.pdtName));
			// 交易额
			result.put(OrderBean.orderAmount, temp.get(OrderBean.orderAmount));

			assetLogMap.put(Asset_yield_logBean.userId, userId);
			assetLogMap.put(Asset_yield_logBean.pdtId, pdtId);
			assetLogMap.put(Asset_yield_logBean.assetId, assetId);
			assetLogMap.put("orderby", "ORDER BY log_yield_date DESC LIMIT 1");
			List<Map<String, Object>> assetLog = dao.findAllList(basisAsset_yield_logServiceImpl.getNamespace(),
					DaoMethod.FIND_ALL_LIST, assetLogMap);
			if (assetLog.size() > 0) {
				// 累计收益
				result.put(Asset_yield_logBean.logAccumulated_yield,
						assetLog.get(0).get(Asset_yield_logBean.logAccumulated_yield));
				// 预计到账金额
				String pdt_expect_yield_unit = productResult.get(ProductBean.pdtExpect_yield_unit).toString();
				String order_amount = temp.get(OrderBean.orderAmount).toString();
				BigDecimal expect_amount = new BigDecimal(order_amount)
						.add(new BigDecimal(order_amount).multiply(new BigDecimal(pdt_expect_yield_unit)));
				result.put("expect_amount", expect_amount);
				// 状态
				result.put(AssetBean.assetStatus, assetList.get(0).get(AssetBean.assetStatus).toString());
				// 购买日
				result.put(OrderBean.orderCreatetime, temp.get(OrderBean.orderCreatetime));
				String lastDay = assetList.get(0).get(AssetBean.assetExpire_date).toString();
				try {
					int remainDays = DateUtil.daysBetween(DateUtil.nowDate("yyyy-MM-dd"), lastDay);
					// 剩余天数
					if (remainDays > 0) {
						result.put("remainDays", remainDays);
					} else {
						result.put("remainDays", 0);
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 法律文件
				result.put("productId", pdtId);
				tempList.add(result);
				resultList.addAll(tempList);
			}
		}
		return resultList;
	}

	/**
	 * 
	 * TODO 方法作用：查询体验金或加息券明细
	 * 
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月21日 下午3:05:41
	 */
	@Override
	public List<Map<String, Object>> ticketDetail(Map<String, Object> param) {
		return dao.findPageList(nameSpace, "tiyanAllList", param);
	}
}

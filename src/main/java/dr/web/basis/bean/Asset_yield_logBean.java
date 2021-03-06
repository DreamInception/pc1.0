/**
 *	包名:	dr.web.basis.controller
 *	文件名:	Bean.java
 *	描述:	登录相关操作
 *	创建人:	陈吉秋特
 *	创建时间:	2016-3-16下午5:00:00
 *	版权:	2016 景源金服版权所有
 */
package dr.web.basis.bean;
import dr.web.common.bean.BaseBean;
/**
 * 
 * @包名 :dr.web.basis.controller
 * @文件名 :Asset_yield_logBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Asset_yield_logBean  extends BaseBean {

	/**log_id*/public static final String logId = "logId" ;                                           /**asset_id*/public static final String assetId = "assetId" ;                                           /**user_id*/public static final String userId = "userId" ;                                           /**pdt_id*/public static final String pdtId = "pdtId" ;                                           /**机构ID*/public static final String instId = "instId" ;                                           /**收益日期*/public static final String logYield_date = "logYield_date" ;                                           /**当日收益*/public static final String logYield = "logYield" ;                                           /**总资产*/public static final String logAsset_amount = "logAsset_amount" ;                                           /**资产累计收益*/public static final String logAccumulated_yield = "logAccumulated_yield" ;                                           /**购买金额*/public static final String logBuymoney = "logBuymoney" ;                                           /**当日收益利率*/public static final String logYield_rate = "logYield_rate" ;                                           /**类型：  1：每日收益   2：赎回清算*/public static final String logType = "logType" ;                                           /**log_createtime*/public static final String logCreatetime = "logCreatetime" ;                                           
}

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
 * @文件名 :Pending_asset_refundBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Pending_asset_refundBean  extends BaseBean {

	/**refund_id*/public static final String refundId = "refundId" ;                                           /**资产ID*/public static final String assetId = "assetId" ;                                           /**用户ID*/public static final String userId = "userId" ;                                           /**产品ID*/public static final String pdtId = "pdtId" ;                                           /**机构ID*/public static final String instId = "instId" ;                                           /**购买份额*/public static final String assetBuycount = "assetBuycount" ;                                           /**资产本金*/public static final String assetBuymoney = "assetBuymoney" ;                                           /**赎回份额*/public static final String refundCount = "refundCount" ;                                           /**利息收益*/public static final String refundYield = "refundYield" ;                                           /**手续费*/public static final String refundFee = "refundFee" ;                                           /**赎回总金额*/public static final String refundAmount = "refundAmount" ;                                           /**回款类型 1:到期赎回 2：撤单 3：提前赎回*/public static final String refundType = "refundType" ;                                           /**还款日期*/public static final String refundDate = "refundDate" ;                                           /**refund_createtime*/public static final String refundCreatetime = "refundCreatetime" ;                                           
}

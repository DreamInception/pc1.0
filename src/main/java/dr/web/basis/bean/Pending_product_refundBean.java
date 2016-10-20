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
 * @文件名 :Pending_product_refundBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Pending_product_refundBean  extends BaseBean {

	/**refund_id*/public static final String refundId = "refundId" ;                                           /**产品ID*/public static final String pdtId = "pdtId" ;                                           /**机构ID*/public static final String instId = "instId" ;                                           /**该产品当天赎回的订单购买份额*/public static final String assetBuycount = "assetBuycount" ;                                           /**该产品当天赎回的订单金额*/public static final String assetBuymoney = "assetBuymoney" ;                                           /**该产品当天赎回的份额*/public static final String refundCount = "refundCount" ;                                           /**该产品当天赎回的资产收益*/public static final String refundYield = "refundYield" ;                                           /**该产品当天赎回需支付的手续费*/public static final String refundFee = "refundFee" ;                                           /**该产品当天赎回的总金额*/public static final String refundAmount = "refundAmount" ;                                           /**回款类型 1:到期赎回 2：撤单 3：提前赎回*/public static final String refundType = "refundType" ;                                           /**资产收益率*/public static final String refundYield_rate = "refundYield_rate" ;                                           /**需还款的资产数量*/public static final String refundAllocate_num = "refundAllocate_num" ;                                           /**还款日期*/public static final String refundDate = "refundDate" ;                                           /**发送状态 0：未发放   1：已发放*/public static final String refundStatus = "refundStatus" ;                                           /**refund_createtime*/public static final String refundCreatetime = "refundCreatetime" ;                                           /**refund_modifytime*/public static final String refundModifytime = "refundModifytime" ;                                           
}

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
 * @文件名 :OrderBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class OrderBean  extends BaseBean {

	/**order_id*/public static final String orderId = "orderId" ;                                           /**order_no*/public static final String orderNo = "orderNo" ;                                           /**user_id*/public static final String userId = "userId" ;                                           /**pdt_id*/public static final String pdtId = "pdtId" ;                                           /**inst_id*/public static final String instId = "instId" ;                                           /**机构名称*/public static final String orderInst_name = "orderInst_name" ;                                           /**产品名称*/public static final String orderProduct_name = "orderProduct_name" ;                                           /**产品单价*/public static final String orderProduct_price = "orderProduct_price" ;                                           /**购买份数*/public static final String orderBuycount = "orderBuycount" ;                                           /**订单金额*/public static final String orderAmount = "orderAmount" ;                                           /**order_charge*/public static final String orderCharge = "orderCharge" ;                                           /**order_actual_amount*/public static final String orderActual_amount = "orderActual_amount" ;                                           /**订单保证金*/public static final String orderBail_money = "orderBail_money" ;                                           /**order_freeze_id*/public static final String orderFreeze_id = "orderFreeze_id" ;                                           /**order_unfreeze_id*/public static final String orderUnfreeze_id = "orderUnfreeze_id" ;                                           /**确认时间*/public static final String orderConfirmtime = "orderConfirmtime" ;                                           /**代付时间*/public static final String orderPaytime = "orderPaytime" ;                                           /**代收流水号*/public static final String orderCollect_no = "orderCollect_no" ;                                           /**代付流水号*/public static final String orderPay_no = "orderPay_no" ;                                           /**order_expire_next_step*/public static final String orderExpire_next_step = "orderExpire_next_step" ;                                           /**order_remark*/public static final String orderRemark = "orderRemark" ;                                           /**订单状态
0:待确认
1：确认
2：已付款 -1 订单失败 -2被拒绝*/public static final String orderStatus = "orderStatus" ;                                           /**order_createtime*/public static final String orderCreatetime = "orderCreatetime" ;                                           /**order_modifytime*/public static final String orderModifytime = "orderModifytime" ;                                           
}

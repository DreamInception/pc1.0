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
 * @文件名 :Tiyan_user_recordBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Tiyan_user_recordBean  extends BaseBean {

	/**主键ID*/public static final String urId = "urId" ;                                           /**用户操作记录表ID*/public static final String otId = "otId" ;                                           /**用户ID*/public static final String userId = "userId" ;                                           /**关联类型*/public static final String relatedType = "relatedType" ;                                           /**被关联ID*/public static final String relatedId = "relatedId" ;                                           /**订单对应得到产品来源，0：老产品，1：新版产品*/public static final String rtSource = "rtSource" ;                                           /**订单ID*/public static final String orderId = "orderId" ;                                           /**触发条件；1：分享朋友圈（裂变），2：买就送*/public static final String otTrigger_condition = "otTrigger_condition" ;                                           /**体验金方案ID*/public static final String planId = "planId" ;                                           /**体验金金额*/public static final String urTiyan_amount = "urTiyan_amount" ;                                           /**预定收益率*/public static final String urPromise_rate = "urPromise_rate" ;                                           /**用户体验金记录状态；默认1：正常，0：未使用，-1：取消， 2：到期，3：已划转， 4：已过期（暂时仅用于加息劵）*/public static final String urState = "urState" ;                                           /**类型，默认0：体验金，1：加息劵*/public static final String urType = "urType" ;                                           /**起息日期*/public static final String urStart_date = "urStart_date" ;                                           /**到期日期*/public static final String urEnd_date = "urEnd_date" ;                                           /**当日收益*/public static final String urDay_profit = "urDay_profit" ;                                           /**累计收益*/public static final String urAccu_profit = "urAccu_profit" ;                                           /**创建时间*/public static final String urCreate_time = "urCreate_time" ;                                           /**最后一次修改时间*/public static final String urModified_time = "urModified_time" ;                                           /**划转时间*/public static final String urTransfer_time = "urTransfer_time" ;                                           /**收款请求ID*/public static final String urCollect_request_id = "urCollect_request_id" ;                                           /**付款请求ID*/public static final String urPay_request_id = "urPay_request_id" ;                                           
}

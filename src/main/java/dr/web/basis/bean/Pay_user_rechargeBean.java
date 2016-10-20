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
 * @文件名 :Pay_user_rechargeBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Pay_user_rechargeBean  extends BaseBean {

	/**id*/public static final String id = "id" ;                                           /**用户ID*/public static final String userId = "userId" ;                                           /**渠道ID*/public static final String channelId = "channelId" ;                                           /**商户ID*/public static final String mchntId = "mchntId" ;                                           /**订单号*/public static final String transId = "transId" ;                                           /**订单交易号*/public static final String tradeNo = "tradeNo" ;                                           /**交易金额*/public static final String orderAmt = "orderAmt" ;                                           /**交易状态 0：初始状态 1同步返回成功 2同步返回失败 3异步返回成功 4异步返回失败 5数据异常*/public static final String state = "state" ;                                           /**返回码*/public static final String returnCode = "returnCode" ;                                           /**返回描述*/public static final String returnMsg = "returnMsg" ;                                           /**创建时间*/public static final String createDt = "createDt" ;                                           /**更新时间*/public static final String modifiedTs = "modifiedTs" ;                                           
}

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
 * @文件名 :Pay_user_withdrawBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Pay_user_withdrawBean  extends BaseBean {

	/**id*/public static final String id = "id" ;                                           /**用户ID*/public static final String userId = "userId" ;                                           /**渠道ID*/public static final String channelId = "channelId" ;                                           /**批次ID*/public static final String batchId = "batchId" ;                                           /**商户订单号*/public static final String transNo = "transNo" ;                                           /**提现金额*/public static final String transAmt = "transAmt" ;                                           /**状态 0为初始状态 1已受理 3异步请求成功 4异步请求失败 5数据异常*/public static final String state = "state" ;                                           /**返回码*/public static final String returnCode = "returnCode" ;                                           /**返回描述*/public static final String returnMsg = "returnMsg" ;                                           /**创建时间*/public static final String createDt = "createDt" ;                                           /**更新时间*/public static final String modifiedTs = "modifiedTs" ;                                           
}

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
 * @文件名 :Pay_user_finance_flowBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Pay_user_finance_flowBean  extends BaseBean {

	/**id*/public static final String id = "id" ;                                           /**用户ID*/public static final String userId = "userId" ;                                           /**渠道ID*/public static final String channelId = "channelId" ;                                           /**订单号*/public static final String transId = "transId" ;                                           /**流水类型，默认1：充值，2：收益，3：到期赎回，4：提现*/public static final String type = "type" ;                                           /**流水金额*/public static final String amount = "amount" ;                                           /**描述说明*/public static final String descs = "descs" ;                                           /**状态*/public static final String state = "state" ;                                           /**创建时间*/public static final String createDt = "createDt" ;                                           
}

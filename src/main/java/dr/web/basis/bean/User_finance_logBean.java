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
 * @文件名 :User_finance_logBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class User_finance_logBean  extends BaseBean {

	/**log_id*/public static final String logId = "logId" ;                                           /**user_id*/public static final String userId = "userId" ;                                           /**操作类型\\n1：充值\\n2：提现\\n3：冻结\\n4：解冻5：购买产品-付款 6：产品到期-收款7:购买产品-资产到帐8:存钱罐收益 9:转入在途账户 10：转出在途账户11：体验金收益， 12：调账，13:系统平账, 14：活动奖励*/public static final String logOperate = "logOperate" ;                                           /**log_operate_money*/public static final String logOperate_money = "logOperate_money" ;                                           /**log_operate_reason*/public static final String logOperate_reason = "logOperate_reason" ;                                           /**log_operator*/public static final String logOperator = "logOperator" ;                                           /**log_user_wealth*/public static final String logUser_wealth = "logUser_wealth" ;                                           /**log_user_balance*/public static final String logUser_balance = "logUser_balance" ;                                           /**log_user_frozen*/public static final String logUser_frozen = "logUser_frozen" ;                                           /**log_user_asset*/public static final String logUser_asset = "logUser_asset" ;                                           /**log_user_yield*/public static final String logUser_yield = "logUser_yield" ;                                           /**log_user_float*/public static final String logUser_float = "logUser_float" ;                                           /**log_target_id*/public static final String logTarget_id = "logTarget_id" ;                                           /**日志状态，1：处理完成 0：处理中 -1： 处理失败*/public static final String logStatus = "logStatus" ;                                           /**是否在用户端显示*/public static final String logDisplay = "logDisplay" ;                                           /**log_remark*/public static final String logRemark = "logRemark" ;                                           /**log_createtime*/public static final String logCreatetime = "logCreatetime" ;                                           
}

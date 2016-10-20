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
 * @文件名 :User_active_reward_logBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class User_active_reward_logBean  extends BaseBean {

	/**uarl_id*/public static final String uarlId = "uarlId" ;                                           /**用户ID*/public static final String userId = "userId" ;                                           /**活动编码*/public static final String activeCode = "activeCode" ;                                           /**活动描述*/public static final String activeDescs = "activeDescs" ;                                           /**奖励金额*/public static final String uarlAmount = "uarlAmount" ;                                           /**状态 默认0：待付款， 1：已付款， -1：付款失败*/public static final String uarlStatus = "uarlStatus" ;                                           /**奖励时间戳（秒）*/public static final String uarlTime = "uarlTime" ;                                           /**创建时间*/public static final String uarlCreate_dt = "uarlCreate_dt" ;                                           /**最后一次修改时间*/public static final String uarlModified_dt = "uarlModified_dt" ;                                           
}

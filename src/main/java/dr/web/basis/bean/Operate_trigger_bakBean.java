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
 * @文件名 :Operate_trigger_bakBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Operate_trigger_bakBean  extends BaseBean {

	/**主键ID*/public static final String otId = "otId" ;                                           /**关联用户表ID*/public static final String userId = "userId" ;                                           /**关联类型；默认1：产品，2：活动*/public static final String relatedType = "relatedType" ;                                           /**被关联ID*/public static final String relatedId = "relatedId" ;                                           /**产生的订单ID，用于回查该操作的详细信息，如购买金额等*/public static final String orderId = "orderId" ;                                           /**触发条件；1：分享朋友圈（裂变），2：买就送*/public static final String otTrigger_condition = "otTrigger_condition" ;                                           /**触发时间*/public static final String otTrigger_time = "otTrigger_time" ;                                           /**操作IP*/public static final String otIp = "otIp" ;                                           /**操作终端*/public static final String otEnd = "otEnd" ;                                           /**触发条件默认字段1*/public static final String otDefault1 = "otDefault1" ;                                           
}

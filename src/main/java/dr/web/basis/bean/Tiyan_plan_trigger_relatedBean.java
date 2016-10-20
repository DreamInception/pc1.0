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
 * @文件名 :Tiyan_plan_trigger_relatedBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Tiyan_plan_trigger_relatedBean  extends BaseBean {

	/**主键ID*/public static final String id = "id" ;                                           /**关联的方案id*/public static final String planId = "planId" ;                                           /**关联的方案触发条件id*/public static final String triggerCondition_id = "triggerCondition_id" ;                                           /**触发次序*/public static final String triggerOrder = "triggerOrder" ;                                           /**状态 默认1：正常*/public static final String state = "state" ;                                           /**创建时间*/public static final String createTime = "createTime" ;                                           
}

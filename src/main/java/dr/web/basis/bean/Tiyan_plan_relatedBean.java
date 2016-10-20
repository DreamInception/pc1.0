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
 * @文件名 :Tiyan_plan_relatedBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Tiyan_plan_relatedBean  extends BaseBean {

	/**pr_id*/public static final String prId = "prId" ;                                           /**方案ID*/public static final String planId = "planId" ;                                           /**关联类型；默认值1：关联产品  2：关联活动。。*/public static final String relatedType = "relatedType" ;                                           /**被关联的ID；如果关联类型(related_type)等于1，则为被关联的产品ID*/public static final String relatedId = "relatedId" ;                                           /**创建时间*/public static final String prCreate_time = "prCreate_time" ;                                           
}

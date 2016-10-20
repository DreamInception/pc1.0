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
 * @文件名 :Tiyan_plan_prod_relatedBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Tiyan_plan_prod_relatedBean  extends BaseBean {

	/**主键ID*/public static final String pprId = "pprId" ;                                           /**方案ID*/public static final String planId = "planId" ;                                           /**产品ID*/public static final String pdtId = "pdtId" ;                                           /**关联产品来源，默认0：原始产品dr_product， 1：v3_fixed_deposit_products*/public static final String rtSource = "rtSource" ;                                           /**关联状态； 默认1：正常*/public static final String pprState = "pprState" ;                                           /**额外字段*/public static final String pprExtra = "pprExtra" ;                                           /**创建时间*/public static final String pprCreate_dt = "pprCreate_dt" ;                                           
}

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
 * @文件名 :Tiyan_planBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Tiyan_planBean  extends BaseBean {

	/**方案ID*/public static final String planId = "planId" ;                                           /**方案名称*/public static final String planName = "planName" ;                                           /**方案期限；单位：天，默认为1天*/public static final String planPeriod = "planPeriod" ;                                           /**方案额度类型；1：固定额度，2：购买额度的倍数， 3：固定区间随机取*/public static final String planPosition_type = "planPosition_type" ;                                           /**方案额度，当方案额度类型为固定额度（1）时，为指定值，为2时，表示倍数，为3时，表示区间的起始值*/public static final String planPosition = "planPosition" ;                                           /**方案额度，当方案额度类型为3时，才有值，表示区间的闭环值*/public static final String planPosition_section = "planPosition_section" ;                                           /**方案利率类型；1：固定利率，2：同购买产品的利率*/public static final String planRate_type = "planRate_type" ;                                           /**方案利率；仅当方案利率类型为固定利率（1）时，这个字段才有值*/public static final String planRate = "planRate" ;                                           /**需要显示的图标icon，可以是文字，如果要显示图片，可存储样式class*/public static final String planIcon = "planIcon" ;                                           /**方案有效时间，如30：表示方案在触发成功后，30天内有效，如30天内未使用，则自动作废*/public static final String planValid_period = "planValid_period" ;                                           /**方案 每人可使用的次数*/public static final String planCount_person = "planCount_person" ;                                           /**方案可被使用的次数*/public static final String planCount_limit = "planCount_limit" ;                                           /**方案已被使用的次数*/public static final String planCount_used = "planCount_used" ;                                           /**方案关联的触发动作，是否需要按顺序依次执行；默认1：需要，2：不需要*/public static final String planOrder_flag = "planOrder_flag" ;                                           /**方案关联产品类型，默认1：指定关联产品；2：关联任意产品*/public static final String planPdt_rt_type = "planPdt_rt_type" ;                                           /**方案状态；默认1：正常，-1：删除*/public static final String planState = "planState" ;                                           /**方案描述*/public static final String planDescs = "planDescs" ;                                           /**方案到期日期*/public static final String planExpire_date = "planExpire_date" ;                                           /**方案创建时间*/public static final String planCreate_time = "planCreate_time" ;                                           /**方案最后一次修改时间*/public static final String planModified_time = "planModified_time" ;                                           /**plan_extra*/public static final String planExtra = "planExtra" ;                                           
}

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
 * @文件名 :Tiyan_activeBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Tiyan_activeBean  extends BaseBean {

	/**主键ID*/public static final String id = "id" ;                                           /**活动名称*/public static final String name = "name" ;                                           /**活动状态 默认1：正常， -1：删除*/public static final String state = "state" ;                                           /**活动开始时间*/public static final String startTime = "startTime" ;                                           /**活动结束时间*/public static final String endTime = "endTime" ;                                           /**活动创建时间*/public static final String createTime = "createTime" ;                                           /**最后一次修改时间*/public static final String modifiedTime = "modifiedTime" ;                                           
}

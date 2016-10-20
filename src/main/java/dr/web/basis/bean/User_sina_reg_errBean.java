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
 * @文件名 :User_sina_reg_errBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class User_sina_reg_errBean  extends BaseBean {

	/**usre_id*/public static final String usreId = "usreId" ;                                           /**用户Id*/public static final String userId = "userId" ;                                           /**新浪注册状态 0：失败， 1：补录成功， -1：补录失败*/public static final String usreState = "usreState" ;                                           /**创建时间*/public static final String usreCreate_dt = "usreCreate_dt" ;                                           /**修改时间*/public static final String usreModified_ts = "usreModified_ts" ;                                           
}

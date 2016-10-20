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
 * @文件名 :App_user_bindBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class App_user_bindBean  extends BaseBean {

	/**主键*/public static final String id = "id" ;                                           /**用户ID*/public static final String userId = "userId" ;                                           /**用户手机号*/public static final String userTelephone = "userTelephone" ;                                           /**设备编号*/public static final String deviceToken = "deviceToken" ;                                           /**极光注册号*/public static final String registId = "registId" ;                                           /**设备类型：ios/android*/public static final String endPoint = "endPoint" ;                                           /**状态，默认1：正常*/public static final String state = "state" ;                                           /**创建时间*/public static final String createDt = "createDt" ;                                           
}

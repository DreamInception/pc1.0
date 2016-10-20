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
 * @文件名 :Remote_req_logBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Remote_req_logBean  extends BaseBean {

	/**id*/public static final String id = "id" ;                                           /**用户ID*/public static final String userId = "userId" ;                                           /**服务名称*/public static final String serviceName = "serviceName" ;                                           /**服务请求uri*/public static final String serviceUri = "serviceUri" ;                                           /**请求参数*/public static final String reqParam = "reqParam" ;                                           /**请求IP*/public static final String reqIp = "reqIp" ;                                           /**创建时间*/public static final String createDt = "createDt" ;                                           /**请求时间戳*/public static final String reqTs = "reqTs" ;                                           
}

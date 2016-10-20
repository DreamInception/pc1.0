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
 * @文件名 :Action_logBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Action_logBean  extends BaseBean {

	/**主键*/public static final String id = "id" ;                                           /**行为id*/public static final String actionId = "actionId" ;                                           /**执行用户id*/public static final String userId = "userId" ;                                           /**执行行为者ip*/public static final String actionIp = "actionIp" ;                                           /**触发行为的表*/public static final String model = "model" ;                                           /**触发行为的数据id*/public static final String recordId = "recordId" ;                                           /**日志备注*/public static final String remark = "remark" ;                                           /**状态*/public static final String status = "status" ;                                           /**执行行为的时间*/public static final String createTime = "createTime" ;                                           
}

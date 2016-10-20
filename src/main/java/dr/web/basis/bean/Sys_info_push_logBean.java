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
 * @文件名 :Sys_info_push_logBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Sys_info_push_logBean  extends BaseBean {

	/**ID*/public static final String id = "id" ;                                           /**用户ID*/public static final String userId = "userId" ;                                           /**用户手机号*/public static final String userTelephone = "userTelephone" ;                                           /**设备标示*/public static final String registId = "registId" ;                                           /**标题*/public static final String title = "title" ;                                           /**内容*/public static final String content = "content" ;                                           /**消息ID*/public static final String infoId = "infoId" ;                                           /**消息类型，默认1：公共消息，2：个人消息*/public static final String type = "type" ;                                           /**发送状态，默认1：发送成功，-1：发送失败*/public static final String state = "state" ;                                           /**消息是否已阅，默认0：未阅，1：已阅*/public static final String isReaded = "isReaded" ;                                           /**发送时间*/public static final String createDt = "createDt" ;                                           
}

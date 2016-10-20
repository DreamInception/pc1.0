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
 * @文件名 :Tiyan_invitation_relatedBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Tiyan_invitation_relatedBean  extends BaseBean {

	/**tir_id*/public static final String tirId = "tirId" ;                                           /**用户ID*/public static final String userId = "userId" ;                                           /**用户手机号*/public static final String phone = "phone" ;                                           /**邀请人ID*/public static final String rId = "rId" ;                                           /**获得的体验金*/public static final String tirAmount = "tirAmount" ;                                           /**是否激活 默认0：未注册， 1：未实名， 2：未绑卡，3：未投资，4：已加息*/public static final String tirState = "tirState" ;                                           /**创建时间*/public static final String tirCreate_dt = "tirCreate_dt" ;                                           /**最后一次修改时间*/public static final String tirModified_ts = "tirModified_ts" ;                                           
}

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
 * @文件名 :Auth_groupBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Auth_groupBean  extends BaseBean {

	/**用户组id,自增主键*/public static final String id = "id" ;                                           /**用户组所属模块*/public static final String module = "module" ;                                           /**组类型*/public static final String type = "type" ;                                           /**用户组中文名称*/public static final String title = "title" ;                                           /**描述信息*/public static final String description = "description" ;                                           /**用户组状态：为1正常，为0禁用,-1为删除*/public static final String status = "status" ;                                           /**用户组拥有的规则id，多个规则 , 隔开*/public static final String rules = "rules" ;                                           
}

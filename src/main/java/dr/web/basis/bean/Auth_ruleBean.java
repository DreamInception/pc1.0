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
 * @文件名 :Auth_ruleBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Auth_ruleBean  extends BaseBean {

	/**规则id,自增主键*/public static final String id = "id" ;                                           /**规则所属module*/public static final String module = "module" ;                                           /**1-url;2-主菜单*/public static final String type = "type" ;                                           /**规则唯一英文标识*/public static final String name = "name" ;                                           /**规则中文描述*/public static final String title = "title" ;                                           /**是否有效(0:无效,1:有效)*/public static final String status = "status" ;                                           /**规则附加条件*/public static final String condition = "condition" ;                                           
}

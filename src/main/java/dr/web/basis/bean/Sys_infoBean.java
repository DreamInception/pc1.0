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
 * @文件名 :Sys_infoBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Sys_infoBean  extends BaseBean {

	/**主键*/public static final String id = "id" ;                                           /**标题*/public static final String title = "title" ;                                           /**内容*/public static final String content = "content" ;                                           /**是否短信发送，默认0：不需要，1：需要*/public static final String useSms = "useSms" ;                                           /**是否系统发送，默认0：不需要，1：需要*/public static final String useSys = "useSys" ;                                           /**类型，默认1：通用*/public static final String type = "type" ;                                           /**状态，默认0：初始创建，1：待发布， -1：删除， 2：已发布*/public static final String state = "state" ;                                           /**创建时间*/public static final String createDt = "createDt" ;                                           /**最近一次修改时间*/public static final String modifiedTs = "modifiedTs" ;                                           /**发布时间*/public static final String publishDt = "publishDt" ;                                           
}

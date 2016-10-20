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
 * @文件名 :AreasBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class AreasBean  extends BaseBean {

	/**area_id*/public static final String areaId = "areaId" ;                                           /**父id*/public static final String parentId = "parentId" ;                                           /**省市地区名称*/public static final String areaName = "areaName" ;                                           /**省市地区拼音*/public static final String pyName = "pyName" ;                                           /**head_py_name*/public static final String headPy_name = "headPy_name" ;                                           /**邮政编码*/public static final String zipcode = "zipcode" ;                                           /**类型(0:国家;1:省份;2:城市;3:地区)*/public static final String areaType = "areaType" ;                                           /**直辖市的标记(0:否;1:是)*/public static final String special = "special" ;                                           
}

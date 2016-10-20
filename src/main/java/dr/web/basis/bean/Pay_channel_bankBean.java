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
 * @文件名 :Pay_channel_bankBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Pay_channel_bankBean  extends BaseBean {

	/**id*/public static final String id = "id" ;                                           /**渠道ID*/public static final String channelId = "channelId" ;                                           /**银行编号*/public static final String code = "code" ;                                           /**银行名称*/public static final String name = "name" ;                                           /**单笔限额*/public static final String singleLimit = "singleLimit" ;                                           /**单日限额*/public static final String dayLimit = "dayLimit" ;                                           /**单月限额*/public static final String monthLimit = "monthLimit" ;                                           /**状态，默认1：正常，-1：禁用*/public static final String state = "state" ;                                           /**创建时间*/public static final String createDt = "createDt" ;                                           /**更新时间*/public static final String modifiedTs = "modifiedTs" ;                                           
}

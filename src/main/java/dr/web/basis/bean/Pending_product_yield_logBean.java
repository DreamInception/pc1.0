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
 * @文件名 :Pending_product_yield_logBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Pending_product_yield_logBean  extends BaseBean {

	/**log_id*/public static final String logId = "logId" ;                                           /**产品ID*/public static final String pdtId = "pdtId" ;                                           /**机构ID*/public static final String instId = "instId" ;                                           /**收益日期*/public static final String logYield_date = "logYield_date" ;                                           /**当日产品收益率*/public static final String logYield_rate = "logYield_rate" ;                                           /**需分配的资产数量*/public static final String logAllocate_num = "logAllocate_num" ;                                           /**收益发放状态 0：未发放  1：已发放  2：有新的未发放*/public static final String logStatus = "logStatus" ;                                           /**log_createtime*/public static final String logCreatetime = "logCreatetime" ;                                           /**更新日期*/public static final String logModifytime = "logModifytime" ;                                           
}

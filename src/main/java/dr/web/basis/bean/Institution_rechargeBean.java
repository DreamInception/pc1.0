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
 * @文件名 :Institution_rechargeBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Institution_rechargeBean  extends BaseBean {

	/**ir_id*/public static final String irId = "irId" ;                                           /**inst_id*/public static final String instId = "instId" ;                                           /**inst_bank_pay_id*/public static final String instBank_pay_id = "instBank_pay_id" ;                                           /**ir_no*/public static final String irNo = "irNo" ;                                           /**ir_sina_inner_trade_no*/public static final String irSina_inner_trade_no = "irSina_inner_trade_no" ;                                           /**充值金额  = 手续费 + 实际到账金额*/public static final String irAmount = "irAmount" ;                                           /**手续费*/public static final String irCharge = "irCharge" ;                                           /**实际到账金额*/public static final String irActual_amount = "irActual_amount" ;                                           /**ir_bank_code*/public static final String irBank_code = "irBank_code" ;                                           /**ir_bank_account*/public static final String irBank_account = "irBank_account" ;                                           /**ir_ip*/public static final String irIp = "irIp" ;                                           /**新浪支付推进ticket*/public static final String irTicket = "irTicket" ;                                           /**0处理中，1已到账，2失败*/public static final String irStatus = "irStatus" ;                                           /**ir_remark*/public static final String irRemark = "irRemark" ;                                           /**ir_createtime*/public static final String irCreatetime = "irCreatetime" ;                                           /**ir_modfiytime*/public static final String irModfiytime = "irModfiytime" ;                                           
}

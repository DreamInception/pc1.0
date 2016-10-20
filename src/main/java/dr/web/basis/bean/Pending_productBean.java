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
 * @文件名 :Pending_productBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Pending_productBean  extends BaseBean {

	/**pdt_id*/public static final String pdtId = "pdtId" ;                                           /**产品代码*/public static final String pdtNo = "pdtNo" ;                                           /**机构ID*/public static final String instId = "instId" ;                                           /**产品名称*/public static final String pdtName = "pdtName" ;                                           /**产品icon*/public static final String pdtIcon = "pdtIcon" ;                                           /**产品类型
1：理财计划
2：债券
3：收益权转让
4：债券转让
5：定向融资工具*/public static final String pdtType = "pdtType" ;                                           /**产品合同ID*/public static final String pdtContract_id = "pdtContract_id" ;                                           /**产品期限*/public static final String pdtCycle = "pdtCycle" ;                                           /**产品期限单位*/public static final String pdtCycle_unit = "pdtCycle_unit" ;                                           /**期限单位计算周期*/public static final String pdtCycle_unit_days = "pdtCycle_unit_days" ;                                           /**产品周期以天计算*/public static final String pdtCycle_in_days = "pdtCycle_in_days" ;                                           /**起息方式：0：固定日期 1：浮动日期*/public static final String pdtStart_yield_type = "pdtStart_yield_type" ;                                           /**确认日*/public static final String pdtConfirm_date = "pdtConfirm_date" ;                                           /**起息日*/public static final String pdtStart_yield_date = "pdtStart_yield_date" ;                                           /**开始收益发放日*/public static final String pdtStart_allot_yield_date = "pdtStart_allot_yield_date" ;                                           /**到期日*/public static final String pdtExpire_date = "pdtExpire_date" ;                                           /**资金到账日*/public static final String pdtRefund_date = "pdtRefund_date" ;                                           /**收益计算类型
1:约定收益
2：净值浮动
3：分配收益*/public static final String pdtYield_count_type = "pdtYield_count_type" ;                                           /**收益类型
1:保本保息
2：保底预期
3：保本预期
4：非保本预期
5：非保本浮动
6：保本浮动收益
7：保底浮动收益*/public static final String pdtYield_type = "pdtYield_type" ;                                           /**收益方式：1：订单 2：净值*/public static final String pdtYield_mode = "pdtYield_mode" ;                                           /**预期年化收益*/public static final String pdtExpect_yield_rate = "pdtExpect_yield_rate" ;                                           /**保底收益*/public static final String pdtGuaranteed_yield_rate = "pdtGuaranteed_yield_rate" ;                                           /**一份产品到期收益*/public static final String pdtExpect_yield_unit = "pdtExpect_yield_unit" ;                                           /**产品库存*/public static final String pdtStock_count = "pdtStock_count" ;                                           /**最低募集成功限额*/public static final String pdtReach_count = "pdtReach_count" ;                                           /**单笔最小限额*/public static final String pdtMin_order_count = "pdtMin_order_count" ;                                           /**单笔最大限额*/public static final String pdtMax_order_count = "pdtMax_order_count" ;                                           /**单人单品购买上限*/public static final String pdtPerson_limit_count = "pdtPerson_limit_count" ;                                           /**每份单价*/public static final String pdtUnit_price = "pdtUnit_price" ;                                           /**递增份数*/public static final String pdtIncrease_unitcount = "pdtIncrease_unitcount" ;                                           /**是否可提前赎回； 0：否，1：是*/public static final String pdtAllow_advance_refund = "pdtAllow_advance_refund" ;                                           /**提前赎回手续费*/public static final String pdtAdvance_refund_fee = "pdtAdvance_refund_fee" ;                                           /**上架时间*/public static final String pdtOnsale_time = "pdtOnsale_time" ;                                           /**下架时间*/public static final String pdtOffsale_time = "pdtOffsale_time" ;                                           /**到期处理方式
0|1
  0：自动赎回  
1：自动续期*/public static final String pdtExpire_next_step = "pdtExpire_next_step" ;                                           /**默认到期处理方式
0*/public static final String pdtDefault_expire_next_step = "pdtDefault_expire_next_step" ;                                           /**订单是否自动确认 0：否  1：是*/public static final String pdtAuto_confirm_order = "pdtAuto_confirm_order" ;                                           /**产品描述*/public static final String pdtInstruction = "pdtInstruction" ;                                           /**产品收益说明*/public static final String pdtYield_instruction = "pdtYield_instruction" ;                                           /**产品风险说明*/public static final String pdtRisk_instruction = "pdtRisk_instruction" ;                                           /**是否需要风险评估 0：不需要，1：需要*/public static final String pdtNeed_risk_evaluation = "pdtNeed_risk_evaluation" ;                                           /**产品风险等级 1：低  2：中 3：高*/public static final String pdtRisk_level = "pdtRisk_level" ;                                           /**pdt_target_date*/public static final String pdtTarget_date = "pdtTarget_date" ;                                           /**备注*/public static final String pdtRemark = "pdtRemark" ;                                           /**操作者*/public static final String pdtOperator = "pdtOperator" ;                                           /**操作备注*/public static final String pdtOperator_remark = "pdtOperator_remark" ;                                           /**产品状态
0：待审核
1：审核通过
2：退回
*/public static final String pdtStatus = "pdtStatus" ;                                           /**pdt_createtime*/public static final String pdtCreatetime = "pdtCreatetime" ;                                           /**pdt_modifytime*/public static final String pdtModifytime = "pdtModifytime" ;                                           
}

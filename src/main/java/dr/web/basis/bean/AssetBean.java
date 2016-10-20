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
 * @文件名 :AssetBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class AssetBean  extends BaseBean {

	/**asset_id*/public static final String assetId = "assetId" ;                                           /**asset_no*/public static final String assetNo = "assetNo" ;                                           /**user_id*/public static final String userId = "userId" ;                                           /**pdt_id*/public static final String pdtId = "pdtId" ;                                           /**机构ID*/public static final String instId = "instId" ;                                           /**order_id*/public static final String orderId = "orderId" ;                                           /**机构传回资产合同号*/public static final String assetContract_no = "assetContract_no" ;                                           /**资产金额=asset_buymoney+asset_yield-asset_yield_fee-asset_charge*/public static final String assetAmount = "assetAmount" ;                                           /**asset_buymoney*/public static final String assetBuymoney = "assetBuymoney" ;                                           /**收益*/public static final String assetYield = "assetYield" ;                                           /**asset_yesterday_yield*/public static final String assetYesterday_yield = "assetYesterday_yield" ;                                           /**收益税*/public static final String assetYield_fee = "assetYield_fee" ;                                           /**手续费*/public static final String assetCharge = "assetCharge" ;                                           /**购买份数*/public static final String assetBuy_count = "assetBuy_count" ;                                           /**asset_price*/public static final String assetPrice = "assetPrice" ;                                           /**收益率*/public static final String assetYield_rate = "assetYield_rate" ;                                           /**购买时间*/public static final String assetBuytime = "assetBuytime" ;                                           /**确认时间*/public static final String assetConfirmtime = "assetConfirmtime" ;                                           /**收益时间/起息时间*/public static final String assetStart_yield_date = "assetStart_yield_date" ;                                           /**asset_start_allot_yield_date*/public static final String assetStart_allot_yield_date = "assetStart_allot_yield_date" ;                                           /**到期时间*/public static final String assetExpire_date = "assetExpire_date" ;                                           /**还款时间*/public static final String assetRefund_date = "assetRefund_date" ;                                           /**到期处理方式 0：自动赎回  1：自动续期*/public static final String assetExpire_next_step = "assetExpire_next_step" ;                                           /**收益更新时间*/public static final String assetYield_updatetime = "assetYield_updatetime" ;                                           /**实际打款时间*/public static final String assetRepaytime = "assetRepaytime" ;                                           /**代收请求号*/public static final String assetCollect_no = "assetCollect_no" ;                                           /**代付请求号*/public static final String assetPay_no = "assetPay_no" ;                                           /**0：待确认， 1：确认 2：到期  3：已赎回 -1：失败*/public static final String assetStatus = "assetStatus" ;                                           /**asset_createtime*/public static final String assetCreatetime = "assetCreatetime" ;                                           /**asset_modifytime*/public static final String assetModifytime = "assetModifytime" ;                                           
}

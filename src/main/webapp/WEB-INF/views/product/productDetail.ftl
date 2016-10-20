<!DOCTYPE html>
<html>
<head lang="en">
	<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/product/css/index.css">
    <script type="text/javascript" src="${base}/static/product/js/productDetail.js" charset="gb2312"></script>
		   ${script!}
      <title>多肉-产品页|http://www.51doro.com-白领阶层互联网资产管理专家</title>
</head>
<body>

<#include "../public/header_product.ftl" >
<article class="mid-Container f-index-dline">
    <section class="product-buy-list f-cb">
        <article class="product-main-lt f-fl">
            <aside id="pro-recharge-success" class="pro-recharge-status">
                <div class="f-cb">
                    <img src="${base}/static/Public/images/success_Small.png" class="rc_success f-fl">
                    <p class="pro-success-txt f-fl">
                        零钱包已成功充值<span class="pro-reg-num">300</span>元, 当前余额 <span class="pro-account-num">1,234.21</span>元
                    </p>
                    <a href="../../Account/ftls/userAccount.html" class="pro-jump f-fr">交易明细</a>
                </div>
            </aside>
            <aside id="pro-recharge-fail" class="pro-recharge-status f-cb">
                <img src="${base}/static/Public/images/fail_Small.png" class="rc_fail f-fl">
                <p class="pro-fail-txt f-fl">
                    <span>充值失败!</span>
                    <span>原因XXX</span>
                </p>
                <a href="../../Account/ftls/userAccount.html" class="pro-retry f-fr">重试</a>

            </aside>
            <div id="pd-first" class="pbl-info">
                <ul class="pbl-info-title f-cb">
                    <li class="f-fl"><img src="${(pdt.icon)!""}"></li>
                    <li class="pbl-info-txt f-fl">${(pdt.name)!""}</li>
                </ul>
                <dl class="pbl-info-content f-cb">
                    <dd class="f-fl">
                 <!--       <i class="pbl-prate-num">${((pdt.expectYieldRate*100)?c)!""}%</i>  -->
                  <i class="pbl-prate-num">${(pdt.expectYieldRate?string('0.00%'))!""}</i> 
                        <i class="pbl-prate-txt">预期年化收益率(%)</i>
                    </dd>
                    <dd class="f-fl">
                        <i class="pbl-pmoney-num">${(pdt.minOrderAmount?c)!""}</i>
                        <i class="pbl-pmoney-txt">起购金额(元)</i>
                    </dd>
                    <dd class="f-fl del-mgr">
                        <i class="pbl-pday-num">${(pdt.durationDesc)!""}</i>
                        <i class="pbl-pday-txt">理财期限</i>
                    </dd>
                    <!--<dd class="f-fl">-->
                        <!--<i class="pbl-prate-num">400,000</i>-->
                        <!--<i class="pbl-prate-txt">剩余金额</i>-->
                    <!--</dd>-->
                </dl>
                <div class="pbl-info-wz">
                    <p class="pbl-wz01 f-fl">计息日期: T+1 即加入计划的第二天</p>
                    <p class="pbl-wz02 f-fr">资金到账日: 到期后两天之内到账</p>

                    <p class="pbl-wz03">还款方式: 到期一次性还本付息</p>
                </div>
            </div>

            <section id="product-nav-list" class="product-nav-list f-cb">
                <a href="javascript:void(0)" id="product-prd-tab" class="product-navBtn prodlt-activeTab f-fl">产品详情</a>
                <a href="javascript:void(0)" id="product-prj-tab" class="product-navBtn f-fl">项目概述</a>
                <a href="javascript:void(0)" id="product-safe-tab" class="product-navBtn f-fl">安全保障</a>
                <a href="javascript:void(0)" id="product-vest-tab" class="product-navBtn f-fl">投资列表</a>
            </section>
            <aside>
                <div id="product-prd" class="pro-dtl-container" style="display: block">
                    <ul class="pro-concept01">
                        <li> <span class="pro-concept-cap">产品概要</span><span class="pro-concept-title">产品名称：</span><span class="pro-concept-data" style="padding-left:35px;">${(pdt.name)!""}</span></li>
                        <li><span class="pro-concept-name">产品类型：</span><span class="pro-concept-data" style="padding-left:35px;">固定收益</span></li>
                        <li><span class="pro-concept-name">产品规模：</span><span class="pro-concept-data" style="padding-left:35px;">${(pdt.totalAmount?c)!""}</span></li>
                        <li><span class="pro-concept-name">产品期限：</span><span class="pro-concept-data" style="padding-left:35px;">${(pdt.durationDesc)!""}</span></li>
                        <li><span class="pro-concept-name">起购金额：</span><span class="pro-concept-data" style="padding-left:35px;">${(pdt.minOrderAmount?c)!""}</span></li>
                    </ul>
                    <ul class="pro-concept02">
                        <li><span class="pro-concept-cap">预期收益</span><span class="pro-concept-title">预期年化收益率：</span><span class="pro-concept-data">${((pdt.expectYieldRate*100)?c)!""}%</span></li>
                        <li><span class="pro-concept-name">起息日：</span><span class="pro-concept-data pro-add-pdl01">T+1</span></li>
                        <li><span class="pro-concept-name">到期日：</span><span class="pro-concept-data pro-add-pdl01">${(pdt.expireDtDesc)!"不支持"}</span></li>
                        <li><span class="pro-concept-name">到期赎回方式：</span><span class="pro-concept-data pro-add-pdl02">${(pdt.pdt_expire_next_step)!"自动赎回"}</span></li>
                    </ul>
                    <div class="pro-concept03">
                        <p><span class="pro-concept-cap">购买准备</span><span class="pro-concept-title">1.注册并实名认证</span></p>
                        <p><span class="pro-concept-name">2.绑定银行卡</span></p>
                        <p><span class="pro-concept-name">3.提前充值，可提高抢购成功率</span></p>
                        <ul class="pro-kind">
                            <li><span class="pro-concept-cap">怎么赎回</span><span class="pro-concept-title">产品到期后, 本金与收益将自动赎回至你的多肉零钱包账户中. 到期前不能</span>
                           
                            </li>
                          <p style="padding-left: 125px;color: #595757">提前赎回</p>
                            <li><p class="pro-back-txt">(注: 本产品存在提前可能性. 若产品提前到期, 本金与实际产品期限内的收益<br/>将提前自动赎回至您的零钱包账户中)</p></li>

                        </ul>
                    </div>

                </div>
                <div id="product-prj" class="pro-dtl-container">
                    <ul class="prj-concept">
                        <li class="prj-content-text">${(pdt.instruction)!""}</li>
                    </ul>
                   
                    </div>
                </div>
                <div id="product-safe" class="pro-dtl-container">
                    <ul class="safe-Protect">
                        <li class="safe-Protect-cap">强强联合</li>
                        <li class="safe-Protect-text">精选优质项目，经由景荣基金旗下的不动产投资管理专业机构--景时夹层基金筛选评估，由Top50地产商操盘开发，通过银行、证券、信托、公募基金、保险公司等金融机构多维度、全方位、多指标的评估</li>
                    </ul>
                    <ul class="safe-Protect">
                        <li class="safe-Protect-cap">资金托管</li>
                        <li class="safe-Protect-text">引入新浪支付托管，实现专款专用，同卡进出，与平台自有资金完全分离；监管机构及时监控，合规透明，拒绝资金池。</li>
                    </ul>
                    <ul class="safe-Protect">
                        <li class="safe-Protect-cap">账户安全</li>
                        <li class="safe-Protect-text">联合实力雄厚的众安财险公司，为您的账户上把安全锁。</li>
                    </ul>
                    <ul class="safe-Protect">
                        <li class="safe-Protect-cap">公开透明</li>
                        <li class="safe-Protect-text">平台产品项目信息详实披露，基础资产、交易对手、资金保障、控制流程、风险要点等一览无余。</li>
                    </ul>
                    <ul class="safe-Protect">
                        <li class="safe-Protect-cap">专业安心</li>
                        <li class="safe-Protect-text">上海锦天城律师事务所受聘为平台常年法律顾问，提供强大的法律支持，监管平台产品，确保合法合规。</li>
                    </ul>
                    <ul class="safe-Protect">
                        <li class="safe-Protect-cap">严格风控</li>
                        <li class="safe-Protect-text">资产由资深、专业金融机构严格筛选、保障资产安全可靠；多重风控手段，为投资者筑起多重安全防线。</li>
                    </ul>
                    <ul class="safe-Protect">
                        <li class="safe-Protect-cap">核心团队</li>
                        <li class="safe-Protect-text">核心成员来自阿里，具有专业的业务能力，丰富的技术研发经验，综合能力强。</li>
                    </ul>
                </div>
                <div id="product-vest" class="pro-dtl-container">
                	<aside class="invest-container">
                    <div class="invest-list">
                    <p class="product-vest-title"> <span class="pv-user">用户</span><span class="pv-money">投资金额（元）</span><span class="pv-time">时间</span>
                    </p>
                    <#if orders??>
                    <#list orders as u>
                    <div class="product-vest-data f-cb"><p class="pv-user-num f-fl">${(u.phone)!""}</p><p class="pv-money-num f-fl">${(u.amount)!""}</p><p class="pv-timenum f-fl">${(u.dt)!""}</p></div>
               		</#list>
               		<#else>
               		<p>没有查询到相应的结果!</p>
               		</#if>
                </div>
               </aside>
                </div>
            </aside>
        </article>
        <div class="pbl-money f-fr">
        <form id="tobuy" action="${base}/pcclient/product/tobuy" method="post" onsubmit="return validateInputMoney();">
        <input type="hidden" name="availableAmount" id="availableAmount" value="${(pdt.availableAmount?c)!""}">
		<input type="hidden" name="pdtId" value="${(pdt.id?c)!""}">
		<input type="hidden" id="maxOrderAmount" value="${(pdt.maxOrderAmount?c)!""}">
		<input type="hidden" id="minOrderAmount" value="${(pdt.minOrderAmount?c)!""}">
		<input type="hidden" id="cycleDay" name="cycleDay" value="${(pdt.durationInMinutes?c)!"0"}">
		<input type="hidden" id="yieldRate" name="yieldRate" value="${((pdt.expectYieldRate*100)?c)!""}">
            <p class="pbl-pocket-txt">零钱包可用余额</p>
			<#if userBalance??>
         <p class="pbl-pocket-des"><span id="pbl-pocket-num" class="pbl-pocket-num">${(userBalance?string("0.00"))!""}</span>元</p> 
     <!--           <p class="pbl-pocket-des"><span id="pbl-pocket-num" class="pbl-pocket-num">423.01</span>元</p> -->
            <#else>
            <p class="pbl-pocket-des"><a class="pbl-pocket-num" href="${base}/pcclient/user/access">请登录</a></p>
            </#if>
            <input id="pbl-money-sum" name="assetBuyMoney" class="pbl-money-sum" placeholder="起购金额100元">

            <p class="pbl-money-hint">预估到期收益：<span id="profit" class="pbl-ben"></span>元</p>

            <p id="pbl-money-error" class="errorMsg"></p>

            <div class="f-cb">
                <button id="pbl-buy-btn" class="pbl-buy-btn f-fl" disabled="disabled" style="display: block">立即购买</button>
                <a id="pbl-recharge-btn" href="${base}/pcclient/finance/rechargePage" class="pbl-recharge-btn f-fl" disabled="disabled">充值</a>
                <a href="javascript:;" id="pbl-all-invest" class="pbl-all-invest f-fl">全投</a>
            </div>
            <!--<input type="checkbox" id="pro-read-ckbox" class="pro-read-ckbox" checked="checked">-->
            <!--<i class="pbl-promise">我已阅读并同意-->
                <!--<a href="../../Contract/ftls/productContract.html" class="pbl-contract01">《产品合同》</a>-->
                <!--<a href="../../Contract/ftls/platform_Agreement.html" class="pbl-contract02">《平台购买协议》</a>-->
            <!--</i>-->
            </form>
        </div>
    </section>

</article>

<!---------------- footer区域---------------->
<#include "../public/footer.ftl" >

</body>
</html>






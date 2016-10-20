<!DOCTYPE html>
<html>
<head lang="en">
    	<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/Public/css/nice-select.css">
    <link rel="stylesheet" type="text/css" href="${base}/static/Account/css/index.css">
    <script type="text/javascript" src="${base}/static/Public/js/jquery-ui.js"></script>
    <script src="${base}/static/Public/js/jquery-ui-datepicker-zh-CN.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="${base}/static/Public/css/jquery-ui.css">
    <script src="${base}/static/Public/js/jquery.nice-select.min.js"></script>
   	<script type="text/javascript" src="${base}/static/Public/js/laypage/laypage.js"></script>
   	<script src="${base}/static/Account/js/userAccount.js"></script>
	${script!}
    <title>多肉-我的资产|http://www.51doro.com-白领阶层互联网资产管理专家</title>
    <script type="text/javascript">
        $(function () {
            var rightHeight = $(".user-detail").height();
            $(".user-nav-list").css("height", rightHeight + 'px');
        });
    </script>
</head>
<body>
<#include "../public/header_asset.ftl" >
<article id="main" class="mid-Container f-index-dline f-cb">
    <!--<aside class="user-nav-list f-fl" style="height: 1168px!important;">-->
   <aside class="user-nav-list f-fl">
        <div class="user-nav-Btn f-cb">
            <p class="user-nav-mid f-fl ">
                <img src="${base}/static/Public/images/asset_sideline_grey.png" class="user-asset-icon">
                <span><a href="${base}/pcclient/account/userAsset" class="user-nav-link">我的资产</a></span>
            </p>

            <p class="user-nav-right f-fl"></p>
        </div>
        <div class="user-nav-Btn f-cb">
            <p class="user-nav-mid user-active-tab f-fl" style="padding-right: 15px;">
                <img src="${base}/static/Public/images/account_sideline_red.png" class="user-account-icon">
                <span><a href="${base}/pcclient/account/userAccount" class="user-nav-link" style="color: #e74d46">零钱包</a></span>
            </p>

            <p class="user-nav-right f-fl"></p>
        </div>
        <div class="user-nav-Btn f-cb">
            <p class="user-nav-mid f-fl">
                <img src="${base}/static/Public/images/finance_sideline_grey.png" class="user-asset-icon">
                <span><a href="${base}/pcclient/account/userFinance" class="user-nav-link">我的理财</a></span>
            </p>

            <p class="user-nav-right f-fl"></p>
        </div>
        <div class="user-nav-Btn f-cb">
            <p class="user-nav-mid f-fl">
                <img src="${base}/static/Public/images/ticket_sideline_grey.png" class="user-ticket-icon">
                <span><a href="${base}/pcclient/account/userTicket" class="user-nav-link">我的福利</a></span>
            </p>

            <p class="user-nav-right f-fl"></p>
        </div>
        <div class="user-nav-Btn f-cb">
            <#if isRead==0>
            	<p class="user-msg-point">●</p>
	        <#else>
	        	<p class="user-msg-point"></p>
	        </#if>
            <dl class="f-cb">
            <p class="user-msg-mid f-fl">
                <img src="${base}/static/Public/images/sms_sideline_grey.png" class="user-msg-icon">
                <span><a href="${base}/pcclient/account/info" class="user-nav-link">我的消息</a></span>
            </p>

            <p class="user-msg-right f-fl"></p>
            </dl>
        </div>
        <div class="user-nav-Btn f-cb">
            <p class="user-nav-mid f-fl">
                <img src="${base}/static/Public/images/safe_sideline_grey.png" class="user-asset-icon">
                <span><a href="${base}/pcclient/safeCenter/safeGuard" class="user-nav-link">安全设置</a></span>
            </p>

            <p class="user-nav-right f-fl"></p>
        </div>
    </aside>
    <section class="user-detail f-fl">
    <#if withdrawSuccess??>
        <div class="withdraw_status">
	        	<#if withdrawSuccess=="true">
		            <p class="wd-win">
		                <img src="${base}/static/Public/images/success_Big.png" class="wd-statImg">
		                <span>取现成功!</span></p>
				<#else>
		            <div class="wd-lose">
		                <p class="f-fl">
		                <img src="${base}/static/Public/images/fail_Big.png" class="wd-statImg">
		                <span id="reason">取现失败!</span>
		                </p>
		           
		                <ul class="f-fr">
		                    <li>您可以与我们的客服取得联系 400-820-0699</li>
		                    <li>周一至周五 09:00 - 18:00</li>
		                </ul>
            </div>
            </#if>
        </div>
        </#if>
        <#if chargeSuccess??>
        <div class="recharge_status">
        		<#if chargeSuccess=="true">
		            <p class="rc-win">
		                <img src="${base}/static/Public/images/success_Big.png" class="wd-statImg">
		                <span>充值成功!</span></p>
				<#else>
		            <div class="rc-lose">
		                <p class="f-fl">
		                    <img src="${base}/static/Public/images/fail_Big.png" class="wd-statImg">
		                    <span>充值失败!</span>
		                </p>
		         
		                <ul class="f-fr">
		                    <li>您可以与我们的客服取得联系 400-820-0699</li>
		                    <li>周一至周五 09:00 - 18:00</li>
		                </ul>
            </div>
            </#if>
        </div>
        </#if>
		<article id="user-index" class="user-index" style="height: 1031px;">
	        <div class="ua-accountBox f-cb">
	            <ul class="account-money f-fl">
	                <li class="account-money-num">${availableBalance?string("0.00")}</li>
	                <li class="account-money-des">零钱包余额</li>
					<div class="f-cb">
		                <a href="${base}/pcclient/finance/rechargePage" class="add-money-btn f-fl">充值</a>
		                <a href="${base}/pcclient/finance/withdrawPage" class="get-money-btn f-fr">取现</a>
					</div>
	            </ul>
	            <p class="splitLine f-fl"></p>
	            <ul class="onroute-money f-fl">
	                <li class="onroute-money-num">${inTransitBalance?string("0.00")}</li>
	                <li class="onroute-money-des">在途资金(元)</li>
	            </ul>
	            <ul class="frozen-money f-fl">
	                <li class="frozen-money-num">${frozenBalance?string("0.00")}</li>
	                <li class="frozen-money-des">冻结资金(元)</li>
	            </ul>
	        </div>
        <div class="ua-accountBox2 f-cb">
            <ul class="account-all-num f-fl">
                <p class="ua-account-num">${totalPurseYield?string("0.00")}</p>

                <p class="ua-account-txt">累计收益(元)</p>
            </ul>
            <ul class="account-yest-num f-fl">
                <p class="ua-account-num">${yesterdayPurseYield?string("0.00")}</p>

                <p class="ua-account-txt">昨日收益(元)</p>
            </ul>
            <p class="ua-vertline f-fl"></p>
            <ul class="account-wan-num f-fl">
            <#if yieldMap??>
                <p class="ua-account-num">${yieldMap.logSina_net_float?string("0.0000")}元</p>
            <#else>
            	<p class="ua-account-num">0.0000元</p>
			</#if>
                    <p class="ua-account-txt">每万份收益(元)</p>
            </ul>
            <ul class="account-seven-num f-fl">
            <#if yieldMap??>
                <p class="ua-account-num">${yieldMap.logSina_7days_yield_rate?string("0.0000")}</p>
            <#else>
            	<p class="ua-account-num">0.0000</p>
			</#if>
                <p class="ua-account-txt">七日年化收益率(%)</p>
            </ul>
        </div>
        <div class="ua-accountBox3">
            <p class="account-record-title">零钱包&nbsp;&nbsp;交易明细</p>
            <ul class="account-record-option f-cb">
                <i class="abo-date f-fl">
                        <a href="javascript:void(0)" id="abo-short-term" class="abo-short-term">最近两周</a>
                        <a href="javascript:void(0)" id="abo-long-term" class="abo-long-term">最近一个月</a>
                </i>
				
                    <div class="ab-fromDiv f-fl">
                        <span class="abo-from-txt">起始日</span>
                        <input type="text" id="abo-from-input" class="ui_timepicker">
                    </div>
                    <div class="ab-toDiv f-fl">
                        <span class="abo-to-txt">截止日</span>
                        <input type="text" id="abo-to-input" class="ui_timepicker">
                    </div>
                </ul>
                <input type="hidden" id="pageCount" name="pageCount" value="${(pageCount?c)!""}">
                 <div id="refresh">
                 	<#include "./accountRefresh.ftl">
                 </div>
                  <aside id="acc-page-number" class="acc-page-number"></aside>


            </div>
        </article>
    </section>
</article>
<#include "../public/footer.ftl" >
</body>
</html>
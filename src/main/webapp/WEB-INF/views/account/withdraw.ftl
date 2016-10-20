<!DOCTYPE html>
<html>
<head lang="en">
    	<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/Account/css/index.css">
    <script type="text/javascript" src="${base}/static/Account/js/withdraw.js"></script>
	   ${script!}
    <title>多肉-我的资产|http://www.51doro.com-白领阶层互联网资产管理专家</title>
    <script type="text/javascript">
        $(function () {
            var rightHeight = $(".user-detail").height();
            $(".user-nav-list").css("height", rightHeight + 'px');
            btnColorChange("withdraw-btn","#df4f4b","#cc3a3a");
        
        });
    </script>
</head>
<body>
<#include "../public/header_asset.ftl" >
<article id="main" class="mid-Container f-cb f-index-dline">
    <aside class="user-nav-list f-fl">
        <div class="user-nav-Btn f-cb">
            <p class="user-nav-mid f-fl ">
                <img src="${base}/static/Public/images/asset_sideline_grey.png" class="user-asset-icon">
                <span><a href="${base}/pcclient/account/userAsset" class="user-nav-link">我的资产</a></span>
            </p>

            <p class="user-nav-right f-fl"></p>
        </div>
        <div class="user-nav-Btn  f-cb">
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
<article class="user-detail f-fl">
    <section class="withdrawDiv">
        <img src="${base}/static/Public/images/bank_logo/${userBank_code}_logo.png" class="wd-bank-logo">
            <p class="wd-card">${userBank_account}</p>

            <p class="wd-name">${userRealname}</p>
        <hr class="wd-firstline">
        
        <p class="withdraw-money">
            <span class="wm-desc">零钱包余额:</span>
            <span class="wm-num">${userBalance?string("0.00")}</span>
        </p>
		<input type="text" id="amount" class="withdrawNum" placeholder="取现金额">
            <p id="wd-inputNum-error" class="errorMsg"></p>

        <input type="password" class="withdraw-psw" id="withdraw-psw" placeholder="交易密码">
            <p id="wd-psw-error" class="errorMsg"></p>
        <button onClick="withdraw()" class="withdraw-btn">取现</button>
    </section>
    <section class="wd-bottom-text">
        <p>单笔取现限额为5万，单日累计取现限额为50万。</p>
        <p>15:00之前发起的取现，一个工作日内到账。</p>
        <p>15:00以后发起的取现，两个工作日内到账。</p>
    </section>
</article>
</article>
<#include "../public/footer.ftl" >
</body>
</html>
<!DOCTYPE html>
<html>
<head lang="en">
	<#include "../public/public_head.ftl" >
    <META HTTP-EQUIV="pragma" CONTENT="no-cache"> 
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"> 
	<META HTTP-EQUIV="expires" CONTENT="0">
    <link rel="stylesheet" type="text/css" href="${base}/static/safeCenter/css/safeCenter.css">
    <script type="text/javascript" src="${base}/static/safeCenter/js/exchangeBind-Step1.js"></script>
    <title>多肉-我的资产|http://www.51doro.com-白领阶层互联网资产管理专家</title>
    <script type="text/javascript">
        $(function () {
            var rightHeight = $(".user-detail").height();
            $(".user-nav-list").css("height", rightHeight + 'px');
            btnColorChange("eb-withdraw","#df4f4b","#cc3a3a");
            $("#eb-password").on("input", function (event) {
                var element = event.target;
                tranPsw = event.target.value;
                validateTransactPsw(element,"eb-psw-error","请设置6位数字交易密码");
            });
            $("#eb-phoneNum").on("input", function (event) {
                var element = event.target;
                validatePhoneNum(element,"eb-phoneNum-error","请输入正确的手机号码");
            });
            
            $("#amount").bind("click", function () {
		        var num = $("#eb-balance").text();
		        $("#eb-depositMoney").val(num);
    		});
        });
    </script>
	 ${script!}
</head>
<body>

<#include "../public/header_asset.ftl" >
<article id="main" class="mid-Container f-index-dline f-cb">
    <aside class="user-nav-list f-fl">
        <div class="user-nav-Btn f-cb">
            <p class="user-nav-mid f-fl ">
                <img src="${base}/static/Public/images/asset_sideline_grey.png" class="user-asset-icon">
                <span><a href="${base}/pcclient/account/userAsset" class="user-nav-link">我的资产</a></span>
            </p>

            <p class="user-nav-right f-fl"></p>
        </div>
        <div class="user-nav-Btn  f-cb">
            <p class="user-nav-mid f-fl" style="padding-right: 15px;">
                <img src="${base}/static/Public/images/account_sideline_grey.png" class="user-account-icon">
                <span><a href="${base}/pcclient/account/userAccount" class="user-nav-link">零钱包</a></span>
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
            <p class="user-msg-point">●</p>
            <dl class="f-cb">
             <p class="user-msg-mid f-fl">
                <img src="${base}/static/Public/images/sms_sideline_grey.png" class="user-msg-icon">
                <span><a href="${base}/pcclient/account/info" class="user-nav-link">我的消息</a></span>
            </p>

                <p class="user-msg-right f-fl"></p>
            </dl>
        </div>
        <div class="user-nav-Btn f-cb">
            <p class="user-nav-mid user-active-tab f-fl">
                <img src="${base}/static/Public/images/safe_sideline_red.png" class="user-asset-icon">
                <span><a href="${base}/pcclient/safeCenter/safeGuard" class="user-nav-link" style="color: #e74d46">安全设置</a></span>
            </p>

            <p class="user-nav-right f-fl"></p>
        </div>
    </aside>
    <section class="user-detail f-fl">
        <p class="eb-title">换绑银行卡</p>
	<div class="f-cb" style="padding-left: 45px;">
        <a href="javascript:void(0)" class="eb-step-tab f-fl" style="background: #e74d46">步骤1.取现</a>
        <a href="javascript:void(0)" class="eb-step-tab f-fl">步骤2.换绑</a>
	</div>
        <div class="exchangeCardDiv">
			<img src="${base}/static/Public/images/bank_logo/${userBank_code}_logo.png" class="eb-bank-logo">
            <p class="eb-cardNum">${userBank_account}</p>

            <p class="eb-cardName">${userRealname}</p>
            <hr class="eb-firstline">
 			<p id="eb-balance" class="eb-accountNum">${userBalance?string("0.00")}</p>  
 		<!--		<p id="eb-balance" class="eb-accountNum">321.912</p>-->
            <p class="eb-accountName">零钱包余额（元）</p>
			<p class="eb-accountNum">${userFrozen?string("0.00")}</p>
			<p class="eb-accountName">冻结资金（元）</p>
            <div class="f-cb">
                <input type="text" id="eb-depositMoney" class="eb-depositMoney f-fl" placeholder="取现金额" autocomplete="off">
                <input id="amount" type="button" class="eb-allMoney f-fl" value="全款">
            </div>
            
            <#if userFrozen?? && (userFrozen > 0)>
            	<script type="text/javascript">
            	$(function(){
            		$("#eb-msgCode-error").css("visibility","visible");
            	})
            	
            	</script>
            	<p id="eb-msgCode-error" class="errorMsg">冻结资金：${userFrozen},未清零，无法换绑!!!</p>
			</#if>
			    <p id="eb-money-error" class="errorMsg"></p>
            <input id="tradePwd" type="password" id="eb-password" class="eb-password" placeholder="交易密码">
            <p id="eb-psw-error" class="errorMsg"></p>
            <a href="javascript:withdraw()" class="eb-withdraw f-fl">取现</a>
        </div>
         
			<aside class="eb-withdraw-area">
				<p>单笔取现限额为5万，单日累计取现限额为50万。</p>
                <p>15:00之前发起的取现，一个工作日内到账。</p>
                <p>15:00以后发起的取现，两个工作日内到账。</p>
        </aside>
    </section>
</article>
<#include "../public/footer.ftl" >
</body>
</html>
<!DOCTYPE html>
<html>
<head lang="en">
   	<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/Account/css/index.css">
    <script type="text/javascript" src="${base}/static/Account/js/recharge.js"></script>
    <title>多肉-我的资产|http://www.51doro.com-白领阶层互联网资产管理专家</title>
      ${script!}
    <script type="text/javascript">
        $(function () {
            var rightHeight = $(".user-detail").height();
            $(".user-nav-list").css("height",rightHeight+'px');
  			btnColorChange("recharge_Btn","#df4f4b","#cc3a3a");
            $("#rc-phoneNum").on("input", function (event) {
                var element = event.target;
                validatePhoneNum(element,"rc-phoneNum-error","请输入正确的手机号码");
            });
            $("#rc-restrict").click(function(){
                $("#rc-maxInvest").toggle();
                var newHeight = $(".user-detail").height();
                $(".user-nav-list").css("height",newHeight+'px');
            });
               $("#texting").on("input", function (event) {
                var element = event.target;
                validateMsgCode(element,"rc-msgCode-error","验证码只能是4位或6位数字");
        		});
        })
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
    	<div class="f-cb user-rc-tabs">
            <a href="javascript:;" class="identify-pay red-tab f-fl">认证支付</a>
            <a href="${base}/pcclient/finance/bankRechargePage" class="netSilver-pay f-fl">网银支付</a>
        </div>
        <section class="rechargeDiv">
			<img src="${base}/static/Public/images/bank_logo/${userBank_code}_logo.png" class="rc-bank-logo">

                <p class="rc-card">${userBank_account}</p>
            
            <p class="rc-name">${userRealname}</p>
            <hr class="rc-firstline">
            <input type="text" placeholder="充值金额" id="rechargeNum" class="rechargeNum">
            <p id="rc-inputNum-error" class="errorMsg"></p>
            <div class="f-cb">
                <input id="chargeRand" type="text" class="rc-verifyCode f-fl" placeholder="验证码">
                <img id="randimg" src="${base}/authImage/image" class="rc-codeStyle f-fr" onclick="refreshRand('randimg')">
            </div>
            <p id="rc-picCode-error" class="errorMsg"></p>
            <div class="f-cb">
            	<input type="hidden" id="ticket">
                <input id="texting" type="text" class="rc-msgCode f-fl" placeholder="短信验证码">
                <input type="button" id="rc-gainCode" class="rc-gainCode f-fr" value="获取验证码" onclick="rechargeText('rc-gainCode','rc-msgCode-error','手机号不能为空','chargeRand')"/>
            </div>
            <p id="rc-msgCode-error" class="errorMsg"></p>
            <input type="password" placeholder="交易密码" id="transactPsw" class="transactPsw">
			<p id="rc-psw-error" class="errorMsg"></p>
            <button onclick="rechargeVerify()" id="recharge_Btn" class="recharge_Btn">充值</button>
        </section>
        <section class="rc-bottom-text">
            <p>零钱包余额及冻结金额由新浪支付托管，安全有保障。</p>

            <p>托管期内产生的零钱包(货币基金)收益归您所有。</p>
            <a href="javascript:void(0)" id="rc-restrict" class="rc-restrict">查看限额表</a>
        </section>
        <hr class="rc-bottom-line">
        <aside id="rc-maxInvest" class="rc-maxInvest">
            <p class="rc-bottom-title">限额表</p>

            <div class="rc-lookup">
                <p class="rc-lookup-title">
                    <span class="rc-lp-tname">银行</span>
                    <span class="rc-lp-tnum">单笔限额</span>
                    <span class="rc-lp-tday">每日限额</span>
                </p>
                <ul class="rc-bank-data">
                 
                    <#list bankList as b>
	                    <li class="rc-each-data f-cb">
	                        <p class="rc-lp-dname f-fl">${b.limitBank_name}</p>
	                        <p class="rc-lp-dnum f-fl">${b.limitSingle_limit}</p>
	                        <p class="rc-lp-dday f-fl">${b.limitDay_limit}</p>
	                    </li>
                    </#list>
                </ul>
            </div>
        </aside>
    </article>
    </section>
</article>
<#include "../public/footer.ftl" >
</body>
</html>
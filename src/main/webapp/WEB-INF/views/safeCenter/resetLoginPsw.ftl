<!DOCTYPE html>
<html>
<head lang="en">
    	<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/safeCenter/css/safeCenter.css">
    <script type="text/javascript" src="${base}/static/safeCenter/js/resetLoginPsw.js"></script>
    <title>多肉-我的资产|http://www.51doro.com-白领阶层互联网资产管理专家</title>
    <script type="text/javascript">
        $(function () {
            var rightHeight = $(".user-detail").height(),
                 loginPsw = '';
            $(".user-nav-list").css("height", rightHeight + 'px');
            btnColorChange("rlp-submit","#df4f4b","#cc3a3a");
            $("#rlp-pwd").on("input", function (event) {
                var element = event.target;
                loginPsw = event.target.value;
                validatePassword(element,"rlp-setPsw-error","密码为6-10位字符");
            });
            $("#rlp-confirmPsw").on("input", function (event) {
                var element = event.target;
                validateSecondPsw(element,loginPsw,"rlp-doublePsw-error","两次输入的密码不符");
            });
            $("#rlp-phoneNum").on("input", function (event) {
                var element = event.target;
                validatePhoneNum(element,"rlp-phoneNum-error","请输入正确的手机号码");
            });
              $("#texting").on("input", function (event) {
                var element = event.target;
                validateMsgCode(element,"rlp-msgCode-error","验证码只能是4位或6位数字");
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
    <article class="rlp-contentWrap">
        <p class="rlp-title">修改登录密码</p>

	<div class="rlp-resetLPswDiv">
	<#if userTelephone != "">
        <input type="text" value="${userTelephone}" disabled="disabled" id="rlp-phoneNum" class="rlp-phoneNum" placeholder="手机号">
     <#else>
     	<input type="text" id="rlp-phoneNum" class="rlp-phoneNum" placeholder="手机号">
      </#if>
      <p id="rlp-phoneNum-error" class="errorMsg"></p>
    <div class="f-cb">
         <input id="resetLoginRand" type="text" class="rlp-verifyCode f-fl" placeholder="验证码">
         <img id="resetLogin" src="${base}/authImage/image" class="rlp-codeStyle f-fr" onclick="refreshRand('resetLogin')">
    </div>
    <p id="rlp-picCode-error" class="errorMsg"></p>
        <div class="f-cb">
        	<input type="hidden" id="ticket">
        	<input type="hidden" id="tpl" value="resetLoginPwd">
            <input type="text" id="texting" class="rlp-msgCode f-fl" placeholder="短信验证码">
            <input type="button" id="rlp-gainCode" class="rlp-gainPsw f-fr" value="获取验证码" onclick="sendMessage('rlp-phoneNum','rlp-gainCode','rlp-msgCode-error','手机号不能为空','tpl','resetLoginRand')"/>
          
        </div>
		<p id="rlp-msgCode-error" class="errorMsg"></p>
                <input type="password" id="rlp-pwd" class="rlp-password" placeholder="密码">
		<p id="rlp-setPsw-error" class="errorMsg"></p>
                <input type="password" id="rlp-confirmPsw" class="rlp-confirmPsw" placeholder="请再次输入密码">
		<p id="rlp-doublePsw-error" class="errorMsg"></p>
        <a href="javascript:resetPwd()" class="rlp-submit f-fl">确定</a>
            </div>
        </article>
    </section>
</article>
<#include "../public/footer.ftl" >
</body>
</html>
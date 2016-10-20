<!DOCTYPE html>
<html>
<head lang="en">
   	<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/User/css/user-center.css">
    <script type="text/javascript" src="${base}/static/User/js/bindCard.js"></script>
    <script type="text/javascript" src="${base}/static/Public/js/jquery-ui.js"></script>
    <link rel="stylesheet" type="text/css" href="${base}/static/Public/css/jquery-ui.css">
	   ${script!}
    <title>多肉-绑定银行卡|http://www.51doro.com-白领阶层互联网资产管理专家</title>
</head>
<body>
<#include "../public/header_default.ftl" >
<article class="identification-Container">
<div class="setbindCardDiv">
<section class="user-bindCard-window">
        <p class="user-idTitle">绑定银行卡</p>
    <input type="text" id="user-bindCard-name" class="user-bindCard-name" placeholder="姓名">
    <!--<input type="text" id="user-bindCard-id" class="user-bindCard-id" placeholder="身份证号">-->
    <div class="eb-card-area f-cb">
    <select name="province" id="province"
							onchange="onSelectChange(this,'#city');" datatype="*"
							nullmsg="所在省份" class="eb-province">
							 <option value="" selected="selected">省份</option>
						</select>
	<select name="city" id="city"
							 datatype="*" nullmsg="所在城市！" class="eb-city">
							 <option value="" selected="selected">城市</option>
						</select>
    </div>
    <div class="eb-bankname">
    <select name="bankCode" id="bankCode" class="eb-sel-bname" onchange="onSelectChange(this,'#county');"
							 datatype="*">
								<option value="" selected="selected">银行名称</option>
								<#list bankList as b>
									<option value="${b.bankCode}">${b.bankName}</option>
								</#list>
						</select>
    </div>
    <input type="text" id="bankCardNumber" class="user-bindCard-bankCard" placeholder="银行卡号">
    <input type="text" id="user-bindCard-phoneNum" class="user-bindCard-phoneNum" placeholder="银行预留手机号">
    <p id="bank-phoneNum-error" class="identify-errorMsg"></p>
    <div class="f-cb uya">
         <input id="bandrand" type="text" class="bindcard-verifyCode f-fl" placeholder="验证码">
         <img id="bandimg" src="${base}/authImage/image" class="bindcard-codeStyle f-fr" onclick="refreshRand('bandimg')">
    </div>
    <p id="bindcard-picCode-error" class="identify-errorMsg"></p>
    <div class="f-cb uya">
    	<input type="hidden" id="ticket">
        <input type="text" id="texting" class="ubc-msgCode f-fl" placeholder="短信验证码">
        <input type="button" id="ubc-gainCode" class="ubc-gainCode f-fr" value="获取验证码" onclick="bankSendText('user-bindCard-phoneNum','ubc-gainCode','user-ubw-error','手机号不能为空','bandrand')"/>
    </div>
   <p id="user-ubw-error" class="identify-errorMsg"></p>
    <div class="uit-agreeDiv">
        <input type="checkbox" id="checkbox-1-2" class="uit-checkbox f-fl" checked="checked"/><label for="checkbox-1-2" style="margin-top: 7px;"></label>
            <span class="uit-agreement">我已阅读并同意<a href="${base}/agreement/agreement/5" class="agreement">《快捷支付服务协议》</a></span>
    </div>
    <a href="javascript:checkTexting()" class="uit-confirm">绑卡</a>
    <p class="ubc-remind">账户资金由新浪支付托管, 安全可靠</p>
</section>
</div>
</article>
<#include "../public/footer.ftl" >
</body>
</html>
<!DOCTYPE html>
<html>
<head lang="en">
    	<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/User/css/user-center.css">
    <script type="text/javascript" src="${base}/static/User/js/resetPsw.js"></script>
     <title>多肉-重设登录密码|http://www.51doro.com-白领阶层互联网资产管理专家</title>
   <script>
        $(function () {
            btnColorChange("urw-submit","#df4f4b","#cc3a3a");
            $("#urw-phoneNum").on("input", function (event) {
                var element = event.target;
                validatePhoneNum(element,"urw-phoneNum-error","请输入正确的手机号码");
            });
            $("#password").on("input", function (event) {
                var element = event.target;
                loginPsw = event.target.value;
                validatePassword(element,"rlp-setPsw-error","密码为6-10位字符");
            });
            $("#checkpwd").on("input", function (event) {
                var element = event.target;
                validateSecondPsw(element,loginPsw,"rlp-doublePsw-error","两次输入的密码不符");
            });
           	$("#texting").on("input", function (event) {
                var element = event.target;
                validateMsgCode(element,"rlp-msgCode-error","验证码只能是4位或6位数字");
            });
        })
    </script>
	   ${script!}
</head>
<body>
<#include "../public/header_default.ftl" >
<article class="identification-Container">
    <div class="resetPswDiv">
    <section class="user-reset-window">
            <p class="user-idTitle">找回登录密码</p>
        <input type="text" id="urw-phoneNum" class="urw-phoneNum" placeholder="手机号">
        <p id="urw-phoneNum-error" class="errorMsg" style="text-indent: 7.5%;"></p>
        <div class="f-cb rp-picDiv">
            <input id="resetLoginRand" type="text" class="rp-verifyCode f-fl" placeholder="验证码">
            <img id="resetLogin" src="${base}/authImage/image" class="rp-codeStyle f-fr" onclick="refreshRand('resetLogin')">
        </div>
    	<p id="rp-picCode-error" class="errorMsg"></p>
        <div class="f-cb uya">
        	<input type="hidden" id="ticket">
        	<input type="hidden" id="tpl" value="resetLoginPwd">
            <input type="text" id="texting" class="ubc-msgCode f-fl" placeholder="短信验证码">
            <input type="button" id="urw-gainCode" class="ubc-gainCode f-fr" value="获取验证码" onclick="sendMessage('urw-phoneNum','urw-gainCode','input-msgCode-error','手机号为空','tpl','resetLoginRand')"/>
         
        </div>
        <p id="rlp-msgCode-error" class="errorMsg" style="text-indent: 7.5%;"></p>
        <input type="password" id="password" class="urw-password" placeholder="密码">
        <p id="rlp-setPsw-error" class="errorMsg" style="text-indent: 7.5%;"></p>
        <input type="password" id="checkpwd" class="urw-confirmPsw" placeholder="请再次输入密码">
        <p id="rlp-doublePsw-error" class="errorMsg" style="text-indent: 7.5%;"></p>
        <a href="javascript:reSetPwd()" class="urw-submit f-fl">确认</a>
    </section>
		    </div>
</article>
    <#include "../public/footer.ftl" >
</body>
</html>
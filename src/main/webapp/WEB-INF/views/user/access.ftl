<!DOCTYPE html>
<html>
<head lang="en">
		<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/User/css/user-center.css">
    <script type="text/javascript" src="${base}/static/User/js/access.js"></script>
	    ${script!}
    <title>多肉-登录注册|http://www.51doro.com-白领阶层互联网资产管理专家</title>
</head>
<body style="background: #eee;">
<#include "../public/header_default.ftl" >
<article class="mid-Container">
<section class="user-access-container f-cb">
 <div class="ua-flash-area f-fl">
    <p class="user-access-title">用户登录</p>

        <img src="${base}/static/Public/images/access_Bg_02.png" class="ua-feature-img">
		</div>
        <article class="uaer-access-window f-fl">
            <p class="uaw-tabs f-cb">
	                <a href="javascript:void(0)" id="login-container-tab" class="uaw-login-tab access-activeTab f-fl">登录</a>
	                <a href="javascript:void(0)" id="reg-container-tab" class="uaw-reg-tab f-fr">注册</a>
            </p>

            <div class="uaw-contentArea">
                <form action="" method="post" id="login-container" class="uaw-log-container">
                    <input type="text" id="log-phoneNum" class="log-phoneNum" placeholder="手机号码">
                    <p id="log-phoneNum-error" class="errorMsg"></p>
                    <input type="password" id="log-loginPsw" class="log-loginPsw" placeholder="登录密码">
                    <p id="log-loginPsw-error" class="errorMsg"></p>
                     <div class="f-cb">
                        <input id="loginRand" type="text" class="log-verifyCode f-fl" placeholder="验证码">
                        <img id="randimg" src="${base}/authImage/image" class="log-codeStyle f-fr" onclick="refreshRand('randimg')">
                    </div>
                    <p id="log-picCode-error" class="reg-errorMsg"></p>
                    <a href="javascript:loginCheck()" id="loginBtn" class="loginBtn">登录</a>
                    <dd class="log-hint f-cb">
                        没有账号？<a href="javascript:void(0)" id="log-free-reg" class="log-free-reg">免费注册</a>
                        <a href="${base}/pcclient/user/resetPwd" class="log-find-psw f-fr">忘记密码？</a>
                    </dd>
                </form>
                <form action="" method="post" id="reg-container" class="uaw-reg-container" style="display: none">
                    <input type="text" id="reg-phoneNum" class="reg-phoneNum" placeholder="用户名 请输入您的手机号码">
                    <p id="reg-phoneNum-error" class="reg-errorMsg"></p>
                    <input type="password" id="reg-loginPsw" class="reg-loginPsw" placeholder="密码">
                    <p id="reg-loginPsw-error" class="reg-errorMsg"></p>
                    <input type="password" id="reg-confirmPsw" class="reg-loginPsw" placeholder="确认密码">
                    <p id="reg-confirmPsw-error" class="reg-errorMsg"></p>
                    <input type="text" id="recommend-phoneNum" class="reg-phoneNum" placeholder="推荐人手机号码(选填)">
                    <p id="recommend-phoneNum-error" class="reg-errorMsg"></p>
                     <div class="f-cb">
                        <input type="text" id="regRand" class="reg-verifyCode f-fl" placeholder="验证码">
                        <img id="regimg" src="${base}/authImage/image" class="codeStyle f-fr" onclick="refreshRand('regimg')">
                    </div>
                    <p id="reg-picCode-error" class="reg-errorMsg"></p>
                    <div class="f-cb">
                    	<input type="hidden" id="ticket">
                        <input type="hidden" id="tpl" value="login">
                        <input type="text" id="texting" class="reg-msgCode f-fl" placeholder="短信验证码">
                        <input type="button" id="reg-gainCode" class="reg-gainCode f-fr" value="获取验证码" onclick="sendMessage('reg-phoneNum','reg-gainCode','reg-msgCode-error','手机号为空','tpl','regRand')"/>

                    </div>
					<p id="reg-msgCode-error" class="reg-errorMsg"></p>
                    <div class="agreeDiv">
                        <input type="checkbox" id="checkbox-1-2" class="reg-radio f-fl" checked="checked"/><label for="checkbox-1-2"></label>
                        <span class="agreementSpan">我已阅读并同意<a href="${base}/agreement/agreement/1" class="agreement">《多肉理财平台注册协议》</a></span>
                    </div>
                    <a href="javascript:register()" class="registerBtn">注册</a>

                    <p class="reg-hint">已有账户？<a href="javascript:void(0)" id="reg-to-login"
                        class="reg-to-login">登录</a></p>
                </form>
            </div>
        </article>
        <p class="ua-copyright">2016©Copyright  www.51doro.com     沪ICP备 15034803号-2</p>
    </section>
</article>
<#include "../public/footer.ftl" >
</body>
</html>
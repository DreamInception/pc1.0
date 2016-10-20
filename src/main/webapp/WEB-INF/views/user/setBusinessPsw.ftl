<!DOCTYPE html>
<html>
<head lang="en">
    	<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/User/css/user-center.css">
    <script type="text/javascript" src="${base}/static/User/js/setBusinessPsw.js"></script>
   <title>多肉-设置交易密码|http://www.51doro.com-白领阶层互联网资产管理专家</title>
   ${script!}
</head>
<body>
<#include "../public/header_default.ftl" >
<article class="identification-Container">
<div class="setBusinessPswDiv" id="setBusinessPsw" >
<section class="user-bpsw-window">
        <p class="user-idTitle">设置交易密码</p>
    <input type="password" id="user-first-password" class="user-first-password" placeholder="交易密码">
    <p id="user-fpsw-error" class="identify-errorMsg"></p>
    <input type="password" id="user-second-password" class="user-second-password" placeholder="再次输入交易密码">
    <p id="user-spsw-error" class="identify-errorMsg"></p>
    <div class="uit-agreeDiv">
        <input type="checkbox" id="checkbox-1-2" class="uit-checkbox f-fl" checked="checked"/><label for="checkbox-1-2" style="margin-top: 7px;"></label>
            <span class="uit-agreement">我同意<a href="../../Contract/ftls/platform_Agreement.html" class="agreement">《多肉理财平台服务协议》</a></span>
    </div>
    <a href="javascript:setTransactPwd()" class="uit-confirm">确认</a>
</section>

</div>
</article>
<#include "../public/footer.ftl" >
</body>
</html>
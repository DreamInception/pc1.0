<!DOCTYPE html>
<html>
<head lang="en">
    	<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/User/css/user-center.css">
    <script type="text/javascript" src="${base}/static/User/js/identification.js"></script>
     <title>多肉-身份信息验证|http://www.51doro.com-白领阶层互联网资产管理专家</title>
    <script>
        $(function () {
            btnColorChange("uit-confirm","#df4f4b","#cc3a3a");
            $("#uit-number").on("input", function (event) {
                var element = event.target;
                validateIDNumber(element,"uit-number-error","输入的身份证号长度不对，或者号码不符合规定！");
            });

        })
    </script>
		   ${script!}
</head>
<body>
<#include "../public/header_default.ftl" >

<article class="identification-Container">
<div class="identificationDiv">
    <section class="user-identity-window">
        <p class="user-idTitle" style="font-weight: lighter;">身份信息验证</p>
        <input type="text" id="uit-name" class="uit-name" placeholder="姓名">
        <p id="uit-name-error" class="identify-errorMsg"></p>
        <input type="text" id="uit-number" class="uit-number" placeholder="身份证号码">
        <p id="uit-number-error" class="identify-errorMsg"></p>
        <div class="uit-agreeDiv">
            <input type="checkbox" id="checkbox-1-2" class="uit-checkbox f-fl" checked="checked"/><label for="checkbox-1-2" style="margin-top: 7px;"></label>
            <span class="uit-agreement">我同意<a href="${base}/agreement/agreement/3" class="agreement">《多肉理财平台服务协议》</a></span>
        </div>
        <a href="javascript:identification()" class="uit-confirm">确认</a>
    </section>
</div>
</article>
<#include "../public/footer.ftl" >
</body>
</html>
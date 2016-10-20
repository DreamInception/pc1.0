<!DOCTYPE html>
<html>
<head lang="en">
    	<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/User/css/user-center.css">
     <title>多肉-重设登录密码|http://www.51doro.com-白领阶层互联网资产管理专家</title>
    <script>
        $(function () {
            btnColorChange("user-rps-link","#df4f4b","#cc3a3a");
        })
    </script>
		   ${script!}
</head>
<body>
<#include "../public/header_default.ftl" >
<article class="identification-Container">
    <div class="resetPswDiv">
    <section class="userSuccess">
    <div class="user-rps-title">
        <p>重设密码成功!</p>
    </div>
            <a href="${base}/pcclient/user/access" class="user-rps-link">确定</a>
</section>
    </div>
    </article>
	   <#include "../public/footer.ftl" >
</body>
</html>
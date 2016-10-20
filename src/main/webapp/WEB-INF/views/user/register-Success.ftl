<!DOCTYPE html>
<html>
<head lang="en">
		<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/User/css/user-center.css">
      <title>多肉-注册成功|http://www.51doro.com-白领阶层互联网资产管理专家</title>
	   ${script!}
</head>
<body>
<#include "../public/header_default.ftl" >
<article class="identification-Container">
	<div class="bindcard-SuccessDiv">
    <section class="userSuccess">
        <div class="user-bdc-title">
            <p>注册成功 !</p>
            <p>一起创造财富的故事吧!</p>
        </div>
        <p class="user-bdc-return">
            <span id="user-bdc-second">3</span>秒跳转至<a href="#" class="user-bdc-link">登录页</a>
        </p>
    </section>
	</div>
</article>
<script type="text/javascript">
var base = document.getElementById("base").href;
    $(function(){
        var seconds = 3;
        var timer = setInterval(function(){
            seconds--;
            $("#user-bdc-second").text(seconds);
            if(seconds==0){
                clearInterval(timer);
                window.location.href = base + "/pcclient/user/access";
                
            }
        },1000);


    })
</script>
<#include "../public/footer.ftl" >
</body>
</html>
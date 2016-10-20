<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${base}/static/Public/css/root.css">
    <link rel="stylesheet" type="text/css" href="${base}/static/Public/css/base.css">
    <link rel="stylesheet" type="text/css" href="${base}/static/company/css/index.css">
    <link rel="shortcut icon" href="${base}/static/Public/images/favicon.ico">
    <script type="text/javascript" src="${base}/static/Public/js/jquery-2.0.3.min.js"></script>
    <title>送千足金金币</title>
</head>
<script>
    window.onload= function(){
        var height = $(".foot-gold-bottom").height();
        $(".fg-btn").css("top",height*0.56);
    };
</script>
<body>
<#include "../public/header_index.ftl" >
    <div class="foot-gold-top">
        <img src="${base}/static/Public/images/footer_active_top.png" class="foot-banner">
    </div>
    <div class="foot-gold-bottom">
        <img src="${base}/static/Public/images/footer_active_bottom.png" class="foot-bottom-pic">
        <a href="${base}/product/productlist" class="fg-btn">立即投资</a>
    </div>
<!---------------- footer区域---------------->
<#include "../public/footer.ftl" >
</body>
</html>
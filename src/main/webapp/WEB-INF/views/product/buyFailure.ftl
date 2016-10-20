<!DOCTYPE html>
<html>
<head lang="en">
	<#include "../public/public_head.ftl" >    
    <link rel="stylesheet" type="text/css" href="${base}/static/product/css/index.css">
    <title>多肉-产品页|http://www.51doro.com-白领阶层互联网资产管理专家</title>
    <script>
        $(function () {
            btnColorChange("bsc-returnBtn","#df4f4b","#cc3a3a");
        });
    </script>
	${script!}
</head>
<body>
	<#include "../public/header_product.ftl" >
<article class="mid-Container">
        <img src="${base}/static/Public/images/fail_Big.png" class="bfl-img">
        <p class="buy-fl-title">抱歉，购买失败！</p>
   
    <ul class="bsc-failDesc">
        <li class="bsc-failTxt">原因:${(errMsg)!""}</li>
        <li class="bsc-failTxt">您可以与我们的客服取得联系 400-820-0699</li>
        <li class="bsc-failTxt">周一至周五 09:00 - 18:00</li>
    </ul>
    <a href="${base}/product/productinfo/${(pdtId?c)!""}" class="bsc-returnBtn">重新购买</a>
</article>
<#include "../public/footer.ftl" >
</body>
</html>
<!DOCTYPE html>
<html>
<head lang="en">
    <#include "../public/public_head.ftl" >    
    <link rel="stylesheet" type="text/css" href="${base}/static/product/css/index.css">
      <title>多肉-产品页|http://www.51doro.com-白领阶层互联网资产管理专家</title>
    <script>
        $(function () {
            btnColorChange("bsc-indexBtn","#df4f4b","#cc3a3a");
        })
    </script>
		     ${script!}
</head>
<body>
	<#include "../public/header_product.ftl" >
    <article class="mid-Container">
        
            <img src="${base}/static/Public/images/success_Big.png" class="bsc-img">
            <p class="buy-sc-title">购买成功！</p>
       

        <section class="bsc-table">
            <p class="bsc-titleList">
                <span class="bsc-purcharse-title">购买时间</span>
            <span class="bsc-product-title">产品名称</span>
            <span class="bsc-rate-title">预期年化收益率(%)</span>
            <span class="bsc-start-title">起息日</span>
            <span class="bsc-end-title">到期日</span>
            <span class="bsc-amount-title">成交金额(元)</span>
            </p>
            <dl class="bsc-dataList f-cb">
                <dd class="bsc-purcharse-data  f-fl">${(pdt.asset_buytime)!""}</dd>
                <dd class="bsc-product-data  f-fl">${(pdt.pdt_name)!""}</dd>
                <dd class="bsc-rate-data  f-fl">${(pdt.pdt_expect_yield_rate*100)!""}</dd>
                <dd class="bsc-start-data  f-fl">${(pdt.pdt_start_yield_date)!""}</dd>
                <dd class="bsc-end-data  f-fl">${(pdt.pdt_expire_date)!""}</dd>
                <dd class="bsc-amount-data  f-fl">${(pdt.asset_amount?c)!""}</dd>
            </dl>
            
        </section>
 <div class="f-cb bsc-btn">
        <a href=".${base}/company/index" class="bsc-indexBtn">返回首页</a>
        <a href="${base}/pcclient/account/userFinance" class="bsc-assetBtn">查看资产</a>
</div>
    </article>
	<#include "../public/footer.ftl" >
</body>
</html>
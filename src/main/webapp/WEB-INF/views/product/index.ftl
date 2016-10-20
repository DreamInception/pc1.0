<!DOCTYPE html>
<html>
<head lang="en">
    <#include "../public/public_head.ftl" >    
    <link rel="stylesheet" type="text/css" href="${base}/static/product/css/index.css">
    <script type="text/javascript" src="${base}/static/Public/js/unslider.min.open.js"></script>
    <script type="text/javascript" src="${base}/static/product/js/index.js"></script>
    <script type="text/javascript" src="${base}/static/Public/js/laypage/laypage.js"></script>
      <title>多肉-产品页|http://www.51doro.com-白领阶层互联网资产管理专家</title>

</head>
<body>
<#include "../public/header_product.ftl" >

 <!---------------------------------------------网页主体内容部分------------------------------------------------------------>
 <aside class="banner_container">
    <div class="banner" id="ad_banner">
        <ul>
          <!--
        <li><a href="http://www.51doro.com/product/productinfo/4791" class="slider_Link slider_bg4"><img class="sliderimg" src="${base}/static/Public/images/banner_zip_slider04.jpg"}" alt=""
                                                      width="1200px" height="400px"></a></li>
      
           <li><a href="${base}/company/foot_gold" class="slider_Link slider_bg3"><img class="sliderimg" src="${base}/static/Public/images/banner_zip_slider03.png"}" alt=""
                                                      width="1200px" height="400px"></a></li>
           	<li><a href="javascript:void(0)" class="slider_Link slider_bg2"><img class="sliderimg" src="${base}/static/Public/images/banner_zip_slider02.png"}" alt=""
                                                      width="1200px" height="400px"></a></li>                                            
    	
    	   <li><a href="javascript:void(0)" class="slider_Link slider_bg5"><img class="sliderimg" src="${base}/static/Public/images/banner_zip_slider05.png"}" alt=""
                                                      width="1200px" height="400px"></a></li>
                  -->                                    
    	   <li><a href="javascript:void(0)" class="slider_Link slider_bg6"><img class="sliderimg" src="${base}/static/Public/images/banner_zip_slider06.png"}" alt=""
                                                      width="1200px" height="400px"></a></li>

        </ul>
<!--
        <a href="javascript:void(0);" class="unslider-arrow prev"><img class="arrow" id="al"
                                                                       src="${base}/static/Public/images/arrowl.png" alt="prev"
                                                                       width="16"></a>
        <a href="javascript:void(0);" class="unslider-arrow next"><img class="arrow" id="ar"
                                                                       src="${base}/static/Public/images/arrowr.png" alt="next"
                                                                       width="16"></a>
      -->                                                             
    </div>
</aside>  
    <article class="mid-Container f-cb f-index-dline">
	 <div class="product-mainArea">
        <aside class="f-cb">
       <!-- <section class="product-showlt f-fl">
            <img src="${base}/static/Public/images/NewTriangle.png" class="pro-tri">

            <div class="pc-fshPerson f-cb">
                <img src="${base}/static/Public/images/nlogo_Big.png" class="f-fl">

                <p class="f-fl">新人专享D7</p>
            </div>
            <hr class="ps-underline"/>
            <p class="plan-rate-num">10.00</p>

            <p class="plan-rate-title">预期年化收益率(%)</p>
            <dd class="product-need-know f-cb">
                <p class="pnk-money f-fl"><span class="pnk-minimum">100</span>元起投</p>

                <p class="pnk-line f-fl">|</p>

                <p class="pnk-time f-fr"><span class="pnk-days">7</span>天产品期限</p>

            </dd>
            <dd class="ps-tablist f-cb">
                <p class="ps-tab f-fl">已裂变</p>

                <p class="ps-tab f-fl">可变现</p>

                <p class="ps-tab f-fl">买就送</p>
            </dd>
            <a href="productDetail.html" class="pro-buy">立即购买</a>
        </section>
        <section class="product-showrt f-fl">
            <img src="${base}/static/Public/images/NewTriangle.png" class="pro-tri">

            <div class="pc-fshPerson f-cb">
                <img src="${base}/static/Public/images/nlogo_Big.png" class="f-fl">

                <p class="f-fl">新人专享D7</p>
            </div>
            <hr class="ps-underline"/>
            <div class="product-infomation">
                <p class="plan-rate-num">10.00</p>

                <p class="plan-rate-title">预期年化收益率(%)</p>
                <dd class="product-need-know f-cb">
                    <p class="pnk-money f-fl"><span class="pnk-minimum">100</span>元起投</p>

                    <p class="pnk-line f-fl">|</p>

                    <p class="pnk-time f-fl"><span class="pnk-days">7</span>天产品期限</p>
                </dd>
                <dd class="ps-tablist f-cb">
                    <p class="ps-tab f-fl">已裂变</p>

                    <p class="ps-tab f-fl">可变现</p>

                    <p class="ps-tab f-fl">买就送</p>
                </dd>
                <a href="productDetail.html" class="pro-buy">立即购买</a>
            </div>
        </section>-->
        </aside>
        <input type="hidden" id="pageCount" name="pageCount" value="${(pageCount?c)!""}">
        <div class="product-list-table" id="refresh">
			<#include "refresh.ftl">
        </div>
        <aside id="pro-page-number" class="pro-page-number"></aside>
    </article>

<!---------------- footer区域---------------->
<#include "../public/footer.ftl" >
</body>
</html>

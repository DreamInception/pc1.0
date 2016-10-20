<html>
<head>
<#include "../public/public_head.ftl" >
    <meta name="Keywords" content="多肉理财，互联网金融平台，手机理财，互联网金融，多肉，个人理财，个人贷款，投融资，信贷">
    <meta name="Description" content="多肉理财，是源泉汇理控股旗下成员，是上海景源金融信息服务有限公司倾力打造，在健全的风险管控体系基础上,为金融机构，中小企业及个人客户提供专业，可信赖的投融资，互联网理财，保险，信贷服务,100元起投，助您财富实现增值！">
    <link rel="stylesheet" type="text/css" href="${base}/static/company/css/index.css">
    <script type="text/javascript" src="${base}/static/Public/js/unslider.min.open.js"></script>
    <script type="text/javascript" src="${base}/static/company/js/index.js"></script>
    ${script!}
    <title>多肉-首页|http://www.51doro.com-白领阶层互联网资产管理专家</title>
    <script>
		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			hm.src = "//hm.baidu.com/hm.js?3cc8c7e0af3ceb12660a1f2445a7d870";
			var s = document.getElementsByTagName("script")[0]; 
			s.parentNode.insertBefore(hm, s);
		})();
    </script>
</head>
<body>
<#include "../public/header_index.ftl" >
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
<!---------------------------------------------网页主体内容部分------------------------------------------------------------>
<section id="main" class="mid-Container f-index-dline">
    
     <article id="ci-productDesc" class="ci-productDesc">
        <section class="mid-block f-cb">
        <div class="ci-prd-info01 f-fl">
            <img src="${base}/static/Public/images/cartIcon.png" class="cpiImg">

            <p class="cpiTitle">100元起购, 超低门槛</p>
        </div>
        <div class="ci-prd-info02 f-fl">
            <img src="${base}/static/Public/images/benefit.png" class="cpiImg">

            <p class="cpiTitle">高达10%预期年化收益率</p>
        </div>
        <div class="ci-prd-info03 f-fl">
            <img src="${base}/static/Public/images/businessTax.png" class="cpiImg">

            <p class="cpiTitle">申购赎回0费用</p>
        </div>
        <div class="ci-prd-info04 f-fl">
            <img src="${base}/static/Public/images/sinaGuard.png" class="cpiImg">

            <p class="cpiTitle">新浪支付托管</p>
        </div>
        <div class="ci-prd-info05 f-fl">
            <img src="${base}/static/Public/images/historyRate.png" class="cpiImg">
            <p class="cpiTitle">100%历史承兑率</p>
        </div>
        </section>
    </article>
	<div class="productInfo">产品信息</div>
    <div class="sellProduct">
        <dl class="sp-line01 f-cb">
            <#if pdtList??>
            <#list pdtList as pdt>
            <#if (pdt_index==3)||(pdt_index==7)>
             <dd class="sp-seq del-mgr f-fl">
            <#else>
            <dd class="sp-seq f-fl">
            </#if>
                <ul>
                    <li class="sp-seq-caption">
                        <p>
                            <img src="${(pdt.icon)!""}" class="sp-seq-logo">
                            <span class="sp-seq-txt">${(pdt.name)!""}</span>
                        </p>
                        <p class="sp-weekNum"></p>
                        </li>
                    <li class="sp-seq-content">
                        <img src="${base}/static/Public/images/splitLine.png" class="sp-splitLine">
                    <!--  <p class="sp_title">${((pdt.expectYieldRate*100)?c)!""}  </p> -->
                        <p class="sp_title">${((pdt.expectYieldRate*100)?string('0.00'))!""}  </p>
                        <p class="sp_payback">预期年化收益率（％）</p>
                        <div class="sp-attributes f-cb">
                        	<#if pdt.plan1??>
                            <p class="sp-split-tab f-fl">${(pdt.plan1)!""}</p>
                            </#if>
                            <#if pdt.plan2??>
                            <p class="sp-cash-tab f-fl">${(pdt.plan2)!""}</p>
                            </#if>
                            <#if pdt.plan3??>
                            <p class="sp-buy-tab f-fl del-mgr">${(pdt.plan3)!""}</p>
                            </#if>
                        </div>
                        <p class="beginAmt">${pdt.minOrderAmount}元起购</p>

                        <p class="sp-prod-day">理财期限<span class="spr_title">${(pdt.durationDesc)!""}</span></p>
                    </li>
                    <li>
                   	<#if (pdt.statusCode="onSale")!false>
                        <a href="${base}/product/productinfo/${(pdt.id?c)!""}" class="sp-buy" >立即购买</a>
                   	<#elseif (pdt.statusCode="soldOut")!false>
                   		<a href="javascript:void(0)" class="sp-buy-disabled">售罄</a>
                   	<#elseif (pdt.statusCode="stopSale")!false>
                   		<a href="javascript:void(0)" class="sp-buy-disabled">待&nbsp&nbsp售</a>
                   	</#if>
                    </li>
                </ul>
            </dd>
            	 <#if pdt_index==3>
		             </dl>
		        <dl class="sp-line02 f-cb">
             </#if>
                </#list>
                </#if>
            <dd class="sp-seq del-mgr f-fl">
                <ul>
                    <a href="${base}/product/productlist" class="link-to-product">更多产品</a>
                </ul>
            </dd>
            
        </dl>
    </div>

    <div class="news_Area f-cb">
        <div class="app-news f-fl">
            <p class="app-news-title">最新动态</p>
            <ul class="app-news-list">
                <li class="f-cb"><a href="javascript:void(0)" class="anl anl-bottom" style="cursor: default">多肉理财APP正式上线<span
                        class="f-fr">2016/01/19</span></a></li>
                <li class="f-cb"><a href="javascript:void(0)" class="anl anl-bottom" style="cursor: default">三个月内累计交易量己达3千万<span
                        class="f-fr">2016/01/10</span></a></li>
                <li class="f-cb"><a href="javascript:void(0)" class="anl anl-bottom" style="cursor: default">庆双11，多肉理财送用户三重豪礼<span
                        class="f-fr">2015/11/11</span></a></li>
                <li class="f-cb"><a href="javascript:void(0)" class="anl anl-bottom" style="cursor: default">上线首日1小时突破百万成交量<span
                        class="f-fr">2015/10/10</span></a></li>
				
				<li class="f-cb"><a href="javascript:void(0)" class="anl" style="cursor: default">多肉理财微信版登录亮相<span class="f-fr">2015/09</span></a></li>
            </ul>
        </div>
        <div class="media-news f-fr">
            <p class="media-news-title">媒体新闻</p>
            <ul class="media-news-list">
            <li class="f-cb"><a href="http://cj.xfrb.com.cn/zonghexinwen/2016-04-20/62667.html" class="anl anl-bottom" target="_blank">多肉理财：心怀敬畏，不忘初心</a></li>
                <li class="f-cb"><a href="http://www.pcpop.com/doc/SX/19/191318.shtml" class="anl anl-bottom" target="_blank">上线58分钟融资1000万解密多肉理财p2b新模式</a></li>
                <li class="f-cb"><a href="http://finance.jrj.com.cn/biz/2016/04/14104020827388.shtml" class="anl anl-bottom" target="_blank">互联网理财新宠 多肉理财缘何逆势而起</a></li>
                <li class="f-cb"><a href="http://www.morningpost.com.cn/2016/0120/1244347.shtml" class="anl anl-bottom" target="_blank">小身体大能量:多肉理财APP正式上线</a></li>
                
                <li class="f-cb"><a href="http://xj.china.com/bt/stxw/11166165/20160414/22437456.html" class="anl" target="_blank">白领变中产，多肉理财在行动</a></li>
             
                <!--<li class="f-cb"><a href="http://news.baidu.com/ns?cl=2&rn=20&tn=news&word=%E5%A4%9A%E8%82%89%E7%90%86%E8%B4%A2&ie=utf-8" class="anl">多肉app 1.0.1上线<span class="f-fr">2016/01/12</span></a></li>-->
            </ul>
        </div>
    </div>
</section>
<!------------------------------------------------------- 合作伙伴区域---------------------------------------------------------->
      <div class="coopDiv">
        <p class="coop-parter">合作伙伴</p>
        <img src="${base}/static/Public/images/coop_Company.png" class="coop-Img">
        <p class="cd_Hint">投资有风险，理财需谨慎</p>
    </div>
<!---------------- footer区域---------------->
<#include "../public/footer.ftl" >
<aside id="hidden-code" class="hidden-code">
    <ul class="app-txt">
       <li>扫</li>
        <li>一</li>
        <li>扫</li>
        <br/>
        <li>手</li>
        <li>机</li>
        <li>下</li>
        <li>载</li>
    </ul>
    <!--<img src="${base}/static/Public/images/app-Code.png" class="saoMa-Code f-fl">-->
</aside>

</body>
</html>
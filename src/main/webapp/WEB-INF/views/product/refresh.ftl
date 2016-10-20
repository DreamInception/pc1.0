 <base id="base" href="${base}">
 <dd class="product-list-head">
                <span class="pro-name">产品名称</span>
                <span class="pro-planrate">预期年化收益率</span>
                <span class="pro-date">期限</span>
                <span class="pro-startamt">起购金额</span>
                <span class="pro-operate">操作</span>
 </dd>
 <dl class="product-list-content">
               <#if page??>
               <#list page as pdt>
                <dd class="product-each-line f-cb">
                    <div class="pro-name-data f-fl">
                        <img src="${(pdt.icon)!""}">
                    <span title="${(pdt.name)!""}">${(pdt.name)!""}</span>
                    </div>
      <!--             <p class="pro-planrate-data f-fl">${((pdt.expectYieldRate*100)?c)!""}%</p>   -->
			 		<p class="pro-planrate-data f-fl">${(pdt.expectYieldRate?string('0.00%'))!""}</p>
                    <p class="pro-date-data f-fl">${(pdt.durationDesc)!""}</p>

                    <p class="pro-startamt-data f-fl">${(pdt.minOrderAmount?c)!""}元</p>

                    <#if (pdt.statusCode=="onSale")!false>
                    <p class="pro-operate-buy f-fl">
                        <a href="${base}/product/productinfo/${(pdt.id?c)!""}" >立即购买</a>
                   	</p>
                   	<#elseif (pdt.statusCode=="soldOut")!false>
                   		<p class="sp-buy-disabled f-fl">
                   		<a href="javascript:void(0);">售&nbsp&nbsp罄</a></p>
                   	<#elseif (pdt.statusCode=="waitingSellStart")!false>
                   		<p class="sp-buy-disabled f-fl"><a href="javascript:void(0);">待&nbsp&nbsp售</a></p>
                   	</#if>
                  
                </dd>
                  <hr class="pd-underline">
                </#list>
                </#if>
  </dl>
  
            
            
       

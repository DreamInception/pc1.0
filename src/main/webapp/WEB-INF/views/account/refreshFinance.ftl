<base id="base" href="${base}">
<dl id="accountTable" class="uf-accountTable">
        <dd class="uf-titleArea f-cb">
            <span class="uf-table-proTitle">产品名称</span>
            <span class="uf-table-tradeTitle">交易额</span>
            <span class="uf-table-sumTitle">累计收益</span>
            <span class="uf-table-planTitle">预期到账金额</span>
            <span class="uf-table-statTitle">状态</span>
            <span class="uf-table-buyTitle">购买日</span>
            <span class="uf-table-leftTitle">剩余天数</span>
     <!--       <span class="uf-table-legalTitle">法律文件</span>  -->
        </dd>
        <dd class="uf-contentArea">
        <#list elements as e>
            <div class="uf-dataArea f-cb">
                    <p class="uf-table-proData f-fl" title="${e.pdtName}">${e.pdtName}</p>

                    <p class="uf-table-tradeData f-fl">${e.orderAmount}</p>

                    <p class="uf-table-sumData f-fl">${e.logAccumulated_yield?string("0.00")}</p>

                    <p class="uf-table-planData f-fl">${e.expect_amount?string("0.00")}</p>
                    
                    <p class="uf-table-statData f-fl">${e.assetStatus}</p>

                    <p class="uf-table-buyData f-fl">${e.orderCreatetime?string("yyyy-MM-dd")}</p>

                      <p class="uf-table-leftData f-fl">${e.remainDays}</p>

                <!--    <p class="uf-table-legalData f-fl"><a href="${base}/pcclient/chart/financeContract?productId=${e.productId}">产品合同</a></p>
                --> 
        	</div>
        	</#list>
		</dd>
		<input type="hidden" id="ajax_pageCount" name="ajax_pageCount" value="${(pageCount?c)!""}">
    </dl>
<ul class="ticket-record-detail" id="ticket_record_detail">
    <li class="trd-navlist f-cb">
        <p class="trd-cat-name f-fl">福利种类</p>

        <p class="trd-pro-name f-fl">生息产品</p>

        <p class="trd-money-name f-fl">生息金额(元)</p>

        <p class="trd-rate-name f-fl">利率(%)</p>

        <p class="trd-sum-name f-fl">累计收益(元)</p>

        <p class="trd-source-name f-fl">来源</p>

        <p class="trd-use-name f-fl">使用日期</p>

        <p class="trd-left-name f-fl">所剩天数(天)</p>
    </li>
<#if list??>
    <li class="trd-nav-datalist">
        <#list list as u>
        <dl class="trd-nav-data f-cb">
                <dd class="trd-cat-data f-fl">${(u.welname)!""}</dd>
                <dd class="trd-pro-data f-fl">${(u.pdtName)!""}</dd>
                <dd class="trd-money-data f-fl">${(u.urTiyan_amount)!""}</dd>
                <dd class="trd-rate-data f-fl">${(u.urPromise_rate)!""}</dd>
                <dd class="trd-sum-data f-fl">${(u.urAccu_profit)!""}</dd>
                <dd class="trd-source-data f-fl">${(u.activeName)!""}</dd>
                <dd class="trd-use-data f-fl">${(u.usedDate?string('yyyy-MM-dd'))!""}</dd>
                <dd class="trd-left-data f-fl">${(u.leftDay)!""}</dd>
            </dl>
         
        </#list>
    </li>
</#if>
</ul>
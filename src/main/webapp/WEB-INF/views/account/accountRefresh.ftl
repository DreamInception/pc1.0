<base id="base" href="${base}">
<dl class="account-record-detail">
        <dd class="abd-navlist f-cb">
		   <div class="abd-operate-title f-fl">操作</div>
		   <div class="abd-transact-title f-fl">交易额</div>
		   <div class="abd-status-title f-fl">状态</div>
		   <div class="abd-time f-fr">时间</div>
        </dd>
	    <ul id="abd-nav-content" class="abd-nav-content">
	        <#list changesList as c>
	            <li class="abd-nav-data f-cb">
	                <p class="and-items f-fl">${c.logOperate_reason}</p>
	
	                <p class="and-money f-fl">${c.logOperate_money}</p>
	
	                <p class="and-status f-fl">${c.logStatus}</p>
	
	                <p class="and-time f-fl">${c.logCreatetime?string("yyyy/MM/dd")}</p>
	            </li>
	       	 </#list>
	    </ul>
	    <input type="hidden" id="ajax_pageCount" name="ajax_pageCount" value="${(pageCount?c)!""}">
</dl>
	    
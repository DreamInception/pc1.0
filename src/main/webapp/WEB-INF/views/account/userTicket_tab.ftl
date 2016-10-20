<ul>
    <!-- li class="ut-cbox-list f-cb">
        <p class="ut-redPocket-line f-fl"></p>
        <div class="ut-redPocket-title f-fl">
            <p class="ut-redPocket-first">红</p>
            <p class="ut-redPocket-second">包</p>
        </div>

        <div id="ut-redPocket-Area" class="ut-redPocket-Area f-fl">
            <p id="ut-redPocket-mask" class="ut-mask">
                <a href="#" id="ut-bonus-detail" class="ut-bonus-detail">返现详情</a>
            </p>

            <p class="ut-rpa-num"><span>10</span>元</p>

            <p class="ut-rpa-source">来源：<span>元宵节活动</span></p>

            <p class="ut-rpa-date">有效期：
                <time>2016/03/02</time>
            </p>

        </div>
    </li -->
    <li class="ut-cbox-list f-cb">
        <p class="ut-tryCash-line f-fl"></p>
        <div class="ut-tryCash-title f-fl">
            <p class="ut-tryCash-first">体</p>
            <p class="ut-tryCash-second">验</p>
            <p class="ut-tryCash-third">金</p>
        </div>
    <#if tiyanList??>
    <#list tiyanList as u>
        <div id="ut-tryCash-Area" class="ut-redPocket-Area f-fl">
            <!--p id="ut-tryCash-mask" class="ut-mask">
                <a href="#" id="ut-bonus-detail" class="ut-bonus-detail">返现详情</a>
            </p -->
            <p class="ut-tca-num"><span>${(u.urTiyan_amount)!"0"}</span>元</p>

            <p class="ut-tca-source">来源：<span>${(u.activeName)!""}</span></p>

            <p class="ut-tca-date">有效期：
                <time>${(u.validDate?string("yyyy/MM/dd"))!""}</time>
            </p>

        </div>
    </#list>
    </#if>
    </li>
    <li class="ut-cbox-list f-cb" style="height: 200px;overflow:auto;">
        <p class="ut-coupon-line f-fl"></p>
        <div class="ut-coupon-title f-fl">
            <p class="ut-coupon-first">加</p>
            <p class="ut-coupon-second">息</p>
            <p class="ut-coupon-third">券</p>
        </div>
    
    <ul class="ut-redPocket-row f-fl">
	    <#if ticketList??>
	        <#list ticketList as u>
	            <#if (u_index % 3==0 && u_index!=0)>
		            </ul>
		            <ul class="ut-redPocket-row f-fl ut-mgl">
	            </#if>
	            <div class="ut-redPocket-Area f-fl">
	                <!-- p id="ut-coupon-mask" class="ut-mask">
	                    <a href="#" id="ut-bonus-detail" class="ut-bonus-detail">返现详情</a>
	                </p -->
	
	                <p class="ut-ca-num"><span>+${(u.urPromise_rate * 100)!"0"}</span>%</p>
	
	                <p class="ut-ca-source">来源：<span>${(u.activeName)!""}</span></p>
	
	                <p class="ut-ca-date">有效期：
	                    <time>${(u.validDate?string("yyyy/MM/dd"))!""}</time>
	                </p>
	            </div>
	        </#list>
    	</#if>
	    </ul>
	</li>
</ul>
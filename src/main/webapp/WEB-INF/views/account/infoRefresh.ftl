		<script>
				$(function(){
					$(".info-title").click(function(){
		            $(this).parent().find(".point").css("visibility","hidden");
		            $(this).parent().parent().find(".info-description").toggle();
		            
		        });
				}
			)
		</script>
		<div style="background-color: #eeeeee">
            <ul class="info-select-tabs f-cb">
                <a id="all-msg-Tab" class="li-title f-fl msg-active-Tab" href="javascript:refresh(${type},2,1)">全部</a>
                <a id="await-msg-Tab" class="li-title f-fl" href="javascript:refresh(${type},0,1)">未读</a>
                <a id="already-msg-Tab" class="li-title f-fl" href="javascript:refresh(${type},1,1)">已读</a>
            </ul>
        </div>
		<#if (messageList?size>0)>
	        <#list messageList as m>
		        <div class="info-block">
		            <dl class="info-tt f-cb">
		            	<#if m.isReaded?? && m.isReaded==false>
			                <dd class="point f-fl">●</dd>
			            </#if>
			                <a href="javascript:infoReadMask(${m.id})" class="info-title f-fl">${m.title}</a>
			                <dd class="info-time f-fr">${m.createDt?string('yyyy/MM/dd')}</dd>
		            </dl>
		
		            <p class="info-description">
		                ${m.content}
		            </p>
		        </div>
	        </#list>
        </#if>
		
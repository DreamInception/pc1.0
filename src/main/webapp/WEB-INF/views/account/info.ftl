<!DOCTYPE html>
<html>
<head lang="en">
    	<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/Account/css/index.css">
    <script type="text/javascript" src="${base}/static/Public/js/laypage/laypage.js"></script>
    <script type="text/javascript" src="${base}/static/Account/js/info.js"></script>
    ${script!}
    <title>多肉-我的资产|http://www.51doro.com-白领阶层互联网资产管理专家</title>
    <script type="text/javascript">
    	 $(function () {
            var rightHeight = $(".info-right-content").height();
            $(".user-nav-list").css("height", rightHeight + 'px');
        });
    </script>
</head>
<body>
<#include "../public/header_asset.ftl" >
<article id="main" class="mid-Container f-index-dline f-cb" style="background-color: white;">
    <aside class="user-nav-list f-fl">
        <div class="user-nav-Btn f-cb">
            <p class="user-nav-mid f-fl ">

                <img src="${base}/static/Public/images/asset_sideline_grey.png" class="user-asset-icon">
                <span><a href="${base}/pcclient/account/userAsset" class="user-nav-link">我的资产</a></span>
            </p>

            <p class="user-nav-right f-fl"></p>
        </div>
        <div class="user-nav-Btn  f-cb">
            <p class="user-nav-mid f-fl" style="padding-right: 15px;">
                <img src="${base}/static/Public/images/account_sideline_grey.png" class="user-account-icon">
                <span><a href="${base}/pcclient/account/userAccount" class="user-nav-link">零钱包</a></span>
            </p>

            <p class="user-nav-right f-fl"></p>
        </div>
        <div class="user-nav-Btn f-cb">
            <p class="user-nav-mid f-fl">
                <img src="${base}/static/Public/images/finance_sideline_grey.png" class="user-asset-icon">
                <span><a href="${base}/pcclient/account/userFinance" class="user-nav-link">我的理财</a></span>
            </p>

            <p class="user-nav-right f-fl"></p>
        </div>
        <div class="user-nav-Btn f-cb">
            <p class="user-nav-mid f-fl">
                <img src="${base}/static/Public/images/ticket_sideline_grey.png" class="user-ticket-icon">
                <span><a href="${base}/pcclient/account/userTicket" class="user-nav-link">我的福利</a></span>
            </p>

            <p class="user-nav-right f-fl"></p>
        </div>
        <div class="user-nav-Btn f-cb">
            <#if isRead==0>
            	<p class="user-msg-point">●</p>
	        <#else>
	        	<p class="user-msg-point"></p>
	        </#if>
            <dl class="f-cb">
                <p class="user-msg-mid user-active-tab f-fl">
                <img src="${base}/static/Public/images/sms_sideline_red.png" class="user-msg-icon">
                <span><a href="${base}/pcclient/account/info" class="user-nav-link" style="color: #e74d46">我的消息</a></span>
            </p>

                <p class="user-msg-right f-fl"></p>
            </dl>
        </div>
        <div class="user-nav-Btn f-cb">
            <p class="user-nav-mid f-fl">
                <img src="${base}/static/Public/images/safe_sideline_grey.png" class="user-asset-icon">
                <span><a href="${base}/pcclient/safeCenter/safeGuard" class="user-nav-link">安全设置</a></span>
            </p>

            <p class="user-nav-right f-fl"></p>
        </div>
    </aside>
    <nav class="user-message-list f-fl">
        <div>
            <a href="javascript:void(0)" id="info-all-Tab" class="info-eachTab info-activeTab">全部消息</a>
            <a href="javascript:void(0)" id="info-system-Tab" class="info-eachTab">系统消息</a>
            <a href="javascript:void(0)" id="info-tran-Tab" class="info-eachTab">个人消息</a>
        </div>
    </nav>
    <section class="info-right-content f-fl">
    <input type="hidden" id="pageCount" name="pageCount" value="${(pageCount?c)!""}">
        	<div id="refresh">
        	<#include "./infoRefresh.ftl"/>
        	</div>
        	<aside id="info-page-number" class="info-page-number"></aside>
        </div>

    </section>
    </article>
    <#include "../public/footer.ftl" >
<script>
    $(function () {
        var rightHeight = $(".user-detail").height();
        $(".user-nav-list").css("height",rightHeight+'px');

        $("#info-all-Tab").on("click", function(event){
            var element = event.target;
            tabShow(element,"info-activeTab");
        });
        $("#info-system-Tab").on("click", function(event) {
            var element = event.target;
            tabShow(element, "info-activeTab");
            refresh(1,'','');
        });
        $("#info-tran-Tab").on("click", function(event) {
            var element = event.target;
            tabShow(element, "info-activeTab");
            refresh(2,'','');
        });
        $("#info-activity-Tab").on("click", function(event) {
            var element = event.target;
            tabShow(element, "info-activeTab");
        });

        $("#all-msg-Tab").on("click", function(event) {
            var element = event.target;
            tabShow(element, "msg-active-Tab");
        });
        $("#await-msg-Tab").on("click", function(event) {
            var element = event.target;
            tabShow(element, "msg-active-Tab");
        });
        $("#already-msg-Tab").on("click", function(event) {
            var element = event.target;
            tabShow(element, "msg-active-Tab");
        });

        $(".info-title").click(function(){
            $(this).parent().find(".point").css("visibility","hidden");
            $(this).parent().parent().find(".info-description").toggle();
        });

    })
</script>
</body>
</html>
<!DOCTYPE html>
<html>
<head lang="en">
    	<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/Account/css/index.css">
    <script type="text/javascript" src="${base}/static/Public/js/highcharts.js"></script>
    <script type="text/javascript" src="${base}/static/Public/js/jquery-ui.js"></script>
	   ${script!}
    <script src="${base}/static/Public/js/jquery-ui-datepicker-zh-CN.js" type="text/javascript"></script>
    <script type="text/javascript" src="${base}/static/Public/js/laypage/laypage.js"></script>
    <script type="text/javascript" src="${base}/static/Account/js/userFinance.js"></script>
    <link rel="stylesheet" type="text/css" href="${base}/static/Public/css/jquery-ui.css">
    <title>多肉-我的资产|http://www.51doro.com-白领阶层互联网资产管理专家</title>
    <script type="text/javascript">
        $(function () {
            var rightHeight = $(".user-detail").height();
            $(".user-nav-list").css("height", rightHeight + 'px');
        });
    </script>
</head>
<body>
<#include "../public/header_asset.ftl" >
<article id="main" class="mid-Container f-index-dline f-cb">
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
            <p class="user-nav-mid user-active-tab f-fl">
                <img src="${base}/static/Public/images/finance_sideline_red.png" class="user-asset-icon">
                <span><a href="${base}/pcclient/account/userFinance" class="user-nav-link" style="color: #e74d46">我的理财</a></span>
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
            <p class="user-msg-mid f-fl">
                <img src="${base}/static/Public/images/sms_sideline_grey.png" class="user-msg-icon">
                <span><a href="${base}/pcclient/account/info" class="user-nav-link">我的消息</a></span>
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
    <section class="user-detail f-fl" style="height: 800px;">
		<article id="uf-right" class="uf-right">
       
        <div class="uf-asset-bonus f-cb">
           <p class="uf-asset-money f-fl">
                <i class="uf-asset-sum">${totalAssetAmount?string("0.00")}</i>
                <i class="uf-asset-txt">持有资产（元）</i>
            </p>
            <p class="uf-all f-fl">
                <i class="uf-all-num">${totalAssetYield?string("0.00")}</i>
                <i class="uf-all-txt">累计收益（元）</i>
            </p>
         
            <p class="uf-plan f-fl">
                <i class="uf-plan-num">${projectedRepaidAmount?string("0.00")}</i>
                <i class="uf-plan-txt">预期到期可获金额（元）</i>
            </p>
        </div>
        <div class="uf-finance-Area">
            <p class="uf-finance-title">我的理财&nbsp;&nbsp;交易明细</p>

            <ul class="uf-finance-option f-cb">
				<div class="f-cb">
                        <a href="javascript:void(0)" id="uf-short-tab" class="uf-time-tab f-fl">最近两周</a>
                        <a href="javascript:void(0)" id="uf-long-tab" class="uf-time-tab f-fl">最近一个月</a>
				<p class="uf-toDiv f-fr">
                            <span class="uf-to-txt">购买日</span>
                            <input type="text" id="uf-to-input" class="uf-to-input">
            	</p>
				</div>
			</ul>
		<input type="hidden" id="pageCount" name="pageCount" value="${(pageCount?c)!""}">
		<div id="refresh">
	        <#include "./refreshFinance.ftl"/>
	    </div>
	    <aside id="fin-page-number" class="fin-page-number"></aside>
        </div>
        </article>
    </section>
</article>
<#include "../public/footer.ftl" >
<script>
    $(function () {
        var rightHeight = $(".user-detail").height();
        $(".user-nav-list").css("height",rightHeight+'px');
        $("#uf-to-input").datepicker({
           dateFormat: "yy-mm-dd",
           minDate : new Date(2007, 1 - 1,1),
		   maxDate : "+0d"
        });
        $("#uf-short-tab").on("click", function (event) {
            var element = event.target;
            tabShow(element, "uf-activeTab");
            $("#abo-to-input").datepicker("setDate", '');
            refreshPageSum(1, 14, '');
        });
        $("#uf-long-tab").on("click", function (event) {
            var element = event.target;
            tabShow(element, "uf-activeTab");
            $("#abo-to-input").datepicker("setDate", '');
            refreshPageSum(1, 30, '');
        });
         $("#uf-to-input").change(function(){
         	$("#uf-short-tab").removeClass("uf-activeTab");
			$("#uf-long-tab").removeClass("uf-activeTab");
         	var buyDay = $("#uf-to-input").datepicker("getDate");
      //   	alert(getFormatDate(new Date(buyDay)));
         refreshPageSum(1, '', getFormatDate(new Date(buyDay)));
         });
     function getFormatDate(date){
        var year = date.getFullYear(),
            month = date.getMonth()+ 1,
             day = date.getDate();
        if(month<10) month="0" + month;
        if(day<10) day="0" + day;
        var dateString = year + "-" + month + "-" + day;
        return dateString;
    }
 //       $("#uf-asset-progressbar01").progressbar({"value":40});

   //     $("#uf-asset-progressbar01 .ui-widget-header").css("background","#e74d46");
    //    $("#uf-asset-progressbar02").progressbar({"value":40});
     //   $("#uf-asset-progressbar02 .ui-widget-header").css("background","#ac9253");
     //   $("#uf-asset-progressbar03").progressbar({"value":40});
    //    $("#uf-asset-progressbar03 .ui-widget-header").css("background","#878787");
    //    $("#uf-asset-progressbar03").progressbar("option","value",60);
    
    	//限制中文字符长度
    $(".uf-table-proData").each(function(){
        var long_str = $(this).text().trim();
        if(getStrLength(long_str)>12){
            $(this).text(cutString(long_str,6));
        }
    });
    })
</script>
</body>
</html>
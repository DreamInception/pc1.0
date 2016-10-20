<!DOCTYPE html>
<html>
<head lang="en">
	<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/Public/css/nice-select.css">
    <link rel="stylesheet" type="text/css" href="${base}/static/Account/css/index.css">
    <script type="text/javascript" src="${base}/static/Public/js/jquery-ui.js"></script>
    <script src="${base}/static/Public/js/jquery-ui-datepicker-zh-CN.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="${base}/static/Public/css/jquery-ui.css">
    <script src="${base}/static/Public/js/jquery.nice-select.min.js"></script>
    <script src="${base}/static/Account/js/ticketDetail.js"></script>
	   ${script!}
    <title>多肉-我的资产|http://www.51doro.com-白领阶层互联网资产管理专家</title>
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
            <p class="user-nav-mid f-fl">
                <img src="${base}/static/Public/images/finance_sideline_grey.png" class="user-asset-icon">
                <span><a href="${base}/pcclient/account/userFinance" class="user-nav-link">我的理财</a></span>
            </p>

            <p class="user-nav-right f-fl"></p>
        </div>
        <div class="user-nav-Btn f-cb">
            <p class="user-nav-mid user-active-tab f-fl">
                <img src="${base}/static/Public/images/ticket_sideline_red.png" class="user-ticket-icon">
                <span><a href="${base}/pcclient/account/userTicket" class="user-nav-link"
                         style="color: #e74d46">我的福利</a></span>
            </p>

            <p class="user-nav-right f-fl"></p>
        </div>
        <div class="user-nav-Btn f-cb">
            <p class="user-msg-point">●</p>
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
    <section class="user-detail f-fl">
        <article id="utd-right" class="utd-right">
            <p class="ut-detail-title">我的福利 交易明细</p>
            <ul class="ticket-record-option f-cb">
                <i class="tro-date f-fl">
                    <a href="javascript:refresh(14,'')" id="tro-short-term" class="tro-short-term tro-activeTab">最近两周</a>
                    <a href="javascript:refresh(30,'')" id="tro-long-term" class="tro-long-term">最近一个月</a>
                </i>
                <i class="tro-date-ft f-fr">
                    <span class="tro-from-txt">使用日期</span>
                    <input type="text" id="tro-from-input" class="tro-from-input" style="text-align: center">
                </i>
            </ul>
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
        </article>
    </section>
</article>
    <script type="text/javascript">
        $(function () {
            var rightHeight = $(".user-detail").height();
        $(".user-nav-list").css("height",rightHeight+'px');

        $("#tro-from-input").datepicker({
            dateFormat : "yy-mm-dd",
			minDate : new Date(2007, 1 - 1,1),
			maxDate : "+0d"
        });
        $('select').niceSelect();

        $("#tro-short-term").on("click", function(event){
            var element = event.target;
            tabShow(element,"tro-activeTab");
        });
        $("#tro-long-term").on("click", function(event) {
            var element = event.target;
            tabShow(element, "tro-activeTab");
        });    
         $("#tro-from-input").change(function(event) {
         	$("#tro-short-term").removeClass("tro-activeTab");
         	$("#tro-long-term").removeClass("tro-activeTab");
            var useDay = $("#tro-from-input").datepicker("getDate");
            refresh('',getFormatDate(new Date(useDay)));
        });
        
        });
        
	// 格式化日期
	function getFormatDate(date) {
		var year = date.getFullYear(), month = date.getMonth() + 1, day = date
				.getDate();
		if (month < 10)
			month = "0" + month;
		if (day < 10)
			day = "0" + day;
		var dateString = year + "-" + month + "-" + day;
		return dateString;
	}
    </script>
<#include "../public/footer.ftl" >
</body>
</html>
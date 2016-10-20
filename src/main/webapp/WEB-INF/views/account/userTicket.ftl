<!DOCTYPE html>
<html>
<head lang="en">
    	<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/Account/css/index.css">
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
    <section class="user-detail f-fl">
        <div class="ut-accountBox f-cb">
            <p class="ut-accountBox-caption">体验金</p>
            <ul class="ut-accountBox-lt f-fl">
                <!--<a href="ticketDetail.html" class="ticketDetail">福利明细</a>-->
                <li class="tryCash-benefit-num">${tiyanAmount!"0.00"}</li>
                <li class="tryCash-benefit-des">生息金额(元)</li>
            </ul>
            <p class="ut-splitLine f-fl"></p>
            <ul class="ut-accountBox-mid f-fl">
                <li class="tryCash-all-num">${tiyanAccProfit!"0.00"}</li>
                <li class="tryCash-all-des">累计收益(元)</li>
            </ul>
            <ul class="ut-accountBox-rt f-fl">
                <li class="tryCash-today-num">${tiyanDayProfit!"0.00"}</li>
                <li class="tryCash-today-des">今日收益(元)</li>
            </ul>
        </div>
        <div class="ut-accountBox f-cb">
            <p class="ut-accountBox-caption">加息券</p>
            <ul class="ut-accountBox-lt f-fl">
                <p class="tkCoupon-num">${ticketCount!"0"}</p>

                <p class="tkCoupon-txt">加息产品数(张)</p>
            </ul>
            <p class="ut-splitLine f-fl"></p>
            <ul class="ut-accountBox-mid f-fl">
                <li class="tkCoupon-all-num">${ticketAccProfit!"0.00"}</li>
                <li class="tkCoupon-all-des">累计收益(元)</li>
            </ul>
            <ul class="ut-accountBox-rt f-fl">
                <li class="tkCoupon-yest-num">${ticketDayProfit!"0.00"}</li>
                <li class="tkCoupon-yest-des">昨日收益(元)</li>
            </ul>
        </div>
        <aside class="ut-accountBox2 f-cb">
            <a href="${base}/pcclient/account/ticketDetail" class="ticketDetail">福利明细</a>
            <ul class="f-cb ut-tablist">
                <a href="javascript:void(0)" id="ut-unuse-tab" class="ut-use-link ut-activeTab f-fl">未使用</a>
                <a href="javascript:void(0)" id="ut-already-tab" class="ut-use-link f-fl">已使用</a>
                <a href="javascript:void(0)" id="ut-expired-tab" class="ut-use-link f-fl">已过期</a>
            </ul>
            <article id="ut-unuse" class="ut-categoryBox">
            <#include "userTicket_tab.ftl" >
            </article>
        </aside>


    </section>
    <section id="ticket-activity-win" class="commonWin">
        <img src="${base}/static/Public/images/closeBtn.png" id="ticket-activity-close" class="closeWin">

        <p class="ticket-top">红包</p>

        <div class="ta-mid">
            <p class="ta-activity-title">年终奖红包</p>

            <p>1. 活动详情.....</p>

            <p>2. 返现详情.....</p>
            <ul class="ta-foot">
                <li>来源: 年终奖活动</li>

                <li>有效期至: 2016/04/01 18:00:00</li>
            </ul>
        </div>


    </section>
    <script type="text/javascript">
        $(function () {
            var rightHeight = $(".user-detail").height();
            $(".user-nav-list").css("height",rightHeight+'px');
//            $("#ut-redPocket-Area").hover(function () {
//                $("#ut-redPocket-mask").show();
//            }, function () {
//                $("#ut-redPocket-mask").hide();
//            });
//            $("#ut-tryCash-Area").hover(function () {
//                $("#ut-tryCash-mask").show();
//            }, function () {
//                $("#ut-tryCash-mask").hide();
//            });
//            $("#ut-coupon-Area").hover(function () {
//                $("#ut-coupon-mask").show();
//            }, function () {
//                $("#ut-coupon-mask").hide();
//            });
//            $("#ut-bonus-detail").click(function () {
//                windowShow("ticket-activity-win");
//            });
//            $("#ticket-activity-close").click(function () {
//                windowHide("ticket-activity-win");
//            });

            $(".ut-use-link").each(function () {
                $(this).on("click", function (event) {
                    var element = event.target;
                    thisTabShow(element, "ut-activeTab");
                    var rightHeight = $(".user-detail").height();
            		$(".user-nav-list").css("height",rightHeight+'px');
                });
            });
        });

        function thisTabShow(obj, cls) {
            var $this = $(obj);
            elementId = $this.attr('id');
            showSecId = elementId.slice(0, elementId.indexOf('-tab'));
            var state = 0;
            if ("ut-unuse" == showSecId) {
                state = 1;
            } else if ("ut-already" == showSecId) {
                state = 2;
            } else if ("ut-expired" == showSecId) {
                state = 4;
            }
            jQuery.ajax({
                type: "POST",
                url: '${base}/pcclient/account/ticketTab?state=' + state,
                error: function () {
                    //TODO 显示错误信息

                },
                success: function (res) {
                    var str = res.replace(new RegExp("<script(.|\s)*?\/script>", "ig"), "");
                    $("#ut-unuse").html(str);
                },
                complete: function () {
                    //TODO 关闭遮罩层
                }
            });
            //$this.css("background", "yellow").siblings().css("background", "#ffffff");
            $this.addClass(cls).siblings().removeClass(cls);
            //console.log("show tab area id is " + showSecId);
            //$("#" + showSecId).show().siblings().hide();
        }
    </script>
</article>
<#include "../public/footer.ftl" >
</body>
</html>
<!DOCTYPE html>
<html>
<head lang="en">
    	<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/safeCenter/css/safeCenter.css">
    <title>多肉-我的资产|http://www.51doro.com-白领阶层互联网资产管理专家</title>
    <script type="text/javascript">
        $(function () {
            var rightHeight = $(".user-detail").height();
            $(".user-nav-list").css("height", rightHeight + 'px');
        });
    </script>
		 ${script!}
</head>
<body>
<#include "../public/header_asset.ftl" >

<article id="main" class="mid-Container f-index-dline f-cb">
    <hr class="user-top-line">
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
            <p class="user-nav-mid user-active-tab f-fl">
                <img src="${base}/static/Public/images/safe_sideline_red.png" class="user-asset-icon">
                <span><a href="${base}/pcclient/safeCenter/safeGuard" class="user-nav-link" style="color: #e74d46">安全设置</a></span>
            </p>

            <p class="user-nav-right f-fl"></p>
        </div>
    </aside>
    <section class="user-detail f-fl">
        <div class="bc-contentWrap">
            <img class="bc-face" src="${base}/static/Public/images/fail_Big.png">

            <p class="bc-title">绑卡失败！</p>

            <ul class="bc-mid-content">
            <#if errMsg??>
                <li>原因:${errMsg}</li>
            <#else>
            	<li>原因: 未知</li>
            </#if>
                <li>您可以与我们的客服取得联系 400-820-0699</li>
                <li>周一至周五 09:00 - 18:00</li>
            </ul>
            <a href="${base}/pcclient/safeCenter/safeGuard" class="bc-back-btn">重试</a>
        </div>
    </section>
</article>
<script type="text/javascript">
    $(function () {
        var seconds = 3;
        var timer = setInterval(function () {
            seconds--;
            $("#bc-usetime").text(seconds);
            if (seconds == 0) {
                clearInterval(timer);
                window.location.href = base
								+ "/pcclient/safeCenter/safeGuard";
            }
        }, 1000);


    })
</script>
<#include "../public/footer.ftl" >
</body>
</html>
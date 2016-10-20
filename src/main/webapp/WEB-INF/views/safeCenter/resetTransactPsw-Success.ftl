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
    <aside class="user-nav-list f-fl">
        <div class="user-nav-Btn f-cb">
            <p class="user-nav-mid f-fl ">
                <img src="${base}/static/Public/images/asset_sideline_grey.png" class="user-asset-icon">
                <span><a href="${base}/pcclient/account/userAsset" class="user-nav-link">我的资产</a></span>
            </p>

            <p class="user-nav-right f-fl"></p>
        </div>
        <div class="user-nav-Btn  f-cb">
            <p class="user-nav-mid f-fl">
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
        <div class="rtp-success-content">
            <img class="user-rtp-img" src="${base}/static/Public/images/success_Big.png">

            <p class="rtp-title">交易密码修改成功！</p>

            <p class="rtp-return"><span id="rtp-usetime" class="rtp-usetime">3</span>秒跳转至<a href="${base}/pcclient/resetPsw/resetTransactSuccessPage"
                                                                                            class="user-rtp-link">上一页</a>
            </p>
        </div>
    </section>
</article>
<script type="text/javascript">
	var base = document.getElementById("base").href;
    $(function () {
        var seconds = 3;
        var timer = setInterval(function () {
            seconds--;
            $("#rtp-usetime").text(seconds);
            if (seconds == 0) {
                clearInterval(timer);
                window.location.href=base+"/pcclient/safeCenter/safeGuard";
            }
        }, 1000);


    })
</script>
<#include "../public/footer.ftl" >
</body>
</html>
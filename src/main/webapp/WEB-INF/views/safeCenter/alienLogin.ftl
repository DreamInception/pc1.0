<!DOCTYPE html>
<html>
<head lang="en">
    	<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/safeCenter/css/safeCenter.css">
   <title>多肉-我的资产|http://www.51doro.com-白领阶层互联网资产管理专家</title>
    <script type="text/javascript">
        $(function () {
            var rightHeight = $(".al-contentWrap").height();
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
    <section class="al-contentWrap f-fl">
        <p class="al-title">
        	异地登录 (近三月数据)
            <span class="al-remind">说明: 请确认登录时间和地点, 如发现异常, 为保证账户安全, 请尽快
            	<a href="${base}/pcclient/safeCenter/resetLogin" class="a-alter-pwd">修改登录密码</a>
        	</span>
        </p>
        
        <div class="al-login-detail">
            <dd class="al-title-list">
                <span class="al-logtime-title">登录时间</span>
                <span class="al-location-title">地点</span>
                <span class="al-ip-title">IP地址</span>
                <span class="al-device-title">登录设备</span>
            </dd>
            <dl class="al-container">
            <#list ipList as ip>
            <dd class="content_list f-cb">
                <time class="al-logtime-data f-fl">${ip.logLogintime}</time>
                <p class="al-location-data f-fl">${ip.address!'未知'}</p>
                <p class="al-ip-data f-fl">${ip.logLogin_ip}</p>
                <p class="al-device-data f-fl">WEB</p>
            </dd>
            </#list>
            </dl>
        </div>
        <aside class="bottom-page-number" style="bottom: 0px;right: 10px;">
        <div class="viciao">
            <!--<span class="disabled">上一页</span>
            <span class="current">1</span>
            <a href="#?page=2">2</a>
            <a href="#?page=3">3</a>
            <a href="#?page=4">4</a>
            <a href="#?page=5">5</a>
            ...&nbsp;<a href="#?page=199">199</a>
            <a href="#?page=200">200</a>
            <a href="#?page=2">下一页</a>-->
        </div>
        </aside>
    </section>

</article>
<#include "../public/footer.ftl" >
</body>
</html>
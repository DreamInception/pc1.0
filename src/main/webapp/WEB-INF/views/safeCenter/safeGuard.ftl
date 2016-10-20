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
        <div class="sg-contentWrap">
            <p class="sg-title">个人资料</p>
            <li class="sg-phoneNum-txt f-cb">
                <p class="sg-start-name f-fl">登录账号：</p>
                <p class="sg-middle-origin f-fl">${userTelephone[0..2]}****${userTelephone[7..10]}</p>
            </li>
            <li class="sg-username-txt f-cb">
                	<p class="sg-start-name f-fl">真实姓名：</p>
                <#if userRealname != "不存在">
                	<p class="sg-middle-origin f-fl">${userRealname}</p>
                <#else>
                	<p class="sg-middle-origin f-fl">实名认证,保障账户安全</p>
                	<a href="${base}/pcclient/identification/identificationPage" class="sg-logininfo-link f-fr">设置</a>
                </#if>
            </li>
            <li class="sg-password-txt f-cb">
                <p class="sg-start-name f-fl">登录密码：</p>
                <p class="sg-middle-origin f-fl">已设置</p>
                <a href="${base}/pcclient/safeCenter/resetLogin" class="sg-logininfo-link f-fr">修改</a>
            </li>
            <li class="sg-finpsw-txt f-cb">
                <p class="sg-start-name f-fl">交易密码：</p>
                <#if userPay_password=='未设置'>
                	<p class="sg-middle-origin f-fl">用于购买理财产品,充值,取现的密码</p>
                	<a href="${base}/pcclient/safeCenter/setTransactPage" class="sg-finpsw-link f-fr">设置</a>
                <#else>
                	<p class="sg-middle-origin f-fl">已设置</p>
                	<a href="${base}/pcclient/safeCenter/resetTransact" class="sg-finpsw-link f-fr">修改</a>
                </#if>
            </li>
            <li class="sg-bankcard-txt f-cb">
                <p class="sg-start-name f-fl">银行卡：</p>
                <#if userBank_status??>
                	<p class="sg-middle-origin f-fl">用于充值,取现交易</p>
                	<a href="${base}/pcclient/user/bindCardPage" class="sg-bankcard-link f-fr">绑定</a>
                <#else>
                	<p class="sg-middle-origin f-fl">${userBank_account}</p>
                </#if>
            </li>
            <li class="sg-logininfo-txt f-cb">
                <p class="sg-start-name f-fl">登录信息： </p>
                <p class="sg-middle-origin f-fl">上次登录:${logLogintime?string("yyyy-MM-dd HH:mm:ss")}&nbsp;&nbsp;${loginAddress!"未知地址"}</p>
                <a href="${base}/pcclient/alienLogin/alienLogin" class="sg-logininfo-link f-fr">查看异常</a>
            </li>
        </div>
    </section>
</article>
</body>
<#include "../public/footer.ftl" >
</html>
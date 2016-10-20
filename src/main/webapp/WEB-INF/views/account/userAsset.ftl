<!DOCTYPE html>
<html>
<head>
    	<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/Account/css/index.css">
    <script type="text/javascript" src="${base}/static/Public/js/highcharts.js"></script>
	<script type="text/javascript" src="${base}/static/Account/js/userAsset.js" charset="gb2312"></script>
   ${script!}
   <title>多肉-我的资产|http://www.51doro.com-白领阶层互联网资产管理专家</title>
</head>
<body>
<#include "../public/header_asset.ftl" >
<article id="main" class="mid-Container f-index-dline f-cb">
    <aside class="user-nav-list f-fl">
        <div class="user-nav-Btn f-cb">
            <p class="user-nav-mid user-active-tab f-fl ">
                <img src="${base}/static/Public/images/asset_sideline_red.png" class="user-asset-icon">
                <span><a href="${base}/pcclient/account/userAsset" class="user-nav-link" style="color: #e74d46">我的资产</a></span>
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
            <p class="user-nav-mid f-fl">
                <img src="${base}/static/Public/images/safe_sideline_grey.png" class="user-asset-icon">
                <span><a href="${base}/pcclient/safeCenter/safeGuard" class="user-nav-link">安全设置</a></span>
            </p>

            <p class="user-nav-right f-fl"></p>
        </div>
    </aside>
    <section class="user-detail f-fl">
	
        <#if userBankStatus==0>
            <p id="bindcard" class="ui-bindcard f-cb">
                <span class="ui-bc_remind f-fl">您尚未绑定银行卡. 快来开启多肉的财富之旅吧!</span>
                <a href="${base}/pcclient/user/bindCardPage" class="ui-bc_btn f-fr">立即绑卡</a>
            </p>
         </#if>
		 	<ul id="user-index" class="user-index">
            <li class="ui-user-info">
				<img src="${base}/static/Public/images/head_Photo.png" class="ui-head-img">
				<div class="ui-user-area">
            	<#if userRealname??>
					<p>用户名:<span class="ui-username">${userRealname}</span></p>
				<#else>
					<p>用户名:<span class="ui-username">未设置</span></p>
				</#if>
                
                <p>登录账号:<span class="ui-accountname">${userTelephone[0..2]}****${userTelephone[7..10]}</span></p>

                    <p>上一次登录：
                        <time class="ui-login-time">${logLogintime?string("yyyy-MM-dd HH:mm:ss")}</time>
                        <span class="ui-login-location">${loginAddress!"未知地址"}</span>
                        <a href="${base}/pcclient/alienLogin/alienLogin" class="ui-logininfo-link">[查看]</a>
                   </p>  
                </div>
            </li>
            <li class="ui-user-asset f-cb">
                <div class="ui-asset-div f-fl">
                    <p class="ui-asset-sum">${balance}</p>

                    <p class="ui-asset-txt">资产总额</p>
		<!--			<div class="f-cb">
	                <a href="${base}/pcclient/finance/rechargePage" class="ui-rc-link f-fl">充值</a>
	                
	                  <a href="${base}/pcclient/finance/withdrawPage" class="ui-wd-link f-fr">取现</a>
					</div>
					-->
                </div>
                <div class="ui-financial-div f-fl">
                    <dl class="f-cb">
                        <dd class="ui-fin-box1 f-fl">
                            <p class="ui-financial-num">${userBalance}</p>

                            <i class="ui-financial-txt">零钱包(元)</i>
                        </dd>
                        <dd class="ui-fin-box2 f-fl">
                            <p class="ui-financial-num">${totalAssetAmount}</p>

                            <i class="ui-financial-txt">理财账户(元)</i>
                        </dd>
                        <dd class="ui-fin-box3 f-fl">
                            <p class="ui-financial-num">${inTransitBalance}</p>

                            <i class="ui-financial-txt">在途资金(元)</i>
                        </dd>
                        <dd class="ui-fin-box4 f-fl">
                            <p class="ui-financial-num">${userFrozen}</p>

                            <i class="ui-financial-txt">冻结资金(元)</i>
                        </dd>
                    </dl>
                </div>
            </li>
            <li class="ui-user-pic">
                <div class="ui-cal-benefit f-cb">
                    <p class="ui-all-ben f-fl">
               			<em>${totalYield}</em>
                        <i>累计收益(元)</i>
                    </p>
					<p class="ui-mid-line f-fl">|</p>
                    <p class="ui-yest-ben f-fl">
                        <em>${yesterdayYield}</em>
                        <i>昨日收益(元)</i>
                    </p>
                </div>
                <p class="ui-graph-tabs f-cb">
                    <a href="javascript:void(0)" id="ui-all-btn" class="ui-each-tab ui-active-ghtab f-fl">全部</a>
                    <a href="javascript:void(0)" id="ui-finance-btn" class="ui-each-tab f-fl">理财</a>
                    <a href="javascript:void(0)" id="ui-account-btn" class="ui-each-tab f-fl">零钱包</a>
                </p>
                <p class="ui-graph-yTitle">金额（元）</p>
                <div class="f-cb">
                	<div id="graphMap">
                   		<p id="graphTable" class="graphTable f-fl"></p>
                    </div>
                    <p class="ui-graph-xTitle f-fl">/日期</p>
                </div>
            </li>
        </ul>


    </section>
</article>
<#include "../public/footer.ftl" >

</body>
</html>
<!DOCTYPE html>
<html>
<head lang="en">
    	<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/safeCenter/css/safeCenter.css">
    <script type="text/javascript" src="${base}/static/Public/js/jquery-ui.js"></script>
    <link rel="stylesheet" type="text/css" href="${base}/static/Public/css/jquery-ui.css">
    <script type="text/javascript" src="${base}/static/safeCenter/js/exchangeBind-Step2.js"></script>
    <title>多肉-我的资产|http://www.51doro.com-白领阶层互联网资产管理专家</title>
    <script type="text/javascript">
        $(function () {
            var rightHeight = $(".user-detail").height();
            $(".user-nav-list").css("height", rightHeight + 'px');
            btnColorChange("eb-confirm","#df4f4b","#cc3a3a");
            $("#eb-bank-phoneNum").on("input", function (event) {
                var element = event.target;
                validatePhoneNum(element,"eb-phoneNum-error","请输入正确的手机号码");
            });
             $("#sms-msgCode").on("input", function (event) {
                var element = event.target;
                validateMsgCode(element,"sms-error","验证码只能是4位或6位数字");
        		});
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
        <p class="eb-title">换绑银行卡</p>
		<div class="f-cb" style="padding-left: 45px;">
	        <a href="javascript:void(0)" class="eb-step-tab f-fl">步骤1.取现</a>
	        <a href="javascript:void(0)" class="eb-step-tab f-fl" style="background: #e74d46">步骤2.换绑</a>
        </div>
        <div class="exchangeCardDiv2">
            <!--<img src="../../Public/images/cmb_logo.png" class="eb-bank-logo">-->
            <input type="text" id="eb-card-name" class="eb-card-name" placeholder="持卡人姓名">
            <div class="eb-card-area f-cb">
            <select name="province" id="province"
                    onchange="onSelectChange(this,'#city');" datatype="*"
                    nullmsg="所在省份！" class="eb-province">
                     <option value="" selected="selected">省份</option>
            
            </select>
            <select name="city f-fl" id="city"
                    datatype="*" nullmsg="所在城市！" class="eb-city">
                     <option value="" selected="selected">城市</option>
              
            </select>
            </div>
            <select name="bankCode" id="eb-bankCode" class="eb-bankname" onchange="onSelectChange(this,'#county');"
                    datatype="*">
                <option value="" selected="selected">银行地区</option>
                <#list bankList as b>
                    <option value="${b.bankCode}">${b.bankName}</option>
                </#list>
            </select>
            <input type="text" id="bankCardNumber" class="eb-cardNumber" placeholder="银行卡号">
            <p id="eb-cardNum-error" class="eb-errorMsg"></p>
            <input type="text" id="eb-bank-phoneNum" class="eb-bank-phoneNum" placeholder="银行预留手机号">
            <p id="eb-phoneNum-error" class="errorMsg"></p>
            <div class="f-cb">
            	<input type="hidden" id="ticket">
                <input type="text" id="sms-msgCode" class="sms-msgCode f-fl" placeholder="短信验证码">
                <input type="button" id="sms-gainCode" class="sms-gainCode f-fl" value="获取验证码"
                       onclick="bankSendText('eb-bank-phoneNum','sms-gainCode','sms-error','手机号不能为空')"/>
            </div>
            <p id="sms-error" class="eb-errorMsg"></p>

            <div class="eb-agreeDiv">
                <input type="checkbox" id="checkbox-1-2" class="eb-checkbox f-fl" checked="checked"/><label for="checkbox-1-2" style="margin-top: 5px;"></label>
                <span class="uia-agreement">我已阅读并同意<a href="${base}/agreement/agreement/5"
                                                      class="agreement">《快捷支付服务协议》</a></span>
            </div>
            <a href="javascript:checkTexting()" class="eb-confirm">绑卡</a>

            <p class="eb-safeinfo">账户资金由新浪支付托管, 安全可靠</p>
        </div>

    </section>
</article>
<#include "../public/footer.ftl" >
<script type="text/javascript">
    $("#province").selectmenu();
    $("#eb-city").selectmenu();
    $("#eb-bankCode").selectmenu();
</script>
</body>
</html>
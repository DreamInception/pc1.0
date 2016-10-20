<!DOCTYPE html>
<html>
<head lang="en">
    	<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/Account/css/index.css"> 
    <script type="text/javascript" src="${base}/static/Account/js/recharge_cb.js"></script>
    <title>多肉-我的资产|http://www.51doro.com-白领阶层互联网资产管理专家</title>
      ${script!}
    <script type="text/javascript">
        $(function () {
            var rightHeight = $(".acc-right-area").height();
            $(".user-nav-list").css("height", rightHeight + 'px');
            btnColorChange("cyber-rcBtn", "#df4f4b", "#cc3a3a");
        })
    </script>
</head>
<body>
<#include "../public/header_asset.ftl" >
<article id="main" class="mid-Container f-cb f-index-dline">

    <aside class="user-nav-list f-fl">
        <div class="user-nav-Btn f-cb">
            <p class="user-nav-mid f-fl ">
                <img src="${base}/static/Public/images/asset_sideline_grey.png" class="user-asset-icon">
                <span><a href="${base}/pcclient/account/userAsset" class="user-nav-link">我的资产</a></span>
            </p>

            <p class="user-nav-right f-fl"></p>
        </div>
        <div class="user-nav-Btn  f-cb">
            <p class="user-nav-mid user-active-tab f-fl" style="padding-right: 15px;">
                <img src="${base}/static/Public/images/account_sideline_red.png" class="user-account-icon">
                <span><a href="${base}/pcclient/account/userAccount" class="user-nav-link" style="color: #e74d46">零钱包</a></span>
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
    <article class="acc-right-area f-fl">
        <div class="f-cb user-cyber-tabs">
            <a href="${base}/pcclient/finance/rechargePage" class="identify-pay f-fl">认证支付</a>
            <a href="javascript:;" class="netSilver-pay red-tab f-fl">网银支付</a>
        </div>
        <aside class="rc-bank-area">
            <p class="rc-sel-bank">选择充值银行</p>
            <dl class="rc-bank-firstline f-cb">
                <dd id="CMB_select" class="rc-bank-ipt select-checkbox f-fl">
                    <p class="cyber-unselect-checkbox cyber-select-checkbox"></p>
                    <img src="${base}/static/Public/images/cyber-bank-logo/CMB_logo.png" class="cyber-bank-logo">
                </dd>
				<dd id="CCB_select" class="rc-bank-ipt select-checkbox f-fl">
                    <p class="cyber-unselect-checkbox"></p>
                    <img src="${base}/static/Public/images/cyber-bank-logo/CCB_logo.png" class="cyber-bank-logo">
                </dd>
                <dd id="ICBC_select" class="rc-bank-ipt select-checkbox f-fl">
                    <p class="cyber-unselect-checkbox"></p>
                    <img src="${base}/static/Public/images/cyber-bank-logo/ICBC_logo.png" class="cyber-bank-logo">
                </dd>
                <dd id="BOC_select" class="rc-bank-ipt select-checkbox f-fl">
                    <p class="cyber-unselect-checkbox"></p>
                    <img src="${base}/static/Public/images/cyber-bank-logo/BOC_logo.png" class="cyber-bank-logo">
                </dd>
                <dd id="ABC_select" class="rc-bank-ipt select-checkbox f-fl">
                    <p class="cyber-unselect-checkbox"></p>
                    <img src="${base}/static/Public/images/cyber-bank-logo/ABC_logo.png" class="cyber-bank-logo">
                </dd>
            </dl>
			<dl class="rc-bank-line rc-hide-line f-cb">
                <dd id="COMM_select" class="rc-bank-ipt select-checkbox f-fl">
                    <p class="cyber-unselect-checkbox"></p>
                    <img src="${base}/static/Public/images/cyber-bank-logo/COMM_logo.png" class="cyber-bank-logo">
                </dd>
				<dd id="GDB_select" class="rc-bank-ipt select-checkbox f-fl">
                    <p class="cyber-unselect-checkbox"></p>
                    <img src="${base}/static/Public/images/cyber-bank-logo/GDB_logo.png" class="cyber-bank-logo">
                </dd>
                <dd id="CIB_select" class="rc-bank-ipt select-checkbox f-fl">
                    <p class="cyber-unselect-checkbox"></p>
                    <img src="${base}/static/Public/images/cyber-bank-logo/CIB_logo.png" class="cyber-bank-logo">
                </dd>
                <dd id="SPDB_select" class="rc-bank-ipt select-checkbox f-fl">
                    <p class="cyber-unselect-checkbox"></p>
                    <img src="${base}/static/Public/images/cyber-bank-logo/SPDB_logo.png" class="cyber-bank-logo">
                </dd>
                <dd id="SZPAB_select" class="rc-bank-ipt select-checkbox f-fl">
                    <p class="cyber-unselect-checkbox"></p>
                    <img src="${base}/static/Public/images/cyber-bank-logo/SZPAB_logo.png" class="cyber-bank-logo">
                </dd>
            </dl>
            <dl class="rc-bank-line rc-hide-line f-cb">
                <dd id="NJCB_select" class="rc-bank-ipt select-checkbox f-fl">
                    <p class="cyber-unselect-checkbox"></p>
                    <img src="${base}/static/Public/images/cyber-bank-logo/NJCB_logo.png" class="cyber-bank-logo">
                </dd>
				<dd id="CEB_select" class="rc-bank-ipt select-checkbox f-fl">
                    <p class="cyber-unselect-checkbox"></p>
                    <img src="${base}/static/Public/images/cyber-bank-logo/CEB_logo.png" class="cyber-bank-logo">
                </dd>
                <dd id="CMBC_select" class="rc-bank-ipt select-checkbox f-fl">
                    <p class="cyber-unselect-checkbox"></p>
                    <img src="${base}/static/Public/images/cyber-bank-logo/CMBC_logo.png" class="cyber-bank-logo">
                </dd>
                <dd id="CITIC_select" class="rc-bank-ipt select-checkbox f-fl">
                    <p class="cyber-unselect-checkbox"></p>
                    <img src="${base}/static/Public/images/cyber-bank-logo/CITIC_logo.png" class="cyber-bank-logo">
                </dd>
                <dd id="BCCB_select" class="rc-bank-ipt select-checkbox f-fl">
                    <p class="cyber-unselect-checkbox"></p>
                    <img src="${base}/static/Public/images/cyber-bank-logo/BCCB_logo.png" class="cyber-bank-logo">
                </dd>
            </dl>
            <dl class="rc-bank-line rc-hide-line f-cb">
                <dd id="CBHB_select" class="rc-bank-ipt select-checkbox f-fl">
                    <p class="cyber-unselect-checkbox"></p>
                    <img src="${base}/static/Public/images/cyber-bank-logo/CBHB_logo.png" class="cyber-bank-logo">
                </dd>
				<dd id="CZS_select" class="rc-bank-ipt select-checkbox f-fl">
                    <p class="cyber-unselect-checkbox"></p>
                    <img src="${base}/static/Public/images/cyber-bank-logo/CZS_logo.png" class="cyber-bank-logo">
                </dd>
                <dd id="PSBC_select" class="rc-bank-ipt select-checkbox f-fl">
                    <p class="cyber-unselect-checkbox"></p>
                    <img src="${base}/static/Public/images/cyber-bank-logo/PSBC_logo.png" class="cyber-bank-logo">
                </dd>
            </dl>
            <a href="javascript:;" id="rc-open-bank" class="rc-open-bank f-cb">
                <p class="cyber-show-txt f-fl">选择其他银行</p>
                <p class="cyber-hide-txt f-fl" style="text-indent: 50px;">收起</p>
                <img src="${base}/static/Public/images/arrow_bottom_small.png" class="cyber-show-img f-fr">
                <img src="${base}/static/Public/images/arrow_top_small.png" class="cyber-hide-img f-fr">
            </a>
        </aside>
        <div class="rc-bank-dtls">
            <p class="rc-bank-title">
                <span class="rbt-td-yh">银行</span>
                <span class="rbt-td-xe">交易限额（人民币）</span>
            </p>
            <ul id="CMB_restrict" class="rc-bank-content f-cb" style="display:block">
                <li class="rc-bank-name f-fl">招商银行</li>
                <li class="rc-bank-txt two-line f-fl">
                    <p class="rc-bank-infoF">大众版：单笔500元，单日5000元</p>
                    <p class="rc-bank-infoS">专业版：无限额，用户可自行设置</p>
                </li>
            </ul>
            <ul id="CCB_restrict" class="rc-bank-content f-cb">
                <li class="rc-bank-name f-fl">建设银行</li>
                <li class="rc-bank-txt f-fl">
                    <p class="rc-bank-infoF">一代网银盾：单笔5万元、单日5万元</p>
                    <p class="rc-bank-infoS">二代网银盾：单笔50万元，单日50万元</p>
                    <p class="rc-bank-infoT">刮刮卡： 单笔5000元，单日5000元</p>
                    <p class="rc-bank-infoF">账号支付： 单笔1000元，单日1000元</p>
                </li>
            </ul>
            <ul id="ICBC_restrict" class="rc-bank-content f-cb">
                <li class="rc-bank-name f-fl">工商银行</li>
                <li class="rc-bank-txt f-fl">
                    <p class="rc-bank-infoF">U盾：单笔、单日100万元</p>
                    <p class="rc-bank-infoS">电子银行口令卡（已开通短信认证）：单笔2000元，单日5000元</p>
                    <p class="rc-bank-infoT">电子银行口令卡（未开通短信认证）：单笔500元，单日1000元</p>
                </li>
            </ul>
            <ul id="BOC_restrict" class="rc-bank-content f-cb">
                <li class="rc-bank-name f-fl">中国银行</li>
                <li class="rc-bank-txt f-fl">
                    <p class="rc-bank-infoF">手机交易码：单笔、单日5000元</p>
                    <p class="rc-bank-infoS">动态口令牌：单笔5万元，单日50万元</p>
                    <p class="rc-bank-infoT">数字证书：单笔5万元，单日50万元</p>
                    <p class="rc-bank-infoF">中银快付：单笔5000元，单日5000元</p>
                </li>
            </ul>
            <ul id="ABC_restrict" class="rc-bank-content f-cb">
                <li class="rc-bank-name f-fl">农业银行</li>
                <li class="rc-bank-txt f-fl">
                    <p class="rc-bank-infoF">K宝：无限额、无限额</p>
                    <p class="rc-bank-infoS">动态口令卡：单笔1000元，单日3000元</p>
                    <p class="rc-bank-infoT">K码：单笔1000元，单日1000元</p>
                </li>
            </ul>
            <ul id="COMM_restrict" class="rc-bank-content f-cb">
                <li class="rc-bank-name f-fl">交通银行</li>
                <li class="rc-bank-txt two-line f-fl">
                    <p class="rc-bank-infoF">短信密码版：单笔、单日5万元</p>
                    <p class="rc-bank-infoS">个人网银证书版：单笔100万元，单日100万元</p>
                </li>
            </ul>
            <ul id="GDB_restrict" class="rc-bank-content f-cb">
                <li class="rc-bank-name f-fl">广发银行</li>
                <li class="rc-bank-txt f-fl">
                    <p class="rc-bank-infoF">手机动态验证码：单笔、单日3000元</p>
                    <p class="rc-bank-infoS">KEY盾：单笔5000元，单日5000元</p>
                    <p class="rc-bank-infoT">Key令：单笔5000元，单日5000元</p>
                    <p class="rc-bank-infoT">卡密：单笔1000元，单日1000元</p>
                </li>
            </ul>
            <ul id="CIB_restrict" class="rc-bank-content f-cb">
                <li class="rc-bank-name f-fl">兴业银行</li>
                <li class="rc-bank-txt two-line f-fl">
                    <p class="rc-bank-infoF">手机动态密码版：单笔5000元，单日5000元</p>
                    <p class="rc-bank-infoS">U盾：单笔100万，柜面/证书开通：日累计限额自行设定</p>
                </li>
            </ul>
            <ul id="SPDB_restrict" class="rc-bank-content f-cb">
                <li class="rc-bank-name f-fl">浦发银行</li>
                <li class="rc-bank-txt two-line f-fl">
                    <p class="rc-bank-infoF">手机动态密码：单笔、单日20万元</p>
                    <p class="rc-bank-infoS">数字证书（浏览器证书或U盾）：单笔100万元，单日无限额</p>
                </li>
            </ul>
            <ul id="SZPAB_restrict" class="rc-bank-content f-cb">
                <li class="rc-bank-name f-fl">平安银行</li>
                <li class="rc-bank-txt one-line f-fl">
                    <p class="rc-bank-infoF">网银：单笔、单日5万元</p>
                </li>
            </ul>
            <ul id="NJCB_restrict" class="rc-bank-content f-cb">
                <li class="rc-bank-name f-fl">南京银行</li>
                <li class="rc-bank-txt one-line f-fl">
                    <p class="rc-bank-infoF">单笔10万，单日1000万元</p>
                </li>
            </ul>
            <ul id="CEB_restrict" class="rc-bank-content f-cb">
                <li class="rc-bank-name f-fl">光大银行</li>
                <li class="rc-bank-txt f-fl">
                    <p class="rc-bank-infoF">手机动态密码：单笔、单日5000元</p>
                    <p class="rc-bank-infoS">令牌动态密码：单笔50万元，单日50万元</p>
                    <p class="rc-bank-infoT">阳光网盾：单笔50万元，单日50万元</p>
                </li>
            </ul>
            <ul id="CMBC_restrict" class="rc-bank-content f-cb">
                <li class="rc-bank-name f-fl">民生银行</li>
                <li class="rc-bank-txt two-line f-fl">
                    <p class="rc-bank-infoF">浏览器证书：单笔、单日5000元</p>
                    <p class="rc-bank-infoS">U宝：单笔50万元，单日50万元</p>
                </li>
            </ul>
            <ul id="CITIC_restrict" class="rc-bank-content f-cb">
                <li class="rc-bank-name f-fl">中信银行</li>
                <li class="rc-bank-txt two-line f-fl">
                    <p class="rc-bank-infoF">动态口令卡：单笔1000元，单日5000元</p>
                    <p class="rc-bank-infoS">移动证书：单笔100万元，单日100万元</p>
                </li>
            </ul>
			<ul id="BCCB_restrict" class="rc-bank-content f-cb">
                <li class="rc-bank-name f-fl">北京银行</li>
                <li class="rc-bank-txt two-line f-fl">
                    <p class="rc-bank-infoF">动态密码版：单笔1000元，单日5000元</p>
                    <p class="rc-bank-infoS">证书版：单笔100万元，单日100万元</p>
                </li>
            </ul>
            <ul id="CBHB_restrict" class="rc-bank-content f-cb">
                <li class="rc-bank-name f-fl">渤海银行</li>
                <li class="rc-bank-txt one-line f-fl">
                    <p class="rc-bank-infoF">单笔2万，单日10万元</p>
                </li>
            </ul>
            <ul id="CZS_restrict" class="rc-bank-content f-cb">
                <li class="rc-bank-name f-fl">浙商银行</li>
                <li class="rc-bank-txt two-line f-fl">
                    <p class="rc-bank-infoF">自助注册：单笔、单日200元</p>
                    <p class="rc-bank-infoS">大众版：单笔1000元，单日1000元</p>
                </li>
            </ul>
            <ul id="PSBC_restrict" class="rc-bank-content f-cb">
                <li class="rc-bank-name f-fl">邮政储蓄银行</li>
                <li class="rc-bank-txt f-fl">
                    <p class="rc-bank-infoF">手机短信用户：单笔、单日1万元</p>
                    <p class="rc-bank-infoS">电子令牌用户：单笔10万元，单日10万元</p>
                    <p class="rc-bank-infoT">Ukey+短信用户：单笔100万元，单日100万元</p>
                </li>
            </ul>
            
        </div>
        <div class="rc-avail-money">
            可用余额<span>${userBalance?string('0.00')!'0.00'}</span>元
        </div>
        <form action="" id="frm" method="post">
	        <div class="rc-input-money">
	            充值金额
	            <input id="amount" type="text" class="rc-input-box" placeholder="充值金额1元起">
	        </div>
	         <p id="rc-cyber-error" class="errorMsg" style="text-indent:140px;"></p>
	        <a href="javascript:getUrlSubmit();" class="cyber-rcBtn">确认充值</a>
        </form>
    </article>
    <section id="cb-recharge-win" class="commonWin">
        <a href="javascript:;" class="closeWin"><img src="../../Public/images/hotClose.png"></a>
        <img src="../../Public/images/warningIcon.png" class="crw-warnImg">
        <p class="crw-warn-txt">充值提示</p>

        <div class="crw-mid-content">
            <p>请您在新打开的网上银行页面进行支付</p>

            <p>支付完成前请不要关闭窗口</p>
        </div>
        <div class="crw-buttons">
            <a href="#" class="crw-recharge-success f-fl">充值成功</a>
            <a href="#" class="crw-problem-success f-fr">遇到问题</a>
        </div>
    </section>
    </section>
</article>
</body>
</html>
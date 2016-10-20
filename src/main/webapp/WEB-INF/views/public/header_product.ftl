<header>
    <nav class="header_First f-cb">
        <section class="mid-Container">
            <div class="hotline f-fl">
                <span class="hotlineText">热线： 400-820-0699</span>
   		<p id="wechatImg" class="wechatImg">
                <img src="${base}/static/Public/images/wechatIcon.png" id="wc-startImg">
                <img src="${base}/static/Public/images/wechatIcon_bright.png" id="wc-changeImg" style="display: none">
                </p>
                <a href="http://weibo.com/p/1006065681260660/home?from=page_100606&mod=TAB&is_hot=1" target="_blank" id="sinaImg" class="sinaImg">
                    <img src="${base}/static/Public/images/sinaIcon.png" id="sina-startImg">
                    <img src="${base}/static/Public/images/sinaIcon_bright.png" id="sina-changeImg" style="display: none">
                </a>
            </div>
            <div class="ub_Div f-fr">
                <a href="${base}/company/appdownload" class="ub_down" target="_blank">APP下载</a>
                <#if !(Session["SESSION_USER"]?exists)>
                <dd class="ub-indentify">
                    <a href="${base}/pcclient/user/access?login=1" id="login_link" class="login_link">登录</a>
                    <p class="ub-line">|</p>
                    <a href="${base}/pcclient/user/access?login=0" id="reg_link" class="reg_link">注册</a>
                </dd>
                <#else>
                <dd class="ub-indentify">
                    <p class="ub-ind-user">欢迎回到多肉理财，&nbsp;<span class="ub-ind-account">${SESSION_USER.userTelephone[0..2]}****${SESSION_USER.userTelephone[7..10]}</span></p>
                    <a href="${base}/pcclient/user/logout" class="ub_out">退出</a>
                </dd>
                </#if>
            </div>
        </section>
    </nav>
    <nav class="header_Second f-cb">
        <section class="mid-Container">
            <a href="${base}/company/index" style="cursor: pointer"><img src="${base}/static/Public/images/index_logo.png" class="logo_Img f-fl"></a>
            <div class="f-fr home-nav-rt">
                <p class="f-cb">
                    <a href="${base}/company/index" class="f-fl home-nav-Btn">首&nbsp;&nbsp;&nbsp;&nbsp;页</a>
                    <a href="${base}/product/productlist" class="f-fl home-nav-Btn clicked-tab">多肉产品</a>
                    <a href="${base}/pcclient/account/userAsset" class="f-fl home-nav-Btn">我的资产</a>
                </p>



            </div>
            <aside id="wechatWin" class="wechatWin">
                <p>多肉理财微信版</p>
                <!--<img src="${base}/static/Public/images/wechat-Code.png" class="wechat_Code">-->
            </aside>
            <aside id="sinaWin" class="sinaWin">
                <p>关注我们的新浪微博</p>
                <a href="http://weibo.com/p/1006065681260660/home?from=page_100606&mod=TAB&is_hot=1" class="sina_link">@多肉理财</a>
            </aside>

        </section>
    </nav>
         <hr class="header-bottom-line">
</header>

<script type="text/javascript">
        $("#sinaImg").hover(function () {
        $("#sinaWin").show();
        $("#sina-changeImg").show();
        $("#sina-startImg").hide();
    }, function () {
        $("#sinaWin").hide();
        $("#sina-changeImg").hide();
        $("#sina-startImg").show();
    });
    $("#wechatImg").hover(function () {
        $("#wechatWin").show();
        $("#wc-changeImg").show();
        $("#wc-startImg").hide();
    }, function () {
        $("#wechatWin").hide();
        $("#wc-changeImg").hide();
        $("#wc-startImg").show();
    });

    $(".home-nav-Btn").hover(function(){
        if(!$(this).hasClass("clicked-tab")){
            $(this).addClass("hover-tab");
        }
    },function(){
        if($(this).hasClass("hover-tab")){
            $(this).removeClass("hover-tab");
        }

    });
</script>
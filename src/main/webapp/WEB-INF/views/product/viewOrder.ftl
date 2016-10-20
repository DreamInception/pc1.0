<!DOCTYPE html>
<html>
<head lang="en">
		<#include "../public/public_head.ftl" >
    <link rel="stylesheet" type="text/css" href="${base}/static/product/css/index.css">
	  ${script!}
      <title>多肉-产品页|http://www.51doro.com-白领阶层互联网资产管理专家</title>
</head>
<body>
<#include "../public/header_product.ftl" >
<article class="mid-Container vo-line-Border">
<p class="vo-page-title">购买确认</p>
 <form id="buy" method="post" action="${base}/product/buy">
  <input type="hidden" name="orderMoney" value="${(money?c)!""}">
  <input type="hidden" id="pdtMaxRaiseRate" name="pdtMaxRaiseRate" value="${(pdtDetail.pdtMax_raise_rate?string("#.####"))!""}">
   <input type="hidden" id="pdtId" name="pdtId" value="${(pdt.id?c)!""}">
   <input type="hidden" name="pdtCycle" id="pdtCycle" value="${(pdt.durationInMinutes?c)!""}">
      <div class="vo-mid-content">
    <section class="product-order-head">
		<div class="f-cb">
                <img src="${base}/static/Public/images/nLogo.png" class="poh-nlogo f-fl">
                <span class="poh-title f-fl">${(pdt.name)!""}</span>
            </div>
        <div class="poh-details">
            <span class="poh-invest-name">投资金额</span><span class="poh-invest-data" id="investMoney">${(money?string("#.##"))!""}</span>元
           
            <span class="poh-rate-name">年化利率</span><span class="poh-rate-data">${((pdt.expectYieldRate*100)?c)!""}%</span>
            <span class="poh-time-name">产品期限</span><span class="poh-time-data" >${(pdt.durationDesc)!""}</span>
        </div>
        <p class="poh-sum-benefit">预计收益<span class="poh-plan-ben">${(profit?string("#.##"))!""}</span>元<span
                class="trycash-payback"></span><span class="coupon-payback"></span></p>
    </section>
     <hr class="vo-line" style="display: none;">
    <section class="product-order-cheap">
  
        <p class="poc-title">我的福利</p>

        <!--<div class="poc-tryCash">-->
            <!--<a href="javascript:void(0)"  id="poc-tc-name" class="poc-tc-name">体验金</a>-->
            <!--<p class="poc-tc-fpb">体验金预计收益<span class="trycash-payback">100</span>元</p>-->
            <!--<p id="poc-intro" class="poc-intro">系统默认赠送体验金，请在<span class="poc-date">3</span>天后查看体验金到期收益 </p>-->
            <!--<article id="availTryCash" class="availTryCash">-->
            <!--<div class="atc-group">-->
            <!--<p class="atc-group-title"><span class="atc-group-num">10000</span>元</p>-->

            <!--<p class="atc-group-sc">来源: 年终奖活动</p>-->

            <!--<p class="atc-group-time">生息周期：-->
            <!--<time class="atc-group-num">2016/04/01 - 2016/04/05</time>-->
            <!--</p>-->
            <!--</div>-->
            <!--</article>-->
            <!--</div>-->
        <div class="poc-ticket">
             <a href="javascript:void(0)" id="poc-tk-name" class="poc-tk-name poc-defaultBg">加息券
            </a>
             <!--<p id="poc-tk-none" class="poc-tk-none">无可用加息券</p>-->
                <!--<p id="poc-tk-close" class="poc-tk-close">未选择可用加息券</p>-->
            <p id="poc-tk-open" class="poc-tk-open">加息券预计收益<span class="ticktet-payback" id="yqsy">0</span>元</p>

            <article id="availTickets" class="availTickets">
                <input type="hidden" name="tatalTicketRate" id="tatalTicketRate">
                 <dl class="at-line">
            <#if list??>
            <#list list as u>
                   //主动加息
                	<#if u.isPassive==0>
                <div class="at-group at-default-bg" id="select${(u.ticketId?c)!""}" onclick="checkTicket(${(u.ticketId?c)!""})">
                	<input type="hidden" name="isPassive" value="${(u.isPassive?c)!""}" id="${(u.ticketId?c)!""}" />
                	<input id="ticket${(u.ticketId?c)!""}" type="hidden" value="${(u.ticketId?c)!""}">
                    <p id="p${(u.ticketId?c)!""}" class="at-group-title"><span class="at-group-num" id="ticketRate${(u.ticketId?c)!""}">${((u.rate*100)?c)!""}</span>%</p>
                     <p id="s${(u.ticketId?c)!""}" class="at-group-sc">来源: <span class="at-group-num">${(u.resource)!""}</span> </p>
                    <p id="t${(u.ticketId?c)!""}" class="at-group-time">有效期:
                        <time class="at-group-num">${(u.expireDate?string("yyyy-MM-dd"))!""}前</time>
                    </p>
                </div>
                //被动加息
                    <#else>
                    <div class="at-group at-select-bg">
                	<input type="hidden" name="isPassive" value="${(u.isPassive?c)!""}" id="${(u.ticketId?c)!""}" />
                	<input id="ticket${(u.ticketId?c)!""}" name="ticketId" type="hidden" value="${(u.ticketId?c)!""}">
                    <p id="p${(u.ticketId?c)!""}" class="at-group-title" style="color: rgb(255, 255, 255);"><span class="at-group-num" id="ticketRate${(u.ticketId?c)!""}">${((u.rate*100)?c)!""}</span>%</p>
                    <p id="s${(u.ticketId?c)!""}" class="at-group-sc"  style="color: rgb(255, 255, 255);">来源: <span class="at-group-num">${(u.resource)!""}</span> </p>
                    <p id="t${(u.ticketId?c)!""}" class="at-group-time" style="color: rgb(255, 255, 255);">有效期:
                        <time class="at-group-num">${(u.expireDate?string("yyyy-MM-dd"))!""}前</time>
                    </p>
                </div>
                    </#if>
                <#if (u_index+1)%4==0>
                	 </dl>
                    <dl class="at-line">
                </#if>
                </#list>
                </#if>
                </dl>
            </article>
        </div>
        
    </section>
 <hr class="vo-line">
    <!--<input id="msgTest" class="vo-msgTest f-fl" placeholder="短信验证码">-->
    <!--<a href="#" class="vo-testCode f-fl">验证码</a>-->

	<section class="product-order-form">
    <p id="vo-msgCode-error" class="errorMsg"></p>
    <input id="payPsw"  type="password" name="payPass" class="payPsw" placeholder="支付密码">
     <a href="${base}/pcclient/safeCenter/resetTransact" class="vo-resetPsw">忘记密码?</a>
    <p class="errorMsg" id="errorMsg"></p>
    <button  class="vo-confirm" id="assign">确认购买</button>
    <button  class="vo-cancel" id="cancel">取消</button>
    <div class="f-cb">
                <!--<input type="checkbox" class="vo-checkbox f-fl" checked="checked">-->
                <input type="checkbox" id="checkbox-1-2" class="vo-checkbox f-fl" checked="checked"/><label for="checkbox-1-2" style="margin-top:20px;"></label>
    <p class="vo-readTxt f-fl">我已阅读并同意
        <a href="${base}/company/contract/${(contractId)!""}/0" class="vo-contract">《产品合同》</a>
        <a href="${base}/company/contract/${(contractId)!""}/1" class="vo-contract">《多肉理财平台购买协议》</a>
    </p>
     </form>
    </div>
   </section>
   </div>
</article>
<script>
 //主动加息券预计收益计算
	function checkTicket(id){
        btnColorChange("vo-confirm","#df4f4b","#cc3a3a");
		var isPassive = $("#isPassive").val();
		//被动加息的加息券，默认选中不能点击，退出方法体
		if(isPassive==1){
			return false;
		}
    	var name = $("#ticket"+id).attr("name");
    	var ticketRate = $("#ticketRate"+id).html()/100;
    	var rate= $("#tatalTicketRate").val()||0;
    	//主动加息券初始没有被选中，为选中的添加name属性标记为选中
    	if(name==""||name == undefined){
    		$("#p"+id).attr("style","color: rgb(255, 255, 255)");
            $("#t"+id).attr("style","color: rgb(255, 255, 255)");
             $("#s"+id).attr("style","color: rgb(255, 255, 255)");
            $("#select"+id).removeClass("at-group at-default-bg");
             $("#select"+id).addClass("at-group at-select-bg");
    		$("#ticket"+id).attr("name","ticketId");
    		$("#tatalTicketRate").val(Number(ticketRate)+Number(rate));
    	}
    	//为取消选中的主动加息券删除name属性
    	else{
    		$("#p"+id).removeAttr("style");
            $("#t"+id).removeAttr("style");
            $("#s"+id).removeAttr("style");
            $("#select"+id).removeClass("at-group at-select-bg");
             $("#select"+id).addClass("at-group at-default-bg");
    		$("#ticket"+id).removeAttr("name");
    		$("#tatalTicketRate").val(Number(rate)-Number(ticketRate));
    	}
    	$.ajax({
    		url:"${base}/product/profit",
    		type:"post",
    		data:{"assetBuyMoney":$("#investMoney").html(),"rate":$("#tatalTicketRate").val(),"cycleDay":$("#pdtCycle").val()},
    		success:function(result){
    			$("#yqsy").html(result.profit);
    		},
    		error:function(result){
    		}
    	});
    }  		
 //被动加息券预计收益计算   
     function rate(){
    	var totalRate=0;
    	$("input[name='isPassive']").each(
			function() {
    		if($(this).val() == 1){
    			var id =$(this).attr("id");
 				totalRate=totalRate+($("#ticketRate"+id).html()/100);
    		}
    		}
		);
		if(totalRate==0){
		$("#tatalTicketRate").val(0);
			return false;
		}
    	$("#tatalTicketRate").val(totalRate);
    	$.ajax({
    		url:"${base}/product/profit",
    		type:"post",
    		data:{"assetBuyMoney":$("#investMoney").html(),"rate":$("#tatalTicketRate").val(),"cycleDay":$("#pdtCycle").val()},
    		success:function(result){
    			$("#yqsy").html(result.profit);
    		},
    		error:function(result){
    		}
    	});
    }  	
    $(function () {
   //页面加载先计算被动加息券的预计收益
   		rate();
   		//点击返回 跳转到产品详情页
    $("#cancel").on("click",function(){
    	var pdtId = $("#pdtId").val();
    	window.location.href="${base}/product/productinfo/"+pdtId;
    	return false;
    });
    	//支付密码验证  如果通过 则表单提交 不通过 则提示密码错误
    	$("#assign").on("click",function(){
    	$("#assign").attr("disabled",true);
    	var pdtMaxRaiseRate = $("#pdtMaxRaiseRate").val();
    	var tatalTicketRate = $("#tatalTicketRate").val();
    	if(pdtMaxRaiseRate!="" && pdtMaxRaiseRate!=undefined){
    	if(Number(tatalTicketRate)>Number(pdtMaxRaiseRate)){
    		$("#assign").attr("disabled",false);
    			showErrorMsg("errorMsg","超过此产品的最大加息限额");
    			return false;
    	}
    	}
    			var password = $("#payPsw").val();
    		if(password=="" || password == undefined){
    			$("#assign").attr("disabled",false);
    			showErrorMsg("errorMsg","请输入支付密码");
    			return false;
    		}
    		var checked = $("#checkbox-1-2").is(':checked')
    		if(!checked){
    			$("#assign").attr("disabled",false);
    			showErrorMsg("errorMsg","请勾选协议");
    			return false;
    		}
    		$.ajax({
    			url:"${base}/product/validatePass",
    			data:{"pass":password},
    			type:"post",
    			success:function(result){
    				if(result.msg>0&&result.msg<5){
    					 showErrorMsg("errorMsg", "交易密码错误,还有"+(5-Number(result.msg))+"机会");
    					$("#assign").attr("disabled",false);
    				}else if(result.msg==5){
    					 showErrorMsg("errorMsg","交易密码被锁");
    					 $("#assign").attr("disabled",false);
    				}else{
    					$("#assign").attr("disabled",true);
    					$("#buy").submit();
    				}
    			},
    			error:function(result){
    			}
    		});
    		return false;
    	});
       // 打开体验金的选择区域
        $("#poc-tc-name").click(function () {
            $(this).css("border", "solid 1px green");
            if ($(".availTryCash").css("display") == 'none') {
                $(".availTryCash").show();
            } else {
                $(".availTryCash").hide();
            }
            ;
        });

       // 打开加息券的选择区域
            $("#poc-tk-name").click(function () {
            if ($("#poc-tk-name").hasClass("poc-defaultBg")) {
                $("#poc-tk-name").removeClass("poc-defaultBg").addClass("poc-clickBg");
                $("#availTickets").show();
                $("#poc-tk-open").show();
            }
            else {
                $("#poc-tk-name").removeClass("poc-clickBg").addClass("poc-defaultBg");
                $("#availTickets").hide();
                $("#poc-tk-open").hide();
            }

        });
         
    });
</script>
<!---------------- footer区域---------------->
<#include "../public/footer.ftl" >
</body>
</html>
$(function () {
	var base = document.getElementById("base").href;
    $(".pd-tab").each(function () {
        $(this).on("click", function (event) {
            var element = event.target;
            tabShow(element, "proby-activeTab");
        });
    });

    $("#product-nav-list a").each(function () {
        $(this).on("click", function (event) {
            var element = event.target;
            tabShow(element, "prodlt-activeTab");
        });
    });
    btnColorChange("pbl-buy-btn","#df4f4b","#cc3a3a");
    btnColorChange("pbl-recharge-btn","#df4f4b","#cc3a3a");
    btnColorChange("pbl-all-invest","#df4f4b","#cc3a3a");

    //全投
    $("#pbl-all-invest").on("click",function(){
    	var availableAmount=$("#availableAmount").val()
    	var maxOrderAmount = $("#maxOrderAmount").val();
    	var all_status = false;
    	var userMoney = parseInt($("#pbl-pocket-num").text()) || 0;
		var num = parseInt($("#pbl-pocket-num").text())/100;
		var accountNum = parseInt(num) * 100 || 0;
    	if(Number(userMoney)<Number(availableAmount)){
    		$("#pbl-money-error").css("visibility", "hidden");
    			$("#pbl-money-sum").val(accountNum);
	      //	$("#tobuy").submit();
    	}else{
    		$("#pbl-money-error").css("visibility", "hidden");
	      	$("#pbl-money-sum").val(availableAmount);
	      //	$("#tobuy").submit();
    	}
    	validateInputMoney();

    });
      
    $("#pbl-money-sum").on("input",validateInputMoney);
});
  function validateInputMoney(){
      	var inputNum = parseInt($("#pbl-money-sum").val()) || 0,
          pocketMoney = parseInt($("#pbl-pocket-num").text()) || 0,
          returnStatus = false,
          maxOrderAmount = $("#maxOrderAmount").val();
      if (isNaN(pocketMoney)){
      	  showErrorMsg("pbl-money-error","请登录");
      } else if (inputNum < $("#minOrderAmount").val()) {
          showErrorMsg("pbl-money-error", "单笔最少起购金额为100元");
          $("#pbl-recharge-btn").attr("disabled", true);
          $("#pbl-buy-btn").attr("disabled", true);
          $(".pbl-buy-btn,.pbl-recharge-btn").css("cursor", "auto");
      } else if (inputNum % 100) {
          showErrorMsg("pbl-money-error", "购买金额需要100的整数倍");
          $("#pbl-recharge-btn").attr("disabled", true);
          $("#pbl-buy-btn").attr("disabled", true);
          $(".pbl-buy-btn,.pbl-recharge-btn").css("cursor", "auto");
      } else if (inputNum > maxOrderAmount) {
          showErrorMsg("pbl-money-error", "单笔最大限额为"+maxOrderAmount+"元");
          $("#pbl-recharge-btn").attr("disabled", true);
          $("#pbl-buy-btn").attr("disabled", true);
          $(".pbl-buy-btn,.pbl-recharge-btn").css("cursor", "auto");
      } else if (inputNum > pocketMoney) {
          showErrorMsg("pbl-money-error", "零钱包余额不足，充值后购买");
          $("#pbl-buy-btn").hide();
          $("#pbl-recharge-btn").show();
          $("#pbl-recharge-btn").attr("disabled", false);
          $(".pbl-buy-btn,.pbl-recharge-btn").css("cursor", "pointer");
          returnStatus = true;
      } else {
          $("#pbl-buy-btn").show();
          $("#pbl-recharge-btn").hide();
          $("#pbl-buy-btn").attr("disabled", false);
          $("#pbl-money-error").css("visibility", "hidden");
          $(".pbl-buy-btn,.pbl-recharge-btn").css("cursor", "pointer");
          returnStatus = true;
      }
      	var assetBuyMoney = $("#pbl-money-sum").val();
//      	if(isNaN(assetBuyMoney)){
//      		$("#pbl-money-sum").val("");
//      		$("#profit").html("");
//      		return false;
//      	}
      	var cycleDay = $("#cycleDay").val();
      	var rate = $("#yieldRate").val();
      	//到期收益
      	if(returnStatus){
      		$.ajax({
      			url:base+'/product/profit',
      			type:'post',
      			data:{'assetBuyMoney':assetBuyMoney,'cycleDay':cycleDay,'rate':rate},
      			success:function(result){
      				$("#profit").html(result.profit);
      			},
      			error:function(result){
      			}
      		});
      	}
      	return returnStatus;
    }
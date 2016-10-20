var base = document.getElementById("base").href;
var bankCode = "CMB";
$(function() {
	$("#rc-open-bank").click(function() {
		if ($(".rc-bank-line").hasClass("rc-hide-line")) {
			$(".rc-bank-line").removeClass("rc-hide-line");
			$(".cyber-show-txt").hide();
			$(".cyber-hide-txt").show();
			$(".cyber-show-img").hide();
			$(".cyber-hide-img").show();
			var rightHeight = $(".acc-right-area").height();
			$(".user-nav-list").css("height", rightHeight + 'px');
		} else {
			$(".rc-bank-line").addClass("rc-hide-line");
			$(".cyber-show-txt").show();
			$(".cyber-hide-txt").hide();
			$(".cyber-show-img").show();
			$(".cyber-hide-img").hide();
			var rightHeight = $(".acc-right-area").height();
			$(".user-nav-list").css("height", rightHeight + 'px');
		}
	});
	$(".rc-bank-ipt p").click(function() {
		var id = $(this).parent().attr("id");
		var index = id.indexOf('_select');
		bankCode = id.substring(0, index);
		var showBankInfo = bankCode + '_restrict';
		if (!$(this).hasClass("cyber-select-checkbox")) {
			$(".rc-bank-ipt p").removeClass("cyber-select-checkbox");
			$(this).addClass("cyber-select-checkbox");
		}
		if ($("#" + showBankInfo).css("display") == 'none') {
			$('.rc-bank-content').hide();
			$("#" + showBankInfo).show();
		}
	});
	$(".rc-bank-ipt img").click(function() {
		var id = $(this).parent().attr("id");
		var index = id.indexOf('_select');
		bankCode = id.substring(0, index);
		var showBankInfo = bankCode + '_restrict';
		if (!$(this).siblings(".cyber-unselect-checkbox").hasClass("cyber-select-checkbox")) {
			$(".rc-bank-ipt p").removeClass("cyber-select-checkbox");
			$(this).siblings(".cyber-unselect-checkbox").addClass("cyber-select-checkbox");
		}
		if ($("#" + showBankInfo).css("display") == 'none') {
			$('.rc-bank-content').hide();
			$("#" + showBankInfo).show();
		}
	});
	
	$("#amount").on("input",function(event){
		var $this = event.target;
		//alert($this.value);
		if(/^(\d){1,15}$/.test($this.value)){
			$("#rc-cyber-error").css("visibility", "hidden");
			return true;
		}else{
			showErrorMsg("rc-cyber-error","充值金额必须为正整数");
			return false;
		}
	});
	

});

// 弹出充值成功提示窗口
function openWindow() {
	var closeHeight = $(".closeWin").height();
	$(".closeWin").css("top", '-' + closeHeight + 'px');
	windowShow("cb-recharge-win");
	$(".closeWin").click(function() {
		windowHide("cb-recharge-win");
	})
}

// 获取新浪充值地址，打开新页面并提交表单
function getUrlSubmit() {
	var amount = $("#amount").val().trim();

	if (amount && amount != "") {
		$.ajax({
			type : 'post',
			url : base + '/pcclient/finance/bankCharge',
			async : true,
			dataType : "json",
			data : {
				amount : amount,
				bankCode : bankCode
			},
			success : function(data) {
				console.log("result data is =====" + data);
				if (data.errMsg == "操作成功！") {
//					openWindow();
					var jumpToUrl = data.rows[0].jumpToUrl;
					var amount = data.rows[0].amount;
					var frm = $("#frm");
                    frm.attr("action", jumpToUrl);
                    frm.submit();
//					var param = {
//						amount : amount
//					};
//					post(jumpToUrl, param);
				} else {
					alert(data.errMsg);
				}
			},
			error : function(XMLHttpRequest, error, errorThrown, data) {
				alert(data.errMsg);
			}
		});
	}
}

// 打开页面提交参数
function post(URL, PARAMS) {
	var temp_form = document.createElement("form");
	temp_form.action = URL;
	temp_form.target = "_blank";
	temp_form.method = "post";
	temp_form.style.display = "none";
	for ( var x in PARAMS) {
		var opt = document.createElement("textarea");
		opt.name = x;
		opt.value = PARAMS[x];
		temp_form.appendChild(opt);
	}
	document.body.appendChild(temp_form);
	temp_form.submit();
}
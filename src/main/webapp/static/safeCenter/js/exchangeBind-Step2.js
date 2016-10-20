$(function(){
	var html = '';
	    $("#province").selectmenu();
    $("#city").selectmenu();
    $("#bankCode").selectmenu();
var base = $("#base").attr("href");
//下拉市区
function onSelectChange(obj, toSelId) {
	setSelect(obj.value, toSelId);
}
// 加载省级下拉
setSelect(1, "#province");

$("#province").on("selectmenuchange",function(){
   	var obj = this;
    onSelectChange(obj,'#city');
    $("#province").selectmenu("destroy");
    $("#city").selectmenu("destroy");
    });
});
function setSelect(fromSelVal, toSelId, value) {
	$.post(base + "/area/getAddress", {
		parentId : fromSelVal
	}, function(result) {
		console.log("result=================="+result);
		var map = result.rows;
		html = '<option value=""' + '>请选择 </option>';
		for ( var index in map) {
			var city = map[index];
			html += '<option  value="' + city.areaId + '">' + city.areaName
					+ '</option>';
						console.log("html=================="+html);
		}
		$(toSelId).html(html);
//		$(toSelId).selectmenu("option", "appendTo",html);
//			console.log("selectmenu html=================="+$(toSelId).selectmenu("value"));
		if (value != undefined) {
			$(toSelId).val(value);
		}
		 $("#province").selectmenu();
         $("#city").selectmenu();
	}, "json");
}

//换绑银行卡短信
function bankSendText(phoneId,msgCodeId, errorId, msg) {
	// 真实姓名
	var bankCardRealName = $('#eb-card-name').val();
	// 银行卡编码
	var bankCode = $('#eb-bankCode').val();
	// 银行卡卡号
	var bankCardNumber = $('#bankCardNumber').val();
	// 银行预留手机
	var bankCardReservedPhone = $('#eb-bank-phoneNum').val();
	// 开户银行
	var bankCardCity = $('#city').val();
	var phoneObj = $("#"+phoneId);
	var msgCodeObj = $("#" + msgCodeId),
	intervalTimeObj = null,// timer变量，控制时间
	count = 60,// 间隔函数，1秒执行
	leftCount = 60,// 当前剩余秒数
	code = '',// 验证码
	codeLength = 6;// 验证码长度
	
	  if(phoneObj.val() != ""){
		msgCodeObj.attr("disabled", "true").css("background", "#c2c2c2").css(
				"cursor", "pointer");
		msgCodeObj.val(count + "秒后重新获取");
		intervalTimeObj = window.setInterval(setRemainTime, 1000);
	
		$("#" + errorId).css("visibility", "hidden");
		// 向后台发送处理数据
		$.ajax({
		type : 'post',
		url : base + '/pcclient/withdraw/exchangeBind',
		async : true,
		dataType : "json",
		data : {
			bankCardRealName : bankCardRealName,
			bankCode : bankCode,
			bankCardNumber : bankCardNumber,
			bankCardReservedPhone : bankCardReservedPhone,
			bankCardCity : bankCardCity
		},
		success : function(data) {
			if (data.errMsg == "操作成功！") {
				$('#ticket').val(data.rows[0]);
				alert("短信已发送！");
			} else {
				alert(data.errMsg);
			}
		},
		error : function(XMLHttpRequest, error, errorThrown, data) {
			alert("出错！");
		}
		});
	 }
    else{
        showErrorMsg(errorId,msg);
    }
		function setRemainTime() {
			if (leftCount == 0) {
				clearInterval(intervalTimeObj);
				msgCodeObj.removeAttr("disabled");
				msgCodeObj.val("重新获取验证码").css("background", "#e74d46").css("cursor",
						"pointer");
				code = '';
			} else {
				leftCount--;
				msgCodeObj.val(leftCount + "秒后重新获取");
			}
	
	
	}
	
}

//表单数据检查，验证短信
function checkTexting() {
	// 真实姓名
	var bankCardRealName = $('#eb-card-name').val();
	// 银行卡编码
	var bankCode = $('#bankCode').val();
	// 银行卡卡号
	var bankCardNumber = $('#bankCardNumber').val();
	// 银行预留手机
	var bankCardReservedPhone = $('#eb-bank-phoneNum').val();
	// 开户银行
	var bankCardCity = $('#city').val();
	// 短信验证码
	var texting = $('#sms-msgCode').val();
	// ticket
	var ticket = $('#ticket').val();

	if (bankCardRealName == '' ||  bankCode == ''
			|| bankCardNumber == '' || bankCardReservedPhone == ''
			|| bankCardCity == '' || texting == '') {
		alert("表单数据不能为空！");
		return;
	}

	$.ajax({
		type : 'post',
		url : base + '/pcclient/user/bindOver',
		async : true,
		dataType : "json",
		data : {
			texting : texting,
			ticket : ticket
		},
		success : function(data) {
			if (data.errMsg == "操作成功！") {
				window.location.href = base + "/pcclient/withdraw/bindCardSuccess";
			} else {
				window.location.href = base + "/pcclient/withdraw/bindCardFail?msg="+data.errMsg;
			}
		},
		error : function(XMLHttpRequest, error, errorThrown, data) {
			alert("出错！");
		}
	});
}







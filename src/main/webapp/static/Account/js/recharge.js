var base = document.getElementById("base").href;
// 充值短信
function rechargeText(msgCodeId, errorId, msg, randImg) {
	var amount = $('#rechargeNum').val(), msgCodeObj = $("#" + msgCodeId), intervalTimeObj = null, // timer变量，控制时间
	count = 60, // 间隔函数，1秒执行
	leftCount = 60, // 当前剩余秒数
	code = '', // 验证码
	codeLength = 6;// 验证码长度
	if (amount == "" || amount <= 0) {
		alert("充值金额必须为正数并不为0！");
		return;
	}

	msgCodeObj.attr("disabled", "true").css("background", "#c2c2c2").css(
			"cursor", "pointer");
	msgCodeObj.val(count + "秒后重新获取");
	intervalTimeObj = window.setInterval(setRemainTime, 1000);

	$("#" + errorId).css("visibility", "hidden");
	var randImgObj = $("#" + randImg).val();
	// 向后台发送处理数据
	$.ajax({
		type : 'post',
		url : base + '/pcclient/finance/recharge',
		async : true,
		dataType : "json",
		data : {
			amount : amount,
			randImg : randImgObj
		},
		success : function(data) {
			if (data.errMsg == "操作成功！") {
				$('#ticket').val(data.rows[0]);
				alert("短信发送成功！");
			} else {
				alert(data.errMsg);
				refreshRand("randimg");
			}
		},
		error : function(XMLHttpRequest, error, errorThrown, data) {
			refreshRand("randimg");
			alert(data.errMsg);
		}
	});
	function setRemainTime() {
		if (leftCount == 0) {
			clearInterval(intervalTimeObj);
			msgCodeObj.removeAttr("disabled");
			msgCodeObj.val("重新获取验证码").css("background", "#e74d46").css(
					"cursor", "pointer");
			code = '';
		} else {
			leftCount--;
			msgCodeObj.val(leftCount + "秒后重新获取");
		}
	}

}

// 短信验证
function rechargeVerify() {
	var ticket = $('#ticket').val();
	var texting = $('#texting').val();
	$.ajax({
				type : 'post',
				url : base + '/pcclient/finance/rechargeVerify',
				async : true,
				dataType : "json",
				data : {
					ticket : ticket,
					smsCode : texting
				},
				success : function(data) {
					if (data.errMsg == "操作成功！") {
						// 充值成功
						window.location.href = base
								+ "/pcclient/account/userAccount?chargeSuccess=true";
					} else {
						alert(data.errMsg);
						// 充值失败
						window.location.href = base
								+ "/pcclient/account/userAccount?chargeSuccess=false&reason="
								+ data.errMsg;
					}
				},
				error : function(XMLHttpRequest, error, errorThrown, data) {
					alert(data.errMsg);
				}
			});
}

// 刷新验证码
function refreshRand(id) {
	var getimage = document.getElementById(id);
	getimage.src = base + "/authImage/image?sid=" + Math.random();
}
var base = document.getElementById("base").href;
// 重置密码(已登录)
function resetPwd() {
	var result = [];
	var tele = $('#rlp-phoneNum').val();
	var pwd = $('#rlp-pwd').val();
	var confirmpwd = $('#rlp-confirmPsw').val();
	var texting = $('#texting').val();
	var ticket = $('#ticket').val();
	if (pwd != confirmpwd) {
		alert("两次密码输入不一致!");
		return;
	}

	$
			.ajax({
				type : 'post',
				url : base + '/pcclient/safeCenter/resetLoginPwd',
				async : true,
				dataType : "json",
				data : {
					phone : tele,
					pwd : pwd,
					texting : texting,
					ticket : ticket
				},
				success : function(data) {
					if (data.errMsg == "操作成功！") {
						refreshRand("resetLogin");
						window.location.href = base
								+ "/forward/forwardURL?url=safeCenter/resetLoginPsw-Success";
					} else {
						alert(data.errMsg);
						refreshRand("resetLogin");
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
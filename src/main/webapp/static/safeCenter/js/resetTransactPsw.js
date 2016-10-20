var base = document.getElementById("base").href;
function resetTransact() {
	var result = [];
	var tele = $('#rlp-phoneNum').val();
	var pwd = $('#rlp-pwd').val();
	var checkPwd = $('#rlp-confirmPsw').val();
	var texting = $('#texting').val();
	var ticket = $('#ticket').val();
	if(pwd != checkPwd){
		alert("两次密码输入不一致！");
		return;
	}
	$
			.ajax({
				type : 'post',
				url : base + '/pcclient/safeCenter/resetTransactPwd',
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
						window.location.href = base
								+ "/forward/forwardURL?url=safeCenter/resetTransactPsw-Success";
						
					} else {
						alert(data.errMsg);
					}
				},
				error : function(XMLHttpRequest, error, errorThrown, data) {
					alert(data.errMsg);
				}
			});
}

//刷新验证码
function refreshRand(id) {
	var getimage = document.getElementById(id);
	getimage.src = base + "/authImage/image?sid=" + Math.random();
}
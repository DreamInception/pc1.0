var base = document.getElementById("base").href;
//重置密码(未登录)
function reSetPwd() {
	var result = [];
	var tele = $('#urw-phoneNum').val();
	var pwd = $('#password').val();
	var checkpwd = $('#checkpwd').val();
	var texting = $('#texting').val();
	var ticket = $('#ticket').val();
	if(pwd != checkpwd){
		alert("两次密码输入不匹配!");
		return;
	}
	$.ajax({
		type : 'post',
		url : base + '/pcclient/user/resetPwdUnlogin',
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
			//	window.location.href = base + "/pcclient/user/access";
				window.location.href = base + "/forward/forwardURL?url=user/resetPsw-Success";
			} else {
				alert(data.errMsg);
			}
		},
		error : function(XMLHttpRequest, error, errorThrown,data) {
			alert(data.errMsg);
		}
	});
}

//刷新验证码
function refreshRand(id) {
	var getimage = document.getElementById(id);
	getimage.src = base + "/authImage/image?sid=" + Math.random();
}
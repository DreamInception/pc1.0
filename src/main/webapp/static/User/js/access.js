/**
 * Created by GuoXiang on 2016/3/7.
 */
$(function() {
	var source = getQueryString("phone");

	if (source != '' && /^1[3|4|5|6|7|8]\d{9}$/.test(source)) {
		$("#recommend-phoneNum").val(source);
	}

	var loginPsw = '';
	imgCode = '';
	$("#login-container-tab").on("click", function(event) {
		var element = event.target;
		tabShow(element, "access-activeTab");
	});
	$("#reg-container-tab").on("click", function(event) {
		var element = event.target;
		tabShow(element, "access-activeTab");
	});

	// 登录、注册TAB切换
	var url = window.location.href;
	pos = url.indexOf("login=");
	if (pos != -1) {
		var str = url.substr(parseInt(pos) + 6, 1);
		console.log("url parameter is " + str);
		switch (str) {
		case '1':
			tabShow($("#login-container-tab"), "access-activeTab");
			break;
		case '0':
			tabShow($("#reg-container-tab"), "access-activeTab");
			break;
		default:
			tabShow($("#login-container-tab"), "access-activeTab");
		}
	}

	checkRegForm();
	checkLoginForm();
	btnColorChange("registerBtn", "#df4f4b", "#cc3a3a");
	btnColorChange("loginBtn", "#df4f4b", "#cc3a3a");
	function checkRegForm() {
		$("#reg-phoneNum").on("blur", function(event) {
			var element = event.target;
			validatePhoneNum(element, "reg-phoneNum-error", "请输入正确的手机号码");

		});
		$("#reg-loginPsw").on("blur", function(event) {
			var element = event.target;
			loginPsw = event.target.value;
			validatePassword(element, "reg-loginPsw-error", "密码不正确");
		});
		$("#reg-confirmPsw").on(
				"blur",
				function(event) {
					var element = event.target;
					validateSecondPsw(element, loginPsw,
							"reg-confirmPsw-error", "两次输入的密码不符");
				});
//		imgCode = createCode("dymCode");
//		$("#dymCode").on("click", function() {
//			createCode("dymCode");
//		});
	}
	function checkLoginForm() {
		$("#log-phoneNum").on("blur", function(event) {
			var element = event.target;
			validatePhoneNum(element, "log-phoneNum-error", "请输入正确的手机号码");

		});
		$("#log-loginPsw").on("blur", function(event) {
			var element = event.target;
			loginPsw = event.target.value;
			validatePassword(element, "log-loginPsw-error", "密码不正确");
		});
	}
	// $("#inputCode").input(function(){
	// var inputCode = $("#inputCode").val();
	// if(inputCode.length<=0){
	// alert("请输入验证码！");
	// return false;
	// }
	// else if(inputCode!=createCode){
	// alert("验证码输入错误!");
	// createCode();
	// return false;
	// }else{
	// console.log("验证码正确");
	// return true;
	// }
	// })
	$("#log-free-reg").click(function() {
		$("#reg-container-tab").trigger("click");
	});
	$("#reg-to-login").click(function() {
		$("#login-container-tab").trigger("click");
	})

	$('#loginRand').bind('keypress', function(event) {
		if (event.keyCode == "13") {
			loginCheck();
		}
	});

	$('#texting').bind('keypress', function(event) {
		if (event.keyCode == "13") {
			register();
		}
	});
})

var base = document.getElementById("base").href;

// 验证表单,登录
function loginCheck() {
	var result = [];
	var tele = $('#log-phoneNum').val();
	var pass = $('#log-loginPsw').val();
	var loginRand = $('#loginRand').val();
	$.ajax({
		type : 'post',
		url : base + '/pcclient/user/login',
		async : true,
		dataType : "json",
		data : {
			telephone : tele,
			password : pass,
			loginRand : loginRand
		},
		success : function(data) {
			if (data.errMsg == "操作成功！") {
				refreshRand("loginRand");
				window.location.href = base + "/pcclient/account/userAsset";
			} else {
				alert(data.errMsg);
				refreshRand("randimg");
			}
		},
		error : function(XMLHttpRequest, error, errorThrown, data) {
			refreshRand("randimg");
			alert("出错！");
		}
	});
}

// 获取url参数source
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

// 注册
function register() {
	var result = [];
	var tele = $('#reg-phoneNum').val();
	var pass = $('#reg-loginPsw').val();
	var texting = $('#texting').val();
	var ticket = $('#ticket').val();
	var recommend = $('#recommend-phoneNum').val();
	var source = getQueryString("source");
	if ($('#checkbox-1-2').attr('unchecked')) {
		alert("请阅读平台协议，并同意！");
		return;
	}
	$.ajax({
		type : 'post',
		url : base + '/pcclient/user/register',
		async : true,
		dataType : "json",
		data : {
			telephone : tele,
			password : pass,
			texting : texting,
			ticket : ticket,
			recommend : recommend,
			source : source
		},
		success : function(data) {
			if (data.errMsg == "操作成功！") {
				refreshRand("regimg");
				window.location.href = base
						+ "/forward/forwardURL?url=user/register-Success";
			} else {
				alert(data.errMsg);
				refreshRand("regimg");
			}
		},
		error : function(XMLHttpRequest, error, errorThrown, data) {
			refreshRand("regimg");
			alert(data.errMsg);
		}
	});
}

// 刷新验证码
function refreshRand(id) {
	var getimage = document.getElementById(id);
	getimage.src = base + "/authImage/image?sid=" + Math.random();
}

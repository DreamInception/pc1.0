var base = document.getElementById("base").href;
var tranPsw = '';
var firstPsw = false;
var secondPsw = false;
$(function() {
			btnColorChange("uit-confirm", "#df4f4b", "#cc3a3a");
			$("#user-first-password").on("input", function(event) {
						var element = event.target;
						tranPsw = event.target.value;
						firstPsw = validateTransactPsw(element, "user-fpsw-error",
								"请设置6位数字交易密码");
								console.log("first psw is"+firstPsw);
					});
			$("#user-second-password").on("input", function(event) {
				var element = event.target;
				secondPsw = validateSecondPsw(element, tranPsw, "user-spsw-error",
						"两次输入的交易密码不符");
						console.log("second psw is"+secondPsw);
			});

		});
function setTransactPwd() {
	var result = [];
	var pwd = $('#user-first-password').val();
	if(firstPsw && secondPsw){
		$.ajax({
				type : 'post',
				url : base + '/pcclient/safeCenter/setTransactPwd',
				async : true,
				dataType : "json",
				data : {
					pwd : pwd
				},
				success : function(data) {
					if (data.errMsg == "操作成功！") {
						window.location.href = base
								+ "/pcclient/user/bindCardPage";
					} else {
						alert(data.errMsg);
					}
				},
				error : function(XMLHttpRequest, error, errorThrown, data) {
					alert("出错！");
				}
			});
	}	
}
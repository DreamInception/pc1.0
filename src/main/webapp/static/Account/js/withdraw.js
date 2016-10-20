var base = document.getElementById("base").href;
//提现
function withdraw() {
	var amount = $('#amount').val();
	var tradePwd = $('#withdraw-psw').val();
	$.ajax({
		type : 'post',
		url : base + '/pcclient/withdraw/withdraw',
		async : true,
		dataType : "json",
		data : {
			amount : amount,
			tradePwd : tradePwd,
		},
		success : function(data) {
			if (data.errMsg == "操作成功！") {
				//取现成功
				window.location.href = base + "/pcclient/account/userAccount?withdrawSuccess=true";
			} else {
				alert(data.errMsg);
				//取现失败
				window.location.href = base + "/pcclient/account/userAccount?withdrawSuccess=false";
			}
		},
		error : function(XMLHttpRequest, error, errorThrown, data) {
			alert(data.errMsg);
		}
	});
}
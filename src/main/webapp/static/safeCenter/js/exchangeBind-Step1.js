var base = document.getElementById("base").href;
//提现
function withdraw() {
	var amount = $('#eb-depositMoney').val();
	var tradePwd = $('#tradePwd').val();
	tradePwd = tradePwd.replace(/,/g, "");
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
				window.location.href = base + "/pcclient/withdraw/exchangeBindPage2";
			}else if(data.errMsg=="余额或冻结资金未取出,无法换绑！"){
				alert(data.errMsg);
				window.location.href = base + "/pcclient/safeCenter/exchangeBindPageStep1";
			} else {
				alert(data.errMsg);
			}
		},
		error : function(XMLHttpRequest, error, errorThrown, data) {
			alert(data.errMsg);
		}
	});
}
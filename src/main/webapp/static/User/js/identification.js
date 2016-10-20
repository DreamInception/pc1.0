var base = document.getElementById("base").href;
// 身份验证
function identification() {
	var realName = $('#uit-name').val();
	var idCardNumber = $('#uit-number').val();
	if (realName == '') {
		$("#uit-name-error").val("姓名不能为空！");
		$("#uit-name-error").css('visibility', 'visible');
		return;
	}
	if ($("#checkbox-1-2").attr('unchecked')) {
		alert("请先阅读协议，并同意！");
		return;
	}
	$.ajax({
		type : 'post',
		url : base + '/pcclient/identification/identification',
		async : true,
		dataType : "json",
		data : {
			realName : realName,
			idCardNumber : idCardNumber
		},
		success : function(data) {
			if (data.errMsg == "操作成功！") {
				window.location.href = base
						+ "/pcclient/safeCenter/setTransactPage";
			} else {
				validateIDNumber("uit-number-error","uit-number-error",data.errMsg);
			}
		},
		error : function(XMLHttpRequest, error, errorThrown, data) {
			alert("出错！");
		}
	});
}
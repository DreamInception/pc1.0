var base = document.getElementById("base").href;
//局部刷新页面
function refresh(inteval, d) {
	if (d == "") {
		d = null;
	}
	$("#ticket_record_detail").html("");
	$.ajax({
		type : 'post',
		url : base + '/pcclient/account/ticketDetailRefresh',
		cache : false,
		async : true,
		dataType : "html",
		data : {
			inteval : inteval,
			d : d
		},
		success : function(data) {
			$('#ticket_record_detail').html(data);
		},
		error : function(XMLHttpRequest, error, errorThrown, data) {
			alert(data.errMsg);
		}
	});
}
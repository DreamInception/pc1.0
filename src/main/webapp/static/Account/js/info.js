var base = document.getElementById("base").href;

$(function() {
	$(".info-title").click(function() {
		$(this).parent().find(".point").css("visibility", "hidden");
		$(this).parent().parent().find(".info-description").toggle();
	});
	    var totalPages = $("#pageCount").val() || 0;
    laypage({
    	cont : 'info-page-number',
    	pages : totalPages,
    	skin : '#e74d46',
    	skip : false,
    	first: '首页',
    	last: '尾页',
    	curr: location.hash.replace('page=',''),
        hash: 'page',
    	jump : function(obj,first){
    		refresh(obj.curr,"","");
    
    	}
    });


// 分页筛选模块jQuery加载
function refresh(ptype, pisReaded, ppageNum) {
	var type = ptype;// 消息类型，默认1：公共消息，2：个人消息，3：空值
	var isReaded = pisReaded;// 消息是否已阅，默认0：未阅，1：已阅，2：空值
	var pageNum = ppageNum;// 页数
	$("#refresh").html("");
	$.ajax({
		type : 'post',
		url : base + '/pcclient/account/infoRefresh',
		cache : false,
		async : true,
		dataType : "html",
		data : {
			type : type,
			isReaded : isReaded,
			pageNum : pageNum
		},
		success : function(data) {
			$('#refresh').html(data);
		},
		error : function(XMLHttpRequest, error, errorThrown, data) {
			alert(data.errMsg);
		}
	});
}

//消息已读标记
function infoReadMask(id){
	$.ajax({
		type : 'post',
		url : base + '/pcclient/Info/markInfo',
		async : true,
		dataType : "json",
		data : {
			id : id
		}
	});
}
})
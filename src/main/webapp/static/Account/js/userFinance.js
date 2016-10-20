var base = document.getElementById("base").href;
$(function(){
	// 分页插件
    var totalPages = $("#pageCount").val() || 0;
    loadPagination(totalPages);
});   
 
function loadPagination(pageSum,days, datetime){
	 laypage({
    	cont : 'fin-page-number',
    	pages : pageSum,
    	skin : '#e74d46',
    	skip : false,
    	first: '首页',
    	last: '尾页',
    	curr: location.hash.replace('page=',''),
        hash: 'page',
    	jump : function(obj,first){
    		refresh(obj.curr,days,datetime);
    
    	}
    });
}
// 分页筛选模块jQuery加载
function refresh(ppageNum, days, datetime) {
	var pageNum = ppageNum;// 页数
	$("#refresh").html("");
	$.ajax({
		type : 'post',
		url : base + '/pcclient/account/refreshFinance',
		cache : false,
		async : true,
		dataType : "html",
		data : {
			pageNum : pageNum,
			days : days,
			datetime : datetime
		},
		success : function(data) {
			$('#refresh').html(data);
		},
		error : function(XMLHttpRequest, error, errorThrown, data) {
			alert(data.errMsg);
		}
	});
}
// 点击tab标签或日期时重新分页
function refreshPageSum(ppageNum, days, datetime) {
	var pageNum = ppageNum;// 页数
	$("#refresh").html("");
	$.ajax({
		type : 'post',
		url : base + '/pcclient/account/refreshFinance',
		cache : false,
		async : true,
		dataType : "html",
		data : {
			pageNum : pageNum,
			days : days,
			datetime : datetime
		},
		success : function(data) {
			$('#refresh').html(data);
			var pageCount = $("#ajax_pageCount").val() || 0;
			//alert(pageCount);
			$('#refresh').html("");
			console.log('pageCount=============='+pageCount);
			loadPagination(pageCount,days,datetime);
		},
		error : function(XMLHttpRequest, error, errorThrown, data) {
			alert(data.errMsg);
		}
	});
}
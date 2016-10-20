var base = document.getElementById("base").href;
$(function() {
	var reason = getQueryString("reason");
	if (reason != null) {
		;
	}
	var rightHeight = $(".user-detail").height();
	$(".user-nav-list").css("height", rightHeight + 'px');
	btnColorChange("add-money-btn", "#df4f4b", "#cc3a3a");
	$("#abo-from-input").datepicker({
		dateFormat : "yy-mm-dd",
		minDate : new Date(2007, 1 - 1, 1),
		maxDate : "+0d"
	});
	$("#abo-to-input").datepicker({
		dateFormat : "yy-mm-dd",
		minDate : new Date(2007, 1 - 1, 1),
		maxDate : "+0d"
	});

	$("#abo-short-term").on("click", function(event) {
		var element = event.target;
		tabShow(element, "abo-activeTab");
		$("#abo-from-input").datepicker("setDate", getBeforeTwoWeek());
		var startDay = $("#abo-from-input").datepicker("getDate");
		var startTime = getFormatDate(startDay);
		$("#abo-to-input").datepicker("setDate", getYesterday());
		var endDay = $("#abo-to-input").datepicker("getDate");
		var endTime = getFormatDate(endDay);
		console.log("---------------Show Two week is from "+startTime+"---------------Two week is to "+endTime);
		// 传日期查询条件到服务器
		refreshPageSum("", startTime, endTime);
		if(startTime && startTime!=''){
			$("#abo-to-input").datepicker("option", "minDate", startTime);
		}
		if(endTime && endTime!=''){
			$("#abo-from-input").datepicker("option", "maxDate", endTime);
		}
	});
	$("#abo-long-term").on("click", function(event) {
		var element = event.target;
		tabShow(element, "abo-activeTab");
		$("#abo-from-input").datepicker("setDate", getBeforeOneMonth());
		var startDay = $("#abo-from-input").datepicker("getDate");
		var startTime = getFormatDate(startDay);
		$("#abo-to-input").datepicker("setDate", getYesterday());
		var endDay = $("#abo-to-input").datepicker("getDate");
		var endTime = getFormatDate(endDay);
		console.log("---------------Show One Month is from "+startTime+"---------------Two week is to "+endTime);
		// 传日期查询条件到服务器
		refreshPageSum("", startTime, endTime);
		if(startTime && startTime!=''){
			$("#abo-to-input").datepicker("option", "minDate", startTime);
		}
		if(endTime && endTime!=''){
			$("#abo-from-input").datepicker("option", "maxDate", endTime);
		}
	});
	$("#abo-from-input").change(function() {
		$("#abo-short-term").removeClass("abo-activeTab");
		$("#abo-long-term").removeClass("abo-activeTab");
		var startDay = $("#abo-from-input").datepicker("getDate");
		var startTime = getFormatDate(startDay);
		var endDay = $("#abo-to-input").datepicker("getDate");
		var endTime = getFormatDate(endDay);
		if(startTime && startTime!=''){
			$("#abo-to-input").datepicker("option", "minDate", startTime);
		}
		console.log("abo-from-input startTime date is ========="+startTime);
		
		refreshPageSum("", startTime, endTime);
	});
	$("#abo-to-input").change(function() {
		$("#abo-short-term").removeClass("abo-activeTab");
		$("#abo-long-term").removeClass("abo-activeTab");
		var startDay = $("#abo-from-input").datepicker("getDate");
		var startTime = getFormatDate(startDay);
		var endDay = $("#abo-to-input").datepicker("getDate");
		var endTime = getFormatDate(endDay);
		if(endTime && endTime!=''){
			$("#abo-from-input").datepicker("option", "maxDate", endTime);
		}
		console.log("abo-to-input endTime date is ========="+endTime);
		refreshPageSum("", startTime, endTime);
	});
	// 分页插件
    var totalPages = $("#pageCount").val() || 0;
    loadPagination(totalPages,"","");
});
	// 格式化日期
	function getFormatDate(date) {
		var year = date.getFullYear(), month = date.getMonth() + 1, day = date
				.getDate();
		if (month < 10)
			month = "0" + month;
		if (day < 10)
			day = "0" + day;
		var dateString = year + "-" + month + "-" + day;
		return dateString;
	}
	// 获取昨天日期
	function getYesterday() {
		var date = new Date();
		var beforeTwoWeekDay = calBeforeXdate(date, 1);

		return beforeTwoWeekDay;
	}
	// 获取两周前日期
	function getBeforeTwoWeek() {
		var date = new Date();
		var beforeTwoWeekDay = calBeforeXdate(date, 14);

		return beforeTwoWeekDay;
	}
	// 获取一个月前日期
	function getBeforeOneMonth() {
		var date = new Date();
		var beforeLastMonthDay = calBeforeXdate(date, 31);
		return beforeLastMonthDay;
	}

	// 获取每月最后一天日期
	function getLastMonthDate(year, month) {
		var lastday = 0;
		seperator = "-";
		lastmonth = month - 1;
		currentday = 0;
		if (lastmonth == 0) {
			lastmonth = 12;
			year = year - 1;
		}
		if (lastmonth == 1 || lastmonth == 3 || lastmonth == 5
				|| lastmonth == 7 || lastmonth == 8 || lastmonth == 10
				|| lastmonth == 12) {
			lastday = 31;
		} else if (lastmonth == 2 && year % 4 == 0) {
			lastday = 29;
		} else if (lastmonth == 2 && year % 4 != 0) {
			lastday = 28;
		} else {
			lastday = 30;
		}
		currentday = year + seperator + lastmonth + seperator + lastday;
		return currentday;
	}

	// 计算日期公共方法(日期，天数）
	function calBeforeXdate(date, during) {
		// var date = new Date();
		var startday = 0;
		lastMonthDate = 0;
		seperator = "-";
		year = date.getFullYear();
		month = parseInt(date.getMonth() + 1);
		day = date.getDate();
		if (month >= 1 & month <= 9) {
			month = '0' + month;
		}
		for (i = 0; i < during; i++) {
			if (day >= 1 & day <= 9) {
				day = '0' + day;
			}
			if (day <= 0) {
				lastMonthDate = getLastMonthDate(year, month);
				year = lastMonthDate.split("-")[0];
				month = lastMonthDate.split("-")[1];
				day = lastMonthDate.split("-")[2];
				if (day >= 1 & day <= 9) {
					day = '0' + day;
				}
				if (month >= 1 & month <= 9) {
					month = '0' + month;
				}
			}
			// var currentday = year + seperator + month + seperator + day;
			// var currentday = month + seperator + day;
			day--;
		}
		startday = year + seperator + month + seperator + day;

		return startday;

	}


function loadPagination(pageSum, startTime, endTime){
// 分页插件
    
    laypage({
    	cont : 'acc-page-number',
    	pages : pageSum,
    	skin : '#e74d46',
    	skip : false,
    	first: '首页',
    	last: '尾页',
    	curr: location.hash.replace('page=',''),
        hash: 'page',
    	jump : function(obj,first){
    		refresh(obj.curr,startTime, endTime);
    		
    	}
    });
}
// 分页筛选模块jQuery加载
function refresh(pageNum, startTime, endTime) {
	console.log("refresh method currPage===="+pageNum+"\n startTime==========="+startTime+"\n endTime==========="+endTime);
	$.ajax({
		type : 'post',
		url : base + '/pcclient/account/refreshAccount',
		cache : false,
		async : true,
		dataType : 'html',
		data : {
			pageNum : pageNum,
			startTime : startTime,
			endTime : endTime
		},
		success : function(data) {
			$("#refresh").html("");
			$('#refresh').html(data);
			console.log("refresh method return success");
		}
	});
}
// 点击tab标签或日期时重新分页
function refreshPageSum(pageNum, startTime, endTime) {
	$("#refresh").html("");
	$.ajax({
		type : 'post',
		url : base + '/pcclient/account/refreshAccount',
		cache : false,
		async : true,
		dataType : "html",
		data : {
			pageNum : pageNum,
			startTime : startTime,
			endTime : endTime
		},
		success : function(data) {
			$('#refresh').html(data);
			var pageCount = $("#ajax_pageCount").val() || 0;
			//alert(pageCount);
			$('#refresh').html("");
			console.log('refreshPageSum method PageCount=============='+pageCount+"\n startTime==========="+startTime+"\n endTime==========="+endTime);
			loadPagination(pageCount,startTime, endTime);
			console.log("refreshPageSum method return success");
		},
		error : function(XMLHttpRequest, error, errorThrown, data) {
			alert(data.errMsg);
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

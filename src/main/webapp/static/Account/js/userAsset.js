var base = document.getElementById("base").href;
var chart_datalist = '';
var ydata = [];
var reverseXDays = [];
var reverseYdata = [];
var graphOptions = {
		title : {
			text : null
		},
		chart : {
			type : 'line'
		// plotBorderWidth: 1
		},
		xAxis : {
			// title: {
			// text: '/日期',
			// align: 'high'
			// },
			// categories: reverseXDays,
			tickLength : 0,
			tickmarkPlacement : 'on',
			gridLineWidth : 1,
			gridLineDashStyle : 'solid',
			gridLineColor : '#C0C0C0',
			labels : {
				formatter : function() {

					return reverseXDays[this.value];

				}
			},
			min : 0,
			max : reverseXDays[reverseXDays.length],
			tickInterval : 1,
			lineColor : '#9f9f9f',
			lineWidth : 2,
			maxPadding : 0.001
		},
		yAxis : {
			// title: {
			// text: '金额（元）',
			// align: 'high'
			// },
			title : {
				text : ''
			},
			labels : {
				formatter : function() {
					return this.value;

				}
			},
			min : 0,
			max : 1,
			startOnTick : false,
			align : 'high',
			lineColor : '#9f9f9f',
			lineWidth : 2
		},
		series : [ {
			name : '收益',
			data : [ 0, 0, 0, 0, 0, 0, 0, 0 ],
			showInLegend : false,
			allowPointSelect : true,
			color : '#a78e54'

		} ],
		plotOptions : {
			series : {
				pointStart : 0,
				marker : {
					radius : 4,
					symbol : "circle",
					fillColor : '#FFFFFF',
					lineWidth : 2,
					lineColor : null
				}
			}
		},
		credits : {
			enabled : false
		}
	};
$(function() {

	
	$.ajax({
		type : 'post',
		url : base + '/pcclient/chart/balanceChart',
		async : true,
		dataType : "json",
		success : function(data) {
			if (data.errMsg == "操作成功！") {

				// 图表数据

				for (var i = 0; i < data.rows.length; i++) {
					ydata.push(parseInt(Number(data.rows[i]) * 100) / 100);
					console.log("data.rows[i]==============" + data.rows[i]);
				}
				console.log("ydata======" + ydata);
				for (i = 0; i < 8; i++) {
					reverseYdata.push(ydata.pop());
				}
				graphOptions.series[0].data = reverseYdata;
				$('#graphTable').highcharts(graphOptions);
				var chart = $('#graphTable').highcharts();
				setYDec(chart,reverseYdata);
				

			} else {
				alert(data.errMsg);
			}
		},
		error : function(XMLHttpRequest, error, errorThrown, data) {
			alert(data.errMsg);
		}
	});

	rightHeight = $(".user-detail").height();
	$(".user-nav-list").css("height", rightHeight + 'px');

	$("#ui-all-btn").on("click", function(event) {
		var element = event.target;
		tabShow(element, "tro-activeTab");
	});
	$("#ui-finance-btn").on("click", function(event) {
		var element = event.target;
		tabShow(element, "tro-activeTab");
	});
	$("#ui-account-btn").on("click", function(event) {
		var element = event.target;
		tabShow(element, "tro-activeTab");
	});
	btnColorChange("ui-bc_btn", "#df4f4b", "#cc3a3a");
	btnColorChange("ui-rc-link", "#df4f4b", "#cc3a3a");
	$(".home-nav-Btn").hover(function() {
		if (!$(this).hasClass("clicked-tab")) {
			$(this).addClass("hover-tab");
		}
	}, function() {
		if ($(this).hasClass("hover-tab")) {
			$(this).removeClass("hover-tab");
		}

	});

	var lastEightdays = getformatdays();

	for (i = 0; i < 8; i++) {
		reverseXDays.push(lastEightdays.pop());
	}

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

	function getformatdays() {
		var date = new Date(), datelist = new Array(), lastMonthDate = 0, seperator = "-";
		year = date.getFullYear();
		month = parseInt(date.getMonth() + 1);
		day = date.getDate();
		if (month >= 1 & month <= 9) {
			month = '0' + month;
		}
		for (i = 0; i < 8; i++) {
			day--;
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
			var currentday = month + seperator + day;
			datelist.push(currentday);

		}

		console.log("graph table's day is" + datelist);
		return datelist;

	}

	

	$("#ui-all-btn").on("click", function(event) {
		var element = event.target;
		tabShow(element, "ui-active-ghtab");
		refreshChart("balanceChart");
	});
	$("#ui-finance-btn").on("click", function(event) {
		var element = event.target;
		tabShow(element, "ui-active-ghtab");
		refreshChart("yieldChart");//资产收益
	});
	$("#ui-account-btn").on("click", function(event) {
		var element = event.target;
		tabShow(element, "ui-active-ghtab");
		refreshChart("assetChart");//零钱收益
	});

	var rightHeight = $(".user-detail").height();
	$(".user-nav-list").css("height", rightHeight + 'px');
});

//刷新图表
function refreshChart(path) {
	$.ajax({
		type : 'post',
		url : base + '/pcclient/chart/' + path,
		async : true,
		dataType : "json",
		success : function(data) {
			if (data.errMsg == "操作成功！") {

				// 图表数据
				ydata = [];
				for (var i = 0; i < data.rows.length; i++) {
					ydata.push(parseInt(Number(data.rows[i]) * 100) / 100);
					console.log("data.rows[i]==============" + data.rows[i]);
				}
				reverseYdata = [];
				for (i = 0; i < 8; i++) {
					reverseYdata.push(ydata.pop());
				}
				graphOptions.series[0].data = reverseYdata;

				$('#graphTable').highcharts(graphOptions);
				var chart = $('#graphTable').highcharts();
				setYDec(chart,reverseYdata);

			} else {
				alert(data.errMsg);
			}
		},
		error : function(XMLHttpRequest, error, errorThrown, data) {
			alert(data.errMsg);
		}
	});
}
// 设置y轴坐标范围，如果后端传的数组全是0，则设置max为1；否则，不设max为null
function setYDec(obj,array){
	var stat = true;    // 数组中全是0
	for(var i=0;i<array.length;i++){
		if(array[i] != 0){
			stat = false; // 数组中不全是0
		}
	}
	if(!stat){
		obj.yAxis[0].update({
			max : null
		});
	}
}	

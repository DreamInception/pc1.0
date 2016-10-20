var base = document.getElementById("base").href;
var phoneNum_input = false;
var picCode_input = false;
var msgCode_input = false;
$(function() {
			$("#province").selectmenu();
			$("#city").selectmenu();
			$("#bankCode").selectmenu();
			btnColorChange("uit-confirm", "#df4f4b", "#cc3a3a");
			$("#user-bindCard-phoneNum").on("input", function(event) {
						var element = event.target;
						phoneNum_input = validatePhoneNum(element, "bank-phoneNum-error",
								"请输入正确的手机号码");
					});

			$("#texting").on("input", function(event) {
						var element = event.target;
						msgCode_input = validateMsgCode(element, "user-ubw-error",
								"验证码只能是4位或6位数字");
					});
		    $("#bandrand").on("input", function(event) {
						var element = event.target;
						picCode_input = validateMsgCode(element, "bindcard-picCode-error",
								"验证码只能是4位或6位数字");
					});
			// 下拉市区
			function onSelectChange(obj, toSelId) {
				setSelect(obj.value, toSelId);
			}
			// 加载省级下拉
			setSelect(1, "#province");

			$("#province").on("selectmenuchange", function() {
						var obj = this;
						onSelectChange(obj, '#city');
						$("#province").selectmenu("destroy");
						$("#city").selectmenu("destroy");
					});

			function setSelect(fromSelVal, toSelId, value) {
				$.post(base + "/area/getAddress", {
							parentId : fromSelVal
						}, function(result) {
							console.log("result==================" + result);
							var map = result.rows;
							html = '<option value=""' + '>请选择 </option>';
							for (var index in map) {
								var city = map[index];
								html += '<option  value="' + city.areaId + '">'
										+ city.areaName + '</option>';
								console.log("html==================" + html);
							}
							$(toSelId).html(html);
							if (value != undefined) {
								$(toSelId).val(value);
							}
							$("#province").selectmenu();
							$("#city").selectmenu();
						}, "json");
			}
		})
// 绑定银行卡
function bankSendText(phoneId, msgCodeId, errorId, msg, randId) {

	// 银行卡编码
	var bankCode = $('#bankCode').val();
	// 银行卡卡号
	var bankCardNumber = $('#bankCardNumber').val();
	// 银行预留手机
	var bankCardReservedPhone = $('#user-bindCard-phoneNum').val();
	// 开户银行
	var bankCardCity = $('#city').val();
	var phoneObj = $("#" + phoneId);
	var randImgObj = $("#" + randId).val();
	var msgCodeObj = $("#" + msgCodeId), intervalTimeObj = null, // timer变量，控制时间
	count = 60, // 间隔函数，1秒执行
	leftCount = 60, // 当前剩余秒数
	code = '', // 验证码
	codeLength = 6;// 验证码长度

	if (phoneObj.val() != "") {
		msgCodeObj.attr("disabled", "true").css("background", "#c2c2c2").css(
				"cursor", "pointer");
		msgCodeObj.val(count + "秒后重新获取");
		intervalTimeObj = window.setInterval(setRemainTime, 1000);

		$("#" + errorId).css("visibility", "hidden");
		
		// 向后台发送处理数据
		$.ajax({
					type : 'post',
					url : base + '/pcclient/user/bindCard',
					async : true,
					dataType : "json",
					data : {
						bankCode : bankCode,
						bankCardNumber : bankCardNumber,
						bankCardReservedPhone : bankCardReservedPhone,
						bankCardCity : bankCardCity,
						randImg : randImgObj
					},
					success : function(data) {
						if (data.errMsg == "操作成功！") {
							$('#ticket').val(data.rows[0]);
							alert("短信已发送！");
						} else {
							alert(data.errMsg);
						}
					},
					error : function(XMLHttpRequest, error, errorThrown, data) {
						alert("出错！");
					}
				});
	} else {
		showErrorMsg(errorId, msg);
	}
	function setRemainTime() {
		if (leftCount == 0) {
			clearInterval(intervalTimeObj);
			msgCodeObj.removeAttr("disabled");
			msgCodeObj.val("重新获取验证码").css("background", "#e74d46").css(
					"cursor", "pointer");
			code = '';
		} else {
			leftCount--;
			msgCodeObj.val(leftCount + "秒后重新获取");
		}

	}
}

// 表单数据检查
function checkTexting() {
	// 银行卡编码
	var bankCode = $('#bankCode').val();
	// 银行卡卡号
	var bankCardNumber = $('#bankCardNumber').val();
	// 银行预留手机
	var bankCardReservedPhone = $('#user-bindCard-phoneNum').val();
	// 开户银行
	var bankCardCity = $('#city').val();
	// 短信验证码
	var texting = $('#texting').val();
	// ticket
	var ticket = $('#ticket').val();

	if (bankCode == '' || bankCardNumber == '' || bankCardReservedPhone == ''
			|| bankCardCity == '' || texting == '') {
		alert("表单数据不能为空！");
		return;
	}
	if(phoneNum_input && picCode_input && msgCode_input){
		$.ajax({
				type : 'post',
				url : base + '/pcclient/user/bindOver',
				async : true,
				dataType : "json",
				data : {
					texting : texting,
					ticket : ticket
				},
				success : function(data) {
					if (data.errMsg == "操作成功！") {
						// alert(data.errMsg);
						window.location.href = base
								+ "pcclient/user/bindSuccess";
					} else {
						refreshRand(bandimg);
						alert(data.errMsg);
					}
				},
				error : function(XMLHttpRequest, error, errorThrown, data) {
					alert("出错！");
					refreshRand(bandimg);
				}
			});
	}
}

// 刷新验证码
function refreshRand(id) {
	var getimage = document.getElementById(id);
	getimage.src = base + "/authImage/image?sid=" + Math.random();
}
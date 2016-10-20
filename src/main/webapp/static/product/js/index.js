$(function () {
	var base = document.getElementById("base").href;
    // banner滑动 
    var unslider = $('#ad_banner').unslider({
        dots: true,
        fluid: true,
        keys: true
    });
    var slideIns = unslider.data("unslider");
    $(".unslider-arrow").click(function () {
        var fn = this.className.split(" ")[1];
        slideIns[fn]();
    })
    $(".banner").mouseover(function () {
        $(".unslider-arrow").show();
    }).mouseout(function () {
        $(".unslider-arrow").hide();
    });
    $("#sinaImg").hover(function () {
        $("#sinaWin").show();
    }, function () {
        $("#sinaWin").hide();
    });
    $("#wechatImg").hover(function () {
        $("#wechatWin").show();
    }, function () {
        $("#wechatWin").hide();
    });

        $(".home-nav-Btn").hover(function(){
            if(!$(this).hasClass("clicked-tab")){
                $(this).addClass("hover-tab");
            }
        },function(){
            if($(this).hasClass("hover-tab")){
                $(this).removeClass("hover-tab");
            }

        });

        $("#ui-all-btn").on("click", function(event){
            var element = event.target;
            tabShow(element,"ui-active-ghtab");
        });
        $("#ui-finance-btn").on("click", function(event) {
            var element = event.target;
            tabShow(element, "ui-active-ghtab");
        });
        $("#ui-account-btn").on("click", function(event) {
            var element = event.target;
            tabShow(element, "ui-active-ghtab");
        });

        var rightHeight = $(".user-detail").height();
        $(".user-nav-list").css("height", rightHeight + 'px');

    btnColorChange("pro-operate-buy","#df4f4b","#cc3a3a");
    btnColorChange("pro-buy","#df4f4b","#cc3a3a");
//限制中文字符长度
    $(".pro-name-data span").each(function(){
        var long_str = $(this).text().trim();
        if(getStrLength(long_str)>30){
            $(this).text(cutString(long_str,15));
        }
    });

    
// 分页插件
  //  var numPerPage = 4;
    var totalPages = $("#pageCount").val() || 0;
    laypage({
    	cont : 'pro-page-number',
    	pages : totalPages,
    	skin : '#428bca',
    	skip : false,
    	first: '首页',
    	last: '尾页',
    	curr: location.hash.replace('page=',''),
        hash: 'page',
    	jump : function(obj){
    			refresh(obj.curr);
    		
    		
    		console.log("refresh success++++++++++");
    	}
    });
    
    function refresh(curPage){
    	var pageNum = curPage; // 请求页码
    	$.ajax({
    		type : "post",
    		url : base + '/product/refresh',
    		cache : false,
    		async : true,
    		dataType : 'html',
    		data : {
    			pageNum : pageNum
    		},
    		success : function(data){
    			$("#refresh").html("");
    			$("#refresh").html(data);
    		}
    	})
    }
    
});
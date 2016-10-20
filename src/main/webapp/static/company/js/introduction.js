$(function(){
    var url = window.location.href;
        pos = url.indexOf("sp/");

    btnColorChange("intro-joinBtn","#df4f4b","#cc3a3a");
    if(pos != -1) {
        var str = url.substr(parseInt(pos)+3);
        console.log("url parameter is "+str);
        switch (str){
            case '0001':
                $("#about-us-btn").addClass("a-checked");
                $("#line1").addClass("line-checked");
                $("#aboutUs").show().siblings().hide();
                break;
            case '0002':
                $("#common-pro-btn").addClass("a-checked");
                $("#line2").addClass("line-checked");
                $("#commonPro").show().siblings().hide();
                break;
            case '0003':
                $("#join-us-btn").addClass("a-checked");
                $("#line3").addClass("line-checked");
                $("#joinUs").show().siblings().hide();
                break;
            case '0004':
                $("#contact-us-btn").addClass("a-checked");
                $("#line4").addClass("line-checked");
                $("#contactUs").show().siblings().hide();
                break;
            default :
                $("#about-us-btn").addClass("a-checked");
                $("#line1").addClass("line-checked");
                $("#aboutUs").show().siblings().hide();
        }
    }
    $("#about-us-btn").click(function(){
        gui ("#about-us-btn", "#aboutUs", "#line1", "#line2", "#line3", "#line4");
    });
    $("#common-pro-btn").click(function(){
        gui ("#common-pro-btn", "#commonPro", "#line2", "#line1", "#line3", "#line4");
    });
    $("#join-us-btn").click(function(){
        gui ("#join-us-btn", "#joinUs", "#line3", "#line1", "#line2", "#line4");
    });
    $("#contact-us-btn").click(function(){
        gui ("#contact-us-btn", "#contactUs", "#line4", "#line1", "#line2", "#line3");
    });

    $("#intro-au-content").hover(function () {
        $("#wc_intro_code").show();
    },function(){
        $("#wc_intro_code").hide();
    });
});
function gui (param0, param1, param2, param3, param4, param5) {
    $(".a-option").removeClass("a-checked");
    $(param0).addClass("a-checked");
    $(param1).show().siblings().hide();
    $(param2).addClass("line-checked");
    $(param3).removeClass("line-checked");
    $(param4).removeClass("line-checked");
    $(param5).removeClass("line-checked");
};
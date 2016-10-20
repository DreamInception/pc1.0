$(function () {
    /*------------------------------------------------------- banner滑动  ------------------------------------------------*/
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
   
    /*------------------------------------------------------- CompanyInfo.js ------------------------------------------------*/

    $("#hidden-code").hover(function () {
        $(this).animate({right: '0px'}, 500);
    }, function () {
        $(this).animate({right: '-130px'}, 500);
    });

    btnColorChange("sp-buy","#df4f4b","#cc3a3a");


});
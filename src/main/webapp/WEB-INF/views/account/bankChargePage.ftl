<html>
<head lang="en">
	<#include "../public/public_head.ftl" >
</head>
<body>
<#if errMsg??>
${errMsg}
<#else>
<form action="${jumpToUrl}" id="frm" method="post">
        <input id="amount" type="hidden" value="${amount}">
</form>
<script>
$(function(){
var amount = $("#amount").val().trim();
if (amount) {
	var frm = $("#frm");
	frm.submit();
}
})
</script>
</#if>
</body>
</html>

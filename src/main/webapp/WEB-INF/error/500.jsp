<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="/base/base.jsp" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		
		

		<STYLE type=text/css>
INPUT {
	FONT-SIZE: 12px
}

TD {
	FONT-SIZE: 12px
}

.p2 {
	FONT-SIZE: 12px
}

.p6 {
	FONT-SIZE: 12px;
	COLOR: #1b6ad8
}

A {
	COLOR: #1b6ad8;
	TEXT-DECORATION: none
}

A:hover {
	COLOR: red
}
</STYLE>
	</head>

	<body>
		<TABLE cellSpacing=0 cellPadding=0 width=540 align=center border=0>
			<TBODY>
				<TR>
					<TD vAlign=top height=270>
						<DIV align=center>
							<BR>
							<IMG height=211 src="${ctx }error/error.gif" width=329>
							<BR>
							<BR>
							<TABLE cellSpacing=0 cellPadding=0 width="80%" border=0>
								<TBODY>
									<TR>
										<TD>
											<FONT class=p2>&nbsp;&nbsp;&nbsp; <FONT color=#ff0000><IMG
														height=13 src="${ctx }error/emessage.gif" width=12>&nbsp;无法访问本页的原因是：<b>内部服务器错误   </b>!</FONT>
											</FONT>
										</TD>
									</TR>
					
								</TBODY>
							</TABLE>
						</DIV>
					</TD>
				</TR>
				<TR>
					<TD height=5></TD>
					<TR>
						<TD align=middle>
							<CENTER>
								<TABLE cellSpacing=0 cellPadding=0 width=480 border=0>
									<TBODY>
										<TR>
											<TD width=6>
												<IMG height=26 src="${ctx }error/left.gif" width=7>
											</TD>
											<TD background="${ctx }error/bg.gif">
												<DIV align=center>
													<FONT class=p6><A href="${ctx }">返回首页</A> | <A
														href="javascript:history.go(-1)">返回出错页</A> | <a
														href="javascript:window.opener=null;window.open('','_self');window.close();">关闭本页</A>
													</FONT>
												</DIV>
											</TD>
											<TD width=7>
												<IMG src="${ctx }error/right.gif">
											</TD>
										</TR>
									</TBODY>
								</TABLE>
							</CENTER>
						</TD>
					</TR>
			</TBODY>
		</TABLE>
	</body>
</html>

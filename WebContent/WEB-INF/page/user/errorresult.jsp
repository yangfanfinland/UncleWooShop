<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>忘记密码:巴巴运动网</title>
<meta http-equiv=Content-type content="text/html; charset=UTF-8" />
<meta content="MShtml 6.00.2900.2769" name=GENERaTOR />
<link href="<%=request.getContextPath() %>/css/global/header01.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/css/global/getpassword.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<jsp:include page="/WEB-INF/page/share/Head.jsp" />
	<table cellSpacing=15 cellPadding=0 width="100%" border=0>
		<Tbody>
			<tr>
				<td valign=bottom>
				<nobr>
					<a class=ablue2 href="/customer/center.go">我的帐户</a>
				</nobr>
				<span class=important> &gt; </span>
				<nobr class=font-title>忘记密码</nobr>
			</td>
			</tr>
		</Tbody>
	</table>
	<table cellSpacing=15 cellPadding=0 width="100%" border=0>
		<Tbody>
			<tr>
				<td valign=top align=middle>
					<table cellSpacing=0 cellPadding=0 width="65%" border=0>
						<Tbody>
							<tr>
								<td valign=top width="99%" colspan=4>
									<table cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
										<Tbody>
											<tr>
												<td valign=top align=left width=10 bgColor=#ddddcc>
													<img height=28 src="<%=request.getContextPath()%>/images/login/az-tan-top-left-round-corner.gif" width=10 border=0/>
												</td>
												<td valign=bottom noWrap width="20%" bgColor=#ddddcc height=28>
													<span class=title>重设新密码&nbsp;&nbsp;</span>
												</td>
												<td valign=bottom align=right width="79%" bgColor=#ddddcc>&nbsp;</td>
												<td valign=top align=right width=10 bgColor=#ddddcc>
													<img height=28 src="<%=request.getContextPath()%>/images/login/az-tan-top-right-round-corner.gif" width=10 border=0>
												</td>
											</tr>
										</Tbody>
									</table>
								</td>
							</tr>
						</Tbody>
					</table>
					<table id="" cellSpacing=0 cellPadding=0 width="65%" bgColor=#ddddcc border=0>
						<Tbody>
							<tr bgColor=#ddddcc>
								<td valign=top bgColor=#ddddcc>
									<table cellSpacing=3 cellPadding=0 width="100%" align=center bgColor=#ddddcc border=0>
										<Tbody>
											<tr>
												<td valign=top bgColor=#ffffff>
													<table class=font9 height=200 cellSpacing=10 cellPadding=0 width="100%" align=center border=0>
														<Tbody>
															<tr>
																<td valign=top>
																	<table border="0" cellpadding="4" cellspacing="4" width="100%">
																		<tbody>
																			<tr align="left">
																				<td>
																					<p class="font14b">无效链接</p>
																				</td>
																			</tr>
																			<tr align="left">
																				<td>链接已经失效,如果您是在浏览器上输入的链接,请检查链接是否正确,建议重新 
																					<a class="font14b" href="/mapping/user/forgetpassword.htm" class="a-your-account">取回密码</a>
																				</td>
																			</tr>
																		</tbody>
																	</table>
																</td>
															</tr>
														</Tbody>
													</table>
												</td>
											</tr>
										</Tbody>
									</table>
								</td>
							</tr>
						</Tbody>
					</table>
					<table cellSpacing=0 cellPadding=0 width="65%" bgColor=#ddddcc border=0>
						<Tbody>
							<tr valign=bottom>
								<td align=left bgColor=#ddddcc height=10>
									<img height=10 src="<%=request.getContextPath()%>/images/login/az-tan-bottom-left-round-corner.gif" width=10 border=0/>
								</td>
								<td align=right bgColor=#ddddcc height=10>
									<img height=10 src="<%=request.getContextPath()%>/images/login/az-tan-bottom-right-round-corner.gif" width=10 border=0/>
								</td>
							</tr>
						</Tbody>
					</table>
				</td>
			</tr>
		</Tbody>
	</table>
	<jsp:include page="/WEB-INF/page/share/Foot.jsp" />

</body>
</html>
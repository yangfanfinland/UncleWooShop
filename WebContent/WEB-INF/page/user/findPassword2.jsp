<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>忘记密码:巴巴运动网</title>
<meta http-equiv=Content-Type content="text/html; charset=UTF-8" />
<link href="<%=request.getContextPath()%>/css/global/getpassword.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/global/header01.css" rel="stylesheet" type="text/css" />
<meta content="MSHTML 6.00.2900.2769" name=GENERaTOR/>
</head>
<body>
	<jsp:include page="/WEB-INF/page/share/Head.jsp" />
	<table cellSpacing=15 cellPadding=0 width="100%" border=0>
		<tbody>
			<tr>
				<td valign=bottom>
					<nobr>
						<a class=ablue2 href="/customer/center.go">我的帐户</a>
					</nobr>
					<span class=important> &gt; </span>
					<nobr class=font-title>忘记密码</nobr>
				</td>
			</tr>
		</tbody>
	</table>
	<table cellSpacing=15 cellPadding=0 width="100%" border=0 align="center">
		<tbody>
			<tr>
				<td valign=top align=middle>
					<table cellSpacing=0 cellPadding=0 width="65%" border=0 align="center">
						<tbody>
							<tr>
								<td valign=top width="99%" colspan=4>
									<table cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
										<tbody>
											<tr>
												<td valign=top align=left width=10 bgColor=#ddddcc>
													<img height=28 src="<%=request.getContextPath()%>/images/login/az-tan-top-left-round-corner.gif" width=10 border=0>
												</td>
												<td valign=bottom noWrap width="20%" bgColor=#ddddcc height=28>
													<span class=title>重设新密码&nbsp;&nbsp;</span>
												</td>
												<td valign=bottom align=right width="79%" bgColor=#ddddcc>&nbsp;</td>
												<td valign=top align=right width=10 bgColor=#ddddcc>
													<img height=28 src="/<%=request.getContextPath()%>images/login/az-tan-top-right-round-corner.gif" width=10 border=0>
												</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
					<table id="" cellSpacing=0 cellPadding=0 width="65%" bgColor=#ddddcc border=0 align="center">
						<tbody>
							<tr bgColor=#ddddcc>
								<td valign=top bgColor=#ddddcc>
									<table cellSpacing=3 cellPadding=0 width="100%" align=center bgColor=#ddddcc border=0>
										<tbody>
											<tr>
												<td valign=top bgColor=#ffffff>
													<table class=font9 height=200 cellSpacing=10 cellPadding=0 width="100%" align=center border=0>
														<tbody>
															<tr>
																<td valign=top>
																	<!--  content  -->
																	<table cellSpacing=4 cellPadding=4 width="100%" border=0>
																		<tbody>
																			<tr align=left>
																				<td>
																				<span class=font-step>第二步：</span>
																				<span class=font14b>请查看您帐户设定的电子邮件信箱</span>
																			</td>
																			</tr>
																			<tr align=left>
																				<td class=font9>
																					<P>为了验证您的身份，我们已发出了通知信，请在24小时内点击邮件内的链接继续设置新密码。</P>
																				</td>
																			</tr>
																			<tr align=left>
																				<td>
																					<HR class=dashes noShade SIZE=1 />
																				</td>
																			</tr>
																			<tr align=left>
																				<td class=font9>
																					<P class=font9>
																						如果您忘记密码且不再使用注册时的E-mail，
																						<a class=a-your-account href="/mapping/user/reg.htm">建议创建一个新帐户</a>。
																					</P>
																				</td>
																			</tr>
																		</tbody>
																	</table> <!--  content  -->
																</td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
					<table cellSpacing=0 cellPadding=0 width="65%" bgColor=#ddddcc border=0 align="center">
						<tbody>
							<tr valign=bottom>
								<td align=left bgColor=#ddddcc height=10>
									<img height=10 src="<%=request.getContextPath()%>/images/login/az-tan-bottom-left-round-corner.gif" width=10 border=0>
								</td>
								<td align=right bgColor=#ddddcc height=10>
									<img height=10 src="<%=request.getContextPath()%>/images/login/az-tan-bottom-right-round-corner.gif" width=10 border=0>
								</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
		</tbody>
	</table>

	<jsp:include page="/WEB-INF/page/share/Foot.jsp" />
</body>
</HTML>
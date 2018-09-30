<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<!DOCtype html PUBLIC "-//W3C//Dtd Xhtml 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>忘记密码:巴巴运动网</title>
<meta http-equiv=Content-type content="text/html; charset=UTF-8" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/FoshanRen.js"></script>
<link href="<%=request.getContextPath()%>/css/global/getpassword.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/global/header01.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
#errorMessage {
	padding: 8px 0px 5px 25px;
	color: #009900
}
-->
</style>
<script type="text/javascript">
<!--
	function validateForm(form) {
		var userName = form.userName.value;
		if (userName == null || trim(userName) == "") {
			alert("会员名不能为空");
			form.userName.focus();
			return false;
		}
		return true;
	}
//-->
</script>
<meta content="MShtml 6.00.2900.2769" name=GENERaTOR />
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
				<td valign=top align=middle><c:if test="${!empty message}">
						<!-- 错误提示 start -->
						<div id="errorinfo">
							<table cellSpacing=1 cellPadding=8 width="65%" align="center" bgColor="#dd9988" border=0>
								<tbody>
									<tr>
										<td bgColor="#ffffd5">
											<img height="17" src="<%=request.getContextPath() %>/images/buy/exclamation-error-red.gif" width="17" />
											<font color="#990000"><strong><span class="font14">错误提示<BR></span></strong></font>
											<div id="errorMessage">${message }</div>
										</td>
									</tr>
								</tbody>
							</table>
							<br>
						</div>
						<!-- 错误提示 end -->
					</c:if>
					<table cellSpacing=0 cellPadding=0 width="65%" border=0 align="center">
						<tbody>
							<tr>
								<td valign=top width="99%" colspan=4>
									<table cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
										<tbody>
											<tr>
												<td valign=top align=left width=10 bgColor=#ddddcc>
													<img height=28 src="<%=request.getContextPath() %>/images/login/az-tan-top-left-round-corner.gif" width=10 border=0></td>
												<td valign=bottom noWrap width="20%" bgColor=#ddddcc height=28>
													<span class=title>重设新密码&nbsp;&nbsp;</span>
												</td>
												<td valign=bottom align=right width="79%" bgColor=#ddddcc>&nbsp;</td>
												<td valign=top align=right width=10 bgColor=#ddddcc>
													<img height=28 src="<%=request.getContextPath() %>/images/login/az-tan-top-right-round-corner.gif" width=10 border=0>
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
																	<s:form action="getpassword" namespace="/user/post" method="post" name="getp" onsubmit="javascript:return validateForm(this)">
																	
																			<table cellSpacing=4 cellPadding=4 width="100%" border=0>
																				<tbody>
																					<tr align=left>
																						<td class="font-error" colspan=3></td>
																					</tr>
																					<tr align=left>
																						<td class="font14" colspan=3>忘记密码了吗？不用着急，只要3步就可以重设您的新密码，简单方便。</td>
																					</tr>
																					<tr align=left>
																						<td colspan=3>
																							<span class="font-step">第一步：</span>
																							<strong class="font14b">请输入您注册时填写的会员名，点击继续</strong>
																						</td>
																					</tr>
																					<tr align=left>
																						<td class="font12b" align="right" width="27%">会员名</td>
																						<td width="39%">
																							<input maxLength="20" size="30" name="username">
																						</td>
																						<td width="34%">
																							<input id="Image1" type="image" alt="继续" src="<%=request.getContextPath() %>/images/login/az-continue-arrow.gif" border=0 name=image1>
																						</td>
																					</tr>
																					<tr align=left>
																						<td colspan=3>
																							<hr class=dashes noShade SIZE=1>
																						</td>
																					</tr>
																					<tr align=left>
																						<td class=font9 colspan=3>
																							<P class=font9>
																								如果您忘记密码且不再使用注册时的E-mail，
																								<a class=a-your-account href="/mapping/user/reg.htm">建议创建一个新帐户</a>。
																							</P>
																						</td>
																					</tr>
																				</tbody>
																			</table>
																	</s:form>
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
									<img height=10 src="<%=request.getContextPath() %>/images/login/az-tan-bottom-left-round-corner.gif" width=10 border=0>
								</td>
								<td align=right bgColor=#ddddcc height=10>
									<img height=10 src="<%=request.getContextPath() %>/images/login/az-tan-bottom-right-round-corner.gif" width=10 border=0>
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
</html>
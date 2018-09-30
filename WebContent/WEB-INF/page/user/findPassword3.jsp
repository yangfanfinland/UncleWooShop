<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<!DOCtype html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>忘记密码:巴巴运动网</title>
<meta http-equiv=Content-type content="text/html; charset=UTF-8" />
<script type="text/javascript" src="<%=request.getContextPath() %>/js/FoshanRen.js"></script>
<link href="<%=request.getContextPath() %>/css/global/header01.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/global/getpassword.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
<!--
	function validateForm(form) {
		var password = form.password.value;
		var confirm_password = form.confirm_password.value;
		if (password == null || trim(password) == "") {
			alert("新密码不能为空");
			form.password.focus();
			return false;
		}
		if (password.length<6 || password.length>16) {
			alert("密码的长度不正确,正确的长度为6-16位字符");
			form.password.focus();
			return false;
		}
		if (password != confirm_password) {
			alert("两次输入的密码不一致，请重新输入。");
			form.password.focus();
			return false;
		}
		return true;
	}
//-->
</script>
<meta content="MSHTML 6.00.2900.2769" name=GENERaTOR/>
</head>
<body>
	<jsp:include page="/WEB-INF/page/share/Head.jsp" />
	<table cellSpacing=15 cellPadding=0 width="100%" border=0>
		<tbody>
			<tr>
				<td valign=bottom><nobr>
					<a class=ablue2 href="/customer/center.go">我的帐户</a></nobr>
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
													<img height=28 src="<%=request.getContextPath() %>/images/login/az-tan-top-left-round-corner.gif" width=10 border=0>
												</td>
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
																	<s:form action="changepassword" namespace="/user/post" method="post" onsubmit="javascript:return validateForm(this)">
																		<input type="hidden" name="username" value="${param.username}"> 
																		<input type="hidden" name="validateCode" value="${param.validateCode }">
																					<table border="0" cellpadding="4" cellspacing="4" width="100%">
																						<tbody>
																							<tr align="left">
																								<td colspan="3" class="font-error"></td>
																							</tr>
																							<tr align="left">
																								<td colspan="3">
																									<p>
																										<span class="font-step">最后一步：</span>
																										<span class="font14b">输入您的新密码</span>
																									</p>
																								</td>
																							</tr>
																							<tr align="left">
																								<td colspan="3" class="font9">当您下订单、查询订单状态或帐户信息时请输入以下密码。</td>
																							</tr>
																							<tr align="left">
																								<td class="font12b" align="right" width="21%">您的新密码是</td>
																								<td width="31%">
																									<input type="password" name="password" maxlength="16" size="30">
																								</td>
																								<td class="font9" width="48%">密码要求由英文字母（a-z大小写均可）、阿拉伯数字(0-9)组成且长度为6-16位字符</td>
																							</tr>
																							<tr align="left">
																								<td class="font12b" align="right">重新输入一遍</td>
																								<td>
																									<input type="password" name="confirm_password" maxlength="16" size="30">
																								</td>
																							</tr>
																							<tr align="left">
																								<td>&nbsp;</td>
																								<td align="right">
																									<input type="image" alt="完成" src="<%=request.getContextPath() %>/images/login/az-finish.gif" border=0 name="image1" ID=Image1 />
																								</td>
																								<td>&nbsp;</td>
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
</HTML>
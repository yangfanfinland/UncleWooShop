<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<html>
<head>
<title>注册用户列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/vip.css" type="text/css">
<script type="text/javascript">
	//到指定的分页页面
	function topage(page) {
		var form = document.forms[0];
		form.page.value = page;
		form.submit();
	}

	function allSelect() {
		var form = document.forms[0];
		var state = form.allselectbox.checked;
		var length = form.usernames.length;
		if (length) {
			for ( var i = 0; i < length; i++) {
				form.usernames[i].checked = state;
			}
		} else {
			form.usernames.checked = state;
		}
	}
	function delete_action() {
		if (selectItem()) {
			var form = document.forms[0];
			form.action = '<s:url action="delete" namespace="/control/user" includeParams="none"/>';
			form.submit();
		} else {
			alert("请选择要操作的记录");
		}
	}
	function enable_action() {
		if (selectItem()) {
			var form = document.forms[0];
			form.action = '<s:url action="enable" namespace="/control/user" includeParams="none"/>';
			form.submit();
		} else {
			alert("请选择要操作的记录");
		}
	}
	
	
	function selectItem() {
		var form = document.forms[0];
		var length = form.usernames.length;
		if (length) {
			for ( var i = 0; i < length; i++) {
				if (form.usernames[i].checked)
					return true;
			}
		} else {
			return form.usernames.checked;
		}
		return false;
	}
</script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/FoshanRen.js"></script>
</head>

<body bgcolor="#FFFFFF" text="#000000" marginwidth="0" marginheight="0">
	<s:form action="list" namespace="/control/user" method="post">
		<s:hidden name="page" />
		<s:hidden name="query" />
		<s:hidden name="realname" />
		<s:hidden name="email" />
		<s:hidden name="username" />
		
		<table width="98%" border="0" cellspacing="1" cellpadding="2" align="center">
			<tr>
				<td colspan="7" bgcolor="6f8ac4" align="right">
					<%@ include file="/WEB-INF/page/share/fenye.jsp"%>
				</td>
			</tr>
			<tr>
				<td width="8%" bgcolor="6f8ac4">
					<div align="center">
						<font color="#FFFFFF">选择</font>
					</div>
				</td>
				<td width="20%" bgcolor="6f8ac4">
					<div align="center">
						<font color="#FFFFFF">用户名</font>
					</div>
				</td>
				<td width="15%" bgcolor="6f8ac4">
					<div align="center">
						<font color="#FFFFFF">真实姓名</font>
					</div>
				</td>
				<td width="10%" bgcolor="6f8ac4">
					<div align="center">
						<font color="#FFFFFF">性别</font>
					</div>
				</td>
				<td width="22%" bgcolor="6f8ac4">
					<div align="center">
						<font color="#FFFFFF">电子邮箱</font>
					</div>
				</td>
				<td width="20%" bgcolor="6f8ac4">
					<div align="center">
						<font color="#FFFFFF">注册时间</font>
					</div>
				</td>
				<td width="7%" bgcolor="6f8ac4">
					<div align="center">
						<font color="#FFFFFF">状态</font>
					</div>
				</td>
			</tr>
			<!---------------------------LOOP START------------------------------>
			<c:forEach items="${pageView.records}" var="entry">
				<tr>
					<td bgcolor="f5f5f5">
						<div align="center">
							<input type="checkbox" name="usernames" value="${entry.username}"/>
						</div>
					</td>
					<td bgcolor="f5f5f5">
						<div align="center">${entry.username}</div>
					</td>
					<td bgcolor="f5f5f5">
						<div align="center">${entry.realname }</div>
					</td>
					<td bgcolor="f5f5f5">
						<div align="center">${entry.gender.name }</div>
					</td>
					<td bgcolor="f5f5f5">
						<div align="center">${entry.email }</div>
					</td>
					<td bgcolor="f5f5f5">
						<div align="center">${entry.regTime }</div>
					</td>
					<td bgcolor="f5f5f5">
						<div align="center">
							<c:if test="${entry.visible}">可用</c:if>
							<c:if test="${!entry.visible}">禁用</c:if>
						</div>
					</td>
				</tr>
			</c:forEach>
			<!----------------------LOOP END------------------------------->
			<tr>
				<td bgcolor="f5f5f5" colspan="7" align="center">
					<table width="100%" border="0" cellspacing="1" cellpadding="3">
						<tr>
							<td width="10%">
								<input type="checkbox" onclick="javascript:allSelect()" name="allselectbox"/>全选
							</td>
							<td width="85%">
								<input type="button" value=" 禁 用 " class="frm_btn" onclick="javascript:delete_action()"/>&nbsp;&nbsp;
								<input type="button" value=" 启 用 " class="frm_btn" onclick="javascript:enable_action()"/>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
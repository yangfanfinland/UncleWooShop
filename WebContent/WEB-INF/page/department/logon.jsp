<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<html>
<head>
<title>管理员登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath() %>/css/css.css" rel="stylesheet" type="text/css">
<!--<base target="main"> -->
<style type="text/css">
<!--
.style2 {font-size: 12pt}
-->
</style>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/FoshanRen.js"></script>
<script type="text/javascript">
<!--
function verifyForm(objForm){
	if (trim(objForm.username.value)==""){
		alert("用户名不能为空!");
		objForm.username.focus();
		return false; 
	}
	if (trim(objForm.password.value)==""){
		alert("密码不能为空!");
		objForm.password.focus();
		return false; 
	}
	return true;
}
function locateparentwindow(){
	if (window.parent!=null && window.parent.document.URL!=document.URL){
		window.parent.location= document.URL; 
	}
}

//-->
</script>
</head>

<body onload="JavaScript:locateparentwindow()">
<s:form action="logon" namespace="/employee" method="post">
  <c:if test="${!empty message}">
  	<p align="center"><font color="red">${message }</font></p>
  </c:if> 
  <table align="center" cellSpacing=0 cellPadding=0 width=555 border=0 style="border-collapse: collapse" bordercolor="#111111">
    <tbody>
      <tr>
        <td width="588">
        	<table align="center" cellSpacing=0 cellPadding=0 width=558 border=0 style="border-collapse: collapse" bordercolor="#111111">
            <tbody>
              <tr>
                <td vAlign=top width="360" height="104">
                    <table width="600" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>
                        <td colspan="2"><img src="<%=request.getContextPath() %>/images/admin/Admin_Login1.gif" width="600" height="126"></td>
                      </tr>
                      <tr>
                        <td width="508" valign="top" background="<%=request.getContextPath() %>/images/admin/Admin_Login2.gif"><table width="508" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td height="37" colspan="6">&nbsp;</td>
                            </tr>
                            <tr>
                              <td width="75" rowspan="2">&nbsp;</td>
                              <td width="126"><font color="#043BC9">用户名称：</font></td>
                              <td width="39" rowspan="2">&nbsp;</td>
                              <td width="131"><font color="#043BC9">用户密码：</font></td>
                              <td width="34">&nbsp;</td>
                              <td width="103">&nbsp;</td>
                            </tr>
                            <tr>
                              <td><input type="text" name="username" maxlength="30" size="30" value="" class="box1"></td>
                              <td><input type="password" name="password" maxlength="30" size="30" value="" class="box1"></td>
                              <td>&nbsp;</td>
                              <td>&nbsp;</td>
                            </tr>
                        </table></td>
                        <td><input type="image" name="submit" src="<%=request.getContextPath() %>/images/admin/Admin_Login3.gif" style="width:92px; HEIGHT: 126px;"></td>
                      </tr>
                    </table>
                </td>
              </tr>
            </tbody>
        </table></td>
      </tr>
    </tbody>
  </table>
</s:form>
</body>
</html>
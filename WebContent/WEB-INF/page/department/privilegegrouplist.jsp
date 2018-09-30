<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<html>
<head>
<title>权限组显示</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/vip.css" type="text/css">
<script type="text/javascript">
<!--
	//到指定的分页页面
	function topage(page){
		var form = document.forms[0];
		form.page.value=page;
		form.submit();
	}
//-->
</script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/FoshanRen.js"></script>
</head>

<body bgcolor="#FFFFFF" text="#000000" marginwidth="0" marginheight="0">
<s:form action="list" namespace="/control/privilegegroup" method="post">
<s:hidden name="page"/>
  <table width="98%" border="0" cellspacing="1" cellpadding="2" align="center">
    <tr >
    	<td colspan="4" bgcolor="6f8ac4" align="right">
    		<%@ include file="/WEB-INF/page/share/fenye.jsp" %>
   		</td>
   </tr>
    <tr>
      <td width="30%" bgcolor="6f8ac4"> 
      	<div align="center"><font color="#FFFFFF">代号</font></div>
      </td>
      <td width="8%" nowrap bgcolor="6f8ac4"> 
      	<div align="center"><font color="#FFFFFF">修改</font></div>
      </td>
      <td bgcolor="6f8ac4"> 
      	<div align="center"><font color="#FFFFFF">名称</font></div>
      </td>
      <td width="10%" bgcolor="6f8ac4"></td>
    </tr>
<!---------------------------LOOP START------------------------------>
<c:forEach items="${pageView.records}" var="entry">
    <tr>
      <td bgcolor="f5f5f5"> 
      	<div align="center">${entry.groupid}</div>
      </td>
      <td bgcolor="f5f5f5"> 
      	<div align="center">
      		<a href='<s:url action="editUI" namespace="/control/privilegegroup" includeParams="none"/>?groupid=${entry.groupid}'>
	  		<img src="<%=request.getContextPath() %>/images/edit.gif" width="15" height="16" border="0">
	  		</a>
	  	</div>
	  </td>
      <td bgcolor="f5f5f5"> 
      	<div align="center">${entry.name}</div>
      </td>
      <td bgcolor="f5f5f5"> 
      	<div align="center">
      	<a href='<s:url action="delete" namespace="/control/privilegegroup" includeParams="none"/>?groupid=${entry.groupid}'>删除</a>
      	</div>
      </td>
	</tr>
</c:forEach>
    <!----------------------LOOP END------------------------------->
    <tr> 
      <td bgcolor="f5f5f5" colspan="4" align="center">
      	<table width="100%" border="0" cellspacing="1" cellpadding="3">
          <tr> 
            <td width="5%"></td>
              <td width="85%">
              <input type="button" value="添加权限组" class="frm_btn" onClick="javascript:window.location.href='<s:url action="addUI" namespace="/control/privilegegroup" includeParams="none"/>'"> &nbsp;&nbsp;
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</s:form>
</body>
</html>
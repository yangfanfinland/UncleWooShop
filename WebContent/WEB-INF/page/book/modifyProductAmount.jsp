<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<html>
<head>
<title>修改产品的购买数量</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/vip.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/FoshanRen.js"></script>
<script type="text/javascript">
function checkfm(form){
	return true;
}
</script>
</head>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<s:form action="modifyProductAmount" namespace="/control/order" method="post" onsubmit="return checkfm(this)">
<s:hidden name="orderitemid"/>
<s:hidden name="orderid"/>
<input type="hidden" name="method" value="modifyProductAmount">
  <table width="90%" border="0" cellspacing="2" cellpadding="3" align="center">
    <tr bgcolor="6f8ac4">
    	<td colspan="2"  > 
    		<font color="#FFFFFF">修改产品的购买数量：</font>
    	</td>
    </tr>
    <tr bgcolor="f5f5f5"> 
    	<td width="22%" > 
    		<div align="right">购买数量：</div>
    	</td>
      	<td width="78%"> 
      		<s:textfield name="amount" size="10" maxlength="5">
        	<font color="#FF0000">*</font>
        	</s:textfield>
        </td>
    </tr>
    <tr bgcolor="f5f5f5"> 
    	<td colspan="2"> 
    		<div align="center"> 
          	<input type="submit" name="SYS_SET" value=" 确 定 " class="frm_btn">
        	</div>
        </td>
    </tr>
  </table>
</s:form>
<br>
</body>
</html>
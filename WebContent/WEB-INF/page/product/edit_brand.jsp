<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Untitled Document</title>
<script type="text/javascript">
	function checkfm(form){
		if(document.form.name.value.length == 0){
			alert("name can't be empty!");
			document.form.name.focus();
			return false;
		}
		return true;
	}
</script>
</head>	
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<s:form action="edit_brand" namespace="/control/product/brand" method="post" enctype="multipart/form-data" onsubmit="return checkfm(this)">
<s:hidden name="code"/>

<br/>
  <table width="90%" border="0" cellspacing="2" cellpadding="3" align="center">
    <tr bgcolor="6f8ac4">
    	<td colspan="2"  > 
    		<font color="#FFFFFF">修改品牌：</font>
        </td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      	<td width="22%" > 
        	<div align="right">品牌名称：</div>
        </td>
      	<td width="78%">
      		<!-- 
      		<s:textfield name="name" size="50" maxlength="50"/>
  			-->
      		 
      		<input type="text" name="name" size="50" maxlength="40" value="${brandname}"/>
      		 
      		<font color="#FF0000">*</font>
        </td>
    </tr>
	<tr bgcolor="f5f5f5"> 
      	<td width="22%" >
        	<div align="right">Logo图片：</div>
       	</td>
      	<td width="78%">
      		 
      		 <input type="file" name="logofile" size="80"/>
      		  
      		  <!--
      		 <s:file name="logofile" size="80"/>
      		 -->
        </td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      	<td colspan="2"> <div align="center"> 
          <input type="submit" name="SYS_SET" value=" 确 定 " class="frm_btn"/>
        </div></td>
    </tr>
  </table>
<br/>
</s:form>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Untitled Document</title>
<script type="text/javascript">
	function checkfm(form){
		var namevalue = form.stylename.value.length;
		if(namevalue == 0){
			alert("Style name can't be empty!");
			form.stylename.focus();
			return false;
		}
		var imagefile = form.imagefile.value;
		if(imagefile != 0){
			var ext = imagefile.substring(imagefile.length-3).toLowerCase();
			if(ext!="jpg"&&ext!="gif"&&ext!="bmp"&&ext!="png"){
				alert("Only upload gif, jpg, bmp, png format file!");
				form.imagefile.focus();
				return false;
			}
		}else{
			alert("Please upload image!!!");
			form.imagefile.focus();
			return false;
		}
		
		return true;
	}
</script>
</head>	
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<s:form action="add_style" namespace="/control/product/style" method="post" enctype="multipart/form-data" onsubmit="return checkfm(this)">
<s:hidden name="productid"/>
  <table width="90%" border="0" cellspacing="2" cellpadding="3" align="center">
    <tr bgcolor="6f8ac4">
    	<td colspan="2"  > 
    		<font color="#FFFFFF">添加产品图片：</font>
        </td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      	<td width="22%" > 
        	<div align="right">样式名称：</div>
        </td>
      	<td width="78%">
      		<!-- 
      		<s:textfield name="name" size="50" maxlength="50"/>
  			-->
      		 
      		<input type="text" name="stylename" size="50" maxlength="40"/>
      		 
      		<font color="#FF0000">*</font>
        </td>
    </tr>
	<tr bgcolor="f5f5f5"> 
      	<td width="22%" >
        	<div align="right">产品图片：</div>
       	</td>
      	<td width="78%">
      		 
      		 <input type="file" name="imagefile" size="80"/>
      		  
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
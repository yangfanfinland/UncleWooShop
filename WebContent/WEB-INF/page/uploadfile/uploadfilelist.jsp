<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Untitled Document</title>
<script type="text/javascript">
	//到指定的分页页面
	function topage(page){
		var form = document.forms[0];
		form.page.value=page;
		form.submit();
	}
	//全选功能
	function allselect(allobj, items){
		var state = document.forms[0].select.checked;
		//alert(state);
		if(items.length){
			for(var i=0;i<items.length;i++){
				if(!items[i].disabled)
					items[i].checked=state;
			}
		}else{
			if(!items.disabled)
				items.checked=states;
		}
	}
	
	function deleteFiles(objform){
		objform.action='<s:url action="delete" namespace="/control/uploadfile/delete" includeParams="none"/>';
		objform.submit();
	}
	
</script>
</head>
<body>
<s:form action="list" namespace="/control/uploadfile" method="post" >
<s:hidden name="page"/>
	<table width="98%" border="0" cellspacing="1" cellpadding="2" align="center">

    	<tr >
        	<td colspan="4"  bgcolor="6f8ac4" align="right">
        		<%@ include file="/WEB-INF/page/share/fenye.jsp" %>
   			</td>
   		</tr>
        <tr>
        	<td width="8%" bgcolor="6f8ac4"> 
            	<div align="center"><font color="#FFFFFF">选择</font></div>
            </td>
            <td width="10%" bgcolor="6f8ac4"> 
            	<div align="center"><font color="#FFFFFF">代号</font></div>
            </td>
            <td width="60%" bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">文件</font></div>
            </td>
            <td width="22%" nowrap bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">上传时间</font></div>
            </td>
    	</tr>
    	<!-- Loop Start -->
    	<c:forEach items="${pageView.records}" var="uploadfile">
	        <tr>
	        	<td bgcolor="f5f5f5"> 
	            	<div align="center"><input type="checkbox" name="fileids" value="${uploadfile.id}"/></div>
	            </td>
	      		<td bgcolor="f5f5f5"> 
	            	<div align="center">${uploadfile.id}</div>
	            </td>
	      		<td bgcolor="f5f5f5">
	            	<div align="center">
	            		<a href="<%=request.getContextPath() %>${uploadfile.filepath}" target="_blank">${uploadfile.filepath}</a>
	            	</div>
	            </td>
		  		<td bgcolor="f5f5f5"> 
	            	<div align="center">${uploadfile.uploadtime}</div>
	            </td>
			</tr>
		</c:forEach>
		<!-- Loop end -->
    <tr> 
      <td bgcolor="f5f5f5" colspan="4" align="center">
      	<table width="100%" border="0" cellspacing="1" cellpadding="3">
          <tr> 
            <td width="10%"><input type="checkbox" name="select" onclick="javascript:allselect(this, this.form.fileids)"/>全选</td>
              <td width="85%">
              <input type="button" class="frm_btn" onClick="javascript:deleteFiles(this.form)" value="删除"/> &nbsp;&nbsp;
            </td>
          </tr>
        </table>
      </td>
    </tr>
    </table>
</s:form>
</body>
</html>
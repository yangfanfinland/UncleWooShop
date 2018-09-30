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
		var state = document.forms[0].all.checked;
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
	//判断是否选择了记录
	function validateIsSelect(allobj, items){
		var state = allobj.checked;
		if(items.length){
			for(var i=0;i<items.length;i++){
				if(items[i].checked)
					return true;
			}
		}else{
			if(items.checked)
				return true;
		}
		return false;
	}
	
	function actionEvent(){
		var form = document.forms[0];
		if(validateIsSelect(form.all, form.stylesids)){
			form.action = '<s:url action="styleVisible" namespace="/control/product/style" includeParams="none"/>';
			form.submit();
		}else{
			alert("Please select record to operate!!!");
		}
		
	}
	function actionEvent2(){
		var form = document.forms[0];
		if(validateIsSelect(form.all, form.stylesids)){
			form.action = '<s:url action="styleDisable" namespace="/control/product/style" includeParams="none"/>';
			form.submit();
		}else{
			alert("Please select record to operate!!!");
		}
	}
</script>
</head>
<body>
<s:form action="list" namespace="/control/product/style" method="post" >
<s:hidden name="productid"/>
	<table width="98%" border="0" cellspacing="1" cellpadding="2" align="center">

    	<tr >
        	<td colspan="5"  bgcolor="6f8ac4" align="right">
        		<div align="left"><font color="#FFFFFF">产品样式</font></div>
   			</td>
   		</tr>
        <tr>
        	<td width="8%" nowrap bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">选择</font></div>
            </td>
            <td width="8%" nowrap bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">修改</font></div>
            </td>
            <td width="37%" bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">名称</font></div>
            </td>
            <td width="10%" bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">在售状态</font></div>
            </td>
            <td width="37%" nowrap bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">产品图片</font></div>
            </td>
    	</tr>
    	<!-- Loop Start -->
    	<c:forEach items="${styles}" var="productStyle">
	        <tr>
	        	<td bgcolor="f5f5f5">
	            	<div align="center"><input type="checkbox" name="stylesids" value="${productStyle.id}"/></div>
	            </td>
	      		<td bgcolor="f5f5f5"> 
	      			<div align="center">
	      				<a href='<s:url action="style_editUI" namespace="/control/product/style" includeParams="none"/>?productstyleid=${productStyle.id}'>
		  					<img src="<%=request.getContextPath() %>/images/edit.gif" width="15" height="16" border="0"/></a>
	      				</a>
	      			</div>
	      		</td>
	      		<td bgcolor="f5f5f5">
	            	<div align="center">${productStyle.name}</div>
	            </td>
	      		<td bgcolor="f5f5f5">
	            	<div align="center">
	            		<c:if test="${productStyle.visible}">
	            			<font color="red">在售</font>	 
	            		</c:if>
	            		<c:if test="${!productStyle.visible}">
	            			停售
	            		</c:if>
	            	</div>
	            </td>
		  		<td bgcolor="f5f5f5"> 
	            	<div align="center"><img src="<%=request.getContextPath() %>${productStyle.imageFullPath}" width="50"/></div>
	            </td>
			</tr>
		</c:forEach>
		<!-- Loop end -->
   		<tr> 
      <td bgcolor="f5f5f5" colspan="5" align="center">
      	<table width="100%" border="0" cellspacing="1" cellpadding="3">
          <tr> 
            <td width="25%"><input type="checkbox" name="all" onclick="javascript:allselect(this, this.form.stylesids)"/>全选</td>
              <td width="85%">
              <input type="button" class="frm_btn" onClick="JavaScript:window.location.href='<s:url action="style_addUI" namespace="/control/product/style" includeParams="none"/>?productid=${param.productid}'" value="添加产品图片"/> &nbsp;&nbsp;
              <input name="visible" type="button" class="frm_btn" onClick="javascript:actionEvent()" value=" 上架"> &nbsp;&nbsp;
              <input name="disable" type="button" class="frm_btn" onClick="javascript:actionEvent2()" value=" 下架"> &nbsp;&nbsp;			  
            </td>
          </tr>
        </table>
      </td>
    </tr>
    </table>
</s:form>
</body>
</html>
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
		var state = allobj.checked;
		if(items.length){
			for(var i=0;i<items.length;i++){
				if(!items[i].disabled)
					items[i].checked=state;
			}
		}else{
			if(!items[i].disabled)
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
		if(validateIsSelect(form.all, form.productids)){
			form.action = '<s:url action="productVisible" namespace="/control/product" includeParams="none"/>';
			form.submit();
		}else{
			alert("Please select record to operate!!!");
		}
		
	}
	function actionEvent2(){
		var form = document.forms[0];
		if(validateIsSelect(form.all, form.productids)){
			form.action = '<s:url action="productDisable" namespace="/control/product" includeParams="none"/>';
			form.submit();
		}else{
			alert("Please select record to operate!!!");
		}
	}
	function actionEvent3(){
		var form = document.forms[0];
		if(validateIsSelect(form.all, form.productids)){
			form.action = '<s:url action="productCommend" namespace="/control/product" includeParams="none"/>';
			form.submit();
		}else{
			alert("Please select record to operate!!!");
		}
	}
	function actionEvent4(){
		var form = document.forms[0];
		if(validateIsSelect(form.all, form.productids)){
			form.action = '<s:url action="productUncommend" namespace="/control/product" includeParams="none"/>';
			form.submit();
		}else{
			alert("Please select record to operate!!!");
		}
	}
</script>
</head>
<body>
<s:form action="list" namespace="/control/product" method="post" >
<s:hidden name="page"/>
<s:hidden name="query"/>
<s:hidden name="name"/>
<s:hidden name="typeid"/>
<s:hidden name="startsellprice"/>
<s:hidden name="endsellprice"/>
<s:hidden name="startbaseprice"/>
<s:hidden name="endbaseprice"/>
<s:hidden name="code"/>
<s:hidden name="brandid"/>

	<table width="98%" border="0" cellspacing="1" cellpadding="2" align="center">

    	<tr >
        	<td colspan="10"  bgcolor="6f8ac4" align="right">
        		<%@ include file="/WEB-INF/page/share/fenye.jsp" %>
   			</td>
   		</tr>
        <tr>
            <td width="7%" bgcolor="6f8ac4"> 
            	<div align="center"><font color="#FFFFFF">产品ID</font></div>
            </td>
            <td width="8%" bgcolor="6f8ac4"> 
            	<div align="center"><font color="#FFFFFF">货号</font></div>
            </td>
            <td width="5%" nowrap bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">修改</font></div>
            </td>
            <td width="30%" bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">产品名称</font></div>
            </td>
            <td width="12%" nowrap bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">所属分类</font></div>
            </td>
            <td width="7%" bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">底价</font></div>
            </td>
            <td width="7%" bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">销售价</font></div>
            </td>
            <td width="6%" bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF"></font></div>
            </td>
            <td width="6%" bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">推荐</font></div>
            </td>
            <td width="12%" bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF"></font></div>
            </td>
    	</tr>
    	<!-- Loop Start -->
    	<c:forEach items="${pageView.records}" var="product">
	        <tr>
	      		<td bgcolor="f5f5f5"> 
	            	<div align="center"><input type="checkbox" name="productids" value="${product.id}"/>${product.id}</div>
	            </td>
	            <td bgcolor="f5f5f5"> 
	            	<div align="center">${product.code}</div>
	            </td>
	      		<td bgcolor="f5f5f5"> 
	      			<div align="center">
	      				<a href='<s:url action="product_editUI" namespace="/control/product" includeParams="none"/>?productid=${product.id}'>
		  					<img src="<%=request.getContextPath() %>/images/edit.gif" width="15" height="16" border="0"/></a>
	      				</a>
	      			</div>
	      		</td>
	      		<td bgcolor="f5f5f5"> 
	            	<div align="center">${product.name}</div>
	            </td>
	            <td bgcolor="f5f5f5"> 
	            	<div align="center">${product.producttype.name}</div>
	            </td>
	            <td bgcolor="f5f5f5"> 
	            	<div align="center">${product.baseprice}</div>
	            </td>
	            <td bgcolor="f5f5f5"> 
	            	<div align="center">${product.sellprice}</div>
	            </td>
	            <td bgcolor="f5f5f5"> 
	            	<div align="center">
	            		<c:if test="${product.visible}">
	            			<font color="red">在售</font>	                
	                	</c:if>
	                	<c:if test="${!product.visible}">
	            			停售	                
	                	</c:if>	
	                </div>
	            </td>
	      		<td bgcolor="f5f5f5"> 
	            	<div align="center">
	            		<c:if test="${product.commend}">
	            			<font color="red">推荐</font>	                
	                	</c:if>
	                	<c:if test="${!product.commend}">
	            			--                
	                	</c:if>	
	                </div>
	            </td>
	            <td bgcolor="f5f5f5"> 
	            	<div align="center">
	            		<a href='<s:url action="list" namespace="/control/product/style" includeParams="none" />?productid=${product.id}'>产品图片管理</a>
	                </div>
	            </td>
			</tr>
		</c:forEach>
		<!-- Loop end -->
    <tr> 
      <td bgcolor="f5f5f5" colspan="10" align="center">
      	<table width="100%" border="0" cellspacing="1" cellpadding="3">
          <tr> 
            <td width="25%"><input type="checkbox" name="all" onclick="javascript:allselect(this, this.form.productids)"/>全选</td>
              <td width="85%">
           
              <input type="button" class="frm_btn" onClick="JavaScript:window.location.href='<s:url action="product_addUI" namespace="/control/product" includeParams="none"/>'" value="添加产品"/> &nbsp;&nbsp;			  
			  <input name="query" type="button" class="frm_btn" id="query" onClick="javascript:window.location.href='<s:url action="product_queryUI" namespace="/control/product" includeParams="none"/>'" value=" 查 询 "> &nbsp;&nbsp;
              <input name="visible" type="button" class="frm_btn" onClick="javascript:actionEvent()" value=" 上架"> &nbsp;&nbsp;
              <input name="disable" type="button" class="frm_btn" onClick="javascript:actionEvent2()" value=" 下架"> &nbsp;&nbsp;
              <input name="commend" type="button" class="frm_btn" onClick="javascript:actionEvent3()" value=" 推荐"> &nbsp;&nbsp;
              <input name="uncommend" type="button" class="frm_btn" onClick="javascript:actionEvent4()" value=" 不推荐"> &nbsp;&nbsp;
            </td>
          </tr>
        </table>
      </td>
    </tr>
    </table>
</s:form>
</body>
</html>
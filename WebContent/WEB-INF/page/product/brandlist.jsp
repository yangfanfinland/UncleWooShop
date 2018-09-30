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
</script>
</head>
<body>
<s:form action="list" namespace="/control/product/brand" method="post" >
<s:hidden name="page"/>
<s:hidden name="query"/>
<s:hidden name="name"/>
	<table width="98%" border="0" cellspacing="1" cellpadding="2" align="center">

    	<tr >
        	<td colspan="4"  bgcolor="6f8ac4" align="right">
        		<%@ include file="/WEB-INF/page/share/fenye.jsp" %>
   			</td>
   		</tr>
        <tr>
            <td width="30%" bgcolor="6f8ac4"> 
            	<div align="center"><font color="#FFFFFF">代号</font></div>
            </td>
            <td width="5%" nowrap bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">修改</font></div>
            </td>
            <td width="35%" bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">品牌名称</font></div>
            </td>
            <td width="30%" nowrap bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">Logo</font></div>
            </td>
    	</tr>
    	<!-- Loop Start -->
    	<c:forEach items="${pageView.records}" var="productBrand">
	        <tr>
	      		<td bgcolor="f5f5f5"> 
	            	<div align="center">${productBrand.code}</div>
	            </td>
	      		<td bgcolor="f5f5f5"> 
	      			<div align="center">
	      				<a href="<s:url action="brand_editUI" namespace="/control/product/brand" includeParams="none"/>?code=${productBrand.code}">
		  					<img src="<%=request.getContextPath() %>/images/edit.gif" width="15" height="16" border="0"/></a>
	      				</a>
	      			</div>
	      		</td>
	      		<td bgcolor="f5f5f5">
	            	<div align="center">${productBrand.name}</div>
	            </td>
		  		<td bgcolor="f5f5f5"> 
	            	<div align="center"><img src="<%=request.getContextPath() %>${productBrand.logopath}" width="100" /></div>
	            </td>
			</tr>
		</c:forEach>
		<!-- Loop end -->
    <tr> 
      <td bgcolor="f5f5f5" colspan="4" align="center">
      	<table width="100%" border="0" cellspacing="1" cellpadding="3">
          <tr> 
            <td width="5%"></td>
              <td width="85%">
           
              <input type="button" class="frm_btn" onClick="JavaScript:window.location.href='<s:url action="brand_addUI" namespace="/control/product/brand" includeParams="none"/>'" value="添加品牌"/> &nbsp;&nbsp;			  
			  <input name="query" type="button" class="frm_btn" id="query" onClick="javascript:window.location.href='<s:url action="brand_queryUI" namespace="/control/product/brand" includeParams="none"/>'" value=" 查 询 "> &nbsp;&nbsp;
            </td>
          </tr>
        </table>
      </td>
    </tr>
    </table>
</s:form>
</body>
</html>
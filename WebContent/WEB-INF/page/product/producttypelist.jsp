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
<s:form action="list" namespace="/control/product/type" method="post" >
<s:hidden name="page"/>
<s:hidden name="parentid"/>
<s:hidden name="name"/>
<s:hidden name="query"/>

	<table width="98%" border="0" cellspacing="1" cellpadding="2" align="center">

    	<tr >
        	<td colspan="7"  bgcolor="6f8ac4" align="right">
        		<%@ include file="/WEB-INF/page/share/fenye.jsp" %>
   			</td>
   		</tr>
        <tr>
            <td width="8%" bgcolor="6f8ac4"> 
            	<div align="center"><font color="#FFFFFF">代号</font></div>
            </td>
            <td width="5%" nowrap bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">修改</font></div>
            </td>
            <td width="20%" bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">产品类别名称</font></div>
            </td>
            <td width="10%" nowrap bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">创建下级类别</font></div>
            </td>
            <td width="15%" bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">子类个数</font></div>
            </td>
            <td width="15%" bgcolor="6f8ac4">
            	<div align="center"><font color="#FFFFFF">所属父类</font></div>
            </td>
            <td nowrap bgcolor="6f8ac4"> 
            	<div align="center"><font color="#FFFFFF">备注</font></div>
            </td>
    	</tr>
    	<!-- Loop Start -->
    	<c:forEach items="${pageView.records}" var="productType">
	        <tr>
	      		<td bgcolor="f5f5f5"> 
	            	<div align="center">${productType.typeid}</div>
	            </td>
	      		<td bgcolor="f5f5f5"> 
	      			<div align="center">
	      				<a href="<s:url action="manage_editUI" namespace="/control/product/type" includeParams="none" />?typeid=${productType.typeid}">
		  					<img src="<%=request.getContextPath() %>/images/edit.gif" width="15" height="16" border="0"/></a>
	      				</a>
	      			</div>
	      		</td>
	      		<td bgcolor="f5f5f5">
	            	<div align="center">
	                	<a href='<s:url action="list" namespace="/control/product/type" includeParams="none" />?parentid=${productType.typeid}'>${productType.name}</a>
	                </div>
	            </td>
		  		<td bgcolor="f5f5f5"> 
	            	<div align="center">
	                	<a href='<s:url action="manage_addUI" namespace="/control/product/type" includeParams="none"/>?parentid=${productType.typeid}'>创建子类别</a>				                
	                </div>
	            </td>
	            <td bgcolor="f5f5f5"> 
	            	<div align="center">
	            		<c:if test="${fn:length(productType.childtypes)>0}">
	            			<font color="red">(有${fn:length(productType.childtypes)}个子类)</font>	                
	                	</c:if>
	                	<c:if test="${fn:length(productType.childtypes)<=0}">
	            			没有子类	                
	                	</c:if>	
	                </div>
	            </td>
	            <td bgcolor="f5f5f5" align="center">
	            	<c:if test="${!empty productType.parent}">${productType.parent.name}</c:if>
	            </td>
		  		<td bgcolor="f5f5f5">
					${productType.note}
		  		</td>
			</tr>
		</c:forEach>
		<!-- Loop end -->
    <tr> 
      <td bgcolor="f5f5f5" colspan="7" align="center">
      	<table width="100%" border="0" cellspacing="1" cellpadding="3">
          <tr> 
            <td width="5%"></td>
              <td width="85%">
           
              <input name="AddDic" type="button" class="frm_btn" id="AddDic" onClick="JavaScript:window.location.href='<s:url action="manage_addUI" namespace="/control/product/type" includeParams="none"/>?parentid=${param.parentid}'" value="添加类别"/> &nbsp;&nbsp;			  
			  <input name="query" type="button" class="frm_btn" id="query" onClick="javascript:window.location.href='<s:url action="manage_queryUI" namespace="/control/product/type" includeParams="none"/>'" value=" 查 询 "> &nbsp;&nbsp;
            </td>
          </tr>
        </table>
      </td>
    </tr>
    </table>
</s:form>
</body>
</html>
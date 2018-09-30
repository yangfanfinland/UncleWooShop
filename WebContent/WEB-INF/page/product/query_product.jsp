<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<html>
<head>
<title>添加产品</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<s:form action="list" namespace="/control/product" method="post">
<input type="hidden" name="method" value="edit">
<s:hidden name="typeid"/>
<input name="query" value="true" type="hidden"/>
  <table width="98%" border="0" cellspacing="1" cellpadding="3" align="center">
    <tr bgcolor="6f8ac4"> 
      <td colspan="2" ><font color="#FFFFFF">查询产品：</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">产品名称  ：</div></td>
      <td width="75%"> <input type="text" name="name" size="50" maxlength="40"/></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">产品类别  ：</div></td>
      <td width="75%"> <input type="text" name="v_type_name" disabled="disabled" size="30" value="${typename }" />
      	<!-- 
        <input type="button" name="select" value="选择..." onClick="javaScript:winOpen('<s:url action="/control/product/type"/>','列表',600,400)">(<a href="<s:url action='/control/product/type/manage'/>">添加产品类别</a>)
      	 --> 
      	
      	<input type="button" name="select" value="选择..." onClick="javascript:window.open('<s:url action="productType_selectUI" namespace="/control/product" includeParams="none"/>','列表',600,400)">
      	 
      </td>
    </tr>
	<tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">底(采购)价 (欧元 )：</div></td>
      <td width="75%">
      	在<input type="text" name="startbaseprice" size="10" maxlength="10" onkeypress="javascript:InputLongNumberCheck()"/>
      	与<input type="text" name="endbaseprice" size="10" maxlength="10" onkeypress="javascript:InputLongNumberCheck()"/>之间 
      </td>
    </tr>
	<tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">销售价 (欧元 )：</div></td>
      <td width="75%"> 
      	在<input type="text" name="startsellprice" size="10" maxlength="10" onkeypress="javascript:InputLongNumberCheck()"/>
      	与<input type="text" name="endsellprice" size="10" maxlength="10" onkeypress="javascript:InputLongNumberCheck()"/>之间 
      </td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">货号 ：</div></td>
      <td width="75%"> <input type="text" name="code" size="20" maxlength="30"/>(注:供货商提供的便于产品查找的编号)</td>
    </tr>
	<tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">品牌 ：</div></td>
      <td width="75%"> 
  		<!-- 
      	<html:select property="brandid">
          <html:option value="">***无***</html:option>
          <html:optionsCollection name="brands" label="name" value="code"/>
        </html:select>
		 -->
        <select name="brandid">
        	<option value="">***无***</option>
        	<c:forEach items="${brands}" var="brand">
        		<option value="${brand.code}">${brand.name}</option>
        	</c:forEach>
        </select>
      </td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td colspan="2"> <div align="center"> 
          <input type="submit" name="edit" value=" 确 认 " class="frm_btn"/>
          &nbsp;&nbsp;<input type="button" name="Button" value=" 返 回 " class="frm_btn" onclick="javascript:history.back()">
        </div></td>
    </tr>
  </table>
</s:form>
<br>
</body>
</html>
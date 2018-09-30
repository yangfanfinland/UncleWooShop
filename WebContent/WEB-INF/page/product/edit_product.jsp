<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<html>
<head>
<title>添加产品</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function LTrim(str){ 
	    var i;
	    for(i=0;i<str.length; i++) {
	        if(str.charAt(i)!=" ") break;
	    }
	    str = str.substring(i,str.length);
	    return str;
	}
	
	function Formfield(name, label){
		this.name=name;
		this.label=label;
	}
	function verifyForm(objForm){
		var list  = new Array(new Formfield("name", "产品名称"),new Formfield("typeid", "产品类型"),
		new Formfield("baseprice", "产品底价"),new Formfield("marketprice", "产品市场价")
		,new Formfield("sellprice", "产品销售价"),new Formfield("description", "产品描述"));
		for(var i=0;i<list.length;i++){
			var objfield = eval("objForm."+ list[i].name);
			if(LTrim(objfield.value)==""){
				alert(list[i].label+ "不能为空");
				if(objfield.type!="hidden" && objfield.focus()) 
					objfield.focus();
				return false;
			}
		}
	    return true;
	}
	function SureSubmit(objForm){
		if(verifyForm(objForm))
			objForm.submit();
	} 
</script>
</head>

<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<s:form action="edit_product" namespace="/control/product" enctype="multipart/form-data" method="post">
<input type="hidden" name="method" value="edit">
<s:hidden name="typeid"/>
<s:hidden name="productid"/>
  <table width="98%" border="0" cellspacing="1" cellpadding="3" align="center">
    <tr bgcolor="6f8ac4"> 
      <td colspan="2" ><font color="#FFFFFF">修改产品：</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">产品名称  ：</div></td>
      <td width="75%"> <input type="text" name="name" size="50" maxlength="40" value="${name}"/><font color="#FF0000">*</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">产品类别<font color="#FF0000">*</font>  ：</div></td>
      <td width="75%"> <input type="text" name="v_type_name" disabled="disabled" size="30" value="${typename }" />
      	<!-- 
        <input type="button" name="select" value="选择..." onClick="javaScript:winOpen('<s:url action="/control/product/type"/>','列表',600,400)">(<a href="<s:url action='/control/product/type/manage'/>">添加产品类别</a>)
      	 --> 
      	
      	<input type="button" name="select" value="选择..." onClick="javascript:window.open('<s:url action="productType_selectUI" namespace="/control/product" includeParams="none"/>','列表',600,400)">(<a href="<s:url action='manage_addUI' namespace="/control/product/type"/>">添加产品类别</a>)
      	 
      </td>
    </tr>
	<tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">底(采购)价 ：</div></td>
      <td width="75%"> <input type="text" name="baseprice" size="10" maxlength="10" value="${baseprice }" onkeypress="javascript:InputLongNumberCheck()"/>欧元 <font color="#FF0000">*</font></td>
    </tr>
	<tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">市场价 ：</div></td>
      <td width="75%"> <input type="text" name="marketprice" size="10" maxlength="10" value="${marketprice}" onkeypress="javascript:InputLongNumberCheck()"/>欧元 <font color="#FF0000">*</font></td>
    </tr>
	<tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">销售价 ：</div></td>
      <td width="75%"> <input type="text" name="sellprice" size="10" maxlength="10" value="${sellprice}" onkeypress="javascript:InputLongNumberCheck()"/>欧元 <font color="#FF0000">*</font></td>
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
        <select name="">
        	<option value="">***无***</option>
        	<c:forEach items="${brands}" var="brand">
        		<option value="${brand.code}">${brand.name}</option>
        	</c:forEach>
        </select>
        
        
        (<a href="<s:url action='brand_addUI' namespace="/control/product/brand"/>">添加品牌</a>)
      </td>
    </tr>
	<tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">适用性别 ：</div></td>
      <td width="75%"><select name="sex">   
			<option value="NONE">男女不限</option>   
			<option value="MAN">男士</option>   
			<option value="WOMEN">女士</option>
		</select>
		</td>
    </tr>
	<tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">型号 ：</div></td>
      <td width="75%"> <input type="text" name="model" size="35" maxlength="30"/></td>
    </tr>
	<tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">重量 ：</div></td>
      <td width="75%"> <input type="text" name="weight" size="10" maxlength="10" onkeypress="javascript:InputIntNumberCheck()"/>克</td>
    </tr>
	<tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">购买说明 ：</div></td>
      <td width="75%"> <input type="text" name="buyexplain" size="35" maxlength="30"/></td>
    </tr>
	<tr bgcolor="f5f5f5"> 
      <td width="25%" valign="top"> <div align="right">产品简介<font color="#FF0000">*</font> ：</div></td>
      <td width="75%"><textarea name="description" cols="50" rows="10">${description}</textarea></td>
	</tr>
    <tr bgcolor="f5f5f5"> 
      <td colspan="2"> <div align="center"> 
          <input type="button" name="edit" value=" 确 认 " class="frm_btn" onClick="javascript:SureSubmit(this.form)">
          &nbsp;&nbsp;<input type="button" name="Button" value=" 返 回 " class="frm_btn" onclick="javascript:history.back()">
        </div></td>
    </tr>
  </table>
</s:form>
<br>
</body>
</html>
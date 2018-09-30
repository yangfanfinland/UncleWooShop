<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<!DOCtype html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<TITLE>Shopping cart -- Uncle Woo China Town</TITLE>
<METa http-equiv=Content-type content="text/html; charset=UTF-8">
<METa http-equiv=Content-Language content=zh-CN>
<link href="<%=request.getContextPath() %>/css/new_cart.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/css/global/header01.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/FoshanRen.js"></script>
<script type="text/javascript">
	function modifyamount(){
		var form = document.forms["buycart"];
		form.action='<s:url action="update_cart" namespace="/center/shopping" includeParams="none" />';
		form.submit();
		}
	function settleaccounts(){
		var form = document.forms["buycart"];
		form.action='<s:url action="pay_cart" namespace="/customer/shopping" includeParams="none" />';
		form.submit();
	}
</script>
</head>
<body>
<jsp:include page="/WEB-INF/page/share/Head.jsp"/>
<br/>
<table cellSpacing=0 cellPadding=5 width="98%" border="0" align="center">
  <tr>
    <td>
    <table cellSpacing=0 cellPadding=0 width="96%" border=0>
      <tbody>
        <tr>
          <td width="24%"><img height=31 src="<%=request.getContextPath() %>/images/buy/shop-cart-header-blue.gif" width="218" border=0/></td>
          <td width="34%">After modify the product amount, click  
             <img style="cursor: pointer; " alt="修改数量" src="<%=request.getContextPath() %>/images/buy/update-t-sm.gif" border="0" onClick="javascript:modifyamount()"></td>
          <td width="14%" align="left"><a href='<s:url action="delete_allcart" namespace="/center/shopping" includeParams="none" />'><img style="cursor: pointer;" alt="清空购物车" src="<%=request.getContextPath() %>/images/buy/az-empty-shoppingcard.gif" border="0"></a></td>
          <td width="15%" align=left><a href="/"><img src="<%=request.getContextPath() %>/images/buy/as-s-continus.gif" width="116" height="22" border="0"></a></td>
          <td width="13%" align=right><img style="cursor: pointer;" src="<%=request.getContextPath() %>/images/buy/az-by-split.gif" width="116" height="22" onClick="javascript:settleaccounts()"></td>
        </tr>
      </tbody>
    </table>
    </td>
  </tr>

  <tr>
    <td><s:form id="buycart" name="buycart" action="" method="post">
     		<input type="hidden" NaME="directUrl" value="${param.directUrl}"/>
		    <table cellSpacing=0 cellPadding=6 width="100%" border=0> 
		      <tr bgColor=#d7ebff>
		        <td width="457"><strong>Products in Shopping Cart -- Purchase at once</strong></td>
		        <td width=112><div align=center><strong>Market Price</strong></div></td>
		        <td width=181><div align=center><strong>Price</strong></div></td>
		        <td width=73><div align=center><strong>Amount</strong></div></td>
		        <td width=66>&nbsp;</td>
		      </tr>
		<!-- loop begin -->
		<c:forEach items="${buyCart.items}" var="item"> 
		       <tr valign="top">
		        <td>
		        	<strong><a href="" target="_blank">${item.product.name}</a></strong> 
		        	<span class="h3color">[Color/Style: <c:forEach items="${item.product.styles}" var="style">${style.name}</c:forEach></span><br/><br/>
		        </td>
		        <td width="112" align="center">
		        	<span class="price" title="€${item.product.marketprice}"><font color="black"><s><b>€${item.product.marketprice}</b></s></font></span>
		        </td>
		        <td width="181">
		        	<p align="center"><span class="price">
		        		<b>€${item.product.sellprice}</b></span><br/>
		          		Save: <span class=price>€${item.product.savedPrice}</span><br/> 
		          </p>
		        </td>
		        <td align="middle" width="73">
		        	<input type="text" style="WIDTH: 30px" maxLength="3" value="${item.amount}"  name="amount_${item.product.id}_<c:forEach items="${item.product.styles}" var="style">${style.id}</c:forEach>" onkeypress="javascript:inputIntNumberCheck()">
		        </td>
		        <td align="middle" width="66">
		        	<a href='<s:url action="delete_cart" namespace="/center/shopping" includeParams="none" />?buyitemid=${item.product.id}-<c:forEach items="${item.product.styles}" var="style">${style.id}</c:forEach>'><img height="17" src="<%=request.getContextPath() %>/images/buy/delete.gif" width="45" border="0"></a>
		        </td>
		      </tr>
		          
		      <tr valign="top">
		        <td colspan="5">
		        	<img height=1 src="<%=request.getContextPath() %>/images/buy/green-pixel.gif" width="100%" border="0">
		        </td>
		      </tr>
		</c:forEach>
		<!-- loop end -->	  
		    </table>
    	</s:form>
	      <table width="96%" border="0" align="left">
	        <tr>
	          <td width="60%" align="right">After modify the product amount, click
	          <img style="cursor: pointer;" alt="修改数量" src="<%=request.getContextPath() %>/images/buy/update-t-sm.gif" border="0" onClick="javascript:modifyamount()"/></td>
	          <td width="9%" align="right"><div align="right"><span class="price"><strong><B><font color="black">Total:</font></B></strong></span></div></td>
	          <td width="11%" align="right"><div align="center"><span class="price"><strong><B class="price"><font color="black">${buyCart.totalPrice} €</font></B></strong></span></div></td>
	          <td width="8%" align="right"><div align="right"><span class="price"><strong><B><font color="black">Save: </font></B></strong></span></div></td>
	          <td width="12%" align="right"><div align="center"><span class="price"><strong><B class="price">${buyCart.totalSavedPrice} €</B></strong></span></div></td>
	        </tr>
	        <tr>
	          <td colspan="3" align="right">&nbsp;</td>
	          <td colspan="2" align="right"><img style="cursor: pointer;" src="<%=request.getContextPath() %>/images/buy/az-by-split.gif" width="116" height="22" onClick="javascript:settleaccounts()"></td>
	        </tr>
	      </table>
     </td>
  </tr>
</table>
<br>
<jsp:include page="/WEB-INF/page/share/Foot.jsp" />
</body>
</HTML>

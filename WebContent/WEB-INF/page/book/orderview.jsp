<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>订单查看</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/FoshanRen.js"></script>
<style type="text/css">
<!--
body {font-size: 12px;line-height:16px}
a:link { color: #3300FF; 
     text-decoration: underline;  }    
    
a {color: #3300FF; 
     text-decoration: underline; }
     
a:hover { color: #FF6600; 
           text-decoration: underline; }

A.subnav:link {
	FONT-SIZE: 12px; COLOR: #330000; LINE-HEIGHT: 155%; TEXT-DECORATION: none
}
A.subnav:visited {
	FONT-SIZE: 12px; COLOR: #330000; LINE-HEIGHT: 155%; TEXT-DECORATION: none
}
A.subnav:active {
	FONT-SIZE: 12px; COLOR: #330000; LINE-HEIGHT: 155%; TEXT-DECORATION: none
}
A.subnav:hover {
	FONT-SIZE: 12px; COLOR: #330000; LINE-HEIGHT: 155%; TEXT-DECORATION: underline
}
-->
</style>

<script type="text/javascript">
function ActionEvent(orderid){
	window.location.href = '<s:url action="cancelOrder" namespace="/control/order" includeParams="none"/>?orderid='+ orderid;
}
function ActionEvent1(orderid){
	window.location.href = '<s:url action="confirmOrder" namespace="/control/order" includeParams="none"/>?orderid='+ orderid;
}
function ActionEvent2(orderid){
	window.location.href = '<s:url action="confirmPayment" namespace="/control/order" includeParams="none"/>?orderid='+ orderid;
}
function ActionEvent3(orderid){
	window.location.href = '<s:url action="turnWaitdeliver" namespace="/control/order" includeParams="none"/>?orderid='+ orderid;
}
function ActionEvent4(orderid){
	window.location.href = '<s:url action="turnDelivered" namespace="/control/order" includeParams="none"/>?orderid='+ orderid;
}
function ActionEvent5(orderid){
	window.location.href = '<s:url action="turnReceived" namespace="/control/order" includeParams="none"/>?orderid='+ orderid;
}
function deleteOrderItem(orderItemid, orderid){
	if(confirm('\n您确认删除该项吗?')){
		window.location.href ='<s:url action="deleteOrderItem" namespace="/control/order" includeParams="none"/>?orderitemid='+ orderItemid+"&orderid="+orderid;
	}
}


</script>
</head>
<body><br/>

<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#333333">
  <tr>
    <td><table width="100%" height="25" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr>
        <td width="59%"><strong>订单号:</strong>${order.orderid } <font color="red">(${order.state.name })</font></td>
        <td width="41%" align="right"><strong>订购时间:</strong>${order.createDate }</td>
      </tr>
    </table>
      <table width="100%" border="0" align="center" cellpadding="3" cellspacing="2">
        <tr>
          <td colspan="4" bgcolor="#FFFFFF"><strong>订购者信息 </strong> <a href='<s:url action="modifyContactInfoUI" namespace="/control/order" includeParams="none"/>?contactid=${order.orderContactInfo.contactid }'>修改</a></td>
          <td align="center" bgcolor="#FFFFFF">支付方式</td>
          <td colspan="2" bgcolor="#FFFFFF">${order.paymentWay }</td>
        </tr>
        <tr>
          <td align="center" bgcolor="#FFFFFF">姓名</td>
          <td colspan="2" bgcolor="#FFFFFF">${order.orderContactInfo.buyerName }（${order.orderContactInfo.gender }）</td>
          <td align="center" bgcolor="#FFFFFF">联系手机</td>
          <td colspan="1" bgcolor="#FFFFFF">${order.orderContactInfo.mobile }</td>
          <td align="center"  bgcolor="#FFFFFF">邮箱</td>
          <td colspan="1" bgcolor="#FFFFFF">${order.orderContactInfo.email }</td>
        </tr>
        <tr>
          <td align="center" bgcolor="#FFFFFF">地址</td>
          <td colspan="3" bgcolor="#FFFFFF">${order.orderContactInfo.address }</td>
          <td align="center" bgcolor="#FFFFFF">邮编</td>
          <td colspan="3" bgcolor="#FFFFFF">${order.orderContactInfo.postalcode }</td>
        </tr>
        <tr>
          <td align="center" bgcolor="#FFFFFF">要求</td>
          <td colspan="6" bgcolor="#FFFFFF">${order.note}</td>
        </tr>
        <tr>
          <td colspan="8" bgcolor="#FFFFFF"><strong>收货人信息</strong> <a href='<s:url action="modifyDeliverInfoUI" namespace="/control/order" includeParams="none"/>?deliverid=${order.orderDeliverInfo.deliverid }'>修改</a></td>
        </tr>
        <tr>
          <td align="center" bgcolor="#FFFFFF">姓名</td>
          <td colspan="2" bgcolor="#FFFFFF">${order.orderDeliverInfo.recipients }</td>
          <td align="center" bgcolor="#FFFFFF">联系手机</td>
          <td colspan="1" bgcolor="#FFFFFF">${order.orderDeliverInfo.mobile }</td>
          <td align="center" bgcolor="#FFFFFF">邮箱</td>
          <td colspan="1" bgcolor="#FFFFFF">${order.orderDeliverInfo.email }</td>
        </tr>
        <tr>
          <td align="center" bgcolor="#FFFFFF">地址</td>
          <td colspan="3" bgcolor="#FFFFFF">${order.orderDeliverInfo.address }</td>
          <td align="center" bgcolor="#FFFFFF">邮编</td>
          <td colspan="2" bgcolor="#FFFFFF">${order.orderDeliverInfo.postalcode }</td>
        </tr>
        <tr>
          <td colspan="8" bgcolor="#FFFFFF"><strong>订购的商品</strong></td>
		  </td>
        </tr>
        <tr>
          <td align="center" bgcolor="#FFFFFF">商品编号</td>
          <td colspan="3" align="center" bgcolor="#FFFFFF">商品名称</td>
          <td align="center" bgcolor="#FFFFFF">单价</td>
          <td width="16%" align="center" bgcolor="#FFFFFF">数量</td>
          <td width="5%" align="center" bgcolor="#FFFFFF">&nbsp;</td>
        </tr>
<c:forEach items="${order.items}" var="item">
        <tr>
          <td align="center" bgcolor="#FFFFFF">${item.productid }</td>
          <td colspan="3" align="center" bgcolor="#FFFFFF">${item.productName } <font color="red">[${item.styleName }]</font></td>
          <td align="center" bgcolor="#FFFFFF">€${item.productPrice }</td>
          <td align="center" bgcolor="#FFFFFF">${item.amount } <a href='<s:url action="modifyProductAmountUI" namespace="/control/order" includeParams="none"/>?orderitemid=${item.itemid }'>修改</a></td>
          <td align="center" bgcolor="#FFFFFF"><a href="JavaScript:deleteOrderItem('${item.itemid }','${order.orderid }')">删除</a></td>
        </tr>
</c:forEach>
        <tr>
          <td colspan="7" align="right" bgcolor="#FFFFFF"><p>商品合计：€${order.productTotalPrice }&nbsp;&nbsp;配送费：€${order.deliverFee }<a href='<s:url action="modifyDeliverFeeUI" namespace="/control/order" includeParams="none"/>?orderid=${order.orderid}'>修改</a>&nbsp;&nbsp;订单合计：€${order.totalPrice }<br />
            
			&nbsp;&nbsp;<strong>应付金额：</strong>€${order.payablefee }</p>          </td>
        </tr>
      </table></td>
  </tr>
</table>
<br />
<table width="90%" border="0" align="center" cellpadding="0" cellspacing="2">
  <tr>
    <td width="15%" bgcolor="#FFFFFF">
    <c:if test="${order.state!='RECEIVED' && order.state!='CANCEL'}">
	<input type="button" value="取消订单" onclick="JavaScript:ActionEvent('${order.orderid }')"/>&nbsp;
     </c:if>
     <c:if test="${order.state=='WAITCONFIRM'}">
    <input type="button" value="审核通过" onclick="JavaScript:ActionEvent1('${order.orderid }')"/>&nbsp;	
    </c:if>
    <c:if test="${order.state=='WAITPAYMENT'}">
    <input type="button" value="财务确认已付款" onclick="JavaScript:ActionEvent2('${order.orderid }')"/>&nbsp;	
    </c:if>
    <c:if test="${order.state=='ADMEASUREPRODUCT'}">
    <input type="button" value="等待发货" onclick="JavaScript:ActionEvent3('${order.orderid }')"/>&nbsp;	
    </c:if>
    <c:if test="${order.state=='WAITDELIVER'}">
    <input type="button" value="已经发货" onclick="JavaScript:ActionEvent4('${order.orderid }')"/>&nbsp;	
    </c:if>
    <c:if test="${order.state=='DELIVERED'}">
    <input type="button" value="已经收货" onclick="JavaScript:ActionEvent5('${order.orderid }')"/>&nbsp;	
    </c:if>
    <input type="button" value="打印订单" onclick="JavaScript:winOpen('<s:url action="printOrder" namespace="/control/order" includeParams="none"/>?orderid=${order.orderid }','打印',700,450)"/>&nbsp;
	<input type="button" value="解锁退出" onclick="JavaScript:window.location.href='<s:url action="employeeUnlockOrder" namespace="/control/order" includeParams="none"/>?orderid=${order.orderid }'"/>
	</td>
  </tr>
</table>
<br />
<table width="90%" border="0" align="center" cellpadding="2" cellspacing="2">
  <tr>
    <td colspan="2"  bgcolor="6f8ac4"><font color="#FFFFFF">客服留言</font> &nbsp; <input type="button" value="客服留言" onclick="JavaScript:window.location.href='<s:url action="addMessageUI" namespace="/control/order" includeParams="none"/>?orderid=${order.orderid}'"/></td>
  </tr>
  <tr>
    <td width="30%" align="center" bgcolor="#FFFFCC">留言者/时间</td>
    <td width="70%" align="center" bgcolor="#FFFFCC">内容</td>
  </tr>
  <c:forEach items="${order.msgs}" var="msg">
  <tr>
    <td>${msg.username } / ${msg.createtime }</td>
    <td >${msg.content }</td>
  </tr>
  <tr>
  	<td colspan="2" height="1" bgcolor="#BBC9FF"></td>
  </tr>
  </c:forEach>
</table>
<p>&nbsp;</p>
</body>
</html>
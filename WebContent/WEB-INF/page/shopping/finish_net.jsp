<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>订单完成 巴巴运动网</title>
<meta http-equiv=Content-Type content="text/html; charset=UTF-8"/>
<meta http-equiv=Content-Language content=zh-CN/>
<link href="<%=request.getContextPath() %>/css/new_cart.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/css/global/header01.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/FoshanRen.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/page/share/Head.jsp"/>
<br/>
<h1>订单号:${param.orderid },应付金额:${param.payablefee }元</h1>
<br/>
你选择的付款方式为"网上支付",现在你就可以进行<a href="?orderid=${param.orderid }"><font color="red">网上支付</font></a>.
<br/>
<jsp:include page="/WEB-INF/page/share/Foot.jsp" />
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=request.getContextPath() %>/css/global/header01.css" rel="stylesheet" type="text/css"/>
<title>Main Page</title>
</head>
<body>
	<jsp:include page="/WEB-INF/page/share/Head.jsp"/>
	<div id="flash">
		<embed src="<%=request.getContextPath()%>/flash/ship.swf" width="970" height="200"/>
	</div>
	<div id="product_news">
		<div id="product">
			<div class="new_product">
				<center><b>新品上市</b></center>
			</div>
		</div>
		<div id="news">
			<div class="news_text">
				<center><b>最新动态</b></center>
			</div>
			<div>
				<ul>
					<li><a href="">购物满100欧，赠送礼品</a></li><br/>
					<li><a href="">购物满100欧，赠送礼品</a></li><br/>
					<li><a href="">购物满100欧，赠送礼品</a></li><br/>
					<li><a href="">购物满100欧，赠送礼品</a></li><br/>
					<li><a href="">购物满100欧，赠送礼品</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div id="discount_brand">
		<div id="discount">
			<div class="productinfo">
				<center><b>促销商品</b></center>
			</div>
		</div>
		<div id="brand">
			<div class="brand_text">
				<center><b>品牌专区</b></center>
				<marquee direction="up" behavior="scroll" onmouseover="this.stop()" onmouseout="this.start()" scrollamount="3" scrolldelay="0">
					<img src="<%=request.getContextPath() %>/images/test/face1.jpg"  width="300" height="50"/>
					<img src="<%=request.getContextPath() %>/images/test/face2.jpg"  width="300" height="50"/>
					<img src="<%=request.getContextPath() %>/images/test/face3.jpg"  width="300" height="50"/>
					<img src="<%=request.getContextPath() %>/images/test/face4.jpg"  width="300" height="50"/>
					<img src="<%=request.getContextPath() %>/images/test/face5.jpg"  width="300" height="50"/>
					<img src="<%=request.getContextPath() %>/images/test/face6.jpg"  width="300" height="50"/>
					<img src="<%=request.getContextPath() %>/images/test/face7.jpg"  width="300" height="50"/>
					<img src="<%=request.getContextPath() %>/images/test/face8.jpg"  width="300" height="50"/>
					<img src="<%=request.getContextPath() %>/images/test/face9.jpg"  width="300" height="50"/>
				</marquee>
			</div>
		</div>
	</div>
	<div id="recommand_knowledge">
		<div id="recommand">
			<div class="productdetail">
				<center><b>店长推荐</b></center>
			</div>
		</div>
		<div id="knowledge">
			<div class="knowledge_text">
				<center><b>美食宝典</b></center>
			</div>
			<div>
				<ul>
					<li><a href="">白斩鸡的做法</a></li><br/>
					<li><a href="">基围虾的做法</a></li><br/>
					<li><a href="">白斩鸡的做法</a></li><br/>
					<li><a href="">基围虾的做法</a></li><br/>
					<li><a href="">白斩鸡的做法</a></li>
				</ul>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/page/share/Foot.jsp"/>
</body>
</html>
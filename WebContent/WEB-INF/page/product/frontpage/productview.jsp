<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<!DOCtype html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
<link href="<%=request.getContextPath() %>/css/global/header01.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/css/product/product.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/css/global/topcommend.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/FoshanRen.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/xmlhttp.js"></script>
	<title>${product.name}-巴巴运动网</title>
<meta name="Keywords" content="${product.name}"/>
<meta name="description" content=""/>

</head>

<body onload="pageInit()">

	<script type="text/javascript">
		function pageInit(){
			getTopSell("${producttype.typeid}");
			getViewHistory();
		}
		function getTopSell(typeid){
			var salespromotion = document.getElementById('salespromotion');		
			if(salespromotion && typeid!=""){
				salespromotion.innerHTML= "Data is loading...";
				send_request(function(value){salespromotion.innerHTML=value},
						 "<s:url action="productswitch" namespace="/center/product" includeParams="none"/>?typeid="+ typeid, true);
			}
		}
		function getViewHistory(){
			var viewHistoryUI = document.getElementById('historyaccess');		
			if(viewHistoryUI){
				viewHistoryUI.innerHTML= "Data is loading...";
				send_request(function(value){viewHistoryUI.innerHTML=value},
						 "<s:url action="productviewhistory" namespace="/center/product" includeParams="none"/>?", true);
			}
		}
	</script>
	
	<jsp:include page="/WEB-INF/page/share/Head.jsp" />
	<div id="ContentBody">
		<!-- 页面主体 -->
		<c:set var="out" value="&gt;&gt; <em>${product.name}</em>" />
		<c:forEach items="${stypes}" var="type" varStatus="statu">
			<c:set var="out" value=" &gt;&gt; <a href='UncleWooShop/center/product/list.action?typeid=${type.typeid}'>${type.name}</a> ${out}" />
		</c:forEach>
		<div id="position">
			Your current position: <a href="/" name="linkHome">Uncle Woo China Town:</a> <span
				id="uc_cat_spnPath"><c:out value="${out}" escapeXml="false"></c:out></span>
		</div>
		<div class="browse_left">
			<!-- 页面主体 左边 -->
			<!-- 浏览过的商品 -->
			<div class="browse">
				<div class="browse_t">Product Viewed</div>
				<ul>
					<div id="historyaccess"></div>
				</ul>
			</div>
			<!--精品推荐 start -->
			<div id="topcommend" align="left">
				<div id="newtop">
					<img height=13 src="<%=request.getContextPath() %>/images/global/sy2.gif" width=192/>
				</div>
				<div id="newlist">
					<div id="newmore">
						<div class="title">Comment</div>
					</div>
					<div style="PADDING-LEFT: 10px; COLOR: #333333" id="salespromotion"></div>
					<span id="commenddetail"></span>
				</div>
			</div>
		</div>
		<!-- 页面主体 左边end -->

		<div id="Right">
			<!-- 页面主体 右边 -->
			<form action='<s:url action="cart" namespace="/center/shopping" includeParams="none"/>' method="post" name="cart">
				<input type="hidden" name="productid" value="${product.id}" />
				<div id="browse_left">
					<c:set var="currentimage" />
					<c:set var="imagecount" value="0" />
					<c:forEach items="${product.styles}" var="style">
						<c:if test="${style.visible}">
							<c:set var="currentimage" value="${style}" />
							<c:set var="imagecount" value="${imagecount+1}" />
						</c:if>
					</c:forEach>
					<div class="right_left">
						<div id="main_image" onclick="bigImageBrowse()" style="cursor: pointer;background:url(<%=request.getContextPath() %>${currentimage.imageFullPath}) center center no-repeat">
							
							<img src="<%=request.getContextPath() %>/images/global/product_blank.gif" width="200" height="240" />
						</div>
						<img src="<%=request.getContextPath() %>/images/global/zoom+.gif" onclick="bigImageBrowse()" style="cursor: pointer;" />
					</div>
		
		
					

					<div class="right_right">
						<div class="right_title">
							<b>${product.name}</b>
						</div>
						<div class="right_desc">
							<ul>
								<li class="li2">Product Code: a${product.id}<font color="#CC0000"> (Used on tel shopping)</font></li>
								<c:if test="${!empty product.brand}">
									<li>Brand: ${product.brand.name}</li>
								</c:if>
							</ul>
						</div>
						<div class="right_desc">
							<c:if test="${imagecount==1}">
								<input type="hidden" name="styleid" value="${currentimage.id }"/>
								<li>Color: ${currentimage.name }</li> 
								<input type="hidden" id="productImage_${currentimage.id }" value="${currentimage.imagename}"/> 
								<input type="hidden" id="productPrototypeImage_${currentimage.id }" value="${currentimage.imageFullPath}"/>
							</c:if>
							<c:if test="${imagecount>1}">
								<img src="<%=request.getContextPath() %>/images/global/init.gif" width="0" height="0"/>
									<li>Color:
										<select name="styleid" onchange="styleEvent(this.value)">
												<c:forEach items="${product.styles}" var="style">
													<c:if test="${style.visible}">
														<option value="${style.id }"
															<c:if test="${style.id==currentimage.id}">selected </c:if>>${style.name}
														</option>
													</c:if>
												</c:forEach>
										</select>
									</li> 
									<c:forEach items="${product.styles}" var="style">
										<c:if test="${style.visible}">
											<input type="hidden" id="productImage_${style.id }" value="${style.imageFullPath}"/>
											<input type="hidden" id="productPrototypeImage_${style.id }" value="${style.imageFullPath}"/>
										</c:if>
									</c:forEach>
									
									<script type="text/javascript">
										function styleEvent(styleid) {
											var productImage = document.getElementById('productImage_' + styleid);
											//alert(productImage.value);
											if (productImage) {
												var main_image = document.getElementById("main_image");
												main_image.style.background = "url(" + "<%=request.getContextPath()%>" + productImage.value + ") center center no-repeat";
											}
										}
										function bigImageBrowse() {
											var form = document.forms["cart"];
											var stypeid = form.styleid.value;
											var productPrototypeImage = document.getElementById('productPrototypeImage_' + stypeid);
											if (productPrototypeImage) {
												var path = "<s:url action="productswitchshowimage" namespace="/center/product" includeParams="none"/>?path=" +productPrototypeImage.value;
												window.open(path, "显示图片");
											}
										}
									</script>
							</c:if>
						</div>
						<ul>
							<li>Maket: <s>${product.marketprice}</s>€ 
							<font color='#ff6f02'>Our: <b>${product.sellprice}€</b></font> Save 
							<font color='#ff6f02'>${product.savedPrice }</font>€
							</li>
							<li class="right_img"><input type="image" src="<%=request.getContextPath() %>/images/global/sale.gif"/></li>
							<li class="guopiprice">[ <img src="<%=request.getContextPath() %>/images/global/2j4.gif" border="0"/>&nbsp;
								<a href="http://www.babasport.com/cache/news/6/9.shtml" target="_blank">Freight Detail</a> ]&nbsp;&nbsp;&nbsp;&nbsp;[ 
									<img src="<%=request.getContextPath() %>/images/global/2j4.gif" border="0"/>&nbsp;
									<a href="http://www.babasport.com/cache/news/4/24.shtml" target="_blank">Pay Method</a> ] </li>
						</ul>
					</div>
				</div>
				<!-- 
				<div id="browse_right">
					<div id="sy_biankuang">
						<div class="sy_xinpintuijian_font">本站尚未开张</div>
						<div class="sy_dianhua" style="line-height: 150%">
							<font color="#FF0000"> 全国：010-6466 3070</font><br/>MSN在线客服：babasport@sohu.com<br/>
									<font color="#3a8FaF">QQ在线客服：523429525</font>
						</div>
					</div>
				</div>
				 -->
			</form>
			<div class='right_blank'></div>
			<div class='right_title1'>Product Description</div>
			<div class='right_content'>${product.description}</div>

		</div>
		<!-- 页面主体 右边 end -->
	</div>
	<!-- 页面主体 end -->

	<jsp:include page="/WEB-INF/page/share/Foot.jsp" />
</body>
</html>
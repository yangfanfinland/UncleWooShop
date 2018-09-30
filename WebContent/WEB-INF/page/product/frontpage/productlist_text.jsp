<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Uncle Woo China Town</title>    
<link href="<%=request.getContextPath() %>/css/global/header01.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/css/product/list.css" rel="stylesheet" type="text/css" />	
<link href="<%=request.getContextPath() %>/css/global/topsell.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="Keywords" content="${producttype.name}"/>
<meta name="description" content="${producttype.note}"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/xmlhttp.js"/>
<script type="text/javascript">
	function getTopSell(typeid){
		var salespromotion = document.getElementById('salespromotion');		
		if(salespromotion && typeid!=""){
			salespromotion.innerHTML= "Data is loading...";
			send_request(function(value){salespromotion.innerHTML=value},
					 "<s:url action="productswitch" namespace="/center/product" includeParams="none"/>?typeid="+ typeid, true);
		}
	}
	function getViewHistory(){
		var viewHistoryUI = document.getElementById('viewHistory');		
		if(viewHistoryUI){
			viewHistoryUI.innerHTML= "Data is loading...";
			send_request(function(value){viewHistoryUI.innerHTML=value},
					 "<s:url action="productviewhistory" namespace="/center/product" includeParams="none"/>?", true);
		}
	}
	function pageInit(){
		alert("yaya");
		getTopSell("${producttype.typeid}");
		alert("haha");
		getViewHistory();
		alert("wawa");
	}
</script>
</head>

<body class="ProducTypeHome2" onload="pageInit()">
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
			var viewHistoryUI = document.getElementById('viewHistory');		
			if(viewHistoryUI){
				viewHistoryUI.innerHTML= "Data is loading...";
				send_request(function(value){viewHistoryUI.innerHTML=value},
						 "<s:url action="productviewhistory" namespace="/center/product" includeParams="none"/>?", true);
			}
		}
	</script>
	
	
	<jsp:include page="/WEB-INF/page/share/Head.jsp"/>
	<c:set var="out" value=""/>
	<c:forEach items="${types}" var="type" varStatus="statu">
		<c:if test="${statu.count==1}"><c:set var="out" value=" &gt;&gt; <em>${type.name}</em> ${out}"/></c:if>
		<c:if test="${statu.count>1}"><c:set var="out" value=" &gt;&gt; <a href='UncleWooShop/center/product/list.action?typeid=${type.typeid}'>${type.name}</a> ${out}"/></c:if>
	</c:forEach>
    <div id="position">Your current position: <a href="/UncleWooShop" name="linkHome">Uncle Woo China Town:</a> 
    <c:out value="${out}" escapeXml="false"></c:out>amount:(${pageView.totalrecord})
	</div>

    <!--页面左侧分类浏览部分-->
    <div class="browse_left">
         <div class="browse">
            <div class="browse_t">${producttype.name}</div>
			
			<h2><span class="gray">View Lower Level Classify</span></h2>
			<ul>
				<c:forEach items="${producttype.childtypes}" var="childtype">						
					<li class='bj_blue'><a href='<s:url action="list" namespace="/center/product" includeParams="none"/>?typeid=${childtype.typeid}'>${childtype.name}</a></li>
				</c:forEach>		    
			</ul>
	     </div>
	<div id="sy_biankuang">
	        <div class="lanmu_font">Most popular ${producttype.name}</div>
	        <div style="PADDING-LEFT: 10px; COLOR: #333333" id="salespromotion"></div>
	</div>
		 <br/>
		 <div class="browse">
	          <div class="browse_t">Product Viewed</div>
			  <ul id="viewHistory">
			  </ul>
	     </div>
    </div>
    <!--页面右侧分类列表部分开始-->
    <div class="browse_right">
         <div class="select_reorder">
              <div class="reorder_l">Please select sort style:<c:if test="${'selldesc'==param.sort}"><strong><em>Sell ↓</em></strong></c:if><c:if test="${'selldesc'!=param.sort}">
              <a title='Sell more to less' href='<s:url action="list" namespace="/center/product" includeParams="none"/>?sort=selldesc&typeid=${param.typeid}&style=${param.style}'>Sell ↓</a></c:if>
			  | <c:if test="${'sellpricedesc'==param.sort}"><strong><em>Price ↓</em></strong></c:if><c:if test="${'sellpricedesc'!=param.sort}">
			  <a title='Price high to low' href='<s:url action="list" namespace="/center/product" includeParams="none"/>?sort=sellpricedesc&typeid=${param.typeid}&style=${param.style}'>Price ↓</a></c:if>
			  | <c:if test="${'sellpriceasc'==param.sort}"><strong><em>Price ↑</em></strong></c:if><c:if test="${'sellpriceasc'!=param.sort}">
			  <a title='Price low to high' href='<s:url action="list" namespace="/center/product" includeParams="none"/>?sort=sellpriceasc&typeid=${param.typeid}&style=${param.style}'>Price ↑</a></c:if>
			  | <c:if test="${empty param.sort}"><strong><em>Publish time</em></strong></c:if><c:if test="${!empty param.sort}">
			  <a title='Publish time' href='<s:url action="list" namespace="/center/product" includeParams="none"/>?sort=&typeid=${param.typeid}&style=${param.style}'>Publish time</a></c:if> </div>
              
		      <div class="reorder_r">Display style：
		      <c:if test="${param.style=='imagetext'}"><strong><em>Image&Text</em></strong></c:if>
		      <c:if test="${param.style!='imagetext'}">
		      	<a href='<s:url action="list" namespace="/center/product" includeParams="none"/>?sort=${param.sort}&typeid=${param.typeid}&sex=${param.sex}&brandid=${param.brandid}&style=imagetext'>Image&Text</a>
		      </c:if> |
		      <c:if test="${param.style=='imagetext'}">
		      	<a href='<s:url action="list" namespace="/center/product" includeParams="none"/>?sort=${param.sort}&typeid=${param.typeid}&sex=${param.sex}&brandid=${param.brandid}&style=image'>Image only</a>
		      </c:if>
		      <c:if test="${param.style!='imagetext'}"><strong><em>Image only</em></strong></c:if>
		      </div>
			<div class="emptybox"></div>
			 <div class="brand">
				<div class="FindByHint">According to<strong> Brand </strong>Select:</div>
				<ul class="CategoryListTableLevel1"><c:forEach items="${brands}" var="brand">
				<li><a href='<s:url action="list" namespace="/center/product" includeParams="none"/>?sort=${param.sort}&typeid=${param.typeid}&brandid=${brand.code}&sex=${param.sex}'>${brand.name}</a></li></c:forEach>
				</ul>
			 </div>
			 <div class="SubCategoryBox">
				<div class="FindByHint">According to<strong> Gender </strong>Select：</div>
				<ul class="CategoryListTableLevel1">
				<li><a  href='<s:url action="list" namespace="/center/product" includeParams="none"/>?sort=sellpriceasc&typeid=${param.typeid}&sex=MAN&brandid=${param.brandid}&style=${param.style}'>Men</a></li>
				<li><a  href='<s:url action="list" namespace="/center/product" includeParams="none"/>?sort=sellpriceasc&typeid=${param.typeid}&sex=WOMEN&brandid=${param.brandid}&style=${param.style}'>Women</a></li>
				<li><a  href='<s:url action="list" namespace="/center/product" includeParams="none"/>?sort=sellpriceasc&typeid=${param.typeid}&sex=NONE&brandid=${param.brandid}&style=${param.style}'>Both</a></li>
				<li><a class="red" href="<s:url action="list" namespace="/center/product" includeParams="none"/>?sort=sellpriceasc&typeid=${param.typeid}">All</a></li>
				</ul>
			 </div>
		</div>
	     <div id="divNaviTop" class="number">
	          <div class="number_l">Find<span class='number_white'>${pageView.totalrecord}</span>results accoring to<span class="number_white">
				<c:choose>
				  <c:when test="${'selldesc'==param.sort}">Sell ↓</c:when>
				  <c:when test="${'sellpricedesc'==param.sort}">Price ↓</c:when>
				  <c:when test="${'sellpriceasc'==param.sort}">Price ↑</c:when>
				  <c:otherwise>Publish time</c:otherwise>
				</c:choose>
			  </span>sort, display style<span class="number_white"><c:if test="${param.style=='imagetext'}">Image&Text</c:if><c:if test="${param.style!='imagetext'}">Image Only</c:if></span>　<span class="number_white">${pageView.maxresult}</span>products/page</div>
		      
		      <div class="turnpage">
                <div><em>Current : page ${pageView.currentpage}</em></div>
		      </div>
		       
	     </div>

	<div class='goods_pic'>
<!----------------------LOOP START------------------------------->	
<c:forEach items="${pageView.records}" var="entry">			
		<div class="goodslist">
          <div class="goods" style="cursor: pointer;background:url(<c:forEach items="${entry.styles}" var="img"><%=request.getContextPath() %>/${img.imageFullPath}</c:forEach>) center center no-repeat"><a href='<s:url action="productview" namespace="/center/product" includeParams="none"/>?productid=${entry.id}' target="_blank">
            <img src="<%=request.getContextPath() %>/images/global/product_blank.gif" alt="${entry.name}" width="140" height="168"  border="0"/></a></div>
          <div class="goods_right">
                <h2><a href='<s:url action="productview" namespace="/center/product" includeParams="none"/>?productid=${entry.id}' target="_blank" title="${entry.name}">${entry.name}</a></h2>
	           <div class="message"><ul>
			  <c:if test="${!empty entry.brand}"> <li>Brand: ${entry.brand.name}</li></c:if>
			   </ul></div>
	           <div class="content">&nbsp;&nbsp;&nbsp;<c:out value="${fn:substring(entry.description,0,200)}"/></div>
	           <div class="message_bottom">
	                <div class="save"><s>€${entry.marketprice}</s>　<strong><em>€${entry.sellprice}</em></strong>　Save: ${entry.savedPrice}</div>
			        <div class="buy"><a href='<s:url action="productview" namespace="/center/product" includeParams="none"/>?productid=${entry.id}'><img src='<%=request.getContextPath() %>/images/sale.gif' width='84' height='24' border='0' /></a></div>
	           </div>
          </div>
          <div class="empty_box"></div>
        </div>
</c:forEach>
<!----------------------LOOP END------------------------------->		
	    	<div id="divNaviBottom" class="page_number">
		     	<div class="turnpage turnpage_bottom">	
		     		<c:forEach begin="${pageView.pageindex.startindex}" end="${pageView.pageindex.endindex}" var="wp">
			    		<c:if test="${pageView.currentpage==wp}"><font color="red">[${wp}]</font></c:if>
			    		<c:if test="${pageView.currentpage!=wp}"><a href='<s:url action="list" namespace="/center/product" includeParams="none"/>?page=${wp}&brandid=${param.brandid}&sex=${param.sex}&sort=${param.sort}&style=${param.style}&typeid=${param.typeid}'>[${wp}]</a></c:if>
					</c:forEach>
					<div>
					</div>Jump To Page
					<select name="selectPage" class="kuang" onchange="javaScript:topage(this.value)">
						<c:forEach begin="1" end="${pageView.totalpage}" var="wp">
							<option value="${wp}" <c:if test="${pageView.currentpage==wp}">selected="selected"</c:if>>${wp} 
						</option>
						</c:forEach>
					</select> 
					<script type="text/javascript">
						function topage(pagenum){
							window.location.href='<s:url action="list" namespace="/center/product" includeParams="none"/>?sort=${param.sort}&style=${param.style}&brandid=${param.brandid}&sex=${param.sex}&typeid=${param.typeid}&page='+ pagenum;
						}
					</script>
         		</div>
	     	</div>
    	</div>
    </div>
	<jsp:include page="/WEB-INF/page/share/Foot.jsp" />
</body>
</html>
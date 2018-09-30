<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<ul>
	<c:forEach items="${topsellproducts}" var="topsellproduct" varStatus="statu">
		<li class="bx">
			${statu.count}.<a href='<s:url action="productview" namespace="/center/product" includeParams="none"/>?productid=${topsellproduct.id}' target="_blank">${topsellproduct.name}</a>
		</li>
	</c:forEach>
</ul>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<ul>
	<c:forEach items="${viewHistory}" var="viewproduct" varStatus="statu">
		<li class="bj_blue">
			<a href='<s:url action="productview" namespace="/center/product" includeParams="none"/>?productid=${viewproduct.id}' target="_blank" title="${viewproduct.name}">${viewproduct.name}</a>
		</li>
	</c:forEach>
</ul>
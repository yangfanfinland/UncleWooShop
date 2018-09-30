<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<font color="#FFFFFF"> 当前页:${pageView.currentpage} |
	总记录数:${pageView.totalrecord} | 每页显示:${pageView.maxresult}条 |
	总页数:${pageView.totalpage} </font>

<c:forEach begin="${pageView.pageindex.startindex}"
	end="${pageView.pageindex.endindex}" var="wp">


	<%-- 路径会增加，无法运行，待解决
        			<a href='<s:url action="list" />?page=${wp}'>第${wp}页</a>
        			--%>

	<%-- 此方法可以得到结果，但是url地址有问题，待解决
        			<a href='<%=request.getContentType() %>/control/center/list.action?page=${wp}'>第${wp}页</a>
        			--%>

	<%-- 无法运行，<s:url>中参数传递，不能使用el表达式
        			<a href='<s:url action='/control/center/list'>
        				<s:param name="page" value="#wp"></s:param>
        			</s:url>'>第${wp}页</a>
        			--%>

	<a href="javascript:topage('${wp}')">第${wp}页</a>

</c:forEach>
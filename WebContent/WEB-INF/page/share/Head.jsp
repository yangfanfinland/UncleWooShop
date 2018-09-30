<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<div id="Head">
  <div id="HeadTop">
    <div id="Logo"><a href='/UncleWooShop' target=_top><img alt="The best Asian shop in Waasa! " src="/images/global/logo.gif" border=0 /></a> </div>
    <div id="HeadNavBar">
      <ul>
        <li class="NoSep"><a id="MyBuyCar"  href='<s:url action="cart" namespace="/center/shopping" includeParams="none"/>' ><font color="blue"><Strong>Shopping Car</Strong></font></a> </li>
        <li><a href='<s:url action="regUI" namespace="/center/user/register" includeParams="none"/>' >Register</a> </li>
        <li><a href='<s:url action="logUI" namespace="/center/user/login" includeParams="none"/>' >Login</a> </li>
         <c:if test="${!empty user}"> 
         	<li><a href='<s:url action="logout" namespace="/user" includeParams="none"/>' >Exit</a> </li>
         </c:if>
        <li><a href="">Help</a> </li>
        <li class="phone">Tel:040-7748215</li>
      </ul>
    </div>
  </div>
  <div id="ChannelMenu">
	<ul id="ChannelMenuItems">
		<li id="MenuHome"><a href="/UncleWooShop"><span>Main Page</span></a></li>
		<li id="ProducType1Home"><a href='<s:url action="list" namespace="/center/product" includeParams="none"/>?typeid=42'><span>Rice</span></a></li>
		<li id="ProducType2Home"><a href='<s:url action="list" namespace="/center/product" includeParams="none"/>?typeid=44'><span>Meat</span></a></li>
		<li id="ProducType3Home"><a href='<s:url action="list" namespace="/center/product" includeParams="none"/>?typeid=47'><span>Source</span></a></li>
		<li id="ProducType8Home"><a href='<s:url action="list" namespace="/center/product" includeParams="none"/>?typeid=49'><span>Noodle</span></a></li>
		<li id="MyAccountHome"><a href=""><span>My Account</span></a></li>
	</ul>
	<!--  SearchBox -->
	<div id="SearchBox">
	  <div id="SearchBoxTop">
		  <div id="SearchForm">
			<s:form action="query" namespace="/center/product" method="post" name="search" id="search">

			 <span class="name">Product Search: </span><input id="word" name="word" accesskey="s" size="100" maxlength="100" value="${param.word }"/>

			  <input type="submit" value="Search" id="DoSearch"/>
			</s:form>
		  </div>
	  </div>
      <div id="HotKeywords">
			<ul>
				<li><span>
					21.07.2013&nbsp;&nbsp;Hello&nbsp;&nbsp;<font color="red" size="2"><b>${user.username}<script type="text/javascript" src="<%=request.getContextPath() %>/js/welcome.js"></SCRIPT></b></font>&nbsp;&nbsp;Welcome to Uncle Woo China Town！</span></li>
				<li>Hot Search:</li>
				
				<li><a href="">Meat</a></li>
				<li><a href="">Rice</a></li>
				<li><a href="">Source</a></li>
			</ul>
      </div>
   </div>
</div><!-- End SearchBox -->
</div>
<!-- Head End -->
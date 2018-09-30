<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<html>
<head>
<title>Menu</title>
<script type="text/javascript">
	function getTablesByStart(name){
		var inputs = document.getElementsByTagName("table");
		var files = new Array();
		var y = 0;
		for (var i=0; i<inputs.length; i++) {		
		  if (inputs[i].id !=null && inputs[i].id.length>name.length && inputs[i].id.substring(0, name.length)==name){
			 files[y] = inputs[i];
			 y++;
		  }
		}
		return files;
	}
	function HideAll(){
		var tables = getTablesByStart("menu_");
		for (var i=0; i<tables.length; i++) {
			tables[i].style.display = "none";
			var id = tables[i].id.substring("menu_".length);
			var imgId = document.getElementById("Img"+ id);
			var imgId2 = document.getElementById("Img"+ id + "_0");
			if(imgId) imgId.src="<%=request.getContextPath() %>/images/midclosedfolder.gif";
			if(imgId2) imgId2.src="<%=request.getContextPath() %>/images/clsfld.gif";
		}
	}

	function turnit(id) {
		var menu = document.getElementById("menu_"+ id);
		var imgId = document.getElementById("Img"+ id);
		var imgId2 = document.getElementById("Img"+ id + "_0");
		if (menu.style.display=="none"){
			HideAll();
			menu.style.display = "";
			if(imgId) imgId.src="<%=request.getContextPath() %>/images/midopenedfolder.gif";
			if(imgId2) imgId2.src="<%=request.getContextPath() %>/images/openfld.gif";
		}else{
			menu.style.display = "none";
			if(imgId) imgId.src="<%=request.getContextPath() %>/images/midclosedfolder.gif";
			if(imgId2) imgId2.src="<%=request.getContextPath() %>/images/clsfld.gif";
		}
}
</script>
</head>
<body>
	<!-- 订单管理start -->
	<table border=0 width="98%" align="center" cellspacing="0" cellpadding="0">
    	<tr>
        	<td colspan="3" onmouseup="turnit('order')" style="cursor:hand">
            	<img id="Imgorder" src="<%=request.getContextPath() %>/images/midclosedfolder.gif" align="absMiddle" border="0" width="16">
                <img id="Imgorder_0" src="<%=request.getContextPath() %>/images/clsfld.gif" align="absMiddle" border="0">
                <span>订单管理</span>
            </td>
        </tr>
    </table>
	<table id="menu_order" border="0" width="98%" align="center" cellspacing="0" cellpadding="0" style="display:none">
    	<tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/vertline.gif" border=0>
                <img src="<%=request.getContextPath() %>/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22">
                <img src="<%=request.getContextPath() %>/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16">
            </td>
        	<td>
        		<a href="<s:url action='query' namespace='/control/order' />" target="right">订单查询</a>
            </td>
        </tr>
        <tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/vertline.gif" border=0>
                <img src="<%=request.getContextPath() %>/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22">
                <img src="<%=request.getContextPath() %>/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16">
            </td>
        	<td>
            	<a href="<s:url action='list' namespace='/control/order' />" target="right">待审核订单</a>
        	</td>
        </tr>
        <tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/vertline.gif" border=0>
                <img src="<%=request.getContextPath() %>/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22">
                <img src="<%=request.getContextPath() %>/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16">
            </td>
        	<td>
        		<a href="<s:url action='list' namespace='/control/order' />?state=WAITPAYMENT&query=true" target="right">等待付款订单</a>
        	</td>
        </tr>
        <tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/vertline.gif" border=0>
                <img src="<%=request.getContextPath() %>/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22">
                <img src="<%=request.getContextPath() %>/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16">
            </td>
        	<td>
        		<a href="<s:url action='list' namespace='/control/order' />?state=ADMEASUREPRODUCT&query=true" target="right">正在配货订单</a>
        	</td>
        </tr>
        <tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/vertline.gif" border=0>
                <img src="<%=request.getContextPath() %>/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22">
                <img src="<%=request.getContextPath() %>/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16">
            </td>
        	<td>
        		<a href="<s:url action='list' namespace='/control/order' />?state=WAITDELIVER&query=true" target="right">等待发货订单</a>
        	</td>
        </tr>
        <tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/vertline.gif" border=0>
                <img src="<%=request.getContextPath() %>/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22">
                <img src="<%=request.getContextPath() %>/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16">
            </td>
        	<td>
        		<a href="<s:url action='list' namespace='/control/order' />?state=DELIVERED&query=true" target="right">已发货订单</a>
        	</td>
        </tr>
        <tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/vertline.gif" border=0>
                <img src="<%=request.getContextPath() %>/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22">
                <img src="<%=request.getContextPath() %>/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16">
            </td>
        	<td>
        		<a href="<s:url action='list' namespace='/control/order' />?state=RECEIVED&query=true" target="right">已收货订单</a>
        	</td>
        </tr>
        <tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/vertline.gif" border=0>
                <img src="<%=request.getContextPath() %>/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22">
                <img src="<%=request.getContextPath() %>/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16">
            </td>
        	<td>
        		<a href="<s:url action='list' namespace='/control/order' />?state=CANCEL&query=true" target="right">已取消订单</a>
        	</td>
        </tr>
        <tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/vertline.gif" border=0>
                <img src="<%=request.getContextPath() %>/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22">
                <img src="<%=request.getContextPath() %>/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16">
            </td>
        	<td>
        		<a href="<s:url action='lockorderlist' namespace='/control/order' />" target="right">已锁定订单</a>
        	</td>
        </tr>
    </table>
    <!-- 订单管理end -->
    <!-- 产品管理start -->
    <table border="0" width="98%" align="center" cellspacing="0" cellpadding="0">
    	<tr> 
            <td colspan="3" onMouseUp="turnit('Product')" style="CURSOR: hand"> 
              <img id="ImgProduct" src="<%=request.getContextPath() %>/images/midclosedfolder.gif" align="absMiddle" border="0" width="16">
              <img id="ImgProduct_0" src="<%=request.getContextPath() %>/images/clsfld.gif" align="absMiddle" border="0"> 
                <span>产品管理</span>
            </td>
  		</tr>
    </table>
    <table id="menu_Product" border="0" width="98%" align="center" cellspacing="0" cellpadding="0" style="display:none">
    	<tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/vertline.gif" border=0>
                <img src="<%=request.getContextPath() %>/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22">
                <img src="<%=request.getContextPath() %>/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16">
            </td>
        	<td>
        		<a href="<s:url action='list' namespace='/control/product/type' />" target="right">产品类别管理</a>
            </td>
        </tr>
        <tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/vertline.gif" border=0>
                <img src="<%=request.getContextPath() %>/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22">
                <img src="<%=request.getContextPath() %>/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16">
            </td>
        	<td>
            	<a href="<s:url action='list' namespace='/control/product/brand' />" target="right">产品品牌管理</a>
        	</td>
        </tr>
       	<tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/vertline.gif" border=0>
                <img src="<%=request.getContextPath() %>/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22">
                <img src="<%=request.getContextPath() %>/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16">
            </td>
        	<td>
            	<a href="<s:url action='list' namespace='/control/product' />" target="right">产品管理</a>
        	</td>
        </tr>
    </table>
    <!-- 产品管理end -->
    <!-- 文件管理start -->
    <table border="0" width="98%" align="center" cellspacing="0" cellpadding="0">
    	<tr> 
            <td colspan="3" onMouseUp="turnit('file')" style="CURSOR: hand"> 
              <img id="Imgfile" src="<%=request.getContextPath() %>/images/midclosedfolder.gif" align="absMiddle" border="0" width="16">
              <img id="Imgfile_0" src="<%=request.getContextPath() %>/images/clsfld.gif" align="absMiddle" border="0"> 
                <span>文件管理</span>
            </td>
  		</tr>
    </table>
    <table id="menu_file" border="0" width="98%" align="center" cellspacing="0" cellpadding="0" style="display:none">
    	<tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/vertline.gif" border=0>
                <img src="<%=request.getContextPath() %>/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22">
                <img src="<%=request.getContextPath() %>/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16">
            </td>
        	<td>
        		<a href="<s:url action='uploadpage' namespace='/control/uploadfile' />" target="right">上传文件</a>
            </td>
        </tr>
    	<tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/vertline.gif" border=0>
                <img src="<%=request.getContextPath() %>/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22">
                <img src="<%=request.getContextPath() %>/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16">
            </td>
        	<td>
        		<a href="<s:url action='list' namespace='/control/uploadfile' />" target="right">上传文件管理</a>
            </td>
        </tr>
    </table>
    <!-- 文件管理end -->
    <!-- 网站用户管理start -->
    <table border="0" width="98%" align="center" cellspacing="0" cellpadding="0">
    	<tr> 
            <td colspan="3" onMouseUp="turnit('user')" style="CURSOR: hand"> 
              <img id="Imguser" src="<%=request.getContextPath() %>/images/midclosedfolder.gif" align="absMiddle" border="0" width="16">
              <img id="Imguser_0" src="<%=request.getContextPath() %>/images/clsfld.gif" align="absMiddle" border="0"> 
                <span>用户管理</span>
            </td>
  		</tr>
    </table>
    <table id="menu_user" border="0" width="98%" align="center" cellspacing="0" cellpadding="0" style="display:none">
    	<tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/vertline.gif" border=0>
                <img src="<%=request.getContextPath() %>/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22">
                <img src="<%=request.getContextPath() %>/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16">
            </td>
        	<td>
        		<a href="<s:url action='list' namespace='/control/user' />" target="right">网站用户管理</a>
            </td>
        </tr>
        <tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/vertline.gif" border=0>
                <img src="<%=request.getContextPath() %>/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22">
                <img src="<%=request.getContextPath() %>/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16">
            </td>
        	<td>
        		<a href="<s:url action='user_queryUI' namespace='/control/user' />" target="right">用户查询</a>
            </td>
        </tr>
    </table>
    <!-- 网站用户管理end -->
    <!-- 部门员工管理start -->
    <table border="0" width="98%" align="center" cellspacing="0" cellpadding="0">
    	<tr> 
            <td colspan="3" onMouseUp="turnit('department')" style="CURSOR: hand"> 
              <img id="Imgdepartment" src="<%=request.getContextPath() %>/images/midclosedfolder.gif" align="absMiddle" border="0" width="16">
              <img id="Imgdepartment_0" src="<%=request.getContextPath() %>/images/clsfld.gif" align="absMiddle" border="0"> 
                <span>部门员工管理</span>
            </td>
  		</tr>
    </table>
    <table id="menu_department" border="0" width="98%" align="center" cellspacing="0" cellpadding="0" style="display:none">
    	<tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/vertline.gif" border=0>
                <img src="<%=request.getContextPath() %>/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22">
                <img src="<%=request.getContextPath() %>/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16">
            </td>
        	<td>
        		<a href="<s:url action='list' namespace='/control/department' />" target="right">部门管理</a>
            </td>
        </tr>
        <tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/vertline.gif" border=0>
                <img src="<%=request.getContextPath() %>/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22">
                <img src="<%=request.getContextPath() %>/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16">
            </td>
        	<td>
        		<a href="<s:url action='list' namespace='/control/employee' />" target="right">员工管理</a>
            </td>
        </tr>
        <tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/vertline.gif" border=0>
                <img src="<%=request.getContextPath() %>/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22">
                <img src="<%=request.getContextPath() %>/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16">
            </td>
        	<td>
        		<a href="<s:url action='query' namespace='/control/employee' />" target="right">员工查询</a>
            </td>
        </tr>
        <tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/vertline.gif" border=0>
                <img src="<%=request.getContextPath() %>/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22">
                <img src="<%=request.getContextPath() %>/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16">
            </td>
        	<td>
        		<a href="<s:url action='list' namespace='/control/privilegegroup' />" target="right">权限组管理</a>
            </td>
        </tr>
    </table>
    <!-- 部门员工管理end -->
    <table border="0" width="98%" align="center" cellspacing="0" cellpadding="0">
    	<tr>
        	<td>
            	<img src="<%=request.getContextPath() %>/images/lastnodeline.gif" border="0">
            </td>
            <td>
            	<a href="<s:url action='logout' namespace='/employee' />" target="_parent">退出系统</a>
            </td>
        <tr/> 
    </table>
<body>
</body>
</html>
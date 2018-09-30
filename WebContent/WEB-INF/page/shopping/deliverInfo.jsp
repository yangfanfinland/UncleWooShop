<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd html 4.0 transitional//EN">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="Wed, 26 Feb 2006 08:21:57 GMT">
<meta http-equiv="Content-TYPE" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath() %>/css/global/address.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/global/bottom.css" rel="stylesheet" type="text/css">
<title>巴巴运动网：结算中心：填写收货地址</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/Country.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/provinceArea.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/FoshanRen.js"></script>
<script type="text/javascript">
<!--
	/*
	 * 功能：取单选框的值
	 */
	function getradiovalue(objradio) {
		var result = "";
		try {
			if (typeof (objradio.value) == "undefined") {
				for ( var i = 0; i < objradio.length; i++) {
					if (objradio[i].checked) {
						return objradio[i].value;
					}
				}
			} else {
				if (objradio.checked)
					result = objradio.value;
			}
		} catch (e) {
			result = "";
		}
		return result;
	}

	function buyerinfoSelect(issame) {
		if ("true" == issame) {
			document.getElementById('buyerinfoinput').style.display = "none";
		} else {
			document.getElementById('buyerinfoinput').style.display = "";
		}
	}
	//email验证
	function isValidEmail(inEmail) {
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		return filter.test(inEmail);
	}
	/**
	 * FormField类,描述表单字段,第一个参数为字段的name属性值,第二个参数为字段的中文名
	 */
	function FormField(fieldName, fieldLabel) {
		this.fieldName = fieldName;
		this.fieldLabel = fieldLabel;
	}
	//验证表单数据
	function validateFormData() {
		var form = document.forms[0];
		var fields = new Array(new FormField("recipients", "收货人姓名"), new FormField("address", "收货人地址"), new FormField("email", "电子邮件"), new FormField("postalcode", "邮政编码"));
		for ( var i = 0; i < fields.length; i++) {
			var field = eval("form." + fields[i].fieldName);
			if (field.value.trim() == "") {
				alert(fields[i].fieldLabel + " 不能为空");
				return false;
			}
		}
		if (getradiovalue(form.gender) == "") {
			alert("请选择收货人的性别");
			return false;
		}
		if (!isValidEmail(form.email.value)) {
			alert("收货人的email格式不正确");
			return false;
		}
		if (!/^\d{6}$/.test(form.postalcode.value.trim())) {
			alert("收货人的邮政编码必须是6位数字");
			return false;
		}
		if (form.mobile.value.trim() != "") {
			if (!/^1[35]\d{9}$/.test(form.mobile.value.trim())) {
				alert("收货人的手机号格式不正确");
				return false;
			}
		}
		if (getradiovalue(form.buyerIsrecipients) == "") {
			alert("请选择购买人与收货人是否相等");
			return false;
		}
		//form.tel.value = "";
		//if (form.maintel.value.trim() != "") {
			//if (/^\d{7,8}$/.test(form.maintel.value.trim())) {
				//form.tel.value = form.forepart.value + "-" + form.maintel.value;
				//if (form.extension.value.trim() != "")
					//form.tel.value += "-" + form.extension.value;
			//} else {
				//alert("收货人的电话号码至少7位");
				//return false;
			//}
		//}

		//if (form.tel.value == "" && form.mobile.value.trim() == "") {
			//alert("收货人的手机和电话至少有一项必填");
			//return false;
		//}

		if (getradiovalue(form.buyerIsrecipients) == "false") {
			var buyerfields = new Array(new FormField("buyer", "购买者的姓名"),
					new FormField("buyer_address", "购买者的地址"), new FormField(
							"buyer_postalcode", "购买者的邮政编码"));
			for ( var i = 0; i < buyerfields.length; i++) {
				var buyerfield = eval("form." + buyerfields[i].fieldName);
				if (buyerfield.value.trim() == "") {
					alert(buyerfields[i].fieldLabel + " 不能为空");
					return false;
				}
			}
			if (getradiovalue(form.buyer_gender) == "") {
				alert("请选择购买者的性别");
				return false;
			}
			//form.buyer_tel.value = "";
			//if (/^\d{7,8}$/.test(form.buyer_maintel.value.trim())) {
				//form.buyer_tel.value = form.buyer_forepart.value + "-"
					//	+ form.buyer_maintel.value;
				//if (form.buyer_extension.value.trim() != "")
					//form.buyer_tel.value += "-" + form.buyer_extension.value;
			//}
			//if (form.buyer_tel.value == ""
				//	&& form.buyer_mobile.value.trim() == "") {
				//alert("购买者的手机和电话至少有一项必填");
				//return false;
			//}
			if(form.buyer_mobile.value.trim() == ""){
				alert("购买者手机不能为空");
				return false;
			}
		}
		return true;
	}
	function sendForm() {
		var form = document.forms[0];
		if (validateFormData())
			form.submit();
	}

	function pageinit() {
		//alert("haha");
		//initPhone();
		showBuyInfo();
		//alert("wawa");
	}

	function showBuyInfo() {
		var form = document.forms[0];
		if (getradiovalue(form.buyerIsrecipients) == "false")
			document.getElementById('buyerinfoinput').style.display = "";
	}

	//function initPhone() {
		//var form = document.forms[0];
		//var phone = form.tel.value;
		//if (phone != "") {
			//var tels = phone.split("-");
			//if (tels.length >= 2) {
				//form.forepart.value = tels[0];
				//form.maintel.value = tels[1];
				//if (tels.length == 3)
					//form.extension.value = tels[2];
			//}
		//}
		//var buyerphone = form.buyer_tel.value;
		//if (buyerphone != "") {
			//var tels = buyerphone.split("-");
			//if (tels.length >= 2) {
				//form.buyer_forepart.value = tels[0];
				//form.buyer_maintel.value = tels[1];
				//if (tels.length == 3)
					//form.buyer_extension.value = tels[2];
			//}
		//}
	//}
//-->
</script>

<meta content="MShtml 6.00.2900.2769" name="GENERATOR">
</head>
<body onload="pageinit()">
	<s:form action="manage" namespace="/customer/shopping" method="post">
		<input type="hidden" name="directUrl" value="${param.directUrl }" />
		<table cellSpacing=0 cellPadding=0 align="center" border=0>
			<tbody>
				<tr>
					<td>
					<img src="<%=request.getContextPath() %>/images/global/logo.gif"> &nbsp;&nbsp;
					<img height=36 src="<%=request.getContextPath() %>/images/buy/az-s-checkout-shipping-bann.gif">
					</td>
				</tr>
			</tbody>
		</table>
		<br/>

		<table cellSpacing=0 cellPadding=0 width="90%" align=center border=0>
			<tbody>
				<tr>
					<td>
						<table cellSpacing=1 cellPadding=1 width="100%" bgColor=#eeeecc border=0>
							<tbody>
								<tr>
									<td bgColor="#ffffff">
										<table cellSpacing=0 cellPadding=4 width="100%" border=0>
											<tbody>
												<tr bgColor="#eeeecc">
													<td>
														<strong><span class=h1><strong>请输入配送地址</strong>:</span></strong>
													</td>
													<td bgColor="#eeeecc">&nbsp;</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
							</tbody>
						</table>
						<div id="cndivaddress">
							<table cellSpacing=1 cellPadding=4 width="100%" border=0>
								<tbody>
									<tr>
										<td colSpan=2>&nbsp;</td>
									</tr>
									<tr>
										<td width=214>
											<div align="right">
												收货人姓名<span id="NameLable"></span>：
											</div>
										</td>
										<td>	 
											<input type="text" name="recipients" maxlength="8" size="30" /><font color="#ff0000">*</font>&nbsp;
											<input type="radio" name="gender" value="MAN" />先生
											<input type="radio" name="gender" value="WOMEN" />女士
										</td>
										
									</tr>
									<tr>
										<td height="27">
											<div align="right">
												收货人地址<span id="AddressLable"></span>：
											</div>
										</td>
										<td>
											<input type="text" name="address" maxlength="100" size="60" />
											<font color="#ff0000">*</font>
										</td>
									</tr>
									<tr>
										<td height="27">
											<div align="right">
											<!-- 
												电子邮件<span id="EmailLable"></span>：
											 -->
											 <s:text name="电子邮件"/>
											</div>
										</td>
										<td>
											
											<input type="text" name="email" maxlength="45" size="30" />
											 
											 <!-- 
											<s:textfield name="email" maxlength="45" size="30" />
											 -->
											<font color="#ff0000">*</font>
										</td>
									</tr>
									
									<tr>
										<td height="27">
											<div align="right">
												邮政编码<span id="PostalcodeLable"></span>：
											</div>
										</td>
										<td>
											<input type="text" name="postalcode" maxlength="6" size="20" />
											<font color="#ff0000">*</font>
											<font color="#484848">请正确填写邮政编码，以免延误您的订单送达时间。不知道邮编？
												<a href="http://www.cpdc.com.cn/webmodules/postcode/CPDC_03G01.aspx" target="_blank">请进这里查询</a>
											</font>
										</td>
									</tr>
									
									
									
									<!-- 
									<tr>
										<td>
											<input type="hidden" name="tel" />
											<div align=right>
												电话<span id="TelLable"></span>：
											</div>
										</td>
										<td>
											<table width="30%" border="0" cellpadding="0" cellspacing="2">
												<tr>
													<td>
														<input value="010" size="4" name="forepart" maxlength="4" onkeypress="javascript:inputIntNumberCheck()">
													</td>
													<td>
														<input name="maintel" size="8" maxlength="8" onkeypress="javascript:inputIntNumberCheck()">
													</td>
													<td>
														<input name="extension" size="4" maxlength="4" onkeypress="javascript:inputIntNumberCheck()">
													</td>
												</tr>
												<tr>
													<td>
														<span class="STYLE1">区号</span>
													</td>
													<td>
														<span class="STYLE1">电话号码</span>
													</td>
													<td>
														<span class="STYLE1">分机</span>
													</td>
												</tr>
											</table>
										</td>
									</tr>
									 -->
									
									
									
									
									
									
									
									<tr>
										<td>
											<div align=right>
												电话<span id="MobileLable"></span>：
											</div>
										</td>
										<td>
											<input type="text" name="mobile" maxlength="15" size="20" />
										</td>
									</tr>
									<tr>
										<td>
											<div align="right">
												购买人与收货人是否相同<font color="#ff0000">*</font>：
											</div>
										</td>
										<td>
											<input type="radio" name="buyerIsrecipients" value="true" onclick="javascript:buyerinfoSelect(this.value)"/>
											<b>相同</b> 
											<input type="radio" name="buyerIsrecipients" value="false" onclick="javascript:buyerinfoSelect(this.value)" />
											<b>不相同</b>
										</td>
									</tr>
									<!---------------------------->
									<tr id="buyerinfoinput" style="display: none">
										<td></td>
										<td nowrap>
											<div class="OkMsg">
												<table cellSpacing="0" cellPadding="0" width="100%" border="0">
													<tr>
														<td align="right" height="25">
															<font color="#f47a22">*</font>
															购买者姓名：
														</td>
														<td align="left">
															<input type="text" name="buyer" maxlength="8" size="30" /> &nbsp;
															<input type="radio" name="buyer_gender" value="MAN" />先生 
															<input type="radio" name="buyer_gender" value="WOMEN" />女士
														</td>
													</tr>
													<tr>
														<td align="right" height="25">
															<font color="#f47a22">*</font>
															详细地址：
														</td>
														<td align="left">
															<input type="text" name="buyer_address" maxlength="100" size="60" />
														</td>
													</tr>
													<tr>
														<td align="right" height="25">
															<font color="#f47a22">*</font>
															邮政编码：</td>
														<td>
															<table cellSpacing="0" cellPadding="0" border="0">
																<tr>
																	<td align="left" height="20">
																		<input type="text" name="buyer_postalcode" maxlength="6" size="20" />
																	</td>
																	<td align="left">&nbsp;&nbsp;
																		<font color="#484848">请正确填写邮政编码，以免延误您的订单送达时间。</font>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
													
													
													
													
													
													<tr>
														<td align="right" height="25"><font color="#f47a22">*</font>
															电话：</td>
														<td>
															<table cellSpacing="0" cellPadding="0" border="0">
																<tr>
																	<td align="left" colSpan="3">
																		<input type="text" name="buyer_mobile" maxlength="15" size="20" />
																	</td>
																	<!-- 
																	<td height="25">&nbsp;移动电话</td>
																	 -->
																</tr>
																<!--
																<tr>
																	<s:hidden name="buyer_tel" />
																	<td>
																		<input value="010" size="4" name="buyer_forepart" maxlength="4" onkeypress="javascript:inputIntNumberCheck()">
																	</td>
																	<td>
																		<input name="buyer_maintel" size="8" maxlength="8" onkeypress="javascript:inputIntNumberCheck()">
																	</td>
																	<td>
																		<input name="buyer_extension" size="4" maxlength="4" onkeypress="javascript:inputIntNumberCheck()">
																	</td>
																	<td height="25">&nbsp;固定电话</td>
																</tr>
																<tr>
																	<td align="center">
																		<font color="#484848">区号</font>
																	</td>
																	<td align="center">
																		<font color="#484848">电话</font>
																	</td>
																	<td align="center">
																		<font color="#484848">分机</font>
																	</td>
																	<td>&nbsp;</td>
																</tr>
																-->
															</table>
														</td>
													</tr>
													 
													 
													 
													<tr>
														<td height="20">&nbsp;</td>
														<td align="left">
															<font color="#484848">（请留下您的联系电话，必要时，我们会通过电话向您确认相关信息。）</font>
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>
									<!---------------------------->

									<tr>
										<td colSpan=2 align="center">
											<img onClick="javascript:sendForm()" src="<%=request.getContextPath() %>/images/buy/az-sfl-shipping-to-this-boo.gif" vspace=5 border=0 style="cursor: pointer;">
										</td>
									</tr>

								</tbody>
							</table>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</s:form>

	<jsp:include page="/WEB-INF/page/share/Foot.jsp" />
</body>
</html>
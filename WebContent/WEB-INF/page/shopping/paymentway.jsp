<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<!DOCTYPE html PUbLIC "-//W3C//Dtd html 4.0 transitional//EN">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="Wed, 26 Feb 2006 08:21:57 GMT">
<meta http-equiv="Content-TYPE" content="text/html; charset=UTF-8">
<title>结算中心：选择支付方式 巴巴运动网</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/FoshanRen.js"></script>
<link href="<%=request.getContextPath() %>/css/global/paymentway.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function sendForm(){
		var form = document.forms[0];
			form.submit();
	}
</script>
</head>

<body onload="pageinit()">
	<table cellSpacing=0 cellPadding=0 align=center border=0>
		<tbody>
			<tr>
				<td>
					<img src="<%=request.getContextPath() %>/images/global/logo.gif"> &nbsp;&nbsp;
					<img height=36 src="<%=request.getContextPath() %>/images/buy/az-s-checkout-payment-banne.gif">
				</td>
			</tr>
		</tbody>
	</table>
	<br/>
	<s:form action="savepaymentway" namespace="/customer/shopping" method="post">
		<input type="hidden" name="method" value="savePaymentway">
		<table cellSpacing=0 cellPadding=0 width="90%" align="center" border=0>
			<tbody>
				<tr>
					<td><span class=h1><strong>请选择您的支付方式:</strong></span>
						<table height=31 cellSpacing=0 cellPadding=0 width="100%" border=0>
							<tbody>
								<tr>
									<td>
										<div align=right>
											<img onClick="javascript:sendForm()" height="22" src="<%=request.getContextPath() %>/images/buy/az-sfl-shipping-to-this-boo.gif" vspace=5 border=0 style="cursor: pointer;">
										</div>
									</td>
								</tr>
							</tbody>
						</table> 
						<!-- 
						<a name="deliverway"></a>
						<table cellSpacing=1 cellPadding=1 width="100%" bgColor="#eeeecc" border=0>
							<tbody>
								<tr>
									<td bgColor="#ffffff">
										<table cellSpacing=0 cellPadding=4 width="100%" border=0>
											<tbody>
												<tr bgColor="#eeeecc">
													<td colspan=2><strong>&nbsp;送货方式</strong></td>
												</tr>
												<tr>
													<td class="big14" vAlign="middle" align="right" width="10%">
														<input type="radio" name="deliverway" value="GENERALPOST" onclick="javascript:paymentwaySelect(this.value)" />
													</td>
													<td vAlign="middle">
														<b>平邮</b>(费用:0.0元)&nbsp;&nbsp;不支持货到付款，注:费用最低，需要到附近邮局自提，时间稍长
													</td>
												</tr>
												<tr>
													<td class="big14" vAlign="middle" align="right" width="10%">
														<input type="radio" name="deliverway" value="EXPRESSDELIVERY" onclick="javascript:paymentwaySelect(this.value)" />
													</td>
													<td vAlign="middle">
														<b>快递送货上门 </b>(费用:0.0元)&nbsp;&nbsp;支持货到付款&nbsp;&nbsp;注:200个城市可以到达，部分城市不能到达
													</td>
												</tr>
												<tr>
													<td class="big14" vAlign="middle" align="right" width="10%">
														<input type="radio" name="deliverway" value="EXIGENCEEXPRESSDELIVERY" onclick="javascript:paymentwaySelect(this.value)" />
													</td>
													<td vAlign="middle">
														<b>加急快递送货上门</b>(费用:0.0元)&nbsp;&nbsp;支持货到付款&nbsp;&nbsp;注:200个城市可以到达，部分城市不能到达
													</td>
												</tr>
												<tr>
													<td class="big14" vAlign="middle" align="right" width="10%">
														<input type="radio" name="deliverway" value="EMS" onclick="javascript:paymentwaySelect(this.value)" />
													</td>
													<td vAlign="middle">
														<b>国内特快专递EMS</b> (费用:0.0 元)&nbsp;&nbsp;不支持货到付款&nbsp;&nbsp;注:适合其他快运无法到达的城市，时间3-5个工作日
													</td>
												</tr>
												<tr>
													<td colspan="2" vAlign="middle" class="big14">
														<table cellSpacing=0 cellPadding=3 width="86%" align="center" id="timerequirement" border=0 style="display: none">
															<tbody>
																<tr>
																	<td align=left colspan=2 style="font-WEIGHT: bold; PADDING-bOTTOM: 2px; PADDING-TOP: 2px; bORDER-bOTTOM: #000000 1px solid">时间要求(注:如对送货时间有特别要求请注明)</td>
																</tr>
																<tr>
																	<td align=right>
																		<input type="radio" name="requirement" value="工作日、双休日与假日均可送货" />
																	</td>
																	<td align=left width="96%">工作日、双休日与假日均可送货</td>
																</tr>
																<tr class=category-row-shaded>
																	<td align=right>
																		<input type="radio" name="requirement" value="只双休日、假日送货" />
																	</td>
																	<td align=left>只双休日、假日送货(工作日不用送)</td>
																</tr>
																<tr>
																	<td align=right>
																		<input type="radio" name="requirement" value="只工作日送货(双休日、假日不用送)" />
																	</td>
																	<td align=left>只工作日送货(双休日、假日不用送) (注：写字楼/商用地址客户请选择)</td>
																</tr>
																<tr class=category-row-shaded>
																	<td align=right>
																		<input type="radio" name="requirement" value="学校地址/地址白天没人，请尽量安排其他时间送货" />
																	</td>
																	<td align=left>学校地址/地址白天没人，请尽量安排其他时间送货
																		(注：特别安排可能会超出预计送货天数)
																	</td>
																</tr>
																<tr>
																	<td align=right>
																		<input type="radio" name="requirement" value="other">
																	</td>
																	<td align=left>
																		<P>
																			特殊说明：
																			<input type="text" name="delivernote" maxlength="100" size="40" onfocus="javascript:setSelectradiobyValue(this.form.requirement,'other')" />
																		</P>
																	</td>
																</tr>
															</tbody>
														</table>
													</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
							</tbody>
						</table> <br/>
					 -->
					<a name="paymentway"></a>
						<table cellSpacing=1 cellPadding=1 width="100%" bgColor=#eeeecc border=0>
							<tbody>
								<tr>
									<td bgColor=#ffffff>
										<table cellSpacing=0 cellPadding=4 width="100%" border=0>
											<tbody>
												<tr bgColor=#eeeecc>
													<td colspan=2><strong>&nbsp;Your reservation guarantee</strong></td>
												</tr>
												<tr>
													<td class="big14" vAlign="middle" align="right" width="20%">
														<b>Credit Cards</b>
													</td>
													<td vAlign="middle">
														<select name="paymentway">
															<option value="" selected="selected">-Please Select-</option>
															<option value="American Express">American Express</option>
															<option value="Visa">Visa</option>
															<option value="MasterCard">MasterCard</option>
															<option value="Diners Club">Diners Club</option>
														</select>
													</td>
												</tr>
												<tr id="paymentway_COD">
													<td class="big14" vAlign="middle" align="right" width="20%">
														<b>Credit card number</b>
													</td>
													<td vAlign="middle">
														<input type="text" name="creditnumber"/>
													</td>
												</tr>
												<tr>
													<td class="big14" vAlign="middle" align="right" width="20%">
														<b>Credit card owner's name</b>
													</td>
													<td vAlign="middle">
														<input type="text" name="creditownername"/>
													</td>
												</tr>
												<tr>
													<td class="big14" vAlign="middle" align="right" width="20%">
														<b>Date of expiry</b>
													</td>
													<td vAlign="middle">
														<select name="expirymonth">
															<option value="01" selected="selected">01</option>
															<option value="02">02</option>
															<option value="03">03</option>
															<option value="04">04</option>
															<option value="05">05</option>
															<option value="06">06</option>
															<option value="07">07</option>
															<option value="08">08</option>
															<option value="09">09</option>
															<option value="10">10</option>
															<option value="11">11</option>
															<option value="12">12</option>																						
														</select>
														<b>/</b>
														<select name="expiryyear">
															<option value="2013" selected="selected">2013</option>
															<option value="2014">2014</option>
															<option value="2015">2015</option>
															<option value="2016">2016</option>
															<option value="2017">2017</option>
															<option value="2018">2018</option>
															<option value="2019">2019</option>
															<option value="2020">2020</option>
															<option value="2021">2021</option>
															<option value="2022">2022</option>
															<option value="2023">2023</option>																			
														</select>
													</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
		<br/>
		<table height=31 cellSpacing=0 cellPadding=0 width="90%" border=0 align="center">
			<tbody>
				<tr>
					<td>
						<div align=right>
							<img onClick="javascript:sendForm()" height="22" src="<%=request.getContextPath() %>/images/buy/az-sfl-shipping-to-this-boo.gif" vspace=5 border=0 style="cursor: pointer;">
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</s:form>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd html 4.0 transitional//EN">
<html><head><title>巴巴运动网：结算中心：订单确认</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="Wed, 26 Feb 2006 08:21:57 GMT">
<meta http-equiv="Content-TYPE" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath() %>/css/global/orderconfirm.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/FoshanRen.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<table cellSpacing=0 cellPadding=0 align=center border=0>
  <tbody>
  <tr>
    <td>
    	<img src="<%=request.getContextPath() %>/images/global/logo.gif" >&nbsp;&nbsp;
    	<img height=36 src="<%=request.getContextPath() %>/images/buy/az-s-checkout-confirm-banne.gif" >
  	</td>
  </tr>
  </tbody>
</table>
<br/>

<s:form action="manage_finish" namespace="/customer/shopping" method="post">
<table cellSpacing=0 cellPadding=0 width="90%" align=center border=0>
  <tbody>
  <tr>
    <td>
      <table cellSpacing=0 cellPadding=4 width="100%" border=0>
        <tbody>
        <tr>
          <td>
            <div align=left>
            	<span class=h1><strong>请查看您的订单,点击“订单确认”后提交订单</strong></span><br/><br/>
            	<table cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
              		<tbody>
              			<tr>
                			<td valign=top width=7 bgColor=#3163ce height=30>
                				<img height=17 src="<%=request.getContextPath() %>/images/buy/az-s-top-left-blue-corner.gif" width=17>
                			</td>
                			<td bgColor=#3163ce align=top>
                  				<div align=center>
                  					<img height=21 src="<%=request.getContextPath() %>/images/buy/az-s-click-place-your-order.gif" width=420>
                  			    </div>
                  			</td>
                			<td bgColor=#3163ce align=right>
                  				<div id=layer_finish1>
                  					<input onClick="return validateForm()" type="image" height=37 alt=订单确认 width=116 src="<%=request.getContextPath() %>/images/buy/az-s-place-order_01.gif" border=0>
                  				</div>
                  			</td>
                			<td valign=top width=7 bgColor=#3163ce>
                				<img height=17 src="<%=request.getContextPath() %>/images/buy/az-s-top-right-blue-corner.gif"  width=17>
                			</td>
                		</tr>
                	</tbody>
                </table>
            	<table cellSpacing=17 cellPadding=0 width="100%" align=center bgColor=#F4F4EC border=0>
              		<tbody>
              			<tr>
                			<td valign=top>
                  				<table cellSpacing=0 cellPadding=0 width="100%" border=0>
                    				<tbody>
                    					<tr>
                      						<td width=6>
                      							<img height=20 src="<%=request.getContextPath() %>/images/buy/az-s-spc-tl-inside-drksnd.gif" width=6>
                      						</td>
                      						<td bgColor=#bbbb9e>
                        						<div class=font14 align=center>
                        							<strong>配送详情</strong>
                        						</div>
                        					</td>
                      						<td width=6>
                      							<img height=20 src="<%=request.getContextPath() %>/images/buy/az-s-spc-tr-inside-drksnd.gif" width=6>
                      						</td>
                      					</tr>
                      				</tbody>
                      			</table>
                  				<table cellSpacing=0 cellPadding=3 width="100%" border=0>
                    				<tbody>
                      					<tr>
                      					
                        					<td width=184 bgColor=#eeeeee>&nbsp;
                        						<strong>商品信息：</strong>
                        						<a href='<s:url action="cart" namespace="/center/shopping" includeParams="none"/>?directUrl=${directUrl}'>
                        							<img height=17 src="<%=request.getContextPath() %>/images/buy/az-s-change.gif" width=45 border=0>
                        						</a>
                        					</td>
                        					<td width="408" bgColor=#eeeeee></td>
                      					</tr>
                    				</tbody>
                  				</table>
                  				<table cellSpacing=0 cellPadding=4 width="100%" bgColor=#ffffff border=0>
                    				<tbody>
                      					<tr>
                        					<td>
                        						<table width="96%" border="0" align="right" cellpadding="5" cellspacing="0">
                          							<tr>
                            							<td height="1" colspan="3" bgcolor="#3163CE"></td>
                          							</tr>
													<!-- loop begin -->
													<c:forEach items="${buyCart.items}" var="item">
													      <tr>
													        <td width="68%" height="33">
															<strong><a href="" target="_blank">${item.product.name }</a></strong><span class="h3color">[颜色/样式：<c:forEach items="${item.product.styles}" var="style">${style.name}</c:forEach>]</span> </td>
													        <td width="11%" align="center">数量：${item.amount }</td>
													        <td width="21%">单价：€<span class="Price">${item.product.sellprice }</span></td>
													      </tr>
													</c:forEach>
													<!-- loop end -->
                          						    <tr>
                            							<td height="1" colspan="3" bgcolor="#CCCCCC"></td>
                          							</tr>
                          							<tr>
                            							<td colspan="3" align="right">商品总价：€${buyCart.totalPrice }&nbsp; 配送费：€${buyCart.deliverFee }
															&nbsp;<span >订单金额：€${buyCart.orderTotalPrice }</span>
														</td>
                            						</tr>
                          							<tr>
                            							<td colspan="3" align="right">
															&nbsp;<strong><font color=#cc0000>应付金额：€${buyCart.orderTotalPrice }</font></strong>
														</td>
                          							</tr>
                								</table>
                       						</td>
                      					</tr>
                    				</tbody>
                  				</table>
                  				<table cellSpacing=0 cellPadding=3 width="100%" border=0>
                    				<tbody>
                    					<tr>
                      						<td width=80 bgColor=#eeeeee>&nbsp;<strong>送货地址：</strong></td>
                      						<td bgColor=#eeeeee>
                      							<a href='<s:url action="deliver" namespace="/customer/shopping" includeParams="none"/>?directUrl=${directUrl}'>
                      								<img height=17 src="<%=request.getContextPath() %>/images/buy/az-s-change.gif" width=45 border=0>
                      							</a>
                      						</td>
                      					</tr>
				  					</tbody>
				  				</table>
                  				<table cellSpacing=0 cellPadding=5 width="100%" border=0>
                    				<tbody>
                    					<tr>
                      						<td bgColor=#ffffff>&nbsp;收货人姓名：${buyCart.deliverInfo.recipients}<br/>
                      							&nbsp;地址：${buyCart.deliverInfo.address}
												<br/>&nbsp;邮编：${buyCart.deliverInfo.postalcode}<br/>
                        						
                        						
                        						<c:if test="${!empty buyCart.deliverInfo.mobile}">&nbsp;电话: </c:if>${buyCart.deliverInfo.mobile}
											</td>
										</tr>
				  					</tbody>
				  				</table>
                  				<table cellSpacing=0 cellPadding=3 width="100%" border=0>
                    				<tbody>
                    					<tr>
                      						<td width=150 bgColor=#eeeeee>&nbsp;<strong>付款方式：</strong></td>
                      						<td width="756" bgColor=#eeeeee>
                      							<a href='<s:url action="paymentway" namespace="/customer/shopping" includeParams="none"/>?directUrl=${directUrl}'>
                      								<img height=17 src="<%=request.getContextPath() %>/images/buy/az-s-change.gif" width=45 border=0>
                      							</a>
                      						</td>
                    					</tr>
                    				</tbody>
                    			</table>
                  				<table cellSpacing=0 cellPadding=4 width="100%" bgColor=#ffffff border=0>
                    				<tbody>
                    					<tr>
                      						<td>
                        						<table width="60%">
                          							<tbody>
                          								<tr>
                            								<td width="30">付款方式：</td>
                            								<td width="221">
                            									<input type="text" value="${buyCart.paymentWayInfo.paymentway}" name="paymentway"/>
           
                            								</td>
														</tr>
                          								<tr>
                            								<td>&nbsp;</td>
                            							</tr>
													</tbody>
												</table>
					  						</td>
                    					</tr>
				 					</tbody>
				 				</table>
								<!--  发票 --><!--  发票 -->
                  				<table cellSpacing=0 cellPadding=3 width="100%" border=0>
                    				<tbody>
                    					<tr>
                      						<td bgColor=#eeeeee>&nbsp;<strong>附言</strong> (填写您的一些要求,100字以内)：</td>
                    					</tr>
					 					<tr>
                      						<td><textarea NaME="note" ROWS="3" COLS="60"></textarea></td>
                    					</tr>
				  					</tbody>
				  				</table>
				  			</tbody>
				  		</table>
            			<table cellSpacing=0 cellPadding=0 width="100%" align="center" bgColor="#4480dd" border=0>
              				<tbody>
              					<tr>
                					<td valign="bottom" width=7 height=30>
                						<img height=17 src="<%=request.getContextPath() %>/images/buy/az-s-bottom-left-blue-corner.gif" width=17>
                					</td>
                					<td align="right">
                  						<div id="layer_finish2">
                  							<input onClick="return validateForm()" type="image" height=37 alt="订单确认" width="116" src="<%=request.getContextPath() %>/images/buy/az-s-place-order_02.gif" border=0>
                  					    </div>
                  					</td>
                					<td valign=bottom width=7>
                						<img height=17 src="<%=request.getContextPath() %>/images/buy/az-s-bottom-right-blue-corner.gif" width=17>
                					</td>
                				</tr>
                			</tbody>
                		</table>
                	</div>
                </td>
               </tr>
              </tbody>
             </table>
  			<div align=center></div>
  		</td>
  	</tr>
  </tbody>
</table>
</s:form>
</body>
</html>
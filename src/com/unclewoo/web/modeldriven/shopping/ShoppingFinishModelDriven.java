package com.unclewoo.web.modeldriven.shopping;

import com.unclewoo.web.modeldriven.product.BaseModelDriven;

public class ShoppingFinishModelDriven extends BaseModelDriven{
	private String paymentway;
	private String orderid;
	private Float payablefee;
	public String getPaymentway() {
		return paymentway;
	}
	public void setPaymentway(String paymentway) {
		this.paymentway = paymentway;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public Float getPayablefee() {
		return payablefee;
	}
	public void setPayablefee(Float payablefee) {
		this.payablefee = payablefee;
	}
	
}

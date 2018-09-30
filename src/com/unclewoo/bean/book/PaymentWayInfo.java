package com.unclewoo.bean.book;

/**
 * 付款方式
 * @author King
 *
 */
public class PaymentWayInfo {
	/** 付款方式 **/
	private String paymentway;
	/** 信用卡卡号 **/
	private String creditnumber;
	/** 信用卡持有者姓名  **/
	private String creditownername;
	/** 信用卡过期月份  **/
	private String expirymonth;
	/** 信用卡过期年份  **/
	private String expiryyear;
	public String getPaymentway() {
		return paymentway;
	}
	public void setPaymentway(String paymentway) {
		this.paymentway = paymentway;
	}
	public String getCreditnumber() {
		return creditnumber;
	}
	public void setCreditnumber(String creditnumber) {
		this.creditnumber = creditnumber;
	}
	public String getCreditownername() {
		return creditownername;
	}
	public void setCreditownername(String creditownername) {
		this.creditownername = creditownername;
	}
	public String getExpirymonth() {
		return expirymonth;
	}
	public void setExpirymonth(String expirymonth) {
		this.expirymonth = expirymonth;
	}
	public String getExpiryyear() {
		return expiryyear;
	}
	public void setExpiryyear(String expiryyear) {
		this.expiryyear = expiryyear;
	}
	
	
}

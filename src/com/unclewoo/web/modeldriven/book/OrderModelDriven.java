package com.unclewoo.web.modeldriven.book;

import com.unclewoo.bean.book.OrderState;
import com.unclewoo.web.modeldriven.product.BaseModelDriven;

public class OrderModelDriven extends BaseModelDriven{
	private String state;
	private String orderid;
	private String username;
	private String recipients;
	private String buyer;
	private Integer contactid;
	
	private String buyer_address;
	private String buyer_postalcode;
	private String buyer_mobile;
	private String buyer_gender;
	
	private String gender;
	private String address;
	private String postalcode;
	private String email;
	private String mobile;
	private Integer deliverid;
	
	private Integer amount;
	private Integer orderitemid;
	private float fee;
	
	private String[] orderids;
	private String message;
	

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRecipients() {
		return recipients;
	}
	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getBuyer_address() {
		return buyer_address;
	}
	public void setBuyer_address(String buyer_address) {
		this.buyer_address = buyer_address;
	}
	public String getBuyer_postalcode() {
		return buyer_postalcode;
	}
	public void setBuyer_postalcode(String buyer_postalcode) {
		this.buyer_postalcode = buyer_postalcode;
	}
	public String getBuyer_mobile() {
		return buyer_mobile;
	}
	public void setBuyer_mobile(String buyer_mobile) {
		this.buyer_mobile = buyer_mobile;
	}
	public Integer getContactid() {
		return contactid;
	}
	public void setContactid(Integer contactid) {
		this.contactid = contactid;
	}
	public String getBuyer_gender() {
		return buyer_gender;
	}
	public void setBuyer_gender(String buyer_gender) {
		this.buyer_gender = buyer_gender;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getDeliverid() {
		return deliverid;
	}
	public void setDeliverid(Integer deliverid) {
		this.deliverid = deliverid;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getOrderitemid() {
		return orderitemid;
	}
	public void setOrderitemid(Integer orderitemid) {
		this.orderitemid = orderitemid;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	public String[] getOrderids() {
		return orderids;
	}
	public void setOrderids(String[] orderids) {
		this.orderids = orderids;
	}
	
}

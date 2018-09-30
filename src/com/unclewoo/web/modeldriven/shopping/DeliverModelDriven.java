package com.unclewoo.web.modeldriven.shopping;

import org.apache.xerces.impl.dv.util.Base64;

import com.unclewoo.bean.user.Gender;

public class DeliverModelDriven {
	private String recipients;
	//private Gender gender;
	private String gender;
	private String address;
	private String email;
	private String postalcode;
	//private String tel;
	private String mobile;
	private Boolean buyerIsrecipients;
	
	private String buyer;
	//private Gender buyer_gender;
	private String buyer_gender;
	private String buyer_address;
	private String buyer_postalcode;
	private String buyer_mobile;
	//private String buyer_tel;
	
	
	private String paymentway;
	private String creditnumber;
	private String creditownername;
	private String expirymonth;
	private String expiryyear;
	
	private String directUrl;
	private String note;
	
	
	
	public String getRecipients() {
		return recipients;
	}
	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}
//	public Gender getGender() {
//		return gender;
//	}
//	public void setGender(Gender gender) {
//		this.gender = gender;
//	}
	
	public String getAddress() {
		return address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	/*
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	*/
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Boolean getBuyerIsrecipients() {
		return buyerIsrecipients;
	}
	public void setBuyerIsrecipients(Boolean buyerIsrecipients) {
		this.buyerIsrecipients = buyerIsrecipients;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
//	public Gender getBuyer_gender() {
//		return buyer_gender;
//	}
//	public void setBuyer_gender(Gender buyer_gender) {
//		this.buyer_gender = buyer_gender;
//	}
	
	public String getBuyer_address() {
		return buyer_address;
	}
	public String getBuyer_gender() {
		return buyer_gender;
	}
	public void setBuyer_gender(String buyer_gender) {
		this.buyer_gender = buyer_gender;
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
	/*
	public String getBuyer_tel() {
		return buyer_tel;
	}
	public void setBuyer_tel(String buyer_tel) {
		this.buyer_tel = buyer_tel;
	}
	*/
	
	
	
	
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
	
	
	
	
	
	public String getDirectUrl() {
		return directUrl;
	}
	public void setDirectUrl(String directUrl) {
		if(directUrl!=null && !"".equals(directUrl.trim())){
			this.directUrl = new String(Base64.decode(directUrl.trim()));
		}	
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}

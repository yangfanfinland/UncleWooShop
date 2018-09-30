package com.unclewoo.bean.book;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.unclewoo.bean.user.Gender;

/**
 * 订单联系信息
 * @author King
 *
 */
@Entity
public class OrderContactInfo {
	private Integer contactid;
	/** 购买人姓名  **/
	private String buyerName;
	/** 配送地址  **/
	private String address;
	/** 电子邮箱  **/
	private String email;
	/** 邮编   **/
	private String postalcode;
	/** 座机  **/
	//private String tel;
	/** 手机  **/
	private String mobile;
	/** 性别  **/
	//private Gender gender = Gender.MAN;
	private String gender = "MAN";
	/** 所属订单  **/
	private Order order;
	
	@OneToOne(cascade=CascadeType.REFRESH, mappedBy="orderContactInfo")
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Id @GeneratedValue
	public Integer getContactid() {
		return contactid;
	}
	public void setContactid(Integer contactid) {
		this.contactid = contactid;
	}
	@Column(length=20,nullable=false)
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	@Column(length=40,nullable=false)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(length=40)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length=10)
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
	@Column(length=20)
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
//	public Gender getGender() {
//		return gender;
//	}
//	public void setGender(Gender gender) {
//		this.gender = gender;
//	}
	@Column(length=5,nullable=false)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contactid == null) ? 0 : contactid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderContactInfo other = (OrderContactInfo) obj;
		if (contactid == null) {
			if (other.contactid != null)
				return false;
		} else if (!contactid.equals(other.contactid))
			return false;
		return true;
	}
	
	
}

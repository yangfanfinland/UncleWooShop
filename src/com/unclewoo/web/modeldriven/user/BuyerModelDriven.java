package com.unclewoo.web.modeldriven.user;

import org.apache.xerces.impl.dv.util.Base64;

import com.unclewoo.web.modeldriven.product.BaseModelDriven;

public class BuyerModelDriven extends BaseModelDriven{
	
	private String username;
	private String password;
	private String email;
	private String realname;
	private String[] usernames;
	private String directUrl;
	private String validateCode;

	public String getDirectUrl() {
		return directUrl;
	}
	public void setDirectUrl(String directUrl) {
		if(directUrl!=null && !"".equals(directUrl.trim())){
			this.directUrl = new String(Base64.decode(directUrl.trim()));//获取解码后的url
		}
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String[] getUsernames() {
		return usernames;
	}
	public void setUsernames(String[] usernames) {
		this.usernames = usernames;
	}
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	
}

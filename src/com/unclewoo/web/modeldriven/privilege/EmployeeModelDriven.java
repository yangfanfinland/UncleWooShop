package com.unclewoo.web.modeldriven.privilege;

import com.unclewoo.web.modeldriven.product.BaseModelDriven;

public class EmployeeModelDriven extends BaseModelDriven{
	private String username;
	private String password;
	private String realname;
	private String departmentid;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

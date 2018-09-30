package com.unclewoo.web.modeldriven.privilege;

import com.unclewoo.web.modeldriven.product.BaseModelDriven;

public class DepartmentModelDriven extends BaseModelDriven{
	private String name;
	private String departmentid;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}
	
}

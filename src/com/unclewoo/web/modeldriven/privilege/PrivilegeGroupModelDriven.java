package com.unclewoo.web.modeldriven.privilege;

import com.unclewoo.bean.privilege.SystemPrivilegePK;
import com.unclewoo.web.modeldriven.product.BaseModelDriven;

public class PrivilegeGroupModelDriven extends BaseModelDriven{
	private String name;
	private SystemPrivilegePK[] privileges;
	private String groupid;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SystemPrivilegePK[] getPrivileges() {
		return privileges;
	}
	public void setPrivileges(SystemPrivilegePK[] privileges) {
		this.privileges = privileges;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	
}

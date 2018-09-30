package com.unclewoo.service.privilege;

import java.util.List;

import com.unclewoo.bean.privilege.SystemPrivilege;
import com.unclewoo.service.base.DAO1;

public interface SystemPrivilegeService extends DAO1<SystemPrivilege>{
	/**
	 * 批量保存权限
	 * @param privileges
	 */
	public void saves(List<SystemPrivilege> privileges);
}

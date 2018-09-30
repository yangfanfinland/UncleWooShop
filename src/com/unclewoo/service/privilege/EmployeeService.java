package com.unclewoo.service.privilege;

import com.unclewoo.bean.privilege.Employee;
import com.unclewoo.service.base.DAO1;

public interface EmployeeService extends DAO1<Employee>{
	/**
	 * 校验用户名是否存在
	 * @param username
	 * @return
	 */
	public boolean exist(String username);
	/**
	 * 校验用户名及密码是否存在
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean validate(String username, String password);
}

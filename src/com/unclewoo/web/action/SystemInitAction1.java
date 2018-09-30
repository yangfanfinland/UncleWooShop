package com.unclewoo.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.unclewoo.bean.privilege.Employee;
import com.unclewoo.bean.privilege.IDCard;
import com.unclewoo.bean.privilege.PrivilegeGroup;
import com.unclewoo.bean.privilege.SystemPrivilege;
import com.unclewoo.bean.user.Gender;
import com.unclewoo.service.privilege.EmployeeService;
import com.unclewoo.service.privilege.PrivilegeGroupService;
import com.unclewoo.service.privilege.SystemPrivilegeService;
/**
 * 初始化 (此action只是在系统安装完成后执行一次)
 * @author King
 *
 */
public class SystemInitAction1 extends ActionSupport implements ServletRequestAware{
	@Resource SystemPrivilegeService privilegeService;
	@Resource PrivilegeGroupService groupService;
	@Resource EmployeeService employeeService;
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	@Override
	public String execute() throws Exception {
		initPrivileges();
		initPrivilegeGroup();
		initAdmin();
		request.setAttribute("message", "权限初始化完成");
		request.setAttribute("urladdress", "/employee/logonUI.action");
		return super.execute();
	}
	
	/**
	 * 初始化管理员账号
	 */
	private void initAdmin() {
		//if(employeeService.getCount()==0){
			Employee employee = new Employee();
			employee.setUsername("admin");
			employee.setPassword("123456");
			employee.setRealname("系统管理员");
			employee.setGender(Gender.MAN);
			employee.setIdCard(new IDCard("213213","北京",new Date()));
			employee.getGroups().addAll(groupService.getScrollData().getResultlist());//赋予权限
			employeeService.save(employee);
		//}
	}

	/**
	 * 初始化系统权限组
	 */
	private void initPrivilegeGroup() {
		//if(groupService.getCount()==0){
			PrivilegeGroup group = new PrivilegeGroup();
			group.setName("系统权限组");
			group.getPrivileges().addAll(privilegeService.getScrollData().getResultlist());
			groupService.save(group);
		//}
		
	}

	/**
	 * 初始化权限
	 */
	private void initPrivileges(){
		//if(privilegeService.getCount()==0){
			List<SystemPrivilege> privileges = new ArrayList<SystemPrivilege>();
			privileges.add(new SystemPrivilege("department", "view", "部门查看"));
			privileges.add(new SystemPrivilege("department", "insert", "部门添加"));
			privileges.add(new SystemPrivilege("department", "update", "部门修改"));
			privileges.add(new SystemPrivilege("department", "delete", "部门删除"));
			
			privileges.add(new SystemPrivilege("employee", "view", "员工查看"));
			privileges.add(new SystemPrivilege("employee", "insert", "员工添加"));
			privileges.add(new SystemPrivilege("employee", "update", "员工信息修改"));
			privileges.add(new SystemPrivilege("employee", "leave", "员工离职设置"));
			privileges.add(new SystemPrivilege("employee", "privilegeSet", "员工权限分配"));
			privilegeService.saves(privileges);
		
		//}
	}
}

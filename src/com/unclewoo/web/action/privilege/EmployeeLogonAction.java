package com.unclewoo.web.action.privilege;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.service.privilege.EmployeeService;
import com.unclewoo.web.modeldriven.privilege.EmployeeModelDriven;
/**
 * 员工登录
 * @author King
 *
 */
public class EmployeeLogonAction extends ActionSupport implements ModelDriven<EmployeeModelDriven>,ServletRequestAware{
	@Resource EmployeeService employeeService;
	
	EmployeeModelDriven employeeModelDriven = new EmployeeModelDriven();
	public EmployeeModelDriven getModel() {
		return employeeModelDriven;
	}
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
	
	public String execute(){
		if(employeeModelDriven.getUsername()!=null && !"".equals(employeeModelDriven.getUsername().trim())
				&& employeeModelDriven.getPassword()!=null &&!"".equals(employeeModelDriven.getPassword().trim())){
			if(employeeService.validate(employeeModelDriven.getUsername(), employeeModelDriven.getPassword())){
				request.getSession().setAttribute("employee", employeeService.find(employeeModelDriven.getUsername().trim()));
				return "control";
			}
			request.setAttribute("message", "用户名及密码有误！");
		}
		return "message";
	}

	
}

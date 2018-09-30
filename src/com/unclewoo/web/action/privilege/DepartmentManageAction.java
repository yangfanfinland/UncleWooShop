package com.unclewoo.web.action.privilege;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.aspectj.lang.annotation.Aspect;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.privilege.Department;
import com.unclewoo.service.privilege.DepartmentService;
import com.unclewoo.utils.SiteUrl;
import com.unclewoo.web.modeldriven.privilege.DepartmentModelDriven;
/**
 * 部门管理
 * @author King
 *
 */
@Aspect
public class DepartmentManageAction extends ActionSupport implements ModelDriven<DepartmentModelDriven>,
	ServletRequestAware{

	@Resource DepartmentService departmentService;
	
	DepartmentModelDriven departmentModelDriven = new DepartmentModelDriven();
	public DepartmentModelDriven getModel() {
		return departmentModelDriven;
	}
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	/**
	 * 部门添加界面
	 * @return
	 */
	@Permission(module="department", privilege="insert")
	public String addUI(){
		return "success";
	}
	/**
	 * 添加部门
	 */
	@Permission(module="department", privilege="insert")
	public String add(){
		Department department = new Department();
		department.setName(departmentModelDriven.getName());
		departmentService.save(department);
		
		request.setAttribute("message", "部门添加成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.department.list"));
		return "message";
	}
	/**
	 * 修改部门界面
	 * @return
	 */
	@Permission(module="department", privilege="update")
	public String editUI(){
		Department department = departmentService.find(departmentModelDriven.getDepartmentid());
		departmentModelDriven.setName(department.getName());
		return "success";
	}
	/**
	 * 修改部门
	 * @return
	 */
	@Permission(module="department", privilege="update")
	public String edit(){
		Department department = departmentService.find(departmentModelDriven.getDepartmentid());
		department.setName(departmentModelDriven.getName());
		departmentService.update(department);
		
		request.setAttribute("message", "部门修改成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.department.list"));
		return "message";
	}
	/**
	 * 删除部门
	 * @return
	 */
	@Permission(module="department", privilege="delete")
	public String delete(){
		departmentService.delete((Serializable)departmentModelDriven.getDepartmentid());
		
		request.setAttribute("message", "部门删除成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.department.list"));
		return "message";
	}
}

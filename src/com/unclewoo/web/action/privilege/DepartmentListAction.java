package com.unclewoo.web.action.privilege;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.PageView;
import com.unclewoo.bean.privilege.Department;
import com.unclewoo.service.privilege.DepartmentService;
import com.unclewoo.web.modeldriven.privilege.DepartmentModelDriven;
/**
 * 部门分页列表
 * @author King
 *
 */
public class DepartmentListAction extends ActionSupport implements ModelDriven<DepartmentModelDriven>,
	ServletRequestAware{

	DepartmentModelDriven departmentModelDriven = new DepartmentModelDriven();
	public DepartmentModelDriven getModel() {
		return departmentModelDriven;
	}
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	@Resource
	DepartmentService departmentService;
	
	@Permission(module="department", privilege="view")
	public String execute() throws Exception {
		PageView<Department> pageView = new PageView<Department>(12, departmentModelDriven.getPage());
		pageView.setQueryResult(departmentService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult()));
		request.setAttribute("pageView", pageView);
		return "success";
	}

	
}

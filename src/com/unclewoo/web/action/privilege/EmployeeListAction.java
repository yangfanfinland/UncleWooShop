package com.unclewoo.web.action.privilege;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.PageView;
import com.unclewoo.bean.privilege.Employee;
import com.unclewoo.service.privilege.EmployeeService;
import com.unclewoo.web.modeldriven.privilege.EmployeeModelDriven;
/**
 * 员工分页列表
 * @author King
 *
 */
public class EmployeeListAction extends ActionSupport implements ModelDriven<EmployeeModelDriven>,
	ServletRequestAware{
	
	@Resource EmployeeService employeeService;
	
	EmployeeModelDriven employeeModelDriven = new EmployeeModelDriven();
	public EmployeeModelDriven getModel() {
		return employeeModelDriven;
	}
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	@Override
	public String execute() throws Exception {
		PageView<Employee> pageView = new PageView<Employee>(12, employeeModelDriven.getPage());
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("realname", "desc");
		if("true".equals(employeeModelDriven.getQuery())){//如果来自于查询界面
			StringBuilder jpql = new StringBuilder();
			List<Object> params = new ArrayList<Object>();
			if(employeeModelDriven.getUsername()!=null && !"".equals(employeeModelDriven.getUsername())){
				params.add("%"+ employeeModelDriven.getUsername().trim() +"%");
				jpql.append("o.username like ?").append(params.size());
			}
			if(employeeModelDriven.getRealname()!=null && !"".equals(employeeModelDriven.getRealname())){
				if(!params.isEmpty())
					jpql.append(" and ");
				params.add("%"+ employeeModelDriven.getRealname().trim() +"%");
				jpql.append("o.realname like ?").append(params.size());
			}
			if(employeeModelDriven.getDepartmentid()!=null && !"".equals(employeeModelDriven.getDepartmentid())){
				if(!params.isEmpty())
					jpql.append(" and ");
				params.add(employeeModelDriven.getDepartmentid());
				jpql.append("o.department.departmentid =?").append(params.size());
			}
			pageView.setQueryResult(employeeService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult(),
					jpql.toString(), params.toArray() ,orderby));
		}else{
			pageView.setQueryResult(employeeService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult(),orderby));
		}
		
		
		request.setAttribute("pageView", pageView);
		
		return "success";
	}
}

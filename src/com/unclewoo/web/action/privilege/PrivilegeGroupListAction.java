package com.unclewoo.web.action.privilege;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.PageView;
import com.unclewoo.bean.privilege.PrivilegeGroup;
import com.unclewoo.service.privilege.PrivilegeGroupService;
import com.unclewoo.web.modeldriven.privilege.PrivilegeGroupModelDriven;
/**
 * 权限组分页列表
 * @author King
 *
 */
public class PrivilegeGroupListAction extends ActionSupport implements ModelDriven<PrivilegeGroupModelDriven>,
	ServletRequestAware{

	@Resource PrivilegeGroupService groupService;
	
	PrivilegeGroupModelDriven privilegeGroupModelDriven = new PrivilegeGroupModelDriven();
	public PrivilegeGroupModelDriven getModel() {
		return privilegeGroupModelDriven;
	}
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String execute(){
		
		PageView<PrivilegeGroup> pageView = new PageView<PrivilegeGroup>(12, privilegeGroupModelDriven.getPage());
		pageView.setQueryResult(groupService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult()));
		request.setAttribute("pageView", pageView);
		
		return "success";
	}
}

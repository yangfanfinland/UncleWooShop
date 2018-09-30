package com.unclewoo.web.action.privilege;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.privilege.PrivilegeGroup;
import com.unclewoo.bean.privilege.SystemPrivilege;
import com.unclewoo.bean.privilege.SystemPrivilegePK;
import com.unclewoo.service.privilege.PrivilegeGroupService;
import com.unclewoo.service.privilege.SystemPrivilegeService;
import com.unclewoo.web.modeldriven.privilege.PrivilegeGroupModelDriven;

public class PrivilegeGroupManageAction extends ActionSupport implements ModelDriven<PrivilegeGroupModelDriven>,
	ServletRequestAware{
	@Resource SystemPrivilegeService privilegeService;
	@Resource PrivilegeGroupService groupService;
	
	PrivilegeGroupModelDriven privilegeGroupModelDriven = new PrivilegeGroupModelDriven();
	public PrivilegeGroupModelDriven getModel() {
		return privilegeGroupModelDriven;
	}
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	/**
	 * 权限组添加界面
	 * @return
	 */
	public String addUI(){
		request.setAttribute("privileges", privilegeService.getScrollData().getResultlist());
		return "success";
	}
	/**
	 * 添加权限组
	 * @return
	 */
	public String add(){
		PrivilegeGroup group = new PrivilegeGroup();
		group.setName(privilegeGroupModelDriven.getName());
		for(SystemPrivilegePK id : privilegeGroupModelDriven.getPrivileges())
			group.addSystemPrivilege(new SystemPrivilege(id));
		
		groupService.save(group);
		
		request.setAttribute("message", "添加权限组成功");
		request.setAttribute("urladdress", "/control/privilegegroup/list.action");
		return "message";
	}
	/**
	 * 权限组修改界面
	 * @return
	 */
	public String editUI(){
		PrivilegeGroup group = groupService.find(privilegeGroupModelDriven.getGroupid());
		privilegeGroupModelDriven.setName(group.getName());
		request.setAttribute("selectprivileges", group.getPrivileges());
		request.setAttribute("privileges", privilegeService.getScrollData().getResultlist());
		return "success";
	}
	/**
	 * 修改权限组
	 * @return
	 */
	public String edit(){
		PrivilegeGroup group = groupService.find(privilegeGroupModelDriven.getGroupid());
		group.setName(privilegeGroupModelDriven.getName());
		group.getPrivileges().clear();
		for(SystemPrivilegePK id : privilegeGroupModelDriven.getPrivileges())
			group.addSystemPrivilege(new SystemPrivilege(id));
		groupService.update(group);
		
		request.setAttribute("message", "权限组修改成功");
		request.setAttribute("urladdress", "/control/privilegegroup/list.action");
		return "message";
	}
	/**
	 * 删除权限组
	 * @return
	 */
	public String delete(){
		groupService.delete((Serializable)privilegeGroupModelDriven.getGroupid());
		
		request.setAttribute("message", "权限组删除成功");
		request.setAttribute("urladdress", "/control/privilegegroup/list.action");
		return "message";
	}
}

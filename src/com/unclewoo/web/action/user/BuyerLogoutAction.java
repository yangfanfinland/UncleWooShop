package com.unclewoo.web.action.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyerLogoutAction extends ActionSupport implements ServletRequestAware{
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String execute(){
		request.getSession().removeAttribute("user");
		return "success";
	}
}

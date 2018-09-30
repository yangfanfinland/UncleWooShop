package com.unclewoo.web.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.unclewoo.service.book.GeneratedOrderidService;

/**
 * 初始化
 * @author King
 *
 */
public class SystemInitAction extends ActionSupport implements ServletRequestAware{
	
	@Resource GeneratedOrderidService generatedOrderidService;
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String execute(){
		generatedOrderidService.init();//初始化系统
		request.setAttribute("message", "初始化完成");
		request.setAttribute("urladdress", "/");
		return "success";
	}
}

package com.unclewoo.web.action.shopping;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.xerces.impl.dv.util.Base64;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 订单信息确认界面
 * @author King
 *
 */
public class OrderConfirmAction extends ActionSupport implements ServletRequestAware{
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
	public String execute(){
		
		String url = "/customer/shopping/confirm.action";
		request.setAttribute("directUrl", new String(Base64.encode(url.getBytes())));
		return "success";
	}
}

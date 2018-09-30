package com.unclewoo.web.action.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.xerces.impl.dv.util.Base64;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.service.user.BuyerService;
import com.unclewoo.web.modeldriven.user.BuyerModelDriven;

public class BuyerLogonAction extends ActionSupport implements ModelDriven<BuyerModelDriven>, ServletRequestAware{
	
	BuyerModelDriven buyerModelDriven = new BuyerModelDriven();

	public BuyerModelDriven getModel() {
		return buyerModelDriven;
	}
	
	@Resource BuyerService buyerService ;
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
	public String execute(){
		if(buyerModelDriven.getUsername()!=null && !"".equals(buyerModelDriven.getUsername().trim())
				&& buyerModelDriven.getPassword()!=null && !"".equals(buyerModelDriven.getPassword().trim())){
			if(buyerService.validate(buyerModelDriven.getUsername().trim(), buyerModelDriven.getPassword().trim())){
				request.getSession().setAttribute("user", buyerService.find(buyerModelDriven.getUsername().trim()));
				//request.setAttribute("message", "用户登录成功");
				
				String url = "/customer/shopping/deliver.action";
				if(buyerModelDriven.getDirectUrl()!=null){
					url = buyerModelDriven.getDirectUrl();//url返回值为/UncleWooShop/customer/shopping/pay_cart.action
					url = url.substring(13);//截取/customer/shopping/pay_cart.action
				//System.out.println(url+"haha");
				}
				request.setAttribute("directUrl", url);
				return "message";
			}else{
				request.setAttribute("error", "用户名及密码有误");
			}
		}
		return "success";
	}
}
 
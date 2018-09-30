package com.unclewoo.web.action.user;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.user.Buyer;
import com.unclewoo.service.user.BuyerService;
import com.unclewoo.web.modeldriven.user.BuyerModelDriven;

public class BuyerRegAction extends ActionSupport implements ModelDriven<BuyerModelDriven>, ServletRequestAware{
	
	BuyerModelDriven buyerModelDriven = new BuyerModelDriven();

	public BuyerModelDriven getModel() {
		return buyerModelDriven;
	}
	
	@Resource BuyerService buyerService;
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	/**
	 * 显示注册页面
	 */
	public String execute(){
		return "success";
	}
	
	/**
	 * 用户注册
	 * @return
	 */
	public String reg(){
		
		
		//ActionContext ctx = ActionContext.getContext();
		
		/*
		   ActionContext ctx = ActionContext.getContext();
		   ctx.getApplication().put("app", "应用范围");//往ServletContext里放入app
		   ctx.getSession().put("ses", "session范围");//往session里放入ses
		   ctx.put("req", "request范围");//往request里放入req
		   return "scope";
		*/
		
		
		if(!buyerService.exist(buyerModelDriven.getUsername().trim())){
			Buyer buyer = new Buyer();
			buyer.setUsername(buyerModelDriven.getUsername().trim());
			buyer.setPassword(buyerModelDriven.getPassword().trim());
			buyer.setEmail(buyerModelDriven.getEmail().trim());
			buyerService.save(buyer);
			request.getSession().setAttribute("user", buyer);
			request.setAttribute("message", "用户注册成功！！！");
			
			
			String url = "/customer/shopping/deliver.action";
			if(buyerModelDriven.getDirectUrl()!=null)
				url = buyerModelDriven.getDirectUrl();
			request.setAttribute("urladdress", url);
			return "message";
		}else{
			request.getSession().setAttribute("error", "该用户已经存在");
			return "error";	
		}
		
	}
	
	/**
	 * 校验用户是否存在
	 * @return
	 */
	public String isUserExist(){
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request");
		request.put("exsit", buyerService.exist(buyerModelDriven.getUsername().trim()));
		return "success";
	}

	
}

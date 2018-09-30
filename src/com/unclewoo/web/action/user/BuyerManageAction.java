package com.unclewoo.web.action.user;

import java.io.Serializable;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.service.user.BuyerService;
import com.unclewoo.web.modeldriven.user.BuyerModelDriven;

public class BuyerManageAction extends ActionSupport implements ModelDriven<BuyerModelDriven>{
	
	BuyerModelDriven buyerModelDriven = new BuyerModelDriven();

	public BuyerModelDriven getModel() {
		return buyerModelDriven;
	}
	
	@Resource BuyerService buyerService ;
	
	/**
	 * 禁用用户账号
	 * @return
	 */
	public String delete(){
		ActionContext ctx = ActionContext.getContext();

		buyerService.delete((Serializable[])buyerModelDriven.getUsernames());
		ctx.put("message", "账号禁用成功！");
		ctx.put("urladdress", "/control/user/list.action");
		return "message";
	}
	
	/**
	 * 启用用户账号
	 * @return
	 */
	public String enable(){
		ActionContext ctx = ActionContext.getContext();
		
		buyerService.enable((Serializable[])buyerModelDriven.getUsernames());
		ctx.put("message", "账号启用成功！");
		ctx.put("urladdress", "/control/user/list.action");
		return "message";
	}
}

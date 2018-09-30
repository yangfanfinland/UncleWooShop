package com.unclewoo.web.action.shopping;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.web.modeldriven.shopping.ShoppingFinishModelDriven;
/**
 * 订购完成
 * 订单提交结果页面
 * @author King
 *
 */
public class ShoppingFinishAction extends ActionSupport implements ModelDriven<ShoppingFinishModelDriven>{
	
	ShoppingFinishModelDriven shoppingFinishModelDriven = new ShoppingFinishModelDriven();
	
	public ShoppingFinishModelDriven getModel() {
		return shoppingFinishModelDriven;
	}
	
	public String execute(){
		System.out.println(shoppingFinishModelDriven.getPaymentway());
		if(shoppingFinishModelDriven.getPaymentway().equals("American Express")){
			//返回American Express视图
			return "";
		}else if(shoppingFinishModelDriven.getPaymentway().equals("Visa")){
			//返回Visa视图
			return "";
		}else if(shoppingFinishModelDriven.getPaymentway().equals("MasterCard")){
			//返回MasterCard视图
			return "success";
		}else if(shoppingFinishModelDriven.getPaymentway().equals("Diners Club")){
			//返回Diners Club视图
			return "";
		}
		return null;
	}

	
}

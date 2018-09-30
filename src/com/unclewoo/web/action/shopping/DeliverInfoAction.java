package com.unclewoo.web.action.shopping;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.user.Gender;
import com.unclewoo.utils.WebUtil;
import com.unclewoo.web.modeldriven.shopping.DeliverModelDriven;
/**
 * 显示配送信息填写界面
 * @author King
 *
 */
public class DeliverInfoAction extends ActionSupport implements ModelDriven<DeliverModelDriven>, ServletRequestAware{
	
	DeliverModelDriven deliverModelDriven = new DeliverModelDriven();
	
	public DeliverModelDriven getModel() {
		return deliverModelDriven;
	}
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String execute(){
		//如果使用struts2 标签，form表单数据回显
//		deliverModelDriven.setGender(Gender.MAN);
//		deliverModelDriven.setBuyer_gender(Gender.MAN);
//		deliverModelDriven.setEmail(WebUtil.getBuyer(request).getEmail());
//		deliverModelDriven.setBuyerIsrecipients(true);
		
		return "success";
	}
}

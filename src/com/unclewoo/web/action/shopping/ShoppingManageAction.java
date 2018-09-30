package com.unclewoo.web.action.shopping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.BuyCart;
import com.unclewoo.bean.book.Order;
import com.unclewoo.bean.book.OrderContactInfo;
import com.unclewoo.bean.book.OrderDeliverInfo;
import com.unclewoo.bean.book.PaymentWayInfo;
import com.unclewoo.bean.user.Gender;
import com.unclewoo.service.book.OrderService;
import com.unclewoo.service.book.impl.OrderServiceBean;
import com.unclewoo.utils.WebUtil;
import com.unclewoo.web.modeldriven.shopping.DeliverModelDriven;

public class ShoppingManageAction extends ActionSupport implements ModelDriven<DeliverModelDriven>, ServletRequestAware{

	@Resource 
	OrderService orderService;
	
	DeliverModelDriven deliverModelDriven = new DeliverModelDriven();
	
	public DeliverModelDriven getModel() {
		return deliverModelDriven;
	}
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	/**
	 * 保存配送信息
	 * @return
	 */
	public String saveDeliverInfo(){
		
		
		BuyCart cart = WebUtil.getBuyCart(request);
		System.out.println(cart.getClass());
		cart.setDeliverInfo(new OrderDeliverInfo());
		cart.getDeliverInfo().setRecipients(deliverModelDriven.getRecipients());
		cart.getDeliverInfo().setGender(deliverModelDriven.getGender());
		cart.getDeliverInfo().setAddress(deliverModelDriven.getAddress());
		cart.getDeliverInfo().setPostalcode(deliverModelDriven.getPostalcode());
		cart.getDeliverInfo().setEmail(deliverModelDriven.getEmail());
		//cart.getDeliverInfo().setTel(deliverModelDriven.getTel());
		cart.getDeliverInfo().setMobile(deliverModelDriven.getMobile());
		
		cart.setBuyerIsrecipients(deliverModelDriven.getBuyerIsrecipients());
		
		cart.setContactInfo(new OrderContactInfo());
		if(cart.getBuyerIsrecipients()){//判断收货人与订购者是否相同
			cart.getContactInfo().setBuyerName(deliverModelDriven.getRecipients());
			cart.getContactInfo().setGender(deliverModelDriven.getGender());
			cart.getContactInfo().setAddress(deliverModelDriven.getAddress());
			cart.getContactInfo().setPostalcode(deliverModelDriven.getPostalcode());
			//cart.getContactInfo().setTel(deliverModelDriven.getTel());
			cart.getContactInfo().setMobile(deliverModelDriven.getMobile());
			cart.getContactInfo().setEmail(deliverModelDriven.getEmail());
			System.out.println(deliverModelDriven.getRecipients()+
					deliverModelDriven.getGender()+
					deliverModelDriven.getAddress()+
					deliverModelDriven.getPostalcode()+
					deliverModelDriven.getMobile()+
					deliverModelDriven.getEmail());
		}else{
			cart.getContactInfo().setBuyerName(deliverModelDriven.getRecipients());
			cart.getContactInfo().setGender(deliverModelDriven.getBuyer_gender());
			cart.getContactInfo().setAddress(deliverModelDriven.getBuyer_address());
			cart.getContactInfo().setPostalcode(deliverModelDriven.getBuyer_postalcode());
			//cart.getContactInfo().setTel(deliverModelDriven.getBuyer_tel());
			cart.getContactInfo().setMobile(deliverModelDriven.getBuyer_mobile());
			cart.getContactInfo().setEmail(WebUtil.getBuyer(request).getEmail());
			System.out.println(deliverModelDriven.getRecipients()+
					deliverModelDriven.getBuyer_gender()+
					deliverModelDriven.getBuyer_address()+
					deliverModelDriven.getBuyer_postalcode()+
					deliverModelDriven.getBuyer_mobile()+
					WebUtil.getBuyer(request).getEmail());
		}
		
		String url = "/customer/shopping/paymentway.action";
		if(deliverModelDriven.getDirectUrl()!=null)
			url = deliverModelDriven.getDirectUrl();
		request.setAttribute("directUrl", url);
		
		return "success";
	}
	/**
	 * 保存用户选择的支付方式
	 * @return
	 */
	public String savePaymentway(){
		BuyCart cart = WebUtil.getBuyCart(request);
		System.out.println(cart.getClass());
		
		cart.setPaymentWayInfo(new PaymentWayInfo());
		cart.getPaymentWayInfo().setPaymentway(deliverModelDriven.getPaymentway());
		cart.getPaymentWayInfo().setCreditnumber(deliverModelDriven.getCreditnumber());
		cart.getPaymentWayInfo().setCreditownername(deliverModelDriven.getCreditownername());
		cart.getPaymentWayInfo().setExpirymonth(deliverModelDriven.getExpirymonth());
		cart.getPaymentWayInfo().setExpiryyear(deliverModelDriven.getExpiryyear());
		
		System.out.println(deliverModelDriven.getPaymentway()+
				deliverModelDriven.getCreditnumber()+
				deliverModelDriven.getCreditownername()+
				deliverModelDriven.getExpirymonth()+
				deliverModelDriven.getExpiryyear());
		
		request.setAttribute("directUrl", "/customer/shopping/confirm.action");
		return "success";
	}
	/**
	 * 提交订单
	 * @return
	 */
	public String saveorder(){
		BuyCart cart = WebUtil.getBuyCart(request);
		cart.setNote(deliverModelDriven.getNote());
		Order order = orderService.createOrder(cart, WebUtil.getBuyer(request).getUsername());
		WebUtil.deleteBuyCart(request);
		
		request.setAttribute("directUrl", "/shopping/finish.action?orderid="+order.getOrderid()+
				"&paymentway="+order.getPaymentWay()+"&payablefee="+order.getPayablefee());
		return "success";
	}

}

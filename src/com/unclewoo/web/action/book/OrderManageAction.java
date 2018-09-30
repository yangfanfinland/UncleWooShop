package com.unclewoo.web.action.book;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.book.Message;
import com.unclewoo.bean.book.Order;
import com.unclewoo.bean.book.OrderContactInfo;
import com.unclewoo.bean.book.OrderDeliverInfo;
import com.unclewoo.bean.book.OrderItem;
import com.unclewoo.service.book.MessageService;
import com.unclewoo.service.book.OrderContactInfoService;
import com.unclewoo.service.book.OrderDeliverInfoService;
import com.unclewoo.service.book.OrderItemService;
import com.unclewoo.service.book.OrderService;
import com.unclewoo.utils.SiteUrl;
import com.unclewoo.utils.WebUtil;
import com.unclewoo.web.modeldriven.book.OrderModelDriven;
/**
 * 订单管理
 * @author King
 *
 */
public class OrderManageAction extends ActionSupport implements ModelDriven<OrderModelDriven>, ServletRequestAware{
	
	OrderModelDriven orderModelDriven = new OrderModelDriven();
	public OrderModelDriven getModel() {
		return orderModelDriven;
	}
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
	@Resource
	OrderContactInfoService orderContactInfoService;
	@Resource
	OrderDeliverInfoService orderDeliverInfoService;
	@Resource
	OrderService orderService;
	@Resource
	OrderItemService itemService;
	@Resource
	MessageService messageService;
	
	/**
	 * 添加客服留言
	 * @return
	 */
	public String addMessage(){
		Message msg = new Message();
		msg.setContent(orderModelDriven.getMessage());
		msg.setUsername(WebUtil.getEmployee(request).getUsername());
		msg.setOrder(new Order(orderModelDriven.getOrderid()));
		messageService.save(msg);
		
		request.setAttribute("message", "留言保存成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.view")+"?orderid="+orderModelDriven.getOrderid());
		return "message";
	}
	
	/**
	 * 客服留言添加界面
	 * @return
	 */
	public String addMessageUI(){
		return "success";
	}
	
	/**
	 * 强行解锁订单
	 * @return
	 */
	public String allUnLock(){
		orderService.unlock(orderModelDriven.getOrderids());
		
		request.setAttribute("message", "强行解锁订单成功");
		request.setAttribute("urladdress", "/control/order/lockorderlist.action");
		return "message";
	}
	/**
	 * 订购者信息修改界面
	 * @return
	 */
	public String modifyContactInfoUI(){
		OrderContactInfo contact = orderContactInfoService.find(orderModelDriven.getContactid());
		orderModelDriven.setBuyer(contact.getBuyerName());
		orderModelDriven.setBuyer_address(contact.getAddress());
		orderModelDriven.setBuyer_postalcode(contact.getPostalcode());
		orderModelDriven.setBuyer_mobile(contact.getMobile());
		return "success";
	}
	/**
	 * 修改订购者信息
	 * @return
	 */
	public String modifyContactInfo(){
		OrderContactInfo contact = orderContactInfoService.find(orderModelDriven.getContactid());
		contact.setBuyerName(orderModelDriven.getBuyer());
		contact.setGender(orderModelDriven.getBuyer_gender());
		contact.setAddress(orderModelDriven.getBuyer_address());
		contact.setMobile(orderModelDriven.getBuyer_mobile());
		contact.setPostalcode(orderModelDriven.getBuyer_postalcode());
		orderContactInfoService.update(contact);
		
		request.setAttribute("message", "订购者信息修改成功！");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.view")+"?orderid="+contact.getOrder().getOrderid());
		return "message";
	}
	/**
	 * 收货者信息修改界面
	 * @return
	 */
	public String modifyDeliverInfoUI(){
		OrderDeliverInfo deliverInfo = orderDeliverInfoService.find(orderModelDriven.getDeliverid());
		orderModelDriven.setRecipients(deliverInfo.getRecipients());
		orderModelDriven.setAddress(deliverInfo.getAddress());
		orderModelDriven.setPostalcode(deliverInfo.getPostalcode());
		orderModelDriven.setEmail(deliverInfo.getEmail());
		orderModelDriven.setMobile(deliverInfo.getMobile());
		return "success";
	}
	/**
	 * 修改收货者配送信息
	 * @return
	 */
	public String modifyDeliverInfo(){
		OrderDeliverInfo deliverInfo = orderDeliverInfoService.find(orderModelDriven.getDeliverid());
		deliverInfo.setEmail(orderModelDriven.getEmail());
		deliverInfo.setRecipients(orderModelDriven.getRecipients());
		deliverInfo.setGender(orderModelDriven.getGender());
		deliverInfo.setAddress(orderModelDriven.getAddress());
		deliverInfo.setPostalcode(orderModelDriven.getPostalcode());
		deliverInfo.setMobile(orderModelDriven.getMobile());
		orderDeliverInfoService.update(deliverInfo);
		
		request.setAttribute("message", "修改收货者配送信息改成功！");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.view")+"?orderid="+deliverInfo.getOrder().getOrderid());
		return "message";
	}
	/**
	 * 产品购买数量修改界面
	 * @return
	 */
	public String modifyProductAmountUI(){
		OrderItem item = itemService.find(orderModelDriven.getOrderitemid());
		orderModelDriven.setAmount(item.getAmount());
		orderModelDriven.setOrderid(item.getOrder().getOrderid());
		return "success";
	}
	/**
	 * 修改产品购买数量信息
	 * @return
	 */
	public String modifyProductAmount(){
		OrderItem item = itemService.find(orderModelDriven.getOrderitemid());
		itemService.updateAmount(orderModelDriven.getOrderitemid(), orderModelDriven.getAmount());
		
		request.setAttribute("message", "修改产品购买数量信息改成功！");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.view")+"?orderid="+orderModelDriven.getOrderid());
		return "message";
	}
	/**
	 * 删除购买商品订单项
	 * @return
	 */
	public String deleteOrderItem(){
		itemService.delete((Serializable)orderModelDriven.getOrderitemid());
		request.setAttribute("message", "删除订单项成功！");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.view")+"?orderid="+orderModelDriven.getOrderid());
		return "message";
	}
	/**
	 * 配送费修改界面
	 * @return
	 */
	public String modifyDeliverFeeUI(){
		Order order = orderService.find(orderModelDriven.getOrderid());
		orderModelDriven.setFee(order.getDeliverFee());
		return "success";
	}
	/**
	 * 修改配送费
	 * @return
	 */
	public String modifyDeliverFee(){
		orderService.updateDeliverFee(orderModelDriven.getOrderid(), orderModelDriven.getFee());
		request.setAttribute("message", "配送费修改成功！");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.view")+"?orderid="+orderModelDriven.getOrderid());
		return "message";
	}
	/**
	 * 打印发货单
	 * @return
	 */
	public String printOrder(){
		request.setAttribute("order", orderService.find(orderModelDriven.getOrderid()));
		return "print";
	}
	/**
	 * 取消订单
	 * @return
	 */
	public String cancelOrder(){
		orderService.cancelOrder(orderModelDriven.getOrderid());
		
		request.setAttribute("message", "订单取消成功！");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.list"));
		return "message";
	}
	/**
	 * 审核通过订单
	 * @return
	 */
	public String confirmOrder(){
		orderService.confirmOrder(orderModelDriven.getOrderid());
		
		request.setAttribute("message", "订单审核通过");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.list"));
		return "message";
	}
	/**
	 * 财务确认已付款
	 * @return
	 */
	public String confirmPayment(){
		orderService.confirmPayment(orderModelDriven.getOrderid());
		
		request.setAttribute("message", "订单已设置为支付");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.list")+"?state=WAITPAYMENT&query=true");
		return "message";
	}
	/**
	 * 把订单设置为等待发货状态
	 * @return
	 */
	public String turnWaitdeliver(){
		orderService.turnWaitdeliver(orderModelDriven.getOrderid());
		
		request.setAttribute("message", "设置成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.list")+"?state=ADMEASUREPRODUCT&query=true");
		return "message";
	}
	/**
	 * 把订单设置为已发货状态
	 * @return
	 */
	public String turnDelivered(){
		orderService.turnDelivered(orderModelDriven.getOrderid());
		
		request.setAttribute("message", "设置成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.list")+"?state=WAITDELIVER&query=true");
		return "message";
	}
	/**
	 * 把订单设置为已收货状态
	 * @return
	 */
	public String turnReceived(){
		orderService.turnReceived(orderModelDriven.getOrderid());
		
		request.setAttribute("message", "设置成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.list")+"?state=DELIVERED&query=true");
		return "message";
	}
	/**
	 * 解锁订单
	 * @return
	 */
	public String employeeUnlockOrder(){
		orderService.unlock(orderModelDriven.getOrderid());
		
		request.setAttribute("directUrl", SiteUrl.readUrl("control.order.list"));
		return "success";
	}
}

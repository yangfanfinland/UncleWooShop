package com.unclewoo.web.action.book;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.regexp.internal.recompile;
import com.unclewoo.bean.book.Order;
import com.unclewoo.bean.privilege.Employee;
import com.unclewoo.service.book.OrderService;
import com.unclewoo.utils.WebUtil;
import com.unclewoo.web.modeldriven.book.OrderModelDriven;
/**
 * 订单信息查看
 * @author King
 *
 */
public class OrderViewAction extends ActionSupport implements ModelDriven<OrderModelDriven>, ServletRequestAware{

	@Resource OrderService orderService;
	
	OrderModelDriven orderModelDriven = new OrderModelDriven();
	public OrderModelDriven getModel() {
		return orderModelDriven;
	}
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String execute() throws Exception {
		Employee employee = WebUtil.getEmployee(request);
		String username = employee.getUsername();
		Order order = orderService.addLock(orderModelDriven.getOrderid(), username);
		if(order.getLockuser()!=null && !order.getLockuser().equals(username)){
			request.setAttribute("message", "订单已经被 "+order.getLockuser()+" 加锁");
			request.setAttribute("urladdress", "/control/order/list.action");
			return "message";
		}
		request.setAttribute("order", order);
		return "success";
	}

	
}

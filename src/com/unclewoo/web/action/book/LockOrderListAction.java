package com.unclewoo.web.action.book;

import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.PageView;
import com.unclewoo.bean.book.Order;
import com.unclewoo.service.book.OrderService;
import com.unclewoo.web.modeldriven.book.OrderModelDriven;

/**
 * 锁定订单列表
 * @author King
 *
 */
public class LockOrderListAction extends ActionSupport implements ServletRequestAware,
	ModelDriven<OrderModelDriven>{
	@Resource OrderService orderService;
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	OrderModelDriven orderModelDriven = new OrderModelDriven();
	public OrderModelDriven getModel() {
		return orderModelDriven;
	}
	
	public String execute(){
		PageView<Order> pageView = new PageView<Order>(12, orderModelDriven.getPage());
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("createDate", "asc");
		pageView.setQueryResult(orderService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult(),
				"o.lockuser is not null", null, orderby));
		
		request.setAttribute("pageView", pageView);
		request.setAttribute("showButton", true);
		return "success";
	}
	
}

package com.unclewoo.web.action.book;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.regexp.internal.recompile;
import com.unclewoo.bean.PageView;
import com.unclewoo.bean.book.Order;
import com.unclewoo.bean.book.OrderState;
import com.unclewoo.service.book.OrderService;
import com.unclewoo.web.modeldriven.book.OrderModelDriven;

public class OrderListAction extends ActionSupport implements ModelDriven<OrderModelDriven>, ServletRequestAware{
	
	OrderModelDriven orderModelDriven = new OrderModelDriven();

	public OrderModelDriven getModel() {
		return orderModelDriven;
	}
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	@Resource OrderService orderService;
	
	public String execute() throws Exception {
		PageView<Order> pageView = new PageView<Order>(12, orderModelDriven.getPage());
		//如果传递了订单状态state请求参数，那么查询该状态下的订单，否则查询待审核状态的订单
		OrderState state = OrderState.WAITCONFIRM;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("createDate", "asc");
		if("true".equals(orderModelDriven.getQuery())){
			StringBuilder sb = new StringBuilder();
			List<Object> params = new ArrayList<Object>();
			if(orderModelDriven.getOrderid()!=null && !"".equals(orderModelDriven.getOrderid())){
				params.add("%"+orderModelDriven.getOrderid().trim()+"%");
				sb.append("o.orderid like ?").append(params.size());
			}
			if(OrderState.valueOf(orderModelDriven.getState())!=null){
				if(!params.isEmpty())
					sb.append(" and ");
				params.add(OrderState.valueOf(orderModelDriven.getState()));
				sb.append("o.state=?").append(params.size());
			}
			if(orderModelDriven.getUsername()!=null && !"".equals(orderModelDriven.getUsername())){
				if(!params.isEmpty())
					sb.append(" and ");
				params.add("%"+orderModelDriven.getUsername().trim()+"%");
				sb.append("o.buyer.username like ?").append(params.size());
			}
			if(orderModelDriven.getRecipients()!=null && !"".equals(orderModelDriven.getRecipients())){
				if(!params.isEmpty())
					sb.append(" and ");
				params.add("%"+orderModelDriven.getRecipients().trim()+"%");
				sb.append("o.orderDeliverInfo.recipients like ?").append(params.size());
			}
			if(orderModelDriven.getBuyer()!=null && !"".equals(orderModelDriven.getBuyer())){
				if(!params.isEmpty())
					sb.append(" and ");
				params.add("%"+orderModelDriven.getBuyer().trim()+"%");
				sb.append("o.orderContactInfo.buyerName like ?").append(params.size());
			}
			pageView.setQueryResult(orderService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult(),
					sb.toString(), params.toArray(), orderby));
		}else{
			pageView.setQueryResult(orderService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult(),
					"o.state=?1", new Object[]{state}, orderby));
		}
		request.setAttribute("pageView", pageView);
		return "success";
	}	
}

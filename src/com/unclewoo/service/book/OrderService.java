package com.unclewoo.service.book;

import com.unclewoo.bean.BuyCart;
import com.unclewoo.bean.book.Order;
import com.unclewoo.service.base.DAO1;

public interface OrderService extends DAO1<Order>{
	/**
	 * 解锁订单
	 * @param orderids 订单号
	 */
	public void unlock(String... orderids);
	/**
	 * 加锁订单
	 * @param orderid 订单号
	 * @param username 锁定用户
	 * @return
	 */
	public Order addLock(String orderid, String username);
	/**
	 * 生成订单
	 * @param buyCart 购物车
	 * @param username 用户名
	 * @return
	 */
	public Order createOrder(BuyCart buyCart, String username);
	/**
	 * 更新配送费
	 * @param orderid
	 * @param deliverFee
	 */
	public void updateDeliverFee(String orderid, float deliverFee);
	/**
	 * 取消订单
	 * @param orderid 订单号
	 */
	public void cancelOrder(String orderid);
	/**
	 * 审核通过订单
	 * @param orderid 订单号
	 */
	public void confirmOrder(String orderid);
	/**
	 * 财务确认已付款
	 * @param orderid 订单号
	 */
	public void confirmPayment(String orderid);
	/**
	 * 把订单转为等待发货状态
	 * @param orderid 订单号
	 */
	public void turnWaitdeliver(String orderid);
	/**
	 * 把订单转为已发货状态
	 * @param orderid
	 */
	public void turnDelivered(String orderid);
	/**
	 * 把订单转为已收货状态
	 * @param orderid
	 */
	public void turnReceived(String orderid);
}

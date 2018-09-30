package com.unclewoo.service.book;

import com.unclewoo.bean.book.OrderItem;
import com.unclewoo.service.base.DAO1;

public interface OrderItemService extends DAO1<OrderItem>{
	/**
	 * 更新商品购买数量
	 * @param itemid 订单项
	 * @param amount 购买数量
	 */
	public void updateAmount(Integer itemid, int amount);
}

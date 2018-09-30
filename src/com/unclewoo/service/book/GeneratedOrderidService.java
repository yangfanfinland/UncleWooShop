package com.unclewoo.service.book;

import com.unclewoo.bean.book.GeneratedOrderid;
import com.unclewoo.service.base.DAO1;

public interface GeneratedOrderidService extends DAO1<GeneratedOrderid>{
	/**
	 * 生成订单流水号
	 * @return
	 */
	public int buildOrderid();
	
	
	public void init();
}

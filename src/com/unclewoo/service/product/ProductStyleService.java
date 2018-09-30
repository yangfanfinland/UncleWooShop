package com.unclewoo.service.product;

import com.unclewoo.service.base.DAO;

public interface ProductStyleService extends DAO{
	/**
	 * 设置产品样式是否上架
	 * @param productstyleids 产品样式id数组
 	 * @param status  true为上架，false为下架
	 */
	public void setVisibleStatus(Integer[] productstyleids, boolean status);
}

package com.unclewoo.service.product;

import java.util.List;

import com.unclewoo.service.base.DAO;

public interface ProductTypeService extends DAO{
	/**
	 * 获取下级类别的id
	 * @param parentids 父类id数组
	 * @return
	 */
	public List<Integer> getSubTypeid(Integer[] parentids);
}
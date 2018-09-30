package com.unclewoo.service.product;

import java.util.List;

import com.unclewoo.bean.product.Brand;
import com.unclewoo.bean.product.ProductInfo;
import com.unclewoo.service.base.DAO;

public interface ProductInfoService extends DAO{
	/**
	 * 设置产品是否上架
	 * @param productids 产品id数组
 	 * @param status  true为上架，false为下架
	 */
	public void setVisibleStatus(Integer[] productids, boolean status);
	
	/**
	 * 设置产品是否推荐
	 * @param productids 产品id数组
 	 * @param status  true为推荐，false为不推荐
	 */
	public void setCommendStatus(Integer[] productids, boolean status);
	
	/**
	 * 获取类别下产品所使用到的品牌 
	 * @param typeids 产品类别id数组
	 * @return
	 */
	public List<Brand> getBrandsByProductTypeid(Integer[] typeids);
	/**
	 * 获取销量最多的并且被推荐的产品
	 * @param typeid 类别id
	 * @param maxResult 获取的产品数量
	 * @return
	 */
	public List<ProductInfo> getTopSell(Integer typeid, int maxResult);
	/**
	 * 获取指定ID的产品
	 * @param productids 产品id数组
	 * @param maxResult 最大获取多少条记录
	 * @return
	 */
	public List<ProductInfo> getViewHistory(Integer[] productids, int maxResult);
	
}

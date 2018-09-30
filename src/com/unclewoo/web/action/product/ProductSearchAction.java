package com.unclewoo.web.action.product;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.PageView;
import com.unclewoo.bean.product.ProductInfo;
import com.unclewoo.service.product.ProductSearchService;
import com.unclewoo.web.modeldriven.product.ProductQueryModelDriven;
/**
 * 商品搜索
 * @author King
 *
 */
public class ProductSearchAction extends ActionSupport implements ModelDriven<ProductQueryModelDriven>,	
	ServletRequestAware{
	
	@Resource ProductSearchService productSearchService;
	
	ProductQueryModelDriven productQueryModelDriven = new ProductQueryModelDriven();
	@Override
	public ProductQueryModelDriven getModel() {
		return productQueryModelDriven;
	}
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String execute(){
		PageView<ProductInfo> pageView = new PageView<ProductInfo>(18, productQueryModelDriven.getPage());
		pageView.setQueryResult(productSearchService.query(productQueryModelDriven.getWord(), pageView.getFirstResult(), pageView.getMaxresult()));
		request.setAttribute("pageView", pageView);
		return "success";
	}

	
}

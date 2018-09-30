package com.unclewoo.web.action.product;


import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.product.ProductStyle;
import com.unclewoo.service.product.ProductStyleService;
import com.unclewoo.web.modeldriven.product.ProductModelDriven;

public class ProductStyleAction extends ActionSupport implements ModelDriven<ProductModelDriven>{
	
	ProductModelDriven productModelDriven = new ProductModelDriven();
	
	public ProductModelDriven getModel() {
		return productModelDriven;
	}
	
	@Resource(name="productStyleServiceBean")
	private ProductStyleService productStyleService;
	
	
	public String execute() throws Exception {

		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("visible", "desc");
		orderby.put("id", "asc");
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request"); 
		request.put("styles", productStyleService.getScrollData(ProductStyle.class, -1, -1,
				"o.product.id=?1", new Object[]{productModelDriven.getProductid()}, orderby).getResultlist());
		return "success";
	}


	

}

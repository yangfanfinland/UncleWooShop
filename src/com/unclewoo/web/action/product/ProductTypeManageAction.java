package com.unclewoo.web.action.product;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.product.ProductType;
import com.unclewoo.service.product.ProductTypeService;
import com.unclewoo.web.modeldriven.product.ProductTypeModelDriven;

public class ProductTypeManageAction extends ActionSupport implements ModelDriven<ProductTypeModelDriven>{

	@Resource
	private ProductTypeService productTypeService;
	
	ProductTypeModelDriven modelDriven = new ProductTypeModelDriven();
	
	@Override
	public ProductTypeModelDriven getModel() {
		// TODO Auto-generated method stub
		return modelDriven;
	}

	
	/**
	 * 类别添加界面
	 */
	public String addUI() throws Exception{
		return "success";
	}
	/**
	 * 
	 * 类别添加
	 */
	public String add() throws Exception{
		ProductType type = new ProductType(modelDriven.getName(), modelDriven.getNote());
		if(modelDriven.getParentid()!=null && modelDriven.getParentid()>0)
			type.setParent(new ProductType(modelDriven.getParentid()));
		else{
			System.out.println("parent id hasn't get!");
		}
		productTypeService.save(type);
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request"); 
		request.put("message", "Add Category Success!");
		request.put("urladdress", "/control/product/type/list.action");
		return "message";
	}
	
	/**
	 * 类别修改界面
	 */
	public String editUI() throws Exception{
		ProductType type = productTypeService.find(ProductType.class, modelDriven.getTypeid());
		modelDriven.setName(type.getName());
		modelDriven.setNote(type.getNote());
		return "success";
	}
	/**
	 * 类别修改
	 */
	public String edit() throws Exception{
		ProductType type = productTypeService.find(ProductType.class, modelDriven.getTypeid());
		type.setName(modelDriven.getName());
		type.setNote(modelDriven.getNote());
		productTypeService.update(type);
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request"); 
		request.put("message", "Edit Category Success!");
		request.put("urladdress", "/control/product/type/list.action");
		return "message";
	}
	/**
	 * 类别查询界面
	 */
	public String queryUI() throws Exception{
		return "success";
	}
}

package com.unclewoo.web.action.product;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.PageView;
import com.unclewoo.bean.product.Brand;
import com.unclewoo.bean.product.ProductType;
import com.unclewoo.service.product.BrandService;
import com.unclewoo.web.modeldriven.product.BrandModelDriven;

public class BrandAction extends ActionSupport implements ModelDriven<BrandModelDriven>{
	
	@Resource(name="brandServiceBean")
	private BrandService brandService;
	

	BrandModelDriven brandModelDriven = new BrandModelDriven();
	
	@Override
	public BrandModelDriven getModel() {
		
		return brandModelDriven;
	}
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String execute() throws Exception {
		StringBuffer jpql = new StringBuffer("o.visible=?1");
		List<Object> params = new ArrayList<Object>();
		params.add(true);
		if("true".equals(brandModelDriven.getQuery())){
			jpql.append(" and o.name like ?"+ (params.size()+1));
			params.add("%"+ name +"%");
		}
		PageView<Brand> pageView = new PageView<Brand>(12, brandModelDriven.getPage());
		int firstindex = (brandModelDriven.getPage()-1)*pageView.getMaxresult();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("code", "desc");
		pageView.setQueryResult(brandService.getScrollData(Brand.class, firstindex, pageView.getMaxresult(), jpql.toString(), params.toArray(), orderby));
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request"); 
		request.put("pageView", pageView);
		
		return "success";
	}

	

}

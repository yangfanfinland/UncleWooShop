package com.unclewoo.web.action.product;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.PageIndex;
import com.unclewoo.bean.PageView;
import com.unclewoo.bean.QueryResult;
import com.unclewoo.bean.WebTool;
import com.unclewoo.bean.product.ProductType;
import com.unclewoo.service.product.ProductTypeService;
import com.unclewoo.web.modeldriven.product.ProductTypeModelDriven;


public class ProductTypeAction extends ActionSupport implements ModelDriven<ProductTypeModelDriven>{
	
	@Resource 
	ProductTypeService productTypeService;

	ProductTypeModelDriven modelDriven = new ProductTypeModelDriven();
	
	@Override
	public ProductTypeModelDriven getModel() {
		// TODO Auto-generated method stub
		return modelDriven;
	}
	

	
	public String execute() throws Exception {
		
		StringBuffer jpql = new StringBuffer("o.visible=?1");
		List<Object> params = new ArrayList<Object>();
		params.add(true);
		if("true".equals(modelDriven.getQuery())){//进行查询操作
			if(modelDriven.getName()!=null && !"".equals(modelDriven.getName().trim())){
				jpql.append(" and o.name like ?"+(params.size()+1));
				params.add("%"+ modelDriven.getName() +"%");
			}
			
		}else{
			if(modelDriven.getParentid()!=null&&modelDriven.getParentid()>0){
				jpql.append(" and o.parent.typeid=?"+(params.size()+1));
				params.add(modelDriven.getParentid());
			}else{
				jpql.append(" and o.parent is null");
			}
			
		}
		
		PageView<ProductType> pageView = new PageView<ProductType>(12, modelDriven.getPage());
		int firstindex = (modelDriven.getPage()-1)*pageView.getMaxresult();
		//System.out.println(modelDriven.getPage());
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("typeid", "desc");
		QueryResult<ProductType> qr = productTypeService.getScrollData(ProductType.class,
				firstindex, pageView.getMaxresult(), jpql.toString(), params.toArray(), orderby);
		pageView.setQueryResult(qr);
		
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request"); 
		request.put("pageView", pageView);
		
		
		/*
		//get HttpServletRequest 
		Map<String,Object> request = (Map) actionContext.get("request"); 
		request.put("a", productType); 
		         
		//get HttpSession 
		//Map<String,Object> session = (Map) actionContext.get("session"); 
		Map<String,Object> session = actionContext.getSession(); 
		session.put("b", productType); 
		          
		//get ServletContext 
		//Map<String,Object> application  = (Map) actionContext.get("application"); 
		Map<String,Object> application  = actionContext.getApplication(); 
		application.put("c", productType);
		*/
		return "success";
	}


	
}

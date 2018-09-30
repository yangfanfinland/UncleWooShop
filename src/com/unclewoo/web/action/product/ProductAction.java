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
import com.unclewoo.bean.product.ProductInfo;
import com.unclewoo.service.product.ProductInfoService;
import com.unclewoo.web.modeldriven.product.ProductModelDriven;

public class ProductAction extends ActionSupport implements ModelDriven<ProductModelDriven>{
	ProductModelDriven productModelDriven = new ProductModelDriven();
	
	@Override
	public ProductModelDriven getModel() {
		return productModelDriven;
	}
	
	
	@Resource(name="productInfoService")
	private ProductInfoService productInfoService;

	@Override
	public String execute() throws Exception {
		
		PageView<ProductInfo> pageView = new PageView<ProductInfo>(12, productModelDriven.getPage());
		int firstindex = (productModelDriven.getPage()-1)*pageView.getMaxresult();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("visible", "desc");
		orderby.put("id", "desc");
		
		if("true".equals(productModelDriven.getQuery())){
			StringBuffer jpql = new StringBuffer("");
			List<Object> params = new ArrayList<Object>();
			//按产品名称查询
			if(productModelDriven.getName()!=null && !"".equals(productModelDriven.getName())){
				if(params.size()>0)
					jpql.append(" and ");
				jpql.append(" o.name like ?").append((params.size()+1));
				params.add("%"+productModelDriven.getName()+"%");
			}
			//按产品类型查询
			if(productModelDriven.getTypeid()!=null&&productModelDriven.getTypeid()>0){
				if(params.size()>0)
					jpql.append(" and ");
				jpql.append(" o.producttype.typeid=?").append((params.size()+1));
				params.add(productModelDriven.getTypeid());
			}
			//按采购价区间查询
			if(productModelDriven.getStartbaseprice()>0){
				if(params.size()>0)
					jpql.append(" and ");
				jpql.append(" o.baseprice>=?").append((params.size()+1));
				params.add(productModelDriven.getStartbaseprice());
			}
			if(productModelDriven.getEndbaseprice()>0){
				if(params.size()>0)
					jpql.append(" and ");
				jpql.append(" o.baseprice<=?").append((params.size()+1));
				params.add(productModelDriven.getEndbaseprice());
			}
			//按销售价区间查询
			if(productModelDriven.getStartsellprice()>0){
				if(params.size()>0)
					jpql.append(" and ");
				jpql.append(" o.sellprice>=?").append((params.size()+1));
				params.add(productModelDriven.getStartsellprice());
			}
			if(productModelDriven.getEndsellprice()>0){
				if(params.size()>0)
					jpql.append(" and ");
				jpql.append(" o.sellprice<=?").append((params.size()+1));
				params.add(productModelDriven.getEndsellprice());
			}
			//按货号查询
			if(productModelDriven.getCode()!=null && !"".equals(productModelDriven.getCode())){
				if(params.size()>0)
					jpql.append(" and ");
				jpql.append(" o.code= ?").append((params.size()+1));
				params.add(productModelDriven.getCode());
			}
			//按品牌查询
			if(productModelDriven.getBrandid()!=null && !"".equals(productModelDriven.getBrandid())){
				if(params.size()>0)
					jpql.append(" and ");
				jpql.append(" o.brand.code= ?").append((params.size()+1));
				params.add(productModelDriven.getBrandid());
			}
			pageView.setQueryResult(productInfoService.getScrollData(ProductInfo.class, firstindex, pageView.getMaxresult(), jpql.toString(), params.toArray(), orderby));
		}else{
			pageView.setQueryResult(productInfoService.getScrollData(ProductInfo.class, firstindex, pageView.getMaxresult(), orderby));
		}
		
		
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request"); 
		request.put("pageView", pageView);
		return "success";
	}

	
	
	
}

package com.unclewoo.web.action.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.PageView;
import com.unclewoo.bean.product.ProductInfo;
import com.unclewoo.bean.product.ProductStyle;
import com.unclewoo.bean.product.ProductType;
import com.unclewoo.bean.product.Sex;
import com.unclewoo.service.product.ProductInfoService;
import com.unclewoo.service.product.ProductTypeService;
import com.unclewoo.utils.WebUtil;
import com.unclewoo.web.modeldriven.product.FrontProductModelDriven;


public class FrontProductAction extends ActionSupport  implements ModelDriven<FrontProductModelDriven>{
	FrontProductModelDriven frontProductModelDriven = new FrontProductModelDriven();
	
	@Override
	public FrontProductModelDriven getModel() {
		return frontProductModelDriven;
	}
	
	
	@Resource(name="productInfoService")
	private ProductInfoService productInfoService;
	
	@Resource(name="productTypeServiceBean")
	private ProductTypeService productTypeService;

	@Override
	public String execute() throws Exception {
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request"); 
		
		PageView<ProductInfo> pageView = new PageView<ProductInfo>(2, frontProductModelDriven.getPage());
		pageView.setPagecode(20);
		int firstindex = (frontProductModelDriven.getPage()-1)*pageView.getMaxresult();
		LinkedHashMap<String, String> orderby = buildOrder(frontProductModelDriven.getSort());
		/*
		orderby.put("createdate", "desc");
		orderby.put("id", "desc");
		*/
		StringBuffer jpql = new StringBuffer("o.visible=?1");
		List<Object> params = new ArrayList<Object>();
		params.add(true);

		List<Integer> typeids = new ArrayList<Integer>();
		typeids.add(frontProductModelDriven.getTypeid());
		getTypeids(typeids, new Integer[]{frontProductModelDriven.getTypeid()});
		StringBuffer n = new StringBuffer();
		for(int i=0; i<typeids.size();i++){
			n.append('?').append((i+2)).append(',');
		}
		n.deleteCharAt(n.length()-1);
		jpql.append(" and o.producttype.typeid in("+ n.toString() +")");
		params.addAll(typeids);
		
		
		if(frontProductModelDriven.getBrandid()!=null && !"".equals(frontProductModelDriven.getBrandid().trim())){
			jpql.append(" and o.brand.code=?").append((params.size()+1));
			params.add(frontProductModelDriven.getBrandid());
		}
		
		if(frontProductModelDriven.getSex()!=null){
			String sex = frontProductModelDriven.getSex().trim();
			if("NONE".equalsIgnoreCase(sex) || "MAN".equalsIgnoreCase(sex) || "WOMEN".equalsIgnoreCase(sex)){
				jpql.append(" and o.sexrequest=?").append((params.size()+1));
				params.add(Sex.valueOf(frontProductModelDriven.getSex()));
			}
		}
		
		
		pageView.setQueryResult(productInfoService.getScrollData(ProductInfo.class, firstindex, 
				pageView.getMaxresult(), jpql.toString(), params.toArray(), orderby));
		for(ProductInfo product : pageView.getRecords()){
			Set<ProductStyle> styles = new HashSet<ProductStyle>();
			for(ProductStyle style : product.getStyles()){
				if(style.getVisible()){
					styles.add(style);
					break;
				}
			}
			
			product.setStyles(styles);
			//注意:执行此句代码会把修改后的数据同步回数据库，如果不想同步回数据库，请在其后调用productInfoService.clear();清除数据库一级缓存
			product.setDescription(WebUtil.HtmltoText(product.getDescription()));
			
		}
		productInfoService.clear();//让托管状态的实体成为游离状态
		request.put("pageView", pageView);
		Integer[] ids = new Integer[typeids.size()];
		for(int i=0; i<typeids.size(); i++){
			ids[i]=typeids.get(i);
		}
		request.put("brands", productInfoService.getBrandsByProductTypeid(ids));
		ProductType type = productInfoService.find(ProductType.class, frontProductModelDriven.getTypeid());
		List<ProductType> types = new ArrayList<ProductType>();
		types.add(type);
		ProductType parent = type.getParent();
		while(parent!=null){
			types.add(parent);
			parent = parent.getParent();
		}
		request.put("producttype", type);
		request.put("types", types);
		return getView(frontProductModelDriven.getStyle());
	}
	
	/**
	 * 获取显示视图
	 * @param style 样式
	 * @return
	 */
	public String getView(String style){
		if("imagetext".equalsIgnoreCase(style))
			return "list_imagetext";//图文版
		else
			return "list_image";//图片版
	}
	
	
	/**
	 * 获取类别下所有子类的id（注 :子类及其子类的id都会取到）递归
	 * @param outtypeids
	 * @param typeids
	 */
	public void getTypeids(List<Integer> outtypeids, Integer[] typeids){
		List<Integer> subtypeids = productTypeService.getSubTypeid(typeids);
		if(subtypeids!=null && subtypeids.size()>0){
			outtypeids.addAll(subtypeids);
			Integer[] ids = new Integer[subtypeids.size()];
			for(int i=0; i<subtypeids.size(); i++){
				ids[i]=subtypeids.get(i);
			}
			getTypeids(outtypeids, ids);
		}
		
	}
	
	/**
	 * 组拼排序
	 * @param orderfield
	 * @return
	 */
	private LinkedHashMap<String, String> buildOrder(String orderfield){
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if("selldesc".equals(orderfield)){
			orderby.put("sellcount", "desc");
		}else if("sellpricedesc".equals(orderfield)){
			orderby.put("sellprice", "desc");
		}else if("sellpriceasc".equals(orderfield)){
			orderby.put("sellprice", "asc");
		}else{
			orderby.put("createdate", "desc");
		}
		return orderby;
	}
}

package com.unclewoo.web.action.product;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.product.ProductInfo;
import com.unclewoo.bean.product.ProductType;
import com.unclewoo.service.product.ProductInfoService;
import com.unclewoo.service.product.ProductTypeService;
import com.unclewoo.utils.WebUtil;
import com.unclewoo.web.modeldriven.product.FrontProductModelDriven;


public class ViewProductAction extends ActionSupport implements ModelDriven<FrontProductModelDriven>, ServletRequestAware,  ServletResponseAware, SessionAware{
	FrontProductModelDriven frontProductModelDriven = new FrontProductModelDriven();
	
	@Override
	public FrontProductModelDriven getModel() {
		return frontProductModelDriven;
	}
	
	@Resource(name="productInfoService")
	private ProductInfoService productInfoService;
	
	private HttpServletResponse response;  
	private HttpServletRequest request;
	private Map session; 
	
	public void setSession(Map session) {
		this.session = session;  
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response; 
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
	public String execute() throws Exception {
		
		ProductInfo product = productInfoService.find(ProductInfo.class, frontProductModelDriven.getProductid());
		if(product==null){
			request.setAttribute("message", "获取不到你需要浏览的产品");
			request.setAttribute("urladdress", "/");
			return "message";
		}
		WebUtil.addCookie(response, "productViewHistory",
				buildViewHistory(request, frontProductModelDriven.getProductid()), 30*24*60*60);
		
		List<ProductType> stypes = new ArrayList<ProductType>();
		ProductType parent = product.getProducttype();
		while(parent!=null){
			stypes.add(parent);
			parent = parent.getParent();
		}
		
		request.setAttribute("product", product);
		request.setAttribute("stypes", stypes);
		return "success";
	}
	
	public String buildViewHistory(HttpServletRequest request, Integer currentProductId){
		//23-2-6-5
		//1.如果当前浏览的id已经在浏览历史里，我们要把移到最前面
		//2.如果浏览历史里已经得到了10个产品，我们需要把最先进入的元素删除
		String cookieValue = WebUtil.getCookieByName(request, "productViewHistory");
		LinkedList<Integer> productids = new LinkedList<Integer>();
		if(cookieValue!=null&&!"".equals(cookieValue.trim())){
			String[] ids = cookieValue.split("-");
			
			for(String id : ids){
				productids.offer(new Integer(id.trim()));
			}
			if(productids.contains(currentProductId))
				productids.remove(currentProductId);
			if(productids.size()>=2)
				productids.poll();
		}
		productids.offer(currentProductId);
		StringBuffer out = new StringBuffer();
		for(Integer id : productids){
			out.append(id).append('-');
		}
		out.deleteCharAt(out.length()-1);
		
		return out.toString();
	}
}


















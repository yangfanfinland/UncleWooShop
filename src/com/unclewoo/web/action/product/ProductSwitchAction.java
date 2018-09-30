package com.unclewoo.web.action.product;

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
import com.unclewoo.service.product.ProductInfoService;
import com.unclewoo.utils.WebUtil;
import com.unclewoo.web.modeldriven.product.FrontProductModelDriven;

public class ProductSwitchAction extends ActionSupport implements ModelDriven<FrontProductModelDriven>, ServletRequestAware,  ServletResponseAware, SessionAware{
	
	FrontProductModelDriven frontProductModelDriven = new FrontProductModelDriven();
	@Override
	public FrontProductModelDriven getModel() {
		return frontProductModelDriven;
	}
	
	@Resource(name="productInfoService")
	private ProductInfoService productInfoService;
	
	public String showimage(){
		return "success";
	}
	
	
	/**
	 * 获取10个最畅销的产品
	 * @return
	 */
	public String topsell(){
		
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request"); 
		request.put("topsellproducts", productInfoService.getTopSell(frontProductModelDriven.getTypeid(), 10));
		return "success";
	}

	/**
	 * 获取10个用户浏览过的的产品
	 * @return
	 */
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
	
	public String getViewHistory(){
		//12-45-67-89
		String cookieValue = WebUtil.getCookieByName(request, "productViewHistory");
		if(cookieValue!=null && !"".equals(cookieValue.trim())){
			String[] ids = cookieValue.split("-");
			Integer[] productids = new Integer[ids.length];
			for(int i=0; i<ids.length; i++){
				productids[i]=new Integer(ids[i].trim());
			}
			request.setAttribute("viewHistory", productInfoService.getViewHistory(productids, 10));
		}
		return "success";
	}

	
}

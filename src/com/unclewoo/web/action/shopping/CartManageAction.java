package com.unclewoo.web.action.shopping;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.xerces.impl.dv.util.Base64;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.BuyCart;
import com.unclewoo.bean.BuyItem;
import com.unclewoo.bean.product.ProductInfo;
import com.unclewoo.bean.product.ProductStyle;
import com.unclewoo.web.modeldriven.shopping.CartModelDriven;

public class CartManageAction extends ActionSupport implements ModelDriven<CartModelDriven>, ServletRequestAware,  ServletResponseAware, SessionAware{
	
	CartModelDriven cartModelDriven = new CartModelDriven();

	public CartModelDriven getModel() {
		return cartModelDriven;
	}
	
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
	
	private BuyCart getBuyCart(HttpServletRequest request){
		return (BuyCart)request.getSession().getAttribute("buycart");
	}
	
	/**
	 * 删除指定购买项
	 * @return
	 */
	public String delete(){
		BuyCart buyCart = getBuyCart(request);
		if(buyCart != null){
			ProductInfo product = new ProductInfo(cartModelDriven.getProductid());
			product.addProductStyle(new ProductStyle(cartModelDriven.getStyleid()));
			buyCart.removeBuyItem(new BuyItem(product));
		}
		String param = cartModelDriven.getDirectUrl()!=null && !"".equals(cartModelDriven.getDirectUrl()) ? "?directUrl="+cartModelDriven.getDirectUrl() : "";
		request.setAttribute("directUrl", "/center/shopping/cart.action" + param);
		return "success";
	}

	/**
	 * 删除所有购买项
	 * 清空购物车
	 * @return
	 */
	public String deleteAll(){
		BuyCart buyCart = getBuyCart(request);
		if(buyCart != null){
			buyCart.removeAll();
		}
		String param = cartModelDriven.getDirectUrl()!=null && !"".equals(cartModelDriven.getDirectUrl()) ? "?directUrl="+cartModelDriven.getDirectUrl() : "";
		request.setAttribute("directUrl", "/center/shopping/cart.action" + param);
		return "success";
	}
	
	/**
	 * 更新所有购买项的数量
	 * @return
	 */
	public String updateAmount(){
		BuyCart buyCart = getBuyCart(request);
		if(buyCart != null){
			for(BuyItem item : buyCart.getItems()){
				StringBuffer key = new StringBuffer("amount_");
				key.append(item.getProduct().getId()).append('_');
				if(item.getProduct().getStyles().size()>0){
					key.append(item.getProduct().getStyles().iterator().next().getId());
				}
				String amountStr = request.getParameter(key.toString());
				if(amountStr!=null && !"".equals(amountStr)){
					try {
						int amount = Integer.parseInt(amountStr);
						if(amount>0)
							item.setAmount(amount);
					} catch (RuntimeException e) {
					}
				}
			}
		}
		String param = cartModelDriven.getDirectUrl()!=null && !"".equals(cartModelDriven.getDirectUrl()) ? "?directUrl="+cartModelDriven.getDirectUrl() : "";
		request.setAttribute("directUrl", "/center/shopping/cart.action" + param);
		return "success";
	}
	
	/**
	 * 结算
	 * @return
	 */
	public String settleaccounts(){
		
		//ActionContext ctx = ActionContext.getContext();
		
		BuyCart buyCart = getBuyCart(request);
		if(buyCart != null){
			for(BuyItem item : buyCart.getItems()){
				StringBuffer key = new StringBuffer("amount_");
				key.append(item.getProduct().getId()).append('_');
				if(item.getProduct().getStyles().size()>0){
					key.append(item.getProduct().getStyles().iterator().next().getId());
				}
				String amountStr = request.getParameter(key.toString());
				if(amountStr!=null && !"".equals(amountStr)){
					try {
						int amount = Integer.parseInt(amountStr);
						if(amount>0)
							item.setAmount(amount);
					} catch (RuntimeException e) {
					}
				}
			}
		}
		
		//ctx.put("urladdress", "/customer/shopping/deliver.action");
		String url = "/customer/shopping/deliver.action";
		if(cartModelDriven.getDirectUrl()!=null && !"".equals(cartModelDriven.getDirectUrl())){
			url = new String(Base64.decode(cartModelDriven.getDirectUrl().trim()));//获取解码后的路径
		}
		request.setAttribute("directUrl", url);
		return "success";
	}
	
}

package com.unclewoo.web.action.shopping;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.BuyCart;
import com.unclewoo.bean.BuyItem;
import com.unclewoo.bean.product.ProductInfo;
import com.unclewoo.bean.product.ProductStyle;
import com.unclewoo.service.product.ProductInfoService;
import com.unclewoo.utils.WebUtil;
import com.unclewoo.web.modeldriven.shopping.CartModelDriven;

public class CartAction extends ActionSupport implements ModelDriven<CartModelDriven>,ServletRequestAware,  ServletResponseAware, SessionAware{

	CartModelDriven cartModelDriven = new CartModelDriven();
	
	public CartModelDriven getModel() {
		return cartModelDriven;
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
	
	public String execute(){
		BuyCart buyCart = (BuyCart)request.getSession().getAttribute("buycart");
		if(buyCart == null){//如果当前session不存在购物车，就访问以前用户session里的购物车(一般是因为用户重新打开了一个浏览器，导致创建了一个新session)
			String sid = WebUtil.getCookieByName(request, "buyCartID");
			if(sid != null){
				HttpSession session = SiteSessioListener.getSession(sid);
				if(session != null){
					buyCart = (BuyCart)session.getAttribute("buycart");
					if(buyCart!=null){
						SiteSessioListener.removeSession(sid);
						request.getSession().setAttribute("buycart", buyCart);
						WebUtil.addCookie(response, "buyCartID", request.getSession().getId(),
								request.getSession().getMaxInactiveInterval());
					}
				}
			}
		}
		if(buyCart==null){
			buyCart = new BuyCart();
			request.getSession().setAttribute("buycart", buyCart);
			WebUtil.addCookie(response, "buyCartID", request.getSession().getId(),
					request.getSession().getMaxInactiveInterval());
		}
		if(cartModelDriven.getProductid()!=null && cartModelDriven.getProductid()>0){//往购物车添加商品
			ProductInfo product = productInfoService.find(ProductInfo.class, cartModelDriven.getProductid());
			
			if(product != null){
				ProductStyle currentStyle = null;
				for(ProductStyle style : product.getStyles()){//找到对应样式id，得到用户选择的样式
					if(style.getVisible() && style.getId().equals(cartModelDriven.getStyleid())){
						currentStyle = style;
						break;
					}
				}
				product.getStyles().clear();//清除所有样式，谈后放入被选样式
				if(currentStyle != null)
					product.addProductStyle(currentStyle);//只存放用户当前选择的样式
				buyCart.addItem(new BuyItem(product, 1));//把商品放入购物车
			}
		}
		
		request.getSession().setAttribute("buyCart", buyCart);
		return "success";
	}

	
}

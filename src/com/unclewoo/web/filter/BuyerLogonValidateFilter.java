package com.unclewoo.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.xerces.impl.dv.util.Base64;

import com.unclewoo.bean.user.Buyer;
import com.unclewoo.utils.WebUtil;

public class BuyerLogonValidateFilter implements Filter{

	public void destroy() {
	}
	
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		Buyer buyer = WebUtil.getBuyer(request);
		if(buyer == null){
			String url = WebUtil.getRequestURIWithParam(request);//1.得到当前请求参数
			String directUrl = new String(Base64.encode(url.getBytes()));//2.对进行编码
			HttpServletResponse response = (HttpServletResponse)res;
			//3.把编码的路径作为请求参数附带到登录路径上
			response.sendRedirect("/UncleWooShop/center/user/login/logUI.action?directUrl="+directUrl);
		}else{
			chain.doFilter(req, res);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}

package com.unclewoo.web.action.user;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.PageView;
import com.unclewoo.bean.user.Buyer;
import com.unclewoo.service.user.BuyerService;
import com.unclewoo.web.modeldriven.user.BuyerModelDriven;

/**
 * 用户分页列表
 * @author King
 *
 */
public class BuyerListAction extends ActionSupport implements ModelDriven<BuyerModelDriven>{

	BuyerModelDriven buyerModelDriven = new BuyerModelDriven();
	
	public BuyerModelDriven getModel() {
		return buyerModelDriven;
	}
	
	@Resource BuyerService buyerService;
	
	public String execute(){
		ActionContext ctx = ActionContext.getContext();
		
		PageView<Buyer> pageView = new PageView<Buyer>(12, buyerModelDriven.getPage());
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("regTime", "desc");
		if("true".equals(buyerModelDriven.getQuery())){//如果来源于查询界面，执行下面代码
			StringBuffer sb = new StringBuffer();
			List<Object> params = new ArrayList<Object>();
			if(buyerModelDriven.getUsername()!=null && !"".equals(buyerModelDriven.getUsername().trim())){
				params.add("%"+ buyerModelDriven.getUsername().trim() +"%");
				sb.append("o.username like ?").append(params.size());
			}
			if(buyerModelDriven.getRealname()!=null && !"".equals(buyerModelDriven.getRealname().trim())){
				if(!params.isEmpty())
					sb.append(" and ");
				params.add("%"+ buyerModelDriven.getRealname().trim() +"%");
				sb.append("o.realname like ?").append(params.size());
			}
			if(buyerModelDriven.getEmail()!=null && !"".equals(buyerModelDriven.getEmail().trim())){
				if(!params.isEmpty())
					sb.append(" and ");
				params.add("%"+ buyerModelDriven.getEmail().trim() +"%");
				sb.append("o.email like ?").append(params.size());
			}
			pageView.setQueryResult(buyerService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult(),
					sb.toString(), params.toArray(), orderby));
		}else{
			pageView.setQueryResult(buyerService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult(), orderby));
		}
		ctx.put("pageView", pageView);
		return "success";
	}

	
}

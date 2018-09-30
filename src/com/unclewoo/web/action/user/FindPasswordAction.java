package com.unclewoo.web.action.user;

import java.io.StringWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.user.Buyer;
import com.unclewoo.mail.EmailSender;
import com.unclewoo.service.user.BuyerService;
import com.unclewoo.utils.MD5;
import com.unclewoo.web.modeldriven.user.BuyerModelDriven;

/**
 * 找回密码
 * @author King
 *
 */
public class FindPasswordAction extends ActionSupport implements ModelDriven<BuyerModelDriven>, ServletRequestAware{
	@Resource BuyerService buyerService;
	
	BuyerModelDriven buyerModelDriven = new BuyerModelDriven();
	public BuyerModelDriven getModel() {
		return buyerModelDriven;
	}
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	/**
	 * 找回密码之发送电子邮件
	 * @return
	 * @throws Exception
	 */
	public String getpassword() throws Exception{
		if(buyerModelDriven.getUsername()!=null && !"".equals(buyerModelDriven.getUsername().trim())){
			if(buyerService.exist(buyerModelDriven.getUsername().trim())){
				Buyer buyer = buyerService.find(buyerModelDriven.getUsername().trim());
				Template template = Velocity.getTemplate("mailContent.html");
				VelocityContext context = new VelocityContext();
				context.put("username", buyer.getUsername());
				context.put("validateCode", MD5.MD5Encode(buyer.getUsername()+buyer.getPassword()));
				StringWriter writer = new StringWriter();
				template.merge(context, writer);
				String content = writer.toString();
				EmailSender.send(buyer.getEmail(), "UncleWoo Find Password Back", content, "text/html");
				return "success";
			}else{
				request.setAttribute("message", "用户名不存在");
			}
		}else{
			request.setAttribute("message", "请输入用户名");
		}
		return "message";
	}
	
	/**
	 * 找回密码之显示密码修改界面
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		if(buyerModelDriven.getUsername()!=null && !"".equals(buyerModelDriven.getUsername().trim())){
			if(buyerService.exist(buyerModelDriven.getUsername().trim())){
				Buyer buyer = buyerService.find(buyerModelDriven.getUsername().trim());
				String code = MD5.MD5Encode(buyer.getUsername()+buyer.getPassword());
				if(code.equals(buyerModelDriven.getValidateCode())){//校验通过，表示来源合法
					return "success";
				}
			}
		}
		return "error";
	}
	
	/**
	 * 找回密码之修改密码
	 * @return
	 * @throws Exception
	 */
	public String changepassword() throws Exception{
		if(buyerModelDriven.getUsername()!=null && !"".equals(buyerModelDriven.getUsername().trim())){
			if(buyerService.exist(buyerModelDriven.getUsername().trim())){
				Buyer buyer = buyerService.find(buyerModelDriven.getUsername().trim());
				String code = MD5.MD5Encode(buyer.getUsername()+buyer.getPassword());
				if(code.equals(buyerModelDriven.getValidateCode())){//校验通过，表示来源合法
					buyerService.updatePassword(buyer.getUsername(), buyerModelDriven.getPassword());
					
					request.setAttribute("message", "密码修改成功");
					request.setAttribute("urladdress", "/center/user/login/logUI.action");
					return "message";
				}
			}
		}
		return "error";
	}
}

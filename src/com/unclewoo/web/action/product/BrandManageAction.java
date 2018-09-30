package com.unclewoo.web.action.product;

import java.io.File;

import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.product.Brand;
import com.unclewoo.bean.product.ProductInfo;
import com.unclewoo.bean.product.ProductType;
import com.unclewoo.service.product.BrandService;
import com.unclewoo.utils.SiteUrl;
import com.unclewoo.web.modeldriven.product.BrandModelDriven;

public class BrandManageAction extends ActionSupport{
		
	@Resource(name="brandServiceBean")
	private BrandService brandService;
	
	
	/**
	 * 品牌添加界面
	 */
	public String addUI() throws Exception{
		return "success";
	}
	/**
	 * 
	 * 品牌添加
	 */
	
	private File logofile;
	private String logofileFileName;//struts2 默认命名规范，必须是      "xxxxFileName"
	private String name;
	private String code;
	
	public File getLogofile() {
		return logofile;
	}

	public void setLogofile(File logofile) {
		this.logofile = logofile;
	}

	public String getLogofileFileName() {
		return logofileFileName;
	}

	public void setLogofileFileName(String logofileFileName) {
		this.logofileFileName = logofileFileName;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String add() throws Exception{
		Brand brand = new Brand();
		
		String logopathdir ="/images/logo";
		String logorealpathdir = ServletActionContext.getServletContext().getRealPath(logopathdir);
		if(logofile!=null){
			File logosavedir = new File(logorealpathdir);
			if(!logosavedir.getParentFile().exists())
				logosavedir.mkdirs();
			String ext = logofileFileName.substring(logofileFileName.lastIndexOf("."));
			String imagename = UUID.randomUUID().toString() + ext;
			String logopath = logopathdir + "/" + imagename;
			File savefile = new File(logosavedir,imagename);
			FileUtils.copyFile(logofile, savefile);
			
			brand.setLogopath(logopath);
			System.out.println(logopath);
			System.out.println(logorealpathdir+"/"+imagename);
		}
		if(name!=null&&!name.trim().equals("")){
			brand.setName(name);
		}
		
		System.out.println(name);
		
		
		brandService.save(brand);
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request"); 
		request.put("message", "Add Brand Success!");
		request.put("urladdress", SiteUrl.readUrl("control.product.brand.list"));
		return "message";
	}

	/**
	 * 品牌修改界面
	 */
	public String editUI() throws Exception{
		
		Brand brand = brandService.find(Brand.class, code);
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request");
		request.put("brandname", brand.getName());
		
		return "success";
	}
	
	/**
	 * 品牌修改
	 */
	public String edit() throws Exception{
		//System.out.println(code);
		Brand brand = brandService.find(Brand.class, code);
		String logopathdir ="/images";
		String logorealpathdir = ServletActionContext.getServletContext().getRealPath(logopathdir);
		if(logofile!=null){
			File logosavedir = new File(logorealpathdir);
			if(!logosavedir.getParentFile().exists())
				logosavedir.mkdirs();
			String ext = logofileFileName.substring(logofileFileName.lastIndexOf("."));
			String imagename = UUID.randomUUID().toString() + ext;
			String logopath = logopathdir + "/" + imagename;
			File savefile = new File(logosavedir,imagename);
			FileUtils.copyFile(logofile, savefile);
			
			brand.setLogopath(logopath);
		}
		if(name!=null&&!name.trim().equals("")){
			brand.setName(name);
		}
		brandService.update(brand);
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request"); 
		request.put("message", "Edit Brand Success!");
		request.put("urladdress", SiteUrl.readUrl("control.product.brand.list"));
		
		return "message";
	}
	
	/**
	 * 品牌查询界面
	 */
	public String queryUI() throws Exception{
		return "success";
	}
	
}

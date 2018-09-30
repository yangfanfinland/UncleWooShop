package com.unclewoo.web.action.product;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.unclewoo.bean.product.ProductInfo;
import com.unclewoo.bean.product.ProductStyle;
import com.unclewoo.service.product.ProductInfoService;
import com.unclewoo.service.product.ProductStyleService;
import com.unclewoo.utils.ImageSizer;
import com.unclewoo.utils.SiteUrl;

public class ProductStyleManageAction extends ActionSupport{
	
	@Resource(name="productInfoServiceBean")
	private ProductInfoService productInfoService;
	
	@Resource(name="productStyleServiceBean")
	private ProductStyleService productStyleService;
	
	private String stylename;
	private File imagefile;
	private String imagefileFileName;
	private Integer productid;
	private Integer productstyleid;
	private Integer[] stylesids;
	
	public String getStylename() {
		return stylename;
	}
	public void setStylename(String stylename) {
		this.stylename = stylename;
	}
	public File getImagefile() {
		return imagefile;
	}
	public void setImagefile(File imagefile) {
		this.imagefile = imagefile;
	}
	public String getImagefileFileName() {
		return imagefileFileName;
	}
	public void setImagefileFileName(String imagefileFileName) {
		this.imagefileFileName = imagefileFileName;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public Integer getProductstyleid() {
		return productstyleid;
	}
	public void setProductstyleid(Integer productstyleid) {
		this.productstyleid = productstyleid;
	}
	public Integer[] getStylesids() {
		return stylesids;
	}
	public void setStylesids(Integer[] stylesids) {
		this.stylesids = stylesids;
	}
	/**
	 * 产品图片添加界面
	 */
	public String addUI(){
		
		return "success";
	}
	/**
	 * 产品图片添加
	 */
	public String add(){
		ProductInfo product = productInfoService.find(ProductInfo.class, productid);
		
		/*
		String pathdir ="/images/product/"+ product.getProducttype().getTypeid() + "/" + product.getId() + "/prototype";	
		String realpathdir = ServletActionContext.getServletContext().getRealPath(pathdir);
		if(imagefile!=null){
			File savedir = new File(realpathdir);
			if(!savedir.getParentFile().exists())
				savedir.mkdirs();
			String ext = imagefileFileName.substring(imagefileFileName.lastIndexOf("."));
			String imagename = UUID.randomUUID().toString() + ext;
			
			ProductStyle productStyle = new ProductStyle(stylename, imagename);
			productStyle.setProduct(product);
			
			String path = pathdir + "/" + imagename;
			File savefile = new File(savedir,imagename);
			try {
				FileUtils.copyFile(imagefile, savefile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			productStyleService.save(productStyle);
			
			System.out.println(path);
			System.out.println(realpathdir+"/"+imagename);
			
		}
		*/
		
		ProductStyleManageAction psma = new ProductStyleManageAction();
		String imagename = psma.saveProductImageFile(imagefileFileName, imagefile,
				product.getProducttype().getTypeid(), product.getId());
		ProductStyle productStyle = new ProductStyle(stylename, imagename);
		productStyle.setProduct(product);
		productStyleService.save(productStyle);
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request"); 
		request.put("message", "Add Style Image Success!");
		request.put("urladdress", SiteUrl.readUrl("control.product.style.list")+"?productid="+product.getId());
		return "message";
	}
	
	/**
	 * 保存产品图片方法
	 * @param imagefileFileName 上传的产品图片名称
	 * @param imagefile 上传产品图片
	 * @param productTypeId  产品类型id
	 * @param productId 产品id
	 * @return
	 */
	public String saveProductImageFile(String imagefileFileName, File imagefile, Integer productTypeId, Integer productId){
		String ext = imagefileFileName.substring(imagefileFileName.lastIndexOf("."));
		String imagename = UUID.randomUUID().toString() + ext;//构建文件名称
		String pathdir ="/images/product/"+ productTypeId + "/" + productId + "/prototype";	//构建文件保存目录
		String realpathdir = ServletActionContext.getServletContext().getRealPath(pathdir);//得到图片保存的真实路径
		
		if(imagefile!=null){
			File savedir = new File(realpathdir);
			if(!savedir.getParentFile().exists())
				savedir.mkdirs();
			
			String path = pathdir + "/" + imagename;
			File savefile = new File(savedir,imagename);
			File file = new File(realpathdir, imagename);
			try {
				FileUtils.copyFile(imagefile, savefile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			String pathdir140 = "/images/product/"+ productTypeId + "/" + productId +"/140x";
			String realpathdir140 = ServletActionContext.getServletContext().getRealPath(pathdir140);
			File savedir140 = new File(realpathdir140);
			if(!savedir140.exists())
				savedir140.mkdirs();
			File savefile140 = new File(savedir140,imagename);
			File file140 = new File(realpathdir140, imagename);
			try {
				ImageSizer.resize(file, file140, 140, ext);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println(file);
			System.out.println(file140);
			System.out.println(path);
			System.out.println(realpathdir+"/"+imagename);
		}
		return imagename;
		
	}
	/**
	 * 产品样式图片修改界面
	 */
	public String editUI(){
		ProductStyle productStyle = productStyleService.find(ProductStyle.class, productstyleid);
		/*
		setStylename(productStyle.getName());
		*/
		
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request");
		request.put("imagepath", productStyle.getImageFullPath());
		request.put("name", productStyle.getName());
		return "success";
	}
	/**
	 * 产品样式图片修改
	 */
	public String edit(){
		ProductStyle productStyle = productStyleService.find(ProductStyle.class, productstyleid);
		productStyle.setName(stylename);
		
		/*
		String pathdir ="/images/product/"+ productStyle.getProduct().getProducttype().getTypeid() + "/" + productStyle.getProduct().getId() + "/prototype";	
		String realpathdir = ServletActionContext.getServletContext().getRealPath(pathdir);
		if(imagefile!=null){
			File savedir = new File(realpathdir);
			if(!savedir.getParentFile().exists())
				savedir.mkdirs();
			String ext = imagefileFileName.substring(imagefileFileName.lastIndexOf("."));
			String imagename = UUID.randomUUID().toString() + ext;
			String path = pathdir + "/" + imagename;
			File savefile = new File(savedir,imagename);
			File file = new File(realpathdir, imagename);
			try {
				FileUtils.copyFile(imagefile, savefile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			String pathdir140 = "/images/product/"+ productStyle.getProduct().getProducttype().getTypeid() + "/" + productStyle.getProduct().getId() +"/140x";
			String realpathdir140 = ServletActionContext.getServletContext().getRealPath(pathdir140);
			File savedir140 = new File(realpathdir140);
			if(!savedir140.exists())
				savedir140.mkdirs();
			File savefile140 = new File(savedir140,imagename);
			File file140 = new File(realpathdir140, imagename);
			
			
			try {
				ImageSizer.resize(file, file140, 140, ext);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(file);
			System.out.println(file140);
			System.out.println(path);
			System.out.println(realpathdir+"/"+imagename);
			*/
		
			ProductStyleManageAction psma = new ProductStyleManageAction();
			String imagename = psma.saveProductImageFile(imagefileFileName, imagefile,
					productStyle.getProduct().getProducttype().getTypeid(), productStyle.getProduct().getId());
		
			productStyle.setImagename(imagename);
			productStyleService.update(productStyle);
			
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request");
		request.put("message", "Add Style Image Success!");
		request.put("urladdress", SiteUrl.readUrl("control.product.style.list")+"?productid="+productStyle.getProduct().getId());
		return "message";
	}
	/**
	 * 设置样式上架
	 */
	public String visible(){
		productStyleService.setVisibleStatus(stylesids, true);
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request");
		request.put("message", "Set Style Visible Success!");
		request.put("urladdress", SiteUrl.readUrl("control.product.style.list")+"?productid="+productid);
		return "message";
	}
	
	/**
	 * 设置样式下架
	 */
	public String disable(){
		productStyleService.setVisibleStatus(stylesids, false);
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request");
		request.put("message", "Set Style Disable Success!");
		request.put("urladdress", SiteUrl.readUrl("control.product.style.list")+"?productid="+productid);
		return "message";
	}
}

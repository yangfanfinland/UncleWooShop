package com.unclewoo.web.action.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.unclewoo.bean.product.Brand;
import com.unclewoo.bean.product.ProductInfo;
import com.unclewoo.bean.product.ProductStyle;
import com.unclewoo.bean.product.ProductType;
import com.unclewoo.bean.product.Sex;
import com.unclewoo.service.product.BrandService;
import com.unclewoo.service.product.ProductInfoService;
import com.unclewoo.service.product.ProductTypeService;
import com.unclewoo.utils.SiteUrl;

public class ProductManageAction extends ActionSupport{
	
	@Resource(name="productInfoServiceBean")
	private ProductInfoService productInfoService;
	@Resource(name="brandServiceBean")
	private BrandService brandService;
	@Resource(name="productTypeServiceBean")
	private ProductTypeService productTypeService;
	
	
	private Integer productid; 
	private Integer[] productids;
	/** 货号 **/
	private String code;
	/** 产品名称 **/
	private String name;
	/** 产品品牌 **/
	private String brandid;
	/** 产品型号 **/
	private String model;
	/** 进价 **/
	private float baseprice;
	/** 市场价 **/
	private float marketprice;
	/** 销售价 **/
	private float sellprice;
	/** 重量 单位:克 **/
	private Integer weight;
	/** 产品简介 **/
	private String description;
	/** 购买说明 **/
	private String buyexplain;
	/** 产品类型 **/
	private Integer typeid;
	/** 性别要求 **/
	private String sex;
	/** 样式名称**/
	private String stylename;
	/** 上传样式图片 **/
	private File imagefile;
	/** 上传样式图片名称 **/
	private String imagefileFileName;
	
	public ProductInfoService getProductInfoService() {
		return productInfoService;
	}

	public void setProductInfoService(ProductInfoService productInfoService) {
		this.productInfoService = productInfoService;
	}

	public Integer getProductid() {
		return productid;
	}
	
	public Integer[] getProductids() {
		return productids;
	}

	public void setProductids(Integer[] productids) {
		this.productids = productids;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrandid() {
		return brandid;
	}

	public void setBrandid(String brandid) {
		this.brandid = brandid;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getBaseprice() {
		return baseprice;
	}

	public void setBaseprice(float baseprice) {
		this.baseprice = baseprice;
	}

	public float getMarketprice() {
		return marketprice;
	}

	public void setMarketprice(float marketprice) {
		this.marketprice = marketprice;
	}

	public float getSellprice() {
		return sellprice;
	}

	public void setSellprice(float sellprice) {
		this.sellprice = sellprice;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBuyexplain() {
		return buyexplain;
	}

	public void setBuyexplain(String buyexplain) {
		this.buyexplain = buyexplain;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
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

	/**
	 * 产品添加界面
	 */
	public String addUI(){
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request"); 
		request.put("brands", brandService.getScrollData(Brand.class).getResultlist());
		return "success";
	}
	/**
	 * 选择类别
	 */
	public String selectUI(){
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request");
		
		String jpql = "o.parent is null and o.visible=true";
		Object[] params = new Object[0];
		if(typeid!=null&&typeid>0){
			jpql = " o.parent.id=?1";
			params = new Object[]{typeid};
			ProductType type = productTypeService.find(ProductType.class, typeid);
			ProductType parent = type.getParent();
			List<ProductType> types = new ArrayList<ProductType>();
			types.add(type);
			while(parent!=null){
				types.add(parent);
				parent = parent.getParent();
			}
			request.put("menutypes", types);
		}
				
		request.put("types", productTypeService.getScrollData(ProductType.class, -1, -1, jpql, params).getResultlist());
		return "success";
	}
	/**
	 * 产品添加
	 */
	public String add(){
		ProductInfo product = new ProductInfo();
		product.setName(name);
		product.setBaseprice(baseprice);
		product.setSellprice(sellprice);
		product.setMarketprice(marketprice);
		if(brandid!=null && !"".equals(brandid.trim())){
			product.setBrand(new Brand(brandid));
		}
		product.setBuyexplain(buyexplain);
		product.setCode(code);
		product.setDescription(description);
		product.setModel(model);
		product.setSexrequest(Sex.valueOf(sex));
		product.setWeight(weight);
		product.setProducttype(new ProductType(typeid));
		
		String ext = imagefileFileName.substring(imagefileFileName.lastIndexOf("."));
		String imagename = UUID.randomUUID().toString() + ext;
		product.addProductStyle(new ProductStyle(stylename, imagename));
		productInfoService.save(product);
		
		System.out.println(brandid);
		
		String pathdir ="/images/product/"+typeid+"/"+product.getId()+"/prototype";//构建文件保存的目录
		String realpathdir = ServletActionContext.getServletContext().getRealPath(pathdir);//得到图片保存目录的真实路径
		if(imagefile!=null){
			File savedir = new File(realpathdir);
			if(!savedir.getParentFile().exists())
				savedir.mkdirs();//如果目录不存在就创建
			
			
			String path = pathdir + "/" + imagename;
			File savefile = new File(savedir,imagename);
			try {
				FileUtils.copyFile(imagefile, savefile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(path);
			System.out.println(realpathdir+"/"+imagename);	
		}
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request"); 
		request.put("message", "Add Product Success!");
		request.put("urladdress", SiteUrl.readUrl("control.product.list"));
		
		return "message";
	}
	/**
	 * 产品修改界面
	 */
	public String editUI(){
		ProductInfo product = productInfoService.find(ProductInfo.class, productid);
		/* 此处无法拿到formbean中的数据
		setBaseprice(product.getBaseprice());
		if(product.getBrand()!=null)
			setBrandid(product.getBrand().getCode());
		setBuyexplain(product.getBuyexplain());
		setCode(product.getCode());
		setDescription(product.getDescription());
		setMarketprice(product.getMarketprice());
		setModel(product.getModel());
		setName(product.getName());
		setSellprice(product.getSellprice());
		setSex(product.getSexrequest().toString());
		setTypeid(product.getProducttype().getTypeid());
		setWeight(product.getWeight());
		*/
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request");
		
		request.put("baseprice", product.getBaseprice());
		request.put("description", product.getDescription());
		request.put("marketprice", product.getMarketprice());
		request.put("name", product.getName());
		request.put("sellprice", product.getSellprice());
		
		
		request.put("typename", product.getProducttype().getName());
		request.put("brands", brandService.getScrollData(Brand.class).getResultlist());
		
		return "success";
	}
	/**
	 * 产品修改
	 */
	public String edit(){
		ProductInfo product = productInfoService.find(ProductInfo.class, productid);
		product.setName(name);
		product.setBaseprice(baseprice);
		product.setSellprice(sellprice);
		product.setMarketprice(marketprice);
		if(brandid!=null && !"".equals(brandid.trim())){
			product.setBrand(new Brand(brandid));
		}
		product.setBuyexplain(buyexplain);
		product.setCode(code);
		product.setDescription(description);
		product.setModel(model);
		product.setSexrequest(Sex.valueOf(sex));
		product.setWeight(weight);
		product.setProducttype(new ProductType(typeid));
		
		productInfoService.update(product);
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request");
		request.put("message", "Edit Product Success!");
		request.put("urladdress", SiteUrl.readUrl("control.product.list"));
		
		return "message";
	}
	/**
	 * 产品查询界面
	 */
	public String queryUI(){
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request"); 
		request.put("brands", brandService.getScrollData(Brand.class).getResultlist());
		return "success";
	}
	/**
	 * 设置产品上架
	 */
	public String visible(){
		productInfoService.setVisibleStatus(productids, true);
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request");
		request.put("message", "Set Product Visible Success!");
		request.put("urladdress", SiteUrl.readUrl("control.product.list"));
		return "message";
	}
	
	/**
	 * 设置产品下架
	 */
	public String disable(){
		productInfoService.setVisibleStatus(productids, false);
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request");
		request.put("message", "Set Product Disable Success!");
		request.put("urladdress", SiteUrl.readUrl("control.product.list"));
		return "message";
	}
	/**
	 * 设置产品推荐
	 */
	public String commend(){
		productInfoService.setCommendStatus(productids, true);
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request");
		request.put("message", "Set Product Commend Success!");
		request.put("urladdress", SiteUrl.readUrl("control.product.list"));
		return "message";
	} 
	
	/**
	 * 设置产品不推荐
	 */
	public String uncommend(){
		productInfoService.setCommendStatus(productids, false);
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request");
		request.put("message", "Set Product Uncommend Success!");
		request.put("urladdress", SiteUrl.readUrl("control.product.list"));
		return "message";
	} 
}

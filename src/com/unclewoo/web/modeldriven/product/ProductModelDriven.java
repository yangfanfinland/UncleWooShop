package com.unclewoo.web.modeldriven.product;

public class ProductModelDriven extends BaseModelDriven{
	private Integer productid; 
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
	private Integer typeid;;
	/** 性别要求 **/
	private String sex;
	
	private float startsellprice;
	
	private float endsellprice;
	
	private float startbaseprice;
	
	private float endbaseprice;
	
	public Integer getProductid() {
		return productid;
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
	public float getStartsellprice() {
		return startsellprice;
	}
	public void setStartsellprice(float startsellprice) {
		this.startsellprice = startsellprice;
	}
	public float getEndsellprice() {
		return endsellprice;
	}
	public void setEndsellprice(float endsellprice) {
		this.endsellprice = endsellprice;
	}
	public float getStartbaseprice() {
		return startbaseprice;
	}
	public void setStartbaseprice(float startbaseprice) {
		this.startbaseprice = startbaseprice;
	}
	public float getEndbaseprice() {
		return endbaseprice;
	}
	public void setEndbaseprice(float endbaseprice) {
		this.endbaseprice = endbaseprice;
	}
}

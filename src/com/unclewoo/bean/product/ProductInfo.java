package com.unclewoo.bean.product;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableComponent;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;

@Entity @Searchable
public class ProductInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	/** 货号 **/
	private String code;
	/** 产品名称 **/
	private String name;
	/** 产品品牌 **/
	private Brand brand;
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
	/** 是否可见 **/
	private boolean visible = true;
	/** 产品类型 **/
	private ProductType producttype;
	/** 上架日期 **/
	private Date createdate = new Date();
	/** 人气指数 **/
	private Integer clickcount = 1;
	/** 销售量 **/
	private Integer sellcount = 0;
	/** 是否推荐 **/
	private boolean commend = false;
	/** 性别要求 **/
	private Sex sexrequest = Sex.NONE;
	
	private Set<ProductStyle> styles = new HashSet<ProductStyle>();
	
	@OneToMany(cascade={CascadeType.REMOVE,CascadeType.PERSIST}, mappedBy="product")
	@OrderBy("visible desc, id asc") @SearchableComponent
	public Set<ProductStyle> getStyles() {
		return styles;
	}
	public void setStyles(Set<ProductStyle> styles) {
		this.styles = styles;
	}
	
	/**
	 * 从样式集合中删除指定样式
	 * @param style
	 */
	public void removeProductStyle(ProductStyle style){
		if(this.styles.contains(style)){
			this.styles.remove(style);
			style.setProduct(null);
		}
	}
	
	/**
	 * 添加样式到样式集合
	 * @param style
	 */
	public void addProductStyle(ProductStyle style){
		if(!this.styles.contains(style)){
			this.styles.add(style);
			style.setProduct(this);
		}
	}	
	
	public ProductInfo() {
	}
	public ProductInfo(Integer id) {
		this.id = id;
	}
	
	@Transient
	public float getSavedPrice(){
		return marketprice-sellprice;
	}
	
	@Id @GeneratedValue @SearchableId
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length=30)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Column(length=50, nullable=false) @SearchableProperty(boost=2,name="productName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="brandid") @SearchableComponent
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	@Column(length=20) @SearchableProperty(index=Index.NO, store=Store.YES)
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Column(nullable=false)
	public float getBaseprice() {
		return baseprice;
	}
	public void setBaseprice(float baseprice) {
		this.baseprice = baseprice;
	}
	@Column(nullable=false) @SearchableProperty(index=Index.NO, store=Store.YES)
	public float getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(float marketprice) {
		this.marketprice = marketprice;
	}
	@Column(nullable=false) @SearchableProperty(index=Index.NO, store=Store.YES)
	public float getSellprice() {
		return sellprice;
	}
	public void setSellprice(float sellprice) {
		this.sellprice = sellprice;
	}
	@SearchableProperty(index=Index.NO, store=Store.YES)
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	@Column(nullable=false, length=250) @SearchableProperty
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(length=30) @SearchableProperty(index=Index.NO, store=Store.YES)
	public String getBuyexplain() {
		return buyexplain;
	}
	public void setBuyexplain(String buyexplain) {
		this.buyexplain = buyexplain;
	}
	@Column(nullable=false)
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)
	@JoinColumn(name="typeid") @SearchableComponent
	public ProductType getProducttype() {
		return producttype;
	}
	public void setProducttype(ProductType producttype) {
		this.producttype = producttype;
	}
	@Temporal(TemporalType.DATE)
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	@Column(nullable=false)
	public Integer getClickcount() {
		return clickcount;
	}
	public void setClickcount(Integer clickcount) {
		this.clickcount = clickcount;
	}
	@Column(nullable=false)
	public Integer getSellcount() {
		return sellcount;
	}
	public void setSellcount(Integer sellcount) {
		this.sellcount = sellcount;
	}
	@Column(nullable=false)
	public boolean isCommend() {
		return commend;
	}
	public void setCommend(boolean commend) {
		this.commend = commend;
	}
	@Enumerated(EnumType.STRING)
	@Column(length=5,nullable=false)
	public Sex getSexrequest() {
		return sexrequest;
	}
	public void setSexrequest(Sex sexrequest) {
		this.sexrequest = sexrequest;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductInfo other = (ProductInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

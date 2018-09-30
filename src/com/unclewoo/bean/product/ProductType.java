package com.unclewoo.bean.product;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;

@Entity @Searchable(root=false)
public class ProductType implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/** type id **/
	private Integer typeid;
	/** type name **/
	private String name;
	/** note, used as google search page description  **/
	private String note;
	/** whether visible or not **/
	private Boolean visible = true;
	/** child category **/
	private Set<ProductType> childtypes = new HashSet<ProductType>();
	/** father category **/
	private ProductType parent;
	
	private Set<ProductInfo> products = new HashSet<ProductInfo>();
	
	public ProductType() {}
	public ProductType(Integer typeid) {
		this.typeid = typeid;
	}
	public ProductType(String name, String note) {
		this.name = name;
		this.note = note;
	}
	
	@OneToMany(mappedBy="producttype", cascade=CascadeType.REMOVE)
	public Set<ProductInfo> getProducts() {
		return products;
	}
	public void setProducts(Set<ProductInfo> products) {
		this.products = products;
	}
	
	
	@ManyToOne(cascade=CascadeType.REFRESH, optional=true)
	@JoinColumn(name="parentid")
	public ProductType getParent() {
		return parent;
	}

	public void setParent(ProductType parent) {
		this.parent = parent;
	}

	@OneToMany(cascade={CascadeType.REFRESH, CascadeType.REMOVE}, mappedBy="parent")
	public Set<ProductType> getChildtypes() {
		return childtypes;
	}

	public void setChildtypes(Set<ProductType> childtypes) {
		this.childtypes = childtypes;
	}

	@Id @GeneratedValue(strategy=GenerationType.AUTO) @SearchableProperty(index=Index.NO, store=Store.YES)
	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	
	@Column(length=36, nullable=false) @SearchableProperty(index=Index.NOT_ANALYZED, store=Store.YES, name="typeName")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length=200)
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(nullable=false)
	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeid == null) ? 0 : typeid.hashCode());
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
		ProductType other = (ProductType) obj;
		if (typeid == null) {
			if (other.typeid != null)
				return false;
		} else if (!typeid.equals(other.typeid))
			return false;
		return true;
	}
	
	
}

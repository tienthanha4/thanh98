package com.devpro.shop16.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_category")
public class Categories extends BaseEntity {
	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "description", length = 100, nullable = false)
	private String description;

	@Column(name = "seo", length = 1000, nullable = true)
	private String seo;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "categories")
	private Set<Products> Productss = new HashSet<Products>();
	public void addProducts(Products Products) {
		Productss.add(Products);
		Products.setCategories(this);
	}
	public void deleteProducts(Products Products) {
		Productss.remove(Products);
		Products.setCategories(null);
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_id")
	private Categories parent;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "parent")
	private Set<Categories> childs = new HashSet<Categories>();
	public void addChild(Categories category) {
		this.childs.add(category);
		category.setParent(this);
	}
	public void deleteChild(Categories category) {
		this.childs.remove(category);
		category.setParent(null);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSeo() {
		return seo;
	}
	public void setSeo(String seo) {
		this.seo = seo;
	}
	public Set<Products> getProductss() {
		return Productss;
	}
	public void setProductss(Set<Products> productss) {
		Productss = productss;
	}
	public Categories getParent() {
		return parent;
	}
	public void setParent(Categories parent) {
		this.parent = parent;
	}
	public Set<Categories> getChilds() {
		return childs;
	}
	public void setChilds(Set<Categories> childs) {
		this.childs = childs;
	}
	


}

package com.devpro.shop16.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_saleorder_products")

public class SaleOrderProducts extends BaseEntity{
	//null = true -> bien kieu object
	@Column(name = "quality",nullable = false)
	private int quality;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id") // foreign key
	private Products saleOrderProducts;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "saleorder_id") // foreign key
	private SaleOrder saleOrder;


	public SaleOrder getSaleOrder() {
		return saleOrder;
	}

	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}

	public Products getSaleOrderProducts() {
		return saleOrderProducts;
	}

	public void setSaleOrderProducts(Products saleOrderProducts) {
		this.saleOrderProducts = saleOrderProducts;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	


	

}

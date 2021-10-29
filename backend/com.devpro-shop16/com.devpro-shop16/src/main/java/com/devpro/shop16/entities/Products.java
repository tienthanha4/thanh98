package com.devpro.shop16.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.Query;

@Entity

@Table(name = "tbl_products")

public class Products extends BaseEntity {
	// null = true -> bien kieu object
	@Column(name = "price", precision = 13, scale = 2, nullable = false)
	private BigDecimal price;// type decimal

	@Column(name = "price_sale", precision = 13, scale = 2, nullable = true)
	private BigDecimal priceSale;
	@Column(name = "tb_rate", precision = 13, scale = 2, nullable = true)
	private BigDecimal tb_rate;

	public BigDecimal getTb_rate() {
		return tb_rate;
	}

	public void setTb_rate(BigDecimal tb_rate) {
		this.tb_rate = tb_rate;
	}

	public String getDetail_description() {
		return detail_description;
	}

	public void setDetail_description(String detail_description) {
		this.detail_description = detail_description;
	}

	@Column(name = "seo", length = 1000, nullable = true)
	private String seo;

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public void setPriceSale(BigDecimal priceSale) {
		this.priceSale = priceSale;
	}

	@Column(name = "short_description", length = 100, nullable = false)
	private String short_description;
	@Lob
	@Column(name = "detail_description", columnDefinition = "LONGTEXT", nullable = true)
	private String detail_description;// type longtext

	@Column(name = "avatar", length = 200, nullable = true)
	private String avatar;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id") // foreign key
	private Categories categories;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comment_product_id") // Ten Property trong private
	Set<Comment> comments = new HashSet<Comment>();

	// Trong phia OneToMany can dinh nghia 2 methods // tro giup cho viec them
	// moi va xoa.
	public void addComent(Comment comment) {
		this.comments.add(comment);
		comment.setComment_product_id(this);
	}

	public void deleteComment(Comment comment) {
		this.comments.remove(comment);
		comment.setComment_product_id(null);
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "products") // Ten Property trong
	private Set<ProductImage> productImages = new HashSet<ProductImage>();

	// Trong phia OneToMany can dinh nghia 2 methods
	// tro giup cho viec them moi va xoa.
	public void addProductImage(ProductImage productImage) {
		this.productImages.add(productImage);
		productImage.setProducts(this);
	}

	public void deleteProductImage(ProductImage productImage) {
		this.productImages.remove(productImage);
		productImage.setProducts(null);
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "saleOrderProducts") // Ten Property trong
	private Set<SaleOrderProducts> saleOrderProduct = new HashSet<SaleOrderProducts>();

	// Trong phia OneToMany can dinh nghia 2 methods
	// tro giup cho viec them moi va xoa.
	public void addSaleOrderProducts(SaleOrderProducts saleOrderProducts) {
		this.saleOrderProduct.add(saleOrderProducts);
		saleOrderProducts.setSaleOrderProducts(this);
	}

	public void deleteSaleOrderProducts(SaleOrderProducts saleOrderProducts) {
		this.saleOrderProduct.remove(saleOrderProducts);
		saleOrderProducts.setSaleOrderProducts(null);
	}

	public Set<SaleOrderProducts> getSaleOrderProduct() {
		return saleOrderProduct;
	}

	public void setSaleOrderProduct(Set<SaleOrderProducts> saleOrderProduct) {
		this.saleOrderProduct = saleOrderProduct;
	}

	public Set<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(Set<ProductImage> productImages) {
		this.productImages = productImages;
	}

	@Column(name = "is_hot", nullable = true)
	private Boolean is_hot = Boolean.TRUE;

	public Boolean getIs_hot() {
		return is_hot;
	}

	public void setIs_hot(Boolean is_hot) {
		this.is_hot = is_hot;
	}

	@Column(name = "title", length = 1000, nullable = true)
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPriceSale() {
		return priceSale;
	}

	public void setPrice_sale(BigDecimal price_sale) {
		this.priceSale = price_sale;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public String getAvatar() {
		return avatar;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	


}

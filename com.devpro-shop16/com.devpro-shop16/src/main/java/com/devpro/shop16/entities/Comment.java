package com.devpro.shop16.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_comment")
public class Comment extends BaseEntity {
	@Column(name = "rate", precision = 13,scale = 2, nullable = true)
	private BigDecimal rate;
	
	@Column(name = "comment", length = 255, nullable = false)
	private String comment;

	@Column(name = "comment_name", length = 255, nullable = false)
	private String comment_name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "comment_product_id") // foreign key
	private Products comment_product_id;

	

	public Products getComment_product_id() {
		return comment_product_id;
	}

	public void setComment_product_id(Products comment_product_id) {
		this.comment_product_id = comment_product_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getComment_name() {
		return comment_name;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	

	public void setComment_name(String comment_name) {
		this.comment_name = comment_name;
	}




	


}

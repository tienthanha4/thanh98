package com.devpro.shop16.DTO;

public class SaleOrderProductSearchModel {
	public String keyword;
	public boolean status;
	
	//tim theo category
	
	
	public Integer saleoder_id;
	
	public String seo;
	public int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Integer getSaleoder_id() {
		return saleoder_id;
	}

	public void setSaleoder_id(Integer saleoder_id) {
		this.saleoder_id = saleoder_id;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}
	

}

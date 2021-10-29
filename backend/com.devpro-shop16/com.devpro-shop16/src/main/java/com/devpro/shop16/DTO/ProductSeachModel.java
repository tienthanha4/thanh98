package com.devpro.shop16.DTO;

//chua tât ca cac thong tin can tim kiem

public class ProductSeachModel {
	//tim theo keyword

	public String keyword;
	public boolean status;
	
	//tim theo category
	
	
	public Integer categoryId;
	
	public String seo;
	
	public String sx;
	
	public String yeucau;
	
	
	//page hien tai
	
	public String getYeucau() {
		return yeucau;
	}

	public void setYeucau(String yeucau) {
		this.yeucau = yeucau;
	}

	public String getSx() {
		return sx;
	}

	public void setSx(String sx) {
		this.sx = sx;
	}

	public int page;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	


}

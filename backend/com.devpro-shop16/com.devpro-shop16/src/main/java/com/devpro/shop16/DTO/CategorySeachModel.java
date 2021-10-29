package com.devpro.shop16.DTO;

public class CategorySeachModel {
	public String seo;
	
	public int page;
	
	public boolean status;
	

	

	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}
	

}

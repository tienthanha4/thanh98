package com.devpro.shop16.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.devpro.shop16.DTO.ProductSeachModel;
import com.devpro.shop16.DTO.SaleOrderProductSearchModel;
import com.devpro.shop16.entities.Products;
import com.devpro.shop16.entities.SaleOrderProducts;

@Service

public class SaleOrderProductsService extends BaseService<SaleOrderProducts> {

	@Override
	protected Class<SaleOrderProducts> clazz() {
		// TODO Auto-generated method stub
		return SaleOrderProducts.class;
	}
	public PagerData<SaleOrderProducts> search(SaleOrderProductSearchModel searchModel,int slshow) {
		String sql = "SELECT * FROM tbl_saleorder_products sop WHERE 1=1";

		if (searchModel != null) {
			// tìm kiếm theo category
			if(searchModel.saleoder_id != null) {
				sql += " and saleorder_id = " + searchModel.saleoder_id;
			}
		
			//tìm theo seo
			if (!StringUtils.isEmpty(searchModel.seo)) {
				sql += " and sop.seo = '" + searchModel.seo + "'";
			}

			// tìm kiếm sản phẩm hot
//			if (searchModel.isHot != null) {
////				sql += " and p.is_hot = '" + searchModel.seo + "'";
//			}
//			
			// tim kiem san pham theo seachText
//			if (!StringUtils.isEmpty(searchModel.keyword)) {
//				sql += " and (p.title like '%" + searchModel.keyword + "%'" + " or p.detail_description like '%"
//						+ searchModel.keyword + "%'" + " or p.short_description like '%" + searchModel.keyword + "%')";
//			}
//			if (!StringUtils.isEmpty(searchModel.status)) {
//				sql += " and p.status= '" + searchModel.status + "' ";
//			}
		}
//		sql += " and p.status=1 ";
		// chi lay san pham chua xoa
//				sql += " and p.status=1 ";
		return runTransactQuerySQL(sql, searchModel == null ? 0 : searchModel.getPage(),  slshow);


	}
	public PagerData<SaleOrderProducts> searchcheckStatus(SaleOrderProductSearchModel searchModel,int slshow) {
		String sql = "SELECT * FROM tbl_saleorder_products sop WHERE 1=1";

		if (searchModel != null) {
			// tìm kiếm theo category
			if(searchModel.saleoder_id != null) {
				sql += " and saleorder_id = " + searchModel.saleoder_id;
			}
		
			//tìm theo seo
			if (!StringUtils.isEmpty(searchModel.seo)) {
				sql += " and sop.seo = '" + searchModel.seo + "'";
			}

			// tìm kiếm sản phẩm hot
//			if (searchModel.isHot != null) {
////				sql += " and p.is_hot = '" + searchModel.seo + "'";
//			}
//			
			// tim kiem san pham theo seachText
//			if (!StringUtils.isEmpty(searchModel.keyword)) {
//				sql += " and (p.title like '%" + searchModel.keyword + "%'" + " or p.detail_description like '%"
//						+ searchModel.keyword + "%'" + " or p.short_description like '%" + searchModel.keyword + "%')";
//			}
//			if (!StringUtils.isEmpty(searchModel.status)) {
//				sql += " and p.status= '" + searchModel.status + "' ";
//			}
		}
//		sql += " and p.status=1 ";
		// chi lay san pham chua xoa
				sql += " and sop.status=1 ";
		return runTransactQuerySQL(sql, searchModel == null ? 0 : searchModel.getPage(),  slshow);


	}
	


}

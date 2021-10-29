package com.devpro.shop16.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.devpro.shop16.DTO.CategorySeachModel;
import com.devpro.shop16.DTO.SaleOderSeachModel;
import com.devpro.shop16.entities.Categories;
import com.devpro.shop16.entities.SaleOrder;

@Service

public class SaleOrderService extends BaseService<SaleOrder> {

	protected Class<SaleOrder> clazz() {
		// TODO Auto-generated method stub
		return SaleOrder.class;
	}
	public PagerData<SaleOrder> search(SaleOderSeachModel searchModel,int sl) {

		// khởi tạo câu lệnh
		String sql = "SELECT * FROM tbl_category c WHERE 1=1";

		if (searchModel != null) {
			// tìm theo seo
			if (!StringUtils.isEmpty(searchModel.getSeo())) {
				sql += " and c.seo = '" + searchModel.getSeo() + "'";
			}
			
			

//			if (!StringUtils.isEmpty(searchModel.status)) {
//				sql += " and p.status=1 ";
//			}

		}
		// chi lay san pham chua xoa
//				sql += " and p.status=1 ";
		return runTransactQuerySQL(sql, searchModel == null ? 0 : searchModel.getPage(),sl);
	}


}

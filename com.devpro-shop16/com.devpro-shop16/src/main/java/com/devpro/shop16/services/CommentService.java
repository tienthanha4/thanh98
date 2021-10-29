package com.devpro.shop16.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.devpro.shop16.DTO.CommentSearchModel;
import com.devpro.shop16.DTO.ProductSeachModel;
import com.devpro.shop16.entities.Comment;
import com.devpro.shop16.entities.Products;

@Service
public class CommentService extends BaseService<Comment> {

	@Override
	protected Class<Comment> clazz() {
		// TODO Auto-generated method stub
		return Comment.class;
	}
	public PagerData<Comment> searchCheckDelete(CommentSearchModel searchModel,int slshow) {
		String sql = "SELECT * FROM tbl_comment p WHERE 1=1";

		if (searchModel != null) {
			// tìm kiếm theo category
			if(!StringUtils.isEmpty(searchModel.getComment_id())) {
				sql += " and p.comment_product_id = " + searchModel.getComment_id();
			}
					}
			sql += " and p.status=1 ";

		// chi lay san pham chua xoa
//				sql += " and p.status=1 ";
		return runTransactQuerySQL(sql, searchModel == null ? 0 : searchModel.getPage(), slshow);


	}
	


}

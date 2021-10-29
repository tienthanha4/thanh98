package com.devpro.shop16.services;
import java.lang.Integer;
import java.util.List;
import java.io.File;
import java.io.IOException;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.devpro.shop16.DTO.ProductSeachModel;
import com.devpro.shop16.components.Utilities;
import com.devpro.shop16.entities.ProductImage;
import com.devpro.shop16.entities.Products;

@Service

public class ProductsService extends BaseService<Products> {

	@Override
	protected Class<Products> clazz() {
		// TODO Auto-generated method stub
		return Products.class;
	}

	// chinh sua
	@Transactional
	public void update(Products p, MultipartFile productAvatar, MultipartFile[] productPictures)
			throws IllegalStateException, IOException {
		// lau thong tin cu cua product tren id
		Products productInDB = super.getById(p.getId());
		if (!isEmptyUpLoadFile(productAvatar)) {
			// xoa avatar cu
			new File(UPLOAD_FOLDER_ROOT + "product/avatar" + productInDB.getAvatar()).delete();
			productAvatar.transferTo(
					new File(UPLOAD_FOLDER_ROOT + "product/pictures/" + productAvatar.getOriginalFilename()));
			p.setAvatar("product/avatar" + productAvatar.getOriginalFilename());

		} else {
			// su dung lai avatar cu
			productInDB.setAvatar("product/avatar/" + productAvatar.getOriginalFilename());
		}

	}

	// them moi san pham
	@Transactional
	public Products add(Products p, MultipartFile productAvatar, MultipartFile[] productPictures)
			throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		// kiem tra xem admin co day avatar len ko
		if (!isEmptyUpLoadFile(productAvatar)) {
			// tao duong dan den folder den avatar
			String pathToFile = UPLOAD_FOLDER_ROOT + "product/avatar/" + productAvatar.getOriginalFilename();
			// luu avatar vao duong dan tren
			productAvatar.transferTo(new File(pathToFile));
			p.setAvatar("product/avatar/" + productAvatar.getOriginalFilename());

		}
		// co day piture khong
		if (!isEmptyUpLoadFile(productPictures)) {
			// day cac file day len luu tren serve
			for (MultipartFile pic : productPictures) {
				pic.transferTo(new File(UPLOAD_FOLDER_ROOT + "product/pictures/" + pic.getOriginalFilename()));
				ProductImage pi = new ProductImage();
				pi.setPath("product/pictures/" + pic.getOriginalFilename());
				pi.setTitle(pic.getOriginalFilename());
				p.addProductImage(pi);

			}

		}
		//tao seo
		p.setSeo(Utilities.slugify(p.getTitle()));

		return super.saveOrUpdate(p);

	}

	private boolean isEmptyUpLoadFile(MultipartFile[] images) {
		if (images == null || images.length <= 0)
			return true;

		if (images.length == 1 && images[0].getOriginalFilename().isEmpty())
			return true;

		return false;
	}

	private boolean isEmptyUpLoadFile(MultipartFile image) {
		return image == null || image.getOriginalFilename().isEmpty();
	}
	// moi mot serve can dinh nghia 1 lop seach model

	public PagerData<Products> search(ProductSeachModel searchModel,int slshow) {
		String sql = "SELECT * FROM tbl_products p WHERE 1=1";

		if (searchModel != null) {
			// tìm kiếm theo category
			if(searchModel.categoryId != null) {
				sql += " and category_id = " + searchModel.categoryId;
			}
			
			//tìm theo seo
			if (!StringUtils.isEmpty(searchModel.seo)) {
				sql += " and p.seo = '" + searchModel.seo + "'";
			}

			// tìm kiếm sản phẩm hot
//			if (searchModel.isHot != null) {
////				sql += " and p.is_hot = '" + searchModel.seo + "'";
//			}
//			
			// tim kiem san pham theo seachText
			if (!StringUtils.isEmpty(searchModel.keyword)) {
				sql += " and (p.title like '%" + searchModel.keyword + "%'" + " or p.detail_description like '%"
						+ searchModel.keyword + "%'" + " or p.short_description like '%" + searchModel.keyword + "%')";
			}
//			if (!StringUtils.isEmpty(searchModel.status)) {
//				sql += " and p.status= '" + searchModel.status + "' ";
//			}
			if (!StringUtils.isEmpty(searchModel.sx)) {
				sql += " ORDER BY p."+ searchModel.sx +" DESC";
			}
			if (!StringUtils.isEmpty(searchModel.yeucau)) {
				sql += " ORDER BY p."+ searchModel.yeucau +" ASC";
			}
		}
//		sql += " and p.status=1 ";
		// chi lay san pham chua xoa
//				sql += " and p.status=1 ";
		return runTransactQuerySQL(sql, searchModel == null ? 0 : searchModel.getPage(),  slshow);


	}
	public PagerData<Products> searchCheckDelete(ProductSeachModel searchModel,int slshow) {
		String sql = "SELECT * FROM tbl_products p WHERE 1=1 ";
		sql += " and p.status=1 ";

		if (searchModel != null) {
			// tìm kiếm theo category
			if(searchModel.categoryId != null) {
				sql += " and category_id = " + searchModel.categoryId;
			}
		
			//tìm theo seo
			if (!StringUtils.isEmpty(searchModel.seo)) {
				sql += " and p.seo = ";
			}

			// tìm kiếm sản phẩm hot
//			if (searchModel.isHot != null) {
////				sql += " and p.is_hot = '" + searchModel.seo + "'";
//			}
//			
			// tim kiem san pham theo seachText
			if (!StringUtils.isEmpty(searchModel.keyword)) {
				sql += " and (p.title like '%" + searchModel.keyword + "%'" + " or p.detail_description like '%"
						+ searchModel.keyword + "%'" + " or p.short_description like '%" + searchModel.keyword + "%')";
			}
//			if (!StringUtils.isEmpty(searchModel.status)) {
//				sql += " and p.status= '" + searchModel.status + "' ";
//			}
			if (!StringUtils.isEmpty(searchModel.sx)) {
				sql += " ORDER BY p."+ searchModel.sx +" DESC";
			}
			if (!StringUtils.isEmpty(searchModel.yeucau)) {
				sql += " ORDER BY p."+ searchModel.yeucau +" ASC";
			}
		}
			

		// chi lay san pham chua xoa
//				sql += " and p.status=1 ";
		return runTransactQuerySQL(sql, searchModel == null ? 0 : searchModel.getPage(), slshow);


	}

	

}

package com.devpro.shop16.components;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.devpro.shop16.entities.Categories;
import com.devpro.shop16.entities.Products;
import com.devpro.shop16.services.CategoryService;

import net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer.Suffixing;

@Component // bean
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired // inject 1 bean vào trong 1 bean khác
	private CategoryService categoryService;

	/**
	 * khi ứng dụng chạy xong sẽ chạy vào hàm này.
	 */
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		
		//this.seedCategory();
		 
	}
//	private void seedCategory () 
//	{
//		Categories cateJava = categoryService.getByTransactQuerySQL("SELECT * FROM demo.tbl_category where name ='D'");
//		
//		if (cateJava == null) {// tao moi cateJava = new Categories();
//			cateJava = new Categories();
//			cateJava.setName("D");
//			cateJava.setDescription("0");
//			
//			cateJava.setCreatedDate(new Date());
//			categoryService.saveOrUpdate(cateJava);
//			for (int i =0; i<20;i++) {
//				Products p =new Products();
//				p.setTitle("title"+i);
//				p.setShort_description("des"+i);
//				p.setDetail_description("des"+i);
//				p.setPrice(new BigDecimal("1000"));
//				p.setCreatedDate(new Date());
//				cateJava.addProducts(p);
//			}
//			
//		} else {// chinh sua		
//			cateJava.setUpdatedDate(new Date());
//			
//			}
//
//		
//		categoryService.saveOrUpdate(cateJava);
//	}
	

}

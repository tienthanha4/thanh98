package com.devpro.shop16.controller.manager;

import java.awt.Dimension;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devpro.shop16.DTO.CategorySeachModel;
import com.devpro.shop16.DTO.ProductSeachModel;
import com.devpro.shop16.controller.BaseController;
import com.devpro.shop16.entities.Categories;
import com.devpro.shop16.entities.Products;
import com.devpro.shop16.services.CategoryService;
import com.devpro.shop16.services.PagerData;
import com.devpro.shop16.services.ProductsService;
import com.github.slugify.Slugify;

@Controller

public class AdminCategoryController extends BaseController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductsService ProductsService;
	@RequestMapping(value = { "/Admin/category/list" }, method = RequestMethod.GET)
	public String get_list1(final Model model, final HttpServletRequest request,
			final HttpServletResponse response ) throws IOException {
		// gui daanh sach categories xuong view
//		List<Categories> list = categoryService.findAll();
//		
//		// gửi danh sách products xuống views
//		model.addAttribute("categorise", list);
//		
		// lay keyword
//		String keyword = request.getParameter("keyword");
//		int page = getCurrentPage(request);

		int page = getCurrentPage(request);
				
		
		CategorySeachModel seachModel = new CategorySeachModel();
		seachModel.page = page;
//
//		
		model.addAttribute("categorieswithPaging",categoryService.search(seachModel,5));
		model.addAttribute("seachModel",seachModel);
		

		

		return "views/admin/CategoryList";// duong toi view
	}
	@RequestMapping(value = { "/Admin/category/addOrUpdate" }, method = RequestMethod.GET)
	public String get_addOrUpdate(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
//		// gui daanh sach categories xuong view
		
		return "views/admin/CategoryAddOrUpdate";// duong toi view
	}
	@RequestMapping(value = { "/Admin/category/addOrUpdate" }, method = RequestMethod.POST)
	public String AddCategory(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
//		// gui daanh sach categories xuong view
		String name = request.getParameter("name");
		String des = request.getParameter("description");
		Categories categories = new Categories();
		categories.setName(name);
		categories.setDescription(des);
		categories.setSeo(new Slugify().slugify(categories.getName()));
		categoryService.saveOrUpdate(categories);
		return get_list1(model, request, response);// duong toi view
	}
	@RequestMapping(value = { "/ajax/category/delete" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_deleteProductById(final Model model,
			final HttpServletRequest request, final HttpServletResponse response, final @RequestBody Categories categories)
			throws IOException {

//		ProductsService.deleteById();

		Map<String, Object> jsonResult = new HashMap<String, Object>();
		Categories categories2  = categoryService.getById(categories.getId());
//		categories2.setStatus(Boolean.FALSE);
//		categoryService.delete(categories2);
		 categoryService.saveOrUpdate(categories2);
		
		ProductSeachModel seachModel = new ProductSeachModel();
		seachModel.categoryId = categories.getId();
		

		
		
		for (int i = 0; i < ProductsService.search(seachModel,9999).getData().size(); i++) {
			
			Products p =  ProductsService.search(seachModel,9999).getData().get(i);
			p.setStatus(Boolean.FALSE);
			System.out.println(p.getId());
			ProductsService.saveOrUpdate(p);
		}
		jsonResult.put("toltal", "xoa thanh cong");
		return ResponseEntity.ok(jsonResult);
	}
	


}

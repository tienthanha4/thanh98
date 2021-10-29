package com.devpro.shop16.controller.user;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop16.services.CategoryService;
import com.devpro.shop16.services.CommentService;
import com.devpro.shop16.DTO.Cart;
import com.devpro.shop16.DTO.CartItem;
import com.devpro.shop16.DTO.CategorySeachModel;
import com.devpro.shop16.DTO.CommentSearchModel;
import com.devpro.shop16.DTO.ProductSeachModel;
import com.devpro.shop16.controller.BaseController;
import com.devpro.shop16.entities.Categories;
import com.devpro.shop16.entities.Comment;
import com.devpro.shop16.entities.Products;

import com.devpro.shop16.services.PagerData;
import com.devpro.shop16.services.ProductsService;

@Controller // -> hieu day la controller day la 1 bean
public class homeController extends BaseController {
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductsService productsService;
	@Autowired
	private CommentService commentService;

	@Autowired
	private com.devpro.shop16.services.SaleOrderService saleOrderService;
	
	public double tbRate(int id) {
		CommentSearchModel searchModel2 = new CommentSearchModel();
		searchModel2.comment_id = id;
		List<Comment> c = commentService.searchCheckDelete(searchModel2,0).getData();
		double tol =0;
		for(int i=0;i<c.size();i++) {
			tol = tol+Double.valueOf(c.get(i).getRate().intValue()) ;
		}
		
		return tol;
		
		
	}
	


	@RequestMapping(value = { "","/home" }, method = RequestMethod.GET)
	public String home(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {
		
		ProductSeachModel seachModel = new ProductSeachModel();
		seachModel.page = 1;
		// so luong show
		
		int slshow = 7;
		model.addAttribute("productsData", productsService.searchCheckDelete(seachModel,slshow));
		
		model.addAttribute("comment",commentService.findAll());
		return "views/customer/index";// duong toi view
	}
	@RequestMapping(value = { "/category/{seo}" }, method = RequestMethod.GET)
	public String home(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
			@PathVariable("seo") String seo) throws IOException {
		CategorySeachModel categorySeachModel = new CategorySeachModel();

		categorySeachModel.seo= seo;

		PagerData<Categories> pagerData = categoryService.search(categorySeachModel,99);//tim theo seo sai
		Categories categories = pagerData.getData().get(0);
		model.addAttribute("CurrentCategory", categories);
		System.out.println(categories.getId());

		ProductSeachModel productSeachModel = new ProductSeachModel();
		productSeachModel.categoryId = categories.getId();
		model.addAttribute("productData", productsService.search(productSeachModel,7));

		return "home";// duong toi view
	}

	
	
}

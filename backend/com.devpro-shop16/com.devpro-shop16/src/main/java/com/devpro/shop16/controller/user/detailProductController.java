package com.devpro.shop16.controller.user;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop16.DTO.Cart;
import com.devpro.shop16.DTO.CartItem;
import com.devpro.shop16.DTO.CommentSearchModel;
import com.devpro.shop16.DTO.ProductSeachModel;
import com.devpro.shop16.controller.BaseController;
import com.devpro.shop16.entities.Comment;
import com.devpro.shop16.entities.Products;
import com.devpro.shop16.services.CommentService;
import com.devpro.shop16.services.PagerData;
import com.devpro.shop16.services.ProductsService;

import com.ibm.icu.text.DecimalFormat;



@Controller
public class detailProductController extends BaseController {
	@Autowired
	private CommentService commentService ;
	@Autowired
	private ProductsService productsService;
	
	public double tbRate(int id) {
		CommentSearchModel searchModel2 = new CommentSearchModel();
		searchModel2.comment_id = id;
		List<Comment> c = commentService.searchCheckDelete(searchModel2,10).getData();
		double tol = 0;
		int dem = 0;
		for(int i=0;i<c.size();i++) {
			if(c.get(i).getRate() != null) {
			tol = tol+Double.valueOf(c.get(i).getRate().intValue()) ;
			System.out.println(c.get(i).getRate());
			}
		}
		
		return tol;
		
		
	}

	@RequestMapping(value = { "/home/product/details/{seo}" }, method = RequestMethod.GET)
	public String details(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
			@PathVariable("seo") String seo) throws IOException {
		ProductSeachModel productSeachModel = new ProductSeachModel();
		productSeachModel.seo = seo;
		PagerData<Products> pagerData = productsService.search(productSeachModel,10);
		Products products = pagerData.getData().get(0);
		model.addAttribute("products", products);
		return "views/customer/detailProduct";// duong toi view
	}
	
	
	@RequestMapping(value = { "/home/product/list" }, method = RequestMethod.GET)
	public String listProduct(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) throws IOException {
//		model.addAttribute("toltal", toltal());
//		
//		// gửi danh sách products xuống views
//		model.addAttribute("products", list);

		// lay keyword
		String keyword = request.getParameter("keyword");
		int page = getCurrentPage(request);
		
//		int page = Integer.parseInt(request.getParameter("page"));
		ProductSeachModel seachModel = new ProductSeachModel();
		seachModel.keyword = keyword;
		seachModel.page = page;
		seachModel.categoryId = super.getInteger(request, "categoryId");
		seachModel.sx = request.getParameter("sx");
		seachModel.yeucau = request.getParameter("yeucau");
//		seachModel.status = true;
		
		//so luong show
		int slshow = 20;
		model.addAttribute("productswithPaging", productsService.searchCheckDelete(seachModel,slshow));
;
		


		
//		model.addAttribute("seachModel", seachModel);
		
		return "views/customer/ListProduct";// duong toi view
	}
	@RequestMapping(value = { "/home/product/details/{seo}" }, method = RequestMethod.POST)
	public String review(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) throws IOException {
		
		Comment comment = new Comment();

		if(getUserLogined() != null) {
			
			comment.setComment_name(getUserLogined().getUsername()) ;
		}
		else {
			return "views/Login";
		}
		int id = Integer.parseInt(request.getParameter("comment_product_id"));
		Products p = productsService.getById(id);
		comment.setComment_product_id(p);
		comment.setRate(BigDecimal.valueOf(Double.valueOf(request.getParameter("rate"))));

		comment.setComment(request.getParameter("comment"));
//		comment.setProducts(products.getId())
//		comment.setComment_product_id(Integer.parseInt(request.getParameter("comment_product_id")));
		commentService.saveOrUpdate(comment);
		String seo = request.getParameter("seo");
		ProductSeachModel productSeachModel = new ProductSeachModel();
		productSeachModel.seo = seo;
		PagerData<Products> pagerData = productsService.search(productSeachModel,10);
		Products products = pagerData.getData().get(0);
		
		CommentSearchModel commentSearchModel = new CommentSearchModel();
		commentSearchModel.comment_id = products.getId();
		List<Comment> c = commentService.searchCheckDelete(commentSearchModel,10).getData();
		double tol = 0;
		double dem = 0;
		for (int i = 0; i < c.size(); i++) {
			if(c.get(i).getRate() != null) {
				System.out.println(c.get(i).getRate());
				tol = tol+Double.valueOf(c.get(i).getRate().intValue()) ;
	
				dem++;
			}
			
		}
		double f = tol/dem;
		BigDecimal bd = BigDecimal.valueOf(f);	
		products.setTb_rate(bd);
		productsService.saveOrUpdate(products);
		System.out.println(bd);
		//kiem tra


		 
		
		return details(model, request, response, seo);// duong toi view
	}
	


}

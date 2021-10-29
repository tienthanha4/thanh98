package com.devpro.shop16.controller.manager;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop16.DTO.CategorySeachModel;
import com.devpro.shop16.DTO.SaleOderSeachModel;
import com.devpro.shop16.DTO.SaleOrderProductSearchModel;
import com.devpro.shop16.controller.BaseController;
import com.devpro.shop16.entities.Products;
import com.devpro.shop16.entities.SaleOrder;
import com.devpro.shop16.entities.SaleOrderProducts;
import com.devpro.shop16.services.SaleOrderProductsService;
import com.devpro.shop16.services.SaleOrderService;

@Controller
public class AdminCartController extends BaseController{
	@Autowired
	private SaleOrderService saleOrderService;
	@Autowired
	private SaleOrderProductsService saleOrderProductsService ;
	
	@RequestMapping(value = { "/Admin/cart/list" }, method = RequestMethod.GET)
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
		
		SaleOrderProductSearchModel searchModel = new SaleOrderProductSearchModel();
		searchModel.page = page;
		model.addAttribute("saleOrderProductwithPaging",saleOrderProductsService.search(searchModel, 5));
		 System.out.println(saleOrderProductsService.search(searchModel, 10).getData().size());		
//		System.out.println(p.getSaleOrder().getCustomerAddress());		
//		SaleOderSeachModel seachModel = new SaleOderSeachModel();
//		seachModel.page = page;
//
//		
//		model.addAttribute("saleOrderwithPaging",saleOrderService.search(seachModel,5));
		return "views/admin/CartList";// duong toi view
	}

}

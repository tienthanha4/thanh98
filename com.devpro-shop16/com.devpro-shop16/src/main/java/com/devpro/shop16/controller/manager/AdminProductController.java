package com.devpro.shop16.controller.manager;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.devpro.shop16.DTO.ProductSeachModel;
import com.devpro.shop16.controller.BaseController;
import com.devpro.shop16.entities.Products;
import com.devpro.shop16.services.CategoryService;

import com.devpro.shop16.services.ProductsService;

@Controller

//khi extend basecontroller thi moi action de add them @ModelAttribute("categories")
public class AdminProductController extends BaseController {
	@Autowired
	private ProductsService ProductsService;
	@Autowired
	private CategoryService categoryService;

	public float toltal() {
		List<Products> list = ProductsService.findAll();
		float toltal = 0;
		for (Products products : list) {
			if (products.getStatus() == true) {
				toltal = toltal + products.getPrice().floatValue();
			}
		}
		return toltal;

	}

	@RequestMapping(value = { "/Admin/product/list" }, method = RequestMethod.GET)
	public String get_list1(final Model model, final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {
		// gui daanh sach categories xuong view
		model.addAttribute("toltal", toltal());
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
		int slshow = 5;
		model.addAttribute("productswithPaging", ProductsService.search(seachModel,slshow));
		model.addAttribute("seachModel", seachModel);

		return "views/admin/ProductList";// duong toi view
	}

	@RequestMapping(value = { "/Admin/product/edit/{productId}" }, method = RequestMethod.GET)
	public String get_edit(final Model model, final HttpServletRequest request, final HttpServletResponse response,
			@ModelAttribute("Products") Products products, @PathVariable("productId") int productId)
			throws IOException {
		// gui daanh sach categories xuong view
		model.addAttribute("categories", categoryService.findAll());
		Products products1 = ProductsService.getById(productId);
		model.addAttribute("products", products1);
		return "views/admin/productAddOrUpdate";// duong toi view
	}
	@RequestMapping(value = { "/Admin/product/delete/{productId}" }, method = RequestMethod.GET)
	public String deleteId(final Model model, final HttpServletRequest request, final HttpServletResponse response,
			@ModelAttribute("Products") Products products, @PathVariable("productId") int productId)
			throws IOException {
		// gui daanh sach categories xuong view

		ProductsService.deleteById(productId);

		return get_list1(model, request, response);// duong toi view
	}

	@RequestMapping(value = { "/Admin/product/addOrUpdate" }, method = RequestMethod.GET)
	public String get_addOrUpdate(final Model model, final HttpServletRequest request,
			final HttpServletResponse response, @ModelAttribute("Products") Products products) throws IOException {
//		// gui daanh sach categories xuong view
		model.addAttribute("categories", categoryService.findAll());

		return "views/admin/productAddOrUpdate";// duong toi view
	}

	@RequestMapping(value = { "/Admin/product/addOrUpdate" }, method = RequestMethod.POST)
	public String post_addOrUpdate(final Model model, final HttpServletRequest request,
			final HttpServletResponse response, @ModelAttribute("Products") Products products,
			@RequestParam("productAvatar") MultipartFile productAvatar,
			@RequestParam("productPictures") MultipartFile[] productPictures) throws IOException {
		System.out.println(products.getId());
		if (products.getId() == null || products.getId() < 0) {
			ProductsService.add(products, productAvatar, productPictures);
		} else {
			ProductsService.update(products, productAvatar, productPictures);
		}

		return get_list1(model, request, response);// duong toi view
	}

	@RequestMapping(value = { "/ajax/product/delete" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_deleteProductById(final Model model,
			final HttpServletRequest request, final HttpServletResponse response, final @RequestBody Products products)
			throws IOException {

//		ProductsService.deleteById();

		Map<String, Object> jsonResult = new HashMap<String, Object>();
		Products products2 = ProductsService.getById(products.getId());
		products2.setStatus(Boolean.FALSE);
		ProductsService.saveOrUpdate(products2);
		jsonResult.put("toltal", toltal());
		return ResponseEntity.ok(jsonResult);
	}

}

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
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop16.DTO.Cart;
import com.devpro.shop16.DTO.CartItem;
import com.devpro.shop16.controller.BaseController;
import com.devpro.shop16.entities.Products;
import com.devpro.shop16.entities.SaleOrder;
import com.devpro.shop16.entities.SaleOrderProducts;
import com.devpro.shop16.entities.User;
import com.devpro.shop16.services.ProductsService;
import com.devpro.shop16.services.SaleOrderService;

@Controller
public class cartController extends BaseController {
	@Autowired
	private ProductsService productsService;
	@Autowired
	private SaleOrderService saleOrderService;

	@RequestMapping(value = { "/home/shopcart" }, method = RequestMethod.GET)
	public String home(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);

		}
		session.setAttribute("toltalprice", cart.getTotalPrice());
		getTotalItems(request);
		calculateTotalPrice(request);
		System.out.println(cart.getTotalPrice());
		session.setAttribute("cart", cart);
		session.setAttribute("totalItems", getTotalItems(request));
		session.setAttribute("toltalprice", cart.getTotalPrice());
		System.out.println(cart.getTotalPrice());
		return "views/customer/ShopCart";// duong toi view
	}

	// ham tinh tong sp
	private int getTotalItems(final HttpServletRequest request) {
		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("cart") == null) {
			return 0;
		}

		Cart cart = (Cart) httpSession.getAttribute("cart");
		List<CartItem> cartItems = cart.getCartItems();

		int total = 0;
		for (CartItem item : cartItems) {
			total += item.getQuanlity();
		}
		return total;
	}
	
	
	@RequestMapping(value = { "/home/shopcart/ajax/delete" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_deleteSessionCartItem(final Model model,
			final HttpServletRequest request, final HttpServletResponse response, final @RequestBody CartItem cartItem)
			throws IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		List<CartItem> cartItems = cart.getCartItems();
		CartItem cartItem2 =null;
		for(CartItem item : cartItems) {
	
			if(cartItem.getProductId() == item.getProductId())
			{
				cartItem2 = item;
			}
			
			
		}
		cart.getCartItems().remove(cartItem2);
		Map<String, Object> jsonResult = new HashMap<String, Object>();

		// de lay session thong hau request
		// session tương tự như kiểu Map và được lưu trên main memory.
		jsonResult.put("id", cartItem.getProductId());
		session.setAttribute("cart", cart);
		
		return ResponseEntity.ok(jsonResult);

	}

	@RequestMapping(value = { "/ajax/ls" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_ls(final Model model, final HttpServletRequest request,
			final HttpServletResponse response, final @RequestBody CartItem cartItem) throws IOException {

		// de lay session thong hau request
		// session tương tự như kiểu Map và được lưu trên main memory.

		HttpSession session = request.getSession();
		Cart cart = null;
		if (session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);

		}
		// Lấy danh sách sản phẩm có trong giỏ hàng\
		List<CartItem> cartItems = cart.getCartItems();
		// kiểm tra nếu có trong giỏ hàng thì tăng số lượng
		boolean isExists = false;
		for (CartItem item : cartItems) {
			if (item.getProductId() == cartItem.getProductId()) {
				isExists = true;
				item.setQuanlity(item.getQuanlity() + cartItem.getQuanlity());
			}

		}
		// nếu sản phẩm chưa có trong giỏ hàng
		if (!isExists) {
			Products productInDb = productsService.getById(cartItem.getProductId());

			cartItem.setProductName(productInDb.getTitle());
			cartItem.setPriceUnit(productInDb.getPrice());

			cart.getCartItems().add(cartItem);
		}

		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("status", "TC");
		jsonResult.put("totalItems", getTotalItems(request));
		jsonResult.put("data", cartItem);
		session.setAttribute("totalItems", getTotalItems(request));
		session.setAttribute("cart", cart);

		return ResponseEntity.ok(jsonResult);
	}
	private void calculateTotalPrice(final HttpServletRequest request) {

		// để lấy session sử dụng thông qua request
		// session tương tự như kiểu Map và được lưu trên main memory.
		HttpSession session = request.getSession();

		// Lấy thông tin giỏ hàng.
		Cart cart = null;
		if (session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		// Lấy danh sách sản phẩm có trong giỏ hàng
		List<CartItem> cartItems = cart.getCartItems();
		BigDecimal total = BigDecimal.ZERO;
		
		for(CartItem ci : cartItems) {
			total = total.add(ci.getPriceUnit().multiply(BigDecimal.valueOf(ci.getQuanlity())));
		}

		cart.setTotalPrice(total);
	}


	@RequestMapping(value = { "/home/shopcart" }, method = RequestMethod.POST)
	public String cartFinish(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {

		// Thông tin khách hàng
		String customerFullName = request.getParameter("customerFullName");
		String customerAddress = request.getParameter("customerAddress");
		String customerEmail = request.getParameter("customerEmail");
		String customerPhone = request.getParameter("customerPhone");
//	tạo hóa đơn
		SaleOrder saleOrder = new SaleOrder();
		saleOrder.setCustomerName(customerFullName);
		saleOrder.setCustomerEmail(customerEmail);
		saleOrder.setCustomerAddress(customerAddress);
		saleOrder.setCustomerPhone(customerPhone);
		saleOrder.setCode(String.valueOf(System.currentTimeMillis()));
		
		// mã hóa đơn
		
			if(getUserLogined() != null) {
				
				saleOrder.setUser(getUserLogined());
			}
			else {
				return "views/Login";
			}
			
		

		// kết các sản phẩm trong giỏ hàng cho hóa đơn
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		calculateTotalPrice(request);
		System.out.println(cart.getTotalPrice());
		saleOrder.setTotal(cart.getTotalPrice());
		
		for (CartItem cartItem : cart.getCartItems()) {
			SaleOrderProducts saleOrderProducts = new SaleOrderProducts();
			saleOrderProducts.setSaleOrderProducts(productsService.getById(cartItem.getProductId()));
			saleOrderProducts.setQuality(cartItem.getQuanlity());

			// sử dụng hàm tiện ích add hoặc remove đới với các quan hệ onetomany
			saleOrder.addSaleOrderProducts(saleOrderProducts);
		}

		// lưu vào cơ sở dữ liệu
		saleOrderService.saveOrUpdate(saleOrder);

		// xóa dữ liệu giỏ hàng trong session
		session.setAttribute("cart", null);
		session.setAttribute("totalItems", "0");

		return "redirect:";

	}
	@RequestMapping(value = { "/ajax/tt" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_(final Model model,
			final HttpServletRequest request, final HttpServletResponse response, final @RequestBody CartItem cartItem)
			throws IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		List<CartItem> cartItems = cart.getCartItems();
		
		for(CartItem item : cartItems) {
	
			if(cartItem.getProductId() == item.getProductId())
			{
				item.setQuanlity(cartItem.getQuanlity());
			}
			
			
		}
		calculateTotalPrice(request);
		getTotalItems(request);
		
		Map<String, Object> jsonResult = new HashMap<String, Object>();

		// de lay session thong hau request
		// session tương tự như kiểu Map và được lưu trên main memory.
		jsonResult.put("id", cartItem.getProductId());
		jsonResult.put("toltal",cart.getTotalPrice());
		session.setAttribute("cart", cart);
		
		return ResponseEntity.ok(jsonResult);

	}


}

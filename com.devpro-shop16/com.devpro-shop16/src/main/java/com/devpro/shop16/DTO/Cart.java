package com.devpro.shop16.DTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;

/**
 * giỏ hàng
 * @author daing
 *
 */

public class Cart {

	// tổng số tiền trong giỏ hàng
	private BigDecimal totalPrice = BigDecimal.ZERO;
	
	// danh sách sản phẩm trong giỏ hàng
	private List<CartItem> cartItems = new ArrayList<CartItem>();
	
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

}

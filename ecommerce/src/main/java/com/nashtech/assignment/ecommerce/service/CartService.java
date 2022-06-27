package com.nashtech.assignment.ecommerce.service;

import java.util.List;

import com.nashtech.assignment.ecommerce.data.entities.Cart;

public interface CartService {
	
	public Cart updateCartQuantity(Cart cart);
	
	public List<Cart> getListCarts();
	
	public Cart createCart(Cart cart);
	
	public Cart findCartByCustomerId(int id);

}

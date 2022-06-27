package com.nashtech.assignment.ecommerce.service;

import com.nashtech.assignment.ecommerce.data.entities.CartItems;

public interface CarItemService {
	
	
	public CartItems updateCartItem(CartItems cartItems);
	
	public CartItems addCartItem(CartItems cartItems);

}

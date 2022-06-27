package com.nashtech.assignment.ecommerce.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.data.entities.CartItems;
import com.nashtech.assignment.ecommerce.data.repository.CartItemRepository;
import com.nashtech.assignment.ecommerce.service.CarItemService;


@Service
public class CartItemServiceImpl implements CarItemService {
	
	private CartItemRepository cartItemRepository;
	
	

	public CartItemServiceImpl( @Autowired CartItemRepository cartItemRepository) {
		super();
		this.cartItemRepository = cartItemRepository;
	}

	@Override
	public CartItems updateCartItem(CartItems cartItems) {
		return this.cartItemRepository.save(cartItems);
	}

	@Override
	public CartItems addCartItem(CartItems cartItems) {
		cartItems.setCartItemId(0);
		return this.cartItemRepository.save(cartItems);
	}

}

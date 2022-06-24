package com.nashtech.assignment.ecommerce.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.data.entities.Cart;
import com.nashtech.assignment.ecommerce.data.repository.CartRepository;
import com.nashtech.assignment.ecommerce.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	private CartRepository cartRepository;
	
	public CartServiceImpl(@Autowired CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	@Override
	public Cart updateCartQuantity(Cart cart) {
		return this.cartRepository.save(cart);
	}

	@Override
	public List<Cart> getListCarts() {
		return this.cartRepository.findAll();
	}
	
	public Cart addNewCart(Cart cart) {
		return this.cartRepository.save(cart);
	}

}

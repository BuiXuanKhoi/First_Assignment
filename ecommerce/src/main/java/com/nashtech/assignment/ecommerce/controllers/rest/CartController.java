package com.nashtech.assignment.ecommerce.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.ecommerce.data.entities.Cart;
import com.nashtech.assignment.ecommerce.service.CartService;

@RestController
@RequestMapping(value = "/")
public class CartController {
	
	private CartService cartService;
	
	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
		
	}
	
	
	@GetMapping("/carts")
	public List<Cart> getListCarts()
	{
		return this.cartService.getListCarts();
		
	}
	
	@PostMapping("/carts")
	public Cart createNewCart( @RequestBody Cart cart) 
	{
		cart.setCartId(0);
		return this.cartService.addNewCart(cart);
	
	}
	
	@PutMapping("/carts")
	public Cart updateCart(@RequestBody Cart cart) {
		return this.cartService.updateCartQuantity(cart);
	}

}

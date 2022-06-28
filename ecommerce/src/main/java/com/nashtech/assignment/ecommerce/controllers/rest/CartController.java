package com.nashtech.assignment.ecommerce.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.ecommerce.data.entities.Cart;
import com.nashtech.assignment.ecommerce.data.entities.CartItems;
import com.nashtech.assignment.ecommerce.service.CarItemService;
import com.nashtech.assignment.ecommerce.service.CartService;
import com.nashtech.assignment.ecommerce.services.impl.CartItemServiceImpl;

@RestController
@RequestMapping(value = "/carts")
public class CartController {
	
	private CartService cartService;
	
	private CarItemService carItemService;
	
	@Autowired
	public CartController(CartService cartService, CarItemService carItemService) {
		this.cartService = cartService;
		this.carItemService = carItemService;
	}
	
	
	@GetMapping
	public List<Cart> getListCarts()
	{
		return this.cartService.getListCarts();
	}
	
	
	@PostMapping(value = "/details")
	public CartItems addNewCartItem(@RequestBody CartItems cartItems) {
		cartItems.setCartItemId(0);
		return this.carItemService.addCartItem(cartItems);
	}
	
	@PostMapping
	public Cart createNewCart( @RequestBody Cart cart) 
	{
		cart.setCartId(0);
		return this.cartService.createCart(cart);
	}
	
	@GetMapping("/{user_id}")
	public Cart findCartByCustomerId(@PathVariable("user_id") int id) {
		
		return this.cartService.findCartByCustomerId(id);
	}
	
	@PutMapping
	public Cart updateCart(@RequestBody Cart cart) {
		return this.cartService.updateCartQuantity(cart);
	}

}

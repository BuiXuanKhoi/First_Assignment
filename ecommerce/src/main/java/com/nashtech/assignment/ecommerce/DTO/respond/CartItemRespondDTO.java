package com.nashtech.assignment.ecommerce.DTO.respond;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nashtech.assignment.ecommerce.data.entities.Cart;
import com.nashtech.assignment.ecommerce.data.entities.Customers;
import com.nashtech.assignment.ecommerce.data.entities.Products;

public class CartItemRespondDTO {
	
	
	@JsonProperty("ID")
	private int cartDetailID;
	
	private Cart cart;
	
	private Customers customers;
	
	private Products products;
	
	//-------------------------------------------------------Getter & Setter-----------------------------------------------


	public int getCartDetailID() {
		return cartDetailID;
	}

	public void setCartDetailID(int cartDetailID) {
		this.cartDetailID = cartDetailID;
	}

	@JsonIgnore
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@JsonIgnore
	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	@JsonIgnore
	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}
	
	@JsonProperty("Cart ID")
	public int getCartId() {
		return cart.getCartId();
	}
	
	@JsonProperty("Customer ID")
	public int getCustomerId() {
		return customers.getCustomerId();
	}
	
	@JsonProperty("Product ID")
	public int getProductId() {
		return products.getProductId();
	}
	
	

}

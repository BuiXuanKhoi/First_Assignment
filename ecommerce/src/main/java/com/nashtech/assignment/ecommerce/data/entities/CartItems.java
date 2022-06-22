package com.nashtech.assignment.ecommerce.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart_detail")
@NoArgsConstructor
public class CartItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_detail_id")
	private int cartItemId;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Products product;
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customers customers;
	
	
	


	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Customers getCustomer() {
		return customers;
	}

	public void setCustomer(Customers customer) {
		this.customers = customer;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public CartItems(Integer cartItemId, Products productId, Cart cartId, Customers customerId) {
		super();
		this.cartItemId = cartItemId;
		this.product = productId;
		this.cart = cartId;
		this.customers = customerId;
	}

	public Integer getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(Integer cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Products getProductId() {
		return product;
	}

	public void setProductId(Products productId) {
		this.product = productId;
	}

	public Cart getCartId() {
		return cart;
	}

	public void setCartId(Cart cartId) {
		this.cart = cartId;
	}

	public Customers getCustomerId() {
		return customers;
	}

	public void setCustomerId(Customers customerId) {
		this.customers = customerId;
	}
	
	
}

package com.nashtech.assignment.ecommerce.data.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany; 	
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "cart")
@NoArgsConstructor
public class Cart {
	
	public Cart(){}	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private int cartId;
	
	@Column(name = "cart_quantity")
	private int cartQuantity;
	
	@Column(name = "cart_total_price")
	private int cartTotalPrice;
	
	@Column(name = "cart_create_day")
	private Date cartCreateDay;
	
	@Column(name = "cart_update_day")
	private Date cartUpdateDay;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	@NonNull
	private Customers customers;
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CartItems> cartItems;
	
	
	


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Cart(Integer cartId, int cartQuantity, int cartTotalPrice, Date cartCreateDay, Date cartUpdateDay,
			Customers customerId) {
		super();
		this.cartId = cartId;
		this.cartQuantity = cartQuantity;
		this.cartTotalPrice = cartTotalPrice;
		this.cartCreateDay = cartCreateDay;
		this.cartUpdateDay = cartUpdateDay;
		this.customers = customerId;
	}

	public Cart(Integer cartId) {
		super();
		this.cartId = cartId;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public int getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public int getCartTotalPrice() {
		return cartTotalPrice;
	}

	public void setCartTotalPrice(int cartTotalPrice) {
		this.cartTotalPrice = cartTotalPrice;
	}

	public Date getCartCreateDay() {
		return cartCreateDay;
	}

	public void setCartCreateDay(Date cartCreateDay) {
		this.cartCreateDay = cartCreateDay;
	}

	public Date getCartUpdateDay() {
		return cartUpdateDay;
	}

	public void setCartUpdateDay(Date cartUpdateDay) {
		this.cartUpdateDay = cartUpdateDay;
	}

	public Customers getCustomerId() {
		return customers;
	}

	public void setCustomerId(Customers customerId) {
		this.customers = customerId;
	}

	public List<CartItems> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}
	
	
	
	

}

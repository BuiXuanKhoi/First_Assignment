package com.nashtech.assignment.ecommerce.DTO.respond;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nashtech.assignment.ecommerce.data.entities.Cart;
import com.nashtech.assignment.ecommerce.data.entities.Customers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CartRespondDTO {
	
	@JsonProperty("quantity")
	private int cartQuantity;
	
	@JsonProperty("total price")
	private long cartTotalPrice;
	
	@JsonProperty("Create Date")
	private Date cartCreateDay;
	
	private Customers customers;

	
	
	//------------------------------------Getter & Setter--------------------------------
	
	
	public int getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public long getCartTotalPrice() {
		return cartTotalPrice;
	}

	public void setCartTotalPrice(long cartTotalPrice) {
		this.cartTotalPrice = cartTotalPrice;
	}

	public Date getCartCreateDay() {
		return cartCreateDay;
	}

	public void setCartCreateDay(Date cartCreateDay) {
		this.cartCreateDay = cartCreateDay;
	}

	@JsonIgnore // Prevent expose all customer field
	public Customers getCustomers() {
		return customers;
	}
	
	// Expose only customer id
	@JsonProperty("Customer ID")
	public int customerId() {
		return customers.getCustomerId();
	}

	
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	
	
	
	
	

}

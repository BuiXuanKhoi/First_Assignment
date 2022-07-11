package com.nashtech.assignment.ecommerce.DTO.respond;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nashtech.assignment.ecommerce.data.entities.Customers;
import com.nashtech.assignment.ecommerce.data.entities.Orders;
import com.nashtech.assignment.ecommerce.data.entities.Products;

public class OrderItemRespondDTO {
	
	@JsonProperty("id")
	private String orderItemId;
	
	@JsonProperty("Address")
	private String orderAddres;
	
	private Products products;
	
	
	private Orders orders;
	
	
	
	//-----------------------------------------------Getter & Setter--------------------------------
	
	@JsonIgnore // Prevent expose all field of products
	public Products getProducts() {
		return products;
	}
	
	// Only id field 
	@JsonProperty("Product ID")
	public int getProductID() {
		return products.getProductId();
	}
	
	public void setProducts(Products products) {
		this.products = products;
	}
	
	@JsonIgnore
	public Orders getOrders() {
		return orders;
	}
	
	@JsonProperty("Order ID")
	public int getOrderID() {
		return orders.getOrderId();
	}
	
	
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public String getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}
	public String getOrderAddres() {
		return orderAddres;
	}
	public void setOrderAddres(String orderAddres) {
		this.orderAddres = orderAddres;
	}
	
	

}

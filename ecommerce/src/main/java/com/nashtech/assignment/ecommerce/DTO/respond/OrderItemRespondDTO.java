package com.nashtech.assignment.ecommerce.DTO.respond;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nashtech.assignment.ecommerce.data.entities.Customers;

public class OrderItemRespondDTO {
	
	@JsonProperty("id")
	private String orderItemId;
	
	@JsonProperty("Address")
	private String orderAddres;
	
	
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

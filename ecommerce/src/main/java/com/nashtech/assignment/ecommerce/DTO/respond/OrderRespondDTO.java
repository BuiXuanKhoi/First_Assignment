package com.nashtech.assignment.ecommerce.DTO.respond;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderRespondDTO {
	
	@JsonProperty("id")
	private int orderId;
	
	@JsonProperty("Quantity")
	private int orderQuantity;
	
	@JsonProperty("Create Day")
	private Date orderCreateDay;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Date getOrderCreateDay() {
		return orderCreateDay;
	}

	public void setOrderCreateDay(Date orderCreateDay) {
		this.orderCreateDay = orderCreateDay;
	}
	
	
	

}

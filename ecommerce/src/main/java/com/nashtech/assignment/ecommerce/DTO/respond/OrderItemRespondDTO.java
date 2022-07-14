package com.nashtech.assignment.ecommerce.DTO.respond;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nashtech.assignment.ecommerce.data.entities.Customers;
import com.nashtech.assignment.ecommerce.data.entities.Orders;
import com.nashtech.assignment.ecommerce.data.entities.Products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderItemRespondDTO {
	
	@JsonProperty("id")
	private String orderItemId;
	
	@JsonProperty("address")
	private String orderAddres;
	
	@JsonProperty("name")
	private String productName;
	
	@JsonProperty("orderId")
	private int orderId;
	

}

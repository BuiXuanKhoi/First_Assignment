package com.nashtech.assignment.ecommerce.DTO.respond;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRespondDTO {
	
	@JsonProperty("id")
	private int orderId;
	
	@JsonProperty("quantity")
	private int orderQuantity;
	
	@JsonProperty("create Day")
	private Date orderCreateDay;
}

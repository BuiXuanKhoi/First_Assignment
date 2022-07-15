package com.nashtech.assignment.ecommerce.DTO.request;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nashtech.assignment.ecommerce.data.entities.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderRequestDTO {
	
	@NotNull(message = "quantity cannot equal or lower than 0")
	@JsonProperty("quantity")
	private int orderQuantity;
	

}

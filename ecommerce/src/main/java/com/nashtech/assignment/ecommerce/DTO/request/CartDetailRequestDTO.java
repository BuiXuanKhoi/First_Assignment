package com.nashtech.assignment.ecommerce.DTO.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDetailRequestDTO {
	

	
	@Min(value = 1, message = "Quantity cannot be equal or lower than 0")
	private int cartItemQuantity;
	
	
	private int cartItemId;

}

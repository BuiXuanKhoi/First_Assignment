package com.nashtech.assignment.ecommerce.DTO.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductUpdateDTO {
	
	@NotBlank(message = "Id is required")
	private int productId;
	
	private String productName;
	
	private int productPrice;
	
	private String productDescribe;
	
	private String productImage;
	
	private int productQuantity;
	

}

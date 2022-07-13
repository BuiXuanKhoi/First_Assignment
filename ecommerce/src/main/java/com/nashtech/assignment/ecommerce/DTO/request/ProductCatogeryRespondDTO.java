package com.nashtech.assignment.ecommerce.DTO.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductCatogeryRespondDTO {
	
	@JsonProperty("id")
	private int productCatogeryId;
	
	@JsonProperty("name")
	private String productCatogeryName;

}

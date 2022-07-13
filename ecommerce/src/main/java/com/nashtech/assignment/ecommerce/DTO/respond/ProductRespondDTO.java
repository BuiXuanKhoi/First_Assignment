package com.nashtech.assignment.ecommerce.DTO.respond;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nashtech.assignment.ecommerce.data.entities.ProductCatogery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRespondDTO {
	
	@JsonProperty("id")
	private int productId;
	
	@JsonProperty("name")
	private String productName;
	
	@JsonProperty("image")
	private String productImage;
	
	@JsonProperty("price")
	private int productPrice;
	
	@JsonProperty("describe")
	private String productDescribe;
	
	@JsonProperty("quantity")
	private int productQuantity;
	
	@JsonProperty("create at")
	private Date productCreateDay;
	
	@JsonProperty("modify at")
	private Date productUpdateDay;
	
	@JsonProperty("type")
	private String catogery;

	
}

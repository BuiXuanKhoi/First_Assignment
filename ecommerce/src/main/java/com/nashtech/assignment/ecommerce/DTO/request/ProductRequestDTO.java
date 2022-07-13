package com.nashtech.assignment.ecommerce.DTO.request;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nashtech.assignment.ecommerce.data.entities.ProductCatogery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequestDTO {
	
	
	@JsonProperty("name")
	@NotEmpty(message = "Product has to have a name")
	@NotBlank(message = "Product has to have a name")
	@NotNull(message = "Product has to have a name")
	private String productName;
	
	@JsonProperty("price")
	@Min(value = 1, message  = "Price is required")
	private int productPrice;
	
	@JsonProperty("quantity")
	@Min(value = 1,message = "Quantity is required")
	private int productQuantity;
	
	@JsonProperty("describe")
	private String productDescribe;
	
	@JsonProperty("image link")
	private String productImage;

	
	private ProductCatogery productCatogery;

	public ProductRequestDTO(@NotEmpty(message = "Product has to have a name") String productName,
			@Min(value = 1, message = "Please enter price of product") int productPrice,
			@Min(value = 1, message = "Please enter the quantity of products") int productQuantity) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}
	
	
	

}

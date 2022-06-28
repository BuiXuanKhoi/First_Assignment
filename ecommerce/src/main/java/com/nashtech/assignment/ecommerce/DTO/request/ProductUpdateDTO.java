package com.nashtech.assignment.ecommerce.DTO.request;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateDTO {
	
	@NotEmpty(message = "Product has to have a name")
	private String productName;
	
	@NotEmpty(message = "Please enter price of product")
	private int productPrice;
	
	@NotEmpty(message = "Please enter the quantity of products")
	private int productQuantity;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	
	

}

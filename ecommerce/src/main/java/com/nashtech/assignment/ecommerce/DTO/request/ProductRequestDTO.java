package com.nashtech.assignment.ecommerce.DTO.request;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedDate;

import com.nashtech.assignment.ecommerce.data.entities.ProductCatogery;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
	
	
	@NotEmpty(message = "Product has to have a name")
	private String productName;
	
	@Min(value = 1, message  = "Please enter price of product")
	private int productPrice;
	
	@Min(value = 1,message = "Please enter the quantity of products")
	private int productQuantity;
	
	private ProductCatogery productCatogery;
	
	
	
	
	


	public ProductCatogery getProductCatogery() {
		return productCatogery;
	}

	public void setProductCatogery(ProductCatogery productCatogery) {
		this.productCatogery = productCatogery;
	}

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

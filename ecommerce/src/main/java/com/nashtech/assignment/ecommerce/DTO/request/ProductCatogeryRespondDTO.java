package com.nashtech.assignment.ecommerce.DTO.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ProductCatogeryRespondDTO {
	
	private int productCatogeryId;
	private String productCatogeryName;
	
	
	
	
	
	public int getProductCatogeryId() {
		return productCatogeryId;
	}
	public void setProductCatogeryId(int productCatogeryId) {
		this.productCatogeryId = productCatogeryId;
	}
	public String getProductCatogeryName() {
		return productCatogeryName;
	}
	public void setProductCatogeryName(String productCatogeryName) {
		this.productCatogeryName = productCatogeryName;
	}
	
	

}

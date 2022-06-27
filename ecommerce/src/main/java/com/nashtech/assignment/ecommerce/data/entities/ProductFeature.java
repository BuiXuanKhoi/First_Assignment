package com.nashtech.assignment.ecommerce.data.entities;

import lombok.Data;


public class ProductFeature {
	
	private int productPrice;
	
	private String productName;
	
	private String productCategoryName;
	
	

	

	public ProductFeature(int productPrice, String productName, String productCategoryName) {
		super();
		this.productPrice = productPrice;
		this.productName = productName;
		this.productCategoryName = productCategoryName;
	}

	public int getproductPrice() {
		return productPrice;
		
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setproductPrice(int productPrice) {
		productPrice = productPrice;
	}

	

	public String getproductCategoryName() {
		return productCategoryName;
	}

	public void setproductCategoryName(String productCategoryName) {
		productCategoryName = productCategoryName;
	}
	
	

}

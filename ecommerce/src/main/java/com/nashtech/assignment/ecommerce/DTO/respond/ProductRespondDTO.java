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
public class ProductRespondDTO {
	
	
	private int productId;
	private String productName;
	private int productPrice;
	private String productDescribe;
	private int productQuantity;
	private Date productCreateDay;
	private Date productUpdateDay;
	private ProductCatogery productCatogery;
	
	
	

	//-----------------------------Getter and Setter---------------------------
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public String getProductDescribe() {
		return productDescribe;
	}
	public void setProductDescribe(String productDescribe) {
		this.productDescribe = productDescribe;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Date getProductCreateDay() {
		return productCreateDay;
	}
	public void setProductCreateDay(Date productCreateDay) {
		this.productCreateDay = productCreateDay;
	}
	public Date getProductUpdateDay() {
		return productUpdateDay;
	}
	public void setProductUpdateDay(Date productUpdateDay) {
		this.productUpdateDay = productUpdateDay;
	}
	
	@JsonIgnore // Prevent expose all category field
	public ProductCatogery getProductCatogery() {
		return productCatogery;
	}
	
	
	// Expose only category id
	@JsonProperty("Catogery ID")
	public int getProductCatogeryId() {
		return productCatogery.getProductCatogeryId();
	}
	public void setProductCatogery(ProductCatogery productCatogery) {
		this.productCatogery = productCatogery;
	}
	
	
	
	
	


	
}

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
	
	@JsonProperty("id")
	private int productId;
	
	@JsonProperty("Name")
	private String productName;
	
	@JsonProperty("Price")
	private int productPrice;
	
	@JsonProperty("Describe")
	private String productDescribe;
	
	@JsonProperty("Quantity")
	private int productQuantity;
	
	@JsonProperty("Create Day")
	private Date productCreateDay;
	
	@JsonProperty("Modify Days")
	private Date productUpdateDay;
	
	@JsonIgnore
	private ProductCatogery productCatogery;
	
	@JsonProperty("Rating")
	private Float productRating;
	
	
	

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
	

	

	
	
	
	
	


	
}

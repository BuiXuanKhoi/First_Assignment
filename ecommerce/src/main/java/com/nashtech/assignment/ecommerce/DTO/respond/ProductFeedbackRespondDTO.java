package com.nashtech.assignment.ecommerce.DTO.respond;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nashtech.assignment.ecommerce.data.entities.Customers;
import com.nashtech.assignment.ecommerce.data.entities.Products;

public class ProductFeedbackRespondDTO {
	
	@JsonProperty("ID")
	private int feedbackId;
	
	@JsonProperty("Comment")
	private String feedbackComment;
	
	@JsonProperty("Rating Point")
	private int feedbackRating;
	
	private Products products;
	
	private Customers customers;

	
	
	//-------------------------------------------------------Getter & Setter-----------------------------------------------
	
	
	
	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackComment() {
		return feedbackComment;
	}

	public void setFeedbackComment(String feedbackComment) {
		this.feedbackComment = feedbackComment;
	}

	public int getFeedbackRating() {
		return feedbackRating;
	}

	public void setFeedbackRating(int feedbackRating) {
		this.feedbackRating = feedbackRating;
	}

	@JsonIgnore
	public Products getProducts() {
		return products;
	}
	
	@JsonProperty("Product ID")
	public int getProductID() {
		return products.getProductId();
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	@JsonIgnore
	public Customers getCustomers() {
		return customers;
	}
	
	@JsonProperty("Customer ID")
	public int getCustomerId() {
		return customers.getCustomerId();
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	
	
	
	
	

}

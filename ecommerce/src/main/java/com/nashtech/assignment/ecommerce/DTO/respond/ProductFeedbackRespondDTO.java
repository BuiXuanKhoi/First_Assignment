package com.nashtech.assignment.ecommerce.DTO.respond;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nashtech.assignment.ecommerce.data.entities.Customers;
import com.nashtech.assignment.ecommerce.data.entities.Products;
import com.nashtech.assignment.ecommerce.data.entities.Users;

public class ProductFeedbackRespondDTO {
	
	@JsonProperty("ID")
	private int feedbackId;
	
	@JsonProperty("Comment")
	private String feedbackComment;
	
	@JsonProperty("Rating Point")
	private int feedbackRating;
	
	@JsonIgnore
	private Products products;
	

	private Users users;

	
	
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
	public Users getUsers() {
		return users;
	}
	
	@JsonProperty("name")
	public String getUserName() {
		return users.getUserName();
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	




	

	
	
	
	
	

}

package com.nashtech.assignment.ecommerce.data.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_feedback")
@NoArgsConstructor
public class ProductFeedback {
	
	public ProductFeedback() {}
	
	
	@Id
	@GeneratedValue
	@Column(name = "feedback_id")
	private Integer feedbackId;
	
	@OneToOne
	@JoinColumn(name = "product_id")
	private Products product;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customers customers;
	
	
	@Column(name = "feedback_rating")
	private float feedbackRating;
	
	@Column(name = "feedback_comment")
	private String feedbackComment;
	

	public Customers getFeedbackId() {
		return customers;
	}

	

	public Products getProductId() {
		return product;
	}

	public void setProductId(Products productId) {
		this.product = productId;
	}





	public ProductFeedback(Integer feedbackId, Products product, Customers customers, float feedbackRating,
			String feedbackComment) {
		super();
		this.feedbackId = feedbackId;
		this.product = product;
		this.customers = customers;
		this.feedbackRating = feedbackRating;
		this.feedbackComment = feedbackComment;
	}


	public float getFeedbackRating() {
		return feedbackRating;
	}


	public void setFeedbackRating(float feedbackRating) {
		this.feedbackRating = feedbackRating;
	}


	public String getFeedbackComment() {
		return feedbackComment;
	}


	public void setFeedbackComment(String feedbackComment) {
		this.feedbackComment = feedbackComment;
	}


	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}


	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}
	
	


	
	

}

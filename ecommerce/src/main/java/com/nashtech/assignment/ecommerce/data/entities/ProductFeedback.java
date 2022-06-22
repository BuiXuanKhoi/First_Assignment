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
	
	
	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	private Customers customers;
	
	@OneToOne
	@JoinColumn(name = "product_id")
	private Products product;
	
	
	@Column(name = "product_rating")
	private float productRating;
	
	@Column(name = "product_comment")
	private String productComment;
	
	

	public ProductFeedback(Customers customers, Products product, Customers customerId, float productRating,
			String productComment) {
		super();
		this.customers = customers;
		this.product = product;
		this.customers = customerId;
		this.productRating = productRating;
		this.productComment = productComment;
	}

	public String getProductComment() {
		return productComment;
	}

	public void setProductComment(String productComment) {
		this.productComment = productComment;
	}

	public Customers getFeedbackId() {
		return customers;
	}

	

	public Products getProductId() {
		return product;
	}

	public void setProductId(Products productId) {
		this.product = productId;
	}


	public float getProductRating() {
		return productRating;
	}

	public void setProductRating(float productRating) {
		this.productRating = productRating;
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

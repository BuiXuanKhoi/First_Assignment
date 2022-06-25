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
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "order_detail")
@NoArgsConstructor
public class OrderItem {
	
	public OrderItem() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_detail_id")
	private Integer orderItemId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	@NonNull
	private Customers customerId;
	
	
	@Column(name = "order_address")
	@NonNull
	private String orderAddressString;
	
	
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Orders orders;
	
	@OneToOne
	@JoinColumn(name = "product_id")
	@NonNull
	private Products products;

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Customers getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customers customerId) {
		this.customerId = customerId;
	}

	public Orders getOrderId() {
		return orders;
	}

	public void setOrderId(Orders orderId) {
		this.orders = orderId;
	}

	public Products getProduct() {
		return products;
	}

	public void setProduct(Products product) {
		this.products = product;
	}

	public OrderItem(Integer orderItemId, Customers customerId, Orders orderId, Products productId) {
		super();
		this.orderItemId = orderItemId;
		this.customerId = customerId;
		this.orders = orderId;
		this.products = productId;
	}
	
	
	
	
	
	
	
	

}

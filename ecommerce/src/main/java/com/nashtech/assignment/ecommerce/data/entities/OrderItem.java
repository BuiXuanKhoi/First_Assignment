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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "order_detail")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderItem {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_detail_id")
	private Integer orderItemId;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonIgnore
	private Orders orders;
	
	@OneToOne
	@JoinColumn(name = "product_id")
	private Products products;
	
	@Column(name = "order_item_quantity")
	private int orderItemQuantity;
	
	@Column(name = "order_item_price")
	private int orderItemPrice;

	public OrderItem(Orders orders, Products products, int orderItemQuantity, int orderItemPrice) {
		this.orders = orders;
		this.products = products;
		this.orderItemQuantity = orderItemQuantity;
		this.orderItemPrice = orderItemPrice;
	}
	
	


	
	
	
	
	
	
	
	

}

package com.nashtech.assignment.ecommerce.data.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Orders {
	
	public Orders() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Integer orderId;
	
	@Column(name = "order_quantity")
	private int orderQuantity;
	
	@Column(name = "order_create_day")
	private Date orderCreateDay;
	
	@Column(name = "order_update_day")
	private Date orderUpdateDay;
	
	@Column(name = "order_delete_day")
	private Date orderDeleteDay;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customers customers;
	
	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderItem> orderItems;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Date getOrderCreateDay() {
		return orderCreateDay;
	}

	public void setOrderCreateDay(Date orderCreateDay) {
		this.orderCreateDay = orderCreateDay;
	}

	public Date getOrderUpdateDay() {
		return orderUpdateDay;
	}

	public void setOrderUpdateDay(Date orderUpdateDay) {
		this.orderUpdateDay = orderUpdateDay;
	}

	public Customers getCustomerId() {
		return customers;
	}

	public void setCustomerId(Customers customerId) {
		this.customers = customerId;
	}

	public Orders(Integer orderId, int orderQuantity, Date orderCreateDay, Date orderUpdateDay, Customers customerId) {
		super();
		this.orderId = orderId;
		this.orderQuantity = orderQuantity;
		this.orderCreateDay = orderCreateDay;
		this.orderUpdateDay = orderUpdateDay;
		this.customers = customerId;
	}
	
	
	
	

}

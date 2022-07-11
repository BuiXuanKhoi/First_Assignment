package com.nashtech.assignment.ecommerce.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "cart_detail")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartItems {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_detail_id")
	private int cartItemId;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	@NonNull
	private Products product;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@NonNull
	private Users users;
	
	@Column(name = "cart_item_quantity")
	private int cartItemQuantity;
	
	@Column(name = "cart_item_total_price")
	private int cartItemTotalPrice;
	
	
	
}

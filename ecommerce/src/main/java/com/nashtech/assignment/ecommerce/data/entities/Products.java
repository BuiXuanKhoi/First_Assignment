package com.nashtech.assignment.ecommerce.data.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.print.attribute.standard.DateTimeAtCreation;
import javax.xml.crypto.Data;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;


@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Products implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;
	
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_price")
	private int productPrice;
	
	@Column(name = "product_describe")
	private String productDescribe;
	
	@Column(name = "product_image")
	private String productImage;
	
	@Column(name = "product_quantity")
	private int productQuantity;
	
	@Column(name = "product_rating")
	private Float productRating;
	
	
	

	@Temporal(TemporalType.DATE)
	@Column(name = "product_create_day")
	private Date productCreateDay ;
	
	@Column(name = "product_update_day")
	private Date productUpdateDay;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_catogery_id")
	@JsonIgnore
	private ProductCatogery productCatogery;
	
	
	//---------------------------
	
	
	
	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<OrderItem> orderItem ;
	

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ProductFeedback> productFeedback;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CartItems> cartItems;

	public Products(String productName, int productPrice, int productQuantity) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}
		
	//-----------------------------
	
	
	


}

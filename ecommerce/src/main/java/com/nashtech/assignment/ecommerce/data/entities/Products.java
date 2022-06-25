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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.crypto.Data;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "products")
public class Products {


	public Products() {}
	

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
	
	@Column(name = "product_quantity")
	private int productQuantity;
	
	@Column(name = "product_create_day")
	private Date productCreateDay;
	
	@Column(name = "product_update_day")
	private Date productUpdateDay;
	
	

	@ManyToOne
	@JoinColumn(name = "product_catogery_id")
	private ProductCatogery productCatogery;
	
	
	//---------------------------
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderItem> orderItem ;
	
	@JsonIgnore
	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private ProductFeedback productFeedback;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CartItems> cartItems;
		
	//-----------------------------
	

	
	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}



	public Products(Integer productId) {
		super();
		this.productId = productId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductPrice() {
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

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public ProductCatogery getProductCatogery() {
		return productCatogery;
	}

	public void setProductCatogery(ProductCatogery productCatogery) {
		this.productCatogery = productCatogery;
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

	public Products(Integer productId, String productName, int productPrice, String productDescribe,
			int productQuantity, Date productCreateDay, Date productUpdateDay) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescribe = productDescribe;
		this.productQuantity = productQuantity;
		this.productCreateDay = productCreateDay;
		this.productUpdateDay = productUpdateDay;
	}
	
	
	

}

package com.nashtech.assignment.ecommerce.data.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "product_catogery")
@NoArgsConstructor
public class ProductCatogery implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_catogery_id")
	private Integer productCatogeryId;
	
	@Column(name = "product_catogery_name")
	@NonNull
	private String productCatogeryName;
	
	@OneToMany(mappedBy = "productCatogery", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Products> products;
	

	public ProductCatogery(Integer productCatogeryId) {
		super();
		this.productCatogeryId = productCatogeryId;
	}
	
	public ProductCatogery() {
		
	}
	
	

	public Integer getProductCatogeryId() {
		return productCatogeryId;
	}

	public void setProductCatogeryId(Integer productCatogeryId) {
		this.productCatogeryId = productCatogeryId;
	}

	public String getProductCatogeryName() {
		return productCatogeryName;
	}

	public void setProductCatogeryName(String productCatogeryName) {
		this.productCatogeryName = productCatogeryName;
	}

	
	
	
	

	
	
	

}

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "product_catogery")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductCatogery implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_catogery_id")
	private Integer productCatogeryId;
	
	@Column(name = "product_catogery_name")
	@NonNull
	private String productCatogeryName;
	
	@OneToMany(mappedBy = "productCatogery", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Products> ListProducts;
	
	@Column(name = "product_catogery_describe")
	private String productCatogeryDescribe;

	public ProductCatogery(Integer productCatogeryId, @NonNull String productCatogeryName) {
		this.productCatogeryId = productCatogeryId;
		this.productCatogeryName = productCatogeryName;
	}
	
	
	
}

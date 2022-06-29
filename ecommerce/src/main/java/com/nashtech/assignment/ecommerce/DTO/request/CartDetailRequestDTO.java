package com.nashtech.assignment.ecommerce.DTO.request;

import javax.validation.constraints.NotBlank;

public class CartDetailRequestDTO {
	
	@NotBlank(message = "Cart ID cannot be null")
	private int cartId;
	
	@NotBlank(message = "Customer ID cannot be null")
	private int customerId;
	
	@NotBlank(message = "Product ID cannot be null")
	private int productId;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public CartDetailRequestDTO(@NotBlank(message = "Cart ID cannot be null") int cartId,
			@NotBlank(message = "Customer ID cannot be null") int customerId,
			@NotBlank(message = "Product ID cannot be null") int productId) {
		super();
		this.cartId = cartId;
		this.customerId = customerId;
		this.productId = productId;
	}
	
	

}

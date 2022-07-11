package com.nashtech.assignment.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.nashtech.assignment.ecommerce.DTO.request.ProductRequestDTO;
import com.nashtech.assignment.ecommerce.DTO.respond.ProductRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.ProductCatogery;
import com.nashtech.assignment.ecommerce.data.entities.Products;
import com.nashtech.assignment.ecommerce.data.repository.ProductCatogeryRepository;
import com.nashtech.assignment.ecommerce.data.repository.ProductRepository;
import com.nashtech.assignment.ecommerce.services.impl.ProductServiceImpl;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ProductServiceTest {
	

	private ProductRepository productRepository;
		
	private ModelMapper modelMapper;
	
	private ProductServiceImpl productServiceImpl;
	
	private ProductCatogeryRepository productCatogeryRepository;
	
	

	@BeforeEach
	void setUp() {
		this.productRepository = mock(ProductRepository.class);
		this.modelMapper = mock(ModelMapper.class);
		this.productCatogeryRepository = mock(ProductCatogeryRepository.class);
		this.productServiceImpl = new ProductServiceImpl(productRepository, modelMapper, productCatogeryRepository);
		}
	
	@Test
	public void testWhenGetAll_shouldReturnList()
	{
		List<ProductRespondDTO> listRespondDTO = new ArrayList<ProductRespondDTO>();
		List<Products> listProducts = new ArrayList<Products>();
		when(this.productRepository.findAll()).thenReturn(listProducts);
		if(!listProducts.isEmpty()) 
		{
			when(productServiceImpl.convertListToListDTO(listProducts)).thenReturn(listRespondDTO);
			assertEquals(listRespondDTO, productServiceImpl.getAllProducts());
		}
			
	}
	
	@Test
	public void testAddProduct() {
		ProductRequestDTO productRequestDTO = new ProductRequestDTO("GNA Phone", 200, 200);
		ProductCatogery productCatogery = new ProductCatogery(22, "Tablet");
		Products products = new Products("GNA Phone", 200, 200);
		
		
		when(modelMapper.map(productRequestDTO, Products.class)).thenReturn(products);
		
		when(productCatogeryRepository.getCatogeryByName("Tablet")).thenReturn(productCatogery);

		products.setProductCatogery(productCatogery);
		System.out.println(products);				
		try {
			Products savedProducts = productRepository.saveAndFlush(products);
			
			System.out.println(savedProducts);
			assertTrue(savedProducts.getProductId() > 1);
			
		} catch (Exception e) {
			System.out.println("Error is : " + e.getMessage());
		}
		

	}
	
	@Test
	public void testWhenHaveId_thenReturnProduct() {
		
	}
	

	
	
	

}

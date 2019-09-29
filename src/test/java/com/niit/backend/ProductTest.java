package com.niit.backend;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.Service.ProductService;
import com.niit.model.Product;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppContext.class)
public class ProductTest {

	@Autowired
	ProductService productservice;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createProduct() {
		Product product = new Product();
		product.setProductname("Mrunmai");
		product.setPrice(1000000);
		product.setProductdescription("she is the best");
		product.setQuantity(1);
		
		assertEquals(true, productservice.createProduct(product));
	}
	@Ignore
	@Test
	public void updateProduct() {
		Product product = productservice.getProductById(34);
		product.setPrice(50);
		product.setProductdescription("Send me to hogwarts");
		product.setProductname("Sirius Black");
		product.setQuantity(3);
		
		assertEquals(true, productservice.updateProduct(product));
		
		}
	@Ignore
	@Test
	public void deleteProduct() {
		Product product = productservice.getProductById(35);
		assertEquals(true,productservice.deleteProduct(product));
		
	}
}



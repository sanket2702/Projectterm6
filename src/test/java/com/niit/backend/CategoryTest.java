package com.niit.backend;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.Service.CategoryService;
import com.niit.model.Category;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppContext.class)
public class CategoryTest {

	@Autowired
	CategoryService categoryservice;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createCategory() {
		Category category = new Category();
		category.setCategoryname("New Collection");
		category.setCategorydesc("qwertyuiopasdfghjklzxcvbnm");
		
		assertEquals(true, categoryservice.createCategory(category));
	}

}

package com.niit.backend;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.Service.OrderService;
import com.niit.model.Order;
import com.niit.model.User;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppContext.class)
public class OrderTest {
	
	@Autowired
	OrderService orderservice;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createOrder() {
		Order order = new Order();
		User u=new User();
		u.setUserId(6);
		order.setUserid(u);
		order.setOrderdesc("Your order contains 3 items");
		order.setOrderprice(3000);
		order.setOrderstat("Dispatched");
		
		assertEquals(true, orderservice.createOrder(order));
	}

}

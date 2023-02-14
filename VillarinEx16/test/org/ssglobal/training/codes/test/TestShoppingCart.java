package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.Product;
import org.ssglobal.training.codes.ProductNotFoundException;
import org.ssglobal.training.codes.ShoppingCart;

public class TestShoppingCart {
	private ShoppingCart cart;
	
	@BeforeEach	
	public void setup() {
		cart = new ShoppingCart();
	}
	
	@AfterEach
	public void teardown() {
		cart = null;
	}
	
	@Test
	public void testWhenCartZero() {
		int count = cart.getItemCount();
		assertEquals(0, count);
	}
	
	@Test
	public void testWhenCartNotZero() {
		Product product = new Product("Chocolate", 220.00);
		cart.addItem(product);
		int count = cart.getItemCount();
		assertNotEquals(0, count);
	}
	
	@Test
	public void testWhenCartEmpty() {
		cart.empty();
		int count = cart.getItemCount();
		assertEquals(0, count);
	}
	
	@Test
	public void testWhenCartNotEmpty() {
		Product product = new Product("Chocolate", 220.00);
		cart.addItem(product);
		int count = cart.getItemCount();
		assertNotEquals(0, count);
	}
	
	@Test
	public void testWhenCartAdded() {
		Product product = new Product("Chocolate", 220.00);
		int initialCount = cart.getItemCount();
		cart.addItem(product);
		int finalCount = cart.getItemCount();
		assertTrue(finalCount > initialCount);
	}
	
	@Test
	public void testWhenCartNotAdded() {
		Product product = new Product("Chocolate", 220.00);
		int initialCount = cart.getItemCount();
		cart.addItem(product);
		int finalCount = cart.getItemCount();
		assertFalse(finalCount == initialCount);
	}
	
	
	@Test
	public void testWhenSumCost() {
		Product product = new Product("Chocolate", 220.00);
		double initialBalance = cart.getBalance();
		cart.addItem(product);
		double finalBalance = cart.getBalance();
		assertTrue(finalBalance > initialBalance);
	}
	
	@Test
	public void testWhenSumCostNotAdded() {
		Product product = new Product("Chocolate", 220.00);
		double initialBalance = cart.getBalance();
		cart.addItem(product);
		double finalBalance = cart.getBalance();
		assertFalse(finalBalance == initialBalance);
	}
	
	@Test
	public void testWhenCartRemoved() {
		Product product = new Product("Chocolate", 220.00);
		cart.addItem(product);
		
		int initialCount = cart.getItemCount();
		try {
			cart.removeItem(product);
		} catch (ProductNotFoundException e) {
			System.out.println(e.getMessage());
		}
		int finalCount = cart.getItemCount();
		assertTrue(finalCount < initialCount);
	}
	
	@Test
	public void testWhenCartNotRemoved() {
		Product product = new Product("Chocolate", 220.00);
		cart.addItem(product);
		
		int initialCount = cart.getItemCount();
		try {
			cart.removeItem(product);
		} catch (ProductNotFoundException e) {
			System.out.println(e.getMessage());
		}
		int finalCount = cart.getItemCount();
		assertFalse(finalCount == initialCount);
	}
	
	@Test
	public void testWhenCartRemovedNotFound() {
		Product product1 = new Product("Chocolate", 220.00);
		Product product2 = new Product("Ice Cream", 350.00);
		cart.addItem(product1);
		
		int initialCount = cart.getItemCount();
		assertThrows(ProductNotFoundException.class, () -> {
			cart.removeItem(product2);
			int finalCount = cart.getItemCount();
			assertTrue(finalCount == initialCount);
		});
	}
}

package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.Calculator;

public class TestCalculator {
	private Calculator calc;

	@BeforeEach
	public void setup() {
		calc = new Calculator();
	}

	@AfterEach
	public void teardown() {
		calc = null;
	}
	
	@Test
	public void testWithSingleSummand() {
		String expression = "1";
		int expectedValue = 1;
		int result = calc.evaluate(expression);
		assertEquals(expectedValue, result);
	}

	@Test
	public void testWithPositiveSummand() {
		String expression = "2+2+2";
		int expectedValue = 6;
		int result = calc.evaluate(expression);
		assertEquals(expectedValue, result);
	}
	
	@Test
	public void testWithNegativeSummand() {
		String expression = "-3+-3+-3";
		int expectedValue = 9;
		int result = calc.evaluate(expression);
		assertNotEquals(expectedValue, result);
	}

	@Test
	public void testWithMixedSummands() {
		String expression = "-4+3+-2";
		int expectedValue = -1;
		int result = calc.evaluate(expression);
		assertNotEquals(expectedValue, result);
	}
	
	@Test
	public void testWithOnlySymbols() {
		String expression = "++++";
		int expectedValue = 0;
		int result = calc.evaluate(expression);
		assertTrue(expectedValue == result);
	}
	
	@Test
	public void testWithPositiveSummands() {
		String expression = "5+5+5";
		int expectedValue = 15;
		int result = calc.evaluate(expression);
		assertTrue(expectedValue == result);
	}
	
	@Test
	public void testWithNegativeSummands() {
		String expression = "-5+-5+-5";
		int expectedValue = 15;
		int result = calc.evaluate(expression);
		assertFalse(expectedValue == result);
	}	
	
	public void testWithLetters() {
		String expression = "1+1+a";
		assertThrows(NumberFormatException.class, () -> {
			int expectedValue = 2;
			int result = calc.evaluate(expression);
			assertEquals(expectedValue, result);
		});
	}
	
	public void testWitSpecialCharacters() {
		String expression = "1+1+@";
		assertThrows(NumberFormatException.class, () -> {
			int expectedValue = 2;
			int result = calc.evaluate(expression);
			assertEquals(expectedValue, result);
		});
	}
	
	/* 
	 *  Average running time -> 0.019s
	 */
	
}


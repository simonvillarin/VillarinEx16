package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.ssglobal.training.codes.Boa;
import org.ssglobal.training.codes.InvalidBoaLengthException;

public class TestBoa {
	private Boa jen;
	private Boa ken;
	private Boa dolly;
	private Boa eric;
	private Boa lu;

	@BeforeEach
	public void setup() {
		jen = new Boa("Jennifer", 2, "grapes");
		ken = new Boa("Kenneth", 3, "granola bars");
		dolly = new Boa("Mandy", 4, "rice grains");
		eric = new Boa("Dandy", 5, "mice");
		lu = new Boa("Minie", 6, "parrot");
	}

	@AfterEach
	public void teardown() {
		jen = null;
		ken = null;
		dolly = null;
		eric = null;
		lu = null;
	}
	
	@ParameterizedTest
	@MethodSource("createBoa")
	public void testHealthyFavoriteFoodIsGranulaBars(Boa boa) {
		boolean result = boa.isHealthy();
		assertEquals(true, result);
	}
	
	@ParameterizedTest
	@MethodSource("createBoa")
	public void testHealthyFavoriteFoodNotGranulaBars(Boa boa) {
		boolean result = boa.isHealthy();
		assertNotEquals(true, result);
	}
	
	@ParameterizedTest
	@MethodSource("createBoa")
	public void testHealthyFavoriteFoodIsEmpty(Boa boa) {
		boolean result = boa.isHealthy();
		assertNotEquals(true, result);
	}

	@ParameterizedTest
	@MethodSource("createBoa")
	public void testfitsInCage(Boa boa) {
		boolean result = boa.fitsInCage(10);
		assertEquals(true, result);
	}
	
	@ParameterizedTest
	@MethodSource("createBoa")
	public void testNotfitsInCage(Boa boa) {
		boolean result = boa.fitsInCage(1);
		assertNotEquals(true, result);
	}
	
	@ParameterizedTest
	@MethodSource("createBoa")
	public void testfitsInCageNegative(Boa boa) {
		boolean result = boa.fitsInCage(-1);
		assertNotEquals(true, result);
	}
	
	@ParameterizedTest
	@MethodSource("createBoa")
	public void testLengthIsPositive(Boa boa) {
		int result = boa.lengthInInches();
		assertDoesNotThrow(() -> {
			assertTrue(result > 0);
		});
	}
	
	@ParameterizedTest
	@MethodSource("createBoa")
	public void testLengthIsNegative(Boa boa) {
		int result = boa.lengthInInches();
		assertThrows(InvalidBoaLengthException.class, () -> {
			assertFalse(result > 0);
		});
	}
	
	@ParameterizedTest
	@MethodSource("createBoa")
	public void testLengthInInchesPositiveAndBelowTenInches(Boa boa) {
		int result = boa.lengthInInches();
		assertTrue(result > 0 && result < 10);
	}
	

	@ParameterizedTest
	@MethodSource("createBoa")
	public void testLengthInInchesBelowZero(Boa boa) {
		int result = boa.lengthInInches();
		assertFalse(result < 0);
	}
	

	@ParameterizedTest
	@MethodSource("createBoa")
	public void testLengthInInchesAboveTenInches(Boa boa) {
		int result = boa.lengthInInches();
		assertFalse(result > 10);
	}
	
	public static Stream<Boa> createBoa() {
		Boa jen = new Boa("Jennifer", 2, "grapes");
		Boa ken = new Boa("Kenneth", 3, "granola bars");
		Boa dolly = new Boa("Mandy", 4, "rice grains");
		Boa eric = new Boa("Dandy", 5, "mice");
		Boa lu = new Boa("Minie", 6, "parrot");
		return Stream.of(jen, ken, dolly, eric, lu);
	}
}

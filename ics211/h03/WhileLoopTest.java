package edu.ics211.h03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WhileLoopTest {

	String[] tokens = {"while", "(", "test_condition", ")", "{", "}"};
	WhileLoop wl;
	@BeforeEach
	void setUp() throws Exception {
		wl = new WhileLoop(tokens);
	}

	@Test
	void testWhileLoopConstructor() {
		assertArrayEquals(tokens, wl.tokens, "tokens valid, so WhileLoop object should be created");
	}
	
	void testNumberOfParts() {
		assertEquals(1, wl.numberOfParts(), "WhileLoop object should have 1 part");
	}


}

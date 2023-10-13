package edu.ics211.h03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConditionalTest {
	
	String[] tokens1 = {"if", "(", "x == 5", ")", "{",
			   "print", "(", "\"x is 5\"", ")", ";",
			   "}",
			   "else", "{",
			      "print", "(", "\"x is not 5\"", ")", ";",
			   "}"};
	Conditional c1;

	@BeforeEach
	void setUp() throws Exception {
		c1 = new Conditional(tokens1);
	}

	@Test
	void testConditionalConstructor() {
		assertArrayEquals(tokens1, c1.tokens, "valid tokens so c1 should be constructed");
	}
	
	
	@Test
	void testNumberOfParts() {
		assertEquals(2, c1.numberOfParts(), "Conditional objects should have 2 parts");
	}

}


/**
 The ConditionalTest class should test the constructor, 
 test if the Condition is compound, and test the numberOfParts() method. 
 * 
 */
package edu.ics211.h02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author esb
 * * @author lucash

 */
class ConditionalTest {

	Conditional if1;
	
	final static String[] test1 = {
             "if", "(", "a", ">", "3", ")", "{",
                 "lifeIsGood", "(", ")", ";",
              "}", "else", "{",
                 "lifeIsVeryGood", "(", "2", ")", ";",
              "}" };
	final static String[] test2 = {"hello"};


	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		if1 = new Conditional(test1);
		
	}
	@Test
	void testConditionalConstructor() {
		assertArrayEquals(test1, if1.tokens, "Conditional object should be constructed");
	}
	@Test
	void testIsCompound() {
		assertTrue(if1.isCompound());
	}
	@Test
	void testNumOfParts() {
	
		assertEquals(if1.numberOfParts(), 2);
	
	}

}


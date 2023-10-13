

/**
 The WhileLoopTest class should test the constructor, and the numberOfParts() method. 
 * 
 */
package edu.ics211.h02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author esb
 * @author lucash
 *
 */
class WhileLoopTest {

	WhileLoop wl1;
	WhileLoop wl2;

        final static String[] test1 = {
             "while", "(", "x", ">", "0", ")", "{",
                 "x", "=", "x", "-", "1", ";",
              "}" };
  

	/**
	 * @throws InvalidStatementException 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws InvalidStatementException  {
		wl1 = new WhileLoop(test1);
		/* for homework 3
		wl2 = new WhileLoop(cond, s12); */
	}
	


	@Test
	void testWhileLoopConstructor() {
		assertArrayEquals(test1, wl1.tokens, "Assignment object should be constructed");
	}
	@Test
	void testNumOfParts() {
		assertEquals(wl1.numberOfParts(), 1);
	}

}


// The MethodCallTest class should test to see if the constructor works, 
//and test the getMethodName() method. 


package edu.ics211.h02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

class MethodCallTest {
	
	MethodCall mc1;
	MethodCall mc2;
    String[] tokens = { "f", "(", "n", ")", ";" };

	
	@BeforeEach
	void setUp() throws Exception {
		mc1 = new MethodCall(tokens);
		/* for homework 3
                String[] parameters = { "x", ",", "y" };
		mc1 = new MethodCall("g", parameters); */
	}

	@Test
	void testGetMethodName() {
		assertEquals(mc1.getMethodName(), "f");
	}
	@Test
	void testMethodCallConstructor() {
		assertArrayEquals(tokens, mc1.tokens, "Assignment object should be constructed");
	}
		/* for homework 3
		assertFalse(mc2.isCompound());
		assertEquals(mc2.getMethodName(), "g"); */
	

}


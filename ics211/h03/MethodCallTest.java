package edu.ics211.h03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MethodCallTest {

	MethodCall mc1;
	MethodCall mc2;
	MethodCall mc3;
	String[] tokens1 = {"println", "(", "myobj", ")", ";"};
	//String[] tokens2 = {"println", "(", "myobj2", ")", ";"};
	//String[] tokens3 = {"println", "(", "myobj", ")", ";"};
	@BeforeEach
	void setUp() throws Exception {
		mc1 = new MethodCall(tokens1);
		//mc2 = new MethodCall(tokens2);
		//mc3 = new MethodCall(tokens3);
	}

	@Test
	void testConstructorWorks() {
		assertArrayEquals(tokens1, mc1.tokens, "MethodCall should have been constructed");
	}

	
	@Test
	void testMethodCallGetMethodName() {
		assertEquals("println", mc1.getMethodName(), "Method name should be \"println\"");
	}
	
	/**
	@Test
	void testMethodCallEqualsSelf() {
		assertTrue(mc1.equals(mc1), "MethodCall object should have been equal to itself");
	}
	
	@Test
	void testMethodCallEquals() {
		assertTrue(mc1.equals(mc3), "mc1 should be equal to mc2");
	}
	
	@Test
	void testMethodCallEqualsSymmetric() {
		assertTrue(mc3.equals(mc1), "Since mc1.equals(mc3) is true, " + 
			"mc3.equals(mc1) should also be true");
	}
	
	@Test
	void testMethodCallNotEquals() {
		assertFalse(mc1.equals(mc2), "mc1 should not be equal to mc2");
	}
	 */

}

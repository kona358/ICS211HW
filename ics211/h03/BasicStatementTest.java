package edu.ics211.h03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicStatementTest {
	BasicStatement basic;

	@BeforeEach
	void setUp() throws Exception {
		String[] tokens = {"x", "=", "5", ";"};
		basic = new BasicStatement(tokens);
	}
	
	@Test
	void testBasicStatementIsNotCompound() {
		assertEquals(false, basic.isCompound(), "Basic Statement should not be compound");
	}


}

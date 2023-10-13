

/**
 The BasicStatementTest class should test to make sure that the BasicStatement is not compound. 
 * 
 */
package edu.ics211.h02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author esb
 *@author lucash
 */
class BasicStatementTest {
	BasicStatement basic;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
                String[] tokens = { "a", "=", "3", ";" };
		basic = new BasicStatement(tokens);
	}

	@Test
	void test() {
		assertFalse(basic.isCompound());
	}

}


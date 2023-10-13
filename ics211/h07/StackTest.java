package edu.ics211.h07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

	final static String[] strData = { "Alice", "Bob", "Dave", "Jack", "Evelyn", "Carol" };
	final static String[] strData2 = { "red", "blue", "green", "yellow", "orange", "cyan", "black" };
	final static Integer[] intData = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

	ArrayStack<String> stack1;
	ArrayStack<String> stack2;
	LinkedStack<Integer> stack3;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testArrayStack1() {
		stack1 = new ArrayStack<String>();
		boolean passedTest = unitTest(stack1, strData);
		assertTrue(passedTest, "Should have passed all tests in unitTest()");
	}

	@Test
	void testArrayStack2() {
		stack2 = new ArrayStack<String>();
		boolean passedTest = unitTest(stack2, strData2);
		assertFalse(passedTest, "Should not passed unitTest() as stack overflow should occur");
	}

	@Test
	void testLinkedStack3() {
		stack3 = new LinkedStack<Integer>();
		boolean passedTest = unitTest(stack3, intData);
		assertTrue(passedTest, "Should have passed all tests in unitTest()");
	}

	@SuppressWarnings("hiding")
	public <E> boolean unitTest(StackInterface<E> stack, E[] data) {
		// test cases that could return false
		if (stack.empty()) {
			try {
				for (E x : data) {
					stack.push(x);
				}
			} catch (FullStackException e) {
				System.out.println("caught " + e);
				return false;
			}
			for (int i = data.length - 1; i >= 0; i--) {

				if (!(data[i].equals(stack.pop()))) {
					return false;
				}
				System.out.println(stack.toString());
			}
			if (!(stack.empty())) {
				return false;
			}
		}
		return true;
	}
}

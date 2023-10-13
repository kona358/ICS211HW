package edu.ics211.h05;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedLinkedListTest {
	SortedLinkedList<Integer> intList = null;
	SortedLinkedList<Double> doubleList = null;
	SortedLinkedList<String> strList = null;

	@BeforeEach
	void setUp() {
		intList = new SortedLinkedList<Integer>();
		doubleList = new SortedLinkedList<Double>();
		strList = new SortedLinkedList<String>();

	}

	@Test
	void testSize() {
		intList.add(1);
		intList.add(2);
		assertEquals(2, intList.size(), "size should be 2");
	}
	@Test
	void testGet() throws IndexOutOfBoundsException{
		doubleList.add(22.6);
		doubleList.add(43.2);
		assertEquals(43.2, doubleList.get(1), "Index 1 Should be 43.2");
	}



	//finish writing
	@Test
	void testAdd(){
		strList.add("John");
		strList.add("John"); // shouldnt add duplicates
		strList.add("Alice");
		strList.add("Joel");
		strList.add("Ellie");
		assertEquals("Alice Ellie Joel John", strList.toString());
	}
	@Test
	void testRemoveA(){
		strList.add("John");
		strList.add("Alice");
		strList.add("Joel");
		strList.add("Ellie");
		strList.remove("Alice");
		assertEquals("Ellie Joel John", strList.toString());
		
	}
	@Test
	void testRemoveBC(){
		strList.add("John");
		strList.add("Alice");
		strList.add("Joel");
		strList.add("Ellie");
		strList.remove("Joel");
		strList.remove("Frank");// frank is not in list

		assertEquals("Alice Ellie John", strList.toString());
		strList.remove("John");
		assertEquals("Alice Ellie", strList.toString());

		
	}

	@Test
	void testIndexOf(){
		strList.add("John");
		strList.add("Alice");
		strList.add("Joel");
		strList.add("Ellie");
		assertEquals(strList.indexOf("Alice"), 0);
		assertEquals(strList.indexOf("Bill"), -1);


	}
	

}

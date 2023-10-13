package edu.ics211.h04;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedArrayListTest {
	SortedArrayList list;
	String[] s1 = {"Alice","Bob","Jane","Tony"};
	@BeforeEach
	void setUp(){
		
		list = new SortedArrayList();
	}

	@Test
	void testAdd() {
		list.add("Jane");
		list.add("Bob");
		
		list.add("Alice");
		list.add("Tony");
		
		//checks the sorting algo is doing alpha sort correctly.	
	assertEquals(list.get(0),s1[0]);
	assertEquals(list.get(1),s1[1]);
	assertEquals(list.get(2),s1[2]);
	assertEquals(list.get(3),s1[3]);
		System.out.print(list);
	assertEquals(list.size(), 4);
	// checks that the add method is not adding duplicate strings
	list.add("jane");
	list.add("bob");
	System.out.println(list);
	assertNotEquals(list.get(3), "jane"); 
	
	}
	@Test
	void testRemove() {
		list.add("Jane");
		list.add("Bob");
		list.add("Alice");
		list.add("Tony");
		
		list.remove("Bob");
		
		assertEquals(list.get(1),s1[2]);
		//check bad cases
		list.remove("bob");
		
		assertEquals(list.toString(), "Alice Jane Tony");
	}
	@Test
	void testIndexOf() {
		list.add("Jane");
		list.add("Bob");
		list.add("Alice");
		list.add("Tony");
		assertEquals(list.indexOf("Jane"),2);
		//check bad cases as well
		assertNotEquals(list.indexOf("Jane"), 1);
		
	}
	
	@Test
	void testToString() {
		list.add("Jane");
		list.add("Bob");
		list.add("Alice");
		list.add("bob");
		list.add("Tony");
		assertEquals(list.toString(), "Alice Bob Jane Tony");
	}

}

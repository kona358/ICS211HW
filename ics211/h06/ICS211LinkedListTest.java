package edu.ics211.h06;


import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ICS211LinkedListTest {

	ICS211LinkedList myList;
	final static String[] strArray = { "Jane", "Bob", "Alice", "Frank"};
	@BeforeEach
	void setUp() throws Exception {
		myList = new ICS211LinkedList();
		for (int i = 0; i < strArray.length; i++) {
			myList.add(strArray[i]);
		}
	}

	@Test
	void testICS211LinkedListForEach() {
		String temp = "";
		int count = 0;
		for (Object name : myList) {
			temp += name;
			if (count < myList.size - 1) {
				temp += " ==> ";
			}
			count++;
		}
		assertEquals(temp, myList.toString(),
			"generated String should be \"Jane ==> Bob ==> Alice ==> Frank\"");
	}

	@SuppressWarnings("unchecked")
	@Test
	void testICS211LinkedListCheckCorrectValues() {
		java.util.Iterator myIterator = myList.iterator();
		for (int i = 0; i < myList.size; i++) {
			assert(myIterator.next().equals(strArray[i]));
			System.out.println("Correct value passed for " + strArray[i]);
		}
	}

	@Test
	void testICS211LinkedListRemoveHead() {
		myList.remove(0);
		assertEquals("Bob ==> Alice ==> Frank", myList.toString(),
			"toString() should return \"Bob ==> Alice ==> Frank\"");
	}

   /*
   Please write a unit test for testICS211LinkedListRemoveTail() to
   remove from myList.size-1
   "toString() should return \"Jane ==> Bob ==> Alice\"
   */
  @Test
  void testICS211LinkedListRemoveTail(){
    myList.remove(myList.size-1);
    assertEquals( "Jane ==> Bob ==> Alice", myList.toString(),  "toString() should return \"Jane ==> Bob ==> Alice\"");

  }

	/*
   Please write a unit test for testICS211LinkedListRemoveInBetween()
   to remove from index 1
   "toString() should return \"Jane ==> Alice ==> Frank\"
   */
  @Test
  void testICS211LinkedListRemoveInBetween(){
    myList.remove(1);
    assertEquals("Jane ==> Alice ==> Frank", myList.toString());
  }


	@Test
	void testICS211LinkedListRemoveIndexNegativeOne() {
		try {
			myList.remove(-1);
			fail("Should have thrown IndexOutOfBoundsException");
		}
		catch (IndexOutOfBoundsException e) {}

	}

   /*
   Please write a unit test for testICS211LinkedListRemoveIndexEqualsSize()
   to remove from myList.size. You will need a try with a fail and will need
   to catch an IndexOutOfBoundsException
   */
  @Test
  void testICS211LinkedListRemoveIndexEqualsSize(){
    try {
		myList.remove(myList.size);
		fail("Should have thrown IndexOutOfBoundsException");
    } catch (IndexOutOfBoundsException e) {

	}
  }


	@SuppressWarnings("unchecked")
	@Test
	void testLinkedListIteratorRemoveHead() {
		java.util.Iterator myIterator = myList.iterator();
		myIterator.next();
		myIterator.remove();
		assertEquals("Bob ==> Alice ==> Frank", myList.toString(),
			"toString() should return \"Bob ==> Alice ==> Frank\"");
	}

   /*
   Please write a unit test for testLinkedListIteratorRemoveTail().
   You will need to re-initialize myIterator. Then, you will need a while loop
   that uses hasNext() and next() to get to the end of the list.
   Finally, call remove() and use assertEquals to compare the expected String
   to the actual String returned by myList.toString().
   "toString() should return \"Jane ==> Bob ==> Alice\"
   */
  @Test
  void testLinkedListIteratorRemoveTail(){
	java.util.Iterator myIterator = myList.iterator();
	while(myIterator.hasNext()){
myIterator.next();
	}
	myIterator.remove(); // removes the last node in the LinkedList
	assertEquals("Jane ==> Bob ==> Alice", myList.toString(), "toString() should return \"Jane ==> Bob ==> Alice\"" );


  }

	/*
   Please write a unit test for testLinkedListIteratorRemoveInBetween().
   You will need to re-initialize myIterator. Then, you will need an index
   based for loop that goes up to myList.size/2.
   Finally, outside of the for loop, call remove() and use assertEquals to compare the expected String
   to the actual String returned by myList.toString().
   "toString() should return \"Jane ==> Alice ==> Frank\"
   */
@Test
void testLinkedListIteratorRemoveInBetween(){
	java.util.Iterator myIterator = myList.iterator();

	for(int i = 0; i<myList.size/2;i++){
		if(myIterator.hasNext()){
			myIterator.next();
		}
	}
	myIterator.remove();
	assertEquals("Jane ==> Alice ==> Frank", myList.toString());
}

	@SuppressWarnings("unchecked")
	@Test
	void testLinkedListIteratorRemoveBeforeFirstNext() {
		java.util.Iterator myIterator = myList.iterator();
		try {
			myIterator.remove();
        }
        
		catch (IllegalStateException e) {

        }
	}
	/*
   Please write a unit test for testLinkedListIteratorRemoveAfterLastNext().
   You will need to re-initialize myIterator. Then, you will need a while loop
   that uses hasNext() and next() to get to the end of the list.
   Then, inside of a try, call next() and use a fail. Catch the java.util.NoSuchElementException.
   */
  @Test
  void testLinkedListIteratorRemoveAfterLastNext(){
	java.util.Iterator myIterator = myList.iterator();
while(myIterator.hasNext()){
	myIterator.next();
}
try {
	myIterator.next();
	fail("Should have thrown NoSuchElementException");
} catch (NoSuchElementException e) {
	// TODO: handle exception
}
  }

}
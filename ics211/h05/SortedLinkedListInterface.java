package edu.ics211.h05;

/**
 * 
 * @author lucas horsman, taryn, esb
 *
 * @param <E>
 */
public interface SortedLinkedListInterface<E extends Comparable<E>> {
	// List methods that are useful for a sorted linked list

	/**
	 * 
	 * @return the size of the SortedLinkedList
	 */
	int size();

	/**
	 * gets the value at provided index. uses the jump helper method
	 * 
	 * @param index
	 * @return true if the value is added, false if it was already present
	 * @throws Exception
	 */
	E get(int index) throws Exception;

	/**
	 * adds value to the SortedLinkedList, sorted using .compareTo, O(n) time complexity. 
	 * @param value the value that we want to add to the SortedLinkedList
	 * @return return true if the value has been removed, false if it was not
	 *         present
	 * 
	 */
	boolean add(E value);
/**
 * Removes the value from the SortedLinkedList
 * @param value value to be removed from the SortedLinkedList
 * @return false if the value is not in the SortedLinkedList, true if it could be found and removed
 */
	boolean remove(E value);

	int indexOf(E value);

/**
 * Prints each of the SortedLinkedList elements in sorted order, separated by a space.
 * @return
 */
	String toString();
}
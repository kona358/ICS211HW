package edu.ics211.h04;
public interface SortedArrayListInterface {
	  // List methods that are useful for a sorted array list
	/**
	 * This method returns an int that corresponds to the number of items
	 * stored in the list.
	 * @return the int which is the number of items in the list.
	 * @author lucas horsman
	 */  
	int size();
	
/**
 * 	 This method returns a string based on the param "index".
 * We access an array, and use this index to choose our element.
 * @param index of the desired ArrayList element
 * @return the element in the ArrayList at specified index 
 */
	  String get(int index);
/**
 * Adds the String parameter "value" to the ArrayList, to an alphabetically sorted position
 * Ignores case of ArrayList elements, meaning strings "A" and "a" cannot both be in the ArrayList
 * 
 * @param value to add to the ArrayList 
 * @return true if the value has been added, false if it was already present
 */

	  boolean add(String value);
	  /**
	   * Removes the specified element of type String from the ArrayList
	   * @param value to be removed from the ArrayList
	   * @return true if the value has been removed, false if it was not present
	   */
	  boolean remove(String value);
	  // return 
	  /**
	   * Gives the index in the ArrayList of the desired string element
	   * @param value of the desired string element
	   * @return the index at which the string can be found, or -1 if not found
	   */
	  int indexOf(String value);
	  
	  /**
	   * 
	   * @return value contents with blanks (" ") in-between
	   */
	  String toString();
	}
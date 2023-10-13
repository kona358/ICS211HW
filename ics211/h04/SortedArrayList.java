package edu.ics211.h04;

import java.util.Arrays;

/**
 * This class is used to store Strings in alphabetic order. When a new
 * String is added, it starts at the end of the list and is moved left
 * until the list is back in alphabetic order. The same String cannot
 * be added more than once. So, all items in the list are unique.
 * Items can be removed from the list by specifying the value of the
 * String to be removed. When String values are compared, the case
 * of the Strings are ignored.
 * 
 * @author username
 *
 */
public class SortedArrayList implements SortedArrayListInterface {

	private String[] data;
	private int count;

	public SortedArrayList() {
		data = new String[1];
		count = 0;
	}

	@Override
	public int size() {

		return count;
	}

	@Override
	public String get(int index) {
		return data[index];
	}

	private void grow() {
		// set data to copy of itself with 3 extra spaces
		data = Arrays.copyOf(data, data.length + 3);
	}

	@Override
	public boolean add(String element) {
	
		if (count == data.length) {
			grow();
		}
		//data[count] = value;
		 int i = count - 1;
	        while (i >= 0 && element.compareToIgnoreCase( data[i]) < 0) {
	            i--;
	        }

	        if (i >= 0 && element.compareToIgnoreCase(data[i]) == 0) {
	            return false;
	        }

	        for (int j = count; j > i + 1; j--) {
	            data[j] = data[j - 1];
	        }
	        data[i + 1] = element;
	        count++;
	        return true;
	    }

	@Override
	public boolean remove(String value) {
		int tempIndex = indexOf(value); 
		if (tempIndex == -1) {
			return false;
		}
		for(int i=tempIndex;i<count-1;i++){
			data[i] = data[i+1];
			
		}
		count--;

		return true;
	}

	@Override
	public int indexOf(String value) {
		// use a for loop to iterate through all Strings in the list
		// if there is a match, store the index and break the for loop
		// returns -1 if index is not found.
		int index = -1;
		for (int i = 0; i < count; i++) {
			if (value.equalsIgnoreCase(data[i])) {
				index = i;
				break;
			}
		}

		return index;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < count; i++) {
			sb.append(data[i]);
			if (i<count-1) {
				sb.append(" ");
			}
		}
		// Use a for loop to iterate over all Strings in the list
		// If the String is not the last item in the list, add a space
		return sb.toString();
	}
	

}

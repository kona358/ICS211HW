package edu.ics211.h05;

public class SortedLinkedList<E extends Comparable<E>> implements SortedLinkedListInterface<E> {

	private static class LinkedNode<T> {
		private T item;
		private LinkedNode<T> next;

		private LinkedNode(T value) {
			item = value;
			next = null;
		}

		private LinkedNode(T value, LinkedNode<T> reference) {
			item = value;
			next = reference;
		}

		public String toString() {
			return this.item.toString();
		}
	}

	// instance variables for SortedLinkedList class
	protected LinkedNode<E> head;
	protected LinkedNode<E> tail;
	protected int size;

	/*
	 * The following private methods are used to verify the integrity of the linked
	 * list
	 * after calling the public methods add() or remove()
	 */

	private void verify(boolean mustBeTrue) {
		if (!mustBeTrue) {
			throw new java.lang.AssertionError("assertion error");
		}
	}

	private void checkInvariants() {
		// uncomment the next line to skip the checks:
		// return;
		// either head and tail are both null, or neither is null.
		// size is zero if and only if they are null, and otherwise is positive
		verify((head == null) == (tail == null));
		verify((size == 0) == (head == null));
		verify(size >= 0);
		// if the list only has one element, head should be the same as tail
		// (and also if the list has no elements), otherwise they should differ
		verify((head == tail) == (size <= 1));
		// a non-null tail variable should always have a null "next" field
		verify((tail == null) || (tail.next == null));
		// check to make sure size is the same as the length of the list.
		// this code takes O(n), so comment it out if performance is important
		int measuredSize = 0;
		LinkedNode<E> node = head;
		// if visitedLast is null, the list is empty, and tail should also be null
		LinkedNode<E> visitedLast = null;
		while (node != null) {
			visitedLast = node;
			node = node.next;
			measuredSize++;
		}
		verify(measuredSize == size);
		// also make sure "last" really is the last node in the linked list
		verify(visitedLast == tail);
	}

	/* end of verification methods */

	// constructor
	public SortedLinkedList() {
		head = null;
		tail = null;
		size = 0;
		checkInvariants();
	}

	/*
	 * helper methods to make it easier to write the public add() and remove()
	 * methods
	 */

	/**
	 * adds at the head of the list
	 * 
	 * @param the value to be added
	 */
	private void addAtFront(E value) {
		head = new LinkedNode<E>(value, head);
		if (tail == null) {
			tail = head;
		}
	}

	/**
	 * adds at the tail of the list. Assumes (and checks) that tail is not null
	 * 
	 * @param the value to be added
	 * @throws RuntimeException
	 */
	private void addAtEnd(E value) {
		if (tail == null) {
			throw new RuntimeException("invalid call to addAtEnd, tail is null");
		}
		LinkedNode<E> newNode = new LinkedNode<E>(value);
		tail.next = newNode;
		tail = newNode;
	}

	private LinkedNode<E> jump(int numJumps) {
		if (numJumps < 0) {
			return null;
		}
		LinkedNode<E> node = head;
		for (int i = 0; i < numJumps; i++) {
			node = node.next;
		}
		return node;
	}

	/* end of helper methods */

	@Override
	public int size() {
		// probably right
		return size;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		// this must be fixed.
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Invalid index to get node");
		}
		LinkedNode<E> node = jump(index);
		return node.item;
	}

	@Override
	public boolean add(E value) {
		checkInvariants();
		if (size == 0) {
			addAtFront(value);
			size++;
		} else {
			if (indexOf(value) == -1) {// index of -1 means value is not already in list
				addAtEnd(value);
				size++;
				int pos = indexOf(value);// index is now at end of list
				LinkedNode<E> prev = jump(pos - 1);
				LinkedNode<E> newNode = jump(pos);
				while (pos > 0 && prev.item.compareTo(value) > 0) {
					E temp = prev.item;
					prev.item = newNode.item;
					newNode.item = temp;
					newNode = prev;
					pos--;  
					prev = jump(pos - 1);

				}

			} else {
				checkInvariants();
				return false;
			}

		}
		return true;
	}

	@Override
	public boolean remove(E value) {
		int index = indexOf(value); // index of the value we want to remove
		if ((index == -1)) {
			return false;
		}		
		LinkedNode<E> prev = jump(index-1);
		if(prev==null){// link to remove is at head
			head=head.next;
		}
		else{//link to remove is not at head
			prev.next = prev.next.next;
			if(prev.next == null){
				tail = prev;
			}

		}
		size--;
		return true;

	}

	@Override
	public int indexOf(E value) {
		int index = -1;
		LinkedNode<E> node = head;
		for (int i = 0; i < size; i++) {
			if (node.item.compareTo(value) == 0) {
				index = i;
				break;
			}
			node = node.next;
		}
		return index;
	}

	public String toString() {
		String temp = "";
		LinkedNode<E> node = head;
		for (int i = 0; i < size; i++) {
			temp += node.item;
			if (i < size - 1) {
				temp += " ";
			}
			node = node.next;
		}
		return temp;
	}
}
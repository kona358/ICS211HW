package edu.ics211.h07;

import java.util.EmptyStackException;

public class LinkedStack<E> implements StackInterface<E> {

    // the stack is stored in linked nodes

    /**
     * A node in a singly-linked list
     * 
     * @author Edo Biagioni
     * @lecture ICS 211 Jan 27 or later
     * @date January 26, 2010
     * @bugs private class: include this code within a larger class
     */

    private static class LinkedNode<T> {
        private T item;
        private LinkedNode<T> next;

        /**
         * constructor to build a node with no successor
         * 
         * @param the value to be stored by this node
         */
        private LinkedNode(T value) {
            item = value;
            next = null;
        }

        /**
         * constructor to build a node with a specified (perhaps null) successor
         * 
         * @param the value to be stored by this node
         * @param the next field for this node
         */
        private LinkedNode(T value, LinkedNode<T> reference) {
            item = value;
            next = reference;
        }
    }

    protected LinkedNode<E> top;
    private int size;

    /* no-arguments default constructor creates an empty stack */
    public LinkedStack() {
        top = null; // empty stack
        size = 0;
    }

    /* @return whether the stack is empty */
    public boolean empty() {
        checkInvariants();

        return (top == null);
    }

    /* @param value to push onto the stack */
    public E push(E value) {
        checkInvariants();
        top = new LinkedNode<E>(value, top);
        size++;
        checkInvariants();
        return value;
    }

    /* @return the top value on the stack */
    public E pop() throws EmptyStackException {
        checkInvariants();
        if (empty()) {
            throw new EmptyStackException();
        }
        E result = top.item;
        top = top.next;
        size--;
        checkInvariants();
        return result;
    }

    /* @return the top value on the stack */
    public E peek() throws EmptyStackException {
        checkInvariants();
        if (empty()) {
            throw new EmptyStackException();
        }
        checkInvariants();
        return top.item;
    }

    /*
     * convert the stack to a printable string
     * 
     * @return a string representing the stack
     */
    public String toString() {
        checkInvariants();
        if (empty()) {
            return "Empty Stack";
        } else {
            return recursiveToString(top);
        }
    }

    /*
     * recursive method to print a non-empty stack
     * 
     * @param the starting index in the array
     * 
     * @return a string representing the stack
     */
    private String recursiveToString(LinkedNode<E> startNode) {
        checkInvariants();
        if (startNode == null) {
            checkInvariants();
            return "";
        }
        String separator = "";
        if (startNode != top) { // add :: after each item (but not at start)
            checkInvariants();
            separator = " :: ";
        }
        checkInvariants();
        return separator + startNode.item + recursiveToString(startNode.next);
    }

    private void verify(boolean mustBeTrue) {
        if (!mustBeTrue) {
            throw new java.lang.AssertionError("assertion error");
        }
    }

    private void checkInvariants() {
        verify((top == null) == (size == 0));
        verify(size >= 0);
        LinkedNode<E> node = top;
        int measuredSize = 0;
        LinkedNode<E> visitedLast = null;
        while (node != null) {
            visitedLast = node;
            node = node.next;
            measuredSize++;
        }
        verify(measuredSize == size);
        // add code to verify that measuredSize and size
        // agree. This is similar to what is used in the
        // LinkedList.java file.
    }

    // simple test
    public static void main(String[] args) {
        StackInterface<String> s = new LinkedStack<String>();

        System.out.println("before pushing anything, " + s);
        s.push("one");
        s.push("two");
        System.out.println("after pushing one and two, " + s);
        System.out.println("pop returns " + s.pop());
        System.out.println("after popping, " + s);
        StackInterface<Integer> si = new LinkedStack<Integer>();
        // push 100 values -- this is fine for LinkedStack
        for (int i = 0; i < 100; i++) {
            si.push(i);
        }
        // now pop them and make sure the same values are returned
        // in LIFO order
        for (int i = 99; i >= 0; i--) {
            Integer returned = si.pop();
            if (!returned.equals(i)) {
                System.out.println("error: pop returns " + returned +
                        ", expected " + i);
            }
        }
        s.push("a");
        s.push("dreadful");
        s.push("night");
        System.out.println("after pushing 'a dreadful night', " + s);
        System.out.println("pop returns " + s.pop());
        System.out.println("pop returns " + s.pop());
        System.out.println("pop returns " + s.pop());
        System.out.println("pop returns " + s.pop());
        System.out.println("after popping, " + s);
        /*
         * expected output:
         * before pushing anything, Empty Stack
         * after pushing one and two, two :: one
         * pop returns two
         * after popping, one
         * after pushing 'a dreadful night', night :: dreadful :: a :: one
         * pop returns night
         * pop returns dreadful
         * pop returns a
         * pop returns one
         * after popping, Empty Stack
         */

    }

}
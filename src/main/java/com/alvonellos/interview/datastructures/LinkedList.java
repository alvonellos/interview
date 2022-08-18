package com.alvonellos.interview.datastructures;

import java.util.Iterator;

/**
 * A simple homebrew linked list class as a coding exercise. 
 * @author alex
 *
 * @param <T> Generic Paramter Type
 * 
 */
public class LinkedList<T extends Comparable<T>> implements Iterable<T>{
	
	protected final static boolean DEBUG = false;      // Enables / disables debug messages.
	protected Node<T> head; // Head node. 
	protected int     size =0; //Start is 0 in it, but otherwise it's 1
	
	/**
	 * A simple iterator implementation for this class
	 * @author alex
	 *
	 * @param <T>
	 */
	@SuppressWarnings("hiding")
	protected static class LLIterator<T extends Comparable<T>> implements Iterator<T> {
		private Node<?> cursor;
		
		/**
		 * Ctor. You should be supplying "this" as the parameter
		 * @param obj the object to iterate over
		 */
		public LLIterator(LinkedList<?> obj) {
		        this.cursor = obj.head;   
		}
		
		/**
		 * Returns whether or not there is a next node. 
		 * @return true if there is a next node
		 */
		@Override
		public boolean hasNext() {
			return cursor != null;
		}

		/**
		 * Fetches the next data from the next node, then updates the cursor
		 * @return the data from the next node. 
		 */
		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			if(cursor != null) { 
				T datum = (T) cursor.getDatum();
				cursor=cursor.getNext();
				return datum;
			}
			return null;
		}
	}
	
	/**
	 * CTOR Implementation of the linked list.
	 */
    public LinkedList() { 
    	this.head = new Node<>();
    	this.head.setPrev(null);
    	this.head.setNext(null);
    	this.head.setHead(true);
    }
    
    // List Interface Methods
    
    /**
     * Fetches the size. Keep in mind this starts at 1 by default empty since the head occupies space. 
     * @return the size of the list
     */
	public int size() {
		return this.size;
	}

	/**
	 * Boolean to test whether or not this is empty. 
	 * @return true if this is empty and false otherwise
	 */
	public boolean isEmpty() {
		return size() == 0;
	}


	/**
	 * Adds an object to the list
	 * @param e the data to add
	 */
	public void add(T e) {
		if(this.size() < 1) { 
			this.head.setDatum(e);
			debug("hit base case");
		} else {
			debug("hit size > 1");
			Node<T> nn = new Node<>();
			nn.setDatum(e);
			nn.setNext(null);
			nn.setHead(false);
			
			//Seek to end;
			Node<T> cur; 
			for(cur = head; cur.getNext() != null; cur=cur.getNext()) {	}
			
			cur.setNext(nn);
			nn.setPrev(cur);
		}
		size += 1;

	}

	/**
	 * Remove an object from the list, by searching for the data first. 
	 * @param key the data to remove
	 * @return true if the object was removed. False if it was not. 
	 */
	public boolean remove(T key) {
		Node<T> temp = head, prev = null;

		if(size == 0) { return false; }
		if(size == 1) { this.clear(); this.size =0; return true; }
 
        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.getNext()
        while (temp != null && temp.getDatum() != key) {
            prev = temp;
            temp = temp.getNext();
        }
 
        // If key was not present in linked list
        if (temp == null)
            return false;
 
        // Unlink the node from linked list
		assert(prev != null);
        prev.setNext(temp.getNext());
        size -= 1;
		return true;
	}
	
	
	/**
	 * Clears the linked list
	 */
	public void clear() {
		size = 0;
    	this.head = new Node<>();
    	this.head.setPrev(null);
    	this.head.setNext(null);
    	this.head.setHead(true);
	}

	/**
	 * Fetches the node at an index. 
	 * @param index The index to search for
	 * @return the node or null. 
	 * @throws IllegalArgumentException if the index is greater than the size, or if the index is less than 1.
	 */
	public Node<T> get(int index) throws IllegalArgumentException {
		if(index <= 0) throw new IllegalArgumentException("index must be greater than 0");
		if(index > size) throw new IllegalArgumentException("index must be less than size");

		Node<T> cur; 
		int i;
		for(cur = head, i = 1; cur != null; cur=cur.getNext(), i++) {
			if(i == index) { return cur; } 
		}
		return null;
	}

	

	/**
	 * Gets the index of a particular datum. 
	 * @param o the data to search for. 
	 * @return -1 if not found
	 */
	public int indexOf(T o) {
		Node<T> cur; 
		int i;
		for(cur = head, i = 1; cur != null; cur=cur.getNext(), i++) {
			if(cur.getDatum().equals(o)) { return i; } 
		}
		return -1;
	}

	/**
	 * Reverse the linked list
	 */
	public void reverse() {
		this.head = reverseList(this.head);
	}

	/**
	 * Internal driver method to reverse the linked list recursively
	 * @param head the head of the list
	 * @return the new head
	 */
	protected Node<T> reverseList(Node<T> head) {
		if(head == null || head.getNext() == null) {
			return head;
		}

		Node<T> next = head.getNext(); // get next node
		head.setNext(null); // set next node to null
		Node<T> newHead = reverseList(next); // recursively reverse list
		next.setNext(head); // set next node to head
		return newHead; // return the new head
	}

	/**
	 * Gets the string representation of the list
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> cur;
		for(cur = this.head; cur != null; cur=cur.getNext()) {
			sb.append(cur.getDatum().toString());
			sb.append(" ");
		}
		return sb.substring(0,sb.length()-1).replace(" ", ", ");
	}


	/**
	 * Get an iterator for this object
	 */
	@Override
	public Iterator<T> iterator() {
		return new LLIterator<>(this);
	}

    /**
     * Debug function
     * @param message the debug message to print
     */
	protected static void debug(String message) { 
		if(DEBUG) { 
			System.err.println("Message: " + message); 
		}	
	}
}

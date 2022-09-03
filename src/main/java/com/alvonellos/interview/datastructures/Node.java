package com.alvonellos.interview.datastructures;

import lombok.extern.java.Log;

import static com.alvonellos.interview.util.java.AddressUtil.addrString;

/**
 * Fully generic node class for utilization in other data structures that need a node
 *
 * @param <T> Type
 * @author Alex Alvonellos
 * @implNote Implements comparable through and through
 */
@Log
public class Node<T extends Comparable<? super T>> implements Comparable<Node<T>> {
    private static final boolean DEBUG = false;
    private Node<T> next;
    private Node<T> prev;

    private T datum;
    private boolean isHead = false;

    /**
     * Special constructor for one node with a boolean variable denoting whether this node is a head or not.
     *
     * @param isHead Is this the head?
     * @param datum  The data to store.
     */
    public Node(boolean isHead, T datum) {
        this.setDatum(datum);
        this.setHead(isHead);
        debug("ctor: Node(boolean isHead, T datum) " + this);
    }

    /**
     * Generic constructor for just one node with a datum;
     *
     * @param datum the data to store in the node
     */
    public Node(T datum) {
        this(false, datum);
        this.setDatum(datum);
        debug("ctor: Node(T datum) " + this);
    }

    /**
     * Generic constructor for two nodes with a datum and a next node.
     * @param leftOrPrev the left or previous node
     * @param rightOrNext the right or next node
     * @param datum the datum of the node
     */
    public Node(Node<T> leftOrPrev, Node<T> rightOrNext, T datum) {
        this(false, datum);
        this.setLeft(leftOrPrev);
        this.setRight(rightOrNext);
        debug("ctor: Node(Node left, Node right, T datum) " + this);
    }

    /**
     * sets the right node of the current node
     * @param right the node to set
     */
    private void setRight(Node<T> right) {
        this.setNext(right);
    }

    /**
     * sets the left node of the current node
     * @param left the node to set
     */
    private void setLeft(Node<T> left) {
        this.prev = left;
    }


    /**
     * This constructor sets just a blank node with default values.
     */
    public Node() {
        this(false, null);
        this.isHead = false;
        this.datum = null;
        debug("ctor: Node() " + this);
    }


    public Node<T> getLeft() {
        return this.getPrev();
    }

    public Node<T> getRight() {
        return this.getNext();
    }

    /**
     * gets the next node
     *
     * @return the next node
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * Sets the next node
     *
     * @param next the next node
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * gets the previous node
     *
     * @return The previous node
     */
    public Node<T> getPrev() {
        return this.prev;
    }

    /**
     * Sets the previous node
     *
     * @param prev The previous node
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    /**
     * sets whether or not this is the head.
     *
     * @param value true if it is the head, false if it is not.
     */
    public void setHead(boolean value) {
        this.isHead = value;
    }

    /**
     * Returns whether or not this node has been specified as the head.
     *
     * @return a boolean, true if it is the head, and false if it is not
     */
    public boolean getHead() {
        return this.isHead;
    }

    /**
     * Sets the datum stored in this object
     *
     * @param datum the datum.
     */
    public void setDatum(T datum) {
        this.datum = datum;
    }

    /**
     * Gets the datum stored in this object
     *
     * @return the datum
     */
    public T getDatum() {
        return this.datum;
    }


    // String representation of this object.
    public String toString() {
        String s = "";
        s += " This-> " + addrString(this);
        s += " Prev-> " + addrString(prev);
        s += " Next-> " + addrString(next);
        String datums = (this.datum != null) ? this.datum.toString() : "null";
        s += " Datum->" + datums;
        s += " isHead->" + this.isHead;
        return s;

    }


    @Override
    public int compareTo(Node<T> o) {
        return this.getDatum().compareTo(o.getDatum());
    }

    @Override
    public boolean equals(Object o) {
        try {
            return this.compareTo((Node<T>) o) == 0;
        } catch (ClassCastException e) {
            return false;
        }
    }

    private void debug(String message) {
        if (DEBUG) {
            log.info(message);
        }
    }

} // End Class

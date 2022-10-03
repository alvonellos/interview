package com.alvonellos.interview.datastructures;

import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

import static com.alvonellos.interview.util.java.AddressUtil.addrString;


@Log
public class CircularLinkedList<T extends Comparable<T>> extends LinkedList<T> implements Comparable<T>, Iterable<T> {
    public CircularLinkedList() {
        super();
        log.entering("CircularLinkedList", "CircularLinkedList");
        super.head = new Node<T>(null, null, null);
        log.info("head: " + addrString(super.head));
        log.exiting("CircularLinkedList", "CircularLinkedList");
    }

    @Override
    public Node<T> get(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        Node<T> cursor = head;
        for(int i = 0; i < index; i++) {
            cursor = cursor.getNext();
        }
        return cursor;
    }

    @Override
    public void add(T element) {
        log.entering("CircularLinkedList", "add", element);


        if(size == 0) { // size is 0
            log.info("size is 0");
            super.head = new Node<T>(super.head, super.head, element);
            size++;
        } else if (size == 1) { // size is 1
            log.info("size is 1");

            Node<T> newNode = new Node<T>(null, null, element);
            log.info("newNode: " + addrString(newNode));

            super.head.setNext(newNode);
            super.head.setPrev(newNode);
            newNode.setNext(super.head);
            newNode.setPrev(super.head);
            size++;
        } else { // size is 2 or more
            log.info("size is 2 or more");

            Node<T> newNode = new Node<T>(null, null, element);
            log.info("newNode: " + addrString(newNode));

            Node<T> lastNode = head.getPrev();
            lastNode.setNext(newNode);
            newNode.setPrev(lastNode);
            newNode.setNext(super.head);
            super.head.setPrev(newNode);
            size++;
        }

        log.exiting("CircularLinkedList", "add", element);
    }

    @Override
    public boolean remove(T element) {
        if (size == 0) {
            return false;
        } else if (size == 1) {
            super.head.setDatum(null);
            size--;
            return true;
        } else {
            Node<T> cursor = super.head;
            while (cursor.getNext() != head) {
                if (cursor.getDatum().equals(element)) {
                    pickAndPatch(cursor);
                    size--;
                    return true;
                }
                cursor = cursor.getNext();
            }
            return false;
        }
    }

    boolean pickAndPatch(Node<T> node) {
        debug("Picking and patching node " + node + " with data " + node.getDatum() + " and prev " + node.getPrev() + " and next " + node.getNext());
        Node<T> previous = node.getPrev();
        Node<T> next = node.getNext();
        previous.setNext(next);
        next.setPrev(previous);

        //free up memory so gc can collect it
        node.setNext(null);
        node.setPrev(null);
        node.setDatum(null);

        return true;
    }


    protected static class LLIterator<T extends Comparable<T>> implements Iterator<T> {
        private Node<?> cursor;
        private final Node<?> head;

        /**
         * Ctor. You should be supplying "this" as the parameter
         * @param obj the object to iterate over
         */
        public LLIterator(LinkedList<?> obj) {
            this.cursor = obj.head;
            this.head = obj.head;
        }

        /**
         * Returns whether there is a next node.
         * @return true if there is a next node
         */
        @Override
        public boolean hasNext() {
            return cursor.getNext() != head;
        }

        /**
         * Fetches the next data from the next node, then updates the cursor
         * @return the data from the next node.
         */
        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            Node<?> head = cursor;

            StringBuffer sb = new StringBuffer();
            sb.append(" head = "); sb.append(addrString(head));
            sb.append(" cursor: "); sb.append(addrString(cursor));
            sb.append(" cursor.getNext(): "); sb.append(addrString(cursor.getNext()));
            sb.append(" cursor.getPrev(): "); sb.append(addrString(cursor.getPrev()));
            log.info(sb.toString());

            cursor = cursor.getNext();
            if(cursor != head) {
                T datum = (T) cursor.getDatum();
                cursor=cursor.getNext();
                return datum;
            }
            return null;
        }
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
     * for all {@code x} and {@code y}.  (This
     * implies that {@code x.compareTo(y)} must throw an exception iff
     * {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
     * all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(@NotNull T o) {
        if( o == null ) throw new NullPointerException();
        if ( o.getClass() != this.getClass() ) throw new ClassCastException();
        return this.hashCode() - o.hashCode();
    }
}

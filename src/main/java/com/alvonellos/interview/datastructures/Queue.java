package com.alvonellos.interview.datastructures;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class Queue <T extends Comparable<T>> implements Iterable<T> {
    private final int size;
    private final T[] elements;

    public Queue() {
        this(100);
    }
    public Queue(int size) {
        this.size = size;
        this.elements = (T[]) new Comparable[size];
    }

    /**
     * Adds an element to the queue.
     * @param element
     */
    public void enqueue(T element) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) {
                index = i;
                break;
            }
        }
        elements[index] = element;
    }

    /**
     * @return the element at the front of the queue.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T element = elements[0];
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                elements[i] = null;
            } else {
                elements[i] = elements[i + 1];
            }
        }
        return element;
    }

    /**
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if the queue is full
     * @return true if the queue is full, false otherwise
     */
    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * Look at the first element in the queue without removing it.
     * @return
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements[0];
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }
            @Override
            public T next() {
                return elements[index++];
            }
        };
    }
}
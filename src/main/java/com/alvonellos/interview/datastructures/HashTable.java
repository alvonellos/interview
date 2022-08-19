package com.alvonellos.interview.datastructures;

import java.util.Iterator;

/**
 * Class that implements a hashtable.
 *
 * @param <K> Key type
 * @Param <V> Value type
 * @author Alex Alvonellos
 * @implNote
 */
public class HashTable<K extends Comparable<K>, V extends Comparable<V>> implements Iterable<K> {
    private static final long serialVersionUID = 1L;

    private final int capacity;
    private final int[] keys;
    private final Object[] values;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.keys = new int[capacity];
        this.values = new Object[capacity];
    }

    public HashTable() {
        this(10);
    }

    /**
     * Inserts a key-value pair into the hashtable.
     * @param key The key to insert.
     * @param value The value to insert
     */
    public void put(K key, V value) {
        int hash = key.hashCode();
        int index = hash % capacity;
        if (keys[index] == 0) {
            keys[index] = hash;
            values[index] = value;
        } else { // there's already a key at this index
            int i = 1;
            while (keys[index] != 0) {
                index = (index + i) % capacity;
                i++;
            }
            keys[index] = hash;
            values[index] = value;
        }
    }

    /**
     * Gets the value associated with the key.
     * @param key The key to search for.
     * @return The value associated with the key.
     */
    public V get(K key) {
        int hash = key.hashCode();
        int index = hash % capacity;
        if (keys[index] == hash) {
            return (V) values[index];
        } else {
            int i = 1;
            while (keys[index] != hash) {
                index = (index + i) % capacity;
                i++;
            }
            return (V) values[index];
        }
    }

    /**
     * Removes the key-value pair from the hashtable.
     * @param key The key to remove.
     */
    public boolean contains(K key) {
        int hash = key.hashCode();
        int index = hash % capacity;
        if (keys[index] == hash) {
            return true;
        } else { // perform a full linear search
            for(int i = index; i < capacity; i++) {
                if (keys[i] == hash) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Removes the key-value pair from the hashtable.
     * @param key The key to remove.
     */
    public boolean remove(K key) {
        int hash = key.hashCode();
        int index = hash % capacity;
        if (keys[index] == hash) {
            keys[index] = 0;
            values[index] = null;
            return true;
        } else {
            int i = 1;
            while (keys[index] != hash) {
                index = (index + i) % capacity;
                i++;
            }
            keys[index] = 0;
            values[index] = null;
            return true;
        }
    }

    /**
     * Clears the hashtable.
     */
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            keys[i] = 0;
            values[i] = null;
        }
    }

    /**
     * Gets the size of the hashtable.
     * @return The size of the hashtable.
     */
    public int size() {
        int size = 0;
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != 0) {
                size++;
            }
        }
        return size;
    }

    /**
     * Gets the capacity of the hashtable.
     * @return The capacity of the hashtable.
     */
    public int capacity() {
        return capacity;
    }

    /**
     * Gets an iterator for the hashtable.
     * @return An iterator for the hashtable.
     */
    public Iterator<K> iterator() {
        return new HashTableIterator();
    }

    /**
     * Check if the hashtable is empty
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Iterator for the hashtable.
     * @author Alex Alvonellos
     * @implNote
     */
    private class HashTableIterator implements Iterator<K> {
        private int index = 0;
        private int lastIndex = -1;

        public boolean hasNext() {
            while (index < capacity && keys[index] == 0) {
                index++;
            }
            return index < capacity;
        }

        public K next() {
            lastIndex = index;
            index++;
            while (index < capacity && keys[index] == 0) {
                index++;
            }
            return (K) values[lastIndex];
        }

        public void remove() {
            keys[lastIndex] = 0;
            values[lastIndex] = null;
        }
    }
}
package com.alvonellos.interview.datastructures;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void put() {
        HashTable<String, String> hashTable = new HashTable<>();
        assert(hashTable.isEmpty());
        hashTable.put("a", "b");
        assert(!hashTable.isEmpty());
        assert(hashTable.get("a").equals("b"));
    }

    @Test
    void get() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("a", "b");
        assert(hashTable.get("a").equals("b"));
    }

    @Test
    void contains() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("a", "b");
        assert(hashTable.contains("a"));
    }

    @Test
    void remove() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("a", "b");
        assert(hashTable.contains("a"));
        hashTable.remove("a");
        assert(!hashTable.contains("a"));
    }

    @Test
    void clear() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("a", "b");
        assert(!hashTable.isEmpty());
        hashTable.clear();
        assert(hashTable.isEmpty());
    }

    @Test
    void size() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("a", "b");
        assert(hashTable.size() == 1);
    }

    @Test
    void capacity() {
        HashTable<String, String> hashTable = new HashTable<>(16);
        assert(hashTable.capacity() == 16);
    }

    @Test
    void iterator() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("a", "b");
        hashTable.put("b", "c");
        hashTable.put("c", "d");

        Iterator<String> iterator = hashTable.iterator();
        StringBuffer sb = new StringBuffer();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        assert(sb.length() == 3);
    }

    @Test
    void collisionTest() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("a", "b");
        hashTable.put("b", "c");
        hashTable.put("c", "d");
        hashTable.put("d", "e");
        hashTable.put("e", "f");
        hashTable.put("f", "g");
        hashTable.put("g", "h");
        hashTable.put("h", "i");
        hashTable.put("i", "j");
        hashTable.put("j", "k");
        hashTable.put("k", "l");
        hashTable.put("l", "m");
        hashTable.put("m", "n");
        hashTable.put("n", "o");
        hashTable.put("o", "p");

        assert(hashTable.size() == 15);

    }
}
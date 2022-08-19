package com.alvonellos.interview.datastructures;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void putTest() {
        HashTable<String, String> hashTable = new HashTable<>();
        assert(hashTable.isEmpty());
        hashTable.put("a", "b");
        assert(!hashTable.isEmpty());
        assert(hashTable.get("a").equals("b"));
    }

    @Test
    void getTest() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("a", "b");
        assert(hashTable.get("a").equals("b"));
    }

    @Test
    void getTestAndFailMissingIndex() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("a", "b");
        assert(hashTable.get("c") == null);
    }


    @Test
    void containsTest() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("a", "b");
        assert(hashTable.contains("a"));
    }

    @Test
    void containsTestAndFailMissingIndex() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("a", "b");
        assert(!hashTable.contains("c"));
    }

    @Test
    void removeTest() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("a", "b");
        assert(hashTable.contains("a"));
        hashTable.remove("a");
        assert(!hashTable.contains("a"));
    }

    @Test
    void removeTestAndLinearSearch() {
        HashTable<String, String> hashTable = new HashTable<>(10);
        hashTable.put("a", "b");

        //Use reflection to get the object array and the key array
        Object[] values = (Object[]) ReflectionTestUtils.getField(hashTable, "values");
        int[] keys = (int[]) ReflectionTestUtils.getField(hashTable, "keys");

        // put it at wrong index as if there was a collision
        keys[("c".hashCode() % 10) - 1] = "c".hashCode();
        values["c".hashCode() % 10 - 1] = "d";

        // Use reflection to set the object array and the key array
        ReflectionTestUtils.setField(hashTable, "keys", keys);
        ReflectionTestUtils.setField(hashTable, "values", values);

        assert(hashTable.contains("a"));
        assert(hashTable.remove("c")); // should work and it should go into the linear search
        assert(hashTable.contains("a"));
    }

    @Test
    void removeTestAndFailMissingIndex() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("a", "b");
        assert(hashTable.contains("a"));
        assert(!hashTable.remove("c")); // should not work and it should not go into the linear search
        assert(hashTable.contains("a"));
    }

    @Test
    void clearTest() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("a", "b");
        assert(!hashTable.isEmpty());
        hashTable.clear();
        assert(hashTable.isEmpty());
    }

    @Test
    void sizeTest() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("a", "b");
        assert(hashTable.size() == 1);
    }

    @Test
    void capacityTest() {
        HashTable<String, String> hashTable = new HashTable<>(16);
        assert(hashTable.capacity() == 16);
    }

    @Test
    void iteratorTest() {
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
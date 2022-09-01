package com.alvonellos.interview.util.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListManipulationTest {

    @Test
    void removeDuplicatesTest() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        assertEquals(6, list.size());
        new ListManipulation<String>().removeDuplicates(list);
        assertEquals(5, list.size());
    }

    @Test
    void removeDuplicatesTest2() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        assertEquals(6, list.size());
        new ListManipulation<String>().removeDuplicatesAlgorithm(list);
        assertEquals(5, list.size());
    }

    @Test
    void removeDuplicatesTestStreams() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        assertEquals(6, list.size());
        list = new ListManipulation<String>().removeDuplicatesStreams(list);
        assertEquals(5, list.size());
    }
}
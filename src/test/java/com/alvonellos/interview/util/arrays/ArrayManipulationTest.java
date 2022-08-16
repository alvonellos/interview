package com.alvonellos.interview.util.arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArrayManipulationTest {

    @Test
    void mergeSortedArrayTest() {
        Integer[] a1 = {1, 3, 5, 7, 9};
        Integer[] a2 = {0, 2, 4, 6, 8};
        Integer[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        ArrayManipulation<Integer> a = new ArrayManipulation<>();
        Integer[] output = a.mergeSortedArray(a1, a2, Integer[]::new);

        assert(output.length == expected.length);
        assertArrayEquals(output, expected);
    }
}
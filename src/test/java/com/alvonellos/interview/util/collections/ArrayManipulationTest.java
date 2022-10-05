package com.alvonellos.interview.util.collections;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.alvonellos.interview.util.collections.ArrayManipulation.removeDuplicates;
import static com.alvonellos.interview.util.collections.ArrayManipulation.triangularSum;
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

    @Test
    void triangularSumTest() {
        int[] input = {1, 2, 3, 4, 5};
        Integer expected = 8;
        Integer actual = triangularSum(input);
        assert(actual == expected);
    }

    @Test
    void removeDuplicatesTest() {
        int[] input = {1, 1, 2};
        int[] expected = {1, 2, 2};

        int output = removeDuplicates(input);

        assert(output == 2);
        assertArrayEquals(expected, input);
    }

    @Test
    void transposeTest() {
        int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[][] output = ArrayManipulation.transpose(input);
        assertArrayEquals(expected, output);
    }

    @Test
    void findMedianSortedArraysTest() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        double actual = ArrayManipulation.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual);
    }
}
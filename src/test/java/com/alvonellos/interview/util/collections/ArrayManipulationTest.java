package com.alvonellos.interview.util.collections;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

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

        input = new int[][] {{1, 2, 3}, {4, 5, 6}};
        expected = new int[][] {{1, 4}, {2, 5}, {3, 6}};
        output = ArrayManipulation.transpose(input);

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

    @Test
    void zigZagConversionTest() {
        String input = "PAYPALISHIRING";
        String expected = "PAHNAPLSIIGYIR";
        String actual = ArrayManipulation.zigZagConversion(input, 3);
        assertEquals(expected, actual);
    }

    @Test
    void loadArrayTest() {
        Scanner in = new Scanner("3 3" + "\n" + "1 2 3" + "\n" + "4 5 6" + "\n" + "7 8 9");
        int[][] expected = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] output = ArrayManipulation.loadArray(in);
        assertArrayEquals(expected, output);
    }

    @Test
    void saveArrayTest() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream pout = new PrintStream(out, true, java.nio.charset.StandardCharsets.UTF_8);

        int[][] input = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        String expected = "3 3" + "\n" + "1 2 3" + "\n" + "4 5 6" + "\n" + "7 8 9" + "\n";
        ArrayManipulation.saveArray(pout, input);
        assertEquals(expected, new String(out.toByteArray(), java.nio.charset.StandardCharsets.UTF_8));


    }
}
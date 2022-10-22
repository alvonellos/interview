package com.alvonellos.interview.util.collections;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.IntFunction;

public class ArrayManipulation<T extends Comparable<T>> {

    /**
     * Take two collections that are sorted and merge them together into one array.
     * @param array1 The first array to merge
     * @param array2 The second array to merge
     * @param arrayCreator the initializer method to be called to create the new array
     * @return the merged array.
     */
    T[] mergeSortedArray(T[] array1, T[] array2, IntFunction<T[]> arrayCreator) {
        T[] result = arrayCreator.apply(array1.length + array2.length);
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i].compareTo(array2[j]) < 0) {
                result[k] = array1[i];
                i++;
            } else {
                result[k] = array2[j];
                j++;
            }
            k++;
        }
        while (i < array1.length) {
            result[k] = array1[i];
            i++;
            k++;
        }
        while (j < array2.length) {
            result[k] = array2[j];
            j++;
            k++;
        }
        return result;
    }

    public static int[][] loadArray(Scanner in) {
        int rows = in.nextInt();
        int cols = in.nextInt();
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int value = in.nextInt();
                array[i][j] = value;
            }
        }
        return array;
    }

    public static void saveArray(PrintStream printStream, int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        printStream.println(rows + " " + cols);
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                printStream.print(array[i][j] + (j == cols - 1 ? "" : " "));
            }
            printStream.println();
        }
    }

    public static int[][] transpose(int[][] array)  {
        int[][] result = new int[array[0].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                result[j][i] = array[i][j];
            }
        }

        saveArray(System.err, array);
        System.out.println();
        saveArray(System.err, result);

        return result;
    }

    /**
     * Calculates the triangular sum of an array
     * @param nums The numbers to triangularly sum.
     * @return The triangular sum.
     * Link: https://leetcode.com/problems/find-triangular-sum-of-an-array/
     */
    public static int triangularSum(int[] nums) {
        while(nums.length != 1) {
            int[] newNums = new int[nums.length-1];
            for(int i = 0; i < nums.length-1; i++) {
                newNums[i] = (nums[i] + nums[i+1]) % 10;
            }
            nums = newNums;
        }
        return nums[0];
    }

    /**
     * Remove duplicates from a list of integers in place
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/
     * @param nums The list of integers to remove duplicates from (in place)
     * @return the length of the list
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length]; // create a new array to hold the merged arrays
        int i = 0; // index for nums1
        int j = 0; // index for nums2
        int k = 0; // index for merged
        while (i < nums1.length && j < nums2.length) { // while both arrays have elements
            if (nums1[i] < nums2[j]) { // if the current element in nums1 is less than the current element in nums2
                merged[k] = nums1[i]; // add the current element in nums1 to the merged array
                i++; // increment the index for nums1
            } else { // if the current element in nums2 is less than the current element in nums1
                merged[k] = nums2[j]; // add the current element in nums2 to the merged array
                j++; // increment the index for nums2
            }
            k++; // increment the index for merged
        }
        while (i < nums1.length) { // if nums1 has elements left
            merged[k] = nums1[i]; // add the current element in nums1 to the merged array
            i++; // increment the index for nums1
            k++; // increment the index for merged
        }
        while (j < nums2.length) { // if nums2 has elements left
            merged[k] = nums2[j]; // add the current element in nums2 to the merged array
            j++; // increment the index for nums2
            k++; // increment the index for merged
        }
        if(merged.length % 2 == 0) { // if the merged array has an even number of elements
            return (merged[merged.length/2] + merged[merged.length/2 - 1]) / 2.0;
            // return the average of the two middle elements
        } else {
            return merged[merged.length/2]; // return the middle element
        }
    }

    /**
     * Convert s to ZigZag format
     * @param s The string to convert
     * @param numRows the number of rows to use
     * @return the converted string
     * Link: https://leetcode.com/problems/zigzag-conversion/
     */
    public static String zigZagConversion(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows]; //generate a string builder for each row
        for(int i = 0; i < sb.length; i++) { // initialize each string builder
            sb[i] = new StringBuilder();
        }

        // loop through the string s and add each character to the appropriate string builder
        int i = 0;
        while(i < s.length()) {
            for(int j = 0; j < numRows && i < s.length(); j++) {
                sb[j].append(s.charAt(i++));
            }
            for(int j = numRows - 2; j > 0 && i < s.length(); j--) {
                sb[j].append(s.charAt(i++));
            }
        }


        // append all the string builders together
        for(int j = 1; j < sb.length; j++) {
            sb[0].append(sb[j]);
        }

        // return the string builder as a string
        return sb[0].toString();
    }
}

package com.alvonellos.interview.util.collections;

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

    public static int[][] transpose(int[][] array)  {
        int[][] result = new int[array[0].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                result[j][i] = array[i][j];
            }
        }
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
}
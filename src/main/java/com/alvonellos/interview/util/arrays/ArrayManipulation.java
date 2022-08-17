package com.alvonellos.interview.util.arrays;

import java.util.function.IntFunction;

public class ArrayManipulation<T extends Comparable<T>> {

    /**
     * Take two arrays that are sorted and merge them together into one array.
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
}

package com.alvonellos.interview.util.numbers;

import java.util.HashMap;
import java.util.Map;

public class NumberManipulation {
    public static Long randBetween(Long min, Long max) {
        return min + Math.round(Math.random() * (max - min));
    }

    /**
     * Given an array of integers nums and an integer target, return indices of
     * the two numbers such that they add up to target.
     * @param nums
     * @param target
     * @return the indices of the two numbers such that they add up to target
     * Note: O(n) runtime ;)
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int comp = target - nums[i];
            if (map.containsKey(comp)) {
                return new int[] { map.get(comp), i };
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {};
    }

    /**
     * Swap a number in place without using a temporary variable.
     * @param numbers
     */
    public static void xorSwap(int[] numbers) {
        assert(numbers.length == 2);

        if (numbers[0] == numbers[1]) { return; }

        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
    }
}

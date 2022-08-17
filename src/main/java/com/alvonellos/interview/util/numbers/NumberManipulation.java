package com.alvonellos.interview.util.numbers;

import java.math.BigInteger;
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

    static HashMap<BigInteger, BigInteger> factCache;
    static {
        factCache = new HashMap<>(); // Initialize the cache with pre-computed values;
        factCache.put(BigInteger.valueOf(0), BigInteger.valueOf(1));
        factCache.put(BigInteger.valueOf(1), BigInteger.valueOf(1));
        factCache.put(BigInteger.valueOf(2), BigInteger.valueOf(2));
        factCache.put(BigInteger.valueOf(3), BigInteger.valueOf(6));
        factCache.put(BigInteger.valueOf(4), BigInteger.valueOf(24));
        factCache.put(BigInteger.valueOf(5), BigInteger.valueOf(120));
        factCache.put(BigInteger.valueOf(6), BigInteger.valueOf(720));
        factCache.put(BigInteger.valueOf(7), BigInteger.valueOf(5040));
        factCache.put(BigInteger.valueOf(8), BigInteger.valueOf(40320));
        factCache.put(BigInteger.valueOf(8), BigInteger.valueOf(40320));
        factCache.put(BigInteger.valueOf(9), BigInteger.valueOf(362880));
    }

    /**
     * Calculates the factorial of the specified number, but uses a cache
     * to speed up the operation.
     * @param n the number to calculate
     */
    public static BigInteger factorialCached(BigInteger n) {
        if (factCache.containsKey(n)) {
            return factCache.get(n);
        } else {
            factCache.put(n, factorial(n));
            return factCache.get(n);
        }
    }

    /**
     * Calculates the factorial of a number
     * @param n the number to calculate
     * @return the factorial of the number
     */
    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.valueOf(0))) {
            return BigInteger.valueOf(1);
        }

        return n.multiply(factorial(n.subtract(BigInteger.valueOf(1))));
    }


    /**
     * Calculates the binomial of a number given n and k.
     * @param n The number of items to calculate for
     * @param k The amount to choose from at a time.
     * @return the binomial of the number
     */
    public static BigInteger binomial(BigInteger n, BigInteger k) {
        BigInteger numerator = factorialCached(n);
        BigInteger denominator = factorialCached(k).multiply(
                factorialCached(n.subtract(k))
        );
        return numerator.divide(denominator);
    }
}

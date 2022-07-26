package com.alvonellos.interview.util.numbers;

import java.math.BigInteger;
import java.util.*;

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

    /**
     * Converts a list of a list of bigInteger to a list of regular integer
     * @param items the items to convert
     * @return the list of integers
     * TODO: Move this to a separate list utilities class
     */
    public List<List<Integer>> convertBigIntegerToIntegerList(List<List<BigInteger>> items) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<BigInteger> item : items) {
            List<Integer> buffer = new ArrayList<>();
            for (BigInteger i : item) {
                buffer.add(i.intValue());
            }
            result.add(buffer);
        }
        return result;
    }

    /**
     * Reverse an integer without using 64 big numbers
     * @param x the number to reverse
     * @return the number reversed, or 0 if the number reversed is too large
     */
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int lastDigit = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
                return 0;
            }
            result = result * 10 + lastDigit;
        }
        return result;
    }

    public class ListNode {
          int val;
          ListNode next;

        ListNode(int val) { this.val = val; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return result.next;

    }

    /**
     * Checks if the number is prime
     * @param n the number to check
     * @return true if the number is prime, false otherwise
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int smallestPrimeFactor(int n) {
        if (n <= 1) {
            return -1;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return i;
            }
        }
        return n;
    }

    /*
     * Complete the 'countOccurrences' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY array
     *  2. INTEGER target
     */

    public static int countOccurrencesLinear(List<Integer> array, int target) {
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == target) {
                count++;
            }
        }
        return count;
    }

    public static int countOccurrencesFast(List<Integer> array, int target) {
        // pass by ref modify the original array.
        return (int) array.parallelStream().filter(i -> i == target).count();
    }

    public static boolean luhnsAlgorithm(final String card) {
        //to hold the card numbers
        final List<Integer> cardNumbers = new ArrayList<Integer>(16);

        //for each character in the string, convert it to an integer and add to list
        card.chars().forEach(s -> {
            if(s != ' ')
                cardNumbers.add(Character.getNumericValue(s));
        });
        System.err.println("parsed: " + cardNumbers.toString());

        //Declare a stack to use to sum the odd card numbers in reverse order
        Stack<Integer> oddCardNumbers = new Stack<Integer>();
        int step2 = 0; //step 2 sum

        //loop through each element in the list
        for(int i=0; i<cardNumbers.size();i++){
            int x = cardNumbers.get(i); //fetch the element
            if(i % 2 == 0) {  //if the element is at an even index
                step2 += (x*2 >= 10 ? (x*2)-9 : x*2); //if doubling it results in a double digit value, then subtract nine
            } else {
                oddCardNumbers.push(x); //push to the stack
            }
        }

        //Sum each in the stack
        int step3 = oddCardNumbers.stream().reduce(Integer::sum).get();

        int step4 = step2 + step3;

        boolean isValid = step4 % 10 == 0;


        //x -> x*2 >= 10 ? (x*2)-9 : x*2;
        return isValid;
    }

    public static boolean happyNumber(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            int digit = Integer.parseInt(number.substring(i, i + 1));
            sum += digit * digit;
        }
        if (sum == 1) {
            return true;
        } else if (sum == 4) {
            return false;
        } else {
            return happyNumber(Integer.toString(sum));
        }
    }
}

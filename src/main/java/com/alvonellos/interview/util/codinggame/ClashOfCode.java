package com.alvonellos.interview.util.codinggame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClashOfCode {
    public static List<Integer> listAllDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        return divisors;
    }

    public static void decoder(String input) {
        String[] inputs = input.split(" ");

        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int[] encoded = new int[numbers.length];
        Map<Integer, Character> decoder = new HashMap<>(10);
        for (int i = 0; i < numbers.length; i++) {
            encoded[i] = (int) numbers[i] * Character.getNumericValue(numbers[i]);
            decoder.put(encoded[i], numbers[i]);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(decoder.get(Integer.parseInt(inputs[i])));
        }
    }

    public static boolean isValidISBN(String isbn) {
        isbn = isbn.replaceAll("-", "");
        if (isbn.length() != 10 && isbn.length() != 13) {
            return false;
        } else if (isbn.length() == 10) {
            // Computing weighted sum
            // of first 9 digits
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                int digit = isbn.charAt(i) - '0';
                if (0 > digit || 9 < digit) return false;
                sum += (digit * (10 - i));
            }

            // Checking last digit.
            char last = isbn.charAt(9);
            if (last != 'X' && (last < '0' || last > '9')) return false;

            // If last digit is 'X', add 10
            // to sum, else add its value
            sum += ((last == 'X') ? 10 : (last - '0'));

            // Return true if weighted sum
            // of digits is divisible by 11.
            return (sum % 11 == 0);
        } else if (isbn.length() == 13) {
            try {
                int tot = 0;
                for (int i = 0; i < 12; i++) {
                    int digit = Integer.parseInt(isbn.substring(i, i + 1));
                    tot += (i % 2 == 0) ? digit * 1 : digit * 3;
                }             //checksum must be 0-9. If calculated as 10 then = 0
                int checksum = 10 - (tot % 10);
                if (checksum == 10) {
                    checksum = 0;
                }
                return checksum == Integer.parseInt(isbn.substring(12));
            } catch (NumberFormatException nfe) {
                //to catch invalid ISBNs that have non-numeric characters in them
                return false;
            }
        } else {
            return false;
        }
    }

}
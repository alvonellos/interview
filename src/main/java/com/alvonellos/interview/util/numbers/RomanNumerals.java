package com.alvonellos.interview.util.numbers;

import lombok.val;

import java.util.HashMap;
import java.util.TreeMap;

public class RomanNumerals {
    private static final HashMap<String, Integer> ROMAN_NUMERALS;
    static {
        ROMAN_NUMERALS = new HashMap<String, Integer>();
        ROMAN_NUMERALS.put("M", 1000);
        ROMAN_NUMERALS.put("CM", 900);
        ROMAN_NUMERALS.put("D", 500);
        ROMAN_NUMERALS.put("CD", 400);
        ROMAN_NUMERALS.put("C", 100);
        ROMAN_NUMERALS.put("XC", 90);
        ROMAN_NUMERALS.put("L", 50);
        ROMAN_NUMERALS.put("XL", 40);
        ROMAN_NUMERALS.put("X", 10);
        ROMAN_NUMERALS.put("IX", 9);
        ROMAN_NUMERALS.put("VI", 6);
        ROMAN_NUMERALS.put("V", 5);
        ROMAN_NUMERALS.put("IV", 4);
        ROMAN_NUMERALS.put("I", 1);
    }
    private final static TreeMap<Integer, String> NUMERAL_ROMAN = new TreeMap<Integer, String>();
    static {
        NUMERAL_ROMAN.put(1000, "M");
        NUMERAL_ROMAN.put(900, "CM");
        NUMERAL_ROMAN.put(500, "D");
        NUMERAL_ROMAN.put(400, "CD");
        NUMERAL_ROMAN.put(100, "C");
        NUMERAL_ROMAN.put(90, "XC");
        NUMERAL_ROMAN.put(50, "L");
        NUMERAL_ROMAN.put(40, "XL");
        NUMERAL_ROMAN.put(10, "X");
        NUMERAL_ROMAN.put(9, "IX");
        NUMERAL_ROMAN.put(5, "V");
        NUMERAL_ROMAN.put(4, "IV");
        NUMERAL_ROMAN.put(1, "I");

    }

    /**
     * Converts a roman numeral to an arabic number.
     * @param number
     * @return
     */
    public static int romanToArabic(String number) {
        StringBuffer buffer = new StringBuffer(number);
        int arabic = 0;
        while (buffer.length() > 0) {
            val current = buffer.substring(0, 1);
            val next = buffer.length() > 1 ? buffer.substring(1, 2) : "";
            if (ROMAN_NUMERALS.containsKey(current + next)) {
                arabic += ROMAN_NUMERALS.get(current + next);
                buffer.delete(0, 2);
            } else {
                arabic += ROMAN_NUMERALS.get(current);
                buffer.delete(0, 1);
            }
        }
        return arabic;
    }

    /**
     * Convert an arabic number to roman numerals
     * @param number the number to convert
     * @return a string representation of the number
     */
    public static String arabicToRoman(int number) {
        int l =  NUMERAL_ROMAN.floorKey(number);
        if ( number == l ) {
            return NUMERAL_ROMAN.get(number);
        }
        return NUMERAL_ROMAN.get(l) + arabicToRoman(number-l);
    }
}

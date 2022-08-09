package com.alvonellos.interview.util.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsTest {

    @Test
    void testRomanToArabic() {
        assertEquals(1, RomanNumerals.romanToArabic("I"));
        assertEquals(5, RomanNumerals.romanToArabic("V"));
        assertEquals(10, RomanNumerals.romanToArabic("X"));
        assertEquals(50, RomanNumerals.romanToArabic("L"));
        assertEquals(100, RomanNumerals.romanToArabic("C"));
        assertEquals(500, RomanNumerals.romanToArabic("D"));
        assertEquals(1000, RomanNumerals.romanToArabic("M"));
        assertEquals(3, RomanNumerals.romanToArabic("III"));
        assertEquals(4, RomanNumerals.romanToArabic("IV"));
        assertEquals(9, RomanNumerals.romanToArabic("IX"));
        assertEquals(40, RomanNumerals.romanToArabic("XL"));
        assertEquals(90, RomanNumerals.romanToArabic("XC"));
        assertEquals(400, RomanNumerals.romanToArabic("CD"));
        assertEquals(900, RomanNumerals.romanToArabic("CM"));
        assertEquals(1984, RomanNumerals.romanToArabic("MCMLXXXIV"));
    }

    @Test
    void arabicToRomanTest() {
        assertEquals("I", RomanNumerals.arabicToRoman(1));
        assertEquals("V", RomanNumerals.arabicToRoman(5));
        assertEquals("X", RomanNumerals.arabicToRoman(10));
        assertEquals("L", RomanNumerals.arabicToRoman(50));
        assertEquals("C", RomanNumerals.arabicToRoman(100));
        assertEquals("D", RomanNumerals.arabicToRoman(500));
        assertEquals("M", RomanNumerals.arabicToRoman(1000));
        assertEquals("III", RomanNumerals.arabicToRoman(3));
        assertEquals("IV", RomanNumerals.arabicToRoman(4));
        assertEquals("IX", RomanNumerals.arabicToRoman(9));
        assertEquals("XL", RomanNumerals.arabicToRoman(40));
        assertEquals("XC", RomanNumerals.arabicToRoman(90));
        assertEquals("CD", RomanNumerals.arabicToRoman(400));
        assertEquals("CM", RomanNumerals.arabicToRoman(900));
        assertEquals("MCMLXXXIV", RomanNumerals.arabicToRoman(1984));
    }
}
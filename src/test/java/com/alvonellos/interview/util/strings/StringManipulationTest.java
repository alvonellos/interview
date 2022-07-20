package com.alvonellos.interview.util.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringManipulationTest {

    @Test
    void removeLastCharacter() {
        String result = StringManipulation.removeLastCharacter("abc");
        assertEquals("ab", result);
    }

    @Test
    void removeFirstCharacter() {
        String result = StringManipulation.removeFirstCharacter("abc");
        assertEquals("bc", result);
    }

    @Test
    void replaceFirstCharacter() {
        String result = StringManipulation.replaceFirstCharacter("abc", "x");
        assertEquals("xbc", result);
    }

    @Test
    void reverseString() {
        String result = StringManipulation.reverseString("abc");
        assertEquals("cba", result);
    }

    @Test
    void reverse_recursive() {
        String result = StringManipulation.reverse_recursive("abc");
        assertEquals("cba", result);
    }

    @Test
    void reverse() {
        String result = StringManipulation.reverse("abc");
        assertEquals("cba", result);
    }

    int generatePalindromicNumber(int i, int j) {
        assert(i >= 1 && j >= 1 && i <= 9 && j <= 9);
        return i*(1001) + j*(110);
    }

    @Test
    void palindromeRecursivePositiveCase() {
        for(int i = 1; i < 9; i++ ) {
            for(int j = 1; j < 9; j++) {
                Integer result = generatePalindromicNumber(i,j);
                boolean isPalindrome = StringManipulation.palindrome_recursive(String.valueOf(result));
                assert(isPalindrome);
            }
        }
    }

    @Test
    void palindromeRecursiveNegativeCase() {
        System.err.println("Testing negative case");
        for(int i = 1; i < 9; i++ ) {
            for(int j = 1; j < 9; j++) {
                if(StringManipulation.palindrome_recursive(String.valueOf(generatePalindromicNumber(i, j)+1)))
                    fail("palindrome_recursive should not have returned true for: " + generatePalindromicNumber(i, j));
            }
        }
    }
}
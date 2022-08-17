package com.alvonellos.interview.util.strings;

import org.junit.jupiter.api.Test;

import static com.alvonellos.interview.util.strings.LongestPalindromicSubstring.isPalindrome;
import static com.alvonellos.interview.util.strings.LongestPalindromicSubstring.longestPalindrome;
import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {

    @Test
    void isPalindromeTest() {
        final String[] palindromes =
                {"a", "b", "c", "d", "e", "f", "g", "racecar", "bbb", "ccc", "ddd", "eee","aba", "bbbb", "cccc"};
        final String[] not_palindromes =
                {"ab", "ac", "ad", "ae", "af", "abb", "bbc", "bbd", "bbf", "bbd"};

        for(String s : palindromes) {
            assert(isPalindrome(s));
        }

        for(String s : not_palindromes) {
            assert(!isPalindrome(s));
        }
    }

    @Test
    void longestPalindromeTest() {
        String expected = "bab";
        String actual = longestPalindrome("babad");
        assertEquals(expected, actual);
    }
}
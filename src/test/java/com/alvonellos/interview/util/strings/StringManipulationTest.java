package com.alvonellos.interview.util.strings;

import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean({KVDatabase.class, PersonRepository.class})
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

    @Test
    void palindromePositiveCase() {
        for(int i = 1; i < 9; i++ ) {
            for(int j = 1; j < 9; j++) {
                Integer result = generatePalindromicNumber(i,j);
                boolean isPalindrome = StringManipulation.palindrome(String.valueOf(result));
                assert(isPalindrome);
            }
        }
    }

    @Test
    void palindromeNegativeCase() {
        System.err.println("Testing negative case");
        for(int i = 1; i < 9; i++ ) {
            for(int j = 1; j < 9; j++) {
                if(StringManipulation.palindrome(String.valueOf(generatePalindromicNumber(i, j)+1)))
                    fail("palindrome_recursive should not have returned true for: " + generatePalindromicNumber(i, j));
            }
        }
    }

    @Test
    void stringContainsVowels() {
        for(char c : "aeiou".toCharArray()) {
            assertTrue(StringManipulation.stringContainsVowels(String.valueOf(c)));
        }
    }

    @Test
    void lengthOfLongestSubstringTest() {
        assert(StringManipulation.lengthOfLongestSubstringBF("abcabcbb") == 3);
        assert(StringManipulation.lengthOfLongestSubstringBF("bbbbb") == 1);
        assert(StringManipulation.lengthOfLongestSubstringBF("pwwkew") == 3);
    }

    @Test
    void lengthOfLongestSubstringTestSlidingWindow() {
        assert(StringManipulation.lengthOfLongestSubstring("abcabcbb") == 3);
        assert(StringManipulation.lengthOfLongestSubstring("bbbbb") == 1);
        assert(StringManipulation.lengthOfLongestSubstring("pwwkew") == 3);
    }

    @Test
    void stringContainsUniqueCharacters() {
        assert(StringManipulation.stringContainsUniqueCharacters("abc"));
        assert(!StringManipulation.stringContainsUniqueCharacters("aabc"));
        assert(StringManipulation.stringContainsUniqueCharacters(""));
        assert(StringManipulation.stringContainsUniqueCharacters(" "));
        assert(StringManipulation.stringContainsUniqueCharacters("a"));

        assert(StringManipulation.stringContainsUniqueCharacters("abc"));
    }

    @Test
    void substringsTest() {
        assertEquals(6, StringManipulation.subStrings("abc").size());
    }
}
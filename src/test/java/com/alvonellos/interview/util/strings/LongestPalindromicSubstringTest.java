package com.alvonellos.interview.util.strings;

import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.alvonellos.interview.util.strings.LongestPalindromicSubstring.isPalindrome;
import static com.alvonellos.interview.util.strings.LongestPalindromicSubstring.longestPalindrome;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean({KVDatabase.class, PersonRepository.class})
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
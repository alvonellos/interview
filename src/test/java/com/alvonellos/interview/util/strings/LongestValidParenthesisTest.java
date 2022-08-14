package com.alvonellos.interview.util.strings;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.alvonellos.interview.util.strings.LongestValidParenthesis.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LongestValidParenthesisTest {
    @Test
    void testLongestValidParenthesis() {
        assertEquals(4, longestValidParenthesesBF(")()())"));
        assertEquals(2, longestValidParenthesesBF("(()"));
    }

    @Test
    void testLongestValidParenthesisDP() {
        assertEquals(4, longestValidParenthesesDP(")()())"));
        assertEquals(2, longestValidParenthesesDP("(()"));
    }

    @Test
    void testLongestValidParenthesisStack() {
        assertEquals(4, longestValidParenthesesStack(")()())"));
        assertEquals(2, longestValidParenthesesStack("(()"));
    }
}
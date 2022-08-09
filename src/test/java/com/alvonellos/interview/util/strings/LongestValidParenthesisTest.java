package com.alvonellos.interview.util.strings;

import org.junit.jupiter.api.Test;

import static com.alvonellos.interview.util.strings.LongestValidParenthesis.longestValidParentheses;
import static org.junit.jupiter.api.Assertions.*;

class LongestValidParenthesisTest {
    @Test
    void testLongestValidParenthesis() {
        assertEquals(4, longestValidParentheses(")()())"));
        assertEquals(2, longestValidParentheses("(()"));
    }
}
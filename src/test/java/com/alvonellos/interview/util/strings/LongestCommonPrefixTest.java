package com.alvonellos.interview.util.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {
    @Test
    void longestCommonPrefixTest() {
        String[] words = { "flower","flow","flight"};
        assertEquals("fl", LongestCommonPrefix.longestCommonPrefix(words));
    }
}
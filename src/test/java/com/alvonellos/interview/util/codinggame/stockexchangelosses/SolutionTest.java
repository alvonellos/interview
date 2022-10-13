package com.alvonellos.interview.util.codinggame.stockexchangelosses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void bracketsExtemeEditionTest() {
        assertTrue(Solution.bracketsExtemeEdition("()"));
        assertTrue(Solution.bracketsExtemeEdition("()[]{}"));
        assertTrue(Solution.bracketsExtemeEdition("{[]}"));
        assertFalse(Solution.bracketsExtemeEdition("(]"));
        assertFalse(Solution.bracketsExtemeEdition("([)]"));
        assertFalse(Solution.bracketsExtemeEdition("]"));

    }
}
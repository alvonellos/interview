package com.alvonellos.interview.util.codinggame.stockexchangelosses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void stockExchangeLossesTest() {
        assertEquals(-3, Solution.stockExchangeLosses(new int[] {3, 2, 4, 2, 1, 5}));
    }

    @Test
    void bracketsExtemeEditionTest() {
        assertTrue(Solution.bracketsExtemeEdition("()"));
        assertTrue(Solution.bracketsExtemeEdition("()[]{}"));
        assertTrue(Solution.bracketsExtemeEdition("{[]}"));
        assertFalse(Solution.bracketsExtemeEdition("(]"));
        assertFalse(Solution.bracketsExtemeEdition("([)]"));
        assertFalse(Solution.bracketsExtemeEdition("]"));
        assertTrue(Solution.bracketsExtemeEdition("{([]){}()})")); // tru

    }
}
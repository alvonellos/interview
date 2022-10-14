package com.alvonellos.interview.util.codinggame.stockexchangelosses;

import com.alvonellos.interview.games.codinggame.stockexchangelosses.Solution;
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
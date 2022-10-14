package com.alvonellos.interview.util.codinggame;

import org.junit.jupiter.api.Test;

import static com.alvonellos.interview.games.codinggame.ClashOfCode.isValidISBN;
import static org.junit.jupiter.api.Assertions.*;

class ClashOfCodeTest {

    @Test
    void isbnTest() {
        assertTrue(isValidISBN("0306406152"));
        assertTrue(isValidISBN("013603599X"));
        assertTrue(isValidISBN("9780306406157"));

        assertFalse(isValidISBN("1145185215X"));
        assertFalse(isValidISBN("9780306406154"));
        assertFalse(isValidISBN("978043551907X"));
    }
}
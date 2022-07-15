package com.alvonellos.interview.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringManipulationTest {

    @Test
    void removeLastCharacter() {
        StringManipulation stringManipulation = new StringManipulation();
        String result = stringManipulation.removeLastCharacter("abc");
        assertEquals("ab", result);
    }

    @Test
    void removeFirstCharacter() {
        StringManipulation stringManipulation = new StringManipulation();
        String result = stringManipulation.removeFirstCharacter("abc");
        assertEquals("bc", result);
    }

    @Test
    void replaceFirstCharacter() {
        StringManipulation stringManipulation = new StringManipulation();
        String result = stringManipulation.replaceFirstCharacter("abc", "x");
        assertEquals("xbc", result);
    }

    @Test
    void reverseString() {
        StringManipulation stringManipulation = new StringManipulation();
        String result = stringManipulation.reverseString("abc");
        assertEquals("cba", result);
    }

    @Test
    void reverse_recursive() {
        StringManipulation stringManipulation = new StringManipulation();
        String result = stringManipulation.reverse_recursive("abc");
        assertEquals("cba", result);
    }

    @Test
    void reverse() {
        StringManipulation stringManipulation = new StringManipulation();
        String result = stringManipulation.reverse("abc");
        assertEquals("cba", result);
    }
}
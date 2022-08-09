package com.alvonellos.interview.util.numbers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.alvonellos.interview.util.numbers.NumberManipulation.randBetween;
import static com.alvonellos.interview.util.numbers.NumberManipulation.twoSum;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NumberManipulationTest {

    @Test
    void randBetweenTest() {
        assertTrue(randBetween(1L, 10L) >= 1L && randBetween(1L, 10L) <= 10L);
    }

    @Test
    void twoSumTest() {
        int[] expected = new int[] {0,1};
        int[] actual = new int[] {2,7,11,15};

        int[] output = twoSum(actual, 9);
        assertArrayEquals(expected, output);
    }
}
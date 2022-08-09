package com.alvonellos.interview.util.numbers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.alvonellos.interview.util.numbers.NumberManipulation.randBetween;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NumberManipulationTest {

    @Test
    void randBetweenTest() {
        assertTrue(randBetween(1L, 10L) >= 1L && randBetween(1L, 10L) <= 10L);
    }
}
package com.alvonellos.interview.Interviews.CapitalOne;

import org.junit.jupiter.api.Test;

import static com.alvonellos.interview.Interviews.CapitalOne.CapitalOne.test;
import static org.junit.jupiter.api.Assertions.*;

class CapitalOneTest {

    @Test
    void test_test_andShouldPass() {
        for(int i = 0; i < 10; i++) {
            assert (test(i) == i);
        }

    }
}
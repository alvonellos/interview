package com.alvonellos.interview.util.numbers;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    private static final Long EPSILON = Long.valueOf(1);

    @Test
    void fib() {
        assertEquals(BigInteger.valueOf(1), Fibonacci.fib(BigInteger.valueOf(0)));
        assertEquals(BigInteger.valueOf(1), Fibonacci.fib(BigInteger.valueOf(1)));
        assertEquals(BigInteger.valueOf(2), Fibonacci.fib(BigInteger.valueOf(2)));
        assertEquals(BigInteger.valueOf(3), Fibonacci.fib(BigInteger.valueOf(3)));
    }

    @RepeatedTest(100)
    @Timeout(100)
    void fib_timed() {
        Long timeIn = System.currentTimeMillis();
        Fibonacci.fib(BigInteger.valueOf(1000));
        Long timeOutNonCached = System.currentTimeMillis() - timeIn;

        timeIn = System.currentTimeMillis();
        Fibonacci.fib(BigInteger.valueOf(1001));
        Long timeoutCached = System.currentTimeMillis() - timeIn;

        if(timeoutCached >= EPSILON || timeOutNonCached >= 10*EPSILON) // should be within 1ms
            fail();

        }
    }
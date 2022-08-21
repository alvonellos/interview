package com.alvonellos.interview.util.numbers;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FibonacciTest {
    private static final Long EPSILON = Long.valueOf(4);//Four milliseconds

    @Test
    void fib() {
        assertEquals(BigInteger.valueOf(1), Fibonacci.fib(BigInteger.valueOf(0)));
        assertEquals(BigInteger.valueOf(1), Fibonacci.fib(BigInteger.valueOf(1)));
        assertEquals(BigInteger.valueOf(2), Fibonacci.fib(BigInteger.valueOf(2)));
        assertEquals(BigInteger.valueOf(3), Fibonacci.fib(BigInteger.valueOf(3)));
    }

    //Test fib with random numbers
    void fibRandom() {
        for(int i = 0; i < 100; i++) {
            BigInteger a = BigInteger.valueOf(Math.round(Math.random() * 100));
            assertEquals(Fibonacci.fib(a), Fibonacci.fib(a));
        }
    }

    @RepeatedTest(100)
    @Timeout(value = 1)
    void fibRandomTimeout() {
        fibRandom();
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

        if(timeoutCached >= EPSILON || timeOutNonCached >= 10*EPSILON) // should be within 4ms for a cache hit
            fail();

        }

    @Test
    void fib_squared() {
        assertEquals(BigInteger.valueOf(1), Fibonacci.fib_squared(BigInteger.valueOf(0)));
        assertEquals(BigInteger.valueOf(1), Fibonacci.fib_squared(BigInteger.valueOf(1)));
        assertEquals(BigInteger.valueOf(4), Fibonacci.fib_squared(BigInteger.valueOf(2)));
        assertEquals(BigInteger.valueOf(9), Fibonacci.fib_squared(BigInteger.valueOf(3)));
    }
}
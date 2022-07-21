package com.alvonellos.interview.util.numbers;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    @Test
    void fib() {
        assertEquals(BigInteger.valueOf(1), Fibonacci.fib(BigInteger.valueOf(0)));
        assertEquals(BigInteger.valueOf(1), Fibonacci.fib(BigInteger.valueOf(1)));
        assertEquals(BigInteger.valueOf(2), Fibonacci.fib(BigInteger.valueOf(2)));
        assertEquals(BigInteger.valueOf(3), Fibonacci.fib(BigInteger.valueOf(3)));
    }
}
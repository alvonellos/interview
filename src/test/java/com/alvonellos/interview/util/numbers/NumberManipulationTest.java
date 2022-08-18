package com.alvonellos.interview.util.numbers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import scala.math.BigInt;

import java.math.BigInteger;
import java.util.HashMap;

import static com.alvonellos.interview.util.numbers.NumberManipulation.*;
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

    @Test
    void xorSwapTest() {
        int[] expected = {2,1};
        int[] actual = {1,2};

        xorSwap(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    void factorialCachedTest() {
        BigInteger expected = BigInteger.valueOf(1);
        BigInteger actual = factorialCached(BigInteger.valueOf(0));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(1);
        actual = factorialCached(BigInteger.valueOf(1));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(2);
        actual = factorialCached(BigInteger.valueOf(2));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(6);
        actual = factorialCached(BigInteger.valueOf(3));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(24);
        actual = factorialCached(BigInteger.valueOf(4));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(120);
        actual = factorialCached(BigInteger.valueOf(5));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(720);
        actual = factorialCached(BigInteger.valueOf(6));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(5040);
        actual = factorialCached(BigInteger.valueOf(7));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(40320);
        actual = factorialCached(BigInteger.valueOf(8));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(362880);
        actual = factorialCached(BigInteger.valueOf(9));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(3628800);
        actual = factorialCached(BigInteger.valueOf(10));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(39916800);
        actual = factorialCached(BigInteger.valueOf(11));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(479001600);
        actual = factorialCached(BigInteger.valueOf(12));
        assertEquals(expected, actual);
    }

    @Test
    void factorialTest() {
        BigInteger expected = BigInteger.valueOf(1);
        BigInteger actual = factorial(BigInteger.valueOf(0));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(1);
        actual = factorial(BigInteger.valueOf(1));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(2);
        actual = factorial(BigInteger.valueOf(2));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(6);
        actual = factorial(BigInteger.valueOf(3));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(24);
        actual = factorial(BigInteger.valueOf(4));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(120);
        actual = factorial(BigInteger.valueOf(5));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(720);
        actual = factorial(BigInteger.valueOf(6));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(5040);
        actual = factorial(BigInteger.valueOf(7));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(40320);
        actual = factorial(BigInteger.valueOf(8));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(362880);
        actual = factorial(BigInteger.valueOf(9));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(3628800);
        actual = factorial(BigInteger.valueOf(10));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(39916800);
        actual = factorial(BigInteger.valueOf(11));
        assertEquals(expected, actual);

        expected = BigInteger.valueOf(479001600);
        actual = factorial(BigInteger.valueOf(12));
        assertEquals(expected, actual);
    }

    @Test
    void binomialTest() {
        assert((binomial(BigInteger.valueOf(10l), BigInteger.valueOf(5l)).equals(BigInteger.valueOf(252l))));
        assert((binomial(BigInteger.valueOf(100l), BigInteger.valueOf(3l)).equals(BigInteger.valueOf(161700l))));

    }

    @Test
    void maxPointsTest() {
        int[][] input = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        int expected = 4;

        int actual = maxPoints(input);
        assertEquals(expected, actual);
    }
}
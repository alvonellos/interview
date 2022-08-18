package com.alvonellos.interview.util.numbers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

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
        int[] expected = new int[]{0, 1};
        int[] actual = new int[]{2, 7, 11, 15};

        int[] output = twoSum(actual, 9);
        assertArrayEquals(expected, output);
    }

    @Test
    void xorSwapTest() {
        int[] expected = {2, 1};
        int[] actual = {1, 2};

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
        assert ((binomial(BigInteger.valueOf(10l), BigInteger.valueOf(5l)).equals(BigInteger.valueOf(252l))));
        assert ((binomial(BigInteger.valueOf(100l), BigInteger.valueOf(3l)).equals(BigInteger.valueOf(161700l))));
    }

    @Test
    void reverseTest() {
        assert (reverse(321) == 123);
    }

    @Test
    void isPrimeTest() {
        assertTrue(isPrime(2));
        assertTrue(isPrime(3));
        assertTrue(isPrime(5));
        assertTrue(isPrime(7));
        assertTrue(isPrime(11));
        assertTrue(isPrime(13));
        assertTrue(isPrime(17));
        assertTrue(isPrime(19));
        assertTrue(isPrime(23));
        assertTrue(isPrime(29));
        assertTrue(isPrime(31));
        assertTrue(isPrime(37));
        assertTrue(isPrime(41));
        assertTrue(isPrime(43));
        assertTrue(isPrime(47));
        assertTrue(isPrime(53));
        assertTrue(isPrime(59));
        assertTrue(isPrime(61));
        assertTrue(isPrime(67));
        assertTrue(isPrime(71));
        assertTrue(isPrime(73));
        assertTrue(isPrime(79));
        assertTrue(isPrime(83));
        assertTrue(isPrime(89));
        assertTrue(isPrime(97));
        assertTrue(isPrime(101));
        assertTrue(isPrime(103));
        assertTrue(isPrime(107));
        assertTrue(isPrime(109));
        assertTrue(isPrime(113));
        assertTrue(isPrime(127));
        assertTrue(isPrime(131));
        assertTrue(isPrime(137));
        assertTrue(isPrime(139));
        assertTrue(isPrime(149));
        assertTrue(isPrime(151));
        assertTrue(isPrime(157));
        assertTrue(isPrime(163));
        assertTrue(isPrime(167));
        assertTrue(isPrime(173));
        assertTrue(isPrime(179));
        assertTrue(isPrime(181));
        assertTrue(isPrime(191));
        assertTrue(isPrime(193));
        assertTrue(isPrime(197));
        assertTrue(isPrime(199));
        assertTrue(isPrime(211));
        assertTrue(isPrime(223));
        assertTrue(isPrime(227));
        assertTrue(isPrime(229));
    }
}
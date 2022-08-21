package com.alvonellos.interview.util.numbers;

import java.math.BigInteger;
import java.util.HashMap;

public class Fibonacci {
    static final HashMap<BigInteger, BigInteger> cache = new HashMap<>();
    static final HashMap<BigInteger, BigInteger> mul_cache = new HashMap<>();

    public static BigInteger fib(BigInteger a) {
        if(a.equals(BigInteger.ZERO)) return BigInteger.ONE;
        if(a.equals(BigInteger.ONE)) return BigInteger.ONE;
        if(cache.containsKey(a)) return cache.get(a);
        else {
            BigInteger fibout = fib(a.subtract(BigInteger.valueOf(2))).add(fib(a.subtract(BigInteger.ONE)));
            cache.put(a, fibout);
            return fibout;
        }
    }

    public static BigInteger fib_squared(BigInteger n) {
        if(mul_cache.containsKey(n)) return mul_cache.get(n);
        else {
            BigInteger fibout = fib(n).multiply(fib(n));
            mul_cache.put(n, fibout);
            return fibout;
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 14; i++) {
            System.out.println(fib(BigInteger.valueOf(i)));
            System.err.println(fib_squared(BigInteger.valueOf(i)));
        }
    }
}

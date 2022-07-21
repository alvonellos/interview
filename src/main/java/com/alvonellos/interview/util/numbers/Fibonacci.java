package com.alvonellos.interview.util.numbers;

import java.math.BigInteger;
import java.util.HashMap;

public class Fibonacci {
    static final HashMap<BigInteger, BigInteger> cache = new HashMap<>();

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
}

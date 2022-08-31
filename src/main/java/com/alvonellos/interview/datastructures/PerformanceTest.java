package com.alvonellos.interview.datastructures;

import com.alvonellos.interview.util.crypto.CryptoAlgorithms;

import java.util.TreeMap;

public class PerformanceTest {
    public static double timeInsertionTreeMap(final int ITERATIONS) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Integer[] keys = new Integer[ITERATIONS];

        for (int i = 0; i < ITERATIONS; i++) {
            keys[i] = i;
        }
        CryptoAlgorithms.shuffle(keys); // shuffle the values so that we can test the average performance.

        long start = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            map.put(i, keys[i]);
        }
        long end = System.currentTimeMillis();

        double n = (double) end - start;
        return n;
    }

    public static double timeSearchTreeMap(final int SIZE) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < SIZE; i++) {
            map.put(i, i);
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            map.get(i);
        }
        long end = System.currentTimeMillis();

        double n = (double) end - start;
        return n;
    }


}

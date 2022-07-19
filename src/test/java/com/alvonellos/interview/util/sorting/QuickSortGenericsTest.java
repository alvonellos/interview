package com.alvonellos.interview.util.sorting;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Timeout;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortGenericsTest {
    SecureRandom random = new SecureRandom();
    static final int STREAM_SIZE = 1024;
    @RepeatedTest(100)
    @Timeout(100)
    void quickSort() {

        Integer[] a = random.ints(STREAM_SIZE).boxed().toArray(Integer[]::new);
        List<Integer> b = new ArrayList<>(Arrays.asList(a));

        QuickSortGenerics<Integer> quickSort = new QuickSortGenerics<>();
        quickSort.QuickSort(a);

        System.err.println(Arrays.stream(a).collect(Collectors.toList()));
        System.err.println(b.stream().sorted().collect(Collectors.toList()));
        assertSorted(a);
    }

    void assertSorted(Integer[] a) {
        assertArrayEquals(a, Arrays.stream(a).sorted().toArray());
    }
}
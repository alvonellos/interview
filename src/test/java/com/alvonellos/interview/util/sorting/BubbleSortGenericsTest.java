package com.alvonellos.interview.util.sorting;

import lombok.var;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.shadow.com.univocity.parsers.common.NormalizedString.toArray;

class BubbleSortGenericsTest {
    SecureRandom random = new SecureRandom();
    static final int STREAM_SIZE = 1024;
    @RepeatedTest(10)
    @Timeout(100)
    void bubbleSort() {

        Integer[] a = random.ints(STREAM_SIZE).boxed().toArray(Integer[]::new);
        List<Integer> b = new ArrayList<>(Arrays.asList(a));

        BubbleSortGenerics bubbleSort = new BubbleSortGenerics<Integer>();
        bubbleSort.BubbleSort(a);

        System.err.println(Arrays.stream(a).collect(Collectors.toList()));
        System.err.println(b.stream().sorted().collect(Collectors.toList()));
        assertSorted(a);
    }

    void assertSorted(Integer[] a) {
        assertArrayEquals(a, Arrays.stream(a).sorted().toArray());
    }

    @Test
    void swap() {
        Integer[] a = random.ints(STREAM_SIZE).boxed().toArray(Integer[]::new);
        List<Integer> b = new ArrayList<>(Arrays.asList(a));

        BubbleSortGenerics bubbleSort = new BubbleSortGenerics<Integer>();
        bubbleSort.BubbleSort(a);

        bubbleSort.swap(a, 0, 1);

        System.err.println(Arrays.stream(a).collect(Collectors.toList()));
        System.err.println(b.stream().sorted().collect(Collectors.toList()));

        assert(a[0]>a[1]);

    }
}
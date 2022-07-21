package com.alvonellos.interview.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.mock;

class SortingAlgorithmServiceTest {
    @InjectMocks
    SortingAlgorithmService sortingAlgorithmService = mock(SortingAlgorithmService.class);

    @Test
    void bubbleSort() {
        Integer[] expected = {1, 2, 3, 4, 5};
        List<Integer> buffer = Arrays.asList(expected);
        Collections.shuffle(Arrays.asList(buffer));
        Integer[] actual = buffer.toArray(new Integer[0]);

        sortingAlgorithmService.bubbleSort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    void quickSort() {
        Integer[] expected = {1, 2, 3, 4, 5};
        List<Integer> buffer = Arrays.asList(expected);
        Collections.shuffle(Arrays.asList(buffer));
        Integer[] actual = buffer.toArray(new Integer[0]);

        sortingAlgorithmService.quickSort(actual);

        assertArrayEquals(expected, actual);

    }

    @Test
    void selectionSort() {
        Integer[] expected = {1, 2, 3, 4, 5};
        List<Integer> buffer = Arrays.asList(expected);
        Collections.shuffle(Arrays.asList(buffer));
        Integer[] actual = buffer.toArray(new Integer[0]);

        sortingAlgorithmService.selectionSort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shellSort() {
        Integer[] expected = {1, 2, 3, 4, 5};
        List<Integer> buffer = Arrays.asList(expected);
        Collections.shuffle(Arrays.asList(buffer));
        Integer[] actual = buffer.toArray(new Integer[0]);

        sortingAlgorithmService.shellSort(actual);

        assertArrayEquals(expected, actual);
    }
}
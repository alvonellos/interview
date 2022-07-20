package com.alvonellos.interview.service;

import com.alvonellos.interview.util.sorting.BubbleSortGenerics;
import com.alvonellos.interview.util.sorting.QuickSortGenerics;
import com.alvonellos.interview.util.sorting.SelectionSortGenerics;
import com.alvonellos.interview.util.sorting.ShellSortGenerics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SortingAlgorithmServiceTest {

    final BubbleSortGenerics<?> bubbleSortGenerics = mock(BubbleSortGenerics.class);
    final QuickSortGenerics<?> quickSortGenerics = mock(QuickSortGenerics.class);
    final SelectionSortGenerics<?> selectionSortGenerics = mock(SelectionSortGenerics.class);
    final ShellSortGenerics<?> shellSortGenerics = mock(ShellSortGenerics.class);

    @InjectMocks
    SortingAlgorithmService sortingAlgorithmService = mock(SortingAlgorithmService.class);

    @BeforeEach
    void setUp() {

        //One of my favorite techniques is to use mockito mock maker inline then reflect and set the final
        //mocks in the tested method
        ReflectionTestUtils.setField(sortingAlgorithmService, "bubbleSortGenerics", bubbleSortGenerics);
        ReflectionTestUtils.setField(sortingAlgorithmService, "quickSortGenerics", quickSortGenerics);
        ReflectionTestUtils.setField(sortingAlgorithmService, "selectionSortGenerics", selectionSortGenerics);
        ReflectionTestUtils.setField(sortingAlgorithmService, "shellSortGenerics", shellSortGenerics);

        //Since its passbyref and returns void we can mock out the method as do nothing and just
        //verify it's called.
        doNothing().when(bubbleSortGenerics).sort(any());
        doNothing().when(quickSortGenerics).sort(any());
        doNothing().when(selectionSortGenerics).sort(any());
        doNothing().when(shellSortGenerics).sort(any());

    }

    @Test
    void bubbleSort() {
        Integer[] sorted = {1, 2, 3, 4, 5};

        sortingAlgorithmService.bubbleSort(sorted);

        verify(bubbleSortGenerics, atMostOnce()).sort(any());
    }

    @Test
    void quickSort() {
        Integer[] sorted = {1, 2, 3, 4, 5};

        sortingAlgorithmService.quickSort(sorted);

        verify(quickSortGenerics, atMostOnce()).sort(any());
    }

    @Test
    void selectionSort() {
        Integer[] sorted = {1, 2, 3, 4, 5};

        sortingAlgorithmService.selectionSort(sorted);

        verify(selectionSortGenerics, atMostOnce()).sort(any());
    }

    @Test
    void shellSort() {
        Integer[] sorted = {1, 2, 3, 4, 5};

        sortingAlgorithmService.shellSort(sorted);

        verify(shellSortGenerics, atMostOnce()).sort(any());
    }
}
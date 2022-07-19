package com.alvonellos.interview.util.sorting;

public class QuickSortGenerics<E> extends SortingAlgorithm {

    /**
     * Quick sort algorithm. O(n log n) algorithm.
     *
     * @param a the array to sort
     */
    public <E extends Comparable<E>> void QuickSort(E[] a) {
        QuickSort(a, 0, a.length - 1);
    }

    /**
     * Quick sort algorithm. O(n log n) algorithm. Internal implementation.
     * @param arr the array to sort
     * @param low the low index of the array
     * @param high the high index of the array
     * @param <E> the element type
     */
    <E extends Comparable<E>> void QuickSort(E[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            QuickSort(arr, low, pivot - 1);
            QuickSort(arr, pivot + 1, high);
        }
    }
}
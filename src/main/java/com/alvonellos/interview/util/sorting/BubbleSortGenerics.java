package com.alvonellos.interview.util.sorting;

public class BubbleSortGenerics<E> extends SortingAlgorithm {
    /**
     * Bubble sort algorithm. O(n^2) algorithm.
     *
     * @param a the array to sort
     */
    public  <E extends Comparable<E>> void sort(E[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    swap(a, j, j + 1);
                }
            }
        }
    }
}
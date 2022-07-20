package com.alvonellos.interview.util.sorting;

public class SelectionSortGenerics<E> extends SortingAlgorithm {
    /**
     * Selection sort algorithm. O(n^2) algorithm.
     *
     * @param a the array to sort
     */
    public <E extends Comparable<E>> void sort(E[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            // find index of smallest element
            int smallest = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[smallest])<=0) {
                    smallest = j;
                }
            }
            swap(a, i, smallest);  // swap smallest to front
        }
    }
}
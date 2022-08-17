package com.alvonellos.interview.util.sorting;

public class MergeSortGenerics<E> extends SortingAlgorithm {
    /**
     * Merge sort algorithm. O(n*log(n)) algorithm.
     *
     * @param a the array to sort
     */
    public  <E extends Comparable<E>> void sort(E[] a) {
        //mergeSort
        if (a.length > 1) {
            int mid = a.length / 2;
            E[] left = (E[]) new Comparable[mid];
            E[] right = (E[]) new Comparable[a.length - mid];
            System.arraycopy(a, 0, left, 0, mid);
            System.arraycopy(a, mid, right, 0, a.length - mid);
            sort(left);
            sort(right);
            merge(left, right, a);
        }
    }

    <E extends Comparable<E>> void merge(E[] left, E[] right, E[] a) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) < 0) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            a[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            a[k] = right[j];
            j++;
            k++;
        }
    }
}
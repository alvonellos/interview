package com.alvonellos.interview.util.sorting;

public abstract class SortingAlgorithm {
    public enum Algorithm {
        BUBBLE, QUICK, SELECTION, SHELL, MERGE
    }

    /**
     * Sort the array by reference
     * @param a the array to sort
     * @param <E> The type of the arrays inner elements.
     */
    public abstract <E extends Comparable<E>> void sort(E[] a);

    /**
     * Swaps the value of two elements in an array by index.
     * @param a the array to swap values within
     * @param i the index of the first element to swap
     * @param j the index of the second element to swap
     * @param <E>
     */
    static final<E> void swap(E[] a, final int i, final int j) {
        if (i != j) {
            E temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    /**
     * This function takes last element as pivot, places
     * the pivot element at its correct position in sorted
     *  array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right
     * of pivot
     * @param arr the array to work with
     * @param low the low index of the array
     * @param high the high index of the array
     * @return and integer specifying the pivot position
     */
    static final int partition (Comparable[] arr, final int low, final int high)
    {
        // pivot (Element to be placed at right position);
        Object pivot;
        pivot = arr[high];

        int i = (low - 1), j = low;  // Index of smaller element and indicates the
        // right position of pivot found so far

        for (j = low; j <= high- 1; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j].compareTo(pivot) < 0)
            {
                i++;    // increment index of smaller element
                swap(arr, i,j);
            }
        }
        swap(arr, i+1, high);
        return (i + 1);
    }
}

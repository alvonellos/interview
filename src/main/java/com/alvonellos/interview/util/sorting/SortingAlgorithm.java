package com.alvonellos.interview.util.sorting;

public abstract class SortingAlgorithm {
    static <E> void swap(E[] a, int i, int j) {
        if (i != j) {
            E temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    /* This function takes last element as pivot, places
the pivot element at its correct position in sorted
 array, and places all smaller (smaller than pivot)
to left of pivot and all greater elements to right
of pivot */
    static int partition (Comparable[] arr, int low, int high)
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

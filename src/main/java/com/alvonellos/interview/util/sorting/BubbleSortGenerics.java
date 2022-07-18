package com.alvonellos.interview.util.sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BubbleSortGenerics<E> {

    <E> void swap(E[] a, int i, int j) {
        if (i != j) {
            E temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public  <E extends Comparable<E>> void BubbleSort(E[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    swap(a, j, j + 1);
                }
            }
        }
    }
}
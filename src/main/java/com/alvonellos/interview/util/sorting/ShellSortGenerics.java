package com.alvonellos.interview.util.sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ShellSortGenerics {

    <E> void swap(E[] a, int i, int j) {
        if (i != j) {
            E temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public <E extends Comparable<E>> void ShellSort(E[] a) {

        int n = a.length;
 
        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                E temp = a[i];
 
                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && a[j - gap].compareTo(temp) > 0; j -= gap)
                    a[j] = a[j - gap];
 
                // put temp (the original a[i]) in its correct
                // location
                a[j] = temp;
            }
        }
    }
   

    public static void main(String[] args){
        SelectionSortGenerics firstsort = new SelectionSortGenerics();

        Integer[] arr = {3,4,1,5};
        System.out.println("before sorting int: "+ Arrays.toString(arr));
        firstsort.selectionSort(arr);
        System.out.println("After sorting int : "+Arrays.toString(arr));
         String[] arr1= {"acd","ded","dal","bad","cle"};
         System.out.println("before sorting String: "+ Arrays.toString(arr1));
         firstsort.selectionSort(arr1);
         System.out.println("After sorting String : "+Arrays.toString(arr1));
         Character[] arr2= {'c','e','a','d','c'};
         System.out.println("before sorting char: "+ Arrays.toString(arr2));
         firstsort.selectionSort(arr2);
         System.out.println("After sorting char : "+Arrays.toString(arr2));
    }
}
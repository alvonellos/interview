/*
package com.alvonellos.interview.util.sorting;
import java.util.Arrays;
import java.util.List;


public class QuickSortGenerics<E> {
    */
/**
     *
     * @param a The element to swap
     * @param i The index of the element to swap
     * @param j The index of the element to swap with the first element
     *//*

    <E> void swap(E[] a, int i, int j) {
        if (i != j) {
            E temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    <E> void QuickSort(List<E> arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            QuickSort(arr, low, pivot - 1);
            QuickSort(arr, pivot + 1, high);
        }
    }

    */
/* This function takes last element as pivot, places
    the pivot element at its correct position in sorted
     array, and places all smaller (smaller than pivot)
    to left of pivot and all greater elements to right
    of pivot *//*

	 private int partition (List<E> array, int low, int high)
	 {
	     // pivot (Element to be placed at right position)
         E[] arr = (E[]) array.toArray();
	     E pivot;
         pivot = arr[high];
	  
	     int i = (low - 1), j = low;  // Index of smaller element and indicates the
                                     // right position of pivot found so far
	
	     for (j = low; j <= high- 1; j++)
	     {
	         // If current element is smaller than the pivot
	         if (((Comparable<E>) arr[j]).compareTo(pivot) < 0)
	         {
	             i++;    // increment index of smaller element
	             swap(arr, i,j);
	         }
	     }
	     swap(arr, i+1, high);
	     return (i + 1);
	 }


    public static void main(String[] args){
        QuickSortGenerics firstsort = new QuickSortGenerics();

        List<Integer> arr = Arrays.asList(3,4,1,5);
        System.out.println("before sorting int: "+ Arrays.toString(arr));
        firstsort.QuickSort(arr);
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
}*/

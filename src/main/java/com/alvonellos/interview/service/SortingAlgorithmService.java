package com.alvonellos.interview.service;

import com.alvonellos.interview.util.sorting.BubbleSortGenerics;
import com.alvonellos.interview.util.sorting.QuickSortGenerics;
import com.alvonellos.interview.util.sorting.SelectionSortGenerics;
import com.alvonellos.interview.util.sorting.ShellSortGenerics;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SortingAlgorithmService {

    final BubbleSortGenerics<?> bubbleSortGenerics = new BubbleSortGenerics();
    final QuickSortGenerics<?> quickSortGenerics = new QuickSortGenerics();
    final SelectionSortGenerics<?> selectionSortGenerics = new SelectionSortGenerics();
    final ShellSortGenerics<?> shellSortGenerics = new ShellSortGenerics();

    public <E extends Comparable<E>> E[] bubbleSort(E[] e) {
        bubbleSortGenerics.sort(e);
        return e;
    }


    public <E extends Comparable<E>> E[] quickSort(E[] e) {
        quickSortGenerics.sort(e);
        return e;
    }


    public <E extends Comparable<E>> E[] selectionSort(E[] e) {
        selectionSortGenerics.sort(e);
        return e;
    }


    public <E extends Comparable<E>> E[] shellSort(E[] e) {
        shellSortGenerics.sort(e);
        return e;
    }
}

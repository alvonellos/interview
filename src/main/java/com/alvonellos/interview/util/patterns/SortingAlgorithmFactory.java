package com.alvonellos.interview.util.patterns;

import com.alvonellos.interview.util.sorting.*;

public class SortingAlgorithmFactory {
    public static SortingAlgorithm getSortingAlgorithm(SortingAlgorithm.Algorithm algorithm) {
        switch (algorithm) {
            case BUBBLE:
                return new BubbleSortGenerics();
            case QUICK:
                return new QuickSortGenerics();
            case SELECTION:
                return new SelectionSortGenerics();
            case SHELL:
                return new ShellSortGenerics();
            case MERGE:
                return new MergeSortGenerics();
            default:
                return null;
        }
    }
}

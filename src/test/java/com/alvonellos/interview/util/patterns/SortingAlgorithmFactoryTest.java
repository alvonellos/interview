package com.alvonellos.interview.util.patterns;

import com.alvonellos.interview.util.sorting.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingAlgorithmFactoryTest {
    @Test
    void getSortingAlgorithm() {
        SortingAlgorithmFactory factory = new SortingAlgorithmFactory();
        assert(factory.getSortingAlgorithm(SortingAlgorithm.Algorithm.BUBBLE) instanceof BubbleSortGenerics);
        assert(factory.getSortingAlgorithm(SortingAlgorithm.Algorithm.QUICK) instanceof QuickSortGenerics);
        assert(factory.getSortingAlgorithm(SortingAlgorithm.Algorithm.SELECTION) instanceof SelectionSortGenerics);
        assert(factory.getSortingAlgorithm(SortingAlgorithm.Algorithm.SHELL) instanceof ShellSortGenerics);
        assert(factory.getSortingAlgorithm(SortingAlgorithm.Algorithm.MERGE) instanceof MergeSortGenerics);
    }
}
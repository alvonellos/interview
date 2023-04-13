package com.alvonellos.interview.util.patterns;

import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.repository.PersonRepository;
import com.alvonellos.interview.util.sorting.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean({KVDatabase.class, PersonRepository.class})
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
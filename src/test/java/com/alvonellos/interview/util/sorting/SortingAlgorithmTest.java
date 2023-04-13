package com.alvonellos.interview.util.sorting;

import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.repository.PersonRepository;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
@MockBean({KVDatabase.class, PersonRepository.class})
class SortingAlgorithmTest {
    SecureRandom random = new SecureRandom();
    static final int STREAM_SIZE = 1024;

    @RepeatedTest(10)
    void swap() {
        Integer[] a = random.ints(STREAM_SIZE).boxed().sorted().toArray(Integer[]::new);
        int pic = random.nextInt(STREAM_SIZE);
        int pic1 = random.nextInt(STREAM_SIZE);

        assert pic != pic1 || (true);

        Integer i = a[pic]; Integer j = a[pic1];

        System.err.println("pic: " + pic + " pic1: " + pic1);

        SortingAlgorithm.swap(a, pic, pic1);

        assert(a[pic] == j && a[pic1] == i);

    }

    @RepeatedTest(100)
    void partition() {
        Integer[] a = random.ints(STREAM_SIZE).boxed().toArray(Integer[]::new);

        System.err.println(Arrays.stream(a).collect(Collectors.toList()));

        int pivot = SortingAlgorithm.partition(a, 0, a.length - 1);
        System.err.println(pivot);

        System.err.println(Arrays.stream(a).collect(Collectors.toList()));

        if(pivot >= 0 && pivot < a.length - 2) {
            assert(a[pivot] < a[pivot + 1]);
        } else { // pivot = a.length -1
            assert(a[pivot] > a[pivot - 1]);
        }
    }
}
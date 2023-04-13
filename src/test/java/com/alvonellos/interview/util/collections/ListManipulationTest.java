package com.alvonellos.interview.util.collections;

import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean({KVDatabase.class, PersonRepository.class})
class ListManipulationTest {

    @Test
    void removeDuplicatesTest() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        assertEquals(6, list.size());
        new ListManipulation<String>().removeDuplicates(list);
        assertEquals(5, list.size());
    }

    @Test
    void removeDuplicatesTest2() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        assertEquals(6, list.size());
        new ListManipulation<String>().removeDuplicatesAlgorithm(list);
        assertEquals(5, list.size());
    }

    @Test
    void removeDuplicatesTestStreams() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        assertEquals(6, list.size());
        list = new ListManipulation<String>().removeDuplicatesStreams(list);
        assertEquals(5, list.size());
    }
}
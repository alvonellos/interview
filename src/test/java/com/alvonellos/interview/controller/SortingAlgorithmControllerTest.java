package com.alvonellos.interview.controller;

import com.alvonellos.interview.service.SortingAlgorithmService;
import com.alvonellos.interview.util.sorting.SortingAlgorithm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static kafka.network.RequestConvertToJson.response;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SortingAlgorithmControllerTest {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final SecureRandom random = new SecureRandom();
    private static final List<String> actual = Stream.of("10", "9", "8", "7", "6", "5", "4", "3", "2", "1").collect(Collectors.toList());
    private static final List<String> expected = actual.stream().sorted().collect(Collectors.toList());

    @Autowired
    MockMvc mockMvc;
    @InjectMocks
    private SortingAlgorithmController controller;
    @MockBean
    private SortingAlgorithmService sortingAlgorithmService;

    @BeforeEach
    void setUp() {
        SortingAlgorithmService sortingAlgorithmService = mock(SortingAlgorithmService.class);

        ReflectionTestUtils.setField(controller, "sortingAlgorithmService", sortingAlgorithmService);
    }

    @AfterEach
    void tearDown() {
        reset(sortingAlgorithmService);
    }


    @Test
    public void contextLoads() throws Exception {
        assertNotNull(controller);
    }

    @Test
    void sort() throws Exception {
        for(SortingAlgorithm.Algorithm algorithm : SortingAlgorithm.Algorithm.values()) {
            mockMvc.perform(
                    post("/sort")
                            .content(mapper.writeValueAsString(actual))
                            .queryParam("algorithm", algorithm.name())
                            .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(expected), false))
                    .andReturn();
        }

        verify(sortingAlgorithmService, atMostOnce()).bubbleSort(any());
        verify(sortingAlgorithmService, atMostOnce()).quickSort(any());
        verify(sortingAlgorithmService, atMostOnce()).selectionSort(any());
        verify(sortingAlgorithmService, atMostOnce()).shellSort(any());
        verify(sortingAlgorithmService, atMostOnce()).mergeSort(any());
    }

    @Test
    void sortAndFailBecauseBadAlgorithm() throws Exception {
        mockMvc.perform(
                        post("/sort")
                                .content(mapper.writeValueAsString(actual))
                                .queryParam("algorithm", "TESTSORT")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
package com.alvonellos.interview.Interviews.DG;
import com.alvonellos.interview.exceptions.InterviewAPIException;
import com.alvonellos.interview.model.KVEntity;
import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.repository.PersonRepository;
import com.alvonellos.interview.service.KVService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class DGSolutionTest {
    private static final String[] THREE_CONSECUTIVE_AMIGOS_HAPPY = new String[]{"153", "153", "153"};

    public static final ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks
    private DGSolution solution;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void setUp() {
        assertNotNull(solution);
        assertNotNull(mockMvc);

    }

    @Test
    public void testIsArmstrongNumber() {
        assertTrue(solution.isArmstrongNumber(String.valueOf(153)));
    }

    @Test
    public void testIsConsecutive() {
        assertTrue(solution.isConsecutive(THREE_CONSECUTIVE_AMIGOS_HAPPY));
    }

    @Test
    public void testIsConsecutiveArmStrong() throws Exception {
        String requestJson = objectMapper.writeValueAsString(THREE_CONSECUTIVE_AMIGOS_HAPPY);

        val result = mockMvc.perform(get("/armstrong")
                        .content(requestJson)
                        .contentType("application/json")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assert(result.getResponse().getContentAsString().contains("true"));
    }
}
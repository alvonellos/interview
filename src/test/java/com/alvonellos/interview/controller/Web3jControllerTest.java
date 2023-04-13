package com.alvonellos.interview.controller;

import com.alvonellos.interview.model.KVEntity;
import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.repository.PersonRepository;
import com.alvonellos.interview.service.Web3jService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.security.SecureRandom;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean({PersonRepository.class})
class Web3jControllerTest {

    @MockBean
    private Web3jService web3jService;
    @Autowired
    MockMvc mockMvc;
    @InjectMocks
    private Web3jController web3jController;

    @MockBean
    KVDatabase kvDatabase;

    @BeforeEach
    void setUp() {
        doReturn(Optional.of(new KVEntity(1L, "FORTUNE", "TEST"))).when(kvDatabase).findById(any());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(web3jController);
    }

    @Test
    void getFortune() throws Exception {
        val request = mockMvc.perform(
                get("/fortune"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        assertNotNull(request.getResponse());
    }

}
package com.alvonellos.interview.controller;

import com.alvonellos.interview.model.KVEntity;
import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.repository.PersonRepository;
import com.alvonellos.interview.service.KVService;
import com.alvonellos.interview.service.MemeService;
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
import org.springframework.test.web.servlet.MockMvc;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean({PersonRepository.class, KVDatabase.class})
class MemeControllerTest {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final SecureRandom random = new SecureRandom();

    @Autowired
    MockMvc mockMvc;
    @InjectMocks
    private KVController controller;

    @MockBean
    MemeService memeService;

    private static final KVEntity TEST_FOUND_KV_ENTITY =
            new KVEntity(1L, "TEST", "TEST");

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        assertNotNull(mockMvc);
    }

    @Test
    void contextLoads() throws Exception {
        assertNotNull(controller);
        assertNotNull(mockMvc);
    }


    @Test
    void getAllTest() throws Exception {
        doCallRealMethod().when(memeService).memeList();

        val result = mockMvc.perform(
                get("/memes"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result);
//        assertEquals(mapper.readValue(mapper.writeValueAsString(Arrays.asList(TEST_FOUND_KV_ENTITY)), List.class),
//                mapper.readValue(result.getResponse().getContentAsString(), List.class));
    }

//    @Test
//    void postTest() throws Exception {
//        doReturn(1L)
//                .when(kvService)
//                .post(anyString(), anyString());
//
//        val result = mockMvc.perform(
//                post("/kv")
//                        .param("key", "TEST")
//                        .param("value", "TEST"))
//                .andDo(print())
//                .andExpect(status().isCreated())
//                .andReturn();
//
//        assertNotNull(result);
//        assertEquals("1", result.getResponse().getContentAsString());
//        verify(kvService, times(1)).post(TEST_FOUND_KV_ENTITY.getKVEntityKey(), TEST_FOUND_KV_ENTITY.getKVEntityValue());
//    }
//
//    @Test
//    void putTest() throws Exception {
//        doReturn(TEST_FOUND_KV_ENTITY)
//                .when(kvService)
//                .put(any(KVEntity.class));
//
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
//        String requestJson = ow.writeValueAsString(TEST_FOUND_KV_ENTITY);
//
//        val result = mockMvc.perform(
//                        put("/kv")
//                                .content(requestJson)
//                                .contentType("application/json"))
//                .andDo(print())
//                .andExpect(status().isNoContent())
//                .andReturn();
//
//        assertNotNull(result);
//        assertEquals("", result.getResponse().getContentAsString());
//        verify(kvService, times(1)).put(TEST_FOUND_KV_ENTITY);
//    }
//
//    @Test
//    void deleteTest() throws Exception {
//        doNothing().when(kvService).delete(any(Long.class));
//
//        val result = mockMvc.perform(
//                        delete("/kv/1"))
//                .andDo(print())
//                .andExpect(status().isNoContent())
//                .andReturn();
//
//        assertNotNull(result);
//        verify(kvService, times(1)).delete(any(Long.class));
//    }
}
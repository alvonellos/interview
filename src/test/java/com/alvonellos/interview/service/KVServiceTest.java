package com.alvonellos.interview.service;

import com.alvonellos.interview.exceptions.InterviewAPIException;
import com.alvonellos.interview.model.KVEntity;
import com.alvonellos.interview.repository.KVDatabase;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
class KVServiceTest {

    @MockBean
    KVDatabase kvDatabase;

    @InjectMocks
    KVService kvService;

    private static final KVEntity TEST_FOUND_KV_ENTITY =
            new KVEntity(1L, "TEST", "TEST");

    @BeforeEach
    void setUp() {
        doReturn(List.of(TEST_FOUND_KV_ENTITY)).when(kvDatabase).saveAll(any());

        ReflectionTestUtils.setField(kvService, "kvDatabase", kvDatabase);
    }

    @AfterEach
    void tearDown() {
        reset(kvDatabase);
    }

    @Test
    void contextLoads() {
        assertNotNull(kvService);
        assertNotNull(kvDatabase);
    }

    @Test
    void getTest() throws InterviewAPIException {
        when(kvDatabase.findById(1L)).thenReturn(Optional.of(TEST_FOUND_KV_ENTITY));

        KVEntity kvEntity = kvService.get(1L);

        verify(kvDatabase, times(1)).findById(1L);
    }

    @Test
    void post() throws InterviewAPIException {
        when(kvDatabase.save(any())).thenReturn(TEST_FOUND_KV_ENTITY);

        Long kvEntityId = kvService.post(TEST_FOUND_KV_ENTITY.getKVEntityKey(), TEST_FOUND_KV_ENTITY.getKVEntityValue());

        assertEquals(TEST_FOUND_KV_ENTITY.getKVEntityId(), kvEntityId);
    }

    @Test
    void put() throws InterviewAPIException {
        doReturn(TEST_FOUND_KV_ENTITY).when(kvDatabase).save(any());
        doReturn(Optional.of(TEST_FOUND_KV_ENTITY)).when(kvDatabase).findById(1L);

        KVEntity kvEntity = kvService.put(TEST_FOUND_KV_ENTITY);

        assertEquals(TEST_FOUND_KV_ENTITY.getKVEntityId(), kvEntity.getKVEntityId());
    }

    @Test
    void delete() {
        doNothing().when(kvDatabase).deleteById(TEST_FOUND_KV_ENTITY.getKVEntityId());

        kvService.delete(TEST_FOUND_KV_ENTITY.getKVEntityId());

        verify(kvDatabase, times(1)).deleteById(TEST_FOUND_KV_ENTITY.getKVEntityId());
    }

    @Test
    void findAll() {
        doReturn(List.of(TEST_FOUND_KV_ENTITY)).when(kvDatabase).findAll();

        val response =
                kvService.findAll();

        assertEquals(1, response.size());
        verify(kvDatabase, times(1)).findAll();

    }

    @Test
    void searchByKey() {
        doReturn(List.of(TEST_FOUND_KV_ENTITY)).when(kvDatabase)
                .findAll(any(Example.class));

        val response =
                kvService.searchByKey(TEST_FOUND_KV_ENTITY.getKVEntityKey());

        assertEquals(1, response.size());
        verify(kvDatabase, times(1)).findAll(any(Example.class));
    }
}
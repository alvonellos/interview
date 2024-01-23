package com.alvonellos.interview.controller;

import com.alvonellos.interview.repository.KVDatabase;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean(KVDatabase.class)
public class PascalControllerTest {
    @Autowired
    MockMvc mockMvc;
    @InjectMocks
    private PascalController controller;

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(controller);
    }

    @Test
    void getPascal() throws Exception {
        val request = mockMvc.perform(
                        get("/pascal/{numRows}/", 1))
                .andDo(print())
                .andExpect(status().isOk());

        val response = request.andReturn().getResponse().getContentAsString();
        assertNotNull(response);

        val request2 = mockMvc.perform(
                        get("/pascal/{numRows}/", 11))
                .andDo(print())
                .andExpect(status().isCreated());

        val response2 = request2.andReturn().getResponse().getContentAsString();
        assertNotNull(response2);

    }

}

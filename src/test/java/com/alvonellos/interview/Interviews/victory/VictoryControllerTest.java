package com.alvonellos.interview.Interviews.victory;

import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.stackoverflow.Answer77901934.StaffRepository;
import lombok.extern.java.Log;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Log
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
@MockBean({VictoryRepo.class, KVDatabase.class, StaffRepository.class})
public class VictoryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    VictoryService victoryService;

    @InjectMocks
    VictoryController victoryController;

    @Test
    public void health() throws Exception {
        log.info("Testing health");

        doReturn(true).when(victoryService).health();

        val result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/victory/status"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        assertNotNull(result);
        verify(victoryService, times(1)).health();
    }

    @Test
    public void get() {
    }

    @Test
    public void post() {
    }
}
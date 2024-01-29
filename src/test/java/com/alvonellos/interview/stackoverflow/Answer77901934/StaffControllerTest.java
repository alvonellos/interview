package com.alvonellos.interview.stackoverflow.Answer77901934;

import com.alvonellos.interview.repository.KVDatabase;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Log
@WebMvcTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
@MockBean({KVDatabase.class, StaffRepository.class})
public class StaffControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private StaffService staffService;
    @InjectMocks
    private StaffController staffController;


    @Before
    public void setUp() throws Exception {
        doReturn(List.of(
                new Staff(1L, "TEST", "TEST@TEST.COM", "123456789", LocalDate.of(1990, 1, 1), 25, "Developer"),
                new Staff(2L, "TEST", "TEST@TEST.COM", "123456789", LocalDate.of(1990, 1, 1), 25, "Developer"),
                new Staff(3L, "TEST", "TEST@TEST.COM", "123456789", LocalDate.of(1990, 1, 1), 25, "Developer")
        )).when(staffService).getStaffs();
    }

    @Test
    public void contextLoads() {
        assertNotNull("mockMvc should not be null", mockMvc);
        assertNotNull("objectMapper should not be null", objectMapper);
        assertNotNull("staffService should not be null", staffService);
        assertNotNull("staffController should not be null", staffController);
    }
    @Test
    public void getStaff_shouldReturnThreeEntities() throws Exception {
        val result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/staff"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andDo(print())
                .andReturn();

        verify(staffService, times(1)).getStaffs();

        val json = result.getResponse().getContentAsString();
        val staffs = objectMapper.readValue(json, List.class);
        assertEquals(3, staffs.size());
    }

    @Test
    public void getStaff_shouldReturnNoEntities() throws Exception {
        doReturn(List.of()).when(staffService).getStaffs();

        val result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/staff"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("[]"))
                .andDo(print())
                .andReturn();

        verify(staffService, times(1)).getStaffs();

        val json = result.getResponse().getContentAsString();
        val staffs = objectMapper.readValue(json, List.class);
        assertEquals(0, staffs.size());
    }
}
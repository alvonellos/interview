package com.alvonellos.interview.stackoverflow.Answer77901934;

import com.alvonellos.interview.repository.KVDatabase;
import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@MockBean(KVDatabase.class)
public class StaffServiceTest {

    @Mock
    StaffRepository staffRepository;

    @InjectMocks
    StaffService staffService;

    @Test
    public void contextLoads() {
      assertNotNull("staffRepository should not be null", staffRepository);
      assertNotNull("staffService should not be null", staffService);
    }

    @Test
    public void getStaffs() {
        doReturn(List.of(
                new Staff(1L, "TEST", "TEST@TEST.COM", "123456789", LocalDate.of(1990, 1, 1), 25, "Developer"),
                new Staff(2L, "TEST", "TEST@TEST.COM", "123456789", LocalDate.of(1990, 1, 1), 25, "Developer"),
                new Staff(3L, "TEST", "TEST@TEST.COM", "123456789", LocalDate.of(1990, 1, 1), 25, "Developer")
        )).when(staffRepository).findAll();

        val result = staffService.getStaffs();

        assertNotNull("result should not be null", result);
        assertEquals("result should have three elements", 3, result.size());
        verify(staffRepository, times(1)).findAll();
        verifyNoMoreInteractions(staffRepository);
    }
}
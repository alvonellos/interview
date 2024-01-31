package com.alvonellos.interview.Interviews.victory;

import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.stackoverflow.Answer77901934.StaffRepository;
import lombok.extern.java.Log;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.junit.Assert.*;


@Log
@RunWith(SpringJUnit4ClassRunner.class)
@MockBean({KVDatabase.class, StaffRepository.class})
public class VictoryServiceTest {

    long[] odds = new long[] {1l,3l,5l,7l,9l};
    long[] evens = new long[] {0l,2l,4l,6l,8l,10l};

    @MockBean
    VictoryRepo victoryRepo;

    @InjectMocks
    VictoryService victoryService;


    @Test
    public void getOnly() {
        val resultOdds = victoryService.getOnly(true);
        assertArrayEquals("should be exactly odd", odds, resultOdds);
        val resultEvens = victoryService.getOnly(false);
        assertArrayEquals("should be exactly evens", evens, resultEvens);
    }


}
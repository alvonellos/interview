package com.alvonellos.interview.util.numbers;

import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean({KVDatabase.class, PersonRepository.class})
class MaxProfitTest {

    @Test
    void maxProfit() {
        int[] prices = {7,1,5,3,6,4};
        assertEquals(5, MaxProfit.maxProfit(prices));

        int[] prices2 = {7,6,4,3,1};
        assertEquals(0, MaxProfit.maxProfit(prices2));
    }
}
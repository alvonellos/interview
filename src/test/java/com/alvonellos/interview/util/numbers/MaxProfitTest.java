package com.alvonellos.interview.util.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProfitTest {

    @Test
    void maxProfit() {
        int[] prices = {7,1,5,3,6,4};
        assertEquals(5, MaxProfit.maxProfit(prices));

        int[] prices2 = {7,6,4,3,1};
        assertEquals(0, MaxProfit.maxProfit(prices2));
    }
}
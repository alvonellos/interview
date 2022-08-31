package com.alvonellos.interview.datastructures;

import com.alvonellos.interview.util.math.BigDecimalUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class PerformanceTestTest {
    @Test
    void testTimeInsertionTreeMap() {
        PerformanceTest performanceTest = new PerformanceTest();
        for(int i = 1; i < 7; i++ ) { // i = 10, 100, 1000, 10000, 100000, 1000000
            System.err.println(i + " : " + (int) Math.pow(10, i) + " : " + performanceTest.timeInsertionTreeMap((int) Math.pow(10, i)));
        }
    }

    @Test
    void testTimeSearchTreeMap() {
        PerformanceTest performanceTest = new PerformanceTest();
        System.err.println("i : " + " (int) Math.pow(10, i) " + " : " + "performanceTest.timeSearchTreeMap((int) Math.pow(10, 10)))");
        for(int i = 1; i < 7; i++ ) { // i = 10, 100, 1000, 10000, 100000, 1000000
            System.err.println(i + " : " + (int) Math.pow(10, i) + " : " + performanceTest.timeSearchTreeMap((int) Math.pow(10, i)));
        }// }
    }


}
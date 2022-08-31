package com.alvonellos.interview.util.math;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class Log2Test {

    @Test
    void log2() {
        assertEquals(1,Log2.log2(2));
        assertEquals(10, Log2.log2(1024));
    }

    @Test
    void testLog2() {
        assertEquals(1.0,Log2.log2(2.0));
        assertEquals(10.0, Log2.log2(1024.0));
    }

    @Test
    void testLog2BigDecimal() {
        assertEquals(BigDecimal.valueOf(1),Log2.log2(BigDecimal.valueOf(2.0)));
        assertEquals(10, Log2.log2(BigDecimal.valueOf(1024).intValue()));
    }
}
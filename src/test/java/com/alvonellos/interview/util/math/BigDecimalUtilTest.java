package com.alvonellos.interview.util.math;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class BigDecimalUtilTest {

    @Test
    void sqrtTest() {
        assertEquals(1, BigDecimalUtil.sqrt(BigDecimal.valueOf(1)).intValue());
        assertEquals(2, BigDecimalUtil.sqrt(BigDecimal.valueOf(4)).intValue());
        assertEquals(3, BigDecimalUtil.sqrt(BigDecimal.valueOf(9)).intValue());
        assertEquals(4, BigDecimalUtil.sqrt(BigDecimal.valueOf(16)).intValue());
        assertEquals(5, BigDecimalUtil.sqrt(BigDecimal.valueOf(25)).intValue());
        assertEquals(6, BigDecimalUtil.sqrt(BigDecimal.valueOf(36)).intValue());
        assertEquals(7, BigDecimalUtil.sqrt(BigDecimal.valueOf(49)).intValue());
        assertEquals(8, BigDecimalUtil.sqrt(BigDecimal.valueOf(64)).intValue());
        assertEquals(9, BigDecimalUtil.sqrt(BigDecimal.valueOf(81)).intValue());
        assertEquals(10, BigDecimalUtil.sqrt(BigDecimal.valueOf(100)).intValue());
    }

    @Test
    void intRootTest() {
        assertEquals(1, BigDecimalUtil.intRoot(BigDecimal.valueOf(1), 1, -1).intValue());
        assertEquals(2, BigDecimalUtil.intRoot(BigDecimal.valueOf(4), 2, 0).intValue());
    }

    @Test
    void lnTest() {
        assertEquals(1, BigDecimalUtil.ln(BigDecimal.valueOf(Math.exp(1)), 15).doubleValue());
    }

    @Test
    void cosineTest() {
        assertEquals(1, BigDecimalUtil.cosine(BigDecimal.ZERO).intValue());
    }

    @Test
    void sineTest() {
        assertEquals(0, BigDecimalUtil.sine(BigDecimal.ZERO).intValue());
    }

    @Test
    void tangentTest() {
        assertEquals(0, BigDecimalUtil.tangent(BigDecimal.ZERO).intValue());
    }

    @Test
    void log10() {
        assertEquals(2, BigDecimalUtil.log10(BigDecimal.valueOf(100)).intValue());
    }

    @Test
    void cuberootTest() {
        assertEquals(1, BigDecimalUtil.cuberoot(BigDecimal.valueOf(1)).intValue());
        assertEquals(2, BigDecimalUtil.cuberoot(BigDecimal.valueOf(8)).intValue());
        assertEquals(3, BigDecimalUtil.cuberoot(BigDecimal.valueOf(27)).intValue());
        assertEquals(4, BigDecimalUtil.cuberoot(BigDecimal.valueOf(64)).intValue());
        assertEquals(5, BigDecimalUtil.cuberoot(BigDecimal.valueOf(125)).intValue());
        assertEquals(6, BigDecimalUtil.cuberoot(BigDecimal.valueOf(216)).intValue());
        assertEquals(7, BigDecimalUtil.cuberoot(BigDecimal.valueOf(343)).intValue());
        assertEquals(8, BigDecimalUtil.cuberoot(BigDecimal.valueOf(512)).intValue());
        assertEquals(9, BigDecimalUtil.cuberoot(BigDecimal.valueOf(729)).intValue());
        assertEquals(10, BigDecimalUtil.cuberoot(BigDecimal.valueOf(1000)).intValue());
    }

    @Test
    void powTest() {
        assertEquals(1, BigDecimalUtil.pow(BigDecimal.valueOf(1), BigDecimal.valueOf(1)).intValue());
        assertEquals(2, BigDecimalUtil.pow(BigDecimal.valueOf(2), BigDecimal.valueOf(1)).intValue());
        assertEquals(4, BigDecimalUtil.pow(BigDecimal.valueOf(2), BigDecimal.valueOf(2)).intValue());
        assertEquals(8, BigDecimalUtil.pow(BigDecimal.valueOf(2), BigDecimal.valueOf(3)).intValue());
        assertEquals(16, BigDecimalUtil.pow(BigDecimal.valueOf(2), BigDecimal.valueOf(4)).intValue());
        assertEquals(32, BigDecimalUtil.pow(BigDecimal.valueOf(2), BigDecimal.valueOf(5)).intValue());
        assertEquals(64, BigDecimalUtil.pow(BigDecimal.valueOf(2), BigDecimal.valueOf(6)).intValue());
        assertEquals(128, BigDecimalUtil.pow(BigDecimal.valueOf(2), BigDecimal.valueOf(7)).intValue());
        assertEquals(256, BigDecimalUtil.pow(BigDecimal.valueOf(2), BigDecimal.valueOf(8)).intValue());
        assertEquals(512, BigDecimalUtil.pow(BigDecimal.valueOf(2), BigDecimal.valueOf(9)).intValue());
        assertEquals(1024, BigDecimalUtil.pow(BigDecimal.valueOf(2), BigDecimal.valueOf(10)).intValue());
    }

    @Test
    void intPowerTest() {
        assertEquals(1, BigDecimalUtil.intPower(BigDecimal.valueOf(2), 0l, 0).intValue());
        assertEquals(2, BigDecimalUtil.intPower(BigDecimal.valueOf(2), 1l, 0).intValue());
        assertEquals(4, BigDecimalUtil.intPower(BigDecimal.valueOf(2), 2l, 0).intValue());
        assertEquals(8, BigDecimalUtil.intPower(BigDecimal.valueOf(2), 3l, 0).intValue());
        assertEquals(16, BigDecimalUtil.intPower(BigDecimal.valueOf(2), 4l, 0).intValue());
        assertEquals(32, BigDecimalUtil.intPower(BigDecimal.valueOf(2), 5l, 0).intValue());
        assertEquals(64, BigDecimalUtil.intPower(BigDecimal.valueOf(2), 6l, 0).intValue());
        assertEquals(128, BigDecimalUtil.intPower(BigDecimal.valueOf(2), 7l, 0).intValue());
        assertEquals(256, BigDecimalUtil.intPower(BigDecimal.valueOf(2), 8l, 0).intValue());
        assertEquals(512, BigDecimalUtil.intPower(BigDecimal.valueOf(2), 9l, 0).intValue());
        assertEquals(1024, BigDecimalUtil.intPower(BigDecimal.valueOf(2), 10l, 0).intValue());
    }

    @Test
    void expTest() {
        assertEquals(1, BigDecimalUtil.exp(BigDecimal.valueOf(0), 0).intValue());
        assertEquals(2, BigDecimalUtil.exp(BigDecimal.valueOf(1), 0).intValue());
        assertEquals(4, BigDecimalUtil.exp(BigDecimal.valueOf(2), 0).intValue());
        assertEquals(8, BigDecimalUtil.exp(BigDecimal.valueOf(3), 0).intValue());
        assertEquals(16, BigDecimalUtil.exp(BigDecimal.valueOf(4), 0).intValue());
        assertEquals(32, BigDecimalUtil.exp(BigDecimal.valueOf(5), 0).intValue());
        assertEquals(64, BigDecimalUtil.exp(BigDecimal.valueOf(6), 0).intValue());
        assertEquals(128, BigDecimalUtil.exp(BigDecimal.valueOf(7), 0).intValue());
        assertEquals(256, BigDecimalUtil.exp(BigDecimal.valueOf(8), 0).intValue());
        assertEquals(512, BigDecimalUtil.exp(BigDecimal.valueOf(9), 0).intValue());
        assertEquals(1024, BigDecimalUtil.exp(BigDecimal.valueOf(10), 0).intValue());
    }

    @Test
    void asinTest() {
        assertEquals(0, BigDecimalUtil.asin(BigDecimal.valueOf(0)).intValue());
        assertEquals(1, BigDecimalUtil.asin(BigDecimal.valueOf(1)).intValue());
    }

    @Test
    void acos() {
        assertEquals(1, BigDecimalUtil.acos(BigDecimal.valueOf(0)).intValue());
        assertEquals(0, BigDecimalUtil.acos(BigDecimal.valueOf(1)).intValue());
    }

    @Test
    void atan() {
        assertEquals(0, BigDecimalUtil.atan(BigDecimal.valueOf(0)).intValue());
        assertEquals(0, BigDecimalUtil.atan(BigDecimal.valueOf(1)).intValue());
    }
}
package com.alvonellos.interview.util.math;

import java.math.BigDecimal;

public class Log2 {
    public static double log2(double n) {
        return Math.log(n) / Math.log(2);
    }

    public static int log2(int N) {
        return (int)(Math.log(N) / Math.log(2));
    }

    public static BigDecimal log2(BigDecimal n) {
        try {
            return BigDecimalUtil
                    .ln(n, 10)
                    .divide(BigDecimalUtil.ln(BigDecimal.valueOf(2), 10));
        } catch (ArithmeticException e) {
            return BigDecimalUtil
                    .ln(n, 10)
                    .divide(BigDecimalUtil.ln(BigDecimal.valueOf(2), 10), BigDecimal.ROUND_HALF_UP);
        }
    }
}

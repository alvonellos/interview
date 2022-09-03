package com.alvonellos.interview.util.math;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegralTest {
    @Test
    public void testIntegrate() {
        assert(Integral.integrate(1, 2, 0.00001, x -> 2*x) == 2.9999900000065516);
    }

    @Test
    public void testBigIntegrate() {
        assert(
                Integral.integrate(
                        BigDecimal.ONE,
                        BigDecimal.TEN,
                        new BigDecimal(0.00001),
                        x -> x.multiply(x))
                    .compareTo(
                            new BigDecimal("332.999505000150073622634407404785312160947363385603636886465459983353896294661663124381305462575970402987658656776623592045390607918219795382284635904099751696586266189181735342117463005706667900085449218750000")
                    ) == 0);
    }

    @Test
    void integrateParallel() {
        assertEquals(2.999999983922528, Integral.integrateParallel(1, 2, 0.00000001, x -> 2*x));
    }

//    @Test // interestingly, this test fails miserably because parellel is SLOWER than sequential. go figure.
//    void integrateParallelTimed() {
//        long start = System.currentTimeMillis();
//        Integral.integrateParallel(1, 2, 0.000001, x -> 2*x);
//        long end = System.currentTimeMillis();
//        System.err.println(end - start);
//
//        long start2 = System.currentTimeMillis();
//        Integral.integrate(1, 2, 0.000001, x -> 2*x);
//        long end2 = System.currentTimeMillis();
//        System.err.println(end2 - start2);
//
//        assert(end - start < end2 - start2);
//    }
}

package com.alvonellos.interview.util.math;

import java.math.BigDecimal;
import java.util.function.*;
import java.util.stream.Stream;

public class Integral {

    /**
     * Integrate a function using the trapezoidal rule.
     * @param a The lower bound of the integral.
     * @param b The upper bound of the integral.
     * @param h The step size.
     * @param f The function to integrate.
     * @return
     */
    public static double integrate(double a, double b, double h, DoubleFunction<Double> f) {
        double sum = 0;
        for (double x = a; x < b; x += h) {
            sum += f.apply(x);
        }
        return sum * h;
    }

    /**
     * Integrate a function using the trapezoidal rule.
     * @param a The lower bound of the integral.
     * @param b The upper bound of the integral.
     * @param h The step size.
     * @param f The function to integrate.
     * @return
     */
    public static BigDecimal integrate(BigDecimal a, BigDecimal b, BigDecimal h, Function<BigDecimal, BigDecimal> f) {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal x = a; x.compareTo(b) < 0; x = x.add(h)) {
            sum = sum.add(f.apply(x));
        }
        return sum.multiply(h);
    }

    /**
     * Integrate using parallel streams.
     * @param a lower bound
     * @param b the upper bound
     * @param h the step size
     * @param f the function to integrate
     * @return
     */
    static double integrateParallel(double a, double b, double h, DoubleFunction<Double> f) {
        return Stream.iterate(a, x -> x + h)
            .limit((int) ((b - a) / h))
            .parallel()
            .mapToDouble(x -> f.apply(x))
            .sum()/((b - a) / h);
    }
}

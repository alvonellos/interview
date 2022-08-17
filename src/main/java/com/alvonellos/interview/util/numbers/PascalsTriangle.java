package com.alvonellos.interview.util.numbers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static com.alvonellos.interview.util.numbers.NumberManipulation.binomial;

public class PascalsTriangle {
    private PascalsTriangle() {
    }

    public static List<List<BigInteger>> pascalsTriangleBinomial(int numRows) {
        List<List<BigInteger>> triangle = new ArrayList<>();
        for (int i = 0; i <= numRows; i++) {
            List<BigInteger> buffer = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                buffer.add(binomial(BigInteger.valueOf(i), BigInteger.valueOf(j)));
            }
            triangle.add(buffer);
        }
        return triangle;
    }
}

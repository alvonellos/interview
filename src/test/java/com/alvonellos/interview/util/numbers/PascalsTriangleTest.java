package com.alvonellos.interview.util.numbers;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static com.alvonellos.interview.util.numbers.PascalsTriangle.pascalsTriangleBinomial;
import static org.junit.jupiter.api.Assertions.*;

class PascalsTriangleTest {

    @Test
    void pascalTest() {
        List<List<BigInteger>> list = new ArrayList<>();
        list = pascalsTriangleBinomial(5);
        System.err.println(list);
        // [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1], [1, 5, 10, 10, 5, 1]]

        val fifthElement = list.get(5);
        assert(fifthElement.toArray()[0].equals(BigInteger.valueOf(1)));
        assert(fifthElement.toArray()[1].equals(BigInteger.valueOf(5)));
        assert(fifthElement.toArray()[2].equals(BigInteger.valueOf(10)));
        assert(fifthElement.toArray()[3].equals(BigInteger.valueOf(10)));
        assert(fifthElement.toArray()[4].equals(BigInteger.valueOf(5)));
        assert(fifthElement.toArray()[5].equals(BigInteger.valueOf(1)));
    }
}
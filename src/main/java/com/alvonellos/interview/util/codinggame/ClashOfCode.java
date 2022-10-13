package com.alvonellos.interview.util.codinggame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClashOfCode {
    public static List<Integer> listAllDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        return divisors;
    }

    public static void decoder(String input) {
        String[] inputs = input.split(" ");

        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int[] encoded = new int[numbers.length];
        Map<Integer, Character> decoder = new HashMap<>(10);
        for (int i = 0; i < numbers.length; i++) {
            encoded[i] = (int) numbers[i] * Character.getNumericValue(numbers[i]);
            decoder.put(encoded[i], numbers[i]);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(decoder.get(Integer.parseInt(inputs[i])));
        }
    }
}

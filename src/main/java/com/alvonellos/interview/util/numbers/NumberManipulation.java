package com.alvonellos.interview.util.numbers;

public class NumberManipulation {
    public static Long randBetween(Long min, Long max) {
        return min + Math.round(Math.random() * (max - min));
    }
}

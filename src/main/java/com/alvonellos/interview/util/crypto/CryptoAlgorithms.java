package com.alvonellos.interview.util.crypto;

import java.math.BigInteger;
import java.security.SecureRandom;

public class CryptoAlgorithms {
    private static final SecureRandom rand = new SecureRandom();

    /**
     * Generate a password of random characters using secure random
     * and a big integer.
     *
     * @param length the length of the password to generate
     * @return
     */
    public static String nextPassword(int length) {
        return new BigInteger(length * 5, rand).toString(32);
    }

    /**
     * Shuffle a string using a secure random number generator.
     *
     * @param input the string to shuffle.
     * @return the string shuffled.
     */
    public static String shuffle(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int randomPos = rand.nextInt(chars.length);
            char temp = chars[i];
            chars[i] = chars[randomPos];
            chars[randomPos] = temp;
        }
        return new String(chars);
    }
}

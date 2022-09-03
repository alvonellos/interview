package com.alvonellos.interview.util.crypto;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;

public class CryptoAlgorithms {
    private CryptoAlgorithms() {
    }
    private static final SecureRandom rand = new SecureRandom();

    /**
     * Decode a message from the given key
     *
     * @param key     the alphabet to use (must be 26*2 characters long)
     * @param message the message to decode
     * @return the decoded message
     */
    public static String decodeMessage(String key, String message) {
        String abcd = "abcdefghijklmnopqrstuvwxyz";
        abcd += abcd.toUpperCase();

        assert (key.length() == 26 * 2);
        assert (message.length() >= 1);

        HashMap<Character, Character> map = new HashMap<>();
        map.put(' ', ' ');
        for (int i = 0; i < key.length(); i++) {
            map.put(key.charAt(i), abcd.charAt(i));
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            sb.append(map.get(message.charAt(i)));
        }

        return sb.toString();
    }

    /**
     * Encode a message with rotational ciphering algorithm
     *
     * @param message the message to encode
     * @return the encoded message
     */
    public static String rotate13Encode(String message) {
        String rot13 = "nopqrstuvwxyzabcdefghijklm";
        rot13 += rot13.toUpperCase();
        return encodeMessage(rot13, message);
    }

    public static String rotate13Decode(String message) {
        String rot13 = "nopqrstuvwxyzabcdefghijklm";
        rot13 += rot13.toUpperCase();
        return decodeMessage(rot13, message);
    }

    /**
     * Encode the given string into a cypher given the key
     *
     * @param key     the alphabet to use for the encoding must be 26*2 chars long
     * @param message the message to encode
     * @return the encoded string
     */
    public static String encodeMessage(String key, String message) {
        String abcd = "abcdefghijklmnopqrstuvwxyz";
        abcd += abcd.toUpperCase();

        assert (key.length() == 26 * 2);
        assert (message.length() >= 1);

        HashMap<Character, Character> map = new HashMap<>();
        map.put(' ', ' ');
        for (int i = 0; i < key.length(); i++) {
            map.put(abcd.charAt(i), key.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {

            sb.append(map.get(message.charAt(i)));
        }

        return sb.toString();
    }

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

    /**
     * Shuffle a string using a secure random number generator.
     *
     * @param input the string to shuffle.
     * @return the string shuffled.
     */
    public static void shuffle(Object[] input) {
        for (int i = 0; i < input.length; i++) {
            int randomPos = rand.nextInt(input.length);
            Object temp = input[i];
            input[i] = input[randomPos];
            input[randomPos] = temp;
        }
    }


    /**
     * Strong password checker that returns number of steps required to
     * meet the password requirements
     *
     * @param s the string to check
     * @return an int that represents the number of steps required to meet the password requirements.
     * https://leetcode.com/problems/strong-password-checker/submissions/
     */
    public static int strongPasswordChecker(String s) {
        final int n = s.length();
        final char[] chars = s.toCharArray();
        final int missing = getMissing(chars);
        // # of replacements to deal with 3 repeating characters
        int replaces = 0;
        // # of seqs that can be substituted with 1 deletions, (3k)-seqs
        int oneSeq = 0;
        // # of seqs that can be substituted with 2 deletions, (3k + 1)-seqs
        int twoSeq = 0;

        for (int i = 2; i < n; )
            if (chars[i] == chars[i - 1] && chars[i - 1] == chars[i - 2]) {
                int length = 2; // length of repeating chars
                while (i < n && chars[i] == chars[i - 1]) {
                    ++length;
                    ++i;
                }
                replaces += length / 3; // 'aaaaaaa' -> 'aaxaaxa'
                if (length % 3 == 0) ++oneSeq;
                if (length % 3 == 1) ++twoSeq;
            } else {
                ++i;
            }

        if (n < 6) return Math.max(6 - n, missing);
        if (n <= 20) return Math.max(replaces, missing);

        final int deletes = n - 20;
        // each replacement in (3k)-seqs can be substituted with 1 deletions
        replaces -= Math.min(oneSeq, deletes);
        // each replacement in (3k + 1)-seqs can be substituted with 2 deletions
        replaces -= Math.min(Math.max(deletes - oneSeq, 0), twoSeq * 2) / 2;
        // each replacement in other seqs can be substituted with 3 deletions
        replaces -= Math.max(deletes - oneSeq - twoSeq * 2, 0) / 3;
        return deletes + Math.max(replaces, missing);
    }

    private static int getMissing(final char[] chars) {
        int missing = 3;

        for (final char c : chars)
            if (Character.isUpperCase(c)) {
                --missing;
                break;
            }

        for (final char c : chars)
            if (Character.isLowerCase(c)) {
                --missing;
                break;
            }

        for (final char c : chars)
            if (Character.isDigit(c)) {
                --missing;
                break;
            }

        return missing;
    }

    public static String sha512(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            StringBuffer hashtext = new StringBuffer(no.toString(16));
            while (hashtext.length() < 32) {
                hashtext.insert(0, '0' + hashtext.toString());
            }
            return hashtext.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

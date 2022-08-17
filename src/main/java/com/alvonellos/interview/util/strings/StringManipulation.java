package com.alvonellos.interview.util.strings;

import java.security.SecureRandom;

public final class StringManipulation {

    public static String removeLastCharacter(String string) {
        return string.substring(0, string.length() - 1);
    }

    public static String removeFirstCharacter(String string) {
        return string.substring(1);
    }

    public static String replaceFirstCharacter(String string, String replacement) {
        return replacement + string.substring(1);
    }

    public static String reverseString(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public static String reverse_recursive(String string) {
        if (string == null) {
            return null;
        }
        if (string.length() <= 1) {
            return string;
        }
        return reverse(string.substring(1)) + string.charAt(0);
        // reverse the string recursively and append the first character at the end
    }

    public static String reverse(String string) {
        if (string == null) {
            return null; // if string is null, return null
        }
        if (string.length() <= 1) { //if string is empty or has only one character, then no reverse
            return string;
        }

        StringBuffer b = new StringBuffer(string); //load string into buffer
        for(int i = 0; i < b.length() / 2; i++) { // declare i as the length of the string divided by 2d to get the middle of the string
            char temp = b.charAt(i); // declare temp as the character at index i
            b.setCharAt(i, b.charAt(b.length() - i - 1)); // set the character at index i to the character at the end of the string minus i minus 1
            b.setCharAt(b.length() - i - 1, temp); // set the character at the end of the string minus i minus 1 to temp
        }
        return b.toString(); // return the string buffer as a string
    }

    /**
     * Checks if the given string is palindromic using a recursive method
     * @param word
     * @return
     */
    public static boolean palindrome_recursive(String word) {
        if (word == null)       return false;
        if (word.length() == 1) return true;
        if (word.length() == 2) return word.charAt(0) == word.charAt(1);

        return word.charAt(word.length() - 1) == word.charAt(0) == palindrome_recursive(word.substring(1, word.length() - 1));
    }

    /**
     * Checks if the given string is palindromic using an iterative method
     * @param word
     * @return
     */
    public static boolean palindrome(String word) {

        StringBuffer buffer = new StringBuffer(word);
        while(buffer.length() > 1) {
            System.err.println(buffer);
            if (buffer.length() == 1) return true;
            if (buffer.length() == 2) return buffer.charAt(0) == buffer.charAt(1);
            if (buffer.charAt(0) != buffer.charAt(buffer.length() - 1))
                return false;

            buffer.deleteCharAt(0);
            buffer.deleteCharAt(buffer.length() - 1);
        }
        return true;
    }

    /**
     * Checks if the given string contains vowels using regular expressions
     * @param input the string to check
     * @return a boolean indicating if it contains vowels or not
     */
    public static boolean stringContainsVowels(String input) {
        return input.toLowerCase().matches(".*[aeiou].*");
    }
}

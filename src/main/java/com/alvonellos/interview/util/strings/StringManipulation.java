package com.alvonellos.interview.util.strings;

import lombok.val;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

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


    /**
     * Finds the length of the longest substring without repeating characters
     * using the sliding window algorithm.
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        // Base condition
        if (s == null || s.equals("")) {
            return 0;
        }
        // Starting window index
        int start = 0;
        // Ending window index
        int end = 0;
        // Maximum length of substring
        int maxLength = 0;
        // This set will store the unique characters
        Set<Character> uniqueCharacters = new HashSet<>(256);
        // Loop for each character in the string
        while (end < s.length()) {
            if (uniqueCharacters.add(s.charAt(end))) {
                end++;
                maxLength = Math.max(maxLength, uniqueCharacters.size());
            } else {
                uniqueCharacters.remove(s.charAt(start));
                start++;
            }
        }
        return maxLength;
    }
    /**
     * Returns the length of the longest substring without repeating characters using brute force
     * @param s the string to check against
     * @return an int representing the length of the longest substring without repeating characters
     * NOTE: https://leetcode.com/problems/longest-substring-without-repeating-characters/
     */
    public static int lengthOfLongestSubstringBF(String s) {
        if (s == null) return 0; // if string is null, return 0
        if (s.length() == 1) return 1; // if the strong contains only one character, return 1
        // if the string contains only two characters, return 2 if the first character is not the same as the second character
        if (s.length() == 2) return s.charAt(0) == s.charAt(1) ? 1 : 2;

        // get all distinct combinations of the string
        return subStrings(s)
                .stream()
                .distinct()
                .filter(substring -> stringContainsUniqueCharacters(substring))
                .mapToInt(substring -> substring.length())
                .max()
                .getAsInt();
    }
        // remove all strings that contain duplicate characters and return the longest one

    /**
     * Checks if the given string contains all unique characters.
     * @param input the string to check
     */
    public static boolean stringContainsUniqueCharacters(String input) {
        if (input == null) return false;
        if (input.length() == 1) return true;
        if (input.length() == 2) return input.charAt(0) != input.charAt(1);

        char[] chars = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>(chars.length);
        for (char c : chars) {
            if (map.containsKey(c)) {
                return false;
            }
            map.put(c, 1);
        }
        return true;
    }

    /**
     * Generate all valid substrings of a given string using brute force
     * @param str the string to check against
     * NOTE: O(N^3) :( - this is not the best solution
     */
    public static List<String> subStrings(String str) {
        StringBuilder sb = new StringBuilder();
        List<String> substrings = new ArrayList<>();
        // Pick starting point
        for (int len = 1; len <= str.length(); len++) {
            // Pick ending point
            for (int i = 0; i <= str.length() - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    sb.append(str.charAt(k));
                }
                substrings.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return substrings;
    }
}

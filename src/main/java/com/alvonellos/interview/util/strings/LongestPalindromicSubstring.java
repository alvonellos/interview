package com.alvonellos.interview.util.strings;

/**
 * Naive implementation of longest palindromic substring algorithm.
 */
public class LongestPalindromicSubstring {

    /**
     * Checks whether the word is a palindromic substring.
     * @param word the word to check against
     * @return
     */
    static boolean isPalindrome(String word) {
        // check whether the word's starting character is equal to the word's ending character.
        if (!word.startsWith(String.valueOf(word.charAt(word.length() - 1)))) {
            return false;
        }

        int i = 0;
        int j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * Returns the longest palindromic substring of the given string
     * This method is the naive implementation of the algorithm, and
     * should not be used in production.
     * @param word
     * @return
     */
    public static String longestPalindrome(String word) {
        String longest = "";
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {
                String sub = word.substring(i, j);
                if (isPalindrome(sub) && sub.length() > longest.length()) {
                    longest = sub;
                }
            }
        }
        return longest;
    }
}

package com.alvonellos.interview.util.strings;

import java.util.Stack;

public class LongestValidParenthesis {

    /**
     * Find the longest valid parenthesis using dynamic programming.
     * @param s the string representation to parse
     * @return
     */
    public static int longestValidParenthesesDP(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    /**
     * Checks whether the given string contains a valid number of parenthesis.
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    /**
     * Calculates the longest valid parenthesis using brute force algorithm
     * @param s
     * @return
     */
    public static int longestValidParenthesesBF(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j+=2) {
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }

    /**
     * Calculates longest valid parenthesis using a stack
     * @param s
     * @return the number of the longest valid parenthesis
     * NOTE: this method is my favorite method
     */
    public static int longestValidParenthesesStack(String s) {
        int maxans = 0; // max stack length
        Stack<Integer> stack = new Stack<>(); // stack
        stack.push(-1); // push to end of stack
        for (int i = 0; i < s.length(); i++) { // loop through the string
            if (s.charAt(i) == '(') { // if we see a ( then push it
                stack.push(i); // push it real good
            } else {
                stack.pop(); // otherwise, just pop it.
                if (stack.empty()) { //if the stack is empty, then push it back
                    stack.push(i); // push it back
                } else {
                    // max answer is the maximum of itself or the index of the array minus the current index
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

}

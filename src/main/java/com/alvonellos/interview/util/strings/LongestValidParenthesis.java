package com.alvonellos.interview.util.strings;

public class LongestValidParenthesis {
    public static int longestValidParentheses(String s) {
        int max = 0;
        int[] stack = new int[s.length()];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                top++;
                stack[top] = i;
            } else {
                if (top == -1) {
                    stack[++top] = i;
                } else {
                    if (s.charAt(stack[top]) == '(') {
                        top--;
                        if (top == -1) {
                            max = Math.max(max, i - stack[top]);
                        } else {
                            max = Math.max(max, i - stack[top]);
                        }
                    } else {
                        stack[++top] = i;
                    }
                }
            }
        }
        return max;
    }
}

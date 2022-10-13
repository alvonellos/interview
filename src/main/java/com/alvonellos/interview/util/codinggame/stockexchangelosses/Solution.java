package com.alvonellos.interview.util.codinggame.stockexchangelosses;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static boolean bracketsExtemeEdition(String expression) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < expression.length(); i++) {
            char x = expression.charAt(i);
            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
        return (stack.isEmpty());
    }

    public static boolean carmichaelNumber(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        for (int i = 2; i < n; i++) {
            if (Math.pow(i, n - 1) % n != 1) {
                return false;
            }
        }
        return true;
    }

    public static String runLengthEncoding(String s) {
        int n = s.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            res += s.charAt(i);
            res += count;
        }
        return res;
    }
}
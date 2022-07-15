package com.alvonellos.interview.util;

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
    }

    public static String reverse(String string) {
        if (string == null) {
            return null;
        }
        if (string.length() <= 1) {
            return string;
        }

        StringBuffer b = new StringBuffer(string);
        for(int i = 0; i < b.length() / 2; i++) {
            char temp = b.charAt(i);
            b.setCharAt(i, b.charAt(b.length() - i - 1));
            b.setCharAt(b.length() - i - 1, temp);
        }
        return b.toString();
    }

}

package com.alvonellos.interview.util.strings;

public class LongestCommonPrefix {

    /**
     * Given an array of strings, find the longest common prefix.
     * @param strs an array of strings
     * @return the longest common prefix
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}

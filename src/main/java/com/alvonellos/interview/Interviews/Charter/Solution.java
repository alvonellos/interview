package com.alvonellos.interview.Interviews.Charter;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;

public class Solution {
    /**
     * Given a string, find the first non-repeating character in it.
     * For example, if the input string is “teeksforteeks”,
     * then the output should be ‘f’ and if the input string is “GeeksQuiz”, then the output should be ‘G’
     */
    public static String findFirstNonRepeatingCharacter(String s) {
        if (s == null || s.length() == 0) { //if the string is empty or null
            return "";
        } else if (s.length() == 1) { //if the length is one then return the string
            return s;
        } else { // the string is greater than one, so we have to work on the two possibilities

            //analyze the string into two datastructures. One is a bitset and the other is a hashset
            HashSet<Character> set = new HashSet<Character>();
            //why did I use a bitset?
            // this algorithm is O(n)
            BitSet bitSet = new BitSet(s.length());
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i)) || s.indexOf(s.charAt(i))!= s.lastIndexOf(s.charAt(i))) {
                    bitSet.set(i);
                } else {
                    set.add(s.charAt(i));
                }
            }

            // iterate through the bitset and find the first non-duplicated character
            for (int i = 0; i < s.length(); i++) {
                if (!bitSet.get(i)) {
                    return String.valueOf(s.charAt(i));
                }
            }
            BitSet duplicated = new BitSet(s.length());
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i)) || s.indexOf(s.charAt(i)) != s.lastIndexOf(s.charAt(i))) {
                    duplicated.set(i);
                } else {
                    set.add(s.charAt(i));
                }
            }

            // iterate through the bitset and find the first non-duplicated character
            for (int i = 0; i < s.length(); i++) {
                if (!duplicated.get(i)) {
                    return String.valueOf(s.charAt(i));
                }
            }
            return ""; //if no non-repeating character is found, return empty string
        }
    }

    public static String findFirstNonRepeatingCharacterShorterSolution(String s) {
        StringBuffer sb = new StringBuffer("");
        if (s == null || s.length() == 0) { //if the string is empty or null
            return "";
        } else if (s.length() == 1) { //if the length is one then return the string
            return s;
        } else { // the string is greater than one, so we have to work on the two possibilities
            for (int i = 0; i < s.length(); i++) {
                if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        assert("f".equals(findFirstNonRepeatingCharacter("teeksforteeks")));
        assert("G".equals(findFirstNonRepeatingCharacter("GeeksQuiz")));
        assert("".equals(findFirstNonRepeatingCharacter("aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz")));


        assert("f".equals(findFirstNonRepeatingCharacterShorterSolution("teeksforteeks")));
        assert("G".equals(findFirstNonRepeatingCharacterShorterSolution("GeeksQuiz")));
        assert("".equals(findFirstNonRepeatingCharacterShorterSolution("aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz")));
    }
}

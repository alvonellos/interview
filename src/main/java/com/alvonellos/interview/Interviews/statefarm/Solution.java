package com.alvonellos.interview.Interviews.statefarm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static String func(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) {
            return s+"1";
        }
        char charArray[] = s.toCharArray();
        Arrays.sort(charArray);
        s = new String(charArray);
        Map <String, Integer> treeMap = new HashMap<>();
        for(String a: s.split("")) {
            if(treeMap.containsKey(a)) {
                treeMap.put(a, treeMap.get(a) + 1);
            } else {
                treeMap.put(a, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        treeMap.forEach((k, v) -> {sb.append(k).append(treeMap.get(k));});
        return sb.toString();
    }
    public static void main(String[] args) {

        assert(func("helloo").equals("e1h1l2o1"));
        System.err.println(func("helloo"));
    }
}

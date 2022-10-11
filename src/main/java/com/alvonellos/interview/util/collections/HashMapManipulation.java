package com.alvonellos.interview.util.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class HashMapManipulation {
    public static <K, V> Map<K, V> mergeTwoMaps(HashMap<K, V> m1, HashMap<K, V> m2) {
        Map<K, V> mergedMap = new HashMap<K, V>();
        mergedMap.putAll(m1);
        mergedMap.putAll(m2);
        return mergedMap;
    }

    public static <K, V> Map<K, V> mergeNHashMaps(HashMap<K, V>... maps) {
        Map<K, V> mergedMap = new HashMap<K, V>();
        Arrays.stream(maps).forEach((HashMap<K, V> map) -> mergedMap.putAll(map));
        return mergedMap;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        // add key-value pair to HashMap
        map.put("key1", "value1"); //1
        map.put("key2", "value2"); //2
        map.put("key3", "value3"); //3
        map.put("key4", "value4"); //4

        //add some tricky ones
        map.put(null, null); //5
        map.put("key5", null); //6
        map.put(null, "value5"); //what will the result be, let's find out

        for (String key : map.keySet()) {
            System.out.println("Key: " + key + " Value: " + map.get(key));
        }

        assert (map.get(null) == "value5"); //showing that null key is allowed
        assert (map.get("key5") == null); //showing that null value is allowed
        assert (map.get("key1") == "value1"); //showing that normal key-value pair is allowed
        assert (map.size() == 6); //showing that duplicate key is not allowed

        HashSet<String> set = new HashSet<String>();
        set.add("key1"); // 1
        set.add("key2"); // 2
        set.add("key3"); // 3
        set.add("key4"); // 4
        set.add(null);   // 5
        set.add("key5"); // 6
        set.add("key5"); //should not be added

        assert (set.contains("key1")); //showing that normal key is allowed
        assert (set.contains(null)); //showing that null key is allowed
        assert (set.size() == 6); //showing that duplicate key is not allowed


        //initialize the hashmap
        HashMap<Integer, Integer>[] maps = Stream.iterate(0, i -> i + 1)
                .limit(10)
                .map(j -> {
                    HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
                    map1.put(j, j * 2);
                    return map1;
                })
                .toArray(HashMap[]::new);
        //merge the hashmap
        Map<Integer, Integer> mergedMap = mergeNHashMaps(maps);
        System.out.println(mergedMap);
        assert (mergedMap.size() == 10);

        // so what's the difference between HashMap and HashSet?
        // HashSet is a set of unique keys, HashMap is a set of unique key-value pairs
        // can a hashmap contain null key? yes
        // can a hashmap contain null value? yes
        // can a hashmap contain duplicate key? no
        // can a hashmap contain duplicate value? yes

        //
    }
}

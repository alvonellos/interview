package com.alvonellos.interview.util.collections;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ListManipulation<T extends Comparable<T>> {
    public void removeDuplicates(List<T> list) {
        HashSet<T> set = new HashSet<T>(list);
        list.clear();
        list.addAll(set);
    }

    public void removeDuplicatesAlgorithm(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) == 0) {
                    list.remove(j);
                    j--;
                }
            }
        }
    }

    public List<T> removeDuplicatesStreams(List<T> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }
}

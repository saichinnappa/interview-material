package com.interview.affirm.oa;

import java.util.*;

public class MostFrequentLetters {
    public static void main(String[] args) {
        String[] strs = {"abc", "bcd", "cde"};
        getMaxNeighbor(strs);
    }

    public static void getMaxNeighbor(String[] strs) {
        Map<Character, Map<Character, Integer>> map = new HashMap<>();

        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                map.putIfAbsent(str.charAt(i), new HashMap<>());
                Map<Character, Integer> neighbors = map.get(str.charAt(i));
                for (int j = 0; j < str.length(); j++) {
                    if (i == j)
                        continue;
                    neighbors.put(str.charAt(j), neighbors.getOrDefault(str.charAt(j), 0) + 1);
                }
            }
        }

        Map<Character, Set<Character>> result = new HashMap<>();
        for (Character c : map.keySet()) {
            List<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.get(c).entrySet());
            Collections.sort(entries, (a, b) -> b.getValue() - a.getValue());

            result.putIfAbsent(c, new HashSet<>());
            int occ = entries.get(0).getValue();
            for (Map.Entry<Character, Integer> entry : entries) {
                if (entry.getValue() == occ)
                    result.get(c).add(entry.getKey());
            }
        }
        System.out.println(result);
    }
}
package com.interview.affirm.oa;

import java.util.*;

public class MostFrequentLetters {
    public static void main(String[] args) {
        String[] strs = {"abc", "bcd", "cde"};
        getMaxNeighbor(strs);
    }

    public static void getMaxNeighbor(String[] strs) {
        Map<Character, Map<Character, Integer>> map = new HashMap<>();
        for (String s : strs) {
            for (int i = 0; i < s.length(); i++) {
                map.putIfAbsent(s.charAt(i), new HashMap<>());
                Map<Character, Integer> countMap = map.get(s.charAt(i));
                for (int j = 0; j < s.length(); j++) {
                    if (i == j) continue;
                    countMap.put(s.charAt(j), countMap.getOrDefault(s.charAt(j), 0) + 1);
                }
            }
        }

        Map<Character, Set<Character>> result = new HashMap<>();
        for (Map.Entry<Character, Map<Character, Integer>> entry : map.entrySet()) {
            List<Map.Entry<Character, Integer>> x = new ArrayList<>(entry.getValue().entrySet());
            Collections.sort(x, (a, b) -> b.getValue() - a.getValue());
            result.put(entry.getKey(), new HashSet<>());
            int most = x.get(0).getValue();
            for (Map.Entry<Character, Integer> y : x) {
                if (y.getValue() == most) {
                    result.get(entry.getKey()).add(y.getKey());
                }
            }
        }

        System.out.println(result);


    }
}
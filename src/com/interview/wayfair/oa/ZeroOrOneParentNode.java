package com.interview.wayfair.oa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The input is int[][] input, input[0] is the parent of input[1], such as {{1,4}, {1,5}, {2,5}, {3,6}, {6, 7}} will form the above graph
 * The first question is a node with only 0 parents and only 1 parent
 */
public class ZeroOrOneParentNode {
    public static void main(String[] args) {
        int[][] graph = {{1, 4}, {1, 5}, {2, 5}, {3, 6}, {6, 7}};
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : graph) {
            //Adding child -> parent
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[1]).add(edge[0]);
            //Adding parent
            map.putIfAbsent(edge[0], new HashSet<>());
        }

        Map<Integer, Set<Integer>> resultMap = new HashMap<>();
        resultMap.put(0, new HashSet<>());
        resultMap.put(1, new HashSet<>());

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 0)
                resultMap.get(0).add(entry.getKey());
            else if (entry.getValue().size() == 1)
                resultMap.get(1).add(entry.getKey());
        }

        resultMap.forEach((k, v) -> System.out.println(k + " -> " + v));


    }
}

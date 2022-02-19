package com.interview.wayfair.oa;

import java.util.*;

public class CommonAncestorOfTwoNodes {
    public static void main(String[] args) {
        int[][] graph = {{1, 4}, {1, 5}, {2, 5}, {3, 6}, {6, 7}};
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : graph) {
            //Adding child -> parent
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[1]).add(edge[0]);
        }

        Set<Integer> s1 = findAncestors(map, 7);
        Set<Integer> s2 = findAncestors(map, 5);
        for (int i : s1) {
            if (s2.contains(i)) {
                System.out.println("Common Ancestor: " + i);
            }
        }


    }

    static Set<Integer> findAncestors(Map<Integer, Set<Integer>> map, int x) {
        Set<Integer> result = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(x);
        while (!stack.isEmpty()) {
            Set<Integer> parents = map.get(stack.pop());
            if (parents == null || parents.size() == 0)
                continue;
            for (int parent : parents) {
                result.add(parent);
                stack.push(parent);
            }
        }
        return result;
    }

}

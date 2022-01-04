package com.practice.leetcode.graphs.dfs;

import java.util.*;

public class StackApproach {

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {3, 4}, {3, 5}};
        traverse(edges, 6);
    }

    private static void traverse(int[][] edges, int totalVertices) {

        Map<Integer, List<Integer>> vertexMap = new HashMap<>();

        for (int i = 0; i < totalVertices; i++) {
            vertexMap.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            vertexMap.get(edge[0]).add(edge[1]);
            vertexMap.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> vertexTracker = new Stack<>();
        boolean[] isVisited = new boolean[totalVertices];
        StringBuilder result = new StringBuilder();

        vertexTracker.push(0);
        isVisited[0] = true;

        while (!vertexTracker.isEmpty()) {
            int topElement = vertexTracker.pop();
            result.append(topElement);
            List<Integer> neighbors = vertexMap.get(topElement);
            for (int neighbor : neighbors) {
                if (!isVisited[neighbor]) {
                    isVisited[neighbor] = true;
                    vertexTracker.push(neighbor);
                }
            }

        }
        System.out.println(result);
    }


}

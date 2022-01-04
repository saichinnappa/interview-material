package com.practice.leetcode.graphs.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recursive {

    static StringBuilder result = new StringBuilder();
    static boolean[] isVisited;
    static int totalVertices = 0;

    public static void main(String[] args) {
//        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        totalVertices = 6;
        int source = 0;
        isVisited = new boolean[totalVertices];
        traverse(edges, source);
    }

    private static void traverse(int[][] edges, int source) {

        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        for (int i = 0; i < totalVertices; i++)
            adjacencyList.put(i, new ArrayList<>());

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
//            adjacencyList.get(edge[1]).add(edge[0]);
        }

        dfs(1, adjacencyList);
        System.out.println(result);
    }

    private static void dfs(int source, Map<Integer, List<Integer>> edges) {

        isVisited[source] = true;
        result.append(source);
        if (source == totalVertices - 1)
            return;

        for (Integer vertex : edges.get(source)) {
            if (!isVisited[vertex])
                dfs(vertex, edges);
            else
                System.out.println("visited edge: [" + source + ", " + vertex + "]");

        }

    }
}

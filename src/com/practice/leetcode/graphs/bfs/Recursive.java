package com.practice.leetcode.graphs.bfs;

import java.util.ArrayList;
import java.util.List;

public class Recursive {
    static int totalVertices = 0;
    static boolean[] isVisited;
    static StringBuilder result = new StringBuilder();
    static List<Integer> vertexTrackerList = new ArrayList<>();
    static int i = 0;

    public static void main(String[] args) {
        totalVertices = 8;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {3, 4}, {3, 5}, {2, 6}, {2, 7}};
        isVisited = new boolean[totalVertices];
        traverse(edges, 0);
        System.out.println(result);
    }

    private static void traverse(int[][] edges, int source) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
//        for (int i = 0; i < totalVertices; i++) {
//            adjacencyList.add(i, new ArrayList<>());
//        }
        adjacencyList.forEach(i -> new ArrayList<>());

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        vertexTrackerList.add(source);
        bfs(source, adjacencyList);

    }

    private static void bfs(int source, List<List<Integer>> adjacencyList) {
        i++;
        isVisited[source] = true;
        result.append(source);
        if (i == totalVertices)
            return;

        for (int i = 0; i < adjacencyList.get(source).size(); i++) {
            int vertex = adjacencyList.get(source).get(i);
            if (!isVisited[vertex])
                vertexTrackerList.add(vertex);
        }
        bfs(vertexTrackerList.get(i), adjacencyList);

    }
}

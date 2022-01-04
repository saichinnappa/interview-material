package com.practice.leetcode.graphs.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class QueueApproach {

    static int totalVertices = 0;
    static boolean[] isVisited;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        totalVertices = 8;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {3, 4}, {3, 5}, {2, 6}, {2, 7}};
        isVisited = new boolean[totalVertices];
        traverse(edges, 0);
        System.out.println(result);
    }

    private static void traverse(int[][] edges, int source) {

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < totalVertices; i++) {
            adjacencyList.add(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        isVisited[source] = true;

        while (!queue.isEmpty()) {
            int firstElement = queue.remove();
            result.append(firstElement);
            for (int i = 0; i < adjacencyList.get(firstElement).size(); i++) {
                int nextElement = adjacencyList.get(firstElement).get(i);
                if (!isVisited[nextElement]) {
                    isVisited[nextElement] = true;
                    queue.add(nextElement);
                }
            }
        }
    }


}

package com.practice.leetcode.graphs;

public class DetectCycle {

    public static void main(String[] args) {
        int[][] graph = {{0, 1}, {1, 2}, {2, 3}};
        boolean[] isVisited = new boolean[graph.length + 1];
        isVisited[graph[0][0]] = true;
        for (int[] edge : graph) {
            if (!isVisited[edge[1]])
                isVisited[edge[1]] = true;
            else {
                System.out.println("Cycle detected!");
                break;
            }
        }

    }
}

package com.practice.leetcode.graphs.dfs;

import java.util.ArrayList;
import java.util.List;

public class AllPaths {

    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        int target = graph.length - 1;
        int source = 0;
        allPathsSourceTarget(source, target, new ArrayList<>(), graph);
        result.forEach(System.out::println);
    }

    private static void allPathsSourceTarget(int source, int target, List<Integer> path, int[][] graph) {
        path.add(source);
        if (source == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int edge : graph[source]) {
            allPathsSourceTarget(edge, target, path, graph);
            path.remove(path.size() - 1);
        }
    }
}

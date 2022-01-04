package com.practice.leetcode.graphs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPaths {

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        allPathsSourceTarget(graph);
    }

    private static void allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        path.add(0);
        queue.add(path);

        while (!queue.isEmpty()) {
            List<Integer> currentPath = queue.poll();
            int currentNode = currentPath.get(currentPath.size() - 1);
            for (int nextNode : graph[currentNode]) {
                List<Integer> tempPath = new ArrayList<>(currentPath);
                tempPath.add(nextNode);
                if (nextNode == graph.length - 1)
                    result.add(tempPath);
                else
                    queue.add(tempPath);
            }
        }
        result.forEach(System.out::println);

    }


}
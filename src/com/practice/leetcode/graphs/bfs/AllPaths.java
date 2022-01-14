package com.practice.leetcode.graphs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPaths {

    public static void main(String[] args) {


//        int[][] graph = {{1, 2}, {3}, {3}, {}};
//        allPathsSourceTarget(graph);
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        allPathsSourceTarget1(graph);
    }

    private static void allPathsSourceTarget1(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        int dest = graph.length - 1;
        queue.offer(0);
        List<Integer> path = new ArrayList<>();
        while (!queue.isEmpty()) {
            int first = queue.removeLast();
            path.add(first);
            if (first == dest) {
                result.add(new ArrayList<>(path));
                path = new ArrayList<>();
                path.add(0);
            }
            int[] edges = graph[first];
            for (int e : edges)
                queue.offer(e);
        }
        for (List<Integer> r : result)
            System.out.println(r);
    }


//    private static void allPathsSourceTarget(int[][] graph) {
//
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> path = new ArrayList<>();
//        Queue<List<Integer>> queue = new LinkedList<>();
//        path.add(0);
//        queue.add(path);
//
//        while (!queue.isEmpty()) {
//            List<Integer> currentPath = queue.poll();
//            int currentNode = currentPath.get(currentPath.size() - 1);
//            for (int nextNode : graph[currentNode]) {
//                List<Integer> tempPath = new ArrayList<>(currentPath);
//                tempPath.add(nextNode);
//                if (nextNode == graph.length - 1)
//                    result.add(tempPath);
//                else
//                    queue.add(tempPath);
//            }
//        }
//        result.forEach(System.out::println);
//
//    }


}
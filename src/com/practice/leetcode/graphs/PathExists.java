package com.practice.leetcode.graphs;

import java.util.*;

public class PathExists {

    static boolean isValid = false;
    static int[][] graph;
    private static boolean[] isVisited;

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        int start = 0, end = 2;
        System.out.println(validPath(n, edges, start, end));
        System.out.println(validPathUsingDFSStack(n, edges, start, end));
        System.out.println(validPathUsingDFSBacktrack(n, edges, start, end));
    }

    public static boolean validPath(int n, int[][] edges, int start, int end) {

        if (start > n - 1 || end > n - 1)
            return false;

        DisjointSet disjointSet = new DisjointSet(n);
        for (int[] edge : edges) {
            disjointSet.union(edge[0], edge[1]);
        }

        return disjointSet.isConnected(start, end);
//        return false;

    }

    public static boolean validPathUsingDFSStack(int n, int[][] edges, int start, int end) {
        Map<Integer, List<Integer>> nodeMap = new HashMap<>();
        boolean[] isVisited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        //initializing adjacency list i.e. graph model
        for (int i = 0; i < n; i++) {
            nodeMap.put(i, new ArrayList<>());
        }

        //building adjacency list
        for (int[] edge : edges) {
            nodeMap.get(edge[0]).add(edge[1]);
            nodeMap.get(edge[1]).add(edge[0]);
        }

        isVisited[start] = true;
        stack.push(start);
        while (!stack.isEmpty()) {
            int val = stack.pop();
            if (val == end)
                return true;
            for (int i = 0; i < nodeMap.get(val).size(); i++) {
                int node = nodeMap.get(val).get(i);
                if (!isVisited[node]) {
                    stack.push(node);
                    isVisited[node] = true;
                }
            }
        }
        return false;
    }

    public static boolean validPathUsingDFSBacktrack(int n, int[][] edges, int start, int end) {
        Map<Integer, List<Integer>> nodeMap = new HashMap<>();
        isVisited = new boolean[n];

        //initializing adjacency list i.e. graph model
        for (int i = 0; i < n; i++) {
            nodeMap.put(i, new ArrayList<>());
        }

        //building adjacency list
        for (int[] edge : edges) {
            nodeMap.get(edge[0]).add(edge[1]);
            nodeMap.get(edge[1]).add(edge[0]);
        }
        isVisited[start] = true;
        backtrack(start, nodeMap.get(start), end, nodeMap);
        return isValid;
    }

    private static void backtrack(int start, List<Integer> paths, int end, Map<Integer, List<Integer>> nodeMap) {

        isVisited[start] = true;

        if (start == end) {
            isValid = true;
            return;
        }

        for (Integer path : paths) {
            if (!isVisited[path]) {
                backtrack(path, nodeMap.get(path), end, nodeMap);
            }
        }
    }


}


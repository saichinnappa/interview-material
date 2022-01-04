package com.practice.leetcode.graphs;

import java.util.*;

public class NetworkDelayTimeDijkstras {

    static int result = 0;

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        networkDelayTime(times, 4, 2);
    }

    public static int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            if (!graph.containsKey(time[0]))
                graph.put(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((d1, d2) -> d1[0] - d2[0]);
        priorityQueue.add(new int[]{0, k});

        Map<Integer, Integer> visited = new HashMap<>();

        while (!priorityQueue.isEmpty()) {

            int[] firstElement = priorityQueue.poll();
            int distance = firstElement[0];
            int currentNode = firstElement[1];
            if (visited.containsKey(currentNode)) continue;
            visited.put(currentNode, distance);
            if (graph.containsKey(currentNode)) {
                for (int[] nextNode : graph.get(currentNode)) {
                    int d = nextNode[1];
                    int node = nextNode[0];
                    if (!visited.containsKey(node)) {
                        priorityQueue.offer(new int[]{distance + d, node});
                    }
                }
            }
        }

        if (visited.size() != n) return -1;

        visited.forEach((k1, v) -> System.out.println(k1 + " " + v));


        for (int val : visited.values()) {
            result = Math.max(val, result);
        }
        return result;
    }
}

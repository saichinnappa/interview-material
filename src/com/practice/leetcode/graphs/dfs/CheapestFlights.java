package com.practice.leetcode.graphs.dfs;

import java.util.*;

public class CheapestFlights {

    public static void main(String[] args) {
        int n = 3;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dest = 2, k = 1;
        caclculateCheapestPath(flights, src, dest, n, k);
    }

    private static void caclculateCheapestPath(int[][] flights, int src, int dest, int n, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            if (!graph.containsKey(flight[0]))
                graph.put(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

//        Map<Integer, Integer> resultMap = new HashMap<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> ((a[0] - b[0])));
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{0, 0, 0});
        int finalPrice = 0;

        int finalStops = 0;
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int source = top[0];
            int stops = top[1];
            int price = top[2];
//            if (source == dest && stops <= k) {
//                priorityQueue.offer(new int[]{stops, price});
//                stops = 0;
//                price = 0;
//            } else if (stops > k) {
//                stops = 0;
//                price = 0;
//            }
            if (graph.containsKey(source)) {
                List<int[]> edges = graph.get(source);
                for (int[] edge : edges) {
                    if (edge[0] == dest) {
                        priorityQueue.offer(new int[]{finalStops, finalPrice + edge[1]});
                        finalPrice = 0;
                        finalStops = 0;
                    } else
                        priorityQueue.offer(new int[]{finalStops++, finalPrice + edge[1]});
                }
            }
        }

        priorityQueue.forEach(i -> System.out.println(i[0] + " " + i[1]));

    }
}

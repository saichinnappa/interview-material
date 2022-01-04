package com.practice.leetcode.graphs;


import java.util.Arrays;
import java.util.PriorityQueue;

public class ConnectAllPointsKruskal {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(minCostConnectPoints(points));
    }

    private static int minCostConnectPoints(int[][] points) {

        PriorityQueue<Edge> queue = new PriorityQueue<>((vertexOne, vertexTwo) -> vertexOne.cost - vertexTwo.cost);
        int maxEdges = points.length - 1;
        int totalCost = 0;
        UnionFindKruskal unionFindKruskal = new UnionFindKruskal(points.length);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                Edge edge = new Edge(i, j, cost);
                queue.add(edge);
            }
        }
        int edgesCount = 0;
        while (!queue.isEmpty()) {
            Edge firstElement = queue.poll();
            int v1 = firstElement.vertexOne;
            int v2 = firstElement.vertexTwo;

            if (edgesCount != maxEdges) {
                if (!unionFindKruskal.isConnected(v1, v2)) {
                    unionFindKruskal.union(v1, v2);
                    totalCost += firstElement.cost;
                    edgesCount++;
                }
            } else {
                return totalCost;
            }
        }
        return totalCost;
    }
}

class UnionFindKruskal {
    int root[];
    int rank[];

    UnionFindKruskal(int size) {
        root = new int[size];
        rank = new int[size];
        Arrays.setAll(root, i -> i);
        Arrays.fill(rank, 1);
    }

    int find(int x) {
        if (x == root[x])
            return x;
        return root[x] = find(root[x]);
    }

    void union(int node1, int node2) {
        int rootX = find(node1);
        int rootY = find(node2);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY])
                root[rootY] = rootX;
            else if (rank[rootX] < rank[rootY])
                root[rootX] = rootY;
            else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }
}

class Edge {
    int vertexOne;
    int vertexTwo;
    int cost;

    Edge(int vertexOne, int vertexTwo, int cost) {
        this.vertexOne = vertexOne;
        this.vertexTwo = vertexTwo;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "vertexOne=" + vertexOne +
                ", vertexTwo=" + vertexTwo +
                ", cost=" + cost +
                '}';
    }
}

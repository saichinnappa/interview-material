package com.practice.leetcode.graphs;

import java.util.Arrays;

public class DisjointSet {

    int[] root;
    int[] rank;
    int size;

    DisjointSet(int size) {
        root = new int[size];
        rank = new int[size];
        this.size = size;
        Arrays.setAll(root, i -> i);
        Arrays.fill(rank, 1);
    }

    int find(int node) {
        if (node == root[node])
            return node;
        return root[node] = find(root[node]);
    }

    void union(int nodeX, int nodeY) {
        int rootX = find(nodeX);
        int rootY = find(nodeY);
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
//        Arrays.stream(rank).forEach(System.out::print);
//        System.out.println();
    }

    boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }
}

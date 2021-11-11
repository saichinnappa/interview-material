package com.practice.leetcode.graphs;

import java.util.Arrays;

public class UnionByRank {

    int[] elements;
    int[] ranks;

    UnionByRank(int size) {
        elements = new int[size];
        ranks = new int[size];
        Arrays.setAll(elements, i -> i);
        Arrays.fill(ranks, 1);
    }

    public static void main(String[] args) throws Exception {
        UnionByRank uf = new UnionByRank(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }

    int find(int node) {
        while (node != elements[node]) {
            node = elements[node];
        }
        return node;
    }

    void union(int node1, int node2) {
        int rootOne = find(node1);
        int rootTwo = find(node2);
        if (rootOne != rootTwo) {
            if (ranks[rootOne] > ranks[rootTwo])
                elements[rootTwo] = rootOne;
            else if (ranks[rootOne] < ranks[rootTwo])
                elements[rootOne] = rootTwo;
            else {
                elements[rootTwo] = rootOne;
                ranks[rootOne]++;
            }
        }
    }

    boolean connected(int node1, int node2) {
        return find(node1) == find(node2);
    }

}

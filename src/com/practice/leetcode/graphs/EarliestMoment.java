package com.practice.leetcode.graphs;

import java.util.Arrays;

public class EarliestMoment {

    public static void main(String[] args) {
//        int[][] input = {{20190101, 0, 1}, {20190104, 3, 4}, {20190107, 2, 3}, {20190211, 1, 5}, {20190224, 2, 4}, {20190301, 0, 3}, {20190312, 1, 2}, {20190322, 4, 5}};
//        int[][] input = {{0, 2, 0}, {1, 0, 1}, {3, 0, 3}, {4, 1, 2}, {7, 3, 1}};
        int[][] input = {{9, 3, 0}, {0, 2, 1}, {8, 0, 1}, {1, 3, 2}, {2, 2, 0}, {3, 3, 1}};
        int n = 4;
        System.out.println(earliestAcq(input, n));
    }

    public static int earliestAcq(int[][] logs, int n) {

        int result = -1;
        UnionFind uf = new UnionFind(n);

        for (int[] log : logs) {
            int count = uf.union(log[1], log[2]);
            if (count == n) {
                return log[0];
            }
        }

        return -1;
    }

    static class UnionFind {

        int[] nums;
        int count;

        UnionFind(int size) {
            nums = new int[size];
            Arrays.setAll(nums, i -> i);
            count = size;
        }

        int find(int node) {
            while (node != nums[node])
                node = nums[node];
            return node;
        }

        int union(int node1, int node2) {
            int val = 0;
            int x = find(node1);
            int y = find(node2);

            System.out.println("node 1-> " + node1 + " || parent -> " + x);
            System.out.println("node 2-> " + node2 + " || parent -> " + y);

            if (x != y) {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == y) {
                        nums[i] = x;
                    }
                    if (nums[i] == x)
                        val++;
                }
                Arrays.stream(nums).forEach(System.out::print);
                System.out.println();
            }

            return val;

        }

    }
}

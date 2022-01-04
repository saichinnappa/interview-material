package com.practice.leetcode.graphs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {

    static final int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    static int maxRow;
    static int maxCol;
    static int result = 0;

    public static void main(String[] args) {
        int[][] input = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//        int[][] input = {{0, 2}};
        maxRow = input.length - 1;
        maxCol = input[0].length - 1;
        orangesRotting(input);
        System.out.println(result);
    }

    private static void orangesRotting(int[][] input) {

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(0, 0));

        while (!queue.isEmpty()) {

            List<Integer> firstElement = queue.remove();
            int row = firstElement.get(0);
            int col = firstElement.get(1);

            List<List<Integer>> neighbors = getNeighbors(row, col, input);

            if (neighbors.size() > 0)
                result++;

            for (List<Integer> neighbor : neighbors) {
                input[neighbor.get(0)][neighbor.get(1)] = 2;
                queue.add(neighbor);
            }
        }

        for (int[] ints : input) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    result = -1;
                    break;
                }
            }
        }

    }

    private static List<List<Integer>> getNeighbors(int row, int col, int[][] input) {

        List<List<Integer>> neighbors = new ArrayList<>();

        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];

            if (newRow < 0 || newCol < 0 || newRow > maxRow || newCol > maxCol || input[newRow][newCol] != 1) {
                continue;
            }
            neighbors.add(List.of(newRow, newCol));
        }

        return neighbors;
    }
}

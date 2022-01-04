package com.practice.leetcode.graphs.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NumberOfIslands {

    static char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
    };
    static int totalIslands = 0;
    static int maxRows, maxCols;

    public static void main(String[] args) {
//        System.out.println(numIslandsRecursive(grid));
        System.out.println(numIslandsIterative(grid));
    }

    private static int numIslandsIterative(char[][] grid) {

        maxRows = grid.length;
        maxCols = grid[0].length;

        Stack<Pair> stack = new Stack<Pair>();

        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxCols; j++) {
                if (grid[i][j] == '1') {
                    totalIslands++;
                    stack.push(new Pair(i, j));
                    processIsland(stack, grid);
                }
            }
        }
        return totalIslands;
    }

    private static void processIsland(Stack<Pair> stack, char[][] grid) {

        while (!stack.isEmpty()) {
            Pair top = stack.pop();
            grid[top.row][top.col] = 'V';
            List<Pair> neighbors = getNeighbors(top.row, top.col);
            for (Pair neighbor : neighbors) {
                stack.push(neighbor);
            }
        }
    }

    private static List<Pair> getNeighbors(int row, int col) {

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        List<Pair> neighbors = new ArrayList<>();
        for (int[] d : directions) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            if (newRow < 0 || newCol < 0 || newRow > maxRows - 1 || newCol > maxCols - 1 || grid[newRow][newCol] != '1')
                continue;
            neighbors.add(new Pair(newRow, newCol));
        }

        return neighbors;
    }


    public static int numIslandsRecursive(char[][] grid) {

        maxRows = grid.length;
        maxCols = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    totalIslands++;
                    dfsIslands(grid, i, j);
                }

            }
        }

        return totalIslands;
    }

    private static void dfsIslands(char[][] grid, int row, int col) {

        if (row < 0 || col < 0 || row > maxRows - 1 || col > maxCols - 1 || grid[row][col] != '1') {
            return;
        }

        grid[row][col] = 'V';
        dfsIslands(grid, row - 1, col);
        dfsIslands(grid, row + 1, col);
        dfsIslands(grid, row, col - 1);
        dfsIslands(grid, row, col + 1);
    }

}

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}


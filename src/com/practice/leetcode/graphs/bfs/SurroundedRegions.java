package com.practice.leetcode.graphs.bfs;

import java.util.*;

public class SurroundedRegions {
    static final int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    //    static char[][] input = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
    static char[][] input = {{'X', 'O'}, {'O', 'X'}};
    static int maxRows;
    static int maxCols;

    public static void main(String[] args) {
        solve(input);
        System.out.println(Arrays.deepToString(input));
    }

    private static void solve(char[][] board) {
        List<Pair> boarderCellsList = new ArrayList<>();
        maxRows = board.length;
        maxCols = board[1].length;

        for (int i = 0; i < maxRows; i++) {
            if (board[i][maxCols - 1] == 'O')
                boarderCellsList.add(new Pair(i, maxCols - 1));
            if (board[i][0] == 'O')
                boarderCellsList.add(new Pair(i, 0));
        }

        for (int i = 0; i < maxCols; i++) {
            if (board[maxRows - 1][i] == 'O')
                boarderCellsList.add(new Pair(maxRows - 1, i));
            if (board[0][i] == 'O')
                boarderCellsList.add(new Pair(0, i));
        }


        Queue<Pair> queue = new LinkedList<Pair>(boarderCellsList);
//        queue.add(boarderCellsList.get(0));


        while (!queue.isEmpty()) {
            Pair firstElement = queue.poll();
            board[firstElement.row][firstElement.col] = 'E';
            List<Pair> neighbors = getNeighbors(firstElement);
            neighbors.forEach(queue::offer);
        }

        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxCols; j++) {
                if (board[i][j] == 'E')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }


    }

    private static List<Pair> getNeighbors(Pair firstElement) {

        List<Pair> neighbors = new ArrayList<>();

        for (int[] d : directions) {
            int newRow = firstElement.row + d[0];
            int newCol = firstElement.col + d[1];

            if (newRow > maxRows - 1 || newCol > maxCols - 1 || newRow < 0 || newCol < 0 || input[newRow][newCol] != 'O')
                continue;
            neighbors.add(new Pair(newRow, newCol));
        }
        return neighbors;
    }

}

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}

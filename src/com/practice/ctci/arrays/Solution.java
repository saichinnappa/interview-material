package com.practice.ctci.arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 2, 3}, {4, 0, 5}, {7, 8, 9}};
        solution.findAndSetZero(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Find zero in a M*N matrtix, and set entire row and column to zero
    void findAndSetZero(int[][] matrix) {
        int firstElementTrackerRow = -1;
        int firstElementTrackerColumn = -1;
        for (int i = 0; i < matrix.length; i++) { //get all rows in matrix
            for (int j = 0; j < matrix[i].length; j++) { //get all columns w.r.t the row
                if (matrix[i][j] == 0 && i != firstElementTrackerRow && j != firstElementTrackerColumn) {
                    int rowIndex = 0;
                    int colIndex = 0;
                    firstElementTrackerRow = i;
                    firstElementTrackerColumn = j;
                    while (colIndex != matrix[i].length) { //iterate complete until colIndex reaches the length of the row
                        matrix[i][colIndex] = 0;
                        colIndex++;
                    }
                    while (rowIndex != matrix.length) { //iterate all rows until rowIndex reaches matrix length
                        matrix[rowIndex][j] = 0;
                        rowIndex++;
                    }
                }
            }
        }
    }
}

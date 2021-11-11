package com.practice.leetcode.arrays;

/**
 * 1252. Cells with Odd Values in a Matrix
 */
public class OddValuesMatrix {
    public static void main(String[] args) {
        int[][] indices = {{1, 1}, {0, 0}};
        int n = 2;
        int m = 3;
        System.out.println(oddCells(2, 2, indices));
    }

    public static int oddCells(int n, int m, int[][] indices) {
        int count = 0;
        int[][] finalMatrix = new int[n][m];
        for (int i = 0; i < indices.length; i++) {
            for (int j = 0; j < indices[i].length - 1; j++) {
                int rowIndex = 0;
                int columnIndex = 0;
                while (columnIndex < m) {
                    finalMatrix[indices[i][j]][columnIndex] += 1;
                    columnIndex++;
                }
                while (rowIndex < n) {
                    finalMatrix[rowIndex][indices[i][j + 1]] += 1;
                    rowIndex++;
                }
            }
        }

        for (int i = 0; i < finalMatrix.length; i++) {
            for (int k = 0; k < finalMatrix[i].length; k++) {
                if (finalMatrix[i][k] % 2 != 0)
                    count++;
            }
        }
        return count;
    }

}

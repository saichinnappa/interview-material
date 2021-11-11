package com.practice.leetcode.misc;

import java.util.*;

public class LuckyNumbers {
    public static void main(String[] args) {
        int[][] input = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        luckyNumbers(input);
    }


    public static List<Integer> luckyNumbers(int[][] matrix) {

        List<Integer> output = new ArrayList<>();
        int[] rowMinElement = new int[3];
        int[] columnMaxElement = new int[3];
        Map<Integer, Integer> matrixMap = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Arrays.sort(matrix[i]);
                matrixMap.put(i, matrix[i][0]);
            }
        }
        return output;

    }
}

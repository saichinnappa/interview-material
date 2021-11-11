package com.practice.geeksforgeeks.arrays;

/**
 * Perfect Sum Problem
 * Given an array arr[] of integers and an integer K, the task is to print all subsets of the given array with the sum equal to the given target K.
 * <p>
 * Examples:
 * <p>
 * Input: arr[] = {5, 10, 12, 13, 15, 18}, K = 30
 * Output: {12, 18}, {5, 12, 13}, {5, 10, 15}
 * Explanation:
 * Subsets with sum 30 are:
 * 12 + 18 = 30
 * 5 + 12 + 13 = 30
 * 5 + 10 + 15 = 30
 * <p>
 * Input: arr[] = {1, 2, 3, 4}, K = 5
 * Output: {2, 3}, {1, 4}
 */
public class PerfectSum {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1 >> 2));
        int[] input = {1, 2, 3, 4, 5};
        perfectSum(input, 5);
    }

    private static void perfectSum(int[] input, int sum) {
        int l = 0;
        for (int i = 0; i < input.length; i++) {
            int temp = input[i];
            for (int j = i + 1; j < l + 2; j++) {
                temp += input[j];
                if (temp == sum) {
                    int[] result = new int[j];
                    int k = 0;
                    while (k != j) {
                        result[k] = input[j];
                        k++;
                    }
//                    System.out.println(Arrays.toString(result));
                } else if (temp > sum) {
                    break;
                }
            }
        }
    }
}

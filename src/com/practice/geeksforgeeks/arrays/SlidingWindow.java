package com.practice.geeksforgeeks.arrays;

/**
 * Sliding Window
 * <p>
 * Given an array arr of size N and an integer K, the task is to find the maximum for each and every contiguous subarray of size K
 * <p>
 * Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4
 * Output: 10 10 10 15 15 90 90
 */
public class SlidingWindow {
    public static void main(String[] args) {
        int[] input = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        findSlidingWindowMax(input, 4);
    }

    private static void findSlidingWindowMax(int[] input, int k) {
        for (int i = 0; i < input.length; i++) {
            if (i + k <= input.length) {
                int max = input[i];
                for (int j = i + 1; j < i + k; j++) {
                    if (max < input[j])
                        max = input[j];
                }
                System.out.print(max + " ");
            }
        }
    }
}

package com.practice.geeksforgeeks.arrays;

import java.util.Arrays;

/**
 * Given an array arr[] denoting heights of N towers and a positive integer K,
 * you have to modify the height of each tower either by increasing or decreasing them by K only once.
 * After modifying, height should be a non-negative integer.
 * Find out the minimum possible difference of the height of shortest and longest towers after you have modified each tower.
 * <p>
 * Note: It is compulsory to increase or decrease (if possible) by K to each tower.
 * Input:
 * K = 2, N = 4
 * Arr[] = {1, 5, 8, 10}
 * Output:
 * 5
 * Explanation:
 * The array can be modified as
 * {3, 3, 6, 8}. The difference between
 * the largest and the smallest is 8-3 = 5.
 */
public class MinimizeHeights {
    public static void main(String[] args) {
        int[] input = {3, 9, 12, 16, 20};
        int k = 3;
        for (int i = 0; i < input.length; i++) {
            if (input[i] - k <= 0) {
                input[i] += k;
            } else {
                input[i] -= k;
            }
        }
        Arrays.sort(input);
        System.out.println("Min Height: " + (input[input.length - 1] - input[0]));
    }
}

package com.practice.geeksforgeeks.arrays;

/**
 * Given an array A of size N of integers. Your task is to find the minimum and maximum elements in the array.
 * Example 1:
 * <p>
 * Input:
 * N = 6
 * A[] = {3, 2, 1, 56, 10000, 167}
 * Output:
 * min = 1, max =  10000
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input:
 * N = 5
 * A[]  = {1, 345, 234, 21, 56789}
 * Output:
 * min = 1, max = 56789
 */
public class MinAndMax {
    public static void main(String[] args) {
        int[] input = {3, 2, 1, 56, 1000, 167};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : input) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }

        System.out.println("MIN: " + min + " | MAX: " + max);
    }
}

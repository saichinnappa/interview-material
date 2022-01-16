package com.practice.geeksforgeeks.arrays;

/**
 * Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.
 * Example 1:
 * <p>
 * Input:
 * N = 5
 * Arr[] = {1,2,3,-2,5}
 * Output:
 * 9
 * Explanation:
 * Max subarray sum is 9
 * of elements (1, 2, 3, -2, 5) which
 * is a contiguous subarray.
 */
public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, -2, 5};
        int maxCurrent = input[0];
        int maxGlobal = input[0];
        for (int i = 1; i < input.length; i++) {
            maxCurrent = Math.max(input[i], input[i] + maxCurrent);
            if (maxCurrent > maxGlobal)
                maxGlobal = maxCurrent;
        }
        System.out.println("Max sum is: " + maxGlobal);
    }
}

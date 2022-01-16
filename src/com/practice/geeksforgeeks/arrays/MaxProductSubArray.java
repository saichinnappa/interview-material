package com.practice.geeksforgeeks.arrays;

/**
 * Given an array Arr[] that contains N integers (may be positive, negative or zero). Find the product of the maximum product subarray.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * N = 5
 * Arr[] = {6, -3, -10, 0, 2}
 * Output: 180
 * Explanation: Subarray with maximum product
 * is [6, -3, -10] which gives product as 180.
 */
public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] input = {6, -3, -10, 0, 2};
        int result = input[0];
        int currMin = input[0];
        int currMax = input[0];
        for (int i = 1; i < input.length; i++) {
            int curr = input[i];
            int temp = Math.max(curr, Math.max(curr * currMax, curr * currMin));
            currMin = Math.min(curr, Math.min(curr * currMin, curr * currMax));
            currMax = temp;
            result = Math.max(currMax, result);
        }
        System.out.println("Result: " + result);
    }
}

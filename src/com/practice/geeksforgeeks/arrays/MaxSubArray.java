package com.practice.geeksforgeeks.arrays;

/**
 * Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.
 * <p>
 * <p>
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
public class MaxSubArray {
    public static void main(String[] args) {
        int[] input = {1, -2, -3, -2, 5};
        int sum = input[0];
        int result = input[0];
        for (int i = 1; i < input.length; i++) {
            sum = Math.max(input[i], sum + input[i]);
            if (sum > result)
                result = sum;
        }
        System.out.println("Result: " + result);
    }
}

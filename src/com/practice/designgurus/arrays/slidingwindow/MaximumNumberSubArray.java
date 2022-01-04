package com.practice.designgurus.arrays.slidingwindow;

/**
 * Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 * Example 2:
 * <p>
 * Input: [2, 3, 4, 1, 5], k=2
 * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4].
 */
public class MaximumNumberSubArray {

    public static void main(String[] args) {
        int ans = helper(2, new int[]{2, 3, 4, 1, 5});
        System.out.println(ans);
    }

    private static int helper(int k, int[] ints) {
        int maxValue = Integer.MIN_VALUE;
        int startWindow = 0;
        int runningSum = 0;
        for (int i = startWindow; i < ints.length; i++) {
            runningSum += ints[i];
            if (i >= k - 1) {
                maxValue = Math.max(maxValue, runningSum);
                runningSum -= ints[startWindow];
                startWindow++;
            }
        }
        return maxValue;
    }
}

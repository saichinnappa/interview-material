package com.practice.designgurus.arrays.slidingwindow;

/**
 * Given an array of positive numbers and a positive number ‘S,’
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
 * Return 0 if no such subarray exists.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
 * Example 2:
 * <p>
 * Input: [2, 1, 5, 2, 8], S=7
 * Output: 1
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
 * Example 3:
 * <p>
 * Input: [3, 4, 1, 1, 6], S=8
 * Output: 3
 * Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1]
 * or [1, 1, 6].
 */
public class SmallestSumSubarray {
    public static void main(String[] args) {
        int ans = helper(8, new int[]{3, 4, 1, 1, 6});
        System.out.println(ans);
    }

    private static int helper(int s, int[] ints) {
        int start = 0;
        int result = Integer.MAX_VALUE;
        int currentSum = 0;
        for (int i = 0; i < ints.length; i++) {
            currentSum += ints[i];
            while (currentSum >= s) {
                result = Math.min(result, i - start + 1);
                currentSum -= ints[start];
                start++;
            }
        }
        return result;
    }


}

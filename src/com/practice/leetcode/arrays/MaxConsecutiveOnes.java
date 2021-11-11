package com.practice.leetcode.arrays;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * <p>
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * Note:
 * <p>
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] input = {1, 1, 1, 1, 0, 0, 1, 1};
        System.out.println(findMaxConsecutiveOnes(input));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int prev = 0;
        int curr = 0;
        for (int i : nums) {
            if (i == 1) {
                ++curr;
            } else {
                curr = 0;
            }
            if (prev < curr) {
                prev = curr;
            }
        }
        return prev;
    }
}

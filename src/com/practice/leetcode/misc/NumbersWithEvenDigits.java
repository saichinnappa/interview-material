package com.practice.leetcode.misc;

/**
 * 1295. Find Numbers with Even Number of Digits
 * Given an array nums of integers, return how many of them contain an even number of digits.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [12,345,2,6,7896]
 * Output: 2
 * Explanation:
 * 12 contains 2 digits (even number of digits).
 * 345 contains 3 digits (odd number of digits).
 * 2 contains 1 digit (odd number of digits).
 * 6 contains 1 digit (odd number of digits).
 * 7896 contains 4 digits (even number of digits).
 * Therefore only 12 and 7896 contain an even number of digits.
 */
public class NumbersWithEvenDigits {
    public static void main(String[] args) {
        int[] nums = {580};
        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int result = 0;
        for (int n : nums) {
            int count = 1;
            while (n / 10 != 0) {
                count++;
                n = n / 10;
            }
            if (count % 2 == 0) {
                result++;
            }
        }
        return result;
    }
}

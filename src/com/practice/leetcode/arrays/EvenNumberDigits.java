package com.practice.leetcode.arrays;

/**
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
 * Example 2:
 * <p>
 * Input: nums = [555,901,482,1771]
 * Output: 1
 * Explanation:
 * Only 1771 contains an even number of digits.
 */
public class EvenNumberDigits {
    public static void main(String[] args) {
        int[] input = {555, 901, 482, 1771};
        System.out.println(findEvenNumberDigits(input));
    }

    static int findEvenNumberDigits(int[] arr) {
        int result = 0;
        for (int i : arr) {
            int digitsCount = 1; //every number has atleast one digit
            while (i / 10 != 0) {
                i = i / 10;
                digitsCount++;
            }
            if (digitsCount % 2 == 0)
                result++;
        }
        return result;
    }
}

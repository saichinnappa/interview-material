package com.practice.leetcode.arrays;

/**
 * LC: 167 - Two Sum II - Input array is sorted
 * <p>
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] input = {2, 3, 7, 9};
        twoSum(input, 9);

    }

    private static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
            if (sum < target) {
                left = (numbers[mid] + numbers[right]) < target ? mid : left + 1;
            } else {
                right = (numbers[mid] + numbers[left]) > target ? mid : right - 1;
            }
        }
        return result;
    }

}

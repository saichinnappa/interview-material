package com.practice.leetcode.arrays;

import java.util.Arrays;

/**
 * 1389. Create Target Array in the Given Order
 * Given two arrays of integers nums and index. Your task is to create target array under the following rules:
 * <p>
 * Initially target array is empty.
 * From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
 * Repeat the previous step until there are no elements to read in nums and index.
 * Return the target array.
 * <p>
 * It is guaranteed that the insertion operations will be valid.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * Output: [0,4,1,3,2]
 * Explanation:
 * nums       index     target
 * 0            0        [0]
 * 1            1        [0,1]
 * 2            2        [0,1,2]
 * 3            2        [0,1,3,2]
 * 4            1        [0,4,1,3,2]
 */
public class TargetArray {
    public static void main(String[] args) {
        int[] nums = {7, 6, 5, 5, 5, 4, 5, 5};
        int[] index = {0, 1, 1, 2, 4, 2, 3, 6};
        System.out.println(Arrays.toString(createTargetArray(nums, index)));
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] targetArray = new int[nums.length];
        Arrays.fill(targetArray, -1);
        for (int i = 0; i < nums.length; i++) {
            if (targetArray[index[i]] == -1) {
                targetArray[index[i]] = nums[i];
            } else {
                shiftElements(targetArray, nums[i], index[i]);
            }
        }
        return targetArray;
    }

    private static void shiftElements(int[] targetArray, int valueToBeInserted, int insertIndex) {
        for (int i = targetArray.length - 1; i > insertIndex; i--) {
            targetArray[i] = targetArray[i - 1];
        }
        targetArray[insertIndex] = valueToBeInserted;
    }
}

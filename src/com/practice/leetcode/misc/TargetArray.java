package com.practice.leetcode.misc;

/**
 * 1389
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
        int[] nums = {0, 1, 2, 3, 4};
        int[] index = {0, 1, 2, 2, 1};
        createTargetArray(nums, index);
    }

    private static int[] createTargetArray(int[] nums, int[] index) {
        int[] targetArray = new int[nums.length];
        for (int i = 0; i < targetArray.length; i++) {
            targetArray[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < index.length; i++) {
            if (targetArray[index[i]] == Integer.MIN_VALUE) {
                targetArray[index[i]] = nums[i];
            } else {
                int count = index[i];
                if (count + 1 < index.length && targetArray[count + 1] == Integer.MIN_VALUE) {
                    targetArray[count + 1] = targetArray[count];
                    targetArray[index[i]] = nums[i];
                } else {
                    for (int j = targetArray.length - 2; j >= index[i]; j--) {
                        targetArray[j + 1] = targetArray[j];
                    }
                    targetArray[index[i]] = nums[i];
                }

            }
        }
        for (int i : targetArray) {
            System.out.println(i);
        }
        return targetArray;
    }

}

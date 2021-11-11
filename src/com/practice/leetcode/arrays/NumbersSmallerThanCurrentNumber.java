package com.practice.leetcode.arrays;

import java.util.Arrays;

/**
 * 1365. How Many Numbers Are Smaller Than the Current Number
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
 * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 * <p>
 * Return the answer in an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 * Explanation:
 * For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 * For nums[1]=1 does not exist any smaller number than it.
 * For nums[2]=2 there exist one smaller number than it (1).
 * For nums[3]=2 there exist one smaller number than it (1).
 * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 */
public class NumbersSmallerThanCurrentNumber {
    public static void main(String[] args) {
        int[] input = {6, 5, 4, 8};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent2(input)));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] finalArray = new int[nums.length];
        int count = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[index] > nums[i]) {
                count++;
            }
            if (i == nums.length - 1) {
                finalArray[index] = count;
                i = -1;
                index++;
                count = 0;
            }
            if (index == nums.length)
                break;
        }
        return finalArray;
    }

    public static int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        System.out.println(Arrays.toString(count));

        for (int i = 1; i <= 100; i++) {
            count[i] += count[i - 1];
        }
        System.out.println(Arrays.toString(count));

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                res[i] = 0;
            else
                res[i] = count[nums[i] - 1];
        }
        System.out.println(Arrays.toString(res));

        return res;

    }

}

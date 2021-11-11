package com.practice.leetcode.misc;

import java.util.HashMap;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int result = -1;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i : nums) {
            countMap.put(i, countMap.get(i) == null ? 1 : countMap.get(i) + 1);
        }
        for (int i : countMap.keySet()) {
            if (countMap.get(i) == 1) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 1, 2, 2, 1};
        System.out.println(singleNumber(arr1));
    }
}

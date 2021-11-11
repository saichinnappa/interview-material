package com.practice.leetcode.arrays;

import java.util.*;

/**
 * LC: 349 - Intersection of two arrays
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 * <p>
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class IntersectionTwoArrays {

    public static void main(String[] args) {
        int[] arr1 = {2, 1};
        int[] arr2 = {1, 1};
        int[] result = intersection(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        List<Integer> result = new ArrayList<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                result.add(i);
                set.remove(i);
            }
        }
        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints;
    }
}

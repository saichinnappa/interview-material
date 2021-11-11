package com.practice.leetcode.arrays;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 0, 0, 0};
        int[] input2 = {2, 5, 6};
        merge(input1, 3, input2, 3);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}

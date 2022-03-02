package com.practice.leetcode.arrays;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 0, 0, 0, 0};
        int[] input2 = {2, 3, 6, 7};
        merge(input1, 3, input2, 4);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = nums1.length - 1;
        int indexOne = m - 1;
        int indexTwo = n - 1;
        while (indexOne >= 0 && indexTwo >= 0) {
            if (nums1[indexOne] > nums2[indexTwo]) {
                nums1[length] = nums1[indexOne];
                length--;
                indexOne--;
            } else if (nums1[indexOne] < nums2[indexTwo]) {
                nums1[length] = nums2[indexTwo];
                indexTwo--;
                length--;
            } else {
                nums1[length] = nums1[indexOne];
                length--;
                indexOne--;
                nums1[length] = nums2[indexTwo];
                indexTwo--;
                length--;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
}

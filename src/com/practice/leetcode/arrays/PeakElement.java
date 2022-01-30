package com.practice.leetcode.arrays;

import java.util.LinkedList;

/**
 * 162. Find Peak Element
 * A peak element is an element that is strictly greater than its neighbors.
 * <p>
 * Given an integer array nums, find a peak element, and return its index.
 * If the array contains multiple peaks, return the index to any of the peaks.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 */
public class PeakElement {
    public static void main(String[] args) {
        int nums[] = {1, 2, 1, 3, 5, 6, 4};
        if (nums.length == 1)
            System.out.println("Peak element index: " + 0);
        int left = 0;
        int right = nums.length - 1;

        //iterative binary search
//        while (left < right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] > nums[mid + 1]) {
//                right = mid;
//            } else
//                left = mid + 1;
//        }
//        System.out.println("Peak Element index: " + left);

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1, (Integer) 22);
        System.out.println(
                list.size()
        );

        //Recursive Binary Search
        int peakIndex = binarySearch(left, right, nums);
        System.out.println("Peak Element index: " + peakIndex);

    }

    private static int binarySearch(int left, int right, int[] nums) {
        if (left == right)
            return left;
        int mid = (left + right) / 2;
        if (nums[mid] < nums[mid + 1])
            return binarySearch(mid + 1, right, nums);
        else
            return binarySearch(left, mid, nums);
    }
}

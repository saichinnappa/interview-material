package com.practice.leetcode.arrays;

/**
 * 33. Search in Rotated Sorted Array
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 * <p>
 * Input: nums = [1], target = 0
 * Output: -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -104 <= target <= 104
 * <p>
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] input = {4, 5, 6, 7, 0, 1, 2};
        int length = input.length;
        int target = 1;
        int rIdx = findRotatedIndex(input, 0, length - 1);
        System.out.println("Rotated Index->" + rIdx);
        int result = -1;
        if (input[rIdx] == target)
            result = rIdx;
        else if (target > input[length - 1]) { //search in the left of rotated array
            result = binarySearch(input, target, 0, rIdx - 1);
        } else {
            result = binarySearch(input, target, rIdx + 1, length - 1);
        }
        System.out.println(result);
    }

    private static int binarySearch(int[] input, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            System.out.println(start + " " + end + " " + mid);
            if (input[mid] == target)
                return mid;
            else if (input[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private static int findRotatedIndex(int[] input, int start, int end) {
        if (input[start] < input[end])
            return 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (input[mid] > input[mid + 1])
                return mid + 1;
            else if (input[mid] > input[start])
                start = mid + 1;
            else if (input[mid] < input[start])
                end = mid - 1;
        }
        return -1;
    }

}

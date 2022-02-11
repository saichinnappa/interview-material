package com.practice.geeksforgeeks.arrays;

public class MinValueInRotatedSubArray {
    public static void main(String[] args) {
        int[] input = {4, 5, 0, 1, 2, 3};
        int rIdx = findRotatedIndex(input, 0, input.length - 1);
        System.out.println("Min Element: " + input[rIdx]);
    }

    private static int findRotatedIndex(int[] nums, int start, int end) {
        if (nums[start] < nums[end])
            return 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } else if (nums[mid] < nums[start])
                end = mid - 1;
            else if (nums[mid] >= nums[start])
                start = mid + 1;
        }
        return -1;
    }
}

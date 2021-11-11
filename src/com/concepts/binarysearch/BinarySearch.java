package com.concepts.binarysearch;

public class BinarySearch {
//    recursiveSearch

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {5, 6, 7, 0, 1, 2, 4};
        int target = 0;
//        int index = binarySearch.performSearch(nums, target);
//        System.out.println(index);
//        int[] nums1 = new int[8];
//        binarySearch.sqrt(nums1, 8);
        System.out.println("Iterative--> " + binarySearch.findRotationsCount(nums));
        System.out.println("Recursive--> " + binarySearch.findRotationsCountRecursive(nums));
    }

    private int performSearch(int[] input, int target) {
        if (input.length == 0) {
            return -1;
        }
        int left = 0;
        int right = input.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (input[mid] == target)
                return mid;
            else if (input[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    private int sqrt(int[] input, int x) {
        if (x == 0)
            return 0;
        int left = 0;
        int right = input.length - 1;
        System.out.println(left + "<L R>" + right);
        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println(input[mid] + " " + mid);
            int val = mid * mid;
            if (val == x)
                return mid;
            else if (val > x)
                right = mid - 1;
            else
                left = mid + 1;
            if (right - left == 1)
                return left;
        }
        return x;
    }


    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        return recursiveBinarySearch(nums, low, high, target);
    }

//    int recursiveBinarySearch(int[] nums, int low, int high, int target) {
//        if (low > high)
//            return -1;
//        int mid = low + (high - low) / 2;
//        if (nums[mid] == target)
//            return mid;
//        if (target > nums[mid])
//            return recursiveBinarySearch(nums, mid + 1, high, target);
//        else
//            return recursiveBinarySearch(nums, low, mid - 1, target);
//    }


    public int recursiveSearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        return recursiveBinarySearch(nums, low, high, target);
    }

    int recursiveBinarySearch(int[] nums, int low, int high, int target) {
        if (low > high)
            return -1;
        int mid = low + (high - low) / 2;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] > nums[high]) {
            if (target < nums[mid]) {
                return recursiveBinarySearch(nums, mid + 1, high, target);
            } else {
                return recursiveBinarySearch(nums, low, mid - 1, target);
            }
        } else {
            if (target > nums[low] && target < nums[mid])
                return recursiveBinarySearch(nums, low, mid - 1, target);
            else
                return recursiveBinarySearch(nums, mid + 1, high, target);
        }
    }

    int findRotationsCount(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if (nums[low] <= nums[high]) {
            return 0;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    int findRotationsCountRecursive(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if (nums[low] <= nums[high]) {
            return 0;
        }
        return helper(nums, low, high);
    }

    private int helper(int[] nums, int low, int high) {
        if (low > high)
            return 0;
        int mid = low + (high - low) / 2;
        int val = nums[mid];
        if (val < nums[mid - 1] && val < nums[mid + 1])
            return mid;
        if (val > nums[high])
            return helper(nums, mid + 1, high);
        else
            return helper(nums, low, mid - 1);

    }


}

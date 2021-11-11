package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [3,2,2,3], val = 3,
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 2.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * <p>
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 * <p>
 * Note that the order of those five elements can be arbitrary.
 * <p>
 * It doesn't matter what values are set beyond the returned length.
 */
public class RemoveElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3}; // 1,2,2,3,4,5
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(findElement(arr));
//        System.out.println(Arrays.toString(sortedSquares(arr)));
//        findDisappearedNumbers(arr);
        System.out.println(nthMax(arr, 3));
    }

    private static boolean findElement(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int valueCheck = 2 * arr[i];
            int k = i;
            if (valueCheck < arr[k]) {
                while (k != -1) {
                    if (i != k && valueCheck == arr[k]) {
                        return true;
                    }
                    k--;
                }
            } else if (valueCheck >= arr[k]) {
                while (k != arr.length) {
                    if (i != k && valueCheck == arr[k]) {
                        return true;
                    }
                    k++;
                }
            }
        }
        return false;
    }

    private static void test(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = Integer.MIN_VALUE;
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[k] > temp) {
                    temp = arr[k];
                }
            }
            if (i == arr.length - 1)
                arr[i] = -1;
            else
                arr[i] = temp;
        }
    }

    public static void moveZeroes(int[] num) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 0) {
                int nextIndex = i + 1;
                while (nextIndex < num.length) {
                    if (num[nextIndex] != 0) {
                        int temp = num[nextIndex];
                        num[nextIndex] = 0;
                        num[i] = temp;
                        break;
                    }
                    nextIndex++;
                }
            }
        }
    }

    public static int[] sortArrayByParity(int[] A) {
        int evenIndex = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                evenIndex++;
                int temp = A[evenIndex];
                A[evenIndex] = A[i];
                A[i] = temp;
            }
        }
        return A;
    }

    public static int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

//    public static int heightChecker(int[] heights) {
//        int diff = Integer.MIN_VALUE;
//        int tempIndex = 0;
//        for (int i = 0; i < heights.length - 1; i++) {
//            if (heights[i] - heights[i + 1] > diff) {
//                diff = heights[i] - heights[i + 1];
//                tempIndex = i;
//            }
//        }
//    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] found = new boolean[nums.length];
        ArrayList<Integer> elements = new ArrayList<>();
        for (int n : nums) {
            found[n - 1] = true;
        }
        for (int i = 0; i < found.length; i++) {
            if (!found[i]) {
                elements.add(i + 1);
            }
        }
        return elements;
    }

    public static int nthMax(int[] nums, int n) { // 1,2,2,3,4,5
        Arrays.sort(nums);
        if (nums.length < 3) {
            return nums[nums.length - 1];
        }
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            System.out.println(i);
            System.out.println("comparing: " + nums[i] + "," + nums[i - 1]);
            if (nums[i] != nums[i - 1]) {
                count++;
            }
            if (count == n)
                return nums[i];
        }
        return nums[nums.length - 1];
    }
}

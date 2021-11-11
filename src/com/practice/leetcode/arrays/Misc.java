package com.practice.leetcode.arrays;

import java.util.*;

public class Misc {
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
//        int[] arr1 = {1, 2, 3, 4, 5};
//        int[] arr2 = {1, 2, 5, 7, 9};
//        int[] arr3 = {1, 3, 4, 5, 8};
//        intersection3Arrays(arr1, arr2, arr3);
//        int[] arr = {2, 1, 2, 1, 1, 2, 2, 1};
//        transformArray(arr);
//        int[] nums = {4, 10, 2, 6, 1};
//        int[] nums = {8, 8};
//        int[] nums = {1, 7, 4, 7, 1, 9, 4, 8, 8};
//        System.out.println(Arrays.toString(minSubsequence(nums).toArray()));
        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(climbStairs(4));
    }

    static List<Integer> intersection3Arrays(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<Integer>();
        Map<Integer, Integer> commonMap = new HashMap<>();

        for (int n : arr1) {
            commonMap.put(n, 1);
        }
        for (int i : arr2) {
            if (commonMap.containsKey(i)) {
                commonMap.put(i, commonMap.get(i) + 1);
            }
        }
        for (int i : arr3) {
            if (commonMap.containsKey(i)) {
                commonMap.put(i, commonMap.get(i) + 1);
            }
        }
        for (int n : commonMap.keySet()) {
            if (commonMap.get(n) == 3) {
                result.add(n);
            }
        }
        Collections.sort(result);
        return result;
    }

    /**
     * Given an initial array arr, every day you produce a new array using the array of the previous day.
     * <p>
     * On the i-th day, you do the following operations on the array of day i-1 to produce the array of day i:
     * <p>
     * If an element is smaller than both its left neighbor and its right neighbor, then this element is incremented.
     * If an element is bigger than both its left neighbor and its right neighbor, then this element is decremented.
     * The first and last elements never change.
     * After some days, the array does not change. Return that final array.
     * <p>
     * Example 1:
     * <p>
     * Input: arr = [6,2,3,4]
     * Output: [6,3,3,4]
     * Explanation:
     * On the first day, the array is changed from [6,2,3,4] to [6,3,3,4].
     * No more operations can be done to this array.
     */

    static List<Integer> transformArray(int[] arr) {
        int[] res = Arrays.copyOf(arr, arr.length);
        int flag = 0;
        while (true) {
            flag = 0;
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    res[i] = arr[i] + 1;
                    flag = 1;
                } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    System.out.println("index: " + i + " || i-1: " + arr[i - 1] + " || i: " + arr[i] + "|| i+1: " + arr[i + 1]);
                    res[i] = arr[i] - 1;
                    flag = 1;
                }
                System.out.println(Arrays.toString(res));
            }

            if (flag == 0) {
                break;
            } else {
                System.out.println("---");
                arr = Arrays.copyOf(res, res.length);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : res) {
            list.add(num);
        }
        return list;
    }

    static void rotateRight(int[] nums, int k) {
        while (k != 0) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            System.out.println(Arrays.toString(nums));
            k--;
        }
    }

    public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        } else {
            Arrays.sort(nums);
            int sum = 0, newSum = 0;
            for (int i : nums) {
                sum += i;
            }
            for (int j = nums.length - 1; j >= 0; j--) {
                result.add(nums[j]);
                newSum += nums[j];
                if (newSum > sum - newSum)
                    return result;
            }
        }
        return result;
    }

    public static boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int value : arr) {
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        }
        Set<Integer> countSet = new HashSet<>(countMap.values());
        return countMap.size() == countSet.size();
    }

    public static int climbStairs(int n) {
        if (map.containsKey(n))
            return map.get(n);
        if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            map.put(n - i, climbStairs(n - i));
        }
        return map.get(n);
    }

    private int getNum(int row, int col) {
        if (row == 0 || col == 0 || row == col) {
            return 1;
        }
        return getNum(row - 1, col - 1) + getNum(row - 1, col);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            ans.add(getNum(rowIndex, i));
        }

        return ans;
    }

}

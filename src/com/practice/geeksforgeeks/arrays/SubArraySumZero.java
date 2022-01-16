package com.practice.geeksforgeeks.arrays;

import java.util.HashMap;

/**
 * Given an array of positive and negative numbers. Find if there is a subarray (of size at-least one) with 0 sum.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 5
 * 4 2 -3 1 6
 * <p>
 * Output:
 * Yes
 * <p>
 * Explanation:
 * 2, -3, 1 is the subarray
 * with sum 0.
 */
public class SubArraySumZero {
    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6};
        // make hashmap of  sum vs frequneccy
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = -1;
        int sum = 0;

        map.put(0, 1);

        while (i < arr.length - 1) {
            i++;
            sum = sum + arr[i];
            if (map.containsKey(sum)) {
                System.out.println("SUM IS ZERO");
            } else {
                map.put(sum, 1);
            }
        }
        System.out.println("SUM ZERO NOT FOUND");
    }
}

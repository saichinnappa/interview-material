package com.practice.geeksforgeeks.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.
 * Example 1:
 * <p>
 * Input:
 * N = 4, K = 6
 * arr[] = {1, 5, 7, 1}
 * Output: 2
 * Explanation:
 * arr[0] + arr[1] = 1 + 5 = 6
 * and arr[1] + arr[3] = 5 + 1 = 6.
 */
public class CountPairsWithSum {
    public static void main(String[] args) {
        int[] input = {1, 1, 1, 1};
        int k = 2;
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(k - input[i])) {
                result += map.get(k - input[i]);
            }
            map.put(input[i], map.getOrDefault(input[i], 0) + 1);
        }
        System.out.println("Result: " + result);
    }
}

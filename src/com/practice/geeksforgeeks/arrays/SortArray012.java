package com.practice.geeksforgeeks.arrays;

import java.util.Arrays;

/**
 * Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.
 * Example 1:
 * <p>
 * Input:
 * N = 5
 * arr[]= {0 2 1 2 0}
 * Output:
 * 0 0 1 2 2
 * Explanation:
 * 0s 1s and 2s are segregated
 * into ascending order.
 */
public class SortArray012 {
    public static void main(String[] args) {
        int[] input = {0, 2, 1, 2, 0, 2, 2, 0, 0, 1, 0};
        int[] count = new int[3];
        for (int i : input)
            count[i]++;
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] != 0) {
                input[index] = i;
                count[i]--;
                index++;
            }
        }
        System.out.println("After Sort: " + Arrays.toString(input));
    }
}

package com.practice.geeksforgeeks.arrays;

import java.util.Arrays;

/**
 * Given an unsorted array arr[] of size N having both negative and positive integers.
 * The task is place all negative element at the end of array without changing the order of positive element and negative element.
 * <p>
 * Example 1:
 * <p>
 * Input :
 * N = 8
 * arr[] = {1, -1, 3, 2, -7, -5, 11, 6 }
 * Output :
 * 1  3  2  11  6  -1  -7  -5
 */
public class MoveNegativeElementsToEnd {
    public static void main(String[] args) {
        int[] arr = {1, -1, 3, 2, -7, -5, 11, 6};
        int n = arr.length;
        int[] b = new int[n];
        int j = 0;
        for (int k : arr) {
            if (k > 0) {
                b[j] = k;
                j++;
            }
        }
        for (int k : arr) {
            if (k < 0) {
                b[j] = k;
                j++;
            }
        }
        System.arraycopy(b, 0, arr, 0, n);
        System.out.println(Arrays.toString(arr));
    }
}

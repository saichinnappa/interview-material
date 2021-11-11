package com.practice.geeksforgeeks.arrays;

/**
 * Given an array of integers arr of size N, the task is to print products of all subarrays of the array.
 * <p>
 * Examples:
 * <p>
 * Input: arr[] = {2, 4}
 * Output: 64
 * Here, subarrays are [2], [2, 4], [4]
 * Prodcuts are 2, 8, 4
 * Product of all Subarrays = 64
 */
public class SubArraysProduct {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(subArrayProduct(arr));
    }

    static int subArrayProduct(int[] arr) {
        int subArraysCount = 0;
        int product = 1;
        for (int i = 0; i < arr.length; i++) {
            product *= arr[i];
            int temp = arr[i];
            subArraysCount++;
            for (int j = i + 1; j < arr.length; j++) {
                temp *= arr[j];
                subArraysCount++;
                product *= temp;
            }
        }
        System.out.println("Total Subarrays: " + subArraysCount);
        return product;
    }
}

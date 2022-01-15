package com.practice.geeksforgeeks.arrays;

/**
 * Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N. Find the missing element.
 * Example 1:
 * Input:
 * N = 5
 * A[] = {1,2,3,5}
 * Output: 4
 */
public class MissingElement {
    public static void main(String[] args) {
        int[] input = {6, 1, 2, 8, 3, 4, 7, 10, 5};
        int n = 10;
        int totalSum = n * (n + 1) / 2;
        for (int i : input)
            totalSum -= i;
        System.out.println("Missing Element is: " + totalSum);
    }
}

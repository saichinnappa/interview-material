package com.practice.geeksforgeeks.arrays;

import java.util.Arrays;

/**
 * Given an unsorted array A of size N that contains only non-negative integers, find a continuous sub-array which adds to a given number S.
 * Example 1:
 * <p>
 * Input:
 * N = 5, S = 12
 * A[] = {1,2,3,7,5}
 * Output: 2 4
 * Explanation: The sum of elements
 * from 2nd position to 4th position
 * is 12.
 */
public class SubarrayWithSum {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 15;
        int startWindow = 0;
        int currentSum = 0;
        for (int endWindow = startWindow; endWindow < input.length; endWindow++) {
            currentSum += input[endWindow];
            if (currentSum == sum) {
                System.out.println(Arrays.toString(new int[]{startWindow, endWindow}));
                break;
            } else if (currentSum > sum) {
                while (currentSum > sum) {
                    currentSum -= input[startWindow];
                    startWindow++;
                }
                if (currentSum == sum) {
                    System.out.println(Arrays.toString(new int[]{startWindow, endWindow}));
                    break;
                }
            }
        }
    }
}

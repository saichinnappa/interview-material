package com.practice.geeksforgeeks.arrays;

import java.util.Arrays;

/**
 * Quick Sort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot.
 * Given an array arr[], its starting position low and its ending position high.
 * Implement the partition() and quickSort() functions to sort the array.
 * Example 1:
 * <p>
 * Input:
 * N = 5
 * arr[] = { 4, 1, 3, 9, 7}
 * Output:
 * 1 3 4 7 9
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] input = {2, 1, 6, 10, 4, 1, 3, 9, 7};
        quickSort(input, 0, input.length - 1);
        System.out.println("Sorted Array: " + Arrays.toString(input));
    }

    private static void quickSort(int[] input, int start, int end) {
        if (start < end) {
            int partitionIndex = findPartitionIndex(input, start, end);
            quickSort(input, start, partitionIndex - 1);
            quickSort(input, partitionIndex + 1, end);
        }
    }

    private static int findPartitionIndex(int[] input, int start, int end) {
        int pivot = input[end];
        int idx = start - 1;
        for (int i = start; i <= end; i++) {
            if (input[i] <= pivot) {
                ++idx;
                int temp = input[i];
                input[i] = input[idx];
                input[idx] = temp;
            }
        }
        return idx;
    }
}

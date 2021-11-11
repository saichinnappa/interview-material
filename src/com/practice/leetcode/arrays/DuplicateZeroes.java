package com.practice.leetcode.arrays;

import java.util.Arrays;

public class DuplicateZeroes {
    public static void main(String[] args) {
        int[] input = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(input);
    }

    public static void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                i = i + 1; // capture the index of next element to zero
                int indexTracker = arr.length - 1;
                while (indexTracker >= i) {
                    arr[indexTracker] = arr[indexTracker - 1];
                    indexTracker--;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}

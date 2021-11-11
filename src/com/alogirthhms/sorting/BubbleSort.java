package com.alogirthhms.sorting;

import java.util.Arrays;

/**
 * BubbleSort
 * 1. Compare two adjacent elements and swap
 * 2. Keep doing step 1 until there is no swap necessary
 * <p>
 * Time Complexity: WC: O(n^2) | BC: O(n)
 * Space Complexity: O(n)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] unsortedArray = {5, 4, 3, 2, 1};
        int[] sortedArray = sortArray(unsortedArray);
        System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] sortArray(int[] unsortedArray) {
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < unsortedArray.length - 1; i++) {
                if (unsortedArray[i] > unsortedArray[i + 1]) {
                    int temp = unsortedArray[i + 1];
                    unsortedArray[i + 1] = unsortedArray[i];
                    unsortedArray[i] = temp;
                    sorted = false;
                }
            }
        }
        return unsortedArray;
    }
}

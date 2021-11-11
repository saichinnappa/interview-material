package com.alogirthhms.sorting;

import java.util.Arrays;

/**
 * Selection Sort:
 * 1. Find minimum element in the array and swap with first element
 * 2. Keep repeating step 1 until the entire array is sorted
 * <p>
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] unsortedArray = {4, 5, 1, 6, 9, 0, 8};
        selectionSort(unsortedArray);
        System.out.println(Arrays.toString(unsortedArray));
    }

    private static void selectionSort(int[] unsortedArray) {

        for (int i = 0; i < unsortedArray.length; i++) {
            int min = unsortedArray[i];
            int minId = i;
            for (int j = i + 1; j < unsortedArray.length; j++) {
                if (unsortedArray[j] < min) {
                    min = unsortedArray[j];
                    minId = j;
                }
            }
            // swapping
            int temp = unsortedArray[i];
            unsortedArray[i] = min;
            unsortedArray[minId] = temp;
        }
    }


}

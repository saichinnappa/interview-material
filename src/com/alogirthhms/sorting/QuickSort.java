package com.alogirthhms.sorting;

import java.util.Arrays;

/**
 * QuickSort
 * 1. Pick pivot element
 * 2. compare left side of the array with pivot element and swap elements
 * 3. compare right side of the array with pivot element and swap elements
 * <p>
 * Time Complexity: O(nlogn) , worst case O(n^2)
 * Space Complexity: O(n) -since in-place swapping
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] unsortedArray = {99, 1, 2, 3, 3, 4, 4, 4, 5, 7, 8, 99};
        quickSort(unsortedArray, 0, unsortedArray.length - 1);
        System.out.println(Arrays.toString(unsortedArray));
    }

    private static void quickSort(int[] unsortedArray, int start, int end) {

        if (start < end) {
            int pivotIndex = partitionArray(unsortedArray, start, end);
            System.out.println(pivotIndex);
            quickSort(unsortedArray, 0, pivotIndex - 1);
            quickSort(unsortedArray, pivotIndex + 1, end);
        }
    }

    private static int partitionArray(int[] unsortedArray, int start, int end) {
        int pivotElement = unsortedArray[end];
        int i = start - 1;
        for (int j = start; j <= end; j++) {
            if (unsortedArray[j] <= pivotElement) {
                ++i;
                int temp = unsortedArray[i];
                unsortedArray[i] = unsortedArray[j];
                unsortedArray[j] = temp;
            }
        }
        return i;
    }
}

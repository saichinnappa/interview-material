package com.alogirthhms.sorting;

import java.util.Arrays;

/**
 * Merge Sort
 * Time Complexity: O(nlogn) - since the array will be repeatedly broken to halves
 * Space Complexity: O(n)
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] unsortedArray = {4, 3, 5, 1, 6};
        mergeSort(unsortedArray);
        System.out.println(Arrays.toString(unsortedArray));
    }

    public static void mergeSort(int[] unsortedArray) {
        int length = unsortedArray.length;
        int mid = length / 2;
        //base condition to come out of recursion i.e when the arrays are broken down to individual elements
        if (length == 1)
            return;
        int[] leftArray = new int[mid]; //Create left array
        int[] rightArray = new int[length - mid]; // create right array
        //populate with left side of unsorted array
        System.arraycopy(unsortedArray, 0, leftArray, 0, leftArray.length);
        //populate with right side of the unsorted array
        if (rightArray.length >= 0) System.arraycopy(unsortedArray, mid, rightArray, 0, rightArray.length);
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(unsortedArray, leftArray, rightArray);
    }

    private static void merge(int[] unsortedArray, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length) { //keep iterating until one of the condition fails and populate into unsorted array
            if (leftArray[i] <= rightArray[j]) {
                unsortedArray[k] = leftArray[i];
                i++;
            } else {
                unsortedArray[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < leftArray.length) { //this loop meant to add any left over elements in left side of the array to unsorted array
            unsortedArray[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightArray.length) { //this loop meant to add any left over elements in right side of the array to unsorted array
            unsortedArray[k] = rightArray[j];
            j++;
            k++;
        }
    }
}

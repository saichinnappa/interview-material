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
        int[] unsortedArray = {5, 4, 3, 2, 1};
        quickSort(unsortedArray, 0, unsortedArray.length - 1);
        System.out.println(Arrays.toString(unsortedArray));
    }

    private static void quickSort(int[] unsortedArray, int start, int end) {
        if(start < end){
            int partitionIndex = partitionArray(unsortedArray, start, end);
            quickSort(unsortedArray, start, partitionIndex - 1);
            quickSort(unsortedArray, partitionIndex + 1, end);
        }
    }

    private static int partitionArray(int[] unsortedArray, int start, int end) {
        int partitionIndex = start - 1;
        int pivotElement = unsortedArray[end];
        for(int i = start; i <= end ; i++){
            if(unsortedArray[i] <= pivotElement){
                partitionIndex++;
                int temp = unsortedArray[partitionIndex];
                unsortedArray[partitionIndex] = unsortedArray[i];
                unsortedArray[i] = temp;
            }
        }
        return partitionIndex;
    }
}

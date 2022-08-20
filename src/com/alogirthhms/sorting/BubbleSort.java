package com.alogirthhms.sorting;

import java.util.Arrays;

/**
 * BubbleSort
 * 1. Compare two adjacent elements and swap
 * 2. Keep doing step 1 until there is no swap necessary
 * <p>
 * Time Complexity: WC: O(n^2) | BC: O(n)
 * Space Complexity: O(1)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] unsortedArray = {1,4,3,6,8};
        sortArray(unsortedArray);
        System.out.println(Arrays.toString(unsortedArray));
    }

    private static void sortArray(int[] unsortedArray) {
        boolean sorted = false;
        while(!sorted){
            sorted = true;
            for(int i = 0; i < unsortedArray.length - 1; i++){
                if(unsortedArray[i] > unsortedArray[i + 1]){
                    sorted = false;
                    int temp = unsortedArray[i];
                    unsortedArray[i] = unsortedArray[i + 1];
                    unsortedArray[i + 1] = temp;
                }
            }
        }
//        return unsortedArray;
    }
}

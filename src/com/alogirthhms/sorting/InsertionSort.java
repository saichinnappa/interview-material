package com.alogirthhms.sorting;

import java.util.Arrays;

/**
 * INSERTION SORT:
 * Step 1: Move forward from second element in the list and start comparing to immediate left part of the list.
 * Step 2: Repeat step 1 until the element is placed in the right position.
 * <p>
 * Time Complexity: O(n^2) - in case of elements are in reverse order.
 * Space Complexity: O(1) - Since existing data structure is modified without creating new.
 */

public class InsertionSort {

    public static void main(String[] args) {
        int[] unsortedArray = {2, 3, 5, 1, 0};
        int[] sortedArray = sortArray(unsortedArray);
        System.out.println(Arrays.toString(sortedArray));

    }

    private static int[] sortArray(int[] unsortedArray) {
      for(int i = 1; i < unsortedArray.length; i++){
          int j = i - 1;
          while(j > -1 && unsortedArray[j] > unsortedArray[i]){
              int temp = unsortedArray[i];
              unsortedArray[i] = unsortedArray[j];
              unsortedArray[j] = temp;
              j--;
              i--;
          }
      }
      return unsortedArray;
    }
}

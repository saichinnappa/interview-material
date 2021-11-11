package com.alogirthhms.sorting;

import java.util.Arrays;

/**
 * INSERTION SORT:
 * Step1: First element will be used to compare with other elements.
 * Step2: Move forward from second element in the list and start comparing to immediate left part of the list.
 * Step3: Repeat step 2 until the element is placed in the right position.
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
        for (int k = 1; k < unsortedArray.length; k++) { //start from first position of the array till the end
            System.out.println("Value of K is ->> " + k);
            int elementToBeSorted = unsortedArray[k]; //element to be sorted
            int j = k - 1; //decrement k value to start comparing from immediate left to the element to be sorted
            while (j != -1 && elementToBeSorted < unsortedArray[j]) {
                System.out.println("Element to be sorted: " + elementToBeSorted);
                int temp = unsortedArray[j];
                unsortedArray[j] = unsortedArray[k];
                unsortedArray[k] = temp;
                j--;  //to move left decrement j
                k--;
            }
        }
        return unsortedArray;
    }
}

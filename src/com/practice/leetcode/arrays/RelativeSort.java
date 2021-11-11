package com.practice.leetcode.arrays;

/**
 * LC: 1122 Relative Sort Array
 * <p>
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * <p>
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
 * Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 * <p>
 * Example 1:
 * <p>
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 */

public class RelativeSort {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        relativeSortArray(arr1, arr2);
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        //HashMap for counting sort: Stores frequency 'map[i]' for element 'i'
        int[] map = new int[1001];

        //Counting sort on arr1 to fill hashmap
        for (int i : arr1) {
            map[i]++;
        }

        //Starting from index 0 in arr1 -> Fill all the arr2 elements from hashmap into arr1, and update element frequency in hashmap
        int x = 0;
        for (int z : arr2) {
            while (map[z]-- > 0) {
                arr1[x++] = z;
            }
        }

        //Similarly fill all other elements in hashmap and update their frequency
        for (int i = 0; i < map.length; i++) {
            while (map[i]-- > 0) {
                arr1[x++] = i;
            }
        }
        return arr1;
    }
}

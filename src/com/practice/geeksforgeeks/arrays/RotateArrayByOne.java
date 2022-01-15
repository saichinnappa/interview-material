package com.practice.geeksforgeeks.arrays;

import java.util.Arrays;

/**
 * Given an array, rotate the array by one position in clock-wise direction.
 * Example 1:
 * <p>
 * Input:
 * N = 5
 * A[] = {1, 2, 3, 4, 5}
 * Output:
 * 5 1 2 3 4
 */
public class RotateArrayByOne {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        int rotateCount = 2;
        int startIdx = 0;
        while (rotateCount > 0) {
            int temp = input[startIdx];
            rotateCount--;
            System.arraycopy(input, 1, input, 0, input.length - 1);
            input[input.length - 1] = temp;
        }
        System.out.println(Arrays.toString(input));
    }
}

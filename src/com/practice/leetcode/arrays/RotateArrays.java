package com.practice.leetcode.arrays;

import java.util.Arrays;

/**
 * Rotating arrays Left and Right
 */
public class RotateArrays {
    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 5, 6, 7};
        int[] input2 = {1, 2, 3, 4, 5, 6, 7};
        rotateLeft(input1);
        rotateRight(input2);
    }

    private static void rotateLeft(int[] arr) {
        int firstElement = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = firstElement;
        System.out.println(Arrays.toString(arr));
    }

    private static void rotateRight(int[] arr) {
        int lastElement = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = lastElement;
        System.out.println(Arrays.toString(arr));
    }
}

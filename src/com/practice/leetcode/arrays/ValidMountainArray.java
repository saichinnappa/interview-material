package com.practice.leetcode.arrays;

/**
 * TODO
 * LC: 941 - Valid Mountain Array
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 * <p>
 * Recall that A is a mountain array if and only if:
 * <p>
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 */
public class ValidMountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        System.out.println(validMountainArray(arr));
    }

    public static boolean validMountainArray(int[] A) {
        if (A.length < 3)
            return false;
        int maxIndex = -1;
        boolean isMountain = false;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                maxIndex = i + 1;
            } else {
                break;
            }
        }
        while (maxIndex != -1 && maxIndex < A.length - 1) {
            if (A[maxIndex] > A[maxIndex + 1]) {
                maxIndex++;
                isMountain = true;
            } else {
                break;
            }
        }
        return maxIndex == A.length - 1 && isMountain;
    }

}

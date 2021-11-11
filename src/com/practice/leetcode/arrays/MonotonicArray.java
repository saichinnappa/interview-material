package com.practice.leetcode.arrays;

/**
 * LC: 896
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * <p>
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * <p>
 * Return true if and only if the given array A is monotonic.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,2,3]
 * Output: true
 */
public class MonotonicArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -1, 3};
        System.out.println(isMonotonic(arr));
    }

    static boolean isMonotonic(int[] A) {
        if (A.length == 0)
            return false;
        if (A.length == 1)
            return true;
        int incCounter = 0;
        int decCounter = 0;
        boolean inc = false, dec = false;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                incCounter++;
                inc = true;
            } else if (A[i] > A[i + 1]) {
                decCounter++;
                dec = true;
            } else {
                incCounter++;
                decCounter++;
            }
            if (inc && dec) {
                break;
            }
        }
        return incCounter == A.length - 1 || decCounter == A.length - 1;
    }

}

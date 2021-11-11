package com.practice.leetcode.arrays;

/**
 * LC: 852 Peak Index in a mountain array
 * Let's call an array A a mountain if the following properties hold:
 * <p>
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 * <p>
 * Example 1:
 * <p>
 * Input: [0,1,0]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [0,2,1,0]
 * Output: 1
 * Note:
 * <p>
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A is a mountain, as defined above.
 */
public class PeakIndexMountainArray {
    public static void main(String[] args) {
        int[] input = {0, 2, 6, 9, 1, 1, 0};
        System.out.println(peakIndexInMountainArray(input));
    }

    public static int peakIndexInMountainArray(int[] A) {
        if (A.length < 3)
            return Integer.MAX_VALUE;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] < A[i]) {
                return i;
            }
        }
        return Integer.MAX_VALUE;

//        int lo = 0, hi = A.length - 1;
//        while (lo < hi) {
//            int mi = lo + (hi - lo) / 2;
//            if (A[mi] < A[mi + 1])
//                lo = mi + 1;
//            else
//                hi = mi;
//        }
//        return lo;
    }
}

package com.practice.leetcode.arrays;

/**
 * 832. Flipping an Image
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 * <p>
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * <p>
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 */
public class FlippingAnImage {
    public static void main(String[] args) {
        int[][] input = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        flipAndInvertImage(input);
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        int i = 0, j = A[0].length - 1, k = 0;
        int[][] B = A.clone();
        for (int x = 0; x < B.length; x++) {
            B[x] = B[x].clone();
        }
        while (i < A.length) {
            if (j >= 0) {
                A[i][k] = Math.abs(B[i][j] - 1);
                k++;
                j--;
            }
            if (j < 0) {
                i++;
                if (i == A.length)
                    break;
                k = 0;
                j = A[i].length - 1;
            }
        }
        return A;
    }

}

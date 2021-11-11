package com.practice.leetcode.arrays;

import java.util.Arrays;

public class SumZero {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(4)));
    }

    public static int[] sumZero(int n) {
        int[] result = new int[n];
        int count = 0;
        int mid = n / 2;
        if (n == 1) {
            return new int[0];
        } else {
            for (int i = 0; i < result.length; i++) {
                if (i < mid) {
                    result[i] = --count;
                } else if (i > mid) {
                    result[i] = ++count;
                }
                if (i == mid) {
                    count = 1;
                    result[i] = count;
                }
            }
            if (n % 2 != 0)
                result[result.length - 1] = 0;
        }
        return result;
    }


}

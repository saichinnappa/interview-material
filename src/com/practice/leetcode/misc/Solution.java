package com.practice.leetcode.misc;

import java.io.IOException;

class Solution {
    public static void main(String[] args) throws IOException {
        int N = 153;
        int bkp = N;
        int length = (int) Math.log10(N) + 1;
        int maxTens = (int) Math.pow(10, length - 1);
        int[] values = new int[length];
        int finalValue = 0;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                values[i] = N / maxTens;
                N = N % maxTens;
            } else {
                maxTens = (int) Math.pow(10, length - 1 - i);
                values[i] = N / maxTens;
                N = N % maxTens;
            }
        }
        for (int i : values) {
            finalValue += Math.pow(i, length);
        }
        System.out.println(finalValue + "\t" + bkp);
        System.out.println(finalValue == bkp);

    }

}
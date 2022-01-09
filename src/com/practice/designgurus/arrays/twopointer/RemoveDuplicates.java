package com.practice.designgurus.arrays.twopointer;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] input = {2, 3, 3, 3, 6, 9, 9, 9};
//        int[] input = {2, 2, 2, 11};
        int idx = 1;
        for (int j = 1; j < input.length; j++) {
            if (input[j] != input[j - 1]) {
                input[idx] = input[j];
                idx++;
            }

        }
        System.out.println(Arrays.toString(input) + " -> " + idx);
    }
}

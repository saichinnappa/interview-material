package com.practice.leetcode.arrays;

import java.util.Arrays;

public class GroupZeroesAndOnes {
    public static void main(String[] args) {
        int[] input = {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1};
        int start = 0;
        int end = input.length - 1;
        while (start < end) {
            if (input[start] == 1) {
                start++;
            }
            if (input[end] == 0) {
                end++;
            }
            if (input[start] == 0 && input[end] == 1) {
                input[start] = 1;
                input[end] = 0;
                start++;
                end--;
            }
        }
        System.out.println(Arrays.toString(input));
    }
}

package com.practice.geeksforgeeks.arrays;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] input = {99, 1, 3, 5, 2};
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] > input[j]) {
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
            System.out.println(Arrays.toString(input));
        }
    }
}

package com.practice.geeksforgeeks.arrays;

public class MaxSumInConfiguration {
    public static void main(String[] args) {
        int[] input = {8, 3, 1, 2};
        int result = Integer.MIN_VALUE;
        int rotationCount = input.length - 1;
        int localSum = 0;
        while (rotationCount != 0) {
            int temp = input[0];
            localSum = 0 * temp;
            for (int i = 1; i < input.length; i++) {
                localSum += (i * input[i]);
                input[i - 1] = input[i];
            }
            result = Math.max(result, localSum);
            input[input.length - 1] = temp;

            rotationCount--;
        }
        System.out.println("Max Sum is: " + result);
    }
}

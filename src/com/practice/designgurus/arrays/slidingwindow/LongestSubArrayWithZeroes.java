package com.practice.designgurus.arrays.slidingwindow;

public class LongestSubArrayWithZeroes {

    public static void main(String[] args) {
        int ans = helper(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3);
        System.out.println(ans);
    }

    private static int helper(int[] input, int k) {
        int result = 0, zeroCount = 0, startWindow = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == 0)
                zeroCount++;
            while (zeroCount > k) {
                if (input[startWindow] == 0)
                    zeroCount--;
                startWindow++;
            }
            result = Math.max(result, i - startWindow + 1);
        }

        return result;
    }

}

package com.practice.designgurus.arrays.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Sliding window approach
 */
public class AverageSubArray {

    public static void main(String[] args) {
        List<Double> ans = helper(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println(ans);
    }

    private static List<Double> helper(int k, int[] ints) {
        double runningSum = 0;
        int startWindow = 0;
        List<Double> list = new ArrayList<>();

        for (int i = startWindow; i < ints.length; i++) {
            runningSum += ints[i];
            if (i >= k - 1) {
                list.add(runningSum / k);
                runningSum -= ints[startWindow];
                startWindow++;
            }
        }
        return list;
    }
}

package com.practice.leetcode.arrays;

/**
 * 1266. Minimum Time Visiting All Points
 * On a plane there are n points with integer coordinates points[i] = [xi, yi]. Your task is to find the minimum time in seconds to visit all points.
 * <p>
 * You can move according to the next rules:
 * <p>
 * In one second always you can either move vertically, horizontally by one unit or diagonally (it means to move one unit vertically and one unit horizontally in one second).
 * You have to visit the points in the same order as they appear in the array.
 * <p>
 * Input: points = [[1,1],[3,4],[-1,0]]
 * Output: 7
 * Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
 * Time from [1,1] to [3,4] = 3 seconds
 * Time from [3,4] to [-1,0] = 4 seconds
 * Total time = 7 seconds
 */
public class MinimumTimeVisitingPoints {
    public static void main(String[] args) {
        int[][] input = {{3, 2}, {-2, 2}};
        System.out.println(minTimeToVisitAllPoints(input));
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int steps = 0;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = 0; j < points[i].length - 1; j++) {
                steps += Math.max(Math.abs(points[i + 1][j] - points[i][j]), Math.abs(points[i + 1][j + 1] - points[i][j + 1]));
            }
        }
        return steps;


    }
}

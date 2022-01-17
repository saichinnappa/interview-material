package com.practice.geeksforgeeks.arrays;

import java.util.PriorityQueue;

/**
 * Given arrival and departure times of all trains that reach a railway station.
 * Find the minimum number of platforms required for the railway station so that no train is kept waiting.
 * Consider that all the trains arrive on the same day and leave on the same day.
 * Arrival and departure time can never be the same for a train but we can have arrival time of one
 * train equal to departure time of the other. At any given instance of time,
 * same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 6
 * arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
 * dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
 * Output: 3
 * Explanation:
 * Minimum 3 platforms are required to
 * safely arrive and depart all trains
 */
public class MinimumPlatforms {
    public static void main(String[] args) {
        int[] arrival = {900, 1100, 1235};

        //{900, 940, 950, 1100, 1500, 1800};
        int[] departure = {1000, 1200, 1240};
        //{910, 1200, 1120, 1130, 1900, 2000};
        if (arrival.length == 1) System.out.println("Min Platforms: " + 1);
        int totalPlatforms = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arrival.length; i++) {
            if (i == 0) {
                queue.offer(departure[i]);
                totalPlatforms++;
            } else {
                int prevDep = queue.peek();
                if (prevDep < arrival[i])
                    queue.poll();
                else if (prevDep >= arrival[i]) {
                    totalPlatforms++;
                }
                queue.offer(departure[i]);
            }

        }
        System.out.println("Total Platforms: " + totalPlatforms);
    }
}

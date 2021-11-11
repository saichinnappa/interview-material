package com.practice.leetcode.arrays;

/**
 * 1450. Number of Students Doing Homework at a Given Time
 * <p>
 * <p>
 * Given two integer arrays startTime and endTime and given an integer queryTime.
 * <p>
 * The ith student started doing their homework at the time startTime[i] and finished it at time endTime[i].
 * <p>
 * Return the number of students doing their homework at time queryTime.
 * More formally, return the number of students where queryTime lays in the interval [startTime[i], endTime[i]] inclusive.
 * Example 1:
 * <p>
 * Input: startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
 * Output: 1
 * Explanation: We have 3 students where:
 * The first student started doing homework at time 1 and finished at time 3 and wasn't doing anything at time 4.
 * The second student started doing homework at time 2 and finished at time 2 and also wasn't doing anything at time 4.
 * The third student started doing homework at time 3 and finished at time 7 and was the only student doing homework at time 4.
 */
public class StudentsHomework {
    public static void main(String[] args) {
        int[] startTime = {1, 2, 3};
        int[] endTime = {3, 2, 7};
        int queryTime = 4;
        System.out.println(busyStudent(startTime, endTime, queryTime));
    }

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int studentsCount = 0;
        for (int i = 0; i < endTime.length; i++) {
            if (endTime[i] >= queryTime && startTime[i] <= queryTime) {
                studentsCount++;
            }
        }
        return studentsCount;
    }

}

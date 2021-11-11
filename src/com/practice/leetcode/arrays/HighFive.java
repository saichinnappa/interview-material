package com.practice.leetcode.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 1086. High Five
 * Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.
 * <p>
 * Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is calculated using integer division.
 * Example 1:
 * <p>
 * Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * Output: [[1,87],[2,88]]
 * Explanation:
 * The average of the student with id = 1 is 87.
 * The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= items.length <= 1000
 * items[i].length == 2
 * The IDs of the students is between 1 to 1000
 * The score of the students is between 1 to 100
 * For each student, there are at least 5 scores
 * Accepted
 */
public class HighFive {
    public static void main(String[] args) {
        int[][] input = {{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}, {3, 99}};
        highFive(input);
    }

    public static int[][] highFive(int[][] items) {
        int[][] result;
        int studentCount = 0;
        Arrays.sort(items, new Comparator<int[]>() {
            public int compare(int[] student1, int[] student2) {
                if (student1[0] == student2[0]) {
                    return student2[1] - student1[1];
                } else {
                    return student1[0] - student2[0];
                }
            }
        });
        System.out.println(items[items.length - 1][0] + "<<<");
        Map<Integer, Integer> studentRecords = new HashMap<>();
        int idCount = 0;
        int currentId = -1;
        for (int i = 0; i < items.length; i++) {
            currentId = i;
            if (idCount < 6 && currentId == i) {
                idCount++;
                if (studentRecords.get(items[i][0]) == null)
                    studentRecords.put(items[i][0], items[i][1]);
                else
                    studentRecords.put(items[i][0], (studentRecords.get(items[i][0]) + items[i][1]));
            }
        }

        for (Integer i : studentRecords.keySet()) {
            System.out.println(studentRecords.get(1) / 5);
            System.out.println(studentRecords.get(2) / 5);
        }

        return null;
    }
}
